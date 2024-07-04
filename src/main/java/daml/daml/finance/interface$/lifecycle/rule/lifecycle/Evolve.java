package daml.daml.finance.interface$.lifecycle.rule.lifecycle;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.daml.finance.interface$.lifecycle.event.Event;
import daml.daml.finance.interface$.lifecycle.observable.numericobservable.NumericObservable;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Evolve extends DamlRecord<Evolve> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final Event.ContractId eventCid;

  public final InstrumentKey instrument;

  public final List<NumericObservable.ContractId> observableCids;

  public Evolve(Event.ContractId eventCid, InstrumentKey instrument,
      List<NumericObservable.ContractId> observableCids) {
    this.eventCid = eventCid;
    this.instrument = instrument;
    this.observableCids = observableCids;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Evolve fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Evolve> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      Event.ContractId eventCid =
          new Event.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected eventCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      InstrumentKey instrument = InstrumentKey.valueDecoder().decode(fields$.get(1).getValue());
      List<NumericObservable.ContractId> observableCids = PrimitiveValueDecoders.fromList(v$0 ->
              new NumericObservable.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected observableCids to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
          .decode(fields$.get(2).getValue());
      return new Evolve(eventCid, instrument, observableCids);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("eventCid", this.eventCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("instrument", this.instrument.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observableCids", this.observableCids.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Evolve> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("eventCid", "instrument", "observableCids"), name -> {
          switch (name) {
            case "eventCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.lifecycle.event.Event.ContractId::new));
            case "instrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "observableCids": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.lifecycle.observable.numericobservable.NumericObservable.ContractId::new)));
            default: return null;
          }
        }
        , (Object[] args) -> new Evolve(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static Evolve fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("eventCid", apply(JsonLfEncoders::contractId, eventCid)),
        JsonLfEncoders.Field.of("instrument", apply(InstrumentKey::jsonEncoder, instrument)),
        JsonLfEncoders.Field.of("observableCids", apply(JsonLfEncoders.list(JsonLfEncoders::contractId), observableCids)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Evolve)) {
      return false;
    }
    Evolve other = (Evolve) object;
    return Objects.equals(this.eventCid, other.eventCid) &&
        Objects.equals(this.instrument, other.instrument) &&
        Objects.equals(this.observableCids, other.observableCids);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.eventCid, this.instrument, this.observableCids);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.rule.lifecycle.Evolve(%s, %s, %s)",
        this.eventCid, this.instrument, this.observableCids);
  }
}
