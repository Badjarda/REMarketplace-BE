package business.issuer.service;

import java.util.List;
import java.util.Map;

import com.daml.ledger.api.v1.TransactionOuterClass.Transaction;
import com.daml.ledger.javaapi.data.Unit;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.custody.entity.repository.CustodyManagerRepository;
import business.issuance.entity.repository.IssuanceManagerRepository;
import business.issuer.entity.repository.IssuanceServiceOfferRepository;
import business.operator.entity.repository.OperatorRepository;
import business.user.entity.repository.UserRepository;
import business.useraccount.entity.repository.UserAccountRepository;
import business.useraccount.entity.repository.UserHoldingFungibleRepository;
import business.useraccount.entity.repository.UserHoldingTransferableRepository;
import business.userproperty.entity.repository.ApartmentPropertyRepository;
import business.userproperty.entity.repository.GaragePropertyRepository;
import business.userproperty.entity.repository.LandPropertyRepository;
import business.userproperty.entity.repository.ResidencePropertyRepository;
import business.userproperty.entity.repository.WarehousePropertyRepository;
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

  @Inject
  ApartmentPropertyRepository apartmentPropertyRepository;

  @Inject
  GaragePropertyRepository garagePropertyRepository;

  @Inject
  LandPropertyRepository landPropertyRepository;

  @Inject
  ResidencePropertyRepository residencePropertyRepository;

  @Inject
  WarehousePropertyRepository warehousePropertyRepository;

  @Inject
  CustodyManagerRepository custodyManagerRepository;

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

    Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);
    transactionService.handleTransaction(transaction);
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
  public String requestIssueTransferable(String operator, String user, String issuanceIdString, String postalCode, String propertyType) {
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

      Id issuanceId = new Id(issuanceIdString+postalCode);
      String propertyIdString = "";
      if(propertyType.equals("APARTMENT")){
        propertyIdString = apartmentPropertyRepository.findById(operatorParty + postalCode).getPropertyId();
      } else if(propertyType.equals("GARAGE")){
        propertyIdString = garagePropertyRepository.findById(operatorParty + postalCode).getPropertyId();
      } else if(propertyType.equals("LAND")){
        propertyIdString = landPropertyRepository.findById(operatorParty + postalCode).getPropertyId();
      } else if(propertyType.equals("RESIDENCE")){
        propertyIdString = residencePropertyRepository.findById(operatorParty + postalCode).getPropertyId();
      } else if(propertyType.equals("WAREHOUSE")){
        propertyIdString = warehousePropertyRepository.findById(operatorParty + postalCode).getPropertyId();
      } else{
        System.out.println("PROPERTY TYPE NOT COMPATIBLE");
      }
      Id propertyId = new Id(propertyIdString);
      String version = "0";
      var propertyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, propertyId, version, HoldingStandard.TRANSFERABLE);
      @SuppressWarnings("rawtypes")
      Quantity quantity = new daml.daml.finance.interface$.types.common.types.Quantity(propertyKey, new BigDecimal(1.0));

      String accountIdString = userAccountRepository.findById(operatorParty + userParty).getAccountId();
      AccountKey accountKey = new AccountKey(operatorParty, userParty, new Id(accountIdString));

      command = serviceId.exerciseRequestIssue(issuanceId, servicId, quantity, accountKey).commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty,userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Request Issue Transferable : " + e.getMessage();
    } catch (Exception e) {
      return "Error Request Issue Transferable : " + e.getMessage();
    }
    return "Success Request Issue Transferable\n";
  }

  public String requestSwap(String operator, String buyer, String seller, String postalCode){
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String buyerParty = userRepository.findById(buyer).getPartyId();
      String sellerParty = userRepository.findById(seller).getPartyId();

      List<com.daml.ledger.javaapi.data.Command> command = null;

      String servicId = custodyManagerRepository.findById(operatorParty + buyerParty).getContractId();
      var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(servicId);

      String holdingCId = userHoldingFungibleRepository.findById(operatorParty + buyerParty).getContractId();
      BigDecimal holdingAmount = userHoldingFungibleRepository.findById(operatorParty + buyerParty).getAmount();
      var holdingFungibleContractId = new daml.daml.finance.interface$.holding.transferable.Transferable.ContractId(holdingCId);

      String accountIdBuyer = userAccountRepository.findById(operatorParty + buyerParty).getAccountId();
      AccountKey buyerAccountKey = new AccountKey(operatorParty, buyerParty, new Id(accountIdBuyer));

      String accountIdSeller = userAccountRepository.findById(operatorParty + sellerParty).getAccountId();
      AccountKey sellerAccountKey = new AccountKey(operatorParty, sellerParty, new Id(accountIdSeller));

      String transferableHoldingCId = userHoldingTransferableRepository.findById(operatorParty + sellerParty + "PropertyId"+postalCode).getContractId();
      var transferableHoldingCid = new daml.daml.finance.interface$.holding.transferable.Transferable.ContractId(transferableHoldingCId);

      command = serviceId.exerciseRequestSwap(sellerParty, sellerAccountKey, buyerAccountKey, holdingFungibleContractId, holdingAmount, transferableHoldingCid).commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty, sellerParty, buyerParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Transfer Property : " + e.getMessage();
    } catch (Exception e) {
      return "Error Transfer Property : " + e.getMessage();
    }
    return "Success Swap Request!\n";
  }

  public String requestDeIssueTransferable(String operator, String user, String issuanceIdString, String postalCode) {
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

      Id issuanceId = new Id(issuanceIdString+postalCode);

      String holdingCId = userHoldingTransferableRepository.findById(operatorParty + userParty + "PropertyId"+postalCode).getContractId();
      var holdingCid = new daml.daml.finance.interface$.holding.holding.Holding.ContractId(holdingCId);

      command = serviceId.exerciseRequestDeIssue(issuanceId, holdingCid).commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty,userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Request DeIssue Transferable : " + e.getMessage();
    } catch (Exception e) {
      return "Error Request DeIssue Transferable : " + e.getMessage();
    }
    return "Success Request DeIssue Transferable\n";
  }

}