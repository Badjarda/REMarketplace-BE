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
  public static final Identifier TEMPLATE_ID = new Identifier("8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f", "Interface.PropertyManager.Property.LandProperty.LandProperty", "LandProperty");

  public static final Choice<LandProperty, GetLandViableConstructionTypes, List<ViableConstructionTypes>> CHOICE_GetLandViableConstructionTypes = 
      Choice.create("GetLandViableConstructionTypes", value$ -> value$.toValue(), value$ ->
        GetLandViableConstructionTypes.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(ViableConstructionTypes.valueDecoder()).decode(value$));

  public static final Choice<LandProperty, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<LandProperty, SetLandBuildableFloors, ContractId> CHOICE_SetLandBuildableFloors = 
      Choice.create("SetLandBuildableFloors", value$ -> value$.toValue(), value$ ->
        SetLandBuildableFloors.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetLandPropertyDistrict, String> CHOICE_GetLandPropertyDistrict = 
      Choice.create("GetLandPropertyDistrict", value$ -> value$.toValue(), value$ ->
        GetLandPropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<LandProperty, GetLandType, LandType> CHOICE_GetLandType = 
      Choice.create("GetLandType", value$ -> value$.toValue(), value$ -> GetLandType.valueDecoder()
        .decode(value$), value$ -> LandType.valueDecoder().decode(value$));

  public static final Choice<LandProperty, SetLandAdditionalInformation, ContractId> CHOICE_SetLandAdditionalInformation = 
      Choice.create("SetLandAdditionalInformation", value$ -> value$.toValue(), value$ ->
        SetLandAdditionalInformation.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<LandProperty, SetTotalLandArea, ContractId> CHOICE_SetTotalLandArea = 
      Choice.create("SetTotalLandArea", value$ -> value$.toValue(), value$ ->
        SetTotalLandArea.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetLandMinimumSurfaceForSale, BigDecimal> CHOICE_GetLandMinimumSurfaceForSale = 
      Choice.create("GetLandMinimumSurfaceForSale", value$ -> value$.toValue(), value$ ->
        GetLandMinimumSurfaceForSale.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<LandProperty, GetLandPhotoReferences, List<String>> CHOICE_GetLandPhotoReferences = 
      Choice.create("GetLandPhotoReferences", value$ -> value$.toValue(), value$ ->
        GetLandPhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromText).decode(value$));

  public static final Choice<LandProperty, SetLandType, ContractId> CHOICE_SetLandType = 
      Choice.create("SetLandType", value$ -> value$.toValue(), value$ -> SetLandType.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, SetLandPhotoReferences, ContractId> CHOICE_SetLandPhotoReferences = 
      Choice.create("SetLandPhotoReferences", value$ -> value$.toValue(), value$ ->
        SetLandPhotoReferences.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetLandBuildableArea, BigDecimal> CHOICE_GetLandBuildableArea = 
      Choice.create("GetLandBuildableArea", value$ -> value$.toValue(), value$ ->
        GetLandBuildableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<LandProperty, GetLandAdditionalInformation, String> CHOICE_GetLandAdditionalInformation = 
      Choice.create("GetLandAdditionalInformation", value$ -> value$.toValue(), value$ ->
        GetLandAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<LandProperty, SetLandPropertyAddress, ContractId> CHOICE_SetLandPropertyAddress = 
      Choice.create("SetLandPropertyAddress", value$ -> value$.toValue(), value$ ->
        SetLandPropertyAddress.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetLandPrice, BigDecimal> CHOICE_GetLandPrice = 
      Choice.create("GetLandPrice", value$ -> value$.toValue(), value$ ->
        GetLandPrice.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromNumeric
        .decode(value$));

  public static final Choice<LandProperty, SetLandViableConstructionTypes, ContractId> CHOICE_SetLandViableConstructionTypes = 
      Choice.create("SetLandViableConstructionTypes", value$ -> value$.toValue(), value$ ->
        SetLandViableConstructionTypes.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, SetLandMinimumSurfaceForSale, ContractId> CHOICE_SetLandMinimumSurfaceForSale = 
      Choice.create("SetLandMinimumSurfaceForSale", value$ -> value$.toValue(), value$ ->
        SetLandMinimumSurfaceForSale.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, SetLandPropertyDistrict, ContractId> CHOICE_SetLandPropertyDistrict = 
      Choice.create("SetLandPropertyDistrict", value$ -> value$.toValue(), value$ ->
        SetLandPropertyDistrict.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetLandDescription, String> CHOICE_GetLandDescription = 
      Choice.create("GetLandDescription", value$ -> value$.toValue(), value$ ->
        GetLandDescription.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromText
        .decode(value$));

  public static final Choice<LandProperty, SetLandInstalledEquipment, ContractId> CHOICE_SetLandInstalledEquipment = 
      Choice.create("SetLandInstalledEquipment", value$ -> value$.toValue(), value$ ->
        SetLandInstalledEquipment.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetTotalLandArea, BigDecimal> CHOICE_GetTotalLandArea = 
      Choice.create("GetTotalLandArea", value$ -> value$.toValue(), value$ ->
        GetTotalLandArea.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromNumeric
        .decode(value$));

  public static final Choice<LandProperty, SetLandDescription, ContractId> CHOICE_SetLandDescription = 
      Choice.create("SetLandDescription", value$ -> value$.toValue(), value$ ->
        SetLandDescription.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<LandProperty, SetLandPropertyPostalCode, ContractId> CHOICE_SetLandPropertyPostalCode = 
      Choice.create("SetLandPropertyPostalCode", value$ -> value$.toValue(), value$ ->
        SetLandPropertyPostalCode.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, SetLandAccessByRoad, ContractId> CHOICE_SetLandAccessByRoad = 
      Choice.create("SetLandAccessByRoad", value$ -> value$.toValue(), value$ ->
        SetLandAccessByRoad.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetLandBuildableFloors, Long> CHOICE_GetLandBuildableFloors = 
      Choice.create("GetLandBuildableFloors", value$ -> value$.toValue(), value$ ->
        GetLandBuildableFloors.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<LandProperty, GetLandInstrumentKey, InstrumentKey> CHOICE_GetLandInstrumentKey = 
      Choice.create("GetLandInstrumentKey", value$ -> value$.toValue(), value$ ->
        GetLandInstrumentKey.valueDecoder().decode(value$), value$ -> InstrumentKey.valueDecoder()
        .decode(value$));

  public static final Choice<LandProperty, GetLandAccessByRoad, Boolean> CHOICE_GetLandAccessByRoad = 
      Choice.create("GetLandAccessByRoad", value$ -> value$.toValue(), value$ ->
        GetLandAccessByRoad.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromBool
        .decode(value$));

  public static final Choice<LandProperty, SetLandInstrumentKey, ContractId> CHOICE_SetLandInstrumentKey = 
      Choice.create("SetLandInstrumentKey", value$ -> value$.toValue(), value$ ->
        SetLandInstrumentKey.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

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

  public static final Choice<LandProperty, SetLandBuildableArea, ContractId> CHOICE_SetLandBuildableArea = 
      Choice.create("SetLandBuildableArea", value$ -> value$.toValue(), value$ ->
        SetLandBuildableArea.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, GetLandPropertyCounty, String> CHOICE_GetLandPropertyCounty = 
      Choice.create("GetLandPropertyCounty", value$ -> value$.toValue(), value$ ->
        GetLandPropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<LandProperty, SetLandPropertyCounty, ContractId> CHOICE_SetLandPropertyCounty = 
      Choice.create("SetLandPropertyCounty", value$ -> value$.toValue(), value$ ->
        SetLandPropertyCounty.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<LandProperty, SetLandPrice, ContractId> CHOICE_SetLandPrice = 
      Choice.create("SetLandPrice", value$ -> value$.toValue(), value$ ->
        SetLandPrice.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

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
    default Update<Exercised<List<ViableConstructionTypes>>> exerciseGetLandViableConstructionTypes(
        GetLandViableConstructionTypes arg) {
      return makeExerciseCmd(CHOICE_GetLandViableConstructionTypes, arg);
    }

    default Update<Exercised<List<ViableConstructionTypes>>> exerciseGetLandViableConstructionTypes(
        ) {
      return exerciseGetLandViableConstructionTypes(new GetLandViableConstructionTypes());
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<ContractId>> exerciseSetLandBuildableFloors(
        SetLandBuildableFloors arg) {
      return makeExerciseCmd(CHOICE_SetLandBuildableFloors, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandBuildableFloors(Long newBuildableFloors) {
      return exerciseSetLandBuildableFloors(new SetLandBuildableFloors(newBuildableFloors));
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

    default Update<Exercised<ContractId>> exerciseSetLandAdditionalInformation(
        SetLandAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_SetLandAdditionalInformation, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandAdditionalInformation(
        String newLandAdditionalInformation) {
      return exerciseSetLandAdditionalInformation(new SetLandAdditionalInformation(newLandAdditionalInformation));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<ContractId>> exerciseSetTotalLandArea(SetTotalLandArea arg) {
      return makeExerciseCmd(CHOICE_SetTotalLandArea, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetTotalLandArea(BigDecimal newTotalLandArea) {
      return exerciseSetTotalLandArea(new SetTotalLandArea(newTotalLandArea));
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

    default Update<Exercised<ContractId>> exerciseSetLandType(SetLandType arg) {
      return makeExerciseCmd(CHOICE_SetLandType, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandType(LandType newLandType) {
      return exerciseSetLandType(new SetLandType(newLandType));
    }

    default Update<Exercised<ContractId>> exerciseSetLandPhotoReferences(
        SetLandPhotoReferences arg) {
      return makeExerciseCmd(CHOICE_SetLandPhotoReferences, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandPhotoReferences(
        List<String> newPhotoReferences) {
      return exerciseSetLandPhotoReferences(new SetLandPhotoReferences(newPhotoReferences));
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

    default Update<Exercised<ContractId>> exerciseSetLandPropertyAddress(
        SetLandPropertyAddress arg) {
      return makeExerciseCmd(CHOICE_SetLandPropertyAddress, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandPropertyAddress(
        String newLandPropertyAddress) {
      return exerciseSetLandPropertyAddress(new SetLandPropertyAddress(newLandPropertyAddress));
    }

    default Update<Exercised<BigDecimal>> exerciseGetLandPrice(GetLandPrice arg) {
      return makeExerciseCmd(CHOICE_GetLandPrice, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetLandPrice() {
      return exerciseGetLandPrice(new GetLandPrice());
    }

    default Update<Exercised<ContractId>> exerciseSetLandViableConstructionTypes(
        SetLandViableConstructionTypes arg) {
      return makeExerciseCmd(CHOICE_SetLandViableConstructionTypes, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandViableConstructionTypes(
        List<ViableConstructionTypes> newLandViableConstructionTypes) {
      return exerciseSetLandViableConstructionTypes(new SetLandViableConstructionTypes(newLandViableConstructionTypes));
    }

    default Update<Exercised<ContractId>> exerciseSetLandMinimumSurfaceForSale(
        SetLandMinimumSurfaceForSale arg) {
      return makeExerciseCmd(CHOICE_SetLandMinimumSurfaceForSale, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandMinimumSurfaceForSale(
        BigDecimal newMinimumSurfaceForSale) {
      return exerciseSetLandMinimumSurfaceForSale(new SetLandMinimumSurfaceForSale(newMinimumSurfaceForSale));
    }

    default Update<Exercised<ContractId>> exerciseSetLandPropertyDistrict(
        SetLandPropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_SetLandPropertyDistrict, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandPropertyDistrict(
        String newLandPropertyDistrict) {
      return exerciseSetLandPropertyDistrict(new SetLandPropertyDistrict(newLandPropertyDistrict));
    }

    default Update<Exercised<String>> exerciseGetLandDescription(GetLandDescription arg) {
      return makeExerciseCmd(CHOICE_GetLandDescription, arg);
    }

    default Update<Exercised<String>> exerciseGetLandDescription() {
      return exerciseGetLandDescription(new GetLandDescription());
    }

    default Update<Exercised<ContractId>> exerciseSetLandInstalledEquipment(
        SetLandInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_SetLandInstalledEquipment, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandInstalledEquipment(
        String newLandInstalledEquipment) {
      return exerciseSetLandInstalledEquipment(new SetLandInstalledEquipment(newLandInstalledEquipment));
    }

    default Update<Exercised<BigDecimal>> exerciseGetTotalLandArea(GetTotalLandArea arg) {
      return makeExerciseCmd(CHOICE_GetTotalLandArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetTotalLandArea() {
      return exerciseGetTotalLandArea(new GetTotalLandArea());
    }

    default Update<Exercised<ContractId>> exerciseSetLandDescription(SetLandDescription arg) {
      return makeExerciseCmd(CHOICE_SetLandDescription, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandDescription(String newLandDescription) {
      return exerciseSetLandDescription(new SetLandDescription(newLandDescription));
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<ContractId>> exerciseSetLandPropertyPostalCode(
        SetLandPropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_SetLandPropertyPostalCode, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandPropertyPostalCode(
        String newLandPropertyPostalCode) {
      return exerciseSetLandPropertyPostalCode(new SetLandPropertyPostalCode(newLandPropertyPostalCode));
    }

    default Update<Exercised<ContractId>> exerciseSetLandAccessByRoad(SetLandAccessByRoad arg) {
      return makeExerciseCmd(CHOICE_SetLandAccessByRoad, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandAccessByRoad(Boolean newLandAccessByRoad) {
      return exerciseSetLandAccessByRoad(new SetLandAccessByRoad(newLandAccessByRoad));
    }

    default Update<Exercised<Long>> exerciseGetLandBuildableFloors(GetLandBuildableFloors arg) {
      return makeExerciseCmd(CHOICE_GetLandBuildableFloors, arg);
    }

    default Update<Exercised<Long>> exerciseGetLandBuildableFloors() {
      return exerciseGetLandBuildableFloors(new GetLandBuildableFloors());
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

    default Update<Exercised<ContractId>> exerciseSetLandInstrumentKey(SetLandInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_SetLandInstrumentKey, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandInstrumentKey(
        InstrumentKey newLandInstrumentKey) {
      return exerciseSetLandInstrumentKey(new SetLandInstrumentKey(newLandInstrumentKey));
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

    default Update<Exercised<ContractId>> exerciseSetLandBuildableArea(SetLandBuildableArea arg) {
      return makeExerciseCmd(CHOICE_SetLandBuildableArea, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandBuildableArea(
        BigDecimal newBuildableArea) {
      return exerciseSetLandBuildableArea(new SetLandBuildableArea(newBuildableArea));
    }

    default Update<Exercised<String>> exerciseGetLandPropertyCounty(GetLandPropertyCounty arg) {
      return makeExerciseCmd(CHOICE_GetLandPropertyCounty, arg);
    }

    default Update<Exercised<String>> exerciseGetLandPropertyCounty() {
      return exerciseGetLandPropertyCounty(new GetLandPropertyCounty());
    }

    default Update<Exercised<ContractId>> exerciseSetLandPropertyCounty(SetLandPropertyCounty arg) {
      return makeExerciseCmd(CHOICE_SetLandPropertyCounty, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandPropertyCounty(
        String newLandPropertyCounty) {
      return exerciseSetLandPropertyCounty(new SetLandPropertyCounty(newLandPropertyCounty));
    }

    default Update<Exercised<ContractId>> exerciseSetLandPrice(SetLandPrice arg) {
      return makeExerciseCmd(CHOICE_SetLandPrice, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetLandPrice(BigDecimal newLandPrice) {
      return exerciseSetLandPrice(new SetLandPrice(newLandPrice));
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
            View::fromJson,List.of(CHOICE_SetLandPrice, CHOICE_GetLandBuildableArea,
            CHOICE_GetTotalLandArea, CHOICE_GetLandBuildableFloors, CHOICE_SetLandBuildableArea,
            CHOICE_SetLandPropertyDistrict, CHOICE_SetLandPropertyPostalCode,
            CHOICE_GetLandPropertyDistrict, CHOICE_Archive, CHOICE_GetView,
            CHOICE_SetLandInstrumentKey, CHOICE_GetLandPrice, CHOICE_SetLandBuildableFloors,
            CHOICE_SetLandAdditionalInformation, CHOICE_SetLandDescription,
            CHOICE_GetLandDescription, CHOICE_GetLandType, CHOICE_SetLandInstalledEquipment,
            CHOICE_Remove, CHOICE_GetLandInstrumentKey, CHOICE_GetLandInstalledEquipment,
            CHOICE_SetLandPropertyAddress, CHOICE_SetLandPhotoReferences,
            CHOICE_GetLandPhotoReferences, CHOICE_SetLandAccessByRoad, CHOICE_GetLandPropertyCounty,
            CHOICE_SetLandType, CHOICE_SetLandPropertyCounty, CHOICE_GetLandAdditionalInformation,
            CHOICE_SetLandViableConstructionTypes, CHOICE_GetLandPropertyAddress,
            CHOICE_GetLandViableConstructionTypes, CHOICE_SetLandMinimumSurfaceForSale,
            CHOICE_SetTotalLandArea, CHOICE_GetLandMinimumSurfaceForSale,
            CHOICE_GetLandAccessByRoad, CHOICE_GetLandPropertyPostalCode));
    }
  }
}
