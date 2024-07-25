package daml.interface$.propertymanager.property.landproperty.landproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.interface$.propertymanager.property.common.ViableConstructionTypes;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetLandViableConstructionTypes extends DamlRecord<SetLandViableConstructionTypes> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final List<ViableConstructionTypes> newLandViableConstructionTypes;

  public SetLandViableConstructionTypes(
      List<ViableConstructionTypes> newLandViableConstructionTypes) {
    this.newLandViableConstructionTypes = newLandViableConstructionTypes;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetLandViableConstructionTypes fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetLandViableConstructionTypes> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      List<ViableConstructionTypes> newLandViableConstructionTypes =
          PrimitiveValueDecoders.fromList(ViableConstructionTypes.valueDecoder())
          .decode(fields$.get(0).getValue());
      return new SetLandViableConstructionTypes(newLandViableConstructionTypes);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLandViableConstructionTypes", this.newLandViableConstructionTypes.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetLandViableConstructionTypes> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newLandViableConstructionTypes"), name -> {
          switch (name) {
            case "newLandViableConstructionTypes": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.interface$.propertymanager.property.common.ViableConstructionTypes.jsonDecoder()));
            default: return null;
          }
        }
        , (Object[] args) -> new SetLandViableConstructionTypes(JsonLfDecoders.cast(args[0])));
  }

  public static SetLandViableConstructionTypes fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newLandViableConstructionTypes", apply(JsonLfEncoders.list(ViableConstructionTypes::jsonEncoder), newLandViableConstructionTypes)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetLandViableConstructionTypes)) {
      return false;
    }
    SetLandViableConstructionTypes other = (SetLandViableConstructionTypes) object;
    return Objects.equals(this.newLandViableConstructionTypes, other.newLandViableConstructionTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newLandViableConstructionTypes);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.landproperty.landproperty.SetLandViableConstructionTypes(%s)",
        this.newLandViableConstructionTypes);
  }
}
