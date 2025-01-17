package daml.marketplace.interface$.propertymanager.property.residenceproperty.residenceproperty;

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

public class SetResidencePropertyAddress extends DamlRecord<SetResidencePropertyAddress> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final String newResidencePropertyAddress;

  public SetResidencePropertyAddress(String newResidencePropertyAddress) {
    this.newResidencePropertyAddress = newResidencePropertyAddress;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetResidencePropertyAddress fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetResidencePropertyAddress> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      String newResidencePropertyAddress = PrimitiveValueDecoders.fromText
          .decode(fields$.get(0).getValue());
      return new SetResidencePropertyAddress(newResidencePropertyAddress);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newResidencePropertyAddress", new Text(this.newResidencePropertyAddress)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetResidencePropertyAddress> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newResidencePropertyAddress"), name -> {
          switch (name) {
            case "newResidencePropertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            default: return null;
          }
        }
        , (Object[] args) -> new SetResidencePropertyAddress(JsonLfDecoders.cast(args[0])));
  }

  public static SetResidencePropertyAddress fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newResidencePropertyAddress", apply(JsonLfEncoders::text, newResidencePropertyAddress)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetResidencePropertyAddress)) {
      return false;
    }
    SetResidencePropertyAddress other = (SetResidencePropertyAddress) object;
    return Objects.equals(this.newResidencePropertyAddress, other.newResidencePropertyAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newResidencePropertyAddress);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.property.residenceproperty.residenceproperty.SetResidencePropertyAddress(%s)",
        this.newResidencePropertyAddress);
  }
}
