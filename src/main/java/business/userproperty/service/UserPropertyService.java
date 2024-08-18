package business.userproperty.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
import business.operator.entity.repository.OperatorRepository;
import business.propertymanager.entity.repository.PropertyManagerRepository;
import business.user.entity.repository.UserRepository;
import business.useraccount.entity.model.UserHoldingTransferable;
import business.useraccount.entity.repository.UserHoldingTransferableRepository;
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
import business.userproperty.entity.repository.PropertyServiceOfferRepository;
import business.userproperty.entity.repository.ResidencePropertyRepository;
import business.userproperty.entity.repository.WarehousePropertyRepository;
import daml.da.set.types.Set;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.marketplace.interface$.propertymanager.property.common.GarageType;
import daml.marketplace.interface$.propertymanager.property.common.LandType;
import daml.marketplace.interface$.propertymanager.property.common.Orientation;
import daml.marketplace.interface$.propertymanager.property.common.Parking;
import daml.marketplace.interface$.propertymanager.property.common.ResidenceType;
import daml.marketplace.interface$.propertymanager.property.common.ViableConstructionTypes;
import daml.marketplace.interface$.propertymanager.property.common.WarehouseType;
import daml.marketplace.interface$.common.types.PropertyKey;
import daml.daml.finance.interface$.types.common.types.HoldingStandard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserPropertyService {
  @Inject
  DamlLedgerClientProvider clientProvider;

  @Inject
  UserRepository userRepository;

  @Inject
  Transactions transactionService;

  @Inject
  OperatorRepository operatorRepository;

  @Inject
  PropertyServiceOfferRepository propertyServiceOfferRepository;

  @Inject
  PropertyManagerRepository propertyManagerRepository;

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
  UserHoldingTransferableRepository userHoldingTransferableRepository;

  public static final String APP_ID = "OperatorId";

  public UserPropertyService() {

  }

  private void handlePropertyServiceOffer(String operator, String user, String action)
      throws IllegalArgumentException, IllegalStateException, Exception {

    String operatorParty = userRepository.findById(operator).getPartyId();
    String userParty = userRepository.findById(user).getPartyId();
    String offerContractId = propertyServiceOfferRepository.findById(operatorParty + userParty)
        .getContractId();
    List<com.daml.ledger.javaapi.data.Command> command = null;

    var serviceAcceptId = new daml.marketplace.interface$.propertymanager.service.Offer.ContractId(offerContractId);

    if (action.equals("accept"))
      command = serviceAcceptId.exerciseAccept().commands();
    else if (action.equals("decline"))
      command = serviceAcceptId.exerciseDecline().commands();

    Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);
    transactionService.handleTransaction(transaction);
  }

  public String acceptPropertyService(String operator, String user) {
    try {
      handlePropertyServiceOffer(operator, user, "accept");
    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error accepting Property Service: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error accepting Property Service : " + e.getMessage() + "\n";
    }

    return "Accepted Property Service!\n";
  }

  public String declinePropertyService(String operator, String user) {
    try {
      handlePropertyServiceOffer(operator, user, "decline");

    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error declining Property Service: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error declining Property Service: " + e.getMessage() + "\n";
    }
    return "Declined Property Service!\n";
  }

  public String requestCreateApartmentProperty (String operator, String user, String propertyId, BigDecimal apartmentPrice,String propertyAddress, String propertyPostalCode, 
   String propertyDistrict,String propertyCounty,BigDecimal grossArea,BigDecimal usableArea,Long bedrooms,Long bathrooms, Long floor,Long parkingSpaces, 
   Boolean elevator,LocalDate buildDate,String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);
      List<com.daml.ledger.javaapi.data.Command> command = null;
      
      Id userPropertyId = new Id(propertyId);
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
          servicId);
      
      String version = "0"; //Checkar como fazer sem ser hard coded
      var apartmentPropertyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, userPropertyId, version, HoldingStandard.TRANSFERABLE);

      command = serviceId.exerciseRequestCreateApartmentProperty(userPropertyId, apartmentPropertyKey, apartmentPrice, propertyAddress, propertyPostalCode, 
      propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms, bathrooms, floor, parkingSpaces, elevator, buildDate, 
      installedEquipment, additionalInformation, description, photoReferences, observersMap)
          .commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Request Create Apartment : " + e.getMessage();
    } catch (Exception e) {
      return "Error Request Create Apartment : " + e.getMessage();
    }
    return "Success Create Request Apartment\n";
  }

  public String requestCreateGarageProperty (String operator, String user, String propertyId, BigDecimal garagePrice, String propertyAddress, 
    String propertyPostalCode, String propertyDistrict,String propertyCounty, BigDecimal garageArea, GarageType garageType, 
    Long vehicleCapacity, String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);
      List<com.daml.ledger.javaapi.data.Command> command = null;
      
      Id userPropertyId = new Id(propertyId);
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
          servicId);
      
      String version = "0"; //Checkar como fazer sem ser hard coded
      var garagePropertyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, userPropertyId, version, HoldingStandard.TRANSFERABLE);

      command = serviceId.exerciseRequestCreateGarageProperty(userPropertyId, garagePropertyKey, garagePrice, propertyAddress, propertyPostalCode, 
      propertyDistrict, propertyCounty, garageArea, garageType, vehicleCapacity, installedEquipment, additionalInformation, description, photoReferences, observersMap)
          .commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Request Create Garage : " + e.getMessage();
    } catch (Exception e) {
      return "Error Request Create Garage : " + e.getMessage();
    }
    return "Success Create Request Garage\n";
  }

  public String requestCreateLandProperty (String operator, String user, String propertyId,  BigDecimal landPrice, String propertyAddress, String propertyPostalCode, 
   String propertyDistrict,String propertyCounty,LandType landType,BigDecimal totalLandArea,BigDecimal minimumSurfaceForSale,BigDecimal buildableArea,
   Long buildableFloors,Boolean accessByRoad, String installedEquipment,List<ViableConstructionTypes> viableConstructionTypes,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);
      List<com.daml.ledger.javaapi.data.Command> command = null;
      
      Id userPropertyId = new Id(propertyId);
      Id userInstrumentId = new Id("InstrumentID"+propertyPostalCode);
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
          servicId);
      
      String version = "0"; //Checkar como fazer sem ser hard coded
      var landPropertyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, userInstrumentId, version, HoldingStandard.TRANSFERABLE);

      command = serviceId.exerciseRequestCreateLandProperty(userPropertyId, landPropertyKey, landPrice, propertyAddress, propertyPostalCode, 
      propertyDistrict, propertyCounty, landType, totalLandArea, minimumSurfaceForSale, buildableArea, buildableFloors, accessByRoad, 
      installedEquipment, viableConstructionTypes, additionalInformation, description, photoReferences, observersMap)
          .commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Request Create Land : " + e.getMessage();
    } catch (Exception e) {
      return "Error Request Create Land : " + e.getMessage();
    }
    return "Success Create Request Land\n";
  }

  public String requestCreateResidenceProperty (String operator, String user, String propertyId,  BigDecimal residencePrice, String propertyAddress, String propertyPostalCode, 
   String propertyDistrict,String propertyCounty,BigDecimal grossArea,BigDecimal usableArea,Long bedrooms,Long bathrooms, Long floors,ResidenceType residenceType, 
   String backyard,Parking parking,LocalDate buildDate, Orientation orientation,String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);
      List<com.daml.ledger.javaapi.data.Command> command = null;
      
      Id userPropertyId = new Id(propertyId);
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
          servicId);
      
      String version = "0"; //Checkar como fazer sem ser hard coded
      var residencePropertyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, userPropertyId, version, HoldingStandard.TRANSFERABLE);

      command = serviceId.exerciseRequestCreateResidenceProperty(userPropertyId, residencePropertyKey, residencePrice, propertyAddress, propertyPostalCode, propertyDistrict, propertyCounty,
       grossArea, usableArea, bedrooms, bathrooms, floors, residenceType, backyard, parking, buildDate, orientation, installedEquipment, additionalInformation, description, photoReferences, observersMap).commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Request Create Residence : " + e.getMessage();
    } catch (Exception e) {
      return "Error Request Create Residence : " + e.getMessage();
    }
    return "Success Create Request Residence\n";
  }

  public String requestCreateWarehouseProperty (String operator, String user, String propertyId, BigDecimal warehousePrice, String propertyAddress, String propertyPostalCode, 
  String propertyDistrict,String propertyCounty, WarehouseType warehouseType, BigDecimal grossArea, BigDecimal usableArea, Long floors, 
  LocalDate buildDate,String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);
      List<com.daml.ledger.javaapi.data.Command> command = null;
      
      Id userPropertyId = new Id(propertyId);
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
          servicId);
      
      String version = "0"; //Checkar como fazer sem ser hard coded
      var warehousePropertyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, userPropertyId, version, HoldingStandard.TRANSFERABLE);

      command = serviceId.exerciseRequestCreateWarehouseProperty(userPropertyId, warehousePropertyKey, warehousePrice, propertyAddress, propertyPostalCode, 
      propertyDistrict, propertyCounty, warehouseType, grossArea, usableArea, floors, buildDate, installedEquipment, 
      additionalInformation, description, photoReferences, observersMap)
          .commands();
      Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Request Create Warehouse : " + e.getMessage();
    } catch (Exception e) {
      return "Error Request Create Warehouse : " + e.getMessage();
    }
    return "Success Create Request Warehouse\n";
  }

  public String modifyUserApartmentPropertyFields(String operator, String user, BigDecimal apartmentPrice, String propertyAddress, String propertyPostalCode, 
  String propertyDistrict,String propertyCounty,BigDecimal grossArea,BigDecimal usableArea,Long bedrooms,Long bathrooms, Long floor,Long parkingSpaces, 
  Boolean elevator,LocalDate buildDate,String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      String apartmentIdString = apartmentPropertyRepository.findById(operatorParty + propertyPostalCode).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(apartmentIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);
      
      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartment(apartmentPrice, propertyAddress, 
      propertyPostalCode, propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms, bathrooms, floor, parkingSpaces, elevator, buildDate, installedEquipment, additionalInformation, description, photoReferences, key).commands(),
      Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Apartment Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Apartment Property: " + e.getMessage();
    }
    return "Success Updating User Apartment Property!\n";
  }

  public String modifyUserGaragePropertyFields(String operator, String user, BigDecimal garagePrice, String propertyAddress, 
  String propertyPostalCode, String propertyDistrict,String propertyCounty, BigDecimal garageArea, GarageType garageType, 
  Long vehicleCapacity, String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      String garageIdString = garagePropertyRepository.findById(operatorParty + propertyPostalCode).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(garageIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);

      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGarage(garagePrice, propertyAddress, 
      propertyPostalCode, propertyDistrict, propertyCounty, garageArea, garageType, vehicleCapacity, installedEquipment, additionalInformation, 
      description, photoReferences, key).commands(),
      Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Garage Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Garage Property: " + e.getMessage();
    }
    return "Success Updating User Garage Property!\n";
  }

  public String modifyUserLandPropertyFields(String operator, String user, BigDecimal landPrice, String propertyAddress, String propertyPostalCode, 
  String propertyDistrict,String propertyCounty,LandType landType,BigDecimal totalLandArea,BigDecimal minimumSurfaceForSale,
  BigDecimal buildableArea,Long buildableFloors,Boolean accessByRoad, String installedEquipment,
  List<ViableConstructionTypes> viableConstructionTypes,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      String landIdString = landPropertyRepository.findById(operatorParty + propertyPostalCode).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(landIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);

      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLand(landPrice, propertyAddress, 
      propertyPostalCode, propertyDistrict, propertyCounty, landType, totalLandArea, minimumSurfaceForSale, 
      buildableArea, buildableFloors, accessByRoad, installedEquipment, viableConstructionTypes, 
      additionalInformation, description, photoReferences, key).commands(),
          Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Land Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Land Property: " + e.getMessage();
    }
    return "Success Updating User Land Property!\n";
  }

  public String modifyUserResidencePropertyFields(String operator, String user, BigDecimal residencePrice, String propertyAddress, String propertyPostalCode, 
  String propertyDistrict,String propertyCounty,BigDecimal grossArea,BigDecimal usableArea, Long bedrooms, Long bathrooms, Long floors, ResidenceType residenceType, 
  String backyard,Parking parking,LocalDate buildDate, Orientation orientation, String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      String residenceIdString = residencePropertyRepository.findById(operatorParty + propertyPostalCode).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(residenceIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);

      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidence(residencePrice, propertyAddress, 
      propertyPostalCode, propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms, bathrooms, 
      floors, residenceType, backyard, parking, buildDate, orientation, installedEquipment, 
      additionalInformation, description, photoReferences, key).commands(),
          Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Residence Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Residence Property: " + e.getMessage();
    }
    return "Success Updating User Residence Property!\n";
  }

  public String modifyUserWarehousePropertyFields(String operator, String user, BigDecimal warehousePrice, String propertyAddress, String propertyPostalCode, 
  String propertyDistrict,String propertyCounty, WarehouseType warehouseType, BigDecimal grossArea, BigDecimal usableArea, Long floors, 
  LocalDate buildDate,String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      String warehouseIdString = warehousePropertyRepository.findById(operatorParty + propertyPostalCode).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(warehouseIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);

      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehouse(warehousePrice, propertyAddress, 
      propertyPostalCode, propertyDistrict, propertyCounty, warehouseType, grossArea, usableArea, floors, 
      buildDate, installedEquipment, additionalInformation, description, photoReferences, key).commands(),
      Arrays.asList(operatorParty, userParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Warehouse Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Warehouse Property: " + e.getMessage();
    }
    return "Success Updating User Warehouse Property!\n";
  }

