package daml.app.profilemanager.model;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.Date;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.Choice;
import com.daml.ledger.javaapi.data.codegen.ContractCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractTypeCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractWithKey;
import com.daml.ledger.javaapi.data.codegen.Created;
import com.daml.ledger.javaapi.data.codegen.Exercised;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.Update;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.da.set.types.Set;
import daml.da.types.Tuple3;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.interface$.common.removable.Removable;
import daml.interface$.profilemanager.userprofile.common.Gender;
import daml.interface$.profilemanager.userprofile.common.Nationality;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class RequestCreateUserProfile extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079", "App.ProfileManager.Model", "RequestCreateUserProfile");

  public static final Choice<RequestCreateUserProfile, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithKey<Contract, ContractId, RequestCreateUserProfile, Tuple3<String, String, Id>> COMPANION = 
      new ContractCompanion.WithKey<>("daml.app.profilemanager.model.RequestCreateUserProfile",
        TEMPLATE_ID, ContractId::new,
        v -> RequestCreateUserProfile.templateValueDecoder().decode(v),
        RequestCreateUserProfile::fromJson, Contract::new, List.of(CHOICE_Archive),
        e -> Tuple3.<java.lang.String, java.lang.String,
        daml.daml.finance.interface$.types.common.types.Id>valueDecoder(PrimitiveValueDecoders.fromParty,
        PrimitiveValueDecoders.fromParty, Id.valueDecoder()).decode(e));

  public final String operator;

  public final String user;

  public final Id id;

  public final String username;

  public final String firstName;

  public final String lastName;

  public final String fullName;

  public final String password;

  public final LocalDate birthday;

  public final Optional<Gender> gender;

  public final Nationality nationality;

  public final String contactMail;

  public final Optional<Long> cellphoneNumber;

  public final Long idNumber;

  public final Long taxId;

  public final Long socialSecurityId;

  public final List<String> photoReferences;

  public final Map<String, Set<String>> observers;

  public RequestCreateUserProfile(String operator, String user, Id id, String username,
      String firstName, String lastName, String fullName, String password, LocalDate birthday,
      Optional<Gender> gender, Nationality nationality, String contactMail,
      Optional<Long> cellphoneNumber, Long idNumber, Long taxId, Long socialSecurityId,
      List<String> photoReferences, Map<String, Set<String>> observers) {
    this.operator = operator;
    this.user = user;
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.fullName = fullName;
    this.password = password;
    this.birthday = birthday;
    this.gender = gender;
    this.nationality = nationality;
    this.contactMail = contactMail;
    this.cellphoneNumber = cellphoneNumber;
    this.idNumber = idNumber;
    this.taxId = taxId;
    this.socialSecurityId = socialSecurityId;
    this.photoReferences = photoReferences;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(RequestCreateUserProfile.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple3<String, String, Id> key,
      daml.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple3<String, String, Id> key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive(daml.da.internal.template.Archive arg) {
    return createAnd().exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive() {
    return createAndExerciseArchive(new daml.da.internal.template.Archive());
  }

  public static Update<Created<ContractId>> create(String operator, String user, Id id,
      String username, String firstName, String lastName, String fullName, String password,
      LocalDate birthday, Optional<Gender> gender, Nationality nationality, String contactMail,
      Optional<Long> cellphoneNumber, Long idNumber, Long taxId, Long socialSecurityId,
      List<String> photoReferences, Map<String, Set<String>> observers) {
    return new RequestCreateUserProfile(operator, user, id, username, firstName, lastName, fullName,
        password, birthday, gender, nationality, contactMail, cellphoneNumber, idNumber, taxId,
        socialSecurityId, photoReferences, observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, RequestCreateUserProfile, Tuple3<String, String, Id>> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static RequestCreateUserProfile fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RequestCreateUserProfile> valueDecoder() throws
      IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(18);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("user", new Party(this.user)));
    fields.add(new DamlRecord.Field("id", this.id.toValue()));
    fields.add(new DamlRecord.Field("username", new Text(this.username)));
    fields.add(new DamlRecord.Field("firstName", new Text(this.firstName)));
    fields.add(new DamlRecord.Field("lastName", new Text(this.lastName)));
    fields.add(new DamlRecord.Field("fullName", new Text(this.fullName)));
    fields.add(new DamlRecord.Field("password", new Text(this.password)));
    fields.add(new DamlRecord.Field("birthday", new Date((int) this.birthday.toEpochDay())));
    fields.add(new DamlRecord.Field("gender", DamlOptional.of(this.gender.map(v$0 -> v$0.toValue()))));
    fields.add(new DamlRecord.Field("nationality", this.nationality.toValue()));
    fields.add(new DamlRecord.Field("contactMail", new Text(this.contactMail)));
    fields.add(new DamlRecord.Field("cellphoneNumber", DamlOptional.of(this.cellphoneNumber.map(v$0 -> new Int64(v$0)))));
    fields.add(new DamlRecord.Field("idNumber", new Int64(this.idNumber)));
    fields.add(new DamlRecord.Field("taxId", new Int64(this.taxId)));
    fields.add(new DamlRecord.Field("socialSecurityId", new Int64(this.socialSecurityId)));
    fields.add(new DamlRecord.Field("photoReferences", this.photoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<RequestCreateUserProfile> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(18,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String user = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(2).getValue());
      String username = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      String firstName = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      String lastName = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      String fullName = PrimitiveValueDecoders.fromText.decode(fields$.get(6).getValue());
      String password = PrimitiveValueDecoders.fromText.decode(fields$.get(7).getValue());
      LocalDate birthday = PrimitiveValueDecoders.fromDate.decode(fields$.get(8).getValue());
      Optional<Gender> gender = PrimitiveValueDecoders.fromOptional(Gender.valueDecoder())
          .decode(fields$.get(9).getValue());
      Nationality nationality = Nationality.valueDecoder().decode(fields$.get(10).getValue());
      String contactMail = PrimitiveValueDecoders.fromText.decode(fields$.get(11).getValue());
      Optional<Long> cellphoneNumber = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromInt64).decode(fields$.get(12).getValue());
      Long idNumber = PrimitiveValueDecoders.fromInt64.decode(fields$.get(13).getValue());
      Long taxId = PrimitiveValueDecoders.fromInt64.decode(fields$.get(14).getValue());
      Long socialSecurityId = PrimitiveValueDecoders.fromInt64.decode(fields$.get(15).getValue());
      List<String> photoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(16).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(17).getValue());
      return new RequestCreateUserProfile(operator, user, id, username, firstName, lastName,
          fullName, password, birthday, gender, nationality, contactMail, cellphoneNumber, idNumber,
          taxId, socialSecurityId, photoReferences, observers);
    } ;
  }

  public static JsonLfDecoder<RequestCreateUserProfile> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "user", "id", "username", "firstName", "lastName", "fullName", "password", "birthday", "gender", "nationality", "contactMail", "cellphoneNumber", "idNumber", "taxId", "socialSecurityId", "photoReferences", "observers"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "user": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "username": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "firstName": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "lastName": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "fullName": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "password": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "birthday": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "gender": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.interface$.profilemanager.userprofile.common.Gender.jsonDecoder()));
            case "nationality": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, daml.interface$.profilemanager.userprofile.common.Nationality.jsonDecoder());
            case "contactMail": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "cellphoneNumber": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64));
            case "idNumber": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "taxId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "socialSecurityId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(15, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "photoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(16, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(17, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new RequestCreateUserProfile(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14]), JsonLfDecoders.cast(args[15]), JsonLfDecoders.cast(args[16]), JsonLfDecoders.cast(args[17])));
  }

  public static RequestCreateUserProfile fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("user", apply(JsonLfEncoders::party, user)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("username", apply(JsonLfEncoders::text, username)),
        JsonLfEncoders.Field.of("firstName", apply(JsonLfEncoders::text, firstName)),
        JsonLfEncoders.Field.of("lastName", apply(JsonLfEncoders::text, lastName)),
        JsonLfEncoders.Field.of("fullName", apply(JsonLfEncoders::text, fullName)),
        JsonLfEncoders.Field.of("password", apply(JsonLfEncoders::text, password)),
        JsonLfEncoders.Field.of("birthday", apply(JsonLfEncoders::date, birthday)),
        JsonLfEncoders.Field.of("gender", apply(JsonLfEncoders.optional(Gender::jsonEncoder), gender)),
        JsonLfEncoders.Field.of("nationality", apply(Nationality::jsonEncoder, nationality)),
        JsonLfEncoders.Field.of("contactMail", apply(JsonLfEncoders::text, contactMail)),
        JsonLfEncoders.Field.of("cellphoneNumber", apply(JsonLfEncoders.optional(JsonLfEncoders::int64), cellphoneNumber)),
        JsonLfEncoders.Field.of("idNumber", apply(JsonLfEncoders::int64, idNumber)),
        JsonLfEncoders.Field.of("taxId", apply(JsonLfEncoders::int64, taxId)),
        JsonLfEncoders.Field.of("socialSecurityId", apply(JsonLfEncoders::int64, socialSecurityId)),
        JsonLfEncoders.Field.of("photoReferences", apply(JsonLfEncoders.list(JsonLfEncoders::text), photoReferences)),
        JsonLfEncoders.Field.of("observers", apply(JsonLfEncoders.genMap(JsonLfEncoders::text, _x1 -> _x1.jsonEncoder(JsonLfEncoders::party)), observers)));
  }

  public static ContractFilter<Contract> contractFilter() {
    return ContractFilter.of(COMPANION);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof RequestCreateUserProfile)) {
      return false;
    }
    RequestCreateUserProfile other = (RequestCreateUserProfile) object;
    return Objects.equals(this.operator, other.operator) && Objects.equals(this.user, other.user) &&
        Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username) &&
        Objects.equals(this.firstName, other.firstName) &&
        Objects.equals(this.lastName, other.lastName) &&
        Objects.equals(this.fullName, other.fullName) &&
        Objects.equals(this.password, other.password) &&
        Objects.equals(this.birthday, other.birthday) &&
        Objects.equals(this.gender, other.gender) &&
        Objects.equals(this.nationality, other.nationality) &&
        Objects.equals(this.contactMail, other.contactMail) &&
        Objects.equals(this.cellphoneNumber, other.cellphoneNumber) &&
        Objects.equals(this.idNumber, other.idNumber) && Objects.equals(this.taxId, other.taxId) &&
        Objects.equals(this.socialSecurityId, other.socialSecurityId) &&
        Objects.equals(this.photoReferences, other.photoReferences) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.user, this.id, this.username, this.firstName,
        this.lastName, this.fullName, this.password, this.birthday, this.gender, this.nationality,
        this.contactMail, this.cellphoneNumber, this.idNumber, this.taxId, this.socialSecurityId,
        this.photoReferences, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.app.profilemanager.model.RequestCreateUserProfile(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.operator, this.user, this.id, this.username, this.firstName, this.lastName,
        this.fullName, this.password, this.birthday, this.gender, this.nationality,
        this.contactMail, this.cellphoneNumber, this.idNumber, this.taxId, this.socialSecurityId,
        this.photoReferences, this.observers);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(Tuple3<String, String, Id> key) {
    return new ByKey(key.toValue(v$0 -> new Party(v$0), v$1 -> new Party(v$1),
        v$2 -> v$2.toValue()));
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<RequestCreateUserProfile> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, RequestCreateUserProfile, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId toInterface(
        daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId(this.contractId);
    }

    public Removable.ContractId toInterface(Removable.INTERFACE_ interfaceCompanion) {
      return new Removable.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Removable.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<RequestCreateUserProfile> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, RequestCreateUserProfile, Tuple3<String, String, Id>> {
    public Contract(ContractId id, RequestCreateUserProfile data, Optional<String> agreementText,
        Optional<Tuple3<String, String, Id>> key, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, RequestCreateUserProfile> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<Tuple3<String, String, Id>> key,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, RequestCreateUserProfile, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.CreateAnd toInterface(
        daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.CreateAnd(COMPANION, this.createArguments);
    }

    public Removable.CreateAnd toInterface(Removable.INTERFACE_ interfaceCompanion) {
      return new Removable.CreateAnd(COMPANION, this.createArguments);
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, RequestCreateUserProfile, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ByKey toInterface(
        daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ByKey(COMPANION, this.contractKey);
    }

    public Removable.ByKey toInterface(Removable.INTERFACE_ interfaceCompanion) {
      return new Removable.ByKey(COMPANION, this.contractKey);
    }
  }
}
