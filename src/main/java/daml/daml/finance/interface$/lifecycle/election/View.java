package daml.daml.finance.interface$.lifecycle.election;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
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
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import java.lang.Boolean;
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

public class View extends DamlRecord<View> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final Id id;

  public final String description;

  public final String claim;

  public final String elector;

  public final String counterparty;

  public final Boolean electorIsOwner;

  public final Map<String, Set<String>> observers;

  public final BigDecimal amount;

  public final String provider;

  public final InstrumentKey instrument;

  public View(Id id, String description, String claim, String elector, String counterparty,
      Boolean electorIsOwner, Map<String, Set<String>> observers, BigDecimal amount,
      String provider, InstrumentKey instrument) {
    this.id = id;
    this.description = description;
    this.claim = claim;
    this.elector = elector;
    this.counterparty = counterparty;
    this.electorIsOwner = electorIsOwner;
    this.observers = observers;
    this.amount = amount;
    this.provider = provider;
    this.instrument = instrument;
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
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(10,0,
          recordValue$);
      Id id = Id.valueDecoder().decode(fields$.get(0).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(1).getValue());
      String claim = PrimitiveValueDecoders.fromText.decode(fields$.get(2).getValue());
      String elector = PrimitiveValueDecoders.fromParty.decode(fields$.get(3).getValue());
      String counterparty = PrimitiveValueDecoders.fromParty.decode(fields$.get(4).getValue());
      Boolean electorIsOwner = PrimitiveValueDecoders.fromBool.decode(fields$.get(5).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(6).getValue());
      BigDecimal amount = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(7).getValue());
      String provider = PrimitiveValueDecoders.fromParty.decode(fields$.get(8).getValue());
      InstrumentKey instrument = InstrumentKey.valueDecoder().decode(fields$.get(9).getValue());
      return new View(id, description, claim, elector, counterparty, electorIsOwner, observers,
          amount, provider, instrument);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(10);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("claim", new Text(this.claim)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("elector", new Party(this.elector)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("counterparty", new Party(this.counterparty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("electorIsOwner", Bool.of(this.electorIsOwner)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observers", this.observers.entrySet()
        .stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("amount", new Numeric(this.amount)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("provider", new Party(this.provider)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("instrument", this.instrument.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("id", "description", "claim", "elector", "counterparty", "electorIsOwner", "observers", "amount", "provider", "instrument"), name -> {
          switch (name) {
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "claim": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "elector": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "counterparty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "electorIsOwner": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            case "amount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "provider": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "instrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new View(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9])));
  }

  public static View fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("claim", apply(JsonLfEncoders::text, claim)),
        JsonLfEncoders.Field.of("elector", apply(JsonLfEncoders::party, elector)),
        JsonLfEncoders.Field.of("counterparty", apply(JsonLfEncoders::party, counterparty)),
        JsonLfEncoders.Field.of("electorIsOwner", apply(JsonLfEncoders::bool, electorIsOwner)),
        JsonLfEncoders.Field.of("observers", apply(JsonLfEncoders.genMap(JsonLfEncoders::text, _x1 -> _x1.jsonEncoder(JsonLfEncoders::party)), observers)),
        JsonLfEncoders.Field.of("amount", apply(JsonLfEncoders::numeric, amount)),
        JsonLfEncoders.Field.of("provider", apply(JsonLfEncoders::party, provider)),
        JsonLfEncoders.Field.of("instrument", apply(InstrumentKey::jsonEncoder, instrument)));
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
    return Objects.equals(this.id, other.id) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.claim, other.claim) && Objects.equals(this.elector, other.elector) &&
        Objects.equals(this.counterparty, other.counterparty) &&
        Objects.equals(this.electorIsOwner, other.electorIsOwner) &&
        Objects.equals(this.observers, other.observers) &&
        Objects.equals(this.amount, other.amount) &&
        Objects.equals(this.provider, other.provider) &&
        Objects.equals(this.instrument, other.instrument);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.description, this.claim, this.elector, this.counterparty,
        this.electorIsOwner, this.observers, this.amount, this.provider, this.instrument);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.election.View(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.id, this.description, this.claim, this.elector, this.counterparty, this.electorIsOwner,
        this.observers, this.amount, this.provider, this.instrument);
  }
}
