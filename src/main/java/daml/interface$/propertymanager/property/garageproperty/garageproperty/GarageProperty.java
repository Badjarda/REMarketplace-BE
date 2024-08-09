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
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.PropertyManager.Property.GarageProperty.GarageProperty", "GarageProperty");

  public static final Choice<GarageProperty, GetGaragePropertyAddress, String> CHOICE_GetGaragePropertyAddress = 
      Choice.create("GetGaragePropertyAddress", value$ -> value$.toValue(), value$ ->
        GetGaragePropertyAddress.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, GetGaragePropertyDistrict, String> CHOICE_GetGaragePropertyDistrict = 
      Choice.create("GetGaragePropertyDistrict", value$ -> value$.toValue(), value$ ->
        GetGaragePropertyDistrict.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, UpdateGarage, ContractId> CHOICE_UpdateGarage = 
      Choice.create("UpdateGarage", value$ -> value$.toValue(), value$ ->
        UpdateGarage.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<GarageProperty, GetGaragePropertyCounty, String> CHOICE_GetGaragePropertyCounty = 
      Choice.create("GetGaragePropertyCounty", value$ -> value$.toValue(), value$ ->
        GetGaragePropertyCounty.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, GetGarageDescription, String> CHOICE_GetGarageDescription = 
      Choice.create("GetGarageDescription", value$ -> value$.toValue(), value$ ->
        GetGarageDescription.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, GetGarageAdditionalInformation, String> CHOICE_GetGarageAdditionalInformation = 
      Choice.create("GetGarageAdditionalInformation", value$ -> value$.toValue(), value$ ->
        GetGarageAdditionalInformation.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, GetVehicleCapacity, Long> CHOICE_GetVehicleCapacity = 
      Choice.create("GetVehicleCapacity", value$ -> value$.toValue(), value$ ->
        GetVehicleCapacity.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromInt64
        .decode(value$));

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

  public static final Choice<GarageProperty, GetGarageInstrumentKey, InstrumentKey> CHOICE_GetGarageInstrumentKey = 
      Choice.create("GetGarageInstrumentKey", value$ -> value$.toValue(), value$ ->
        GetGarageInstrumentKey.valueDecoder().decode(value$), value$ -> InstrumentKey.valueDecoder()
        .decode(value$));

  public static final Choice<GarageProperty, GetGaragePropertyPostalCode, String> CHOICE_GetGaragePropertyPostalCode = 
      Choice.create("GetGaragePropertyPostalCode", value$ -> value$.toValue(), value$ ->
        GetGaragePropertyPostalCode.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<GarageProperty, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<GarageProperty, GetGarageArea, BigDecimal> CHOICE_GetGarageArea = 
      Choice.create("GetGarageArea", value$ -> value$.toValue(), value$ ->
        GetGarageArea.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromNumeric
        .decode(value$));

  public static final Choice<GarageProperty, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<GarageProperty, GetGaragePrice, BigDecimal> CHOICE_GetGaragePrice = 
      Choice.create("GetGaragePrice", value$ -> value$.toValue(), value$ ->
        GetGaragePrice.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromNumeric
        .decode(value$));

  public static final Choice<GarageProperty, GetGaragePhotoReferences, List<String>> CHOICE_GetGaragePhotoReferences = 
      Choice.create("GetGaragePhotoReferences", value$ -> value$.toValue(), value$ ->
        GetGaragePhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromText).decode(value$));

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

    default Update<Exercised<ContractId>> exerciseUpdateGarage(UpdateGarage arg) {
      return makeExerciseCmd(CHOICE_UpdateGarage, arg);
    }

    default Update<Exercised<ContractId>> exerciseUpdateGarage(BigDecimal newGaragePrice,
        String newGaragePropertyAddress, String newGaragePropertyPostalCode,
        String newGaragePropertyDistrict, String newGaragePropertyCounty, BigDecimal newGarageArea,
        GarageType newGarageType, Long newGarageVehicleCapacity, String newGarageInstalledEquipment,
        String newGarageAdditionalInformation, String newGarageDescription,
        List<String> newGaragePhotoReferences) {
      return exerciseUpdateGarage(new UpdateGarage(newGaragePrice, newGaragePropertyAddress,
          newGaragePropertyPostalCode, newGaragePropertyDistrict, newGaragePropertyCounty,
          newGarageArea, newGarageType, newGarageVehicleCapacity, newGarageInstalledEquipment,
          newGarageAdditionalInformation, newGarageDescription, newGaragePhotoReferences));
    }

    default Update<Exercised<String>> exerciseGetGaragePropertyCounty(GetGaragePropertyCounty arg) {
      return makeExerciseCmd(CHOICE_GetGaragePropertyCounty, arg);
    }

    default Update<Exercised<String>> exerciseGetGaragePropertyCounty() {
      return exerciseGetGaragePropertyCounty(new GetGaragePropertyCounty());
    }

    default Update<Exercised<String>> exerciseGetGarageDescription(GetGarageDescription arg) {
      return makeExerciseCmd(CHOICE_GetGarageDescription, arg);
    }

    default Update<Exercised<String>> exerciseGetGarageDescription() {
      return exerciseGetGarageDescription(new GetGarageDescription());
    }

    default Update<Exercised<String>> exerciseGetGarageAdditionalInformation(
        GetGarageAdditionalInformation arg) {
      return makeExerciseCmd(CHOICE_GetGarageAdditionalInformation, arg);
    }

    default Update<Exercised<String>> exerciseGetGarageAdditionalInformation() {
      return exerciseGetGarageAdditionalInformation(new GetGarageAdditionalInformation());
    }

    default Update<Exercised<Long>> exerciseGetVehicleCapacity(GetVehicleCapacity arg) {
      return makeExerciseCmd(CHOICE_GetVehicleCapacity, arg);
    }

    default Update<Exercised<Long>> exerciseGetVehicleCapacity() {
      return exerciseGetVehicleCapacity(new GetVehicleCapacity());
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

    default Update<Exercised<InstrumentKey>> exerciseGetGarageInstrumentKey(
        GetGarageInstrumentKey arg) {
      return makeExerciseCmd(CHOICE_GetGarageInstrumentKey, arg);
    }

    default Update<Exercised<InstrumentKey>> exerciseGetGarageInstrumentKey() {
      return exerciseGetGarageInstrumentKey(new GetGarageInstrumentKey());
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
            View::fromJson,List.of(CHOICE_GetGarageAdditionalInformation,
            CHOICE_GetGarageDescription, CHOICE_GetGaragePropertyCounty,
            CHOICE_GetGaragePropertyPostalCode, CHOICE_GetGaragePhotoReferences,
            CHOICE_GetGaragePropertyAddress, CHOICE_Archive, CHOICE_UpdateGarage, CHOICE_GetView,
            CHOICE_GetGarageArea, CHOICE_GetGarageInstrumentKey, CHOICE_GetGarageType,
            CHOICE_GetVehicleCapacity, CHOICE_Remove, CHOICE_GetGaragePrice,
            CHOICE_GetGarageInstalledEquipment, CHOICE_GetGaragePropertyDistrict));
    }
  }
}
