package daml.interface$.propertymanager.property.residenceproperty.residenceproperty;

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
import daml.interface$.propertymanager.property.common.Orientation;
import daml.interface$.propertymanager.property.common.Parking;
import daml.interface$.propertymanager.property.common.ResidenceType;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public final class ResidenceProperty {
  public static final Identifier TEMPLATE_ID = new Identifier("e09e7a18c217e8002e4a374c04915d394e5120e173ac8f1ee6decbc2d8c3c8b4", "Interface.PropertyManager.Property.ResidenceProperty.ResidenceProperty", "ResidenceProperty");

  public static final Choice<ResidenceProperty, SetResidencePropertyAddress, ContractId> CHOICE_SetResidencePropertyAddress = 
      Choice.create("SetResidencePropertyAddress", value$ -> value$.toValue(), value$ ->
        SetResidencePropertyAddress.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, SetResidencePropertyCounty, ContractId> CHOICE_SetResidencePropertyCounty = 
      Choice.create("SetResidencePropertyCounty", value$ -> value$.toValue(), value$ ->
        SetResidencePropertyCounty.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, SetResidenceFloors, ContractId> CHOICE_SetResidenceFloors = 
      Choice.create("SetResidenceFloors", value$ -> value$.toValue(), value$ ->
        SetResidenceFloors.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetResidenceBuildDate, LocalDate> CHOICE_GetResidenceBuildDate = 
      Choice.create("GetResidenceBuildDate", value$ -> value$.toValue(), value$ ->
        GetResidenceBuildDate.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromDate.decode(value$));

  public static final Choice<ResidenceProperty, GetResidenceBackyard, String> CHOICE_GetResidenceBackyard = 
      Choice.create("GetResidenceBackyard", value$ -> value$.toValue(), value$ ->
        GetResidenceBackyard.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ResidenceProperty, GetResidenceInstalledEquipment, String> CHOICE_GetResidenceInstalledEquipment = 
      Choice.create("GetResidenceInstalledEquipment", value$ -> value$.toValue(), value$ ->
        GetResidenceInstalledEquipment.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ResidenceProperty, SetResidenceOrientation, ContractId> CHOICE_SetResidenceOrientation = 
      Choice.create("SetResidenceOrientation", value$ -> value$.toValue(), value$ ->
        SetResidenceOrientation.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetResidencePropertyAddress, String> CHOICE_GetResidencePropertyAddress = 
      Choice.create("GetResidencePropertyAddress", value$ -> value$.toValue(), value$ ->
        GetResidencePropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ResidenceProperty, SetResidencePhotoReferences, ContractId> CHOICE_SetResidencePhotoReferences = 
      Choice.create("SetResidencePhotoReferences", value$ -> value$.toValue(), value$ ->
        SetResidencePhotoReferences.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, SetResidencePrice, ContractId> CHOICE_SetResidencePrice = 
      Choice.create("SetResidencePrice", value$ -> value$.toValue(), value$ ->
        SetResidencePrice.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetResidenceOrientation, Orientation> CHOICE_GetResidenceOrientation = 
      Choice.create("GetResidenceOrientation", value$ -> value$.toValue(), value$ ->
        GetResidenceOrientation.valueDecoder().decode(value$), value$ -> Orientation.valueDecoder()
        .decode(value$));

  public static final Choice<ResidenceProperty, GetResidencePropertyCounty, String> CHOICE_GetResidencePropertyCounty = 
      Choice.create("GetResidencePropertyCounty", value$ -> value$.toValue(), value$ ->
        GetResidencePropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ResidenceProperty, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<ResidenceProperty, SetResidenceParking, ContractId> CHOICE_SetResidenceParking = 
      Choice.create("SetResidenceParking", value$ -> value$.toValue(), value$ ->
        SetResidenceParking.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, SetResidenceBathrooms, ContractId> CHOICE_SetResidenceBathrooms = 
      Choice.create("SetResidenceBathrooms", value$ -> value$.toValue(), value$ ->
        SetResidenceBathrooms.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetResidenceAdditionalInformation, String> CHOICE_GetResidenceAdditionalInformation = 
      Choice.create("GetResidenceAdditionalInformation", value$ -> value$.toValue(), value$ ->
        GetResidenceAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ResidenceProperty, GetResidenceFloors, Long> CHOICE_GetResidenceFloors = 
      Choice.create("GetResidenceFloors", value$ -> value$.toValue(), value$ ->
        GetResidenceFloors.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromInt64
        .decode(value$));

  public static final Choice<ResidenceProperty, GetResidenceGrossArea, BigDecimal> CHOICE_GetResidenceGrossArea = 
      Choice.create("GetResidenceGrossArea", value$ -> value$.toValue(), value$ ->
        GetResidenceGrossArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<ResidenceProperty, SetResidenceUsableArea, ContractId> CHOICE_SetResidenceUsableArea = 
      Choice.create("SetResidenceUsableArea", value$ -> value$.toValue(), value$ ->
        SetResidenceUsableArea.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, SetResidenceBuildDate, ContractId> CHOICE_SetResidenceBuildDate = 
      Choice.create("SetResidenceBuildDate", value$ -> value$.toValue(), value$ ->
        SetResidenceBuildDate.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetResidenceInstrumentKey, InstrumentKey> CHOICE_GetResidenceInstrumentKey = 
      Choice.create("GetResidenceInstrumentKey", value$ -> value$.toValue(), value$ ->
        GetResidenceInstrumentKey.valueDecoder().decode(value$), value$ ->
        InstrumentKey.valueDecoder().decode(value$));

  public static final Choice<ResidenceProperty, GetResidenceUsableArea, BigDecimal> CHOICE_GetResidenceUsableArea = 
      Choice.create("GetResidenceUsableArea", value$ -> value$.toValue(), value$ ->
        GetResidenceUsableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<ResidenceProperty, SetResidenceInstalledEquipment, ContractId> CHOICE_SetResidenceInstalledEquipment = 
      Choice.create("SetResidenceInstalledEquipment", value$ -> value$.toValue(), value$ ->
        SetResidenceInstalledEquipment.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<ResidenceProperty, GetResidencePropertyDistrict, String> CHOICE_GetResidencePropertyDistrict = 
      Choice.create("GetResidencePropertyDistrict", value$ -> value$.toValue(), value$ ->
        GetResidencePropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ResidenceProperty, GetResidenceBathrooms, Long> CHOICE_GetResidenceBathrooms = 
      Choice.create("GetResidenceBathrooms", value$ -> value$.toValue(), value$ ->
        GetResidenceBathrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<ResidenceProperty, SetResidenceGrossArea, ContractId> CHOICE_SetResidenceGrossArea = 
      Choice.create("SetResidenceGrossArea", value$ -> value$.toValue(), value$ ->
        SetResidenceGrossArea.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<ResidenceProperty, GetResidenceBedrooms, Long> CHOICE_GetResidenceBedrooms = 
      Choice.create("GetResidenceBedrooms", value$ -> value$.toValue(), value$ ->
        GetResidenceBedrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<ResidenceProperty, SetResidenceInstrumentKey, ContractId> CHOICE_SetResidenceInstrumentKey = 
      Choice.create("SetResidenceInstrumentKey", value$ -> value$.toValue(), value$ ->
        SetResidenceInstrumentKey.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetResidenceParking, Parking> CHOICE_GetResidenceParking = 
      Choice.create("GetResidenceParking", value$ -> value$.toValue(), value$ ->
        GetResidenceParking.valueDecoder().decode(value$), value$ -> Parking.valueDecoder()
        .decode(value$));

  public static final Choice<ResidenceProperty, SetResidencePropertyPostalCode, ContractId> CHOICE_SetResidencePropertyPostalCode = 
      Choice.create("SetResidencePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        SetResidencePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, SetResidenceType, ContractId> CHOICE_SetResidenceType = 
      Choice.create("SetResidenceType", value$ -> value$.toValue(), value$ ->
        SetResidenceType.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, SetResidenceAdditionalInformation, ContractId> CHOICE_SetResidenceAdditionalInformation = 
      Choice.create("SetResidenceAdditionalInformation", value$ -> value$.toValue(), value$ ->
        SetResidenceAdditionalInformation.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, SetResidencePropertyDistrict, ContractId> CHOICE_SetResidencePropertyDistrict = 
      Choice.create("SetResidencePropertyDistrict", value$ -> value$.toValue(), value$ ->
        SetResidencePropertyDistrict.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetResidenceType, ResidenceType> CHOICE_GetResidenceType = 
      Choice.create("GetResidenceType", value$ -> value$.toValue(), value$ ->
        GetResidenceType.valueDecoder().decode(value$), value$ -> ResidenceType.valueDecoder()
        .decode(value$));

  public static final Choice<ResidenceProperty, GetResidencePhotoReferences, List<String>> CHOICE_GetResidencePhotoReferences = 
      Choice.create("GetResidencePhotoReferences", value$ -> value$.toValue(), value$ ->
        GetResidencePhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromText).decode(value$));

  public static final Choice<ResidenceProperty, GetResidenceDescription, String> CHOICE_GetResidenceDescription = 
      Choice.create("GetResidenceDescription", value$ -> value$.toValue(), value$ ->
        GetResidenceDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ResidenceProperty, SetResidenceBackyard, ContractId> CHOICE_SetResidenceBackyard = 
      Choice.create("SetResidenceBackyard", value$ -> value$.toValue(), value$ ->
        SetResidenceBackyard.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, SetResidenceDescription, ContractId> CHOICE_SetResidenceDescription = 
      Choice.create("SetResidenceDescription", value$ -> value$.toValue(), value$ ->
        SetResidenceDescription.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetResidencePrice, BigDecimal> CHOICE_GetResidencePrice = 
      Choice.create("GetResidencePrice", value$ -> value$.toValue(), value$ ->
        GetResidencePrice.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<ResidenceProperty, SetResidenceBedrooms, ContractId> CHOICE_SetResidenceBedrooms = 
      Choice.create("SetResidenceBedrooms", value$ -> value$.toValue(), value$ ->
        SetResidenceBedrooms.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ResidenceProperty, GetResidencePropertyPostalCode, String> CHOICE_GetResidencePropertyPostalCode = 
      Choice.create("GetResidencePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        GetResidencePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private ResidenceProperty() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<ResidenceProperty> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, ResidenceProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<ContractId>> exerciseSetResidencePropertyAddress(
        SetResidencePropertyAddress arg) {
      return makeExerciseCmd(CHOICE_SetResidencePropertyAddress, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePropertyAddress(
        String newResidencePropertyAddress) {
      return exerciseSetResidencePropertyAddress(new SetResidencePropertyAddress(newResidencePropertyAddress));
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePropertyCounty(
        SetResidencePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_SetResidencePropertyCounty, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePropertyCounty(
        String newResidencePropertyCounty) {
      return exerciseSetResidencePropertyCounty(new SetResidencePropertyCounty(newResidencePropertyCounty));
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceFloors(SetResidenceFloors arg) {
      return makeExerciseCmd(CHOICE_SetResidenceFloors, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceFloors(Long newResidenceFloors) {
      return exerciseSetResidenceFloors(new SetResidenceFloors(newResidenceFloors));
    }

    default Update<Exercised<LocalDate>> exerciseGetResidenceBuildDate(GetResidenceBuildDate arg) {
      return makeExerciseCmd(CHOICE_GetResidenceBuildDate, arg);
    }

    default Update<Exercised<LocalDate>> exerciseGetResidenceBuildDate() {
      return exerciseGetResidenceBuildDate(new GetResidenceBuildDate());
    }

    default Update<Exercised<String>> exerciseGetResidenceBackyard(GetResidenceBackyard arg) {
      return makeExerciseCmd(CHOICE_GetResidenceBackyard, arg);
    }

    default Update<Exercised<String>> exerciseGetResidenceBackyard() {
      return exerciseGetResidenceBackyard(new GetResidenceBackyard());
    }

    default Update<Exercised<String>> exerciseGetResidenceInstalledEquipment(
        GetResidenceInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_GetResidenceInstalledEquipment, arg);
    }

    default Update<Exercised<String>> exerciseGetResidenceInstalledEquipment() {
      return exerciseGetResidenceInstalledEquipment(new GetResidenceInstalledEquipment());
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceOrientation(
        SetResidenceOrientation arg) {
      return makeExerciseCmd(CHOICE_SetResidenceOrientation, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceOrientation(
        Orientation newOrientation) {
      return exerciseSetResidenceOrientation(new SetResidenceOrientation(newOrientation));
    }

    default Update<Exercised<String>> exerciseGetResidencePropertyAddress(
        GetResidencePropertyAddress arg) {
      return makeExerciseCmd(CHOICE_GetResidencePropertyAddress, arg);
    }

    default Update<Exercised<String>> exerciseGetResidencePropertyAddress() {
      return exerciseGetResidencePropertyAddress(new GetResidencePropertyAddress());
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePhotoReferences(
        SetResidencePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_SetResidencePhotoReferences, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePhotoReferences(
        List<String> newPhotoReferences) {
      return exerciseSetResidencePhotoReferences(new SetResidencePhotoReferences(newPhotoReferences));
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePrice(SetResidencePrice arg) {
      return makeExerciseCmd(CHOICE_SetResidencePrice, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePrice(BigDecimal newResidencePrice) {
      return exerciseSetResidencePrice(new SetResidencePrice(newResidencePrice));
    }

    default Update<Exercised<Orientation>> exerciseGetResidenceOrientation(
        GetResidenceOrientation arg) {
      return makeExerciseCmd(CHOICE_GetResidenceOrientation, arg);
    }

    default Update<Exercised<Orientation>> exerciseGetResidenceOrientation() {
      return exerciseGetResidenceOrientation(new GetResidenceOrientation());
    }

    default Update<Exercised<String>> exerciseGetResidencePropertyCounty(
        GetResidencePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_GetResidencePropertyCounty, arg);
    }

    default Update<Exercised<String>> exerciseGetResidencePropertyCounty() {
      return exerciseGetResidencePropertyCounty(new GetResidencePropertyCounty());
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceParking(SetResidenceParking arg) {
      return makeExerciseCmd(CHOICE_SetResidenceParking, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceParking(Parking newResidenceParking) {
      return exerciseSetResidenceParking(new SetResidenceParking(newResidenceParking));
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceBathrooms(SetResidenceBathrooms arg) {
      return makeExerciseCmd(CHOICE_SetResidenceBathrooms, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceBathrooms(
        Long newResidenceBathrooms) {
      return exerciseSetResidenceBathrooms(new SetResidenceBathrooms(newResidenceBathrooms));
    }

    default Update<Exercised<String>> exerciseGetResidenceAdditionalInformation(
        GetResidenceAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_GetResidenceAdditionalInformation, arg);
    }

    default Update<Exercised<String>> exerciseGetResidenceAdditionalInformation() {
      return exerciseGetResidenceAdditionalInformation(new GetResidenceAdditionalInformation());
    }

    default Update<Exercised<Long>> exerciseGetResidenceFloors(GetResidenceFloors arg) {
      return makeExerciseCmd(CHOICE_GetResidenceFloors, arg);
    }

    default Update<Exercised<Long>> exerciseGetResidenceFloors() {
      return exerciseGetResidenceFloors(new GetResidenceFloors());
    }

    default Update<Exercised<BigDecimal>> exerciseGetResidenceGrossArea(GetResidenceGrossArea arg) {
      return makeExerciseCmd(CHOICE_GetResidenceGrossArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetResidenceGrossArea() {
      return exerciseGetResidenceGrossArea(new GetResidenceGrossArea());
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceUsableArea(
        SetResidenceUsableArea arg) {
      return makeExerciseCmd(CHOICE_SetResidenceUsableArea, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceUsableArea(
        BigDecimal newResidenceUsableArea) {
      return exerciseSetResidenceUsableArea(new SetResidenceUsableArea(newResidenceUsableArea));
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceBuildDate(SetResidenceBuildDate arg) {
      return makeExerciseCmd(CHOICE_SetResidenceBuildDate, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceBuildDate(
        LocalDate newResidenceBuildDate) {
      return exerciseSetResidenceBuildDate(new SetResidenceBuildDate(newResidenceBuildDate));
    }

    default Update<Exercised<InstrumentKey>> exerciseGetResidenceInstrumentKey(
        GetResidenceInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_GetResidenceInstrumentKey, arg);
    }

    default Update<Exercised<InstrumentKey>> exerciseGetResidenceInstrumentKey() {
      return exerciseGetResidenceInstrumentKey(new GetResidenceInstrumentKey());
    }

    default Update<Exercised<BigDecimal>> exerciseGetResidenceUsableArea(
        GetResidenceUsableArea arg) {
      return makeExerciseCmd(CHOICE_GetResidenceUsableArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetResidenceUsableArea() {
      return exerciseGetResidenceUsableArea(new GetResidenceUsableArea());
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceInstalledEquipment(
        SetResidenceInstalledEquipment arg) {
      return makeExerciseCmd(CHOICE_SetResidenceInstalledEquipment, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceInstalledEquipment(
        String newResidenceInstalledEquipment) {
      return exerciseSetResidenceInstalledEquipment(new SetResidenceInstalledEquipment(newResidenceInstalledEquipment));
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<String>> exerciseGetResidencePropertyDistrict(
        GetResidencePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_GetResidencePropertyDistrict, arg);
    }

    default Update<Exercised<String>> exerciseGetResidencePropertyDistrict() {
      return exerciseGetResidencePropertyDistrict(new GetResidencePropertyDistrict());
    }

    default Update<Exercised<Long>> exerciseGetResidenceBathrooms(GetResidenceBathrooms arg) {
      return makeExerciseCmd(CHOICE_GetResidenceBathrooms, arg);
    }

    default Update<Exercised<Long>> exerciseGetResidenceBathrooms() {
      return exerciseGetResidenceBathrooms(new GetResidenceBathrooms());
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceGrossArea(SetResidenceGrossArea arg) {
      return makeExerciseCmd(CHOICE_SetResidenceGrossArea, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceGrossArea(
        BigDecimal newResidenceGrossArea) {
      return exerciseSetResidenceGrossArea(new SetResidenceGrossArea(newResidenceGrossArea));
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<Long>> exerciseGetResidenceBedrooms(GetResidenceBedrooms arg) {
      return makeExerciseCmd(CHOICE_GetResidenceBedrooms, arg);
    }

    default Update<Exercised<Long>> exerciseGetResidenceBedrooms() {
      return exerciseGetResidenceBedrooms(new GetResidenceBedrooms());
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceInstrumentKey(
        SetResidenceInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_SetResidenceInstrumentKey, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceInstrumentKey(
        InstrumentKey newResidenceInstrumentKey) {
      return exerciseSetResidenceInstrumentKey(new SetResidenceInstrumentKey(newResidenceInstrumentKey));
    }

    default Update<Exercised<Parking>> exerciseGetResidenceParking(GetResidenceParking arg) {
      return makeExerciseCmd(CHOICE_GetResidenceParking, arg);
    }

    default Update<Exercised<Parking>> exerciseGetResidenceParking() {
      return exerciseGetResidenceParking(new GetResidenceParking());
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePropertyPostalCode(
        SetResidencePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_SetResidencePropertyPostalCode, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePropertyPostalCode(
        String newResidencePropertyPostalCode) {
      return exerciseSetResidencePropertyPostalCode(new SetResidencePropertyPostalCode(newResidencePropertyPostalCode));
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceType(SetResidenceType arg) {
      return makeExerciseCmd(CHOICE_SetResidenceType, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceType(ResidenceType newResidenceType) {
      return exerciseSetResidenceType(new SetResidenceType(newResidenceType));
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceAdditionalInformation(
        SetResidenceAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_SetResidenceAdditionalInformation, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceAdditionalInformation(
        String newResidenceAdditionalInformation) {
      return exerciseSetResidenceAdditionalInformation(new SetResidenceAdditionalInformation(newResidenceAdditionalInformation));
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePropertyDistrict(
        SetResidencePropertyDistrict arg) {
      return makeExerciseCmd(CHOICE_SetResidencePropertyDistrict, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidencePropertyDistrict(
        String newResidencePropertyDistrict) {
      return exerciseSetResidencePropertyDistrict(new SetResidencePropertyDistrict(newResidencePropertyDistrict));
    }

    default Update<Exercised<ResidenceType>> exerciseGetResidenceType(GetResidenceType arg) {
      return makeExerciseCmd(CHOICE_GetResidenceType, arg);
    }

    default Update<Exercised<ResidenceType>> exerciseGetResidenceType() {
      return exerciseGetResidenceType(new GetResidenceType());
    }

    default Update<Exercised<List<String>>> exerciseGetResidencePhotoReferences(
        GetResidencePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_GetResidencePhotoReferences, arg);
    }

    default Update<Exercised<List<String>>> exerciseGetResidencePhotoReferences() {
      return exerciseGetResidencePhotoReferences(new GetResidencePhotoReferences());
    }

    default Update<Exercised<String>> exerciseGetResidenceDescription(GetResidenceDescription arg) {
      return makeExerciseCmd(CHOICE_GetResidenceDescription, arg);
    }

    default Update<Exercised<String>> exerciseGetResidenceDescription() {
      return exerciseGetResidenceDescription(new GetResidenceDescription());
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceBackyard(SetResidenceBackyard arg) {
      return makeExerciseCmd(CHOICE_SetResidenceBackyard, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceBackyard(
        String newResidenceBackyard) {
      return exerciseSetResidenceBackyard(new SetResidenceBackyard(newResidenceBackyard));
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceDescription(
        SetResidenceDescription arg) {
      return makeExerciseCmd(CHOICE_SetResidenceDescription, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceDescription(
        String newResidenceDescription) {
      return exerciseSetResidenceDescription(new SetResidenceDescription(newResidenceDescription));
    }

    default Update<Exercised<BigDecimal>> exerciseGetResidencePrice(GetResidencePrice arg) {
      return makeExerciseCmd(CHOICE_GetResidencePrice, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetResidencePrice() {
      return exerciseGetResidencePrice(new GetResidencePrice());
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceBedrooms(SetResidenceBedrooms arg) {
      return makeExerciseCmd(CHOICE_SetResidenceBedrooms, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetResidenceBedrooms(Long newResidenceBedrooms) {
      return exerciseSetResidenceBedrooms(new SetResidenceBedrooms(newResidenceBedrooms));
    }

    default Update<Exercised<String>> exerciseGetResidencePropertyPostalCode(
        GetResidencePropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_GetResidencePropertyPostalCode, arg);
    }

    default Update<Exercised<String>> exerciseGetResidencePropertyPostalCode() {
      return exerciseGetResidencePropertyPostalCode(new GetResidencePropertyPostalCode());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, ResidenceProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, ResidenceProperty, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<ResidenceProperty, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.propertymanager.property.residenceproperty.residenceproperty.ResidenceProperty", ResidenceProperty.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_GetResidenceBedrooms, CHOICE_GetResidenceBathrooms,
            CHOICE_GetResidenceOrientation, CHOICE_GetResidencePhotoReferences, CHOICE_Archive,
            CHOICE_SetResidenceGrossArea, CHOICE_GetResidenceInstrumentKey,
            CHOICE_SetResidenceBedrooms, CHOICE_GetResidenceBuildDate,
            CHOICE_SetResidenceInstrumentKey, CHOICE_GetResidenceInstalledEquipment,
            CHOICE_SetResidenceInstalledEquipment, CHOICE_GetResidencePropertyPostalCode,
            CHOICE_GetResidenceFloors, CHOICE_GetResidencePropertyCounty,
            CHOICE_SetResidenceUsableArea, CHOICE_SetResidencePropertyAddress,
            CHOICE_SetResidenceParking, CHOICE_Remove, CHOICE_GetResidencePrice,
            CHOICE_SetResidenceType, CHOICE_SetResidenceDescription, CHOICE_GetResidenceBackyard,
            CHOICE_GetResidenceGrossArea, CHOICE_GetResidenceUsableArea,
            CHOICE_GetResidenceAdditionalInformation, CHOICE_SetResidenceBuildDate,
            CHOICE_SetResidencePhotoReferences, CHOICE_SetResidencePropertyDistrict, CHOICE_GetView,
            CHOICE_SetResidenceFloors, CHOICE_SetResidenceOrientation,
            CHOICE_SetResidencePropertyPostalCode, CHOICE_GetResidencePropertyAddress,
            CHOICE_GetResidenceParking, CHOICE_SetResidenceBathrooms, CHOICE_GetResidenceType,
            CHOICE_GetResidenceDescription, CHOICE_GetResidencePropertyDistrict,
            CHOICE_SetResidencePropertyCounty, CHOICE_SetResidenceAdditionalInformation,
            CHOICE_SetResidencePrice, CHOICE_SetResidenceBackyard));
    }
  }
}
