package daml.interface$.profilemanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.interface$.common.types.UserProfileKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UpdateCellphoneNumber extends DamlRecord<UpdateCellphoneNumber> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final Optional<Long> newCellphoneNumber;

  public final UserProfileKey userProfileKey;

  public UpdateCellphoneNumber(Optional<Long> newCellphoneNumber, UserProfileKey userProfileKey) {
    this.newCellphoneNumber = newCellphoneNumber;
    this.userProfileKey = userProfileKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateCellphoneNumber fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateCellphoneNumber> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Optional<Long> newCellphoneNumber = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromInt64).decode(fields$.get(0).getValue());
      UserProfileKey userProfileKey = UserProfileKey.valueDecoder()
          .decode(fields$.get(1).getValue());
      return new UpdateCellphoneNumber(newCellphoneNumber, userProfileKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newCellphoneNumber", DamlOptional.of(this.newCellphoneNumber.map(v$0 -> new Int64(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userProfileKey", this.userProfileKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateCellphoneNumber> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newCellphoneNumber", "userProfileKey"), name -> {
          switch (name) {
            case "newCellphoneNumber": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64));
            case "userProfileKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.interface$.common.types.UserProfileKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateCellphoneNumber(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static UpdateCellphoneNumber fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newCellphoneNumber", apply(JsonLfEncoders.optional(JsonLfEncoders::int64), newCellphoneNumber)),
        JsonLfEncoders.Field.of("userProfileKey", apply(UserProfileKey::jsonEncoder, userProfileKey)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof UpdateCellphoneNumber)) {
      return false;
    }
    UpdateCellphoneNumber other = (UpdateCellphoneNumber) object;
    return Objects.equals(this.newCellphoneNumber, other.newCellphoneNumber) &&
        Objects.equals(this.userProfileKey, other.userProfileKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newCellphoneNumber, this.userProfileKey);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.profilemanager.service.UpdateCellphoneNumber(%s, %s)",
        this.newCellphoneNumber, this.userProfileKey);
  }
}
