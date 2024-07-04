package daml.daml.finance.interface$.settlement.instruction;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Party;
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
import java.util.Objects;

public class Execute extends DamlRecord<Execute> {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public final Set<String> actors;

  public Execute(Set<String> actors) {
    this.actors = actors;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Execute fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Execute> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Set<String> actors = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      return new Execute(actors);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("actors", this.actors.toValue(v$0 -> new Party(v$0))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Execute> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("actors"), name -> {
          switch (name) {
            case "actors": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new Execute(JsonLfDecoders.cast(args[0])));
  }

  public static Execute fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("actors", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), actors)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Execute)) {
      return false;
    }
    Execute other = (Execute) object;
    return Objects.equals(this.actors, other.actors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.actors);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.settlement.instruction.Execute(%s)",
        this.actors);
  }
}
