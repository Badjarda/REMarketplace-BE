package daml.daml.finance.interface$.lifecycle.effect;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Numeric;
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
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.daml.finance.interface$.types.common.types.Quantity;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Calculate extends DamlRecord<Calculate> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final String actor;

  public final Quantity<InstrumentKey, BigDecimal> quantity;

  public Calculate(String actor, Quantity<InstrumentKey, BigDecimal> quantity) {
    this.actor = actor;
    this.quantity = quantity;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Calculate fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Calculate> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String actor = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Quantity<InstrumentKey, BigDecimal> quantity =
          Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
          java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
          PrimitiveValueDecoders.fromNumeric).decode(fields$.get(1).getValue());
      return new Calculate(actor, quantity);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("actor", new Party(this.actor)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("quantity", this.quantity.toValue(v$0 -> v$0.toValue(),
        v$1 -> new Numeric(v$1))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Calculate> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("actor", "quantity"), name -> {
          switch (name) {
            case "actor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "quantity": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10)));
            default: return null;
          }
        }
        , (Object[] args) -> new Calculate(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static Calculate fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("actor", apply(JsonLfEncoders::party, actor)),
        JsonLfEncoders.Field.of("quantity", apply(_x0 -> _x0.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric), quantity)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Calculate)) {
      return false;
    }
    Calculate other = (Calculate) object;
    return Objects.equals(this.actor, other.actor) && Objects.equals(this.quantity, other.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.actor, this.quantity);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.effect.Calculate(%s, %s)",
        this.actor, this.quantity);
  }
}
