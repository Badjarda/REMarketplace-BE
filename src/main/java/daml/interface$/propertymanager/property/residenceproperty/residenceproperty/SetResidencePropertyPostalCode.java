package daml.interface$.propertymanager.property.residenceproperty.residenceproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetResidencePropertyPostalCode extends DamlRecord<SetResidencePropertyPostalCode> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final String newResidencePropertyPostalCode;

  public SetResidencePropertyPostalCode(String newResidencePropertyPostalCode) {
    this.newResidencePropertyPostalCode = newResidencePropertyPostalCode;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetResidencePropertyPostalCode fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetResidencePropertyPostalCode> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      String newResidencePropertyPostalCode = PrimitiveValueDecoders.fromText
          .decode(fields$.get(0).getValue());
      return new SetResidencePropertyPostalCode(newResidencePropertyPostalCode);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidencePropertyPostalCode", new Text(this.newResidencePropertyPostalCode)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetResidencePropertyPostalCode> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newResidencePropertyPostalCode"), name -> {
          switch (name) {
            case "newResidencePropertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            default: return null;
          }
        }
        , (Object[] args) -> new SetResidencePropertyPostalCode(JsonLfDecoders.cast(args[0])));
  }

  public static SetResidencePropertyPostalCode fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newResidencePropertyPostalCode", apply(JsonLfEncoders::text, newResidencePropertyPostalCode)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetResidencePropertyPostalCode)) {
      return false;
    }
    SetResidencePropertyPostalCode other = (SetResidencePropertyPostalCode) object;
    return Objects.equals(this.newResidencePropertyPostalCode, other.newResidencePropertyPostalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newResidencePropertyPostalCode);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.residenceproperty.residenceproperty.SetResidencePropertyPostalCode(%s)",
        this.newResidencePropertyPostalCode);
  }
}
