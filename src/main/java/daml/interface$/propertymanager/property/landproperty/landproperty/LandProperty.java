package daml.interface$.propertymanager.property.landproperty.landproperty;

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
import daml.interface$.propertymanager.property.common.LandType;
import daml.interface$.propertymanager.property.common.ViableConstructionTypes;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.List;

public final class LandProperty {
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.PropertyManager.Property.LandProperty.LandProperty", "LandProperty");

  public static final Choice<LandProperty, GetLandPrice, BigDecimal> CHOICE_GetLandPrice = 
      Choice.create("GetLandPrice", value$ -> value$.toValue(), value$ ->
        GetLandPrice.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromNumeric
        .decode(value$));

  public static final Choice<LandProperty, GetLandDescription, String> CHOICE_GetLandDescription = 
      Choice.create("GetLandDescription", value$ -> value$.toValue(), value$ ->
        GetLandDescription.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromText
        .decode(value$));

  public static final Choice<LandProperty, GetLandViableConstructionTypes, List<ViableConstructionTypes>> CHOICE_GetLandViableConstructionTypes = 
      Choice.create("GetLandViableConstructionTypes", value$ -> value$.toValue(), value$ ->
        GetLandViableConstructionTypes.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(ViableConstructionTypes.valueDecoder()).decode(value$));

