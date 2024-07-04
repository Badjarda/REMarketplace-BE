package business.issuer.service;

import java.util.List;
import java.util.Map;

import com.daml.ledger.javaapi.data.Unit;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.issuance.entity.repository.IssuanceManagerRepository;
import business.issuer.entity.repository.IssuanceServiceOfferRepository;
import business.operator.entity.repository.OperatorRepository;
import business.user.entity.repository.UserRepository;
import business.useraccount.entity.repository.UserAccountRepository;
import business.useraccount.entity.repository.UserHoldingFungibleRepository;
import business.useraccount.entity.repository.UserHoldingTransferableRepository;
import daml.da.set.types.Set;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.daml.finance.interface$.types.common.types.HoldingStandard;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.Quantity;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IssuanceService {
  @Inject
  DamlLedgerClientProvider clientProvider;

  @Inject
  UserRepository userRepository;

  @Inject
  Transactions transactionService;

  @Inject
  OperatorRepository operatorRepository;

  @Inject
  IssuanceServiceOfferRepository issuanceServiceOfferRepository;

  @Inject
  IssuanceManagerRepository issuanceManagerRepository;

  @Inject
  UserHoldingFungibleRepository userHoldingFungibleRepository;

  @Inject
  UserHoldingTransferableRepository userHoldingTransferableRepository;

  @Inject
  UserAccountRepository userAccountRepository;

  public static final String APP_ID = "OperatorId";

  public IssuanceService() {

  }

  private void handleIssuanceServiceOffer(String operator, String user, String action)
      throws IllegalArgumentException, IllegalStateException, Exception {

    String operatorParty = userRepository.findById(operator).getPartyId();
    String userParty = userRepository.findById(user).getPartyId();
    String offerContractId = issuanceServiceOfferRepository.findById(operatorParty + userParty)
        .getContractId();
    List<com.daml.ledger.javaapi.data.Command> command = null;

    var serviceAcceptId = new daml.marketplace.interface$.issuance.service.Offer.ContractId(
        offerContractId);

    if (action.equals("accept"))
      command = serviceAcceptId.exerciseAccept().commands();
    else if (action.equals("decline"))
      command = serviceAcceptId.exerciseDecline().commands();

    transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty));
  }

  public String acceptIssuanceService(String operator, String user) {
    try {
      handleIssuanceServiceOffer(operator, user, "accept");
    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error accepting Issuance Service: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error accepting Issuance Service : " + e.getMessage() + "\n";
    }

    return "Accepted Issuance Service!\n";
  }

  public String declineIssuanceService(String operator, String user) {
    try {
      handleIssuanceServiceOffer(operator, user, "decline");

    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error declining Issuance Service: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error declining Issuance Service: " + e.getMessage() + "\n";
    }
    return "Declined Issuance Service!\n";
  }

  @SuppressWarnings("unchecked")
  public String requestIssueTransferable(String operator, String user, String issuanceIdString, String propertyIdString) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);

      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = issuanceManagerRepository.findById(operatorParty + userParty).getContractId();
      var serviceId = new daml.marketplace.interface$.issuance.service.Service.ContractId(servicId);

      Id issuanceId = new Id(issuanceIdString);
      Id propertyId = new Id(propertyIdString);
      String version = "0";
      var propertyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, propertyId, version, HoldingStandard.TRANSFERABLE);
      @SuppressWarnings("rawtypes")
      Quantity quantity = new daml.daml.finance.interface$.types.common.types.Quantity(propertyKey, 1.0);

      String accountIdString = userAccountRepository.findById(operatorParty + userParty).getAccountId();
      AccountKey accountKey = new AccountKey(operatorParty, userParty, new Id(accountIdString));

      command = serviceId
          .exerciseRequestIssue(issuanceId, servicId, quantity, accountKey).commands();
      transactionService.submitTransaction(command, Arrays.asList(userParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Request Issue Transferable : " + e.getMessage();
    } catch (Exception e) {
      return "Error Request Issue Transferable : " + e.getMessage();
    }
    return "Success Request Issue Transferable\n";
  }

  @SuppressWarnings("unchecked")
  public String requestIssueFungible(String operator, String user, String issuanceIdString, String tokenStringId, BigDecimal amount) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);

      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = issuanceManagerRepository.findById(operatorParty + userParty).getContractId();
      var serviceId = new daml.marketplace.interface$.issuance.service.Service.ContractId(servicId);

      Id issuanceId = new Id(issuanceIdString);
      Id tokenId = new Id(tokenStringId);
      String version = "0";
      var currencyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, tokenId, version, HoldingStandard.TRANSFERABLEFUNGIBLE);
      @SuppressWarnings("rawtypes")
      Quantity quantity = new daml.daml.finance.interface$.types.common.types.Quantity(currencyKey, amount);

      String accountIdString = userAccountRepository.findById(operatorParty + userParty).getAccountId();
      AccountKey accountKey = new AccountKey(operatorParty, userParty, new Id(accountIdString));

      command = serviceId
          .exerciseRequestIssue(issuanceId, servicId, quantity, accountKey).commands();
      transactionService.submitTransaction(command, Arrays.asList(userParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Request Issue Fungible : " + e.getMessage();
    } catch (Exception e) {
      return "Error Request Issue Fungible : " + e.getMessage();
    }
    return "Success Request Issue Fungible\n";
  }

  public String issueTransferCurrency(String operator, String buyer, String seller){
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String buyerParty = userRepository.findById(buyer).getPartyId();
      String sellerParty = userRepository.findById(seller).getPartyId();
      
      Map<String, Unit> singletonMapBuyer = Collections.singletonMap(buyerParty, Unit.getInstance());
      Map<String, Unit> singletonMapSeller = Collections.singletonMap(sellerParty, Unit.getInstance());
      Map<String, Unit> combinedMap = new HashMap<>(singletonMapBuyer);
      combinedMap.putAll(singletonMapSeller);
      Set<String> observers = new Set<>(combinedMap);

      List<com.daml.ledger.javaapi.data.Command> command = null;

      String holdingCId = userHoldingFungibleRepository.findById(operatorParty + buyerParty).getContractId();
      var holdingFungibleContractId = new daml.daml.finance.interface$.holding.transferable.Transferable.ContractId(holdingCId);

      String accountIdString = userAccountRepository.findById(operatorParty + sellerParty).getAccountId();
      AccountKey accountKey = new AccountKey(operatorParty, sellerParty, new Id(accountIdString));

      command = holdingFungibleContractId.exerciseTransfer(observers, accountKey).commands();
      transactionService.submitTransaction(command, Arrays.asList(buyerParty, sellerParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Transfer Currency : " + e.getMessage();
    } catch (Exception e) {
      return "Error Transfer Currency : " + e.getMessage();
    }
    return "Success Transfer Currency\n";
  }

  public String issueTransferProperty(String operator, String buyer, String seller){
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String buyerParty = userRepository.findById(buyer).getPartyId();
      String sellerParty = userRepository.findById(seller).getPartyId();
      
      Map<String, Unit> singletonMapBuyer = Collections.singletonMap(buyerParty, Unit.getInstance());
      Map<String, Unit> singletonMapSeller = Collections.singletonMap(sellerParty, Unit.getInstance());
      Map<String, Unit> combinedMap = new HashMap<>(singletonMapBuyer);
      combinedMap.putAll(singletonMapSeller);
      Set<String> observers = new Set<>(combinedMap);

      List<com.daml.ledger.javaapi.data.Command> command = null;

      String holdingCId = userHoldingTransferableRepository.findById(operatorParty + buyerParty).getContractId();
      var holdingFungibleContractId = new daml.daml.finance.interface$.holding.transferable.Transferable.ContractId(holdingCId);

      String accountIdString = userAccountRepository.findById(operatorParty + buyer).getAccountId();
      AccountKey accountKey = new AccountKey(operatorParty, buyerParty, new Id(accountIdString));

      command = holdingFungibleContractId.exerciseTransfer(observers, accountKey).commands();
      transactionService.submitTransaction(command, Arrays.asList(buyerParty, sellerParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Transfer Property : " + e.getMessage();
    } catch (Exception e) {
      return "Error Transfer Property : " + e.getMessage();
    }
    return "Success Transfer Property\n";
  }

}
