package daml.daml.finance.interface$.holding.factory;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Numeric;
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
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Create extends DamlRecord<Create> {
  public static final String _packageId = "1b3dd202f2b5f6e97f0cc3426598a0c6c4725d8885e9e91d14377dce3e451348";

  public final InstrumentKey instrument;

  public final AccountKey account;

  public final BigDecimal amount;

  public final Map<String, Set<String>> observers;

  public Create(InstrumentKey instrument, AccountKey account, BigDecimal amount,
      Map<String, Set<String>> observers) {
    this.instrument = instrument;
    this.account = account;
    this.amount = amount;
    this.observers = observers;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Create fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Create> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0,
          recordValue$);
      InstrumentKey instrument = InstrumentKey.valueDecoder().decode(fields$.get(0).getValue());
      AccountKey account = AccountKey.valueDecoder().decode(fields$.get(1).getValue());
      BigDecimal amount = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(2).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(3).getValue());
      return new Create(instrument, account, amount, observers);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(4);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("instrument", this.instrument.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("account", this.account.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("amount", new Numeric(this.amount)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observers", this.observers.entrySet()
        .stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Create> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("instrument", "account", "amount", "observers"), name -> {
          switch (name) {
            case "instrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "account": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "amount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Create(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static Create fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("instrument", apply(InstrumentKey::jsonEncoder, instrument)),
        JsonLfEncoders.Field.of("account", apply(AccountKey::jsonEncoder, account)),
        JsonLfEncoders.Field.of("amount", apply(JsonLfEncoders::numeric, amount)),
        JsonLfEncoders.Field.of("observers", apply(JsonLfEncoders.genMap(JsonLfEncoders::text, _x1 -> _x1.jsonEncoder(JsonLfEncoders::party)), observers)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Create)) {
      return false;
    }
    Create other = (Create) object;
    return Objects.equals(this.instrument, other.instrument) &&
        Objects.equals(this.account, other.account) && Objects.equals(this.amount, other.amount) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.instrument, this.account, this.amount, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.holding.factory.Create(%s, %s, %s, %s)",
        this.instrument, this.account, this.amount, this.observers);
  }
}