//---------------------------------------------------------------------------------------------------------------------------------

  public Map<String, List<?>> getAllUserProperties(String operatorId, String userId) {
    String operatorParty = userRepository.findById(operatorId).getPartyId();
    String userParty = userRepository.findById(userId).getPartyId();

    List<UserHoldingTransferable> listHoldingTransferables = userHoldingTransferableRepository.findByPartyIdStartingWith(operatorParty + userParty);
    Map<String, List<?>> propertiesMap = new HashMap<>();

    List<ApartmentPropertyGETDTO> apartments = new ArrayList<>();
    List<GaragePropertyGETDTO> garages = new ArrayList<>();
    List<LandPropertyGETDTO> lands = new ArrayList<>();
    List<ResidencePropertyGETDTO> residences = new ArrayList<>();
    List<WarehousePropertyGETDTO> warehouses = new ArrayList<>();

    for (UserHoldingTransferable holding : listHoldingTransferables) {
        String propertyId = operatorParty + holding.getPostalCode();
        switch (holding.getPropertyType()) {
            case "APARTMENT":
                apartments.add(mapToApartmentPropertyDTO(apartmentPropertyRepository.findById(propertyId)));
                break;
            case "GARAGE":
                garages.add(mapToGaragePropertyDTO(garagePropertyRepository.findById(propertyId)));
                break;
            case "LAND":
                lands.add(mapToLandPropertyDTO(landPropertyRepository.findById(propertyId)));
                break;
            case "RESIDENCE":
                residences.add(mapToResidencePropertyDTO(residencePropertyRepository.findById(propertyId)));
                break;
            case "WAREHOUSE":
                warehouses.add(mapToWarehousePropertyDTO(warehousePropertyRepository.findById(propertyId)));
                break;
            default:
                break;
        }
    }
    propertiesMap.put("APARTMENT", apartments);
    propertiesMap.put("GARAGE", garages);
    propertiesMap.put("LAND", lands);
    propertiesMap.put("RESIDENCE", residences);
    propertiesMap.put("WAREHOUSE", warehouses);

    return propertiesMap;
  }

  public Map<String, List<?>> getAllProperties() {
    Map<String, List<?>> propertiesMap = new HashMap<>();

    List<ApartmentPropertyGETDTO> apartments = apartmentPropertyRepository.findAll().stream()
        .map(this::mapToApartmentPropertyDTO)
        .collect(Collectors.toList());
    List<GaragePropertyGETDTO> garages = garagePropertyRepository.findAll().stream()
        .map(this::mapToGaragePropertyDTO)
        .collect(Collectors.toList());
    List<LandPropertyGETDTO> lands = landPropertyRepository.findAll().stream()
        .map(this::mapToLandPropertyDTO)
        .collect(Collectors.toList());
    List<ResidencePropertyGETDTO> residences = residencePropertyRepository.findAll().stream()
        .map(this::mapToResidencePropertyDTO)
        .collect(Collectors.toList());
    List<WarehousePropertyGETDTO> warehouses = warehousePropertyRepository.findAll().stream()
        .map(this::mapToWarehousePropertyDTO)
        .collect(Collectors.toList());

    propertiesMap.put("APARTMENT", apartments);
    propertiesMap.put("GARAGE", garages);
    propertiesMap.put("LAND", lands);
    propertiesMap.put("RESIDENCE", residences);
    propertiesMap.put("WAREHOUSE", warehouses);

    return propertiesMap;
  }

  public List<ApartmentPropertyGETDTO> getAllApartmentProperties() {
    return apartmentPropertyRepository.findAll().stream()
        .map(this::mapToApartmentPropertyDTO)
        .collect(Collectors.toList());
  }

  public ApartmentPropertyGETDTO getApartmentPropertyById(String operatorId, String postalCode) {
    String operatorParty = userRepository.findById(operatorId).getPartyId();
    String partyId = operatorParty + postalCode;
    return mapToApartmentPropertyDTO(apartmentPropertyRepository.findById(partyId));
  }

  public List<GaragePropertyGETDTO> getAllGarageProperties() {
    return garagePropertyRepository.findAll().stream()
        .map(this::mapToGaragePropertyDTO)
        .collect(Collectors.toList());
  }

  public GaragePropertyGETDTO getGaragePropertyById(String operatorId, String postalCode) {
    String operatorParty = userRepository.findById(operatorId).getPartyId();
    String partyId = operatorParty + postalCode;
    return mapToGaragePropertyDTO(garagePropertyRepository.findById(partyId));
  }

  public List<LandPropertyGETDTO> getAllLandProperties() {
    return landPropertyRepository.findAll().stream()
        .map(this::mapToLandPropertyDTO)
        .collect(Collectors.toList());
  }

  public LandPropertyGETDTO getLandPropertyById(String operatorId, String postalCode) {
    String operatorParty = userRepository.findById(operatorId).getPartyId();
    String partyId = operatorParty + postalCode;
    return mapToLandPropertyDTO(landPropertyRepository.findById(partyId));
  }

  public List<ResidencePropertyGETDTO> getAllResidenceProperties() {
    return residencePropertyRepository.findAll().stream()
        .map(this::mapToResidencePropertyDTO)
        .collect(Collectors.toList());
  }

  public ResidencePropertyGETDTO getResidencePropertyById(String operatorId, String postalCode) {
    String operatorParty = userRepository.findById(operatorId).getPartyId();
    String partyId = operatorParty + postalCode;
    return mapToResidencePropertyDTO(residencePropertyRepository.findById(partyId));
  }

  public List<WarehousePropertyGETDTO> getAllWarehouseProperties() {
    return warehousePropertyRepository.findAll().stream()
        .map(this::mapToWarehousePropertyDTO)
        .collect(Collectors.toList());
  }

  public WarehousePropertyGETDTO getWarehousePropertyById(String operatorId, String postalCode) {
    String operatorParty = userRepository.findById(operatorId).getPartyId();
    String partyId = operatorParty + postalCode;
    return mapToWarehousePropertyDTO(warehousePropertyRepository.findById(partyId));
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
