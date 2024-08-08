package business.userproperty.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daml.ledger.api.v1.TransactionOuterClass.Transaction;
import com.daml.ledger.javaapi.data.Unit;

import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.operator.entity.repository.OperatorRepository;
import business.propertymanager.entity.repository.PropertyManagerRepository;
import business.user.entity.repository.UserRepository;
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
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
          servicId);
      
      String version = "0"; //Checkar como fazer sem ser hard coded
      var landPropertyKey = new daml.daml.finance.interface$.types.common.types.InstrumentKey(userParty, operatorParty, userPropertyId, version, HoldingStandard.TRANSFERABLE);

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
      
      String apartmentIdString = apartmentPropertyRepository.findById(operatorParty + userParty).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(apartmentIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);
      
      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentPrice(apartmentPrice, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentPropertyAddress(propertyAddress, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentPropertyPostalCode(propertyPostalCode, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentPropertyDistrict(propertyDistrict, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentPropertyCounty(propertyCounty, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);
      
      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentGrossArea(grossArea, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentUsableArea(usableArea, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentBedrooms(bedrooms, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentBathrooms(bathrooms, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentFloor(floor, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentParkingSpaces(parkingSpaces, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentElevator(elevator, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentBuildDate(buildDate, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentInstalledEquipment(installedEquipment, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentAdditionalInformation(additionalInformation, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentDescription(description, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);
      
      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateApartmentPhotoReferences(photoReferences, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Apartment Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Apartment Property: " + e.getMessage();
    }
    return "Success Updating User Apartment Property:\n";
  }

  public String modifyUserGaragePropertyFields(String operator, String user, BigDecimal garagePrice, String propertyAddress, 
  String propertyPostalCode, String propertyDistrict,String propertyCounty, BigDecimal garageArea, GarageType garageType, 
  Long vehicleCapacity, String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      String garageIdString = garagePropertyRepository.findById(operatorParty + userParty).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(garageIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);

      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGaragePrice(garagePrice, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGaragePropertyAddress(propertyAddress, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGaragePropertyPostalCode(propertyPostalCode, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGaragePropertyDistrict(propertyDistrict, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGaragePropertyCounty(propertyCounty, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);
      
      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGarageType(garageType, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateVehicleCapacity(vehicleCapacity, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGarageInstalledEquipment(installedEquipment, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGarageAdditionalInformation(additionalInformation, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGarageDescription(description, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateGaragePhotoReferences(photoReferences, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Garage Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Garage Property: " + e.getMessage();
    }
    return "Success Updating User Garage Property:\n";
  }

  public String modifyUserLandPropertyFields(String operator, String user, BigDecimal landPrice, String propertyAddress, String propertyPostalCode, 
  String propertyDistrict,String propertyCounty,LandType landType,BigDecimal totalLandArea,BigDecimal minimumSurfaceForSale,
  BigDecimal buildableArea,Long buildableFloors,Boolean accessByRoad, String installedEquipment,
  List<ViableConstructionTypes> viableConstructionTypes,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      String landIdString = landPropertyRepository.findById(operatorParty + userParty).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(landIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);

      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandPrice(landPrice, key).commands(),
          Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandPropertyAddress(propertyAddress, key).commands(),
          Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandPropertyPostalCode(propertyPostalCode, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandPropertyDistrict(propertyDistrict, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandPropertyCounty(propertyCounty, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);
      
      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandType(landType, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateTotalLandArea(totalLandArea, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateMinimumSurfaceForSale(minimumSurfaceForSale, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandBuildableArea(buildableArea, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandAccessByRoad(accessByRoad, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandInstalledEquipment(installedEquipment, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandViableConstructionTypes(viableConstructionTypes, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandAdditionalInformation(additionalInformation, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandDescription(description, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateLandPhotoReferences(photoReferences, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Land Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Land Property: " + e.getMessage();
    }
    return "Success Updating User Land Property:\n";
  }

  public String modifyUserResidencePropertyFields(String operator, String user, BigDecimal residencePrice, String propertyAddress, String propertyPostalCode, 
  String propertyDistrict,String propertyCounty,BigDecimal grossArea,BigDecimal usableArea, Long bedrooms, Long bathrooms, Long floors, ResidenceType residenceType, 
  String backyard,Parking parking,LocalDate buildDate, Orientation orientation, String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      String residenceIdString = residencePropertyRepository.findById(operatorParty + userParty).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(residenceIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);

      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidencePrice(residencePrice, key).commands(),
          Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidencePropertyAddress(propertyAddress, key).commands(),
          Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidencePropertyPostalCode(propertyPostalCode, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidencePropertyDistrict(propertyDistrict, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidencePropertyCounty(propertyCounty, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);
      
      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceGrossArea(grossArea, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceUsableArea(usableArea, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceBedrooms(bedrooms, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceBathrooms(bathrooms, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceFloors(floors, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceType(residenceType, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceBackyard(backyard, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceParking(parking, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceBuildDate(buildDate, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceOrientation(orientation, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceInstalledEquipment(installedEquipment, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceAdditionalInformation(additionalInformation, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidenceDescription(description, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);
      
      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateResidencePhotoReferences(photoReferences, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Residence Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Residence Property: " + e.getMessage();
    }
    return "Success Updating User Residence Property:\n";
  }

  public String modifyUserWarehousePropertyFields(String operator, String user, BigDecimal warehousePrice, String propertyAddress, String propertyPostalCode, 
  String propertyDistrict,String propertyCounty, WarehouseType warehouseType, BigDecimal grossArea, BigDecimal usableArea, Long floors, 
  LocalDate buildDate,String installedEquipment,String additionalInformation,String description, List<String> photoReferences) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = propertyManagerRepository.findById(operatorParty + userParty).getContractId();
      
      String warehouseIdString = warehousePropertyRepository.findById(operatorParty + userParty).getPropertyId();
      PropertyKey key = new PropertyKey(operatorParty, userParty, new Id(warehouseIdString));

      var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(servicId);

      Transaction transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehousePrice(warehousePrice, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehousePropertyAddress(propertyAddress, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehousePropertyPostalCode(propertyPostalCode, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehousePropertyDistrict(propertyDistrict, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehousePropertyCounty(propertyCounty, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehouseType(warehouseType, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehouseGrossArea(grossArea, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehouseUsableArea(usableArea, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehouseFloors(floors, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehouseBuildDate(buildDate, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehouseInstalledEquipment(installedEquipment, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehouseAdditionalInformation(additionalInformation, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehouseDescription(description, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

      transaction = transactionService.submitTransaction(serviceId.exerciseUpdateWarehousePhotoReferences(photoReferences, key).commands(),
      Arrays.asList(userParty), null);
      transactionService.handleTransaction(transaction);

    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Warehouse Property: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Warehouse Property: " + e.getMessage();
    }
    return "Success Updating User Warehouse Property:\n";
  }

}
