package daml.marketplace.interface$.propertymanager.property.residenceproperty.residenceproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Numeric;
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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetResidenceGrossArea extends DamlRecord<SetResidenceGrossArea> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final BigDecimal newResidenceGrossArea;

  public SetResidenceGrossArea(BigDecimal newResidenceGrossArea) {
    this.newResidenceGrossArea = newResidenceGrossArea;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetResidenceGrossArea fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetResidenceGrossArea> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      BigDecimal newResidenceGrossArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(0).getValue());
      return new SetResidenceGrossArea(newResidenceGrossArea);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidenceGrossArea", new Numeric(this.newResidenceGrossArea)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetResidenceGrossArea> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newResidenceGrossArea"), name -> {
          switch (name) {
            case "newResidenceGrossArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            default: return null;
          }
        }
        , (Object[] args) -> new SetResidenceGrossArea(JsonLfDecoders.cast(args[0])));
  }

  public static SetResidenceGrossArea fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newResidenceGrossArea", apply(JsonLfEncoders::numeric, newResidenceGrossArea)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetResidenceGrossArea)) {
      return false;
    }
    SetResidenceGrossArea other = (SetResidenceGrossArea) object;
    return Objects.equals(this.newResidenceGrossArea, other.newResidenceGrossArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newResidenceGrossArea);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.property.residenceproperty.residenceproperty.SetResidenceGrossArea(%s)",
        this.newResidenceGrossArea);
  }
}
