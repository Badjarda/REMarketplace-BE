package business.userrole.service;

import java.util.List;
import java.util.Arrays;
import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.operator.entity.repository.OperatorRepository;
import business.user.entity.repository.UserRepository;
import business.userrole.entity.repository.UserRoleOfferRepository;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRoleService {
  @Inject
  DamlLedgerClientProvider clientProvider;

  @Inject
  UserRepository userRepository;

  @Inject
  Transactions transactionService;

  @Inject
  OperatorRepository operatorRepository;

  @Inject
  UserRoleOfferRepository userRoleOfferRepository;

  public static final String APP_ID = "OperatorId";

  public UserRoleService() {

  }

  private void handleUserRoleOffer(String operator, String user, String action)
      throws IllegalArgumentException, IllegalStateException, Exception {

    String operatorParty = userRepository.findById(operator).getPartyId();
    String userParty = userRepository.findById(user).getPartyId();
    String offerContractId = userRoleOfferRepository.findById(operatorParty+userParty).getContractId();
    List<com.daml.ledger.javaapi.data.Command> command = null;

    daml.marketplace.interface$.role.user.Offer.ContractId userAcceptId = new daml.marketplace.interface$.role.user.Offer.ContractId(
        offerContractId);

    if (action.equals("accept"))
      command = userAcceptId.exerciseAccept().commands();
    else if (action.equals("decline"))
      command = userAcceptId.exerciseDecline().commands();

    transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);

  }

  public String acceptUserRole(String operator, String user) {
    try {
      handleUserRoleOffer(operator, user, "accept");
    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error accepting User role: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error accepting User role : " + e.getMessage() + "\n";
    }

    return "Accepted User Role!\n";
  }

  public String declineUserRole(String operator, String user) {
    try {
      handleUserRoleOffer(operator, user, "decline");

    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error declining User role: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error declining User role: " + e.getMessage() + "\n";
    }
    return "Declined User Role!\n";
  }
}
