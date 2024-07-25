package daml.marketplace.interface$.propertymanager.property.landproperty.landproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetLandAccessByRoad extends DamlRecord<SetLandAccessByRoad> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final Boolean newLandAccessByRoad;

  public SetLandAccessByRoad(Boolean newLandAccessByRoad) {
    this.newLandAccessByRoad = newLandAccessByRoad;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetLandAccessByRoad fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetLandAccessByRoad> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Boolean newLandAccessByRoad = PrimitiveValueDecoders.fromBool
          .decode(fields$.get(0).getValue());
      return new SetLandAccessByRoad(newLandAccessByRoad);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandAccessByRoad", Bool.of(this.newLandAccessByRoad)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetLandAccessByRoad> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newLandAccessByRoad"), name -> {
          switch (name) {
            case "newLandAccessByRoad": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            default: return null;
          }
        }
        , (Object[] args) -> new SetLandAccessByRoad(JsonLfDecoders.cast(args[0])));
  }

  public static SetLandAccessByRoad fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newLandAccessByRoad", apply(JsonLfEncoders::bool, newLandAccessByRoad)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetLandAccessByRoad)) {
      return false;
    }
    SetLandAccessByRoad other = (SetLandAccessByRoad) object;
    return Objects.equals(this.newLandAccessByRoad, other.newLandAccessByRoad);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newLandAccessByRoad);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.property.landproperty.landproperty.SetLandAccessByRoad(%s)",
        this.newLandAccessByRoad);
  }
}
