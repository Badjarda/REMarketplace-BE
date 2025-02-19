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

public class SetResidenceBedrooms extends DamlRecord<SetResidenceBedrooms> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final Long newResidenceBedrooms;

  public SetResidenceBedrooms(Long newResidenceBedrooms) {
    this.newResidenceBedrooms = newResidenceBedrooms;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetResidenceBedrooms fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetResidenceBedrooms> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Long newResidenceBedrooms = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(0).getValue());
      return new SetResidenceBedrooms(newResidenceBedrooms);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceBedrooms", new Int64(this.newResidenceBedrooms)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetResidenceBedrooms> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newResidenceBedrooms"), name -> {
          switch (name) {
            case "newResidenceBedrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            default: return null;
          }
        }
        , (Object[] args) -> new SetResidenceBedrooms(JsonLfDecoders.cast(args[0])));
  }

  public static SetResidenceBedrooms fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newResidenceBedrooms", apply(JsonLfEncoders::int64, newResidenceBedrooms)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetResidenceBedrooms)) {
      return false;
    }
    SetResidenceBedrooms other = (SetResidenceBedrooms) object;
    return Objects.equals(this.newResidenceBedrooms, other.newResidenceBedrooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newResidenceBedrooms);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.property.residenceproperty.residenceproperty.SetResidenceBedrooms(%s)",
        this.newResidenceBedrooms);
  }
}
