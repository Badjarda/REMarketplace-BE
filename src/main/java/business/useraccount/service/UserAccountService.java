package business.useraccount.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daml.ledger.javaapi.data.Unit;

import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.custody.entity.repository.CustodyManagerRepository;
import business.operator.entity.repository.OperatorRepository;
import business.user.entity.repository.UserRepository;
import business.useraccount.entity.repository.CustodyServiceOfferRepository;
import business.useraccount.entity.repository.UserAccountRepository;
import business.useraccount.entity.repository.UserHoldingFungibleRepository;
import business.useraccount.entity.repository.UserHoldingTransferableRepository;
import business.userproperty.entity.repository.ApartmentPropertyRepository;
import daml.da.set.types.Set;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.Quantity;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.daml.finance.interface$.types.common.types.HoldingStandard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserAccountService {
  @Inject
  DamlLedgerClientProvider clientProvider;

  @Inject
  UserRepository userRepository;

  @Inject
  Transactions transactionService;

  @Inject
  OperatorRepository operatorRepository;

  @Inject
  CustodyServiceOfferRepository custodyServiceOfferRepository;

  @Inject
  CustodyManagerRepository custodyManagerRepository;

  @Inject
  UserAccountRepository userAccountRepository;

  @Inject
  ApartmentPropertyRepository apartmentPropertyRepository;

  @Inject
  UserHoldingTransferableRepository userHoldingTransferableRepository;

  @Inject
  UserHoldingFungibleRepository userHoldingFungibleRepository;

  public static final String APP_ID = "OperatorId";

  public UserAccountService() {

  }

  private void handleCustodyServiceOffer(String operator, String user, String action)
      throws IllegalArgumentException, IllegalStateException, Exception {

    String operatorParty = userRepository.findById(operator).getPartyId();
    String userParty = userRepository.findById(user).getPartyId();
    String offerContractId = custodyServiceOfferRepository.findById(operatorParty + userParty)
        .getContractId();
    List<com.daml.ledger.javaapi.data.Command> command = null;

    var serviceAcceptId = new daml.marketplace.interface$.custody.service.Offer.ContractId(
        offerContractId);

    if (action.equals("accept"))
      command = serviceAcceptId.exerciseAccept().commands();
    else if (action.equals("decline"))
      command = serviceAcceptId.exerciseDecline().commands();

    transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty));

  }

  public String acceptCustodyService(String operator, String user) {
    try {
      handleCustodyServiceOffer(operator, user, "accept");
    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error accepting Custody Service: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error accepting Custody Service : " + e.getMessage() + "\n";
    }

    return "Accepted Custody Service!\n";
  }

  public String declineCustodyService(String operator, String user) {
    try {
      handleCustodyServiceOffer(operator, user, "decline");

    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error declining Custody Service: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error declining Custody Service: " + e.getMessage() + "\n";
    }
    return "Declined Custody Service!\n";
  }

  public String requestOpenAccount(String operator, String user, String accountId, String description) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = custodyManagerRepository.findById(operatorParty + userParty)
          .getContractId();
      Id userAccountId = new Id(accountId);
      var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(
          servicId);
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);

      Map<String, Unit> controllersMap = Collections.singletonMap(userParty, Unit.getInstance());
      Set<String> controllersSet = new Set<>(controllersMap);
      var controllers = new daml.daml.finance.interface$.account.account.Controllers(controllersSet, controllersSet);

      command = serviceId
          .exerciseRequestOpenAccount(userAccountId, description, controllers, observersMap)
          .commands();
      transactionService.submitTransaction(command, Arrays.asList(userParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Open Account : " + e.getMessage();
    } catch (Exception e) {
      return "Error request Open Account : " + e.getMessage();
    }
    return "Success Open Account Request\n";
  }

  public String requestCloseAccount(String operator, String user) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = custodyManagerRepository.findById(operatorParty + userParty)
          .getContractId();
      var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(
          servicId);
      
      var accountId = userAccountRepository.findById(operatorParty + userParty).getAccountId();
      
      Id userAccountId = new Id(accountId);

      var accountKey = new daml.daml.finance.interface$.types.common.types.AccountKey(operatorParty, userParty, userAccountId);
      command = serviceId
          .exerciseRequestCloseAccount(accountKey)
          .commands();
      transactionService.submitTransaction(command, Arrays.asList(userParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Close Account : " + e.getMessage();
    } catch (Exception e) {
      return "Error request Close Account : " + e.getMessage();
    }
    return "Success Close Account Request\n";
  }

  @SuppressWarnings("unchecked")
  public String requestDepositPropertyInstrument(String operator, String user, String propertyId){
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);
      
      Id userPropertyId = new Id(propertyId);
      String version = "0";
      var propertyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, userPropertyId, version, HoldingStandard.TRANSFERABLE);
      @SuppressWarnings("rawtypes")
      Quantity quantity = new daml.daml.finance.interface$.types.common.types.Quantity(propertyKey, 1.0);

      String accountIdString = userAccountRepository.findById(operatorParty + userParty).getAccountId();
      AccountKey accountKey = new AccountKey(operatorParty, userParty, new Id(accountIdString));

      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = custodyManagerRepository.findById(operatorParty + userParty)
          .getContractId();
      
      var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(
          servicId);

      command = serviceId
          .exerciseRequestDeposit(quantity, accountKey)
          .commands();
      transactionService.submitTransaction(command, Arrays.asList(userParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Deposit Property Instrument : " + e.getMessage();
    } catch (Exception e) {
      return "Error request Deposit Property Instrument : " + e.getMessage();
    }
    return "Success Request Deposit Property Instrument\n";
  }

  @SuppressWarnings("unchecked")
  public String requestDepositCurrencyInstrument(String operator, String user, String tokenStringId, BigDecimal amount){
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);
      
      Id tokenId = new Id(tokenStringId);
      String version = "0";
      var currencyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, tokenId, version, HoldingStandard.TRANSFERABLEFUNGIBLE);
      @SuppressWarnings("rawtypes")
      Quantity quantity = new daml.daml.finance.interface$.types.common.types.Quantity(currencyKey, amount);

      String accountIdString = userAccountRepository.findById(operatorParty + userParty).getAccountId();
      AccountKey accountKey = new AccountKey(operatorParty, userParty, new Id(accountIdString));

      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = custodyManagerRepository.findById(operatorParty + userParty)
          .getContractId();
      
      var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(
          servicId);

      command = serviceId
          .exerciseRequestDeposit(quantity, accountKey)
          .commands();
      transactionService.submitTransaction(command, Arrays.asList(userParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Deposit Currency Instrument : " + e.getMessage();
    } catch (Exception e) {
      return "Error request Deposit Currency Instrument : " + e.getMessage();
    }
    return "Success Request Deposit Currency Instrument\n";
  }

  public String requestWithdrawTransferable(String operator, String user, String holdingCid){
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);

      String holdingCId = userHoldingTransferableRepository.findById(holdingCid).getContractId();
      var holdingContractId = new daml.daml.finance.interface$.holding.holding.Holding.ContractId(holdingCId);

      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = custodyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(servicId);

      command = serviceId.exerciseRequestWithdraw(holdingContractId).commands();
      transactionService.submitTransaction(command, Arrays.asList(userParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Withdraw Property Instrument : " + e.getMessage();
    } catch (Exception e) {
      return "Error request Withdraw Property Instrument : " + e.getMessage();
    }
    return "Success Request Withdraw Property Instrument\n";
  }

  public String requestWithdrawFungible(String operator, String user, String holdingCid){
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);

      String holdingCId = userHoldingFungibleRepository.findById(holdingCid).getContractId();
      var holdingContractId = new daml.daml.finance.interface$.holding.holding.Holding.ContractId(holdingCId);

      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = custodyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(servicId);

      command = serviceId.exerciseRequestWithdraw(holdingContractId).commands();
      transactionService.submitTransaction(command, Arrays.asList(userParty));
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Withdraw Currency Instrument : " + e.getMessage();
    } catch (Exception e) {
      return "Error request Withdraw Currency Instrument : " + e.getMessage();
    }
    return "Success Request Withdraw Currency Instrument\n";
  }

}
