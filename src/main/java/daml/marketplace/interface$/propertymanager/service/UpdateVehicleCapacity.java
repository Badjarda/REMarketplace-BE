package daml.marketplace.interface$.propertymanager.service;

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
import daml.marketplace.interface$.common.types.PropertyKey;
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

public class UpdateVehicleCapacity extends DamlRecord<UpdateVehicleCapacity> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final Long newVehicleCapacity;

  public final PropertyKey propertyKey;

  public UpdateVehicleCapacity(Long newVehicleCapacity, PropertyKey propertyKey) {
    this.newVehicleCapacity = newVehicleCapacity;
    this.propertyKey = propertyKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateVehicleCapacity fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateVehicleCapacity> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Long newVehicleCapacity = PrimitiveValueDecoders.fromInt64.decode(fields$.get(0).getValue());
      PropertyKey propertyKey = PropertyKey.valueDecoder().decode(fields$.get(1).getValue());
      return new UpdateVehicleCapacity(newVehicleCapacity, propertyKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newVehicleCapacity", new Int64(this.newVehicleCapacity)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyKey", this.propertyKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateVehicleCapacity> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newVehicleCapacity", "propertyKey"), name -> {
          switch (name) {
            case "newVehicleCapacity": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "propertyKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.marketplace.interface$.common.types.PropertyKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateVehicleCapacity(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static UpdateVehicleCapacity fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newVehicleCapacity", apply(JsonLfEncoders::int64, newVehicleCapacity)),
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
    if (!(object instanceof UpdateVehicleCapacity)) {
      return false;
    }
    UpdateVehicleCapacity other = (UpdateVehicleCapacity) object;
    return Objects.equals(this.newVehicleCapacity, other.newVehicleCapacity) &&
        Objects.equals(this.propertyKey, other.propertyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newVehicleCapacity, this.propertyKey);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.service.UpdateVehicleCapacity(%s, %s)",
        this.newVehicleCapacity, this.propertyKey);
  }
}