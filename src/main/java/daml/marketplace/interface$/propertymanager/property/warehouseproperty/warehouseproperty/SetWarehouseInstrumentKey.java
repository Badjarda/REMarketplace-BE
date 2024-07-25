package daml.interface$.propertymanager.property.warehouseproperty.warehouseproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetWarehouseInstrumentKey extends DamlRecord<SetWarehouseInstrumentKey> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final InstrumentKey newWarehouseInstrumentKey;

  public SetWarehouseInstrumentKey(InstrumentKey newWarehouseInstrumentKey) {
    this.newWarehouseInstrumentKey = newWarehouseInstrumentKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetWarehouseInstrumentKey fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetWarehouseInstrumentKey> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      InstrumentKey newWarehouseInstrumentKey = InstrumentKey.valueDecoder()
          .decode(fields$.get(0).getValue());
      return new SetWarehouseInstrumentKey(newWarehouseInstrumentKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newWarehouseInstrumentKey", this.newWarehouseInstrumentKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetWarehouseInstrumentKey> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newWarehouseInstrumentKey"), name -> {
          switch (name) {
            case "newWarehouseInstrumentKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new SetWarehouseInstrumentKey(JsonLfDecoders.cast(args[0])));
  }

  public static SetWarehouseInstrumentKey fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newWarehouseInstrumentKey", apply(InstrumentKey::jsonEncoder, newWarehouseInstrumentKey)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetWarehouseInstrumentKey)) {
      return false;
    }
    SetWarehouseInstrumentKey other = (SetWarehouseInstrumentKey) object;
    return Objects.equals(this.newWarehouseInstrumentKey, other.newWarehouseInstrumentKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newWarehouseInstrumentKey);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.warehouseproperty.warehouseproperty.SetWarehouseInstrumentKey(%s)",
        this.newWarehouseInstrumentKey);
  }
}
