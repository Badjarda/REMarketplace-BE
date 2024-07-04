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

public class Lock extends DamlRecord<Lock> {
  public static final String _packageId = "6006a43f628a8f49702554de6206668fb67dbd5dc9c4d3158de53325a0a4631e";

  public final Set<String> lockers;

  public final Set<String> context;

  public final LockType lockType;

  public Lock(Set<String> lockers, Set<String> context, LockType lockType) {
    this.lockers = lockers;
    this.context = context;
    this.lockType = lockType;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Lock fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Lock> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      Set<String> lockers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      Set<String> context = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromText)
          .decode(fields$.get(1).getValue());
      LockType lockType = LockType.valueDecoder().decode(fields$.get(2).getValue());
      return new Lock(lockers, context, lockType);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("lockers", this.lockers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("context", this.context.toValue(v$0 -> new Text(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("lockType", this.lockType.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Lock> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("lockers", "context", "lockType"), name -> {
          switch (name) {
            case "lockers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "context": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            case "lockType": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.util.lockable.LockType.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new Lock(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static Lock fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("lockers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), lockers)),
        JsonLfEncoders.Field.of("context", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::text), context)),
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
    if (!(object instanceof Lock)) {
      return false;
    }
    Lock other = (Lock) object;
    return Objects.equals(this.lockers, other.lockers) &&
        Objects.equals(this.context, other.context) &&
        Objects.equals(this.lockType, other.lockType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.lockers, this.context, this.lockType);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.util.lockable.Lock(%s, %s, %s)",
        this.lockers, this.context, this.lockType);
  }
}
