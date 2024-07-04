package daml.daml.finance.interface$.holding.fungible;

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

public class Split extends DamlRecord<Split> {
  public static final String _packageId = "1b3dd202f2b5f6e97f0cc3426598a0c6c4725d8885e9e91d14377dce3e451348";

  public final List<BigDecimal> amounts;

  public Split(List<BigDecimal> amounts) {
    this.amounts = amounts;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Split fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Split> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      List<BigDecimal> amounts = PrimitiveValueDecoders.fromList(PrimitiveValueDecoders.fromNumeric)
          .decode(fields$.get(0).getValue());
      return new Split(amounts);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("amounts", this.amounts.stream().collect(DamlCollectors.toDamlList(v$0 -> new Numeric(v$0)))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Split> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("amounts"), name -> {
          switch (name) {
            case "amounts": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10)));
            default: return null;
          }
        }
        , (Object[] args) -> new Split(JsonLfDecoders.cast(args[0])));
  }

  public static Split fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("amounts", apply(JsonLfEncoders.list(JsonLfEncoders::numeric), amounts)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Split)) {
      return false;
    }
    Split other = (Split) object;
    return Objects.equals(this.amounts, other.amounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.amounts);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.holding.fungible.Split(%s)", this.amounts);
  }
}
