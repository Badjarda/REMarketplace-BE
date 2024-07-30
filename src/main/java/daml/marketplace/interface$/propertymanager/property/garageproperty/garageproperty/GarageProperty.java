package daml.interface$.propertymanager.property.garageproperty.garageproperty;

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
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.interface$.propertymanager.property.common.GarageType;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.List;

public final class GarageProperty {
  public static final Identifier TEMPLATE_ID = new Identifier("e09e7a18c217e8002e4a374c04915d394e5120e173ac8f1ee6decbc2d8c3c8b4", "Interface.PropertyManager.Property.GarageProperty.GarageProperty", "GarageProperty");

  public static final Choice<GarageProperty, GetGaragePropertyAddress, String> CHOICE_GetGaragePropertyAddress = 
      Choice.create("GetGaragePropertyAddress", value$ -> value$.toValue(), value$ ->
        GetGaragePropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, GetGaragePropertyDistrict, String> CHOICE_GetGaragePropertyDistrict = 
      Choice.create("GetGaragePropertyDistrict", value$ -> value$.toValue(), value$ ->
        GetGaragePropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, SetGarageDescription, ContractId> CHOICE_SetGarageDescription = 
      Choice.create("SetGarageDescription", value$ -> value$.toValue(), value$ ->
        SetGarageDescription.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, GetGaragePropertyCounty, String> CHOICE_GetGaragePropertyCounty = 
      Choice.create("GetGaragePropertyCounty", value$ -> value$.toValue(), value$ ->
        GetGaragePropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, SetGaragePhotoReferences, ContractId> CHOICE_SetGaragePhotoReferences = 
      Choice.create("SetGaragePhotoReferences", value$ -> value$.toValue(), value$ ->
        SetGaragePhotoReferences.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, GetGarageAdditionalInformation, String> CHOICE_GetGarageAdditionalInformation = 
      Choice.create("GetGarageAdditionalInformation", value$ -> value$.toValue(), value$ ->
        GetGarageAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, SetGaragePropertyAddress, ContractId> CHOICE_SetGaragePropertyAddress = 
      Choice.create("SetGaragePropertyAddress", value$ -> value$.toValue(), value$ ->
        SetGaragePropertyAddress.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<GarageProperty, GetGarageInstalledEquipment, String> CHOICE_GetGarageInstalledEquipment = 
      Choice.create("GetGarageInstalledEquipment", value$ -> value$.toValue(), value$ ->
        GetGarageInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, GetGarageType, GarageType> CHOICE_GetGarageType = 
      Choice.create("GetGarageType", value$ -> value$.toValue(), value$ ->
        GetGarageType.valueDecoder().decode(value$), value$ -> GarageType.valueDecoder()
        .decode(value$));

  public static final Choice<GarageProperty, SetGarageType, ContractId> CHOICE_SetGarageType = 
      Choice.create("SetGarageType", value$ -> value$.toValue(), value$ ->
        SetGarageType.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, SetGarageInstalledEquipment, ContractId> CHOICE_SetGarageInstalledEquipment = 
      Choice.create("SetGarageInstalledEquipment", value$ -> value$.toValue(), value$ ->
        SetGarageInstalledEquipment.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, SetGaragePropertyPostalCode, ContractId> CHOICE_SetGaragePropertyPostalCode = 
      Choice.create("SetGaragePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        SetGaragePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, GetGaragePropertyPostalCode, String> CHOICE_GetGaragePropertyPostalCode = 
      Choice.create("GetGaragePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        GetGaragePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<GarageProperty, SetGaragePropertyDistrict, ContractId> CHOICE_SetGaragePropertyDistrict = 
      Choice.create("SetGaragePropertyDistrict", value$ -> value$.toValue(), value$ ->
        SetGaragePropertyDistrict.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, GetGarageDescription, String> CHOICE_GetGarageDescription = 
      Choice.create("GetGarageDescription", value$ -> value$.toValue(), value$ ->
        GetGarageDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, GetGarageArea, BigDecimal> CHOICE_GetGarageArea = 
      Choice.create("GetGarageArea", value$ -> value$.toValue(), value$ ->
        GetGarageArea.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromNumeric
        .decode(value$));

  public static final Choice<GarageProperty, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<GarageProperty, SetGarageAdditionalInformation, ContractId> CHOICE_SetGarageAdditionalInformation = 
      Choice.create("SetGarageAdditionalInformation", value$ -> value$.toValue(), value$ ->
        SetGarageAdditionalInformation.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, SetGaragePropertyCounty, ContractId> CHOICE_SetGaragePropertyCounty = 
      Choice.create("SetGaragePropertyCounty", value$ -> value$.toValue(), value$ ->
        SetGaragePropertyCounty.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, GetGaragePrice, BigDecimal> CHOICE_GetGaragePrice = 
      Choice.create("GetGaragePrice", value$ -> value$.toValue(), value$ ->
        GetGaragePrice.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromNumeric
        .decode(value$));

  public static final Choice<GarageProperty, GetGaragePhotoReferences, List<String>> CHOICE_GetGaragePhotoReferences = 
      Choice.create("GetGaragePhotoReferences", value$ -> value$.toValue(), value$ ->
        GetGaragePhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromText).decode(value$));

  public static final Choice<GarageProperty, SetVehicleCapacity, ContractId> CHOICE_SetVehicleCapacity = 
      Choice.create("SetVehicleCapacity", value$ -> value$.toValue(), value$ ->
        SetVehicleCapacity.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, SetGaragePrice, ContractId> CHOICE_SetGaragePrice = 
      Choice.create("SetGaragePrice", value$ -> value$.toValue(), value$ ->
        SetGaragePrice.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, GetVehicleCapacity, Long> CHOICE_GetVehicleCapacity = 
      Choice.create("GetVehicleCapacity", value$ -> value$.toValue(), value$ ->
        GetVehicleCapacity.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromInt64
        .decode(value$));

  public static final Choice<GarageProperty, SetGarageInstrumentKey, ContractId> CHOICE_SetGarageInstrumentKey = 
      Choice.create("SetGarageInstrumentKey", value$ -> value$.toValue(), value$ ->
        SetGarageInstrumentKey.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, GetGarageInstrumentKey, InstrumentKey> CHOICE_GetGarageInstrumentKey = 
      Choice.create("GetGarageInstrumentKey", value$ -> value$.toValue(), value$ ->
        GetGarageInstrumentKey.valueDecoder().decode(value$), value$ -> InstrumentKey.valueDecoder()
        .decode(value$));

  public static final Choice<GarageProperty, SetGarageArea, ContractId> CHOICE_SetGarageArea = 
      Choice.create("SetGarageArea", value$ -> value$.toValue(), value$ ->
        SetGarageArea.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private GarageProperty() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<GarageProperty> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, GarageProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<String>> exerciseGetGaragePropertyAddress(
        GetGaragePropertyAddress arg) {
      return makeExerciseCmd(CHOICE_GetGaragePropertyAddress, arg);
    }

    default Update<Exercised<String>> exerciseGetGaragePropertyAddress() {
      return exerciseGetGaragePropertyAddress(new GetGaragePropertyAddress());
    }

    default Update<Exercised<String>> exerciseGetGaragePropertyDistrict(
        GetGaragePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_GetGaragePropertyDistrict, arg);
    }

    default Update<Exercised<String>> exerciseGetGaragePropertyDistrict() {
      return exerciseGetGaragePropertyDistrict(new GetGaragePropertyDistrict());
    }

    default Update<Exercised<ContractId>> exerciseSetGarageDescription(SetGarageDescription arg) {
      return makeExerciseCmd(CHOICE_SetGarageDescription, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGarageDescription(
        String newGarageDescription) {
      return exerciseSetGarageDescription(new SetGarageDescription(newGarageDescription));
    }

    default Update<Exercised<String>> exerciseGetGaragePropertyCounty(GetGaragePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_GetGaragePropertyCounty, arg);
    }

    default Update<Exercised<String>> exerciseGetGaragePropertyCounty() {
      return exerciseGetGaragePropertyCounty(new GetGaragePropertyCounty());
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePhotoReferences(
        SetGaragePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_SetGaragePhotoReferences, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePhotoReferences(
        List<String> newPhotoReferences) {
      return exerciseSetGaragePhotoReferences(new SetGaragePhotoReferences(newPhotoReferences));
    }

    default Update<Exercised<String>> exerciseGetGarageAdditionalInformation(
        GetGarageAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_GetGarageAdditionalInformation, arg);
    }

    default Update<Exercised<String>> exerciseGetGarageAdditionalInformation() {
      return exerciseGetGarageAdditionalInformation(new GetGarageAdditionalInformation());
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePropertyAddress(
        SetGaragePropertyAddress arg) {
      return makeExerciseCmd(CHOICE_SetGaragePropertyAddress, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePropertyAddress(
        String newGaragePropertyAddress) {
      return exerciseSetGaragePropertyAddress(new SetGaragePropertyAddress(newGaragePropertyAddress));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<String>> exerciseGetGarageInstalledEquipment(
        GetGarageInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_GetGarageInstalledEquipment, arg);
    }

    default Update<Exercised<String>> exerciseGetGarageInstalledEquipment() {
      return exerciseGetGarageInstalledEquipment(new GetGarageInstalledEquipment());
    }

    default Update<Exercised<GarageType>> exerciseGetGarageType(GetGarageType arg) {
      return makeExerciseCmd(CHOICE_GetGarageType, arg);
    }

    default Update<Exercised<GarageType>> exerciseGetGarageType() {
      return exerciseGetGarageType(new GetGarageType());
    }

    default Update<Exercised<ContractId>> exerciseSetGarageType(SetGarageType arg) {
      return makeExerciseCmd(CHOICE_SetGarageType, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGarageType(GarageType newGarageType) {
      return exerciseSetGarageType(new SetGarageType(newGarageType));
    }

    default Update<Exercised<ContractId>> exerciseSetGarageInstalledEquipment(
        SetGarageInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_SetGarageInstalledEquipment, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGarageInstalledEquipment(
        String newGarageInstalledEquipment) {
      return exerciseSetGarageInstalledEquipment(new SetGarageInstalledEquipment(newGarageInstalledEquipment));
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePropertyPostalCode(
        SetGaragePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_SetGaragePropertyPostalCode, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePropertyPostalCode(
        String newGaragePropertyPostalCode) {
      return exerciseSetGaragePropertyPostalCode(new SetGaragePropertyPostalCode(newGaragePropertyPostalCode));
    }

    default Update<Exercised<String>> exerciseGetGaragePropertyPostalCode(
        GetGaragePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_GetGaragePropertyPostalCode, arg);
    }

    default Update<Exercised<String>> exerciseGetGaragePropertyPostalCode() {
      return exerciseGetGaragePropertyPostalCode(new GetGaragePropertyPostalCode());
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePropertyDistrict(
        SetGaragePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_SetGaragePropertyDistrict, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePropertyDistrict(
        String newGaragePropertyDistrict) {
      return exerciseSetGaragePropertyDistrict(new SetGaragePropertyDistrict(newGaragePropertyDistrict));
    }

    default Update<Exercised<String>> exerciseGetGarageDescription(GetGarageDescription arg) {
      return makeExerciseCmd(CHOICE_GetGarageDescription, arg);
    }

    default Update<Exercised<String>> exerciseGetGarageDescription() {
      return exerciseGetGarageDescription(new GetGarageDescription());
    }

    default Update<Exercised<BigDecimal>> exerciseGetGarageArea(GetGarageArea arg) {
      return makeExerciseCmd(CHOICE_GetGarageArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetGarageArea() {
      return exerciseGetGarageArea(new GetGarageArea());
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<ContractId>> exerciseSetGarageAdditionalInformation(
        SetGarageAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_SetGarageAdditionalInformation, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGarageAdditionalInformation(
        String newGarageAdditionalInformation) {
      return exerciseSetGarageAdditionalInformation(new SetGarageAdditionalInformation(newGarageAdditionalInformation));
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePropertyCounty(
        SetGaragePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_SetGaragePropertyCounty, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePropertyCounty(
        String newGaragePropertyCounty) {
      return exerciseSetGaragePropertyCounty(new SetGaragePropertyCounty(newGaragePropertyCounty));
    }

    default Update<Exercised<BigDecimal>> exerciseGetGaragePrice(GetGaragePrice arg) {
      return makeExerciseCmd(CHOICE_GetGaragePrice, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetGaragePrice() {
      return exerciseGetGaragePrice(new GetGaragePrice());
    }

    default Update<Exercised<List<String>>> exerciseGetGaragePhotoReferences(
        GetGaragePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_GetGaragePhotoReferences, arg);
    }

    default Update<Exercised<List<String>>> exerciseGetGaragePhotoReferences() {
      return exerciseGetGaragePhotoReferences(new GetGaragePhotoReferences());
    }

    default Update<Exercised<ContractId>> exerciseSetVehicleCapacity(SetVehicleCapacity arg) {
      return makeExerciseCmd(CHOICE_SetVehicleCapacity, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetVehicleCapacity(Long newVehicleCapacity) {
      return exerciseSetVehicleCapacity(new SetVehicleCapacity(newVehicleCapacity));
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePrice(SetGaragePrice arg) {
      return makeExerciseCmd(CHOICE_SetGaragePrice, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGaragePrice(BigDecimal newGaragePrice) {
      return exerciseSetGaragePrice(new SetGaragePrice(newGaragePrice));
    }

    default Update<Exercised<Long>> exerciseGetVehicleCapacity(GetVehicleCapacity arg) {
      return makeExerciseCmd(CHOICE_GetVehicleCapacity, arg);
    }

    default Update<Exercised<Long>> exerciseGetVehicleCapacity() {
      return exerciseGetVehicleCapacity(new GetVehicleCapacity());
    }

    default Update<Exercised<ContractId>> exerciseSetGarageInstrumentKey(
        SetGarageInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_SetGarageInstrumentKey, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGarageInstrumentKey(
        InstrumentKey newGarageInstrumentKey) {
      return exerciseSetGarageInstrumentKey(new SetGarageInstrumentKey(newGarageInstrumentKey));
    }

    default Update<Exercised<InstrumentKey>> exerciseGetGarageInstrumentKey(
        GetGarageInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_GetGarageInstrumentKey, arg);
    }

    default Update<Exercised<InstrumentKey>> exerciseGetGarageInstrumentKey() {
      return exerciseGetGarageInstrumentKey(new GetGarageInstrumentKey());
    }

    default Update<Exercised<ContractId>> exerciseSetGarageArea(SetGarageArea arg) {
      return makeExerciseCmd(CHOICE_SetGarageArea, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetGarageArea(BigDecimal newGarageArea) {
      return exerciseSetGarageArea(new SetGarageArea(newGarageArea));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, GarageProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, GarageProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<GarageProperty, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.propertymanager.property.garageproperty.garageproperty.GarageProperty", GarageProperty.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_GetGarageDescription, CHOICE_GetGaragePropertyCounty,
            CHOICE_GetGaragePropertyPostalCode, CHOICE_GetGaragePropertyAddress, CHOICE_Archive,
            CHOICE_GetView, CHOICE_GetGarageInstrumentKey, CHOICE_SetGarageDescription,
            CHOICE_GetGarageType, CHOICE_GetVehicleCapacity, CHOICE_SetGaragePhotoReferences,
            CHOICE_GetGarageAdditionalInformation, CHOICE_SetGaragePropertyCounty,
            CHOICE_SetGaragePropertyDistrict, CHOICE_Remove, CHOICE_GetGaragePrice,
            CHOICE_SetGaragePropertyPostalCode, CHOICE_GetGarageInstalledEquipment,
            CHOICE_GetGaragePropertyDistrict, CHOICE_SetGarageAdditionalInformation,
            CHOICE_GetGaragePhotoReferences, CHOICE_SetGarageInstrumentKey,
            CHOICE_SetGaragePropertyAddress, CHOICE_SetVehicleCapacity, CHOICE_GetGarageArea,
            CHOICE_SetGarageInstalledEquipment, CHOICE_SetGarageArea, CHOICE_SetGarageType,
            CHOICE_SetGaragePrice));
    }
  }
}
