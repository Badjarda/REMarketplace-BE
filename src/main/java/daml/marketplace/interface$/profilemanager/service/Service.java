package daml.interface$.profilemanager.service;

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
import daml.da.set.types.Set;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.interface$.common.types.UserProfileKey;
import daml.interface$.profilemanager.userprofile.common.Gender;
import daml.interface$.profilemanager.userprofile.common.Nationality;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class Service {
  public static final Identifier TEMPLATE_ID = new Identifier("f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079", "Interface.ProfileManager.Service", "Service");

  public static final Choice<Service, UpdateSocialSecurityId, Unit> CHOICE_UpdateSocialSecurityId = 
      Choice.create("UpdateSocialSecurityId", value$ -> value$.toValue(), value$ ->
        UpdateSocialSecurityId.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateNationality, Unit> CHOICE_UpdateNationality = 
      Choice.create("UpdateNationality", value$ -> value$.toValue(), value$ ->
        UpdateNationality.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdatePhotoReferences, Unit> CHOICE_UpdatePhotoReferences = 
      Choice.create("UpdatePhotoReferences", value$ -> value$.toValue(), value$ ->
        UpdatePhotoReferences.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateLastName, Unit> CHOICE_UpdateLastName = 
      Choice.create("UpdateLastName", value$ -> value$.toValue(), value$ ->
        UpdateLastName.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateIdNumber, Unit> CHOICE_UpdateIdNumber = 
      Choice.create("UpdateIdNumber", value$ -> value$.toValue(), value$ ->
        UpdateIdNumber.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateCellphoneNumber, Unit> CHOICE_UpdateCellphoneNumber = 
      Choice.create("UpdateCellphoneNumber", value$ -> value$.toValue(), value$ ->
        UpdateCellphoneNumber.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateUsername, Unit> CHOICE_UpdateUsername = 
      Choice.create("UpdateUsername", value$ -> value$.toValue(), value$ ->
        UpdateUsername.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateFullName, Unit> CHOICE_UpdateFullName = 
      Choice.create("UpdateFullName", value$ -> value$.toValue(), value$ ->
        UpdateFullName.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateTaxId, Unit> CHOICE_UpdateTaxId = 
      Choice.create("UpdateTaxId", value$ -> value$.toValue(), value$ -> UpdateTaxId.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateBirthday, Unit> CHOICE_UpdateBirthday = 
      Choice.create("UpdateBirthday", value$ -> value$.toValue(), value$ ->
        UpdateBirthday.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateGender, Unit> CHOICE_UpdateGender = 
      Choice.create("UpdateGender", value$ -> value$.toValue(), value$ ->
        UpdateGender.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdatePassword, Unit> CHOICE_UpdatePassword = 
      Choice.create("UpdatePassword", value$ -> value$.toValue(), value$ ->
        UpdatePassword.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, UpdateFirstName, Unit> CHOICE_UpdateFirstName = 
      Choice.create("UpdateFirstName", value$ -> value$.toValue(), value$ ->
        UpdateFirstName.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, CreateUserProfile, UserProfileKey> CHOICE_CreateUserProfile = 
      Choice.create("CreateUserProfile", value$ -> value$.toValue(), value$ ->
        CreateUserProfile.valueDecoder().decode(value$), value$ -> UserProfileKey.valueDecoder()
        .decode(value$));

  public static final Choice<Service, RequestCreateUserProfile, daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId> CHOICE_RequestCreateUserProfile = 
      Choice.create("RequestCreateUserProfile", value$ -> value$.toValue(), value$ ->
        RequestCreateUserProfile.valueDecoder().decode(value$), value$ ->
        new daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, UpdateContactMail, Unit> CHOICE_UpdateContactMail = 
      Choice.create("UpdateContactMail", value$ -> value$.toValue(), value$ ->
        UpdateContactMail.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private Service() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Service> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Unit>> exerciseUpdateSocialSecurityId(UpdateSocialSecurityId arg) {
      return makeExerciseCmd(CHOICE_UpdateSocialSecurityId, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateSocialSecurityId(Long newSocialSecurityId,
        UserProfileKey userProfileKey) {
      return exerciseUpdateSocialSecurityId(new UpdateSocialSecurityId(newSocialSecurityId,
          userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateNationality(UpdateNationality arg) {
      return makeExerciseCmd(CHOICE_UpdateNationality, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateNationality(Nationality newNationality,
        UserProfileKey userProfileKey) {
      return exerciseUpdateNationality(new UpdateNationality(newNationality, userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdatePhotoReferences(UpdatePhotoReferences arg) {
      return makeExerciseCmd(CHOICE_UpdatePhotoReferences, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdatePhotoReferences(List<String> newPhotoReferences,
        UserProfileKey userProfileKey) {
      return exerciseUpdatePhotoReferences(new UpdatePhotoReferences(newPhotoReferences,
          userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateLastName(UpdateLastName arg) {
      return makeExerciseCmd(CHOICE_UpdateLastName, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateLastName(String newLastName,
        UserProfileKey userProfileKey) {
      return exerciseUpdateLastName(new UpdateLastName(newLastName, userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateIdNumber(UpdateIdNumber arg) {
      return makeExerciseCmd(CHOICE_UpdateIdNumber, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateIdNumber(Long newIdNumber,
        UserProfileKey userProfileKey) {
      return exerciseUpdateIdNumber(new UpdateIdNumber(newIdNumber, userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateCellphoneNumber(UpdateCellphoneNumber arg) {
      return makeExerciseCmd(CHOICE_UpdateCellphoneNumber, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateCellphoneNumber(Optional<Long> newCellphoneNumber,
        UserProfileKey userProfileKey) {
      return exerciseUpdateCellphoneNumber(new UpdateCellphoneNumber(newCellphoneNumber,
          userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<Unit>> exerciseUpdateUsername(UpdateUsername arg) {
      return makeExerciseCmd(CHOICE_UpdateUsername, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateUsername(String newUsername,
        UserProfileKey userProfileKey) {
      return exerciseUpdateUsername(new UpdateUsername(newUsername, userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateFullName(UpdateFullName arg) {
      return makeExerciseCmd(CHOICE_UpdateFullName, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateFullName(String newFullName,
        UserProfileKey userProfileKey) {
      return exerciseUpdateFullName(new UpdateFullName(newFullName, userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateTaxId(UpdateTaxId arg) {
      return makeExerciseCmd(CHOICE_UpdateTaxId, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateTaxId(Long newTaxId,
        UserProfileKey userProfileKey) {
      return exerciseUpdateTaxId(new UpdateTaxId(newTaxId, userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateBirthday(UpdateBirthday arg) {
      return makeExerciseCmd(CHOICE_UpdateBirthday, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateBirthday(LocalDate newBirthday,
        UserProfileKey userProfileKey) {
      return exerciseUpdateBirthday(new UpdateBirthday(newBirthday, userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateGender(UpdateGender arg) {
      return makeExerciseCmd(CHOICE_UpdateGender, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateGender(Optional<Gender> newGender,
        UserProfileKey userProfileKey) {
      return exerciseUpdateGender(new UpdateGender(newGender, userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdatePassword(UpdatePassword arg) {
      return makeExerciseCmd(CHOICE_UpdatePassword, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdatePassword(String newPassword,
        UserProfileKey userProfileKey) {
      return exerciseUpdatePassword(new UpdatePassword(newPassword, userProfileKey));
    }

    default Update<Exercised<Unit>> exerciseUpdateFirstName(UpdateFirstName arg) {
      return makeExerciseCmd(CHOICE_UpdateFirstName, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateFirstName(String newFirstName,
        UserProfileKey userProfileKey) {
      return exerciseUpdateFirstName(new UpdateFirstName(newFirstName, userProfileKey));
    }

    default Update<Exercised<UserProfileKey>> exerciseCreateUserProfile(CreateUserProfile arg) {
      return makeExerciseCmd(CHOICE_CreateUserProfile, arg);
    }

    default Update<Exercised<UserProfileKey>> exerciseCreateUserProfile(
        daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId createUserProfileRequest) {
      return exerciseCreateUserProfile(new CreateUserProfile(createUserProfileRequest));
    }

    default Update<Exercised<daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId>> exerciseRequestCreateUserProfile(
        RequestCreateUserProfile arg) {
      return makeExerciseCmd(CHOICE_RequestCreateUserProfile, arg);
    }

    default Update<Exercised<daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId>> exerciseRequestCreateUserProfile(
        Id id, String username, String firstName, String lastName, String fullName, String password,
        LocalDate birthday, Optional<Gender> gender, Nationality nationality, String contactMail,
        Optional<Long> cellphoneNumber, Long idNumber, Long taxId, Long socialSecurityId,
        List<String> photoReferences, Map<String, Set<String>> observers) {
      return exerciseRequestCreateUserProfile(new RequestCreateUserProfile(id, username, firstName,
          lastName, fullName, password, birthday, gender, nationality, contactMail, cellphoneNumber,
          idNumber, taxId, socialSecurityId, photoReferences, observers));
    }

    default Update<Exercised<Unit>> exerciseUpdateContactMail(UpdateContactMail arg) {
      return makeExerciseCmd(CHOICE_UpdateContactMail, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateContactMail(String newContactMail,
        UserProfileKey userProfileKey) {
      return exerciseUpdateContactMail(new UpdateContactMail(newContactMail, userProfileKey));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<Service, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.profilemanager.service.Service", Service.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_UpdateGender, CHOICE_UpdateContactMail,
            CHOICE_UpdateTaxId, CHOICE_CreateUserProfile, CHOICE_UpdateBirthday,
            CHOICE_UpdatePassword, CHOICE_UpdateFirstName, CHOICE_UpdateCellphoneNumber,
            CHOICE_UpdateSocialSecurityId, CHOICE_UpdateNationality, CHOICE_UpdateFullName,
            CHOICE_Archive, CHOICE_UpdateUsername, CHOICE_UpdatePhotoReferences,
            CHOICE_UpdateIdNumber, CHOICE_UpdateLastName, CHOICE_RequestCreateUserProfile));
    }
  }
}
