package daml.daml.finance.interface$.util.disclosure;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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
import daml.da.types.Tuple2;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveObservers extends DamlRecord<RemoveObservers> {
  public static final String _packageId = "6006a43f628a8f49702554de6206668fb67dbd5dc9c4d3158de53325a0a4631e";

  public final Set<String> disclosers;

  public final Tuple2<String, Set<String>> observersToRemove;

  public RemoveObservers(Set<String> disclosers, Tuple2<String, Set<String>> observersToRemove) {
    this.disclosers = disclosers;
    this.observersToRemove = observersToRemove;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static RemoveObservers fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RemoveObservers> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Set<String> disclosers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      Tuple2<String, Set<String>> observersToRemove = Tuple2.<java.lang.String,
          daml.da.set.types.Set<java.lang.String>>valueDecoder(PrimitiveValueDecoders.fromText,
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(1).getValue());
      return new RemoveObservers(disclosers, observersToRemove);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("disclosers", this.disclosers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observersToRemove", this.observersToRemove.toValue(v$0 -> new Text(v$0),
        v$1 -> v$1.toValue(v$2 -> new Party(v$2)))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RemoveObservers> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("disclosers", "observersToRemove"), name -> {
          switch (name) {
            case "disclosers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "observersToRemove": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.types.Tuple2.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new RemoveObservers(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static RemoveObservers fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("disclosers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), disclosers)),
        JsonLfEncoders.Field.of("observersToRemove", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::text, _x1 -> _x1.jsonEncoder(JsonLfEncoders::party)), observersToRemove)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof RemoveObservers)) {
      return false;
    }
    RemoveObservers other = (RemoveObservers) object;
    return Objects.equals(this.disclosers, other.disclosers) &&
        Objects.equals(this.observersToRemove, other.observersToRemove);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.disclosers, this.observersToRemove);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.util.disclosure.RemoveObservers(%s, %s)",
        this.disclosers, this.observersToRemove);
  }
}
