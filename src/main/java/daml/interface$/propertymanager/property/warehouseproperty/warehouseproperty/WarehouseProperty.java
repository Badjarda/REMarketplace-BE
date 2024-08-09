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
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.PropertyManager.Property.WarehouseProperty.WarehouseProperty", "WarehouseProperty");

  public static final Choice<WarehouseProperty, GetWarehouseFloors, Long> CHOICE_GetWarehouseFloors = 
      Choice.create("GetWarehouseFloors", value$ -> value$.toValue(), value$ ->
        GetWarehouseFloors.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromInt64
        .decode(value$));

  public static final Choice<WarehouseProperty, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseUsableArea, BigDecimal> CHOICE_GetWarehouseUsableArea = 
      Choice.create("GetWarehouseUsableArea", value$ -> value$.toValue(), value$ ->
        GetWarehouseUsableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<WarehouseProperty, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<WarehouseProperty, UpdateWarehouse, ContractId> CHOICE_UpdateWarehouse = 
      Choice.create("UpdateWarehouse", value$ -> value$.toValue(), value$ ->
        UpdateWarehouse.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<WarehouseProperty, GetWarehousePropertyCounty, String> CHOICE_GetWarehousePropertyCounty = 
      Choice.create("GetWarehousePropertyCounty", value$ -> value$.toValue(), value$ ->
        GetWarehousePropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseInstrumentKey, InstrumentKey> CHOICE_GetWarehouseInstrumentKey = 
      Choice.create("GetWarehouseInstrumentKey", value$ -> value$.toValue(), value$ ->
        GetWarehouseInstrumentKey.valueDecoder().decode(value$), value$ ->
        InstrumentKey.valueDecoder().decode(value$));

  public static final Choice<WarehouseProperty, GetWarehousePropertyDistrict, String> CHOICE_GetWarehousePropertyDistrict = 
      Choice.create("GetWarehousePropertyDistrict", value$ -> value$.toValue(), value$ ->
        GetWarehousePropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehousePropertyPostalCode, String> CHOICE_GetWarehousePropertyPostalCode = 
      Choice.create("GetWarehousePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        GetWarehousePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehousePhotoReferences, List<String>> CHOICE_GetWarehousePhotoReferences = 
      Choice.create("GetWarehousePhotoReferences", value$ -> value$.toValue(), value$ ->
        GetWarehousePhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromText).decode(value$));

  public static final Choice<WarehouseProperty, GetWarehousePrice, BigDecimal> CHOICE_GetWarehousePrice = 
      Choice.create("GetWarehousePrice", value$ -> value$.toValue(), value$ ->
        GetWarehousePrice.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseBuildDate, LocalDate> CHOICE_GetWarehouseBuildDate = 
      Choice.create("GetWarehouseBuildDate", value$ -> value$.toValue(), value$ ->
        GetWarehouseBuildDate.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromDate.decode(value$));

  public static final Choice<WarehouseProperty, GetWarehouseGrossArea, BigDecimal> CHOICE_GetWarehouseGrossArea = 
      Choice.create("GetWarehouseGrossArea", value$ -> value$.toValue(), value$ ->
        GetWarehouseGrossArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

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
    default Update<Exercised<Long>> exerciseGetWarehouseFloors(GetWarehouseFloors arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseFloors, arg);
    }

    default Update<Exercised<Long>> exerciseGetWarehouseFloors() {
      return exerciseGetWarehouseFloors(new GetWarehouseFloors());
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<BigDecimal>> exerciseGetWarehouseUsableArea(
        GetWarehouseUsableArea arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseUsableArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetWarehouseUsableArea() {
      return exerciseGetWarehouseUsableArea(new GetWarehouseUsableArea());
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<ContractId>> exerciseUpdateWarehouse(UpdateWarehouse arg) {
      return makeExerciseCmd(CHOICE_UpdateWarehouse, arg);
    }

    default Update<Exercised<ContractId>> exerciseUpdateWarehouse(BigDecimal newWarehousePrice,
        String newWarehousePropertyAddress, String newWarehousePropertyPostalCode,
        String newWarehousePropertyDistrict, String newWarehousePropertyCounty,
        WarehouseType newWarehouseType, BigDecimal newWarehouseGrossArea,
        BigDecimal newWarehouseUsableArea, Long newWarehouseFloors, LocalDate newWarehouseBuildDate,
        String newWarehouseInstalledEquipment, String newWarehouseAdditionalInformation,
        String newWarehouseDescription, List<String> newWarehousePhotoReferences) {
      return exerciseUpdateWarehouse(new UpdateWarehouse(newWarehousePrice,
          newWarehousePropertyAddress, newWarehousePropertyPostalCode, newWarehousePropertyDistrict,
          newWarehousePropertyCounty, newWarehouseType, newWarehouseGrossArea,
          newWarehouseUsableArea, newWarehouseFloors, newWarehouseBuildDate,
          newWarehouseInstalledEquipment, newWarehouseAdditionalInformation,
          newWarehouseDescription, newWarehousePhotoReferences));
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyCounty(
        GetWarehousePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_GetWarehousePropertyCounty, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyCounty() {
      return exerciseGetWarehousePropertyCounty(new GetWarehousePropertyCounty());
    }

    default Update<Exercised<InstrumentKey>> exerciseGetWarehouseInstrumentKey(
        GetWarehouseInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_GetWarehouseInstrumentKey, arg);
    }

    default Update<Exercised<InstrumentKey>> exerciseGetWarehouseInstrumentKey() {
      return exerciseGetWarehouseInstrumentKey(new GetWarehouseInstrumentKey());
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyDistrict(
        GetWarehousePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_GetWarehousePropertyDistrict, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyDistrict() {
      return exerciseGetWarehousePropertyDistrict(new GetWarehousePropertyDistrict());
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyPostalCode(
        GetWarehousePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_GetWarehousePropertyPostalCode, arg);
    }

    default Update<Exercised<String>> exerciseGetWarehousePropertyPostalCode() {
      return exerciseGetWarehousePropertyPostalCode(new GetWarehousePropertyPostalCode());
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
            View::fromJson,List.of(CHOICE_GetWarehousePropertyAddress, CHOICE_GetWarehouseGrossArea,
            CHOICE_GetWarehouseDescription, CHOICE_Archive, CHOICE_GetView,
            CHOICE_GetWarehouseInstalledEquipment, CHOICE_GetWarehousePrice,
            CHOICE_GetWarehouseInstrumentKey, CHOICE_GetWarehousePropertyDistrict,
            CHOICE_GetWarehouseBuildDate, CHOICE_GetWarehousePropertyPostalCode, CHOICE_Remove,
            CHOICE_GetWarehouseUsableArea, CHOICE_GetWarehousePropertyCounty,
            CHOICE_GetWarehouseFloors, CHOICE_GetWarehouseAdditionalInformation,
            CHOICE_GetWarehousePhotoReferences, CHOICE_GetWarehouseType, CHOICE_UpdateWarehouse));
    }
  }
}
