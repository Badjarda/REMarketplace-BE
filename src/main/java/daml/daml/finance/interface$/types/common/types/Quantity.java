package daml.daml.finance.interface$.types.common.types;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Quantity<u, a> {
  public static final String _packageId = "6ea0a5ef5513821304e7830999cbeedb0867b1bd7bc826f0efee61d5d53aa6a6";

  public final u unit;

  public final a amount;

  public Quantity(u unit, a amount) {
    this.unit = unit;
    this.amount = amount;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static <u, a> Quantity<u, a> fromValue(Value value$, Function<Value, u> fromValueu,
      Function<Value, a> fromValuea) throws IllegalArgumentException {
    return Quantity.<u, a>valueDecoder(ValueDecoder.fromFunction(fromValueu),
          ValueDecoder.fromFunction(fromValuea)).decode(value$);
  }

  public static <u, a> ValueDecoder<Quantity<u, a>> valueDecoder(ValueDecoder<u> fromValueu,
      ValueDecoder<a> fromValuea) throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0, recordValue$);
      u unit = fromValueu.decode(fields$.get(0).getValue());
      a amount = fromValuea.decode(fields$.get(1).getValue());
      return new Quantity<u, a>(unit, amount);
    } ;
  }

  public DamlRecord toValue(Function<u, Value> toValueu, Function<a, Value> toValuea) {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(2);
    fields.add(new DamlRecord.Field("unit", toValueu.apply(this.unit)));
    fields.add(new DamlRecord.Field("amount", toValuea.apply(this.amount)));
    return new DamlRecord(fields);
  }

  public static <u, a> JsonLfDecoder<Quantity<u, a>> jsonDecoder(JsonLfDecoder<u> decodeu,
      JsonLfDecoder<a> decodea) {
    return JsonLfDecoders.record(Arrays.asList("unit", "amount"), name -> {
          switch (name) {
            case "unit": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, decodeu);
            case "amount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, decodea);
            default: return null;
          }
        }
        , (Object[] args) -> new Quantity<u, a>(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static <u, a> Quantity<u, a> fromJson(String json, JsonLfDecoder<u> decodeu,
      JsonLfDecoder<a> decodea) throws JsonLfDecoder.Error {
    return jsonDecoder(decodeu, decodea).decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder(Function<u, JsonLfEncoder> makeEncoder_u,
      Function<a, JsonLfEncoder> makeEncoder_a) {
    return JsonLfEncoders.record(JsonLfEncoders.Field.of("unit", apply(makeEncoder_u, unit)),
        JsonLfEncoders.Field.of("amount", apply(makeEncoder_a, amount)));
  }

  public String toJson(Function<u, JsonLfEncoder> makeEncoder_u,
      Function<a, JsonLfEncoder> makeEncoder_a) {
    var w = new StringWriter();
    try {
      this.jsonEncoder(makeEncoder_u, makeEncoder_a).encode(new JsonLfWriter(w));
    } catch (IOException e) {
      // Not expected with StringWriter
      throw new UncheckedIOException(e);
    }
    return w.toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Quantity<?, ?>)) {
      return false;
    }
    Quantity<?, ?> other = (Quantity<?, ?>) object;
    return Objects.equals(this.unit, other.unit) && Objects.equals(this.amount, other.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unit, this.amount);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.types.common.types.Quantity(%s, %s)",
        this.unit, this.amount);
  }
}
