package daml.marketplace.interface$.propertymanager.service;

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
import daml.marketplace.interface$.common.types.PropertyKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UpdateWarehousePropertyCounty extends DamlRecord<UpdateWarehousePropertyCounty> {
  public static final String _packageId = "ab9bbdb36a2cfacb7b3bd66e0d472fb99ff4b9d98bdf81e76a5b8bd3b57250a9";

  public final String newWarehousePropertyCounty;

  public final PropertyKey propertyKey;

  public UpdateWarehousePropertyCounty(String newWarehousePropertyCounty, PropertyKey propertyKey) {
    this.newWarehousePropertyCounty = newWarehousePropertyCounty;
    this.propertyKey = propertyKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateWarehousePropertyCounty fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateWarehousePropertyCounty> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String newWarehousePropertyCounty = PrimitiveValueDecoders.fromText
          .decode(fields$.get(0).getValue());
      PropertyKey propertyKey = PropertyKey.valueDecoder().decode(fields$.get(1).getValue());
      return new UpdateWarehousePropertyCounty(newWarehousePropertyCounty, propertyKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehousePropertyCounty", new Text(this.newWarehousePropertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyKey", this.propertyKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateWarehousePropertyCounty> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newWarehousePropertyCounty", "propertyKey"), name -> {
          switch (name) {
            case "newWarehousePropertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "propertyKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.marketplace.interface$.common.types.PropertyKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateWarehousePropertyCounty(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static UpdateWarehousePropertyCounty fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newWarehousePropertyCounty", apply(JsonLfEncoders::text, newWarehousePropertyCounty)),
        JsonLfEncoders.Field.of("propertyKey", apply(PropertyKey::jsonEncoder, propertyKey)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof UpdateWarehousePropertyCounty)) {
      return false;
    }
    UpdateWarehousePropertyCounty other = (UpdateWarehousePropertyCounty) object;
    return Objects.equals(this.newWarehousePropertyCounty, other.newWarehousePropertyCounty) &&
        Objects.equals(this.propertyKey, other.propertyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newWarehousePropertyCounty, this.propertyKey);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.service.UpdateWarehousePropertyCounty(%s, %s)",
        this.newWarehousePropertyCounty, this.propertyKey);
  }
}
