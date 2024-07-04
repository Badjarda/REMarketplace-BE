package daml.daml.finance.interface$.util.lockable;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlOptional;
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
import java.util.Optional;

public class View extends DamlRecord<View> {
  public static final String _packageId = "6006a43f628a8f49702554de6206668fb67dbd5dc9c4d3158de53325a0a4631e";

  public final Optional<Lock> lock;

  public final Set<String> controllers;

  public View(Optional<Lock> lock, Set<String> controllers) {
    this.lock = lock;
    this.controllers = controllers;
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
      Optional<Lock> lock = PrimitiveValueDecoders.fromOptional(Lock.valueDecoder())
          .decode(fields$.get(0).getValue());
      Set<String> controllers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      return new View(lock, controllers);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("lock", DamlOptional.of(this.lock.map(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("controllers", this.controllers.toValue(v$0 -> new Party(v$0))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("lock", "controllers"), name -> {
          switch (name) {
            case "lock": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.daml.finance.interface$.util.lockable.Lock.jsonDecoder()));
            case "controllers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
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
        JsonLfEncoders.Field.of("lock", apply(JsonLfEncoders.optional(Lock::jsonEncoder), lock)),
        JsonLfEncoders.Field.of("controllers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), controllers)));
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
    return Objects.equals(this.lock, other.lock) &&
        Objects.equals(this.controllers, other.controllers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.lock, this.controllers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.util.lockable.View(%s, %s)", this.lock,
        this.controllers);
  }
}
