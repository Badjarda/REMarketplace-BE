package daml.marketplace.interface$.profilemanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.Date;
import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.da.set.types.Set;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;
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

public class RequestCreateUserProfile extends DamlRecord<RequestCreateUserProfile> {
  public static final String _packageId = "b93cea58d2cd7e7792117719e7c79bd5a10ca2a87dc57a03f202a3ec5bc6c5d9";

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

  public RequestCreateUserProfile(Id id, String username, String firstName, String lastName,
      String fullName, String password, LocalDate birthday, Optional<Gender> gender,
      Nationality nationality, String contactMail, Optional<Long> cellphoneNumber, Long idNumber,
      Long taxId, Long socialSecurityId, List<String> photoReferences,
      Map<String, Set<String>> observers) {
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

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static RequestCreateUserProfile fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RequestCreateUserProfile> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(16,0,
          recordValue$);
      Id id = Id.valueDecoder().decode(fields$.get(0).getValue());
      String username = PrimitiveValueDecoders.fromText.decode(fields$.get(1).getValue());
      String firstName = PrimitiveValueDecoders.fromText.decode(fields$.get(2).getValue());
      String lastName = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      String fullName = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      String password = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      LocalDate birthday = PrimitiveValueDecoders.fromDate.decode(fields$.get(6).getValue());
      Optional<Gender> gender = PrimitiveValueDecoders.fromOptional(Gender.valueDecoder())
          .decode(fields$.get(7).getValue());
      Nationality nationality = Nationality.valueDecoder().decode(fields$.get(8).getValue());
      String contactMail = PrimitiveValueDecoders.fromText.decode(fields$.get(9).getValue());
      Optional<Long> cellphoneNumber = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromInt64).decode(fields$.get(10).getValue());
      Long idNumber = PrimitiveValueDecoders.fromInt64.decode(fields$.get(11).getValue());
      Long taxId = PrimitiveValueDecoders.fromInt64.decode(fields$.get(12).getValue());
      Long socialSecurityId = PrimitiveValueDecoders.fromInt64.decode(fields$.get(13).getValue());
      List<String> photoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(14).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(15).getValue());
      return new RequestCreateUserProfile(id, username, firstName, lastName, fullName, password,
          birthday, gender, nationality, contactMail, cellphoneNumber, idNumber, taxId,
          socialSecurityId, photoReferences, observers);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(16);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("username", new Text(this.username)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("firstName", new Text(this.firstName)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("lastName", new Text(this.lastName)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("fullName", new Text(this.fullName)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("password", new Text(this.password)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("birthday", new Date((int) this.birthday.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("gender", DamlOptional.of(this.gender.map(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("nationality", this.nationality.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("contactMail", new Text(this.contactMail)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("cellphoneNumber", DamlOptional.of(this.cellphoneNumber.map(v$0 -> new Int64(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("idNumber", new Int64(this.idNumber)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("taxId", new Int64(this.taxId)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("socialSecurityId", new Int64(this.socialSecurityId)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("photoReferences", this.photoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observers", this.observers.entrySet()
        .stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RequestCreateUserProfile> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("id", "username", "firstName", "lastName", "fullName", "password", "birthday", "gender", "nationality", "contactMail", "cellphoneNumber", "idNumber", "taxId", "socialSecurityId", "photoReferences", "observers"), name -> {
          switch (name) {
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "username": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "firstName": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "lastName": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "fullName": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "password": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "birthday": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "gender": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.marketplace.interface$.profilemanager.userprofile.common.Gender.jsonDecoder()));
            case "nationality": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, daml.marketplace.interface$.profilemanager.userprofile.common.Nationality.jsonDecoder());
            case "contactMail": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "cellphoneNumber": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64));
            case "idNumber": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "taxId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "socialSecurityId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "photoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(15, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new RequestCreateUserProfile(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14]), JsonLfDecoders.cast(args[15])));
  }

  public static RequestCreateUserProfile fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
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
    return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username) &&
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
    return Objects.hash(this.id, this.username, this.firstName, this.lastName, this.fullName,
        this.password, this.birthday, this.gender, this.nationality, this.contactMail,
        this.cellphoneNumber, this.idNumber, this.taxId, this.socialSecurityId,
        this.photoReferences, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.profilemanager.service.RequestCreateUserProfile(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.id, this.username, this.firstName, this.lastName, this.fullName, this.password,
        this.birthday, this.gender, this.nationality, this.contactMail, this.cellphoneNumber,
        this.idNumber, this.taxId, this.socialSecurityId, this.photoReferences, this.observers);
  }
}
