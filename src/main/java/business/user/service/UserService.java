package business.user.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.daml.ledger.javaapi.data.ListUsersResponse;
import com.daml.ledger.javaapi.data.User;
import com.daml.ledger.rxjava.DamlLedgerClient;

import business.DamlLedgerClientProvider;
import business.custody.service.AccountManagerService;
import business.issuer.service.IssuanceService;
import business.operator.service.OperatorService;
import business.party.entity.repository.PartyRepository;
import business.rolemanager.service.RoleManagerService;
import business.user.entity.model.LedgerUser;
import business.user.entity.repository.UserRepository;
import business.useraccount.service.UserAccountService;
import business.userprofile.entity.repository.UserProfileRepository;
import business.userprofile.service.UserProfileService;
import business.userproperty.service.UserPropertyService;
import business.userrole.service.UserRoleService;
import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;

@ApplicationScoped
public class UserService {
    @Inject
    DamlLedgerClientProvider clientProvider;

    @Inject
    PartyRepository partyRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    RoleManagerService roleManagerService;

    @Inject
    UserService userService;

    @Inject
    UserRoleService userRoleService;

    @Inject
    OperatorService operatorService;

    @Inject
    AccountManagerService accountManagerService;

    @Inject
    UserProfileService userProfileService;

    @Inject
    UserAccountService userAccountService;

    @Inject
    UserPropertyService userPropertyService;

    @Inject
    IssuanceService issuanceService;

    @Inject
    UserProfileRepository userProfileRepository;

    private DamlLedgerClient client;

    public UserService() {
    }

    public String createUser(String userName, String partyName, String profileId,
      String username, String firstName, String lastName, String fullName, String password, LocalDate birthday,
      Optional<Gender> gender, Nationality nationality, String contactMail, Optional<Long> cellphoneNumber,
      Long idNumber, Long taxId, Long socialSecurityId, List<String> photoReferences) {
        client = clientProvider.getClient();
        var userManagementClient = client.getUserManagementClient();

        try {
            String partyId = partyRepository.findById(partyName).getPartyId();
            userManagementClient.createUser(new com.daml.ledger.javaapi.data.CreateUserRequest(userName, partyId))
                    .blockingGet();
            userRepository.persist(new LedgerUser(userName, partyId));  

            operatorService.offerUserRole(OperatorService.operatorId, userName, "RegisteredUserRole");
            userRoleService.acceptUserRole(OperatorService.operatorId, userName);

            accountManagerService.createCustodyService(OperatorService.operatorId, userName, OperatorService.publicId, "TransferableUser");

            operatorService.offerUserProfileService(OperatorService.operatorId, userName);
            userProfileService.acceptProfileService(OperatorService.operatorId, userName);

            operatorService.offerCustodianService(OperatorService.operatorId, userName);
            userAccountService.acceptCustodyService(OperatorService.operatorId, userName);

            userAccountService.requestOpenAccount(OperatorService.operatorId, userName, "Account"+userName, "My Daml.Finance Account");
            operatorService.acceptRequestOpenAccount(OperatorService.operatorId, userName);

            operatorService.offerPropertyManagerService(OperatorService.operatorId, userName);
            userPropertyService.acceptPropertyService(userName);

            operatorService.offerIssuanceService(OperatorService.operatorId, userName);
            issuanceService.acceptIssuanceService(OperatorService.operatorId, userName);

            userProfileService.requestCreateUserProfile(userName, OperatorService.publicId, profileId, username, firstName, lastName, 
            fullName, password, birthday, gender, nationality, contactMail, cellphoneNumber, idNumber, taxId, socialSecurityId, photoReferences);
            operatorService.acceptRequestCreateProfile(OperatorService.operatorId, userName);

        } catch (IllegalArgumentException | IllegalStateException e) {
            // Handle input validation or contract existence check errors
            return "Error creating User: " + e.getMessage() + "\n";
        } catch (Exception e) {
            // Handle other exceptions
            return "Error Creating User : " + e.getMessage() + "\n";
        }
        return "User " + userName + " Successfully created!\n";
    }

    public String createOperator(String userName, String partyName) {
        client = clientProvider.getClient();
        var userManagementClient = client.getUserManagementClient();

        try {
            String partyId = partyRepository.findById(partyName).getPartyId();
            userManagementClient.createUser(new com.daml.ledger.javaapi.data.CreateUserRequest(userName, partyId))
                    .blockingGet();
            userRepository.persist(new LedgerUser(userName, partyId));
            roleManagerService.createUserFactory(userName);
        } catch (IllegalArgumentException | IllegalStateException e) {
            // Handle input validation or contract existence check errors
            return "Error creating Operator: " + e.getMessage() + "\n";
        } catch (Exception e) {
            // Handle other exceptions
            return "Error Creating Operator : " + e.getMessage() + "\n";
        }
        return "Operator " + userName + " Successfully created!\n";
    }

    public String createPublic(String userName, String partyName) {
        client = clientProvider.getClient();
        var userManagementClient = client.getUserManagementClient();

        try {
            String partyId = partyRepository.findById(partyName).getPartyId();
            userManagementClient.createUser(new com.daml.ledger.javaapi.data.CreateUserRequest(userName, partyId))
                    .blockingGet();
            userRepository.persist(new LedgerUser(userName, partyId));
        } catch (IllegalArgumentException | IllegalStateException e) {
            // Handle input validation or contract existence check errors
            return "Error creating Public: " + e.getMessage() + "\n";
        } catch (Exception e) {
            // Handle other exceptions
            return "Error Creating Public : " + e.getMessage() + "\n";
        }
        return "Public " + userName + " Successfully created!\n";
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
