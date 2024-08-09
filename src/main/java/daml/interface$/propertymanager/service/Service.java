package daml.interface$.propertymanager.service;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.Choice;
import com.daml.ledger.javaapi.data.codegen.Contract;
import com.daml.ledger.javaapi.data.codegen.ContractCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractTypeCompanion;
import com.daml.ledger.javaapi.data.codegen.Exercised;
import com.daml.ledger.javaapi.data.codegen.InterfaceCompanion;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.Update;
import daml.da.set.types.Set;
import daml.da.types.Tuple2;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.interface$.common.types.PropertyKey;
import daml.interface$.propertymanager.property.common.GarageType;
import daml.interface$.propertymanager.property.common.LandType;
import daml.interface$.propertymanager.property.common.Orientation;
import daml.interface$.propertymanager.property.common.Parking;
import daml.interface$.propertymanager.property.common.ResidenceType;
import daml.interface$.propertymanager.property.common.ViableConstructionTypes;
import daml.interface$.propertymanager.property.common.WarehouseType;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public final class Service {
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.PropertyManager.Service", "Service");

  public static final Choice<Service, RequestCreateLandProperty, daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId> CHOICE_RequestCreateLandProperty = 
      Choice.create("RequestCreateLandProperty", value$ -> value$.toValue(), value$ ->
        RequestCreateLandProperty.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, UpdateGarage, Unit> CHOICE_UpdateGarage = 
      Choice.create("UpdateGarage", value$ -> value$.toValue(), value$ ->
        UpdateGarage.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateLand, Unit> CHOICE_UpdateLand = 
      Choice.create("UpdateLand", value$ -> value$.toValue(), value$ -> UpdateLand.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, CreateResidenceProperty, Tuple2<InstrumentKey, PropertyKey>> CHOICE_CreateResidenceProperty = 
      Choice.create("CreateResidenceProperty", value$ -> value$.toValue(), value$ ->
        CreateResidenceProperty.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
        daml.interface$.common.types.PropertyKey>valueDecoder(InstrumentKey.valueDecoder(),
        PropertyKey.valueDecoder()).decode(value$));

  public static final Choice<Service, UpdateWarehouse, Unit> CHOICE_UpdateWarehouse = 
      Choice.create("UpdateWarehouse", value$ -> value$.toValue(), value$ ->
        UpdateWarehouse.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateApartment, Unit> CHOICE_UpdateApartment = 
      Choice.create("UpdateApartment", value$ -> value$.toValue(), value$ ->
        UpdateApartment.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, RequestCreateGarageProperty, daml.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty.ContractId> CHOICE_RequestCreateGarageProperty = 
      Choice.create("RequestCreateGarageProperty", value$ -> value$.toValue(), value$ ->
        RequestCreateGarageProperty.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, RequestCreateWarehouseProperty, daml.interface$.propertymanager.choices.requestcreatewarehouseproperty.RequestCreateWarehouseProperty.ContractId> CHOICE_RequestCreateWarehouseProperty = 
      Choice.create("RequestCreateWarehouseProperty", value$ -> value$.toValue(), value$ ->
        RequestCreateWarehouseProperty.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.choices.requestcreatewarehouseproperty.RequestCreateWarehouseProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, RequestCreateApartmentProperty, daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId> CHOICE_RequestCreateApartmentProperty = 
      Choice.create("RequestCreateApartmentProperty", value$ -> value$.toValue(), value$ ->
        RequestCreateApartmentProperty.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidence, Unit> CHOICE_UpdateResidence = 
      Choice.create("UpdateResidence", value$ -> value$.toValue(), value$ ->
        UpdateResidence.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, CreateLandProperty, Tuple2<InstrumentKey, PropertyKey>> CHOICE_CreateLandProperty = 
      Choice.create("CreateLandProperty", value$ -> value$.toValue(), value$ ->
        CreateLandProperty.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
        daml.interface$.common.types.PropertyKey>valueDecoder(InstrumentKey.valueDecoder(),
        PropertyKey.valueDecoder()).decode(value$));

  public static final Choice<Service, CreateGarageProperty, Tuple2<InstrumentKey, PropertyKey>> CHOICE_CreateGarageProperty = 
      Choice.create("CreateGarageProperty", value$ -> value$.toValue(), value$ ->
        CreateGarageProperty.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
        daml.interface$.common.types.PropertyKey>valueDecoder(InstrumentKey.valueDecoder(),
        PropertyKey.valueDecoder()).decode(value$));

  public static final Choice<Service, RequestCreateResidenceProperty, daml.interface$.propertymanager.choices.requestcreateresidenceproperty.RequestCreateResidenceProperty.ContractId> CHOICE_RequestCreateResidenceProperty = 
      Choice.create("RequestCreateResidenceProperty", value$ -> value$.toValue(), value$ ->
        RequestCreateResidenceProperty.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.choices.requestcreateresidenceproperty.RequestCreateResidenceProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, CreateWarehouseProperty, Tuple2<InstrumentKey, PropertyKey>> CHOICE_CreateWarehouseProperty = 
      Choice.create("CreateWarehouseProperty", value$ -> value$.toValue(), value$ ->
        CreateWarehouseProperty.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
        daml.interface$.common.types.PropertyKey>valueDecoder(InstrumentKey.valueDecoder(),
        PropertyKey.valueDecoder()).decode(value$));

  public static final Choice<Service, CreateApartmentProperty, Tuple2<InstrumentKey, PropertyKey>> CHOICE_CreateApartmentProperty = 
      Choice.create("CreateApartmentProperty", value$ -> value$.toValue(), value$ ->
        CreateApartmentProperty.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
        daml.interface$.common.types.PropertyKey>valueDecoder(InstrumentKey.valueDecoder(),
        PropertyKey.valueDecoder()).decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private Service() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Service> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId>> exerciseRequestCreateLandProperty(
        RequestCreateLandProperty arg) {
      return makeExerciseCmd(CHOICE_RequestCreateLandProperty, arg);
    }

    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId>> exerciseRequestCreateLandProperty(
        Id id, InstrumentKey landInstrument, BigDecimal landPrice, String propertyAddress,
        String propertyPostalCode, String propertyDistrict, String propertyCounty,
        LandType landType, BigDecimal totalLandArea, BigDecimal minimumSurfaceForSale,
        BigDecimal buildableArea, Long buildableFloors, Boolean accessByRoad,
        String installedEquipment, List<ViableConstructionTypes> viableConstructionTypes,
        String additionalInformation, String description, List<String> photoReferences,
        Map<String, Set<String>> observers) {
      return exerciseRequestCreateLandProperty(new RequestCreateLandProperty(id, landInstrument,
          landPrice, propertyAddress, propertyPostalCode, propertyDistrict, propertyCounty,
          landType, totalLandArea, minimumSurfaceForSale, buildableArea, buildableFloors,
          accessByRoad, installedEquipment, viableConstructionTypes, additionalInformation,
          description, photoReferences, observers));
    }

    default Update<Exercised<Unit>> exerciseUpdateGarage(UpdateGarage arg) {
      return makeExerciseCmd(CHOICE_UpdateGarage, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGarage(BigDecimal newGaragePrice,
        String newGaragePropertyAddress, String newGaragePropertyPostalCode,
        String newGaragePropertyDistrict, String newGaragePropertyCounty, BigDecimal newGarageArea,
        GarageType newGarageType, Long newGarageVehicleCapacity, String newGarageInstalledEquipment,
        String newGarageAdditionalInformation, String newGarageDescription,
        List<String> newGaragePhotoReferences, PropertyKey propertyKey) {
      return exerciseUpdateGarage(new UpdateGarage(newGaragePrice, newGaragePropertyAddress,
          newGaragePropertyPostalCode, newGaragePropertyDistrict, newGaragePropertyCounty,
          newGarageArea, newGarageType, newGarageVehicleCapacity, newGarageInstalledEquipment,
          newGarageAdditionalInformation, newGarageDescription, newGaragePhotoReferences,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLand(UpdateLand arg) {
      return makeExerciseCmd(CHOICE_UpdateLand, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLand(BigDecimal newLandPrice,
        String newLandPropertyAddress, String newLandPropertyPostalCode,
        String newLandPropertyDistrict, String newLandPropertyCounty, LandType newLandType,
        BigDecimal newLandTotalArea, BigDecimal newLandMinimumSurfaceForSale,
        BigDecimal newLandBuildableArea, Long newLandBuildableFloors, Boolean newLandAccessByRoad,
        String newLandInstalledEquipment,
        List<ViableConstructionTypes> newLandViableConstructionTypes,
        String newLandAdditionalInformation, String newLandDescription,
        List<String> newLandPhotoReferences, PropertyKey propertyKey) {
      return exerciseUpdateLand(new UpdateLand(newLandPrice, newLandPropertyAddress,
          newLandPropertyPostalCode, newLandPropertyDistrict, newLandPropertyCounty, newLandType,
          newLandTotalArea, newLandMinimumSurfaceForSale, newLandBuildableArea,
          newLandBuildableFloors, newLandAccessByRoad, newLandInstalledEquipment,
          newLandViableConstructionTypes, newLandAdditionalInformation, newLandDescription,
          newLandPhotoReferences, propertyKey));
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateResidenceProperty(
        CreateResidenceProperty arg) {
      return makeExerciseCmd(CHOICE_CreateResidenceProperty, arg);
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateResidenceProperty(
        daml.interface$.propertymanager.choices.requestcreateresidenceproperty.RequestCreateResidenceProperty.ContractId createResidencePropertyRequest) {
      return exerciseCreateResidenceProperty(new CreateResidenceProperty(createResidencePropertyRequest));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouse(UpdateWarehouse arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouse, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouse(BigDecimal newWarehousePrice,
        String newWarehousePropertyAddress, String newWarehousePropertyPostalCode,
        String newWarehousePropertyDistrict, String newWarehousePropertyCounty,
        WarehouseType newWarehouseType, BigDecimal newWarehouseGrossArea,
        BigDecimal newWarehouseUsableArea, Long newWarehouseFloors, LocalDate newWarehouseBuildDate,
        String newWarehouseInstalledEquipment, String newWarehouseAdditionalInformation,
        String newWarehouseDescription, List<String> newWarehousePhotoReferences,
        PropertyKey propertyKey) {
      return exerciseUpdateWarehouse(new UpdateWarehouse(newWarehousePrice,
          newWarehousePropertyAddress, newWarehousePropertyPostalCode, newWarehousePropertyDistrict,
          newWarehousePropertyCounty, newWarehouseType, newWarehouseGrossArea,
          newWarehouseUsableArea, newWarehouseFloors, newWarehouseBuildDate,
          newWarehouseInstalledEquipment, newWarehouseAdditionalInformation,
          newWarehouseDescription, newWarehousePhotoReferences, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartment(UpdateApartment arg) {
      return makeExerciseCmd(CHOICE_UpdateApartment, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartment(BigDecimal newApartmentPrice,
        String newApartmentPropertyAddress, String newApartmentPropertyPostalCode,
        String newApartmentPropertyDistrict, String newApartmentPropertyCounty,
        BigDecimal newApartmentGrossArea, BigDecimal newApartmentUsableArea,
        Long newApartmentBedrooms, Long newApartmentBathrooms, Long newApartmentFloor,
        Long newApartmentParkingSpaces, Boolean newApartmentElevator,
        LocalDate newApartmentBuildDate, String newApartmentInstalledEquipment,
        String newApartmentAdditionalInformation, String newApartmentDescription,
        List<String> newApartmentPhotoReferences, PropertyKey propertyKey) {
      return exerciseUpdateApartment(new UpdateApartment(newApartmentPrice,
          newApartmentPropertyAddress, newApartmentPropertyPostalCode, newApartmentPropertyDistrict,
          newApartmentPropertyCounty, newApartmentGrossArea, newApartmentUsableArea,
          newApartmentBedrooms, newApartmentBathrooms, newApartmentFloor, newApartmentParkingSpaces,
          newApartmentElevator, newApartmentBuildDate, newApartmentInstalledEquipment,
          newApartmentAdditionalInformation, newApartmentDescription, newApartmentPhotoReferences,
          propertyKey));
    }

    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty.ContractId>> exerciseRequestCreateGarageProperty(
        RequestCreateGarageProperty arg) {
      return makeExerciseCmd(CHOICE_RequestCreateGarageProperty, arg);
    }

    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty.ContractId>> exerciseRequestCreateGarageProperty(
        Id id, InstrumentKey garageInstrument, BigDecimal garagePrice, String propertyAddress,
        String propertyPostalCode, String propertyDistrict, String propertyCounty,
        BigDecimal garageArea, GarageType garageType, Long vehicleCapacity,
        String installedEquipment, String additionalInformation, String description,
        List<String> photoReferences, Map<String, Set<String>> observers) {
      return exerciseRequestCreateGarageProperty(new RequestCreateGarageProperty(id,
          garageInstrument, garagePrice, propertyAddress, propertyPostalCode, propertyDistrict,
          propertyCounty, garageArea, garageType, vehicleCapacity, installedEquipment,
          additionalInformation, description, photoReferences, observers));
    }

    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreatewarehouseproperty.RequestCreateWarehouseProperty.ContractId>> exerciseRequestCreateWarehouseProperty(
        RequestCreateWarehouseProperty arg) {
      return makeExerciseCmd(CHOICE_RequestCreateWarehouseProperty, arg);
    }

    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreatewarehouseproperty.RequestCreateWarehouseProperty.ContractId>> exerciseRequestCreateWarehouseProperty(
        Id id, InstrumentKey warehouseInstrument, BigDecimal warehousePrice, String propertyAddress,
        String propertyPostalCode, String propertyDistrict, String propertyCounty,
        WarehouseType warehouseType, BigDecimal grossArea, BigDecimal usableArea, Long floors,
        LocalDate buildDate, String installedEquipment, String additionalInformation,
        String description, List<String> photoReferences, Map<String, Set<String>> observers) {
      return exerciseRequestCreateWarehouseProperty(new RequestCreateWarehouseProperty(id,
          warehouseInstrument, warehousePrice, propertyAddress, propertyPostalCode,
          propertyDistrict, propertyCounty, warehouseType, grossArea, usableArea, floors, buildDate,
          installedEquipment, additionalInformation, description, photoReferences, observers));
    }

    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId>> exerciseRequestCreateApartmentProperty(
        RequestCreateApartmentProperty arg) {
      return makeExerciseCmd(CHOICE_RequestCreateApartmentProperty, arg);
    }

    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId>> exerciseRequestCreateApartmentProperty(
        Id id, InstrumentKey apartmentInstrument, BigDecimal apartmentPrice, String propertyAddress,
        String propertyPostalCode, String propertyDistrict, String propertyCounty,
        BigDecimal grossArea, BigDecimal usableArea, Long bedrooms, Long bathrooms, Long floor,
        Long parkingSpaces, Boolean elevator, LocalDate buildDate, String installedEquipment,
        String additionalInformation, String description, List<String> photoReferences,
        Map<String, Set<String>> observers) {
      return exerciseRequestCreateApartmentProperty(new RequestCreateApartmentProperty(id,
          apartmentInstrument, apartmentPrice, propertyAddress, propertyPostalCode,
          propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms, bathrooms, floor,
          parkingSpaces, elevator, buildDate, installedEquipment, additionalInformation,
          description, photoReferences, observers));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<Unit>> exerciseUpdateResidence(UpdateResidence arg) {
      return makeExerciseCmd(CHOICE_UpdateResidence, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidence(BigDecimal newResidencePrice,
        String newResidencePropertyAddress, String newResidencePropertyPostalCode,
        String newResidencePropertyDistrict, String newResidencePropertyCounty,
        BigDecimal newResidenceGrossArea, BigDecimal newResidenceUsableArea,
        Long newResidenceBedrooms, Long newResidenceBathrooms, Long newResidenceFloors,
        ResidenceType newResidenceType, String newResidenceBackyard, Parking newResidenceParking,
        LocalDate newResidenceBuildDate, Orientation newResidenceOrientation,
        String newResidenceInstalledEquipment, String newResidenceAdditionalInformation,
        String newResidenceDescription, List<String> newResidencePhotoReferences,
        PropertyKey propertyKey) {
      return exerciseUpdateResidence(new UpdateResidence(newResidencePrice,
          newResidencePropertyAddress, newResidencePropertyPostalCode, newResidencePropertyDistrict,
          newResidencePropertyCounty, newResidenceGrossArea, newResidenceUsableArea,
          newResidenceBedrooms, newResidenceBathrooms, newResidenceFloors, newResidenceType,
          newResidenceBackyard, newResidenceParking, newResidenceBuildDate, newResidenceOrientation,
          newResidenceInstalledEquipment, newResidenceAdditionalInformation,
          newResidenceDescription, newResidencePhotoReferences, propertyKey));
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateLandProperty(
        CreateLandProperty arg) {
      return makeExerciseCmd(CHOICE_CreateLandProperty, arg);
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateLandProperty(
        daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId createLandPropertyRequest) {
      return exerciseCreateLandProperty(new CreateLandProperty(createLandPropertyRequest));
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateGarageProperty(
        CreateGarageProperty arg) {
      return makeExerciseCmd(CHOICE_CreateGarageProperty, arg);
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateGarageProperty(
        daml.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty.ContractId createGaragePropertyRequest) {
      return exerciseCreateGarageProperty(new CreateGarageProperty(createGaragePropertyRequest));
    }

    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreateresidenceproperty.RequestCreateResidenceProperty.ContractId>> exerciseRequestCreateResidenceProperty(
        RequestCreateResidenceProperty arg) {
      return makeExerciseCmd(CHOICE_RequestCreateResidenceProperty, arg);
    }

    default Update<Exercised<daml.interface$.propertymanager.choices.requestcreateresidenceproperty.RequestCreateResidenceProperty.ContractId>> exerciseRequestCreateResidenceProperty(
        Id id, InstrumentKey residenceInstrument, BigDecimal residencePrice, String propertyAddress,
        String propertyPostalCode, String propertyDistrict, String propertyCounty,
        BigDecimal grossArea, BigDecimal usableArea, Long bedrooms, Long bathrooms, Long floors,
        ResidenceType residenceType, String backyard, Parking parking, LocalDate buildDate,
        Orientation orientation, String installedEquipment, String additionalInformation,
        String description, List<String> photoReferences, Map<String, Set<String>> observers) {
      return exerciseRequestCreateResidenceProperty(new RequestCreateResidenceProperty(id,
          residenceInstrument, residencePrice, propertyAddress, propertyPostalCode,
          propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms, bathrooms, floors,
          residenceType, backyard, parking, buildDate, orientation, installedEquipment,
          additionalInformation, description, photoReferences, observers));
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateWarehouseProperty(
        CreateWarehouseProperty arg) {
      return makeExerciseCmd(CHOICE_CreateWarehouseProperty, arg);
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateWarehouseProperty(
        daml.interface$.propertymanager.choices.requestcreatewarehouseproperty.RequestCreateWarehouseProperty.ContractId createWarehousePropertyRequest) {
      return exerciseCreateWarehouseProperty(new CreateWarehouseProperty(createWarehousePropertyRequest));
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateApartmentProperty(
        CreateApartmentProperty arg) {
      return makeExerciseCmd(CHOICE_CreateApartmentProperty, arg);
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateApartmentProperty(
        daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId createApartmentPropertyRequest) {
      return exerciseCreateApartmentProperty(new CreateApartmentProperty(createApartmentPropertyRequest));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<Service, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.propertymanager.service.Service", Service.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_RequestCreateResidenceProperty,
            CHOICE_RequestCreateLandProperty, CHOICE_CreateApartmentProperty,
            CHOICE_CreateLandProperty, CHOICE_CreateGarageProperty, CHOICE_CreateResidenceProperty,
            CHOICE_Archive, CHOICE_UpdateGarage, CHOICE_RequestCreateGarageProperty,
            CHOICE_UpdateLand, CHOICE_UpdateResidence, CHOICE_UpdateWarehouse,
            CHOICE_CreateWarehouseProperty, CHOICE_RequestCreateWarehouseProperty,
            CHOICE_UpdateApartment, CHOICE_RequestCreateApartmentProperty));
    }
  }
}
