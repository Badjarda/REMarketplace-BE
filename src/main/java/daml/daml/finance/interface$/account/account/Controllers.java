package daml.daml.finance.interface$.account.account;

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

public class Controllers extends DamlRecord<Controllers> {
  public static final String _packageId = "20095234ad30447a6c709382b0ff3ed4ed0cbaf588e1048499bcdfa78a9e774c";

  public final Set<String> outgoing;

  public final Set<String> incoming;

  public Controllers(Set<String> outgoing, Set<String> incoming) {
    this.outgoing = outgoing;
    this.incoming = incoming;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Controllers fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Controllers> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Set<String> outgoing = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      Set<String> incoming = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      return new Controllers(outgoing, incoming);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("outgoing", this.outgoing.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("incoming", this.incoming.toValue(v$0 -> new Party(v$0))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Controllers> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("outgoing", "incoming"), name -> {
          switch (name) {
            case "outgoing": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "incoming": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new Controllers(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static Controllers fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("outgoing", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), outgoing)),
        JsonLfEncoders.Field.of("incoming", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), incoming)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Controllers)) {
      return false;
    }
    Controllers other = (Controllers) object;
    return Objects.equals(this.outgoing, other.outgoing) &&
        Objects.equals(this.incoming, other.incoming);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.outgoing, this.incoming);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.account.account.Controllers(%s, %s)",
        this.outgoing, this.incoming);
  }
}
