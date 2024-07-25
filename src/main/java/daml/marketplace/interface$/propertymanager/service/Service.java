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
  public static final Identifier TEMPLATE_ID = new Identifier("8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f", "Interface.PropertyManager.Service", "Service");

  public static final Choice<Service, UpdateResidenceFloors, Unit> CHOICE_UpdateResidenceFloors = 
      Choice.create("UpdateResidenceFloors", value$ -> value$.toValue(), value$ ->
        UpdateResidenceFloors.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehouseUsableArea, Unit> CHOICE_UpdateWarehouseUsableArea = 
      Choice.create("UpdateWarehouseUsableArea", value$ -> value$.toValue(), value$ ->
        UpdateWarehouseUsableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGarageAdditionalInformation, Unit> CHOICE_UpdateGarageAdditionalInformation = 
      Choice.create("UpdateGarageAdditionalInformation", value$ -> value$.toValue(), value$ ->
        UpdateGarageAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehousePrice, Unit> CHOICE_UpdateWarehousePrice = 
      Choice.create("UpdateWarehousePrice", value$ -> value$.toValue(), value$ ->
        UpdateWarehousePrice.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentParkingSpaces, Unit> CHOICE_UpdateApartmentParkingSpaces = 
      Choice.create("UpdateApartmentParkingSpaces", value$ -> value$.toValue(), value$ ->
        UpdateApartmentParkingSpaces.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidencePropertyPostalCode, Unit> CHOICE_UpdateResidencePropertyPostalCode = 
      Choice.create("UpdateResidencePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        UpdateResidencePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandBuildableFloors, Unit> CHOICE_UpdateLandBuildableFloors = 
      Choice.create("UpdateLandBuildableFloors", value$ -> value$.toValue(), value$ ->
        UpdateLandBuildableFloors.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehouseInstrumentKey, Unit> CHOICE_UpdateWarehouseInstrumentKey = 
      Choice.create("UpdateWarehouseInstrumentKey", value$ -> value$.toValue(), value$ ->
        UpdateWarehouseInstrumentKey.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGarageDescription, Unit> CHOICE_UpdateGarageDescription = 
      Choice.create("UpdateGarageDescription", value$ -> value$.toValue(), value$ ->
        UpdateGarageDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandBuildableArea, Unit> CHOICE_UpdateLandBuildableArea = 
      Choice.create("UpdateLandBuildableArea", value$ -> value$.toValue(), value$ ->
        UpdateLandBuildableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentElevator, Unit> CHOICE_UpdateApartmentElevator = 
      Choice.create("UpdateApartmentElevator", value$ -> value$.toValue(), value$ ->
        UpdateApartmentElevator.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidenceBedrooms, Unit> CHOICE_UpdateResidenceBedrooms = 
      Choice.create("UpdateResidenceBedrooms", value$ -> value$.toValue(), value$ ->
        UpdateResidenceBedrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidencePhotoReferences, Unit> CHOICE_UpdateResidencePhotoReferences = 
      Choice.create("UpdateResidencePhotoReferences", value$ -> value$.toValue(), value$ ->
        UpdateResidencePhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

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

  public static final Choice<Service, RequestCreateLandProperty, daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId> CHOICE_RequestCreateLandProperty = 
      Choice.create("RequestCreateLandProperty", value$ -> value$.toValue(), value$ ->
        RequestCreateLandProperty.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, UpdateLandAdditionalInformation, Unit> CHOICE_UpdateLandAdditionalInformation = 
      Choice.create("UpdateLandAdditionalInformation", value$ -> value$.toValue(), value$ ->
        UpdateLandAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidencePropertyAddress, Unit> CHOICE_UpdateResidencePropertyAddress = 
      Choice.create("UpdateResidencePropertyAddress", value$ -> value$.toValue(), value$ ->
        UpdateResidencePropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehousePropertyDistrict, Unit> CHOICE_UpdateWarehousePropertyDistrict = 
      Choice.create("UpdateWarehousePropertyDistrict", value$ -> value$.toValue(), value$ ->
        UpdateWarehousePropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandPropertyAddress, Unit> CHOICE_UpdateLandPropertyAddress = 
      Choice.create("UpdateLandPropertyAddress", value$ -> value$.toValue(), value$ ->
        UpdateLandPropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidenceDescription, Unit> CHOICE_UpdateResidenceDescription = 
      Choice.create("UpdateResidenceDescription", value$ -> value$.toValue(), value$ ->
        UpdateResidenceDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentPropertyDistrict, Unit> CHOICE_UpdateApartmentPropertyDistrict = 
      Choice.create("UpdateApartmentPropertyDistrict", value$ -> value$.toValue(), value$ ->
        UpdateApartmentPropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGarageArea, Unit> CHOICE_UpdateGarageArea = 
      Choice.create("UpdateGarageArea", value$ -> value$.toValue(), value$ ->
        UpdateGarageArea.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateApartmentPrice, Unit> CHOICE_UpdateApartmentPrice = 
      Choice.create("UpdateApartmentPrice", value$ -> value$.toValue(), value$ ->
        UpdateApartmentPrice.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGarageType, Unit> CHOICE_UpdateGarageType = 
      Choice.create("UpdateGarageType", value$ -> value$.toValue(), value$ ->
        UpdateGarageType.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateGaragePropertyDistrict, Unit> CHOICE_UpdateGaragePropertyDistrict = 
      Choice.create("UpdateGaragePropertyDistrict", value$ -> value$.toValue(), value$ ->
        UpdateGaragePropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentPropertyCounty, Unit> CHOICE_UpdateApartmentPropertyCounty = 
      Choice.create("UpdateApartmentPropertyCounty", value$ -> value$.toValue(), value$ ->
        UpdateApartmentPropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidenceInstalledEquipment, Unit> CHOICE_UpdateResidenceInstalledEquipment = 
      Choice.create("UpdateResidenceInstalledEquipment", value$ -> value$.toValue(), value$ ->
        UpdateResidenceInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateVehicleCapacity, Unit> CHOICE_UpdateVehicleCapacity = 
      Choice.create("UpdateVehicleCapacity", value$ -> value$.toValue(), value$ ->
        UpdateVehicleCapacity.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidencePropertyCounty, Unit> CHOICE_UpdateResidencePropertyCounty = 
      Choice.create("UpdateResidencePropertyCounty", value$ -> value$.toValue(), value$ ->
        UpdateResidencePropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidenceBackyard, Unit> CHOICE_UpdateResidenceBackyard = 
      Choice.create("UpdateResidenceBackyard", value$ -> value$.toValue(), value$ ->
        UpdateResidenceBackyard.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentUsableArea, Unit> CHOICE_UpdateApartmentUsableArea = 
      Choice.create("UpdateApartmentUsableArea", value$ -> value$.toValue(), value$ ->
        UpdateApartmentUsableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehouseAdditionalInformation, Unit> CHOICE_UpdateWarehouseAdditionalInformation = 
      Choice.create("UpdateWarehouseAdditionalInformation", value$ -> value$.toValue(), value$ ->
        UpdateWarehouseAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidencePrice, Unit> CHOICE_UpdateResidencePrice = 
      Choice.create("UpdateResidencePrice", value$ -> value$.toValue(), value$ ->
        UpdateResidencePrice.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, CreateResidenceProperty, Tuple2<InstrumentKey, PropertyKey>> CHOICE_CreateResidenceProperty = 
      Choice.create("CreateResidenceProperty", value$ -> value$.toValue(), value$ ->
        CreateResidenceProperty.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
        daml.interface$.common.types.PropertyKey>valueDecoder(InstrumentKey.valueDecoder(),
        PropertyKey.valueDecoder()).decode(value$));

  public static final Choice<Service, UpdateLandPrice, Unit> CHOICE_UpdateLandPrice = 
      Choice.create("UpdateLandPrice", value$ -> value$.toValue(), value$ ->
        UpdateLandPrice.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateResidenceInstrumentKey, Unit> CHOICE_UpdateResidenceInstrumentKey = 
      Choice.create("UpdateResidenceInstrumentKey", value$ -> value$.toValue(), value$ ->
        UpdateResidenceInstrumentKey.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentPropertyAddress, Unit> CHOICE_UpdateApartmentPropertyAddress = 
      Choice.create("UpdateApartmentPropertyAddress", value$ -> value$.toValue(), value$ ->
        UpdateApartmentPropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGaragePropertyAddress, Unit> CHOICE_UpdateGaragePropertyAddress = 
      Choice.create("UpdateGaragePropertyAddress", value$ -> value$.toValue(), value$ ->
        UpdateGaragePropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGaragePropertyPostalCode, Unit> CHOICE_UpdateGaragePropertyPostalCode = 
      Choice.create("UpdateGaragePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        UpdateGaragePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidenceAdditionalInformation, Unit> CHOICE_UpdateResidenceAdditionalInformation = 
      Choice.create("UpdateResidenceAdditionalInformation", value$ -> value$.toValue(), value$ ->
        UpdateResidenceAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidenceBathrooms, Unit> CHOICE_UpdateResidenceBathrooms = 
      Choice.create("UpdateResidenceBathrooms", value$ -> value$.toValue(), value$ ->
        UpdateResidenceBathrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehouseInstalledEquipment, Unit> CHOICE_UpdateWarehouseInstalledEquipment = 
      Choice.create("UpdateWarehouseInstalledEquipment", value$ -> value$.toValue(), value$ ->
        UpdateWarehouseInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentAdditionalInformation, Unit> CHOICE_UpdateApartmentAdditionalInformation = 
      Choice.create("UpdateApartmentAdditionalInformation", value$ -> value$.toValue(), value$ ->
        UpdateApartmentAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGarageInstalledEquipment, Unit> CHOICE_UpdateGarageInstalledEquipment = 
      Choice.create("UpdateGarageInstalledEquipment", value$ -> value$.toValue(), value$ ->
        UpdateGarageInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehouseGrossArea, Unit> CHOICE_UpdateWarehouseGrossArea = 
      Choice.create("UpdateWarehouseGrossArea", value$ -> value$.toValue(), value$ ->
        UpdateWarehouseGrossArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, CreateWarehouseProperty, Tuple2<InstrumentKey, PropertyKey>> CHOICE_CreateWarehouseProperty = 
      Choice.create("CreateWarehouseProperty", value$ -> value$.toValue(), value$ ->
        CreateWarehouseProperty.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
        daml.interface$.common.types.PropertyKey>valueDecoder(InstrumentKey.valueDecoder(),
        PropertyKey.valueDecoder()).decode(value$));

  public static final Choice<Service, UpdateWarehousePropertyCounty, Unit> CHOICE_UpdateWarehousePropertyCounty = 
      Choice.create("UpdateWarehousePropertyCounty", value$ -> value$.toValue(), value$ ->
        UpdateWarehousePropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, CreateApartmentProperty, Tuple2<InstrumentKey, PropertyKey>> CHOICE_CreateApartmentProperty = 
      Choice.create("CreateApartmentProperty", value$ -> value$.toValue(), value$ ->
        CreateApartmentProperty.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
        daml.interface$.common.types.PropertyKey>valueDecoder(InstrumentKey.valueDecoder(),
        PropertyKey.valueDecoder()).decode(value$));

  public static final Choice<Service, UpdateResidenceParking, Unit> CHOICE_UpdateResidenceParking = 
      Choice.create("UpdateResidenceParking", value$ -> value$.toValue(), value$ ->
        UpdateResidenceParking.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentDescription, Unit> CHOICE_UpdateApartmentDescription = 
      Choice.create("UpdateApartmentDescription", value$ -> value$.toValue(), value$ ->
        UpdateApartmentDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGaragePropertyCounty, Unit> CHOICE_UpdateGaragePropertyCounty = 
      Choice.create("UpdateGaragePropertyCounty", value$ -> value$.toValue(), value$ ->
        UpdateGaragePropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandPropertyCounty, Unit> CHOICE_UpdateLandPropertyCounty = 
      Choice.create("UpdateLandPropertyCounty", value$ -> value$.toValue(), value$ ->
        UpdateLandPropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentPropertyPostalCode, Unit> CHOICE_UpdateApartmentPropertyPostalCode = 
      Choice.create("UpdateApartmentPropertyPostalCode", value$ -> value$.toValue(), value$ ->
        UpdateApartmentPropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehouseFloors, Unit> CHOICE_UpdateWarehouseFloors = 
      Choice.create("UpdateWarehouseFloors", value$ -> value$.toValue(), value$ ->
        UpdateWarehouseFloors.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentBedrooms, Unit> CHOICE_UpdateApartmentBedrooms = 
      Choice.create("UpdateApartmentBedrooms", value$ -> value$.toValue(), value$ ->
        UpdateApartmentBedrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGaragePhotoReferences, Unit> CHOICE_UpdateGaragePhotoReferences = 
      Choice.create("UpdateGaragePhotoReferences", value$ -> value$.toValue(), value$ ->
        UpdateGaragePhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehousePropertyPostalCode, Unit> CHOICE_UpdateWarehousePropertyPostalCode = 
      Choice.create("UpdateWarehousePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        UpdateWarehousePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, RequestCreateGarageProperty, daml.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty.ContractId> CHOICE_RequestCreateGarageProperty = 
      Choice.create("RequestCreateGarageProperty", value$ -> value$.toValue(), value$ ->
        RequestCreateGarageProperty.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, UpdateResidenceBuildDate, Unit> CHOICE_UpdateResidenceBuildDate = 
      Choice.create("UpdateResidenceBuildDate", value$ -> value$.toValue(), value$ ->
        UpdateResidenceBuildDate.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehouseDescription, Unit> CHOICE_UpdateWarehouseDescription = 
      Choice.create("UpdateWarehouseDescription", value$ -> value$.toValue(), value$ ->
        UpdateWarehouseDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, RequestCreateWarehouseProperty, daml.interface$.propertymanager.choices.requestcreatewarehouseproperty.RequestCreateWarehouseProperty.ContractId> CHOICE_RequestCreateWarehouseProperty = 
      Choice.create("RequestCreateWarehouseProperty", value$ -> value$.toValue(), value$ ->
        RequestCreateWarehouseProperty.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.choices.requestcreatewarehouseproperty.RequestCreateWarehouseProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, UpdateResidenceType, Unit> CHOICE_UpdateResidenceType = 
      Choice.create("UpdateResidenceType", value$ -> value$.toValue(), value$ ->
        UpdateResidenceType.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateResidencePropertyDistrict, Unit> CHOICE_UpdateResidencePropertyDistrict = 
      Choice.create("UpdateResidencePropertyDistrict", value$ -> value$.toValue(), value$ ->
        UpdateResidencePropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGaragePrice, Unit> CHOICE_UpdateGaragePrice = 
      Choice.create("UpdateGaragePrice", value$ -> value$.toValue(), value$ ->
        UpdateGaragePrice.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateApartmentInstalledEquipment, Unit> CHOICE_UpdateApartmentInstalledEquipment = 
      Choice.create("UpdateApartmentInstalledEquipment", value$ -> value$.toValue(), value$ ->
        UpdateApartmentInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentInstrumentKey, Unit> CHOICE_UpdateApartmentInstrumentKey = 
      Choice.create("UpdateApartmentInstrumentKey", value$ -> value$.toValue(), value$ ->
        UpdateApartmentInstrumentKey.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandAccessByRoad, Unit> CHOICE_UpdateLandAccessByRoad = 
      Choice.create("UpdateLandAccessByRoad", value$ -> value$.toValue(), value$ ->
        UpdateLandAccessByRoad.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehouseBuildDate, Unit> CHOICE_UpdateWarehouseBuildDate = 
      Choice.create("UpdateWarehouseBuildDate", value$ -> value$.toValue(), value$ ->
        UpdateWarehouseBuildDate.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandPropertyDistrict, Unit> CHOICE_UpdateLandPropertyDistrict = 
      Choice.create("UpdateLandPropertyDistrict", value$ -> value$.toValue(), value$ ->
        UpdateLandPropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateTotalLandArea, Unit> CHOICE_UpdateTotalLandArea = 
      Choice.create("UpdateTotalLandArea", value$ -> value$.toValue(), value$ ->
        UpdateTotalLandArea.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, RequestCreateApartmentProperty, daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId> CHOICE_RequestCreateApartmentProperty = 
      Choice.create("RequestCreateApartmentProperty", value$ -> value$.toValue(), value$ ->
        RequestCreateApartmentProperty.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, UpdateResidenceOrientation, Unit> CHOICE_UpdateResidenceOrientation = 
      Choice.create("UpdateResidenceOrientation", value$ -> value$.toValue(), value$ ->
        UpdateResidenceOrientation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandPropertyPostalCode, Unit> CHOICE_UpdateLandPropertyPostalCode = 
      Choice.create("UpdateLandPropertyPostalCode", value$ -> value$.toValue(), value$ ->
        UpdateLandPropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandPhotoReferences, Unit> CHOICE_UpdateLandPhotoReferences = 
      Choice.create("UpdateLandPhotoReferences", value$ -> value$.toValue(), value$ ->
        UpdateLandPhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentFloor, Unit> CHOICE_UpdateApartmentFloor = 
      Choice.create("UpdateApartmentFloor", value$ -> value$.toValue(), value$ ->
        UpdateApartmentFloor.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandInstrumentKey, Unit> CHOICE_UpdateLandInstrumentKey = 
      Choice.create("UpdateLandInstrumentKey", value$ -> value$.toValue(), value$ ->
        UpdateLandInstrumentKey.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateMinimumSurfaceForSale, Unit> CHOICE_UpdateMinimumSurfaceForSale = 
      Choice.create("UpdateMinimumSurfaceForSale", value$ -> value$.toValue(), value$ ->
        UpdateMinimumSurfaceForSale.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandDescription, Unit> CHOICE_UpdateLandDescription = 
      Choice.create("UpdateLandDescription", value$ -> value$.toValue(), value$ ->
        UpdateLandDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentBathrooms, Unit> CHOICE_UpdateApartmentBathrooms = 
      Choice.create("UpdateApartmentBathrooms", value$ -> value$.toValue(), value$ ->
        UpdateApartmentBathrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehouseType, Unit> CHOICE_UpdateWarehouseType = 
      Choice.create("UpdateWarehouseType", value$ -> value$.toValue(), value$ ->
        UpdateWarehouseType.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateApartmentGrossArea, Unit> CHOICE_UpdateApartmentGrossArea = 
      Choice.create("UpdateApartmentGrossArea", value$ -> value$.toValue(), value$ ->
        UpdateApartmentGrossArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehousePhotoReferences, Unit> CHOICE_UpdateWarehousePhotoReferences = 
      Choice.create("UpdateWarehousePhotoReferences", value$ -> value$.toValue(), value$ ->
        UpdateWarehousePhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateGarageInstrumentKey, Unit> CHOICE_UpdateGarageInstrumentKey = 
      Choice.create("UpdateGarageInstrumentKey", value$ -> value$.toValue(), value$ ->
        UpdateGarageInstrumentKey.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateWarehousePropertyAddress, Unit> CHOICE_UpdateWarehousePropertyAddress = 
      Choice.create("UpdateWarehousePropertyAddress", value$ -> value$.toValue(), value$ ->
        UpdateWarehousePropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidenceGrossArea, Unit> CHOICE_UpdateResidenceGrossArea = 
      Choice.create("UpdateResidenceGrossArea", value$ -> value$.toValue(), value$ ->
        UpdateResidenceGrossArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateApartmentPhotoReferences, Unit> CHOICE_UpdateApartmentPhotoReferences = 
      Choice.create("UpdateApartmentPhotoReferences", value$ -> value$.toValue(), value$ ->
        UpdateApartmentPhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateResidenceUsableArea, Unit> CHOICE_UpdateResidenceUsableArea = 
      Choice.create("UpdateResidenceUsableArea", value$ -> value$.toValue(), value$ ->
        UpdateResidenceUsableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, CreateLandProperty, Tuple2<InstrumentKey, PropertyKey>> CHOICE_CreateLandProperty = 
      Choice.create("CreateLandProperty", value$ -> value$.toValue(), value$ ->
        CreateLandProperty.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
        daml.interface$.common.types.PropertyKey>valueDecoder(InstrumentKey.valueDecoder(),
        PropertyKey.valueDecoder()).decode(value$));

  public static final Choice<Service, UpdateLandType, Unit> CHOICE_UpdateLandType = 
      Choice.create("UpdateLandType", value$ -> value$.toValue(), value$ ->
        UpdateLandType.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateApartmentBuildDate, Unit> CHOICE_UpdateApartmentBuildDate = 
      Choice.create("UpdateApartmentBuildDate", value$ -> value$.toValue(), value$ ->
        UpdateApartmentBuildDate.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandViableConstructionTypes, Unit> CHOICE_UpdateLandViableConstructionTypes = 
      Choice.create("UpdateLandViableConstructionTypes", value$ -> value$.toValue(), value$ ->
        UpdateLandViableConstructionTypes.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLandInstalledEquipment, Unit> CHOICE_UpdateLandInstalledEquipment = 
      Choice.create("UpdateLandInstalledEquipment", value$ -> value$.toValue(), value$ ->
        UpdateLandInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

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
    default Update<Exercised<Unit>> exerciseUpdateResidenceFloors(UpdateResidenceFloors arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceFloors, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceFloors(Long newResidenceFloors,
        PropertyKey propertyKey) {
      return exerciseUpdateResidenceFloors(new UpdateResidenceFloors(newResidenceFloors,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseUsableArea(
        UpdateWarehouseUsableArea arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouseUsableArea, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseUsableArea(
        BigDecimal newWarehouseUsableArea, PropertyKey propertyKey) {
      return exerciseUpdateWarehouseUsableArea(new UpdateWarehouseUsableArea(newWarehouseUsableArea,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageAdditionalInformation(
        UpdateGarageAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_UpdateGarageAdditionalInformation, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageAdditionalInformation(
        String newGarageAdditionalInformation, PropertyKey propertyKey) {
      return exerciseUpdateGarageAdditionalInformation(new UpdateGarageAdditionalInformation(newGarageAdditionalInformation,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePrice(UpdateWarehousePrice arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehousePrice, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePrice(BigDecimal newWarehousePrice,
        PropertyKey propertyKey) {
      return exerciseUpdateWarehousePrice(new UpdateWarehousePrice(newWarehousePrice, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentParkingSpaces(
        UpdateApartmentParkingSpaces arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentParkingSpaces, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentParkingSpaces(
        Long newApartmentParkingSpaces, PropertyKey propertyKey) {
      return exerciseUpdateApartmentParkingSpaces(new UpdateApartmentParkingSpaces(newApartmentParkingSpaces,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePropertyPostalCode(
        UpdateResidencePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_UpdateResidencePropertyPostalCode, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePropertyPostalCode(
        String newResidencePropertyPostalCode, PropertyKey propertyKey) {
      return exerciseUpdateResidencePropertyPostalCode(new UpdateResidencePropertyPostalCode(newResidencePropertyPostalCode,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandBuildableFloors(
        UpdateLandBuildableFloors arg) {
      return makeExerciseCmd(CHOICE_UpdateLandBuildableFloors, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandBuildableFloors(Long newLandBuildableFloors,
        PropertyKey propertyKey) {
      return exerciseUpdateLandBuildableFloors(new UpdateLandBuildableFloors(newLandBuildableFloors,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseInstrumentKey(
        UpdateWarehouseInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouseInstrumentKey, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseInstrumentKey(
        InstrumentKey newWarehouseInstrumentKey, PropertyKey propertyKey) {
      return exerciseUpdateWarehouseInstrumentKey(new UpdateWarehouseInstrumentKey(newWarehouseInstrumentKey,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageDescription(UpdateGarageDescription arg) {
      return makeExerciseCmd(CHOICE_UpdateGarageDescription, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageDescription(String newGarageDescription,
        PropertyKey propertyKey) {
      return exerciseUpdateGarageDescription(new UpdateGarageDescription(newGarageDescription,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandBuildableArea(UpdateLandBuildableArea arg) {
      return makeExerciseCmd(CHOICE_UpdateLandBuildableArea, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandBuildableArea(BigDecimal newLandBuildableArea,
        PropertyKey propertyKey) {
      return exerciseUpdateLandBuildableArea(new UpdateLandBuildableArea(newLandBuildableArea,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentElevator(UpdateApartmentElevator arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentElevator, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentElevator(Boolean newApartmentElevator,
        PropertyKey propertyKey) {
      return exerciseUpdateApartmentElevator(new UpdateApartmentElevator(newApartmentElevator,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceBedrooms(UpdateResidenceBedrooms arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceBedrooms, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceBedrooms(Long newResidenceBedrooms,
        PropertyKey propertyKey) {
      return exerciseUpdateResidenceBedrooms(new UpdateResidenceBedrooms(newResidenceBedrooms,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePhotoReferences(
        UpdateResidencePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_UpdateResidencePhotoReferences, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePhotoReferences(
        List<String> newResidencePhotoReferences, PropertyKey propertyKey) {
      return exerciseUpdateResidencePhotoReferences(new UpdateResidencePhotoReferences(newResidencePhotoReferences,
          propertyKey));
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

    default Update<Exercised<Unit>> exerciseUpdateLandAdditionalInformation(
        UpdateLandAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_UpdateLandAdditionalInformation, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandAdditionalInformation(
        String newLandAdditionalInformation, PropertyKey propertyKey) {
      return exerciseUpdateLandAdditionalInformation(new UpdateLandAdditionalInformation(newLandAdditionalInformation,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePropertyAddress(
        UpdateResidencePropertyAddress arg) {
      return makeExerciseCmd(CHOICE_UpdateResidencePropertyAddress, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePropertyAddress(
        String newResidencePropertyAddress, PropertyKey propertyKey) {
      return exerciseUpdateResidencePropertyAddress(new UpdateResidencePropertyAddress(newResidencePropertyAddress,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePropertyDistrict(
        UpdateWarehousePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehousePropertyDistrict, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePropertyDistrict(
        String newWarehousePropertyDistrict, PropertyKey propertyKey) {
      return exerciseUpdateWarehousePropertyDistrict(new UpdateWarehousePropertyDistrict(newWarehousePropertyDistrict,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPropertyAddress(
        UpdateLandPropertyAddress arg) {
      return makeExerciseCmd(CHOICE_UpdateLandPropertyAddress, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPropertyAddress(String newLandPropertyAddress,
        PropertyKey propertyKey) {
      return exerciseUpdateLandPropertyAddress(new UpdateLandPropertyAddress(newLandPropertyAddress,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceDescription(
        UpdateResidenceDescription arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceDescription, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceDescription(
        String newResidenceDescription, PropertyKey propertyKey) {
      return exerciseUpdateResidenceDescription(new UpdateResidenceDescription(newResidenceDescription,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPropertyDistrict(
        UpdateApartmentPropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentPropertyDistrict, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPropertyDistrict(
        String newApartmentPropertyDistrict, PropertyKey propertyKey) {
      return exerciseUpdateApartmentPropertyDistrict(new UpdateApartmentPropertyDistrict(newApartmentPropertyDistrict,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageArea(UpdateGarageArea arg) {
      return makeExerciseCmd(CHOICE_UpdateGarageArea, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageArea(BigDecimal newGarageArea,
        PropertyKey propertyKey) {
      return exerciseUpdateGarageArea(new UpdateGarageArea(newGarageArea, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPrice(UpdateApartmentPrice arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentPrice, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPrice(BigDecimal newApartmentPrice,
        PropertyKey propertyKey) {
      return exerciseUpdateApartmentPrice(new UpdateApartmentPrice(newApartmentPrice, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageType(UpdateGarageType arg) {
      return makeExerciseCmd(CHOICE_UpdateGarageType, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageType(GarageType newGarageType,
        PropertyKey propertyKey) {
      return exerciseUpdateGarageType(new UpdateGarageType(newGarageType, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePropertyDistrict(
        UpdateGaragePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_UpdateGaragePropertyDistrict, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePropertyDistrict(
        String newGaragePropertyDistrict, PropertyKey propertyKey) {
      return exerciseUpdateGaragePropertyDistrict(new UpdateGaragePropertyDistrict(newGaragePropertyDistrict,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPropertyCounty(
        UpdateApartmentPropertyCounty arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentPropertyCounty, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPropertyCounty(
        String newApartmentPropertyCounty, PropertyKey propertyKey) {
      return exerciseUpdateApartmentPropertyCounty(new UpdateApartmentPropertyCounty(newApartmentPropertyCounty,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceInstalledEquipment(
        UpdateResidenceInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceInstalledEquipment, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceInstalledEquipment(
        String newResidenceInstalledEquipment, PropertyKey propertyKey) {
      return exerciseUpdateResidenceInstalledEquipment(new UpdateResidenceInstalledEquipment(newResidenceInstalledEquipment,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateVehicleCapacity(UpdateVehicleCapacity arg) {
      return makeExerciseCmd(CHOICE_UpdateVehicleCapacity, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateVehicleCapacity(Long newVehicleCapacity,
        PropertyKey propertyKey) {
      return exerciseUpdateVehicleCapacity(new UpdateVehicleCapacity(newVehicleCapacity,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePropertyCounty(
        UpdateResidencePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_UpdateResidencePropertyCounty, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePropertyCounty(
        String newResidencePropertyCounty, PropertyKey propertyKey) {
      return exerciseUpdateResidencePropertyCounty(new UpdateResidencePropertyCounty(newResidencePropertyCounty,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceBackyard(UpdateResidenceBackyard arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceBackyard, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceBackyard(
        String newResidenceBackyardDescription, PropertyKey propertyKey) {
      return exerciseUpdateResidenceBackyard(new UpdateResidenceBackyard(newResidenceBackyardDescription,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentUsableArea(
        UpdateApartmentUsableArea arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentUsableArea, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentUsableArea(
        BigDecimal newApartmentUsableArea, PropertyKey propertyKey) {
      return exerciseUpdateApartmentUsableArea(new UpdateApartmentUsableArea(newApartmentUsableArea,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseAdditionalInformation(
        UpdateWarehouseAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouseAdditionalInformation, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseAdditionalInformation(
        String newWarehouseAdditionalInformation, PropertyKey propertyKey) {
      return exerciseUpdateWarehouseAdditionalInformation(new UpdateWarehouseAdditionalInformation(newWarehouseAdditionalInformation,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePrice(UpdateResidencePrice arg) {
      return makeExerciseCmd(CHOICE_UpdateResidencePrice, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePrice(BigDecimal newResidencePrice,
        PropertyKey propertyKey) {
      return exerciseUpdateResidencePrice(new UpdateResidencePrice(newResidencePrice, propertyKey));
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateResidenceProperty(
        CreateResidenceProperty arg) {
      return makeExerciseCmd(CHOICE_CreateResidenceProperty, arg);
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateResidenceProperty(
        daml.interface$.propertymanager.choices.requestcreateresidenceproperty.RequestCreateResidenceProperty.ContractId createResidencePropertyRequest) {
      return exerciseCreateResidenceProperty(new CreateResidenceProperty(createResidencePropertyRequest));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPrice(UpdateLandPrice arg) {
      return makeExerciseCmd(CHOICE_UpdateLandPrice, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPrice(BigDecimal newLandPrice,
        PropertyKey propertyKey) {
      return exerciseUpdateLandPrice(new UpdateLandPrice(newLandPrice, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceInstrumentKey(
        UpdateResidenceInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceInstrumentKey, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceInstrumentKey(
        InstrumentKey newResidenceInstrumentKey, PropertyKey propertyKey) {
      return exerciseUpdateResidenceInstrumentKey(new UpdateResidenceInstrumentKey(newResidenceInstrumentKey,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPropertyAddress(
        UpdateApartmentPropertyAddress arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentPropertyAddress, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPropertyAddress(
        String newApartmentPropertyAddress, PropertyKey propertyKey) {
      return exerciseUpdateApartmentPropertyAddress(new UpdateApartmentPropertyAddress(newApartmentPropertyAddress,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePropertyAddress(
        UpdateGaragePropertyAddress arg) {
      return makeExerciseCmd(CHOICE_UpdateGaragePropertyAddress, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePropertyAddress(
        String newGaragePropertyAddress, PropertyKey propertyKey) {
      return exerciseUpdateGaragePropertyAddress(new UpdateGaragePropertyAddress(newGaragePropertyAddress,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePropertyPostalCode(
        UpdateGaragePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_UpdateGaragePropertyPostalCode, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePropertyPostalCode(
        String newGaragePropertyPostalCode, PropertyKey propertyKey) {
      return exerciseUpdateGaragePropertyPostalCode(new UpdateGaragePropertyPostalCode(newGaragePropertyPostalCode,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceAdditionalInformation(
        UpdateResidenceAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceAdditionalInformation, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceAdditionalInformation(
        String newResidenceAdditionalInformation, PropertyKey propertyKey) {
      return exerciseUpdateResidenceAdditionalInformation(new UpdateResidenceAdditionalInformation(newResidenceAdditionalInformation,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceBathrooms(UpdateResidenceBathrooms arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceBathrooms, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceBathrooms(Long newResidenceBathrooms,
        PropertyKey propertyKey) {
      return exerciseUpdateResidenceBathrooms(new UpdateResidenceBathrooms(newResidenceBathrooms,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseInstalledEquipment(
        UpdateWarehouseInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouseInstalledEquipment, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseInstalledEquipment(
        String newWarehouseInstalledEquipment, PropertyKey propertyKey) {
      return exerciseUpdateWarehouseInstalledEquipment(new UpdateWarehouseInstalledEquipment(newWarehouseInstalledEquipment,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentAdditionalInformation(
        UpdateApartmentAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentAdditionalInformation, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentAdditionalInformation(
        String newApartmentAdditionalInformation, PropertyKey propertyKey) {
      return exerciseUpdateApartmentAdditionalInformation(new UpdateApartmentAdditionalInformation(newApartmentAdditionalInformation,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageInstalledEquipment(
        UpdateGarageInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_UpdateGarageInstalledEquipment, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageInstalledEquipment(
        String newGarageInstalledEquipment, PropertyKey propertyKey) {
      return exerciseUpdateGarageInstalledEquipment(new UpdateGarageInstalledEquipment(newGarageInstalledEquipment,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseGrossArea(UpdateWarehouseGrossArea arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouseGrossArea, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseGrossArea(
        BigDecimal newWarehouseGrossArea, PropertyKey propertyKey) {
      return exerciseUpdateWarehouseGrossArea(new UpdateWarehouseGrossArea(newWarehouseGrossArea,
          propertyKey));
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateWarehouseProperty(
        CreateWarehouseProperty arg) {
      return makeExerciseCmd(CHOICE_CreateWarehouseProperty, arg);
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateWarehouseProperty(
        daml.interface$.propertymanager.choices.requestcreatewarehouseproperty.RequestCreateWarehouseProperty.ContractId createWarehousePropertyRequest) {
      return exerciseCreateWarehouseProperty(new CreateWarehouseProperty(createWarehousePropertyRequest));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePropertyCounty(
        UpdateWarehousePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehousePropertyCounty, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePropertyCounty(
        String newWarehousePropertyCounty, PropertyKey propertyKey) {
      return exerciseUpdateWarehousePropertyCounty(new UpdateWarehousePropertyCounty(newWarehousePropertyCounty,
          propertyKey));
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateApartmentProperty(
        CreateApartmentProperty arg) {
      return makeExerciseCmd(CHOICE_CreateApartmentProperty, arg);
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateApartmentProperty(
        daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId createApartmentPropertyRequest) {
      return exerciseCreateApartmentProperty(new CreateApartmentProperty(createApartmentPropertyRequest));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceParking(UpdateResidenceParking arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceParking, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceParking(Parking newResidenceParking,
        PropertyKey propertyKey) {
      return exerciseUpdateResidenceParking(new UpdateResidenceParking(newResidenceParking,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentDescription(
        UpdateApartmentDescription arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentDescription, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentDescription(
        String newApartmentDescription, PropertyKey propertyKey) {
      return exerciseUpdateApartmentDescription(new UpdateApartmentDescription(newApartmentDescription,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePropertyCounty(
        UpdateGaragePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_UpdateGaragePropertyCounty, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePropertyCounty(
        String newGaragePropertyCounty, PropertyKey propertyKey) {
      return exerciseUpdateGaragePropertyCounty(new UpdateGaragePropertyCounty(newGaragePropertyCounty,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPropertyCounty(UpdateLandPropertyCounty arg) {
      return makeExerciseCmd(CHOICE_UpdateLandPropertyCounty, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPropertyCounty(String newLandPropertyCounty,
        PropertyKey propertyKey) {
      return exerciseUpdateLandPropertyCounty(new UpdateLandPropertyCounty(newLandPropertyCounty,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPropertyPostalCode(
        UpdateApartmentPropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentPropertyPostalCode, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPropertyPostalCode(
        String newApartmentPropertyPostalCode, PropertyKey propertyKey) {
      return exerciseUpdateApartmentPropertyPostalCode(new UpdateApartmentPropertyPostalCode(newApartmentPropertyPostalCode,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseFloors(UpdateWarehouseFloors arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouseFloors, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseFloors(Long newWarehouseFloors,
        PropertyKey propertyKey) {
      return exerciseUpdateWarehouseFloors(new UpdateWarehouseFloors(newWarehouseFloors,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentBedrooms(UpdateApartmentBedrooms arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentBedrooms, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentBedrooms(Long newApartmentBedrooms,
        PropertyKey propertyKey) {
      return exerciseUpdateApartmentBedrooms(new UpdateApartmentBedrooms(newApartmentBedrooms,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePhotoReferences(
        UpdateGaragePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_UpdateGaragePhotoReferences, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePhotoReferences(
        List<String> newGaragePhotoReferences, PropertyKey propertyKey) {
      return exerciseUpdateGaragePhotoReferences(new UpdateGaragePhotoReferences(newGaragePhotoReferences,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePropertyPostalCode(
        UpdateWarehousePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehousePropertyPostalCode, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePropertyPostalCode(
        String newWarehousePropertyPostalCode, PropertyKey propertyKey) {
      return exerciseUpdateWarehousePropertyPostalCode(new UpdateWarehousePropertyPostalCode(newWarehousePropertyPostalCode,
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

    default Update<Exercised<Unit>> exerciseUpdateResidenceBuildDate(UpdateResidenceBuildDate arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceBuildDate, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceBuildDate(
        LocalDate newResidenceBuildDate, PropertyKey propertyKey) {
      return exerciseUpdateResidenceBuildDate(new UpdateResidenceBuildDate(newResidenceBuildDate,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseDescription(
        UpdateWarehouseDescription arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouseDescription, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseDescription(
        String newWarehouseDescription, PropertyKey propertyKey) {
      return exerciseUpdateWarehouseDescription(new UpdateWarehouseDescription(newWarehouseDescription,
          propertyKey));
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

    default Update<Exercised<Unit>> exerciseUpdateResidenceType(UpdateResidenceType arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceType, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceType(ResidenceType newResidenceType,
        PropertyKey propertyKey) {
      return exerciseUpdateResidenceType(new UpdateResidenceType(newResidenceType, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePropertyDistrict(
        UpdateResidencePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_UpdateResidencePropertyDistrict, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidencePropertyDistrict(
        String newResidencePropertyDistrict, PropertyKey propertyKey) {
      return exerciseUpdateResidencePropertyDistrict(new UpdateResidencePropertyDistrict(newResidencePropertyDistrict,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePrice(UpdateGaragePrice arg) {
      return makeExerciseCmd(CHOICE_UpdateGaragePrice, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGaragePrice(BigDecimal newGaragePrice,
        PropertyKey propertyKey) {
      return exerciseUpdateGaragePrice(new UpdateGaragePrice(newGaragePrice, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentInstalledEquipment(
        UpdateApartmentInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentInstalledEquipment, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentInstalledEquipment(
        String newApartmentInstalledEquipment, PropertyKey propertyKey) {
      return exerciseUpdateApartmentInstalledEquipment(new UpdateApartmentInstalledEquipment(newApartmentInstalledEquipment,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentInstrumentKey(
        UpdateApartmentInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentInstrumentKey, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentInstrumentKey(
        InstrumentKey newApartmentInstrumentKey, PropertyKey propertyKey) {
      return exerciseUpdateApartmentInstrumentKey(new UpdateApartmentInstrumentKey(newApartmentInstrumentKey,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandAccessByRoad(UpdateLandAccessByRoad arg) {
      return makeExerciseCmd(CHOICE_UpdateLandAccessByRoad, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandAccessByRoad(Boolean newLandAccessByRoad,
        PropertyKey propertyKey) {
      return exerciseUpdateLandAccessByRoad(new UpdateLandAccessByRoad(newLandAccessByRoad,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseBuildDate(UpdateWarehouseBuildDate arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouseBuildDate, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseBuildDate(
        LocalDate newWarehouseBuildDate, PropertyKey propertyKey) {
      return exerciseUpdateWarehouseBuildDate(new UpdateWarehouseBuildDate(newWarehouseBuildDate,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPropertyDistrict(
        UpdateLandPropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_UpdateLandPropertyDistrict, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPropertyDistrict(
        String newLandPropertyDistrict, PropertyKey propertyKey) {
      return exerciseUpdateLandPropertyDistrict(new UpdateLandPropertyDistrict(newLandPropertyDistrict,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateTotalLandArea(UpdateTotalLandArea arg) {
      return makeExerciseCmd(CHOICE_UpdateTotalLandArea, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateTotalLandArea(BigDecimal newTotalLandArea,
        PropertyKey propertyKey) {
      return exerciseUpdateTotalLandArea(new UpdateTotalLandArea(newTotalLandArea, propertyKey));
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

    default Update<Exercised<Unit>> exerciseUpdateResidenceOrientation(
        UpdateResidenceOrientation arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceOrientation, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceOrientation(
        Orientation newResidenceOrientation, PropertyKey propertyKey) {
      return exerciseUpdateResidenceOrientation(new UpdateResidenceOrientation(newResidenceOrientation,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPropertyPostalCode(
        UpdateLandPropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_UpdateLandPropertyPostalCode, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPropertyPostalCode(
        String newLandPropertyPostalCode, PropertyKey propertyKey) {
      return exerciseUpdateLandPropertyPostalCode(new UpdateLandPropertyPostalCode(newLandPropertyPostalCode,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPhotoReferences(
        UpdateLandPhotoReferences arg) {
      return makeExerciseCmd(CHOICE_UpdateLandPhotoReferences, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandPhotoReferences(
        List<String> newLandPhotoReferences, PropertyKey propertyKey) {
      return exerciseUpdateLandPhotoReferences(new UpdateLandPhotoReferences(newLandPhotoReferences,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentFloor(UpdateApartmentFloor arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentFloor, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentFloor(Long newApartmentFloor,
        PropertyKey propertyKey) {
      return exerciseUpdateApartmentFloor(new UpdateApartmentFloor(newApartmentFloor, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandInstrumentKey(UpdateLandInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_UpdateLandInstrumentKey, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandInstrumentKey(
        InstrumentKey newLandInstrumentKey, PropertyKey propertyKey) {
      return exerciseUpdateLandInstrumentKey(new UpdateLandInstrumentKey(newLandInstrumentKey,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateMinimumSurfaceForSale(
        UpdateMinimumSurfaceForSale arg) {
      return makeExerciseCmd(CHOICE_UpdateMinimumSurfaceForSale, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateMinimumSurfaceForSale(
        BigDecimal newLandMinimumSurfaceForSale, PropertyKey propertyKey) {
      return exerciseUpdateMinimumSurfaceForSale(new UpdateMinimumSurfaceForSale(newLandMinimumSurfaceForSale,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandDescription(UpdateLandDescription arg) {
      return makeExerciseCmd(CHOICE_UpdateLandDescription, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandDescription(String newLandDescription,
        PropertyKey propertyKey) {
      return exerciseUpdateLandDescription(new UpdateLandDescription(newLandDescription,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentBathrooms(UpdateApartmentBathrooms arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentBathrooms, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentBathrooms(Long newApartmentBathrooms,
        PropertyKey propertyKey) {
      return exerciseUpdateApartmentBathrooms(new UpdateApartmentBathrooms(newApartmentBathrooms,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseType(UpdateWarehouseType arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouseType, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehouseType(WarehouseType newWarehouseType,
        PropertyKey propertyKey) {
      return exerciseUpdateWarehouseType(new UpdateWarehouseType(newWarehouseType, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentGrossArea(UpdateApartmentGrossArea arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentGrossArea, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentGrossArea(
        BigDecimal newApartmentGrossArea, PropertyKey propertyKey) {
      return exerciseUpdateApartmentGrossArea(new UpdateApartmentGrossArea(newApartmentGrossArea,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePhotoReferences(
        UpdateWarehousePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehousePhotoReferences, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePhotoReferences(
        List<String> newWarehousePhotoReferences, PropertyKey propertyKey) {
      return exerciseUpdateWarehousePhotoReferences(new UpdateWarehousePhotoReferences(newWarehousePhotoReferences,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageInstrumentKey(
        UpdateGarageInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_UpdateGarageInstrumentKey, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGarageInstrumentKey(
        InstrumentKey newGarageInstrumentKey, PropertyKey propertyKey) {
      return exerciseUpdateGarageInstrumentKey(new UpdateGarageInstrumentKey(newGarageInstrumentKey,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePropertyAddress(
        UpdateWarehousePropertyAddress arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehousePropertyAddress, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateWarehousePropertyAddress(
        String newWarehousePropertyAddress, PropertyKey propertyKey) {
      return exerciseUpdateWarehousePropertyAddress(new UpdateWarehousePropertyAddress(newWarehousePropertyAddress,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceGrossArea(UpdateResidenceGrossArea arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceGrossArea, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceGrossArea(
        BigDecimal newResidenceGrossArea, PropertyKey propertyKey) {
      return exerciseUpdateResidenceGrossArea(new UpdateResidenceGrossArea(newResidenceGrossArea,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPhotoReferences(
        UpdateApartmentPhotoReferences arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentPhotoReferences, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentPhotoReferences(
        List<String> newApartmentPhotoReferences, PropertyKey propertyKey) {
      return exerciseUpdateApartmentPhotoReferences(new UpdateApartmentPhotoReferences(newApartmentPhotoReferences,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceUsableArea(
        UpdateResidenceUsableArea arg) {
      return makeExerciseCmd(CHOICE_UpdateResidenceUsableArea, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateResidenceUsableArea(
        BigDecimal newResidenceUsableArea, PropertyKey propertyKey) {
      return exerciseUpdateResidenceUsableArea(new UpdateResidenceUsableArea(newResidenceUsableArea,
          propertyKey));
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateLandProperty(
        CreateLandProperty arg) {
      return makeExerciseCmd(CHOICE_CreateLandProperty, arg);
    }

    default Update<Exercised<Tuple2<InstrumentKey, PropertyKey>>> exerciseCreateLandProperty(
        daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId createLandPropertyRequest) {
      return exerciseCreateLandProperty(new CreateLandProperty(createLandPropertyRequest));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandType(UpdateLandType arg) {
      return makeExerciseCmd(CHOICE_UpdateLandType, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandType(LandType newLandType,
        PropertyKey propertyKey) {
      return exerciseUpdateLandType(new UpdateLandType(newLandType, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentBuildDate(UpdateApartmentBuildDate arg) {
      return makeExerciseCmd(CHOICE_UpdateApartmentBuildDate, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateApartmentBuildDate(
        LocalDate newApartmentBuildDate, PropertyKey propertyKey) {
      return exerciseUpdateApartmentBuildDate(new UpdateApartmentBuildDate(newApartmentBuildDate,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandViableConstructionTypes(
        UpdateLandViableConstructionTypes arg) {
      return makeExerciseCmd(CHOICE_UpdateLandViableConstructionTypes, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandViableConstructionTypes(
        List<ViableConstructionTypes> newLandViableConstructionTypes, PropertyKey propertyKey) {
      return exerciseUpdateLandViableConstructionTypes(new UpdateLandViableConstructionTypes(newLandViableConstructionTypes,
          propertyKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLandInstalledEquipment(
        UpdateLandInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_UpdateLandInstalledEquipment, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLandInstalledEquipment(
        String newLandInstalledEquipment, PropertyKey propertyKey) {
      return exerciseUpdateLandInstalledEquipment(new UpdateLandInstalledEquipment(newLandInstalledEquipment,
          propertyKey));
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
            View::fromJson,List.of(CHOICE_UpdateApartmentInstalledEquipment,
            CHOICE_UpdateLandViableConstructionTypes, CHOICE_UpdateWarehouseInstalledEquipment,
            CHOICE_UpdateApartmentPrice, CHOICE_UpdateApartmentPropertyDistrict,
            CHOICE_UpdateApartmentPhotoReferences, CHOICE_UpdateApartmentBedrooms,
            CHOICE_UpdateGaragePropertyAddress, CHOICE_RequestCreateResidenceProperty,
            CHOICE_UpdateApartmentPropertyCounty, CHOICE_UpdateApartmentPropertyAddress,
            CHOICE_UpdateGarageAdditionalInformation, CHOICE_UpdateWarehousePropertyPostalCode,
            CHOICE_RequestCreateLandProperty, CHOICE_UpdateVehicleCapacity,
            CHOICE_UpdateApartmentPropertyPostalCode, CHOICE_UpdateResidenceAdditionalInformation,
            CHOICE_UpdateTotalLandArea, CHOICE_UpdateLandAdditionalInformation,
            CHOICE_UpdateResidencePropertyPostalCode, CHOICE_UpdateLandPropertyPostalCode,
            CHOICE_UpdateWarehouseDescription, CHOICE_CreateApartmentProperty,
            CHOICE_UpdateApartmentDescription, CHOICE_UpdateResidenceInstrumentKey,
            CHOICE_UpdateResidenceUsableArea, CHOICE_UpdateResidencePropertyCounty,
            CHOICE_UpdateLandPropertyAddress, CHOICE_UpdateApartmentParkingSpaces,
            CHOICE_CreateLandProperty, CHOICE_UpdateApartmentElevator, CHOICE_UpdateGarageArea,
            CHOICE_UpdateWarehouseGrossArea, CHOICE_UpdateGaragePropertyDistrict,
            CHOICE_UpdateLandInstrumentKey, CHOICE_UpdateResidencePropertyAddress,
            CHOICE_UpdateWarehouseUsableArea, CHOICE_UpdateResidencePrice,
            CHOICE_UpdateGarageInstrumentKey, CHOICE_UpdateResidencePropertyDistrict,
            CHOICE_UpdateApartmentInstrumentKey, CHOICE_UpdateApartmentBathrooms,
            CHOICE_UpdateApartmentFloor, CHOICE_CreateGarageProperty,
            CHOICE_UpdateMinimumSurfaceForSale, CHOICE_UpdateApartmentUsableArea,
            CHOICE_UpdateGarageInstalledEquipment, CHOICE_UpdateGaragePropertyCounty,
            CHOICE_UpdateLandPhotoReferences, CHOICE_UpdateGaragePrice,
            CHOICE_UpdateLandAccessByRoad, CHOICE_UpdateResidenceType,
            CHOICE_UpdateResidenceDescription, CHOICE_CreateResidenceProperty,
            CHOICE_UpdateWarehouseFloors, CHOICE_UpdateResidencePhotoReferences,
            CHOICE_UpdateWarehousePrice, CHOICE_UpdateLandPropertyCounty, CHOICE_UpdateLandType,
            CHOICE_UpdateGaragePhotoReferences, CHOICE_UpdateLandBuildableFloors,
            CHOICE_UpdateLandDescription, CHOICE_UpdateResidenceFloors,
            CHOICE_UpdateWarehousePhotoReferences, CHOICE_CreateWarehouseProperty,
            CHOICE_RequestCreateWarehouseProperty, CHOICE_Archive, CHOICE_UpdateWarehouseType,
            CHOICE_UpdateResidenceBuildDate, CHOICE_UpdateGarageDescription,
            CHOICE_UpdateResidenceBackyard, CHOICE_UpdateWarehouseAdditionalInformation,
            CHOICE_RequestCreateGarageProperty, CHOICE_UpdateWarehouseBuildDate,
            CHOICE_UpdateWarehousePropertyAddress, CHOICE_UpdateLandBuildableArea,
            CHOICE_UpdateWarehousePropertyDistrict, CHOICE_UpdateGarageType,
            CHOICE_UpdateApartmentAdditionalInformation, CHOICE_UpdateResidenceInstalledEquipment,
            CHOICE_UpdateWarehousePropertyCounty, CHOICE_UpdateResidenceGrossArea,
            CHOICE_UpdateLandPrice, CHOICE_UpdateResidenceOrientation,
            CHOICE_RequestCreateApartmentProperty, CHOICE_UpdateResidenceBathrooms,
            CHOICE_UpdateLandPropertyDistrict, CHOICE_UpdateResidenceBedrooms,
            CHOICE_UpdateResidenceParking, CHOICE_UpdateApartmentGrossArea,
            CHOICE_UpdateApartmentBuildDate, CHOICE_UpdateGaragePropertyPostalCode,
            CHOICE_UpdateWarehouseInstrumentKey, CHOICE_UpdateLandInstalledEquipment));
    }
  }
}
