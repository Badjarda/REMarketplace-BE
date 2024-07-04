package daml.daml.finance.interface$.util.lockable;

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
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Acquire extends DamlRecord<Acquire> {
  public static final String _packageId = "6006a43f628a8f49702554de6206668fb67dbd5dc9c4d3158de53325a0a4631e";

  public final Set<String> newLockers;

  public final String context;

  public final LockType lockType;

  public Acquire(Set<String> newLockers, String context, LockType lockType) {
    this.newLockers = newLockers;
    this.context = context;
    this.lockType = lockType;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Acquire fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Acquire> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      Set<String> newLockers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      String context = PrimitiveValueDecoders.fromText.decode(fields$.get(1).getValue());
      LockType lockType = LockType.valueDecoder().decode(fields$.get(2).getValue());
      return new Acquire(newLockers, context, lockType);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newLockers", this.newLockers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("context", new Text(this.context)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("lockType", this.lockType.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Acquire> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newLockers", "context", "lockType"), name -> {
          switch (name) {
            case "newLockers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "context": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "lockType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.util.lockable.LockType.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new Acquire(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static Acquire fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newLockers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), newLockers)),
        JsonLfEncoders.Field.of("context", apply(JsonLfEncoders::text, context)),
        JsonLfEncoders.Field.of("lockType", apply(LockType::jsonEncoder, lockType)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Acquire)) {
      return false;
    }
    Acquire other = (Acquire) object;
    return Objects.equals(this.newLockers, other.newLockers) &&
        Objects.equals(this.context, other.context) &&
        Objects.equals(this.lockType, other.lockType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newLockers, this.context, this.lockType);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.util.lockable.Acquire(%s, %s, %s)",
        this.newLockers, this.context, this.lockType);
  }
}
