package daml.daml.finance.interface$.lifecycle.effect;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Timestamp;
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
import daml.daml.finance.interface$.types.common.types.Quantity;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class View extends DamlRecord<View> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final Set<String> providers;

  public final InstrumentKey targetInstrument;

  public final Optional<InstrumentKey> producedInstrument;

  public final Id id;

  public final String description;

  public final Optional<Instant> settlementTime;

  public final List<Quantity<InstrumentKey, BigDecimal>> otherConsumed;

  public final List<Quantity<InstrumentKey, BigDecimal>> otherProduced;

  public View(Set<String> providers, InstrumentKey targetInstrument,
      Optional<InstrumentKey> producedInstrument, Id id, String description,
      Optional<Instant> settlementTime, List<Quantity<InstrumentKey, BigDecimal>> otherConsumed,
      List<Quantity<InstrumentKey, BigDecimal>> otherProduced) {
    this.providers = providers;
    this.targetInstrument = targetInstrument;
    this.producedInstrument = producedInstrument;
    this.id = id;
    this.description = description;
    this.settlementTime = settlementTime;
    this.otherConsumed = otherConsumed;
    this.otherProduced = otherProduced;
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
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(8,0,
          recordValue$);
      Set<String> providers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      InstrumentKey targetInstrument = InstrumentKey.valueDecoder()
          .decode(fields$.get(1).getValue());
      Optional<InstrumentKey> producedInstrument = PrimitiveValueDecoders.fromOptional(
            InstrumentKey.valueDecoder()).decode(fields$.get(2).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(3).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      Optional<Instant> settlementTime = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromTimestamp).decode(fields$.get(5).getValue());
      List<Quantity<InstrumentKey, BigDecimal>> otherConsumed = PrimitiveValueDecoders.fromList(
            Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
            java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
            PrimitiveValueDecoders.fromNumeric)).decode(fields$.get(6).getValue());
      List<Quantity<InstrumentKey, BigDecimal>> otherProduced = PrimitiveValueDecoders.fromList(
            Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
            java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
            PrimitiveValueDecoders.fromNumeric)).decode(fields$.get(7).getValue());
      return new View(providers, targetInstrument, producedInstrument, id, description,
          settlementTime, otherConsumed, otherProduced);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(8);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("providers", this.providers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("targetInstrument", this.targetInstrument.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("producedInstrument", DamlOptional.of(this.producedInstrument.map(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("settlementTime", DamlOptional.of(this.settlementTime.map(v$0 -> Timestamp.fromInstant(v$0)))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("otherConsumed", this.otherConsumed.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue(v$1 -> v$1.toValue(),
        v$2 -> new Numeric(v$2))))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("otherProduced", this.otherProduced.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue(v$1 -> v$1.toValue(),
        v$2 -> new Numeric(v$2))))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("providers", "targetInstrument", "producedInstrument", "id", "description", "settlementTime", "otherConsumed", "otherProduced"), name -> {
          switch (name) {
            case "providers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "targetInstrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "producedInstrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder()));
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "settlementTime": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp));
            case "otherConsumed": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10))));
            case "otherProduced": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10))));
            default: return null;
          }
        }
        , (Object[] args) -> new View(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7])));
  }

  public static View fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("providers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), providers)),
        JsonLfEncoders.Field.of("targetInstrument", apply(InstrumentKey::jsonEncoder, targetInstrument)),
        JsonLfEncoders.Field.of("producedInstrument", apply(JsonLfEncoders.optional(InstrumentKey::jsonEncoder), producedInstrument)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("settlementTime", apply(JsonLfEncoders.optional(JsonLfEncoders::timestamp), settlementTime)),
        JsonLfEncoders.Field.of("otherConsumed", apply(JsonLfEncoders.list(_x1 -> _x1.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric)), otherConsumed)),
        JsonLfEncoders.Field.of("otherProduced", apply(JsonLfEncoders.list(_x1 -> _x1.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric)), otherProduced)));
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
    return Objects.equals(this.providers, other.providers) &&
        Objects.equals(this.targetInstrument, other.targetInstrument) &&
        Objects.equals(this.producedInstrument, other.producedInstrument) &&
        Objects.equals(this.id, other.id) && Objects.equals(this.description, other.description) &&
        Objects.equals(this.settlementTime, other.settlementTime) &&
        Objects.equals(this.otherConsumed, other.otherConsumed) &&
        Objects.equals(this.otherProduced, other.otherProduced);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.providers, this.targetInstrument, this.producedInstrument, this.id,
        this.description, this.settlementTime, this.otherConsumed, this.otherProduced);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.effect.View(%s, %s, %s, %s, %s, %s, %s, %s)",
        this.providers, this.targetInstrument, this.producedInstrument, this.id, this.description,
        this.settlementTime, this.otherConsumed, this.otherProduced);
  }
}
