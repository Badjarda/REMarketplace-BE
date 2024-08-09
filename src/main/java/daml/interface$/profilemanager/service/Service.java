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
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.ProfileManager.Service", "Service");

  public static final Choice<Service, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, UpdateProfile, Unit> CHOICE_UpdateProfile = 
      Choice.create("UpdateProfile", value$ -> value$.toValue(), value$ ->
        UpdateProfile.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, CreateUserProfile, UserProfileKey> CHOICE_CreateUserProfile = 
      Choice.create("CreateUserProfile", value$ -> value$.toValue(), value$ ->
        CreateUserProfile.valueDecoder().decode(value$), value$ -> UserProfileKey.valueDecoder()
        .decode(value$));

  public static final Choice<Service, RequestCreateUserProfile, daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId> CHOICE_RequestCreateUserProfile = 
      Choice.create("RequestCreateUserProfile", value$ -> value$.toValue(), value$ ->
        RequestCreateUserProfile.valueDecoder().decode(value$), value$ ->
        new daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

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
    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<Unit>> exerciseUpdateProfile(UpdateProfile arg) {
      return makeExerciseCmd(CHOICE_UpdateProfile, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateProfile(String newUsername, String newFirstName,
        String newLastName, String newFullName, String newPassword, LocalDate newBirthday,
        Optional<Gender> newGender, Nationality newNationality, String newContactMail,
        Optional<Long> newCellphoneNumber, Long newIdNumber, Long newTaxId,
        Long newSocialSecurityId, List<String> newPhotoReferences, UserProfileKey userProfileKey) {
      return exerciseUpdateProfile(new UpdateProfile(newUsername, newFirstName, newLastName,
          newFullName, newPassword, newBirthday, newGender, newNationality, newContactMail,
          newCellphoneNumber, newIdNumber, newTaxId, newSocialSecurityId, newPhotoReferences,
          userProfileKey));
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
            View::fromJson,List.of(CHOICE_Archive, CHOICE_UpdateProfile, CHOICE_CreateUserProfile,
            CHOICE_RequestCreateUserProfile));
    }
  }
}
