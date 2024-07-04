package business.user.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.daml.ledger.javaapi.data.ListUsersResponse;
import com.daml.ledger.javaapi.data.User;
import com.daml.ledger.rxjava.DamlLedgerClient;

import business.DamlLedgerClientProvider;
import business.party.entity.repository.PartyRepository;
import business.user.entity.model.LedgerUser;
import business.user.entity.repository.UserRepository;

@ApplicationScoped
public class UserService {
    @Inject
    DamlLedgerClientProvider clientProvider;

    @Inject
    PartyRepository partyRepository;

    @Inject
    UserRepository userRepository;

    private DamlLedgerClient client;

    public UserService() {
    }

    public String createUser(String userName, String partyName) {
        client = clientProvider.getClient();
        var userManagementClient = client.getUserManagementClient();

        try {
            String partyId = partyRepository.findById(partyName).getPartyId();
            userManagementClient.createUser(new com.daml.ledger.javaapi.data.CreateUserRequest(userName, partyId))
                    .blockingGet();
            userRepository.persist(new LedgerUser(userName, partyId));

        } catch (IllegalArgumentException | IllegalStateException e) {
            // Handle input validation or contract existence check errors
            return "Error creating User: " + e.getMessage() + "\n";
        } catch (Exception e) {
            // Handle other exceptions
            return "Error Creating User : " + e.getMessage() + "\n";
        }

        return "User " + userName + " Successfully created!\n";

    }

    public String deleteUser(String userName) {
        client = clientProvider.getClient();
        var userManagementClient = client.getUserManagementClient();

        try {
            if (userRepository.findById(userName) == null)
                throw new IllegalArgumentException();
            userManagementClient.deleteUser(new com.daml.ledger.javaapi.data.DeleteUserRequest(userName)).blockingGet();

        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Deleting User: " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Deleting User : " + e.getMessage() + "\n";
        }

        userRepository.deleteById(userName);
        return "User " + userName + " Successfully deleted!\n";

    }

    public void storeAllUserFromLedger() {
        client = clientProvider.getClient();
        ListUsersResponse response = client.getUserManagementClient().listUsers().blockingGet();
        for (User user : response.getUsers()) {
            String party = user.getPrimaryParty().get();
            userRepository.persist(new LedgerUser(user.getId(), party));
        }
    }
}
