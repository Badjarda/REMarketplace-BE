package daml.interface$.propertymanager.property.apartmentproperty.apartmentproperty;

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
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public final class ApartmentProperty {
  public static final Identifier TEMPLATE_ID = new Identifier("8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f", "Interface.PropertyManager.Property.ApartmentProperty.ApartmentProperty", "ApartmentProperty");

  public static final Choice<ApartmentProperty, GetApartmentBathrooms, Long> CHOICE_GetApartmentBathrooms = 
      Choice.create("GetApartmentBathrooms", value$ -> value$.toValue(), value$ ->
        GetApartmentBathrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentPhotoReferences, ContractId> CHOICE_SetApartmentPhotoReferences = 
      Choice.create("SetApartmentPhotoReferences", value$ -> value$.toValue(), value$ ->
        SetApartmentPhotoReferences.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentUsableArea, BigDecimal> CHOICE_GetApartmentUsableArea = 
      Choice.create("GetApartmentUsableArea", value$ -> value$.toValue(), value$ ->
        GetApartmentUsableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentFloor, ContractId> CHOICE_SetApartmentFloor = 
      Choice.create("SetApartmentFloor", value$ -> value$.toValue(), value$ ->
        SetApartmentFloor.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentFloor, Long> CHOICE_GetApartmentFloor = 
      Choice.create("GetApartmentFloor", value$ -> value$.toValue(), value$ ->
        GetApartmentFloor.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromInt64
        .decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentPropertyPostalCode, String> CHOICE_GetApartmentPropertyPostalCode = 
      Choice.create("GetApartmentPropertyPostalCode", value$ -> value$.toValue(), value$ ->
        GetApartmentPropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentPrice, ContractId> CHOICE_SetApartmentPrice = 
      Choice.create("SetApartmentPrice", value$ -> value$.toValue(), value$ ->
        SetApartmentPrice.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentInstrumentKey, InstrumentKey> CHOICE_GetApartmentInstrumentKey = 
      Choice.create("GetApartmentInstrumentKey", value$ -> value$.toValue(), value$ ->
        GetApartmentInstrumentKey.valueDecoder().decode(value$), value$ ->
        InstrumentKey.valueDecoder().decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentBuildDate, LocalDate> CHOICE_GetApartmentBuildDate = 
      Choice.create("GetApartmentBuildDate", value$ -> value$.toValue(), value$ ->
        GetApartmentBuildDate.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromDate.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentInstalledEquipment, ContractId> CHOICE_SetApartmentInstalledEquipment = 
      Choice.create("SetApartmentInstalledEquipment", value$ -> value$.toValue(), value$ ->
        SetApartmentInstalledEquipment.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentPropertyDistrict, String> CHOICE_GetApartmentPropertyDistrict = 
      Choice.create("GetApartmentPropertyDistrict", value$ -> value$.toValue(), value$ ->
        GetApartmentPropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentPhotoReferences, List<String>> CHOICE_GetApartmentPhotoReferences = 
      Choice.create("GetApartmentPhotoReferences", value$ -> value$.toValue(), value$ ->
        GetApartmentPhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromText).decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentInstalledEquipment, String> CHOICE_GetApartmentInstalledEquipment = 
      Choice.create("GetApartmentInstalledEquipment", value$ -> value$.toValue(), value$ ->
        GetApartmentInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentGrossArea, ContractId> CHOICE_SetApartmentGrossArea = 
      Choice.create("SetApartmentGrossArea", value$ -> value$.toValue(), value$ ->
        SetApartmentGrossArea.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, SetApartmentPropertyAddress, ContractId> CHOICE_SetApartmentPropertyAddress = 
      Choice.create("SetApartmentPropertyAddress", value$ -> value$.toValue(), value$ ->
        SetApartmentPropertyAddress.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentElevator, Boolean> CHOICE_GetApartmentElevator = 
      Choice.create("GetApartmentElevator", value$ -> value$.toValue(), value$ ->
        GetApartmentElevator.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromBool.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentPropertyDistrict, ContractId> CHOICE_SetApartmentPropertyDistrict = 
      Choice.create("SetApartmentPropertyDistrict", value$ -> value$.toValue(), value$ ->
        SetApartmentPropertyDistrict.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentInstrumentKey, ContractId> CHOICE_SetApartmentInstrumentKey = 
      Choice.create("SetApartmentInstrumentKey", value$ -> value$.toValue(), value$ ->
        SetApartmentInstrumentKey.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, SetApartmentBathrooms, ContractId> CHOICE_SetApartmentBathrooms = 
      Choice.create("SetApartmentBathrooms", value$ -> value$.toValue(), value$ ->
        SetApartmentBathrooms.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentDescription, String> CHOICE_GetApartmentDescription = 
      Choice.create("GetApartmentDescription", value$ -> value$.toValue(), value$ ->
        GetApartmentDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentAdditionalInformation, ContractId> CHOICE_SetApartmentAdditionalInformation = 
      Choice.create("SetApartmentAdditionalInformation", value$ -> value$.toValue(), value$ ->
        SetApartmentAdditionalInformation.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, SetApartmentUsableArea, ContractId> CHOICE_SetApartmentUsableArea = 
      Choice.create("SetApartmentUsableArea", value$ -> value$.toValue(), value$ ->
        SetApartmentUsableArea.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentParkingSpaces, Long> CHOICE_GetApartmentParkingSpaces = 
      Choice.create("GetApartmentParkingSpaces", value$ -> value$.toValue(), value$ ->
        GetApartmentParkingSpaces.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentPropertyCounty, ContractId> CHOICE_SetApartmentPropertyCounty = 
      Choice.create("SetApartmentPropertyCounty", value$ -> value$.toValue(), value$ ->
        SetApartmentPropertyCounty.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, SetApartmentBuildDate, ContractId> CHOICE_SetApartmentBuildDate = 
      Choice.create("SetApartmentBuildDate", value$ -> value$.toValue(), value$ ->
        SetApartmentBuildDate.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentBedrooms, Long> CHOICE_GetApartmentBedrooms = 
      Choice.create("GetApartmentBedrooms", value$ -> value$.toValue(), value$ ->
        GetApartmentBedrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentElevator, ContractId> CHOICE_SetApartmentElevator = 
      Choice.create("SetApartmentElevator", value$ -> value$.toValue(), value$ ->
        SetApartmentElevator.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentAdditionalInformation, String> CHOICE_GetApartmentAdditionalInformation = 
      Choice.create("GetApartmentAdditionalInformation", value$ -> value$.toValue(), value$ ->
        GetApartmentAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentPropertyPostalCode, ContractId> CHOICE_SetApartmentPropertyPostalCode = 
      Choice.create("SetApartmentPropertyPostalCode", value$ -> value$.toValue(), value$ ->
        SetApartmentPropertyPostalCode.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentGrossArea, BigDecimal> CHOICE_GetApartmentGrossArea = 
      Choice.create("GetApartmentGrossArea", value$ -> value$.toValue(), value$ ->
        GetApartmentGrossArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentPropertyAddress, String> CHOICE_GetApartmentPropertyAddress = 
      Choice.create("GetApartmentPropertyAddress", value$ -> value$.toValue(), value$ ->
        GetApartmentPropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentDescription, ContractId> CHOICE_SetApartmentDescription = 
      Choice.create("SetApartmentDescription", value$ -> value$.toValue(), value$ ->
        SetApartmentDescription.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, SetApartmentBedrooms, ContractId> CHOICE_SetApartmentBedrooms = 
      Choice.create("SetApartmentBedrooms", value$ -> value$.toValue(), value$ ->
        SetApartmentBedrooms.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentPrice, BigDecimal> CHOICE_GetApartmentPrice = 
      Choice.create("GetApartmentPrice", value$ -> value$.toValue(), value$ ->
        GetApartmentPrice.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<ApartmentProperty, SetApartmentParkingSpaces, ContractId> CHOICE_SetApartmentParkingSpaces = 
      Choice.create("SetApartmentParkingSpaces", value$ -> value$.toValue(), value$ ->
        SetApartmentParkingSpaces.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentPropertyCounty, String> CHOICE_GetApartmentPropertyCounty = 
      Choice.create("GetApartmentPropertyCounty", value$ -> value$.toValue(), value$ ->
        GetApartmentPropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private ApartmentProperty() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<ApartmentProperty> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, ApartmentProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Long>> exerciseGetApartmentBathrooms(GetApartmentBathrooms arg) {
      return makeExerciseCmd(CHOICE_GetApartmentBathrooms, arg);
    }

    default Update<Exercised<Long>> exerciseGetApartmentBathrooms() {
      return exerciseGetApartmentBathrooms(new GetApartmentBathrooms());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPhotoReferences(
        SetApartmentPhotoReferences arg) {
      return makeExerciseCmd(CHOICE_SetApartmentPhotoReferences, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPhotoReferences(
        List<String> newPhotoReferences) {
      return exerciseSetApartmentPhotoReferences(new SetApartmentPhotoReferences(newPhotoReferences));
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentUsableArea(
        GetApartmentUsableArea arg) {
      return makeExerciseCmd(CHOICE_GetApartmentUsableArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentUsableArea() {
      return exerciseGetApartmentUsableArea(new GetApartmentUsableArea());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentFloor(SetApartmentFloor arg) {
      return makeExerciseCmd(CHOICE_SetApartmentFloor, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentFloor(Long newApartmentFloor) {
      return exerciseSetApartmentFloor(new SetApartmentFloor(newApartmentFloor));
    }

    default Update<Exercised<Long>> exerciseGetApartmentFloor(GetApartmentFloor arg) {
      return makeExerciseCmd(CHOICE_GetApartmentFloor, arg);
    }

    default Update<Exercised<Long>> exerciseGetApartmentFloor() {
      return exerciseGetApartmentFloor(new GetApartmentFloor());
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyPostalCode(
        GetApartmentPropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_GetApartmentPropertyPostalCode, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyPostalCode() {
      return exerciseGetApartmentPropertyPostalCode(new GetApartmentPropertyPostalCode());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPrice(SetApartmentPrice arg) {
      return makeExerciseCmd(CHOICE_SetApartmentPrice, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPrice(BigDecimal newApartmentPrice) {
      return exerciseSetApartmentPrice(new SetApartmentPrice(newApartmentPrice));
    }

    default Update<Exercised<InstrumentKey>> exerciseGetApartmentInstrumentKey(
        GetApartmentInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_GetApartmentInstrumentKey, arg);
    }

    default Update<Exercised<InstrumentKey>> exerciseGetApartmentInstrumentKey() {
      return exerciseGetApartmentInstrumentKey(new GetApartmentInstrumentKey());
    }

    default Update<Exercised<LocalDate>> exerciseGetApartmentBuildDate(GetApartmentBuildDate arg) {
      return makeExerciseCmd(CHOICE_GetApartmentBuildDate, arg);
    }

    default Update<Exercised<LocalDate>> exerciseGetApartmentBuildDate() {
      return exerciseGetApartmentBuildDate(new GetApartmentBuildDate());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentInstalledEquipment(
        SetApartmentInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_SetApartmentInstalledEquipment, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentInstalledEquipment(
        String newApartmentInstalledEquipment) {
      return exerciseSetApartmentInstalledEquipment(new SetApartmentInstalledEquipment(newApartmentInstalledEquipment));
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyDistrict(
        GetApartmentPropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_GetApartmentPropertyDistrict, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyDistrict() {
      return exerciseGetApartmentPropertyDistrict(new GetApartmentPropertyDistrict());
    }

    default Update<Exercised<List<String>>> exerciseGetApartmentPhotoReferences(
        GetApartmentPhotoReferences arg) {
      return makeExerciseCmd(CHOICE_GetApartmentPhotoReferences, arg);
    }

    default Update<Exercised<List<String>>> exerciseGetApartmentPhotoReferences() {
      return exerciseGetApartmentPhotoReferences(new GetApartmentPhotoReferences());
    }

    default Update<Exercised<String>> exerciseGetApartmentInstalledEquipment(
        GetApartmentInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_GetApartmentInstalledEquipment, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentInstalledEquipment() {
      return exerciseGetApartmentInstalledEquipment(new GetApartmentInstalledEquipment());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentGrossArea(SetApartmentGrossArea arg) {
      return makeExerciseCmd(CHOICE_SetApartmentGrossArea, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentGrossArea(
        BigDecimal newApartmentGrossArea) {
      return exerciseSetApartmentGrossArea(new SetApartmentGrossArea(newApartmentGrossArea));
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPropertyAddress(
        SetApartmentPropertyAddress arg) {
      return makeExerciseCmd(CHOICE_SetApartmentPropertyAddress, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPropertyAddress(
        String newApartmentPropertyAddress) {
      return exerciseSetApartmentPropertyAddress(new SetApartmentPropertyAddress(newApartmentPropertyAddress));
    }

    default Update<Exercised<Boolean>> exerciseGetApartmentElevator(GetApartmentElevator arg) {
      return makeExerciseCmd(CHOICE_GetApartmentElevator, arg);
    }

    default Update<Exercised<Boolean>> exerciseGetApartmentElevator() {
      return exerciseGetApartmentElevator(new GetApartmentElevator());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPropertyDistrict(
        SetApartmentPropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_SetApartmentPropertyDistrict, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPropertyDistrict(
        String newApartmentPropertyDistrict) {
      return exerciseSetApartmentPropertyDistrict(new SetApartmentPropertyDistrict(newApartmentPropertyDistrict));
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentInstrumentKey(
        SetApartmentInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_SetApartmentInstrumentKey, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentInstrumentKey(
        InstrumentKey newApartmentInstrumentKey) {
      return exerciseSetApartmentInstrumentKey(new SetApartmentInstrumentKey(newApartmentInstrumentKey));
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentBathrooms(SetApartmentBathrooms arg) {
      return makeExerciseCmd(CHOICE_SetApartmentBathrooms, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentBathrooms(
        Long newApartmentBathrooms) {
      return exerciseSetApartmentBathrooms(new SetApartmentBathrooms(newApartmentBathrooms));
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<String>> exerciseGetApartmentDescription(GetApartmentDescription arg) {
      return makeExerciseCmd(CHOICE_GetApartmentDescription, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentDescription() {
      return exerciseGetApartmentDescription(new GetApartmentDescription());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentAdditionalInformation(
        SetApartmentAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_SetApartmentAdditionalInformation, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentAdditionalInformation(
        String newApartmentAdditionalInformation) {
      return exerciseSetApartmentAdditionalInformation(new SetApartmentAdditionalInformation(newApartmentAdditionalInformation));
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentUsableArea(
        SetApartmentUsableArea arg) {
      return makeExerciseCmd(CHOICE_SetApartmentUsableArea, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentUsableArea(
        BigDecimal newApartmentUsableArea) {
      return exerciseSetApartmentUsableArea(new SetApartmentUsableArea(newApartmentUsableArea));
    }

    default Update<Exercised<Long>> exerciseGetApartmentParkingSpaces(
        GetApartmentParkingSpaces arg) {
      return makeExerciseCmd(CHOICE_GetApartmentParkingSpaces, arg);
    }

    default Update<Exercised<Long>> exerciseGetApartmentParkingSpaces() {
      return exerciseGetApartmentParkingSpaces(new GetApartmentParkingSpaces());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPropertyCounty(
        SetApartmentPropertyCounty arg) {
      return makeExerciseCmd(CHOICE_SetApartmentPropertyCounty, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPropertyCounty(
        String newApartmentPropertyCounty) {
      return exerciseSetApartmentPropertyCounty(new SetApartmentPropertyCounty(newApartmentPropertyCounty));
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentBuildDate(SetApartmentBuildDate arg) {
      return makeExerciseCmd(CHOICE_SetApartmentBuildDate, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentBuildDate(
        LocalDate newApartmentBuildDate) {
      return exerciseSetApartmentBuildDate(new SetApartmentBuildDate(newApartmentBuildDate));
    }

    default Update<Exercised<Long>> exerciseGetApartmentBedrooms(GetApartmentBedrooms arg) {
      return makeExerciseCmd(CHOICE_GetApartmentBedrooms, arg);
    }

    default Update<Exercised<Long>> exerciseGetApartmentBedrooms() {
      return exerciseGetApartmentBedrooms(new GetApartmentBedrooms());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentElevator(SetApartmentElevator arg) {
      return makeExerciseCmd(CHOICE_SetApartmentElevator, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentElevator(
        Boolean newApartmentElevator) {
      return exerciseSetApartmentElevator(new SetApartmentElevator(newApartmentElevator));
    }

    default Update<Exercised<String>> exerciseGetApartmentAdditionalInformation(
        GetApartmentAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_GetApartmentAdditionalInformation, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentAdditionalInformation() {
      return exerciseGetApartmentAdditionalInformation(new GetApartmentAdditionalInformation());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPropertyPostalCode(
        SetApartmentPropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_SetApartmentPropertyPostalCode, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentPropertyPostalCode(
        String newApartmentPropertyPostalCode) {
      return exerciseSetApartmentPropertyPostalCode(new SetApartmentPropertyPostalCode(newApartmentPropertyPostalCode));
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentGrossArea(GetApartmentGrossArea arg) {
      return makeExerciseCmd(CHOICE_GetApartmentGrossArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentGrossArea() {
      return exerciseGetApartmentGrossArea(new GetApartmentGrossArea());
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyAddress(
        GetApartmentPropertyAddress arg) {
      return makeExerciseCmd(CHOICE_GetApartmentPropertyAddress, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyAddress() {
      return exerciseGetApartmentPropertyAddress(new GetApartmentPropertyAddress());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentDescription(
        SetApartmentDescription arg) {
      return makeExerciseCmd(CHOICE_SetApartmentDescription, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentDescription(
        String newApartmentDescription) {
      return exerciseSetApartmentDescription(new SetApartmentDescription(newApartmentDescription));
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentBedrooms(SetApartmentBedrooms arg) {
      return makeExerciseCmd(CHOICE_SetApartmentBedrooms, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentBedrooms(Long newApartmentBedrooms) {
      return exerciseSetApartmentBedrooms(new SetApartmentBedrooms(newApartmentBedrooms));
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentPrice(GetApartmentPrice arg) {
      return makeExerciseCmd(CHOICE_GetApartmentPrice, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentPrice() {
      return exerciseGetApartmentPrice(new GetApartmentPrice());
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentParkingSpaces(
        SetApartmentParkingSpaces arg) {
      return makeExerciseCmd(CHOICE_SetApartmentParkingSpaces, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetApartmentParkingSpaces(
        Long newApartmentParkingSpaces) {
      return exerciseSetApartmentParkingSpaces(new SetApartmentParkingSpaces(newApartmentParkingSpaces));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyCounty(
        GetApartmentPropertyCounty arg) {
      return makeExerciseCmd(CHOICE_GetApartmentPropertyCounty, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyCounty() {
      return exerciseGetApartmentPropertyCounty(new GetApartmentPropertyCounty());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, ApartmentProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, ApartmentProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<ApartmentProperty, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.propertymanager.property.apartmentproperty.apartmentproperty.ApartmentProperty", ApartmentProperty.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_SetApartmentPropertyCounty, CHOICE_GetApartmentFloor,
            CHOICE_GetApartmentElevator, CHOICE_GetView, CHOICE_SetApartmentBedrooms,
            CHOICE_SetApartmentElevator, CHOICE_SetApartmentUsableArea,
            CHOICE_SetApartmentPhotoReferences, CHOICE_SetApartmentGrossArea,
            CHOICE_GetApartmentInstrumentKey, CHOICE_SetApartmentBuildDate, CHOICE_Remove,
            CHOICE_GetApartmentBuildDate, CHOICE_SetApartmentPropertyDistrict,
            CHOICE_GetApartmentInstalledEquipment, CHOICE_GetApartmentPhotoReferences,
            CHOICE_GetApartmentParkingSpaces, CHOICE_SetApartmentPrice,
            CHOICE_SetApartmentPropertyPostalCode, CHOICE_SetApartmentBathrooms,
            CHOICE_GetApartmentAdditionalInformation, CHOICE_SetApartmentInstalledEquipment,
            CHOICE_Archive, CHOICE_GetApartmentPropertyDistrict, CHOICE_SetApartmentParkingSpaces,
            CHOICE_SetApartmentFloor, CHOICE_GetApartmentBathrooms,
            CHOICE_SetApartmentAdditionalInformation, CHOICE_GetApartmentDescription,
            CHOICE_GetApartmentPropertyPostalCode, CHOICE_GetApartmentGrossArea,
            CHOICE_GetApartmentUsableArea, CHOICE_GetApartmentPropertyAddress,
            CHOICE_SetApartmentPropertyAddress, CHOICE_SetApartmentDescription,
            CHOICE_GetApartmentPrice, CHOICE_GetApartmentBedrooms,
            CHOICE_GetApartmentPropertyCounty, CHOICE_SetApartmentInstrumentKey));
    }
  }
}
