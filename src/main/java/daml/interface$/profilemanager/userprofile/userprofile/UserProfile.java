package daml.interface$.profilemanager.userprofile.userprofile;

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
import daml.interface$.profilemanager.userprofile.common.Gender;
import daml.interface$.profilemanager.userprofile.common.Nationality;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public final class UserProfile {
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.ProfileManager.UserProfile.UserProfile", "UserProfile");

  public static final Choice<UserProfile, GetBirthday, LocalDate> CHOICE_GetBirthday = 
      Choice.create("GetBirthday", value$ -> value$.toValue(), value$ -> GetBirthday.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromDate.decode(value$));

  public static final Choice<UserProfile, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<UserProfile, GetSocialSecurityId, Long> CHOICE_GetSocialSecurityId = 
      Choice.create("GetSocialSecurityId", value$ -> value$.toValue(), value$ ->
        GetSocialSecurityId.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<UserProfile, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<UserProfile, GetNationality, Nationality> CHOICE_GetNationality = 
      Choice.create("GetNationality", value$ -> value$.toValue(), value$ ->
        GetNationality.valueDecoder().decode(value$), value$ -> Nationality.valueDecoder()
        .decode(value$));

  public static final Choice<UserProfile, GetFirstName, String> CHOICE_GetFirstName = 
      Choice.create("GetFirstName", value$ -> value$.toValue(), value$ ->
        GetFirstName.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromText
        .decode(value$));

  public static final Choice<UserProfile, GetIdNumber, Long> CHOICE_GetIdNumber = 
      Choice.create("GetIdNumber", value$ -> value$.toValue(), value$ -> GetIdNumber.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<UserProfile, GetGender, Optional<Gender>> CHOICE_GetGender = 
      Choice.create("GetGender", value$ -> value$.toValue(), value$ -> GetGender.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromOptional(Gender.valueDecoder())
        .decode(value$));

  public static final Choice<UserProfile, GetPhotoReferences, List<String>> CHOICE_GetPhotoReferences = 
      Choice.create("GetPhotoReferences", value$ -> value$.toValue(), value$ ->
        GetPhotoReferences.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromList(
          PrimitiveValueDecoders.fromText).decode(value$));

  public static final Choice<UserProfile, GetFullName, String> CHOICE_GetFullName = 
      Choice.create("GetFullName", value$ -> value$.toValue(), value$ -> GetFullName.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<UserProfile, GetTaxId, Long> CHOICE_GetTaxId = 
      Choice.create("GetTaxId", value$ -> value$.toValue(), value$ -> GetTaxId.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromInt64.decode(value$));

  public static final Choice<UserProfile, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<UserProfile, UpdateProfile, ContractId> CHOICE_UpdateProfile = 
      Choice.create("UpdateProfile", value$ -> value$.toValue(), value$ ->
        UpdateProfile.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<UserProfile, GetLastName, String> CHOICE_GetLastName = 
      Choice.create("GetLastName", value$ -> value$.toValue(), value$ -> GetLastName.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<UserProfile, GetUsername, String> CHOICE_GetUsername = 
      Choice.create("GetUsername", value$ -> value$.toValue(), value$ -> GetUsername.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<UserProfile, GetCellphoneNumber, Optional<Long>> CHOICE_GetCellphoneNumber = 
      Choice.create("GetCellphoneNumber", value$ -> value$.toValue(), value$ ->
        GetCellphoneNumber.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromOptional(PrimitiveValueDecoders.fromInt64).decode(value$));

  public static final Choice<UserProfile, GetPassword, String> CHOICE_GetPassword = 
      Choice.create("GetPassword", value$ -> value$.toValue(), value$ -> GetPassword.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromText.decode(value$));

  public static final Choice<UserProfile, GetContactMail, String> CHOICE_GetContactMail = 
      Choice.create("GetContactMail", value$ -> value$.toValue(), value$ ->
        GetContactMail.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromText
        .decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private UserProfile() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<UserProfile> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, UserProfile, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<LocalDate>> exerciseGetBirthday(GetBirthday arg) {
      return makeExerciseCmd(CHOICE_GetBirthday, arg);
    }

    default Update<Exercised<LocalDate>> exerciseGetBirthday() {
      return exerciseGetBirthday(new GetBirthday());
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<Long>> exerciseGetSocialSecurityId(GetSocialSecurityId arg) {
      return makeExerciseCmd(CHOICE_GetSocialSecurityId, arg);
    }

    default Update<Exercised<Long>> exerciseGetSocialSecurityId() {
      return exerciseGetSocialSecurityId(new GetSocialSecurityId());
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<Nationality>> exerciseGetNationality(GetNationality arg) {
      return makeExerciseCmd(CHOICE_GetNationality, arg);
    }

    default Update<Exercised<Nationality>> exerciseGetNationality() {
      return exerciseGetNationality(new GetNationality());
    }

    default Update<Exercised<String>> exerciseGetFirstName(GetFirstName arg) {
      return makeExerciseCmd(CHOICE_GetFirstName, arg);
    }

    default Update<Exercised<String>> exerciseGetFirstName() {
      return exerciseGetFirstName(new GetFirstName());
    }

    default Update<Exercised<Long>> exerciseGetIdNumber(GetIdNumber arg) {
      return makeExerciseCmd(CHOICE_GetIdNumber, arg);
    }

    default Update<Exercised<Long>> exerciseGetIdNumber() {
      return exerciseGetIdNumber(new GetIdNumber());
    }

    default Update<Exercised<Optional<Gender>>> exerciseGetGender(GetGender arg) {
      return makeExerciseCmd(CHOICE_GetGender, arg);
    }

    default Update<Exercised<Optional<Gender>>> exerciseGetGender() {
      return exerciseGetGender(new GetGender());
    }

    default Update<Exercised<List<String>>> exerciseGetPhotoReferences(GetPhotoReferences arg) {
      return makeExerciseCmd(CHOICE_GetPhotoReferences, arg);
    }

    default Update<Exercised<List<String>>> exerciseGetPhotoReferences() {
      return exerciseGetPhotoReferences(new GetPhotoReferences());
    }

    default Update<Exercised<String>> exerciseGetFullName(GetFullName arg) {
      return makeExerciseCmd(CHOICE_GetFullName, arg);
    }

    default Update<Exercised<String>> exerciseGetFullName() {
      return exerciseGetFullName(new GetFullName());
    }

    default Update<Exercised<Long>> exerciseGetTaxId(GetTaxId arg) {
      return makeExerciseCmd(CHOICE_GetTaxId, arg);
    }

    default Update<Exercised<Long>> exerciseGetTaxId() {
      return exerciseGetTaxId(new GetTaxId());
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<ContractId>> exerciseUpdateProfile(UpdateProfile arg) {
      return makeExerciseCmd(CHOICE_UpdateProfile, arg);
    }

    default Update<Exercised<ContractId>> exerciseUpdateProfile(String newUsername,
        String newFirstName, String newLastName, String newFullName, String newPassword,
        LocalDate newBirthday, Optional<Gender> newGender, Nationality newNationality,
        String newContactMail, Optional<Long> newCellphoneNumber, Long newIdNumber, Long newTaxId,
        Long newSocialSecurityId, List<String> newPhotoReferences) {
      return exerciseUpdateProfile(new UpdateProfile(newUsername, newFirstName, newLastName,
          newFullName, newPassword, newBirthday, newGender, newNationality, newContactMail,
          newCellphoneNumber, newIdNumber, newTaxId, newSocialSecurityId, newPhotoReferences));
    }

    default Update<Exercised<String>> exerciseGetLastName(GetLastName arg) {
      return makeExerciseCmd(CHOICE_GetLastName, arg);
    }

    default Update<Exercised<String>> exerciseGetLastName() {
      return exerciseGetLastName(new GetLastName());
    }

    default Update<Exercised<String>> exerciseGetUsername(GetUsername arg) {
      return makeExerciseCmd(CHOICE_GetUsername, arg);
    }

    default Update<Exercised<String>> exerciseGetUsername() {
      return exerciseGetUsername(new GetUsername());
    }

    default Update<Exercised<Optional<Long>>> exerciseGetCellphoneNumber(GetCellphoneNumber arg) {
      return makeExerciseCmd(CHOICE_GetCellphoneNumber, arg);
    }

    default Update<Exercised<Optional<Long>>> exerciseGetCellphoneNumber() {
      return exerciseGetCellphoneNumber(new GetCellphoneNumber());
    }

    default Update<Exercised<String>> exerciseGetPassword(GetPassword arg) {
      return makeExerciseCmd(CHOICE_GetPassword, arg);
    }

    default Update<Exercised<String>> exerciseGetPassword() {
      return exerciseGetPassword(new GetPassword());
    }

    default Update<Exercised<String>> exerciseGetContactMail(GetContactMail arg) {
      return makeExerciseCmd(CHOICE_GetContactMail, arg);
    }

    default Update<Exercised<String>> exerciseGetContactMail() {
      return exerciseGetContactMail(new GetContactMail());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, UserProfile, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, UserProfile, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<UserProfile, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.profilemanager.userprofile.userprofile.UserProfile", UserProfile.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_GetIdNumber, CHOICE_Remove, CHOICE_GetPhotoReferences,
            CHOICE_Archive, CHOICE_GetBirthday, CHOICE_GetView, CHOICE_GetSocialSecurityId,
            CHOICE_GetFullName, CHOICE_GetUsername, CHOICE_GetLastName, CHOICE_GetCellphoneNumber,
            CHOICE_GetNationality, CHOICE_GetGender, CHOICE_UpdateProfile, CHOICE_GetTaxId,
            CHOICE_GetPassword, CHOICE_GetFirstName, CHOICE_GetContactMail));
    }
  }
}
