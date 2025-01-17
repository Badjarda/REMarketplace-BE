package daml.marketplace.interface$.propertymanager.property.warehouseproperty.warehouseproperty;

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

public class SetWarehousePropertyDistrict extends DamlRecord<SetWarehousePropertyDistrict> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final String newWarehousePropertyDistrict;

  public SetWarehousePropertyDistrict(String newWarehousePropertyDistrict) {
    this.newWarehousePropertyDistrict = newWarehousePropertyDistrict;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetWarehousePropertyDistrict fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetWarehousePropertyDistrict> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      String newWarehousePropertyDistrict = PrimitiveValueDecoders.fromText
          .decode(fields$.get(0).getValue());
      return new SetWarehousePropertyDistrict(newWarehousePropertyDistrict);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehousePropertyDistrict", new Text(this.newWarehousePropertyDistrict)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetWarehousePropertyDistrict> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newWarehousePropertyDistrict"), name -> {
          switch (name) {
            case "newWarehousePropertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            default: return null;
          }
        }
        , (Object[] args) -> new SetWarehousePropertyDistrict(JsonLfDecoders.cast(args[0])));
  }

  public static SetWarehousePropertyDistrict fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newWarehousePropertyDistrict", apply(JsonLfEncoders::text, newWarehousePropertyDistrict)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetWarehousePropertyDistrict)) {
      return false;
    }
    SetWarehousePropertyDistrict other = (SetWarehousePropertyDistrict) object;
    return Objects.equals(this.newWarehousePropertyDistrict, other.newWarehousePropertyDistrict);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newWarehousePropertyDistrict);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.property.warehouseproperty.warehouseproperty.SetWarehousePropertyDistrict(%s)",
        this.newWarehousePropertyDistrict);
  }
}
