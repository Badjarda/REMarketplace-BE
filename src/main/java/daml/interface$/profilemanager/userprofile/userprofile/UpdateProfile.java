package daml.interface$.profilemanager.userprofile.userprofile;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.Date;
import com.daml.ledger.javaapi.data.Int64;
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
import java.util.Objects;
import java.util.Optional;

public class UpdateProfile extends DamlRecord<UpdateProfile> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final String newUsername;

  public final String newFirstName;

  public final String newLastName;

  public final String newFullName;

  public final String newPassword;

  public final LocalDate newBirthday;

  public final Optional<Gender> newGender;

  public final Nationality newNationality;

  public final String newContactMail;

  public final Optional<Long> newCellphoneNumber;

  public final Long newIdNumber;

  public final Long newTaxId;

  public final Long newSocialSecurityId;

  public final List<String> newPhotoReferences;

  public UpdateProfile(String newUsername, String newFirstName, String newLastName,
      String newFullName, String newPassword, LocalDate newBirthday, Optional<Gender> newGender,
      Nationality newNationality, String newContactMail, Optional<Long> newCellphoneNumber,
      Long newIdNumber, Long newTaxId, Long newSocialSecurityId, List<String> newPhotoReferences) {
    this.newUsername = newUsername;
    this.newFirstName = newFirstName;
    this.newLastName = newLastName;
    this.newFullName = newFullName;
    this.newPassword = newPassword;
    this.newBirthday = newBirthday;
    this.newGender = newGender;
    this.newNationality = newNationality;
    this.newContactMail = newContactMail;
    this.newCellphoneNumber = newCellphoneNumber;
    this.newIdNumber = newIdNumber;
    this.newTaxId = newTaxId;
    this.newSocialSecurityId = newSocialSecurityId;
    this.newPhotoReferences = newPhotoReferences;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateProfile fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateProfile> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(14,0,
          recordValue$);
      String newUsername = PrimitiveValueDecoders.fromText.decode(fields$.get(0).getValue());
      String newFirstName = PrimitiveValueDecoders.fromText.decode(fields$.get(1).getValue());
      String newLastName = PrimitiveValueDecoders.fromText.decode(fields$.get(2).getValue());
      String newFullName = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      String newPassword = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      LocalDate newBirthday = PrimitiveValueDecoders.fromDate.decode(fields$.get(5).getValue());
      Optional<Gender> newGender = PrimitiveValueDecoders.fromOptional(Gender.valueDecoder())
          .decode(fields$.get(6).getValue());
      Nationality newNationality = Nationality.valueDecoder().decode(fields$.get(7).getValue());
      String newContactMail = PrimitiveValueDecoders.fromText.decode(fields$.get(8).getValue());
      Optional<Long> newCellphoneNumber = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromInt64).decode(fields$.get(9).getValue());
      Long newIdNumber = PrimitiveValueDecoders.fromInt64.decode(fields$.get(10).getValue());
      Long newTaxId = PrimitiveValueDecoders.fromInt64.decode(fields$.get(11).getValue());
      Long newSocialSecurityId = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(12).getValue());
      List<String> newPhotoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(13).getValue());
      return new UpdateProfile(newUsername, newFirstName, newLastName, newFullName, newPassword,
          newBirthday, newGender, newNationality, newContactMail, newCellphoneNumber, newIdNumber,
          newTaxId, newSocialSecurityId, newPhotoReferences);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(14);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newUsername", new Text(this.newUsername)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newFirstName", new Text(this.newFirstName)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLastName", new Text(this.newLastName)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newFullName", new Text(this.newFullName)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newPassword", new Text(this.newPassword)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newBirthday", new Date((int) this.newBirthday.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGender", DamlOptional.of(this.newGender.map(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newNationality", this.newNationality.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newContactMail", new Text(this.newContactMail)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newCellphoneNumber", DamlOptional.of(this.newCellphoneNumber.map(v$0 -> new Int64(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newIdNumber", new Int64(this.newIdNumber)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newTaxId", new Int64(this.newTaxId)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newSocialSecurityId", new Int64(this.newSocialSecurityId)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newPhotoReferences", this.newPhotoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateProfile> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newUsername", "newFirstName", "newLastName", "newFullName", "newPassword", "newBirthday", "newGender", "newNationality", "newContactMail", "newCellphoneNumber", "newIdNumber", "newTaxId", "newSocialSecurityId", "newPhotoReferences"), name -> {
          switch (name) {
            case "newUsername": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newFirstName": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newLastName": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newFullName": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newPassword": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newBirthday": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "newGender": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.interface$.profilemanager.userprofile.common.Gender.jsonDecoder()));
            case "newNationality": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, daml.interface$.profilemanager.userprofile.common.Nationality.jsonDecoder());
            case "newContactMail": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newCellphoneNumber": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64));
            case "newIdNumber": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newTaxId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newSocialSecurityId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newPhotoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateProfile(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13])));
  }

  public static UpdateProfile fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newUsername", apply(JsonLfEncoders::text, newUsername)),
        JsonLfEncoders.Field.of("newFirstName", apply(JsonLfEncoders::text, newFirstName)),
        JsonLfEncoders.Field.of("newLastName", apply(JsonLfEncoders::text, newLastName)),
        JsonLfEncoders.Field.of("newFullName", apply(JsonLfEncoders::text, newFullName)),
        JsonLfEncoders.Field.of("newPassword", apply(JsonLfEncoders::text, newPassword)),
        JsonLfEncoders.Field.of("newBirthday", apply(JsonLfEncoders::date, newBirthday)),
        JsonLfEncoders.Field.of("newGender", apply(JsonLfEncoders.optional(Gender::jsonEncoder), newGender)),
        JsonLfEncoders.Field.of("newNationality", apply(Nationality::jsonEncoder, newNationality)),
        JsonLfEncoders.Field.of("newContactMail", apply(JsonLfEncoders::text, newContactMail)),
        JsonLfEncoders.Field.of("newCellphoneNumber", apply(JsonLfEncoders.optional(JsonLfEncoders::int64), newCellphoneNumber)),
        JsonLfEncoders.Field.of("newIdNumber", apply(JsonLfEncoders::int64, newIdNumber)),
        JsonLfEncoders.Field.of("newTaxId", apply(JsonLfEncoders::int64, newTaxId)),
        JsonLfEncoders.Field.of("newSocialSecurityId", apply(JsonLfEncoders::int64, newSocialSecurityId)),
        JsonLfEncoders.Field.of("newPhotoReferences", apply(JsonLfEncoders.list(JsonLfEncoders::text), newPhotoReferences)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof UpdateProfile)) {
      return false;
    }
    UpdateProfile other = (UpdateProfile) object;
    return Objects.equals(this.newUsername, other.newUsername) &&
        Objects.equals(this.newFirstName, other.newFirstName) &&
        Objects.equals(this.newLastName, other.newLastName) &&
        Objects.equals(this.newFullName, other.newFullName) &&
        Objects.equals(this.newPassword, other.newPassword) &&
        Objects.equals(this.newBirthday, other.newBirthday) &&
        Objects.equals(this.newGender, other.newGender) &&
        Objects.equals(this.newNationality, other.newNationality) &&
        Objects.equals(this.newContactMail, other.newContactMail) &&
        Objects.equals(this.newCellphoneNumber, other.newCellphoneNumber) &&
        Objects.equals(this.newIdNumber, other.newIdNumber) &&
        Objects.equals(this.newTaxId, other.newTaxId) &&
        Objects.equals(this.newSocialSecurityId, other.newSocialSecurityId) &&
        Objects.equals(this.newPhotoReferences, other.newPhotoReferences);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newUsername, this.newFirstName, this.newLastName, this.newFullName,
        this.newPassword, this.newBirthday, this.newGender, this.newNationality,
        this.newContactMail, this.newCellphoneNumber, this.newIdNumber, this.newTaxId,
        this.newSocialSecurityId, this.newPhotoReferences);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.profilemanager.userprofile.userprofile.UpdateProfile(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.newUsername, this.newFirstName, this.newLastName, this.newFullName, this.newPassword,
        this.newBirthday, this.newGender, this.newNationality, this.newContactMail,
        this.newCellphoneNumber, this.newIdNumber, this.newTaxId, this.newSocialSecurityId,
        this.newPhotoReferences);
  }
}
