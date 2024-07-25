package daml.interface$.propertymanager.property.warehouseproperty.warehouseproperty;

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
import daml.interface$.propertymanager.property.common.WarehouseType;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public final class WarehouseProperty {
  public static final Identifier TEMPLATE_ID = new Identifier("8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f", "Interface.PropertyManager.Property.WarehouseProperty.WarehouseProperty", "WarehouseProperty");

  public static final Choice<WarehouseProperty, SetWarehousePropertyAddress, ContractId> CHOICE_SetWarehousePropertyAddress = 
      Choice.create("SetWarehousePropertyAddress", value$ -> value$.toValue(), value$ ->
        SetWarehousePropertyAddress.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, SetWarehousePhotoReferences, ContractId> CHOICE_SetWarehousePhotoReferences = 
      Choice.create("SetWarehousePhotoReferences", value$ -> value$.toValue(), value$ ->
        SetWarehousePhotoReferences.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<WarehouseProperty, SetWarehouseType, ContractId> CHOICE_SetWarehouseType = 
      Choice.create("SetWarehouseType", value$ -> value$.toValue(), value$ ->
        SetWarehouseType.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, SetWarehouseFloors, ContractId> CHOICE_SetWarehouseFloors = 
      Choice.create("SetWarehouseFloors", value$ -> value$.toValue(), value$ ->
        SetWarehouseFloors.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, GetWarehousePropertyCounty, String> CHOICE_GetWarehousePropertyCounty = 
      Choice.create("GetWarehousePropertyCounty", value$ -> value$.toValue(), value$ ->
        GetWarehousePropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, SetWarehousePrice, ContractId> CHOICE_SetWarehousePrice = 
      Choice.create("SetWarehousePrice", value$ -> value$.toValue(), value$ ->
        SetWarehousePrice.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, GetWarehousePropertyDistrict, String> CHOICE_GetWarehousePropertyDistrict = 
      Choice.create("GetWarehousePropertyDistrict", value$ -> value$.toValue(), value$ ->
        GetWarehousePropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, SetWarehouseGrossArea, ContractId> CHOICE_SetWarehouseGrossArea = 
      Choice.create("SetWarehouseGrossArea", value$ -> value$.toValue(), value$ ->
        SetWarehouseGrossArea.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, GetWarehousePhotoReferences, List<String>> CHOICE_GetWarehousePhotoReferences = 
      Choice.create("GetWarehousePhotoReferences", value$ -> value$.toValue(), value$ ->
        GetWarehousePhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromText).decode(value$));

  public static final Choice<WarehouseProperty, GetWarehousePrice, BigDecimal> CHOICE_GetWarehousePrice = 
      Choice.create("GetWarehousePrice", value$ -> value$.toValue(), value$ ->
        GetWarehousePrice.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseFloors, Long> CHOICE_GetWarehouseFloors = 
      Choice.create("GetWarehouseFloors", value$ -> value$.toValue(), value$ ->
        GetWarehouseFloors.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromInt64
        .decode(value$));

  public static final Choice<WarehouseProperty, SetWarehouseUsableArea, ContractId> CHOICE_SetWarehouseUsableArea = 
      Choice.create("SetWarehouseUsableArea", value$ -> value$.toValue(), value$ ->
        SetWarehouseUsableArea.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, GetWarehouseUsableArea, BigDecimal> CHOICE_GetWarehouseUsableArea = 
      Choice.create("GetWarehouseUsableArea", value$ -> value$.toValue(), value$ ->
        GetWarehouseUsableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<WarehouseProperty, SetWarehousePropertyDistrict, ContractId> CHOICE_SetWarehousePropertyDistrict = 
      Choice.create("SetWarehousePropertyDistrict", value$ -> value$.toValue(), value$ ->
        SetWarehousePropertyDistrict.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, SetWarehouseInstrumentKey, ContractId> CHOICE_SetWarehouseInstrumentKey = 
      Choice.create("SetWarehouseInstrumentKey", value$ -> value$.toValue(), value$ ->
        SetWarehouseInstrumentKey.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<WarehouseProperty, SetWarehouseAdditionalInformation, ContractId> CHOICE_SetWarehouseAdditionalInformation = 
      Choice.create("SetWarehouseAdditionalInformation", value$ -> value$.toValue(), value$ ->
        SetWarehouseAdditionalInformation.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, SetWarehouseInstalledEquipment, ContractId> CHOICE_SetWarehouseInstalledEquipment = 
      Choice.create("SetWarehouseInstalledEquipment", value$ -> value$.toValue(), value$ ->
        SetWarehouseInstalledEquipment.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, SetWarehousePropertyPostalCode, ContractId> CHOICE_SetWarehousePropertyPostalCode = 
      Choice.create("SetWarehousePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        SetWarehousePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, GetWarehouseBuildDate, LocalDate> CHOICE_GetWarehouseBuildDate = 
      Choice.create("GetWarehouseBuildDate", value$ -> value$.toValue(), value$ ->
        GetWarehouseBuildDate.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromDate.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseGrossArea, BigDecimal> CHOICE_GetWarehouseGrossArea = 
      Choice.create("GetWarehouseGrossArea", value$ -> value$.toValue(), value$ ->
        GetWarehouseGrossArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseInstrumentKey, InstrumentKey> CHOICE_GetWarehouseInstrumentKey = 
      Choice.create("GetWarehouseInstrumentKey", value$ -> value$.toValue(), value$ ->
        GetWarehouseInstrumentKey.valueDecoder().decode(value$), value$ ->
        InstrumentKey.valueDecoder().decode(value$));

  public static final Choice<WarehouseProperty, SetWarehouseBuildDate, ContractId> CHOICE_SetWarehouseBuildDate = 
      Choice.create("SetWarehouseBuildDate", value$ -> value$.toValue(), value$ ->
        SetWarehouseBuildDate.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseAdditionalInformation, String> CHOICE_GetWarehouseAdditionalInformation = 
      Choice.create("GetWarehouseAdditionalInformation", value$ -> value$.toValue(), value$ ->
        GetWarehouseAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseDescription, String> CHOICE_GetWarehouseDescription = 
      Choice.create("GetWarehouseDescription", value$ -> value$.toValue(), value$ ->
        GetWarehouseDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, SetWarehousePropertyCounty, ContractId> CHOICE_SetWarehousePropertyCounty = 
      Choice.create("SetWarehousePropertyCounty", value$ -> value$.toValue(), value$ ->
        SetWarehousePropertyCounty.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, GetWarehousePropertyAddress, String> CHOICE_GetWarehousePropertyAddress = 
      Choice.create("GetWarehousePropertyAddress", value$ -> value$.toValue(), value$ ->
        GetWarehousePropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseType, WarehouseType> CHOICE_GetWarehouseType = 
      Choice.create("GetWarehouseType", value$ -> value$.toValue(), value$ ->
        GetWarehouseType.valueDecoder().decode(value$), value$ -> WarehouseType.valueDecoder()
        .decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseInstalledEquipment, String> CHOICE_GetWarehouseInstalledEquipment = 
      Choice.create("GetWarehouseInstalledEquipment", value$ -> value$.toValue(), value$ ->
        GetWarehouseInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehousePropertyPostalCode, String> CHOICE_GetWarehousePropertyPostalCode = 
      Choice.create("GetWarehousePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        GetWarehousePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, SetWarehouseDescription, ContractId> CHOICE_SetWarehouseDescription = 
      Choice.create("SetWarehouseDescription", value$ -> value$.toValue(), value$ ->
        SetWarehouseDescription.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private WarehouseProperty() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<WarehouseProperty> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, WarehouseProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<ContractId>> exerciseSetWarehousePropertyAddress(
        SetWarehousePropertyAddress arg) {
      return makeExerciseCmd(CHOICE_SetWarehousePropertyAddress, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePropertyAddress(
        String newWarehousePropertyAddress) {
      return exerciseSetWarehousePropertyAddress(new SetWarehousePropertyAddress(newWarehousePropertyAddress));
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePhotoReferences(
        SetWarehousePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_SetWarehousePhotoReferences, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePhotoReferences(
        List<String> newPhotoReferences) {
      return exerciseSetWarehousePhotoReferences(new SetWarehousePhotoReferences(newPhotoReferences));
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseType(SetWarehouseType arg) {
      return makeExerciseCmd(CHOICE_SetWarehouseType, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseType(WarehouseType newWarehouseType) {
      return exerciseSetWarehouseType(new SetWarehouseType(newWarehouseType));
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseFloors(SetWarehouseFloors arg) {
      return makeExerciseCmd(CHOICE_SetWarehouseFloors, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseFloors(Long newWarehouseFloors) {
      return exerciseSetWarehouseFloors(new SetWarehouseFloors(newWarehouseFloors));
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyCounty(
        GetWarehousePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_GetWarehousePropertyCounty, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyCounty() {
      return exerciseGetWarehousePropertyCounty(new GetWarehousePropertyCounty());
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePrice(SetWarehousePrice arg) {
      return makeExerciseCmd(CHOICE_SetWarehousePrice, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePrice(BigDecimal newWarehousePrice) {
      return exerciseSetWarehousePrice(new SetWarehousePrice(newWarehousePrice));
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyDistrict(
        GetWarehousePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_GetWarehousePropertyDistrict, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyDistrict() {
      return exerciseGetWarehousePropertyDistrict(new GetWarehousePropertyDistrict());
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseGrossArea(SetWarehouseGrossArea arg) {
      return makeExerciseCmd(CHOICE_SetWarehouseGrossArea, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseGrossArea(
        BigDecimal newWarehouseGrossArea) {
      return exerciseSetWarehouseGrossArea(new SetWarehouseGrossArea(newWarehouseGrossArea));
    }

    default Update<Exercised<List<String>>> exerciseGetWarehousePhotoReferences(
        GetWarehousePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_GetWarehousePhotoReferences, arg);
    }

    default Update<Exercised<List<String>>> exerciseGetWarehousePhotoReferences() {
      return exerciseGetWarehousePhotoReferences(new GetWarehousePhotoReferences());
    }

    default Update<Exercised<BigDecimal>> exerciseGetWarehousePrice(GetWarehousePrice arg) {
      return makeExerciseCmd(CHOICE_GetWarehousePrice, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetWarehousePrice() {
      return exerciseGetWarehousePrice(new GetWarehousePrice());
    }

    default Update<Exercised<Long>> exerciseGetWarehouseFloors(GetWarehouseFloors arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseFloors, arg);
    }

    default Update<Exercised<Long>> exerciseGetWarehouseFloors() {
      return exerciseGetWarehouseFloors(new GetWarehouseFloors());
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseUsableArea(
        SetWarehouseUsableArea arg) {
      return makeExerciseCmd(CHOICE_SetWarehouseUsableArea, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseUsableArea(
        BigDecimal newWarehouseUsableArea) {
      return exerciseSetWarehouseUsableArea(new SetWarehouseUsableArea(newWarehouseUsableArea));
    }

    default Update<Exercised<BigDecimal>> exerciseGetWarehouseUsableArea(
        GetWarehouseUsableArea arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseUsableArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetWarehouseUsableArea() {
      return exerciseGetWarehouseUsableArea(new GetWarehouseUsableArea());
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePropertyDistrict(
        SetWarehousePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_SetWarehousePropertyDistrict, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePropertyDistrict(
        String newWarehousePropertyDistrict) {
      return exerciseSetWarehousePropertyDistrict(new SetWarehousePropertyDistrict(newWarehousePropertyDistrict));
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseInstrumentKey(
        SetWarehouseInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_SetWarehouseInstrumentKey, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseInstrumentKey(
        InstrumentKey newWarehouseInstrumentKey) {
      return exerciseSetWarehouseInstrumentKey(new SetWarehouseInstrumentKey(newWarehouseInstrumentKey));
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseAdditionalInformation(
        SetWarehouseAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_SetWarehouseAdditionalInformation, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseAdditionalInformation(
        String newWarehouseAdditionalInformation) {
      return exerciseSetWarehouseAdditionalInformation(new SetWarehouseAdditionalInformation(newWarehouseAdditionalInformation));
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseInstalledEquipment(
        SetWarehouseInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_SetWarehouseInstalledEquipment, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseInstalledEquipment(
        String newWarehouseInstalledEquipment) {
      return exerciseSetWarehouseInstalledEquipment(new SetWarehouseInstalledEquipment(newWarehouseInstalledEquipment));
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePropertyPostalCode(
        SetWarehousePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_SetWarehousePropertyPostalCode, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePropertyPostalCode(
        String newWarehousePropertyPostalCode) {
      return exerciseSetWarehousePropertyPostalCode(new SetWarehousePropertyPostalCode(newWarehousePropertyPostalCode));
    }

    default Update<Exercised<LocalDate>> exerciseGetWarehouseBuildDate(GetWarehouseBuildDate arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseBuildDate, arg);
    }

    default Update<Exercised<LocalDate>> exerciseGetWarehouseBuildDate() {
      return exerciseGetWarehouseBuildDate(new GetWarehouseBuildDate());
    }

    default Update<Exercised<BigDecimal>> exerciseGetWarehouseGrossArea(GetWarehouseGrossArea arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseGrossArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetWarehouseGrossArea() {
      return exerciseGetWarehouseGrossArea(new GetWarehouseGrossArea());
    }

    default Update<Exercised<InstrumentKey>> exerciseGetWarehouseInstrumentKey(
        GetWarehouseInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseInstrumentKey, arg);
    }

    default Update<Exercised<InstrumentKey>> exerciseGetWarehouseInstrumentKey() {
      return exerciseGetWarehouseInstrumentKey(new GetWarehouseInstrumentKey());
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseBuildDate(SetWarehouseBuildDate arg) {
      return makeExerciseCmd(CHOICE_SetWarehouseBuildDate, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseBuildDate(
        LocalDate newWarehouseBuildDate) {
      return exerciseSetWarehouseBuildDate(new SetWarehouseBuildDate(newWarehouseBuildDate));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<String>> exerciseGetWarehouseAdditionalInformation(
        GetWarehouseAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseAdditionalInformation, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehouseAdditionalInformation() {
      return exerciseGetWarehouseAdditionalInformation(new GetWarehouseAdditionalInformation());
    }

    default Update<Exercised<String>> exerciseGetWarehouseDescription(GetWarehouseDescription arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseDescription, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehouseDescription() {
      return exerciseGetWarehouseDescription(new GetWarehouseDescription());
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePropertyCounty(
        SetWarehousePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_SetWarehousePropertyCounty, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehousePropertyCounty(
        String newWarehousePropertyCounty) {
      return exerciseSetWarehousePropertyCounty(new SetWarehousePropertyCounty(newWarehousePropertyCounty));
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyAddress(
        GetWarehousePropertyAddress arg) {
      return makeExerciseCmd(CHOICE_GetWarehousePropertyAddress, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyAddress() {
      return exerciseGetWarehousePropertyAddress(new GetWarehousePropertyAddress());
    }

    default Update<Exercised<WarehouseType>> exerciseGetWarehouseType(GetWarehouseType arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseType, arg);
    }

    default Update<Exercised<WarehouseType>> exerciseGetWarehouseType() {
      return exerciseGetWarehouseType(new GetWarehouseType());
    }

    default Update<Exercised<String>> exerciseGetWarehouseInstalledEquipment(
        GetWarehouseInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseInstalledEquipment, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehouseInstalledEquipment() {
      return exerciseGetWarehouseInstalledEquipment(new GetWarehouseInstalledEquipment());
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyPostalCode(
        GetWarehousePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_GetWarehousePropertyPostalCode, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyPostalCode() {
      return exerciseGetWarehousePropertyPostalCode(new GetWarehousePropertyPostalCode());
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseDescription(
        SetWarehouseDescription arg) {
      return makeExerciseCmd(CHOICE_SetWarehouseDescription, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetWarehouseDescription(
        String newWarehouseDescription) {
      return exerciseSetWarehouseDescription(new SetWarehouseDescription(newWarehouseDescription));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, WarehouseProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, WarehouseProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<WarehouseProperty, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.propertymanager.property.warehouseproperty.warehouseproperty.WarehouseProperty", WarehouseProperty.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_SetWarehousePropertyCounty,
            CHOICE_GetWarehousePropertyAddress, CHOICE_SetWarehouseAdditionalInformation,
            CHOICE_SetWarehouseBuildDate, CHOICE_GetWarehouseGrossArea, CHOICE_SetWarehousePrice,
            CHOICE_SetWarehousePropertyDistrict, CHOICE_GetWarehouseDescription,
            CHOICE_SetWarehouseInstalledEquipment, CHOICE_SetWarehouseGrossArea, CHOICE_Archive,
            CHOICE_GetWarehouseInstalledEquipment, CHOICE_SetWarehouseDescription,
            CHOICE_SetWarehousePhotoReferences, CHOICE_GetWarehouseType,
            CHOICE_GetWarehouseBuildDate, CHOICE_GetWarehousePropertyPostalCode, CHOICE_Remove,
            CHOICE_GetWarehouseUsableArea, CHOICE_GetWarehousePropertyCounty,
            CHOICE_SetWarehouseUsableArea, CHOICE_GetWarehouseFloors,
            CHOICE_SetWarehousePropertyAddress, CHOICE_GetView,
            CHOICE_SetWarehousePropertyPostalCode, CHOICE_GetWarehousePrice,
            CHOICE_GetWarehouseInstrumentKey, CHOICE_SetWarehouseFloors,
            CHOICE_SetWarehouseInstrumentKey, CHOICE_GetWarehousePropertyDistrict,
            CHOICE_GetWarehouseAdditionalInformation, CHOICE_GetWarehousePhotoReferences,
            CHOICE_SetWarehouseType));
    }
  }
}
