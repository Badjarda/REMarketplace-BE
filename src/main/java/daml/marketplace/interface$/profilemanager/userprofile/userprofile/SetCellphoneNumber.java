package daml.marketplace.interface$.profilemanager.userprofile.userprofile;

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

public class SetCellphoneNumber extends DamlRecord<SetCellphoneNumber> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final Optional<Long> newCellphoneNumber;

  public SetCellphoneNumber(Optional<Long> newCellphoneNumber) {
    this.newCellphoneNumber = newCellphoneNumber;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetCellphoneNumber fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetCellphoneNumber> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,1,
          recordValue$);
      Optional<Long> newCellphoneNumber = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromInt64).decode(fields$.get(0).getValue());
      return new SetCellphoneNumber(newCellphoneNumber);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newCellphoneNumber", DamlOptional.of(this.newCellphoneNumber.map(v$0 -> new Int64(v$0)))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetCellphoneNumber> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newCellphoneNumber"), name -> {
          switch (name) {
            case "newCellphoneNumber": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64));
            default: return null;
          }
        }
        , (Object[] args) -> new SetCellphoneNumber(JsonLfDecoders.cast(args[0])));
  }

  public static SetCellphoneNumber fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newCellphoneNumber", apply(JsonLfEncoders.optional(JsonLfEncoders::int64), newCellphoneNumber)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetCellphoneNumber)) {
      return false;
    }
    SetCellphoneNumber other = (SetCellphoneNumber) object;
    return Objects.equals(this.newCellphoneNumber, other.newCellphoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newCellphoneNumber);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.profilemanager.userprofile.userprofile.SetCellphoneNumber(%s)",
        this.newCellphoneNumber);
  }
}
