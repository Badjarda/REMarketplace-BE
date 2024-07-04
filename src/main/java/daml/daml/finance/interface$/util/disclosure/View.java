package daml.daml.finance.interface$.util.disclosure;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Party;
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
import daml.da.set.types.Set;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class View extends DamlRecord<View> {
  public static final String _packageId = "6006a43f628a8f49702554de6206668fb67dbd5dc9c4d3158de53325a0a4631e";

  public final Set<String> disclosureControllers;

  public final Map<String, Set<String>> observers;

  public View(Set<String> disclosureControllers, Map<String, Set<String>> observers) {
    this.disclosureControllers = disclosureControllers;
    this.observers = observers;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static View fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<View> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Set<String> disclosureControllers =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(1).getValue());
      return new View(disclosureControllers, observers);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("disclosureControllers", this.disclosureControllers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observers", this.observers.entrySet()
        .stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("disclosureControllers", "observers"), name -> {
          switch (name) {
            case "disclosureControllers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new View(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static View fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("disclosureControllers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), disclosureControllers)),
        JsonLfEncoders.Field.of("observers", apply(JsonLfEncoders.genMap(JsonLfEncoders::text, _x1 -> _x1.jsonEncoder(JsonLfEncoders::party)), observers)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof View)) {
      return false;
    }
    View other = (View) object;
    return Objects.equals(this.disclosureControllers, other.disclosureControllers) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.disclosureControllers, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.util.disclosure.View(%s, %s)",
        this.disclosureControllers, this.observers);
  }
}
