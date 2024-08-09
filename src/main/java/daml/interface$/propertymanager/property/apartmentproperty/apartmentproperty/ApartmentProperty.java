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
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.PropertyManager.Property.ApartmentProperty.ApartmentProperty", "ApartmentProperty");

  public static final Choice<ApartmentProperty, GetApartmentBathrooms, Long> CHOICE_GetApartmentBathrooms = 
      Choice.create("GetApartmentBathrooms", value$ -> value$.toValue(), value$ ->
        GetApartmentBathrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentUsableArea, BigDecimal> CHOICE_GetApartmentUsableArea = 
      Choice.create("GetApartmentUsableArea", value$ -> value$.toValue(), value$ ->
        GetApartmentUsableArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<ApartmentProperty, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentFloor, Long> CHOICE_GetApartmentFloor = 
      Choice.create("GetApartmentFloor", value$ -> value$.toValue(), value$ ->
        GetApartmentFloor.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromInt64
        .decode(value$));

  public static final Choice<ApartmentProperty, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentPropertyPostalCode, String> CHOICE_GetApartmentPropertyPostalCode = 
      Choice.create("GetApartmentPropertyPostalCode", value$ -> value$.toValue(), value$ ->
        GetApartmentPropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentDescription, String> CHOICE_GetApartmentDescription = 
      Choice.create("GetApartmentDescription", value$ -> value$.toValue(), value$ ->
        GetApartmentDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentParkingSpaces, Long> CHOICE_GetApartmentParkingSpaces = 
      Choice.create("GetApartmentParkingSpaces", value$ -> value$.toValue(), value$ ->
        GetApartmentParkingSpaces.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<ApartmentProperty, UpdateApartment, ContractId> CHOICE_UpdateApartment = 
      Choice.create("UpdateApartment", value$ -> value$.toValue(), value$ ->
        UpdateApartment.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<ApartmentProperty, GetApartmentGrossArea, BigDecimal> CHOICE_GetApartmentGrossArea = 
      Choice.create("GetApartmentGrossArea", value$ -> value$.toValue(), value$ ->
        GetApartmentGrossArea.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentInstrumentKey, InstrumentKey> CHOICE_GetApartmentInstrumentKey = 
      Choice.create("GetApartmentInstrumentKey", value$ -> value$.toValue(), value$ ->
        GetApartmentInstrumentKey.valueDecoder().decode(value$), value$ ->
        InstrumentKey.valueDecoder().decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentBuildDate, LocalDate> CHOICE_GetApartmentBuildDate = 
      Choice.create("GetApartmentBuildDate", value$ -> value$.toValue(), value$ ->
        GetApartmentBuildDate.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromDate.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentPropertyAddress, String> CHOICE_GetApartmentPropertyAddress = 
      Choice.create("GetApartmentPropertyAddress", value$ -> value$.toValue(), value$ ->
        GetApartmentPropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentPrice, BigDecimal> CHOICE_GetApartmentPrice = 
      Choice.create("GetApartmentPrice", value$ -> value$.toValue(), value$ ->
        GetApartmentPrice.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromNumeric.decode(value$));

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

  public static final Choice<ApartmentProperty, GetApartmentElevator, Boolean> CHOICE_GetApartmentElevator = 
      Choice.create("GetApartmentElevator", value$ -> value$.toValue(), value$ ->
        GetApartmentElevator.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromBool.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentBedrooms, Long> CHOICE_GetApartmentBedrooms = 
      Choice.create("GetApartmentBedrooms", value$ -> value$.toValue(), value$ ->
        GetApartmentBedrooms.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<ApartmentProperty, GetApartmentAdditionalInformation, String> CHOICE_GetApartmentAdditionalInformation = 
      Choice.create("GetApartmentAdditionalInformation", value$ -> value$.toValue(), value$ ->
        GetApartmentAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

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

    default Update<Exercised<BigDecimal>> exerciseGetApartmentUsableArea(
        GetApartmentUsableArea arg) {
      return makeExerciseCmd(CHOICE_GetApartmentUsableArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentUsableArea() {
      return exerciseGetApartmentUsableArea(new GetApartmentUsableArea());
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<Long>> exerciseGetApartmentFloor(GetApartmentFloor arg) {
      return makeExerciseCmd(CHOICE_GetApartmentFloor, arg);
    }

    default Update<Exercised<Long>> exerciseGetApartmentFloor() {
      return exerciseGetApartmentFloor(new GetApartmentFloor());
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyPostalCode(
        GetApartmentPropertyPostalCode arg) {
      return makeExerciseCmd(CHOICE_GetApartmentPropertyPostalCode, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyPostalCode() {
      return exerciseGetApartmentPropertyPostalCode(new GetApartmentPropertyPostalCode());
    }

    default Update<Exercised<String>> exerciseGetApartmentDescription(GetApartmentDescription arg) {
      return makeExerciseCmd(CHOICE_GetApartmentDescription, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentDescription() {
      return exerciseGetApartmentDescription(new GetApartmentDescription());
    }

    default Update<Exercised<Long>> exerciseGetApartmentParkingSpaces(
        GetApartmentParkingSpaces arg) {
      return makeExerciseCmd(CHOICE_GetApartmentParkingSpaces, arg);
    }

    default Update<Exercised<Long>> exerciseGetApartmentParkingSpaces() {
      return exerciseGetApartmentParkingSpaces(new GetApartmentParkingSpaces());
    }

    default Update<Exercised<ContractId>> exerciseUpdateApartment(UpdateApartment arg) {
      return makeExerciseCmd(CHOICE_UpdateApartment, arg);
    }

    default Update<Exercised<ContractId>> exerciseUpdateApartment(BigDecimal newApartmentPrice,
        String newApartmentPropertyAddress, String newApartmentPropertyPostalCode,
        String newApartmentPropertyDistrict, String newApartmentPropertyCounty,
        BigDecimal newApartmentGrossArea, BigDecimal newApartmentUsableArea,
        Long newApartmentBedrooms, Long newApartmentBathrooms, Long newApartmentFloor,
        Long newApartmentParkingSpaces, Boolean newApartmentElevator,
        LocalDate newApartmentBuildDate, String newApartmentInstalledEquipment,
        String newApartmentAdditionalInformation, String newApartmentDescription,
        List<String> newApartmentPhotoReferences) {
      return exerciseUpdateApartment(new UpdateApartment(newApartmentPrice,
          newApartmentPropertyAddress, newApartmentPropertyPostalCode, newApartmentPropertyDistrict,
          newApartmentPropertyCounty, newApartmentGrossArea, newApartmentUsableArea,
          newApartmentBedrooms, newApartmentBathrooms, newApartmentFloor, newApartmentParkingSpaces,
          newApartmentElevator, newApartmentBuildDate, newApartmentInstalledEquipment,
          newApartmentAdditionalInformation, newApartmentDescription, newApartmentPhotoReferences));
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentGrossArea(GetApartmentGrossArea arg) {
      return makeExerciseCmd(CHOICE_GetApartmentGrossArea, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentGrossArea() {
      return exerciseGetApartmentGrossArea(new GetApartmentGrossArea());
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

    default Update<Exercised<String>> exerciseGetApartmentPropertyAddress(
        GetApartmentPropertyAddress arg) {
      return makeExerciseCmd(CHOICE_GetApartmentPropertyAddress, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentPropertyAddress() {
      return exerciseGetApartmentPropertyAddress(new GetApartmentPropertyAddress());
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentPrice(GetApartmentPrice arg) {
      return makeExerciseCmd(CHOICE_GetApartmentPrice, arg);
    }

    default Update<Exercised<BigDecimal>> exerciseGetApartmentPrice() {
      return exerciseGetApartmentPrice(new GetApartmentPrice());
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

    default Update<Exercised<Boolean>> exerciseGetApartmentElevator(GetApartmentElevator arg) {
      return makeExerciseCmd(CHOICE_GetApartmentElevator, arg);
    }

    default Update<Exercised<Boolean>> exerciseGetApartmentElevator() {
      return exerciseGetApartmentElevator(new GetApartmentElevator());
    }

    default Update<Exercised<Long>> exerciseGetApartmentBedrooms(GetApartmentBedrooms arg) {
      return makeExerciseCmd(CHOICE_GetApartmentBedrooms, arg);
    }

    default Update<Exercised<Long>> exerciseGetApartmentBedrooms() {
      return exerciseGetApartmentBedrooms(new GetApartmentBedrooms());
    }

    default Update<Exercised<String>> exerciseGetApartmentAdditionalInformation(
        GetApartmentAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_GetApartmentAdditionalInformation, arg);
    }

    default Update<Exercised<String>> exerciseGetApartmentAdditionalInformation() {
      return exerciseGetApartmentAdditionalInformation(new GetApartmentAdditionalInformation());
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
            View::fromJson,List.of(CHOICE_GetApartmentInstrumentKey, CHOICE_GetApartmentFloor,
            CHOICE_GetApartmentElevator, CHOICE_GetApartmentAdditionalInformation, CHOICE_GetView,
            CHOICE_GetApartmentBathrooms, CHOICE_UpdateApartment, CHOICE_GetApartmentPropertyCounty,
            CHOICE_Remove, CHOICE_GetApartmentBuildDate, CHOICE_GetApartmentInstalledEquipment,
            CHOICE_GetApartmentPhotoReferences, CHOICE_GetApartmentParkingSpaces, CHOICE_Archive,
            CHOICE_GetApartmentPropertyDistrict, CHOICE_GetApartmentDescription,
            CHOICE_GetApartmentPropertyPostalCode, CHOICE_GetApartmentGrossArea,
            CHOICE_GetApartmentUsableArea, CHOICE_GetApartmentPropertyAddress,
            CHOICE_GetApartmentPrice, CHOICE_GetApartmentBedrooms));
    }
  }
}
