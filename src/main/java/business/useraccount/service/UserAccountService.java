package business.useraccount.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.daml.ledger.api.v1.TransactionOuterClass.Transaction;
import com.daml.ledger.javaapi.data.Unit;

import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.custody.entity.repository.CustodyManagerRepository;
import business.operator.entity.repository.OperatorRepository;
import business.user.entity.repository.UserRepository;
import business.useraccount.dto.SwapRequestGETDTO;
import business.useraccount.entity.model.UserSwapRequest;
import business.useraccount.entity.repository.CustodyServiceOfferRepository;
import business.useraccount.entity.repository.UserAccountRepository;
import business.useraccount.entity.repository.UserHoldingFungibleRepository;
import business.useraccount.entity.repository.UserHoldingTransferableRepository;
import business.useraccount.entity.repository.UserSwapRequestRepository;
import business.userproperty.dto.ApartmentPropertyGETDTO;
import business.userproperty.dto.GaragePropertyGETDTO;
import business.userproperty.dto.LandPropertyGETDTO;
import business.userproperty.dto.ResidencePropertyGETDTO;
import business.userproperty.dto.WarehousePropertyGETDTO;
import business.userproperty.entity.model.ApartmentProperty;
import business.userproperty.entity.model.GarageProperty;
import business.userproperty.entity.model.LandProperty;
import business.userproperty.entity.model.ResidenceProperty;
import business.userproperty.entity.model.WarehouseProperty;
import business.userproperty.entity.repository.ApartmentPropertyRepository;
import business.userproperty.entity.repository.GaragePropertyRepository;
import business.userproperty.entity.repository.LandPropertyRepository;
import business.userproperty.entity.repository.ResidencePropertyRepository;
import business.userproperty.entity.repository.WarehousePropertyRepository;
import daml.da.set.types.Set;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.Quantity;
import daml.marketplace.interface$.common.types.PropertyKey;
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

  @Inject
  UserSwapRequestRepository userSwapRequestRepository;

  @Inject
  GaragePropertyRepository garagePropertyRepository;

  @Inject
  LandPropertyRepository landPropertyRepository;

  @Inject
  ResidencePropertyRepository residencePropertyRepository;

  @Inject
  WarehousePropertyRepository warehousePropertyRepository;

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

    Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);
    transactionService.handleTransaction(transaction);
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
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(userParty, operatorParty), null);
      transactionService.handleTransaction(transaction);
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
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(userParty, operatorParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Close Account : " + e.getMessage();
    } catch (Exception e) {
      return "Error request Close Account : " + e.getMessage();
    }
    return "Success Close Account Request\n";
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
      String servicId = custodyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(servicId);

      command = serviceId.exerciseRequestDeposit(quantity, accountKey).commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(userParty, operatorParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Deposit Currency Instrument : " + e.getMessage();
    } catch (Exception e) {
      return "Error request Deposit Currency Instrument : " + e.getMessage();
    }
    return "Success Request Deposit Currency Instrument\n";
  }

  public String requestWithdrawFungible(String operator, String user){
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();

      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);

      String holdingCId = userHoldingFungibleRepository.findById(operatorParty+userParty).getContractId();
      var holdingContractId = new daml.daml.finance.interface$.holding.holding.Holding.ContractId(holdingCId);

      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = custodyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(servicId);

      command = serviceId.exerciseRequestWithdraw(holdingContractId).commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty,userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Withdraw Currency Instrument : " + e.getMessage();
    } catch (Exception e) {
      return "Error request Withdraw Currency Instrument : " + e.getMessage();
    }
    return "Success Request Withdraw Currency Instrument\n";
  }

  public String acceptSwapRequest(String operator, String buyer, String seller, String publicString, String postalCode, String propertyType) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String buyerParty = userRepository.findById(buyer).getPartyId();
            String sellerParty = userRepository.findById(seller).getPartyId();

            String servicId = custodyManagerRepository.findById(operatorParty + sellerParty).getContractId();
            var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(servicId);

            String transferableHoldingCId = userHoldingTransferableRepository.findById(operatorParty + sellerParty + "PropertyId"+postalCode).getContractId();
            
            String swapRequestCId = userSwapRequestRepository.findById(operatorParty + sellerParty + buyerParty + transferableHoldingCId).getContractId();
            var swapRequestCid = new daml.marketplace.interface$.custody.choices.swaprequest.SwapRequest.ContractId(swapRequestCId);

            String accountIdSeller = userAccountRepository.findById(operatorParty + sellerParty).getAccountId();
            AccountKey sellerAccountKey = new AccountKey(operatorParty, sellerParty, new Id(accountIdSeller));

            List<com.daml.ledger.javaapi.data.Command> command = null;

            if(propertyType.equals("APARTMENT")){
                String apartmentIdString = apartmentPropertyRepository.findById(operatorParty + postalCode).getPropertyId();
                PropertyKey key = new PropertyKey(operatorParty, sellerParty, new Id(apartmentIdString));
                command = serviceId.exerciseAtomicSwapApartment(sellerParty, buyerParty, sellerAccountKey, swapRequestCid, key).commands();
            } else if(propertyType.equals("GARAGE")){
                String garageIdString = garagePropertyRepository.findById(operatorParty + postalCode).getPropertyId();
                PropertyKey key = new PropertyKey(operatorParty, sellerParty, new Id(garageIdString));
                command = serviceId.exerciseAtomicSwapGarage(sellerParty, buyerParty, sellerAccountKey, swapRequestCid, key).commands();
            } else if(propertyType.equals("LAND")){
                String landIdString = landPropertyRepository.findById(operatorParty + postalCode).getPropertyId();
                PropertyKey key = new PropertyKey(operatorParty, sellerParty, new Id(landIdString));
                command = serviceId.exerciseAtomicSwapLand(sellerParty, buyerParty, sellerAccountKey, swapRequestCid, key).commands();
            } else if(propertyType.equals("RESIDENCE")){
                String residenceIdString = residencePropertyRepository.findById(operatorParty + postalCode).getPropertyId();
                PropertyKey key = new PropertyKey(operatorParty, sellerParty, new Id(residenceIdString));
                command = serviceId.exerciseAtomicSwapResidence(sellerParty, buyerParty, sellerAccountKey, swapRequestCid, key).commands();
            } else if(propertyType.equals("WAREHOUSE")){
                String warehouseIdString = warehousePropertyRepository.findById(operatorParty + postalCode).getPropertyId();
                PropertyKey key = new PropertyKey(operatorParty, sellerParty, new Id(warehouseIdString));
                command = serviceId.exerciseAtomicSwapWarehouse(sellerParty, buyerParty, sellerAccountKey, swapRequestCid, key).commands();
            } else{
            System.out.println("PROPERTY TYPE NOT COMPATIBLE");
            }
            Transaction transaction = transactionService.submitTransaction(
                command, 
                Arrays.asList(operatorParty, buyerParty, sellerParty), 
                Arrays.asList(operatorParty, buyerParty, sellerParty)
            );
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Atomic Swap : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Atomic Swap : " + e.getMessage() + "\n";
        }
        return "Successfully Atomic Swapped!\n";
    }

    public List<SwapRequestGETDTO> getAllUserSwapRequests(String operatorId, String sellerId){
      String operatorParty = userRepository.findById(operatorId).getPartyId();
      String sellerParty = userRepository.findById(sellerId).getPartyId();
      List<UserSwapRequest> swapRequests = userSwapRequestRepository.findByPartyIdStartingWith(operatorParty + sellerParty);

      return swapRequests.stream()
              .map(request -> mapToSwapRequestGETDTO(operatorId, request))
              .collect(Collectors.toList());
    }

    public SwapRequestGETDTO mapToSwapRequestGETDTO(String operatorId, UserSwapRequest entity) {
      String operatorParty = userRepository.findById(operatorId).getPartyId();
      ApartmentPropertyGETDTO apartmentDTO = null;
      LandPropertyGETDTO landDTO = null;
      ResidencePropertyGETDTO residenceDTO = null;
      GaragePropertyGETDTO garageDTO = null;
      WarehousePropertyGETDTO warehouseDTO = null;

      switch (entity.getPropertyType()) {
          case "APARTMENT":
              ApartmentProperty apartment = apartmentPropertyRepository.findById(operatorParty + entity.getPostalCode());
                  apartmentDTO = mapToApartmentPropertyDTO(apartment);
              break;
          case "LAND":
              LandProperty land = landPropertyRepository.findById(operatorParty + entity.getPostalCode());
                  landDTO = mapToLandPropertyDTO(land);
              break;
          case "RESIDENCE":
              ResidenceProperty residence = residencePropertyRepository.findById(operatorParty + entity.getPostalCode());
                  residenceDTO = mapToResidencePropertyDTO(residence);
              break;
          case "GARAGE":
              GarageProperty garage = garagePropertyRepository.findById(operatorParty + entity.getPostalCode());
                  garageDTO = mapToGaragePropertyDTO(garage);
              break;
          case "WAREHOUSE":
              WarehouseProperty warehouse = warehousePropertyRepository.findById(operatorParty + entity.getPostalCode());
                  warehouseDTO = mapToWarehousePropertyDTO(warehouse);
              break;
          default:
              break;
      }

      return new SwapRequestGETDTO(
          entity.getPartyId(), 
          entity.getBuyerId(),
          entity.getPropertyType(),
          apartmentDTO,
          landDTO,
          residenceDTO,
          garageDTO,
          warehouseDTO
      );
    }

    public ApartmentPropertyGETDTO mapToApartmentPropertyDTO(ApartmentProperty entity) {
      return new ApartmentPropertyGETDTO(
          entity.getPropertyId(),
          entity.getApartmentPrice(),
          entity.getPropertyAddress(),
          entity.getPropertyPostalCode(),
          entity.getPropertyDistrict(),
          entity.getPropertyCounty(),
          entity.getGrossArea(),
          entity.getUsableArea(),
          entity.getBedrooms(),
          entity.getBathrooms(),
          entity.getFloor(),
          entity.getParkingSpaces(),
          entity.getElevator(),
          entity.getBuildDate(),
          entity.getInstalledEquipment(),
          entity.getAdditionalInformation(),
          entity.getDescription(),
          entity.getPhotoReferences()
      );
    }
  
    public GaragePropertyGETDTO mapToGaragePropertyDTO(GarageProperty entity) {
      return new GaragePropertyGETDTO(
          entity.getPropertyId(),
          entity.getGaragePrice(),
          entity.getPropertyAddress(),
          entity.getPropertyPostalCode(),
          entity.getPropertyDistrict(),
          entity.getPropertyCounty(),
          entity.getGarageArea(),
          entity.getGarageType(),
          entity.getVehicleCapacity(),
          entity.getInstalledEquipment(),
          entity.getAdditionalInformation(),
          entity.getDescription(),
          entity.getPhotoReferences()
      );
    }
  
    public LandPropertyGETDTO mapToLandPropertyDTO(LandProperty entity) {
      return new LandPropertyGETDTO(
          entity.getPropertyId(),
          entity.getLandPrice(),
          entity.getPropertyAddress(),
          entity.getPropertyPostalCode(),
          entity.getPropertyDistrict(),
          entity.getPropertyCounty(),
          entity.getLandType(),
          entity.getTotalLandArea(),
          entity.getMinimumSurfaceForSale(),
          entity.getBuildableArea(),
          entity.getBuildableFloors(),
          entity.getAccessByRoad(),
          entity.getInstalledEquipment(),
          entity.getViableConstructionTypes(),
          entity.getAdditionalInformation(),
          entity.getDescription(),
          entity.getPhotoReferences()
      );
    }
  
    public ResidencePropertyGETDTO mapToResidencePropertyDTO(ResidenceProperty entity) {
      return new ResidencePropertyGETDTO(
          entity.getPropertyId(),
          entity.getResidencePrice(),
          entity.getPropertyAddress(),
          entity.getPropertyPostalCode(),
          entity.getPropertyDistrict(),
          entity.getPropertyCounty(),
          entity.getGrossArea(),
          entity.getUsableArea(),
          entity.getBedrooms(),
          entity.getBathrooms(),
          entity.getFloors(),
          entity.getResidenceType(),
          entity.getBackyard(),
          entity.getParking(),
          entity.getBuildDate(),
          entity.getOrientation(),
          entity.getInstalledEquipment(),
          entity.getAdditionalInformation(),
          entity.getDescription(),
          entity.getPhotoReferences()
      );
    }
  
    public WarehousePropertyGETDTO mapToWarehousePropertyDTO(WarehouseProperty entity) {
      return new WarehousePropertyGETDTO(
          entity.getPropertyId(),
          entity.getWarehousePrice(),
          entity.getPropertyAddress(),
          entity.getPropertyPostalCode(),
          entity.getPropertyDistrict(),
          entity.getPropertyCounty(),
          entity.getWarehouseType(),
          entity.getGrossArea(),
          entity.getUsableArea(),
          entity.getFloors(),
          entity.getBuildDate(),
          entity.getInstalledEquipment(),
          entity.getAdditionalInformation(),
          entity.getDescription(),
          entity.getPhotoReferences()
      );
    }
  

}