  public static final Choice<LandProperty, GetLandBuildableFloors, Long> CHOICE_GetLandBuildableFloors = 
      Choice.create("GetLandBuildableFloors", value$ -> value$.toValue(), value$ ->
        GetLandBuildableFloors.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<LandProperty, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<LandProperty, GetLandPropertyDistrict, String> CHOICE_GetLandPropertyDistrict = 
      Choice.create("GetLandPropertyDistrict", value$ -> value$.toValue(), value$ ->
        GetLandPropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<LandProperty, GetLandType, LandType> CHOICE_GetLandType = 
      Choice.create("GetLandType", value$ -> value$.toValue(), value$ -> GetLandType.valueDecoder()
        .decode(value$), value$ -> LandType.valueDecoder().decode(value$));

  public static final Choice<LandProperty, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<LandProperty, GetLandMinimumSurfaceForSale, BigDecimal> CHOICE_GetLandMinimumSurfaceForSale = 
      Choice.create("GetLandMinimumSurfaceForSale", value$ -> value$.toValue(), value$ ->
        GetLandMinimumSurfaceForSale.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<LandProperty, GetLandPhotoReferences, List<String>> CHOICE_GetLandPhotoReferences = 
      Choice.create("GetLandPhotoReferences", value$ -> value$.toValue(), value$ ->
        GetLandPhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromText).decode(value$));

  public static final Choice<LandProperty, GetLandPropertyCounty, String> CHOICE_GetLandPropertyCounty = 
      Choice.create("GetLandPropertyCounty", value$ -> value$.toValue(), value$ ->
        GetLandPropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<LandProperty, GetLandBuildableArea, BigDecimal> CHOICE_GetLandBuildableArea = 
      Choice.create("GetLandBuildableArea", value$ -> value$.toValue(), value$ ->
        GetLandBuildableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<LandProperty, GetLandAdditionalInformation, String> CHOICE_GetLandAdditionalInformation = 
      Choice.create("GetLandAdditionalInformation", value$ -> value$.toValue(), value$ ->
        GetLandAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<LandProperty, GetTotalLandArea, BigDecimal> CHOICE_GetTotalLandArea = 
      Choice.create("GetTotalLandArea", value$ -> value$.toValue(), value$ ->
        GetTotalLandArea.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromNumeric
        .decode(value$));

  public static final Choice<LandProperty, UpdateLand, ContractId> CHOICE_UpdateLand = 
      Choice.create("UpdateLand", value$ -> value$.toValue(), value$ -> UpdateLand.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<LandProperty, GetLandInstrumentKey, InstrumentKey> CHOICE_GetLandInstrumentKey = 
      Choice.create("GetLandInstrumentKey", value$ -> value$.toValue(), value$ ->
        GetLandInstrumentKey.valueDecoder().decode(value$), value$ -> InstrumentKey.valueDecoder()
        .decode(value$));

  public static final Choice<LandProperty, GetLandAccessByRoad, Boolean> CHOICE_GetLandAccessByRoad = 
      Choice.create("GetLandAccessByRoad", value$ -> value$.toValue(), value$ ->
        GetLandAccessByRoad.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromBool
        .decode(value$));

  public static final Choice<LandProperty, GetLandPropertyPostalCode, String> CHOICE_GetLandPropertyPostalCode = 
      Choice.create("GetLandPropertyPostalCode", value$ -> value$.toValue(), value$ ->
        GetLandPropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<LandProperty, GetLandPropertyAddress, String> CHOICE_GetLandPropertyAddress = 
      Choice.create("GetLandPropertyAddress", value$ -> value$.toValue(), value$ ->
        GetLandPropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<LandProperty, GetLandInstalledEquipment, String> CHOICE_GetLandInstalledEquipment = 
      Choice.create("GetLandInstalledEquipment", value$ -> value$.toValue(), value$ ->
        GetLandInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private LandProperty() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<LandProperty> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, LandProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<BigDecimal>> exerciseGetLandPrice(GetLandPrice arg) {
      return makeExerciseCmd(CHOICE_GetLandPrice, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetLandPrice() {
      return exerciseGetLandPrice(new GetLandPrice());
    }

    default Update<Exercised<String>> exerciseGetLandDescription(GetLandDescription arg) {
      return makeExerciseCmd(CHOICE_GetLandDescription, arg);
    }

    default Update<Exercised<String>> exerciseGetLandDescription() {
      return exerciseGetLandDescription(new GetLandDescription());
    }

    default Update<Exercised<List<ViableConstructionTypes>>> exerciseGetLandViableConstructionTypes(
        GetLandViableConstructionTypes arg) {
      return makeExerciseCmd(CHOICE_GetLandViableConstructionTypes, arg);
    }

    default Update<Exercised<List<ViableConstructionTypes>>> exerciseGetLandViableConstructionTypes(
        ) {
      return exerciseGetLandViableConstructionTypes(new GetLandViableConstructionTypes());
    }

    default Update<Exercised<Long>> exerciseGetLandBuildableFloors(GetLandBuildableFloors arg) {
      return makeExerciseCmd(CHOICE_GetLandBuildableFloors, arg);
    }

    default Update<Exercised<Long>> exerciseGetLandBuildableFloors() {
      return exerciseGetLandBuildableFloors(new GetLandBuildableFloors());
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<String>> exerciseGetLandPropertyDistrict(GetLandPropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_GetLandPropertyDistrict, arg);
    }

    default Update<Exercised<String>> exerciseGetLandPropertyDistrict() {
      return exerciseGetLandPropertyDistrict(new GetLandPropertyDistrict());
    }

    default Update<Exercised<LandType>> exerciseGetLandType(GetLandType arg) {
      return makeExerciseCmd(CHOICE_GetLandType, arg);
    }

    default Update<Exercised<LandType>> exerciseGetLandType() {
      return exerciseGetLandType(new GetLandType());
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<BigDecimal>> exerciseGetLandMinimumSurfaceForSale(
        GetLandMinimumSurfaceForSale arg) {
      return makeExerciseCmd(CHOICE_GetLandMinimumSurfaceForSale, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetLandMinimumSurfaceForSale() {
      return exerciseGetLandMinimumSurfaceForSale(new GetLandMinimumSurfaceForSale());
    }

    default Update<Exercised<List<String>>> exerciseGetLandPhotoReferences(
        GetLandPhotoReferences arg) {
      return makeExerciseCmd(CHOICE_GetLandPhotoReferences, arg);
    }

    default Update<Exercised<List<String>>> exerciseGetLandPhotoReferences() {
      return exerciseGetLandPhotoReferences(new GetLandPhotoReferences());
    }

    default Update<Exercised<String>> exerciseGetLandPropertyCounty(GetLandPropertyCounty arg) {
      return makeExerciseCmd(CHOICE_GetLandPropertyCounty, arg);
    }

    default Update<Exercised<String>> exerciseGetLandPropertyCounty() {
      return exerciseGetLandPropertyCounty(new GetLandPropertyCounty());
    }

    default Update<Exercised<BigDecimal>> exerciseGetLandBuildableArea(GetLandBuildableArea arg) {
      return makeExerciseCmd(CHOICE_GetLandBuildableArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetLandBuildableArea() {
      return exerciseGetLandBuildableArea(new GetLandBuildableArea());
    }

    default Update<Exercised<String>> exerciseGetLandAdditionalInformation(
        GetLandAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_GetLandAdditionalInformation, arg);
    }

    default Update<Exercised<String>> exerciseGetLandAdditionalInformation() {
      return exerciseGetLandAdditionalInformation(new GetLandAdditionalInformation());
    }

    default Update<Exercised<BigDecimal>> exerciseGetTotalLandArea(GetTotalLandArea arg) {
      return makeExerciseCmd(CHOICE_GetTotalLandArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetTotalLandArea() {
      return exerciseGetTotalLandArea(new GetTotalLandArea());
    }

    default Update<Exercised<ContractId>> exerciseUpdateLand(UpdateLand arg) {
      return makeExerciseCmd(CHOICE_UpdateLand, arg);
    }

    default Update<Exercised<ContractId>> exerciseUpdateLand(BigDecimal newLandPrice,
        String newLandPropertyAddress, String newLandPropertyPostalCode,
        String newLandPropertyDistrict, String newLandPropertyCounty, LandType newLandType,
        BigDecimal newLandTotalArea, BigDecimal newLandMinimumSurfaceForSale,
        BigDecimal newLandBuildableArea, Long newLandBuildableFloors, Boolean newLandAccessByRoad,
        String newLandInstalledEquipment,
        List<ViableConstructionTypes> newLandViableConstructionTypes,
        String newLandAdditionalInformation, String newLandDescription,
        List<String> newLandPhotoReferences) {
      return exerciseUpdateLand(new UpdateLand(newLandPrice, newLandPropertyAddress,
          newLandPropertyPostalCode, newLandPropertyDistrict, newLandPropertyCounty, newLandType,
          newLandTotalArea, newLandMinimumSurfaceForSale, newLandBuildableArea,
          newLandBuildableFloors, newLandAccessByRoad, newLandInstalledEquipment,
          newLandViableConstructionTypes, newLandAdditionalInformation, newLandDescription,
          newLandPhotoReferences));
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<InstrumentKey>> exerciseGetLandInstrumentKey(
        GetLandInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_GetLandInstrumentKey, arg);
    }

    default Update<Exercised<InstrumentKey>> exerciseGetLandInstrumentKey() {
      return exerciseGetLandInstrumentKey(new GetLandInstrumentKey());
    }

    default Update<Exercised<Boolean>> exerciseGetLandAccessByRoad(GetLandAccessByRoad arg) {
      return makeExerciseCmd(CHOICE_GetLandAccessByRoad, arg);
    }

    default Update<Exercised<Boolean>> exerciseGetLandAccessByRoad() {
      return exerciseGetLandAccessByRoad(new GetLandAccessByRoad());
    }

    default Update<Exercised<String>> exerciseGetLandPropertyPostalCode(
        GetLandPropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_GetLandPropertyPostalCode, arg);
    }

    default Update<Exercised<String>> exerciseGetLandPropertyPostalCode() {
      return exerciseGetLandPropertyPostalCode(new GetLandPropertyPostalCode());
    }

    default Update<Exercised<String>> exerciseGetLandPropertyAddress(GetLandPropertyAddress arg) {
      return makeExerciseCmd(CHOICE_GetLandPropertyAddress, arg);
    }

    default Update<Exercised<String>> exerciseGetLandPropertyAddress() {
      return exerciseGetLandPropertyAddress(new GetLandPropertyAddress());
    }

    default Update<Exercised<String>> exerciseGetLandInstalledEquipment(
        GetLandInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_GetLandInstalledEquipment, arg);
    }

    default Update<Exercised<String>> exerciseGetLandInstalledEquipment() {
      return exerciseGetLandInstalledEquipment(new GetLandInstalledEquipment());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, LandProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, LandProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<LandProperty, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.propertymanager.property.landproperty.landproperty.LandProperty", LandProperty.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_GetLandDescription, CHOICE_GetLandType,
            CHOICE_GetLandBuildableArea, CHOICE_GetTotalLandArea, CHOICE_GetLandBuildableFloors,
            CHOICE_GetLandInstalledEquipment, CHOICE_GetLandPropertyDistrict, CHOICE_Archive,
            CHOICE_GetLandAdditionalInformation, CHOICE_GetView, CHOICE_UpdateLand,
            CHOICE_GetLandMinimumSurfaceForSale, CHOICE_GetLandPrice, CHOICE_Remove,
            CHOICE_GetLandInstrumentKey, CHOICE_GetLandPhotoReferences,
            CHOICE_GetLandPropertyCounty, CHOICE_GetLandPropertyAddress,
            CHOICE_GetLandViableConstructionTypes, CHOICE_GetLandAccessByRoad,
            CHOICE_GetLandPropertyPostalCode));
    }
  }
}
