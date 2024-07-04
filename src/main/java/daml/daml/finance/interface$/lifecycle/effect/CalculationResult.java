package daml.daml.finance.interface$.lifecycle.effect;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Numeric;
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

public class CalculationResult extends DamlRecord<CalculationResult> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final List<Quantity<InstrumentKey, BigDecimal>> consumed;

  public final List<Quantity<InstrumentKey, BigDecimal>> produced;

  public CalculationResult(List<Quantity<InstrumentKey, BigDecimal>> consumed,
      List<Quantity<InstrumentKey, BigDecimal>> produced) {
    this.consumed = consumed;
    this.produced = produced;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CalculationResult fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<CalculationResult> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      List<Quantity<InstrumentKey, BigDecimal>> consumed = PrimitiveValueDecoders.fromList(
            Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
            java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
            PrimitiveValueDecoders.fromNumeric)).decode(fields$.get(0).getValue());
      List<Quantity<InstrumentKey, BigDecimal>> produced = PrimitiveValueDecoders.fromList(
            Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
            java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
            PrimitiveValueDecoders.fromNumeric)).decode(fields$.get(1).getValue());
      return new CalculationResult(consumed, produced);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("consumed", this.consumed.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue(v$1 -> v$1.toValue(),
        v$2 -> new Numeric(v$2))))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("produced", this.produced.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue(v$1 -> v$1.toValue(),
        v$2 -> new Numeric(v$2))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<CalculationResult> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("consumed", "produced"), name -> {
          switch (name) {
            case "consumed": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10))));
            case "produced": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10))));
            default: return null;
          }
        }
        , (Object[] args) -> new CalculationResult(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static CalculationResult fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("consumed", apply(JsonLfEncoders.list(_x1 -> _x1.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric)), consumed)),
        JsonLfEncoders.Field.of("produced", apply(JsonLfEncoders.list(_x1 -> _x1.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric)), produced)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof CalculationResult)) {
      return false;
    }
    CalculationResult other = (CalculationResult) object;
    return Objects.equals(this.consumed, other.consumed) &&
        Objects.equals(this.produced, other.produced);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.consumed, this.produced);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.effect.CalculationResult(%s, %s)",
        this.consumed, this.produced);
  }
}
