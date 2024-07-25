package daml.interface$.propertymanager.property.warehouseproperty.warehouseproperty;

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

public class SetWarehousePrice extends DamlRecord<SetWarehousePrice> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final BigDecimal newWarehousePrice;

  public SetWarehousePrice(BigDecimal newWarehousePrice) {
    this.newWarehousePrice = newWarehousePrice;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetWarehousePrice fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetWarehousePrice> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      BigDecimal newWarehousePrice = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(0).getValue());
      return new SetWarehousePrice(newWarehousePrice);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehousePrice", new Numeric(this.newWarehousePrice)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetWarehousePrice> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newWarehousePrice"), name -> {
          switch (name) {
            case "newWarehousePrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            default: return null;
          }
        }
        , (Object[] args) -> new SetWarehousePrice(JsonLfDecoders.cast(args[0])));
  }

  public static SetWarehousePrice fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newWarehousePrice", apply(JsonLfEncoders::numeric, newWarehousePrice)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetWarehousePrice)) {
      return false;
    }
    SetWarehousePrice other = (SetWarehousePrice) object;
    return Objects.equals(this.newWarehousePrice, other.newWarehousePrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newWarehousePrice);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.warehouseproperty.warehouseproperty.SetWarehousePrice(%s)",
        this.newWarehousePrice);
  }
}
