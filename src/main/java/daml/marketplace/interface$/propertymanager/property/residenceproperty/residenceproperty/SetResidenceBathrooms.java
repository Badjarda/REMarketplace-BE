package daml.marketplace.interface$.propertymanager.property.residenceproperty.residenceproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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

public class SetResidenceBathrooms extends DamlRecord<SetResidenceBathrooms> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final Long newResidenceBathrooms;

  public SetResidenceBathrooms(Long newResidenceBathrooms) {
    this.newResidenceBathrooms = newResidenceBathrooms;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetResidenceBathrooms fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetResidenceBathrooms> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Long newResidenceBathrooms = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(0).getValue());
      return new SetResidenceBathrooms(newResidenceBathrooms);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceBathrooms", new Int64(this.newResidenceBathrooms)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetResidenceBathrooms> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newResidenceBathrooms"), name -> {
          switch (name) {
            case "newResidenceBathrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            default: return null;
          }
        }
        , (Object[] args) -> new SetResidenceBathrooms(JsonLfDecoders.cast(args[0])));
  }

  public static SetResidenceBathrooms fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newResidenceBathrooms", apply(JsonLfEncoders::int64, newResidenceBathrooms)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetResidenceBathrooms)) {
      return false;
    }
    SetResidenceBathrooms other = (SetResidenceBathrooms) object;
    return Objects.equals(this.newResidenceBathrooms, other.newResidenceBathrooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newResidenceBathrooms);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.property.residenceproperty.residenceproperty.SetResidenceBathrooms(%s)",
        this.newResidenceBathrooms);
  }
}
