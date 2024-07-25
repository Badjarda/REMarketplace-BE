package daml.interface$.propertymanager.property.garageproperty.garageproperty;

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
import daml.interface$.propertymanager.property.common.GarageType;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetGarageType extends DamlRecord<SetGarageType> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final GarageType newGarageType;

  public SetGarageType(GarageType newGarageType) {
    this.newGarageType = newGarageType;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetGarageType fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetGarageType> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      GarageType newGarageType = GarageType.valueDecoder().decode(fields$.get(0).getValue());
      return new SetGarageType(newGarageType);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGarageType", this.newGarageType.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetGarageType> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newGarageType"), name -> {
          switch (name) {
            case "newGarageType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.interface$.propertymanager.property.common.GarageType.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new SetGarageType(JsonLfDecoders.cast(args[0])));
  }

  public static SetGarageType fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newGarageType", apply(GarageType::jsonEncoder, newGarageType)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetGarageType)) {
      return false;
    }
    SetGarageType other = (SetGarageType) object;
    return Objects.equals(this.newGarageType, other.newGarageType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newGarageType);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.garageproperty.garageproperty.SetGarageType(%s)",
        this.newGarageType);
  }
}
