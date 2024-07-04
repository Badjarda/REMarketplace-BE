package daml.daml.finance.lifecycle.event.distribution;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Timestamp;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.Choice;
import com.daml.ledger.javaapi.data.codegen.ContractCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractTypeCompanion;
import com.daml.ledger.javaapi.data.codegen.Created;
import com.daml.ledger.javaapi.data.codegen.Exercised;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.Update;
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

public final class Event extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("26b39500d110bf1f69fc9d84e2ec281dd9a62fbdf35369e7321d5b30ccc46a97", "Daml.Finance.Lifecycle.Event.Distribution", "Event");

  public static final Choice<Event, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Event> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.daml.finance.lifecycle.event.distribution.Event",
        TEMPLATE_ID, ContractId::new, v -> Event.templateValueDecoder().decode(v), Event::fromJson,
        Contract::new, List.of(CHOICE_Archive));

  public final Set<String> providers;

  public final Id id;

  public final String description;

  public final Instant effectiveTime;

  public final InstrumentKey targetInstrument;

  public final InstrumentKey newInstrument;

  public final List<Quantity<InstrumentKey, BigDecimal>> perUnitDistribution;

  public final Set<String> observers;

  public Event(Set<String> providers, Id id, String description, Instant effectiveTime,
      InstrumentKey targetInstrument, InstrumentKey newInstrument,
      List<Quantity<InstrumentKey, BigDecimal>> perUnitDistribution, Set<String> observers) {
    this.providers = providers;
    this.id = id;
    this.description = description;
    this.effectiveTime = effectiveTime;
    this.targetInstrument = targetInstrument;
    this.newInstrument = newInstrument;
    this.perUnitDistribution = perUnitDistribution;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Event.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive(daml.da.internal.template.Archive arg) {
    return createAnd().exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive() {
    return createAndExerciseArchive(new daml.da.internal.template.Archive());
  }

  public static Update<Created<ContractId>> create(Set<String> providers, Id id, String description,
      Instant effectiveTime, InstrumentKey targetInstrument, InstrumentKey newInstrument,
      List<Quantity<InstrumentKey, BigDecimal>> perUnitDistribution, Set<String> observers) {
    return new Event(providers, id, description, effectiveTime, targetInstrument, newInstrument,
        perUnitDistribution, observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Event> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Event fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Event> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(8);
    fields.add(new DamlRecord.Field("providers", this.providers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("id", this.id.toValue()));
    fields.add(new DamlRecord.Field("description", new Text(this.description)));
    fields.add(new DamlRecord.Field("effectiveTime", Timestamp.fromInstant(this.effectiveTime)));
    fields.add(new DamlRecord.Field("targetInstrument", this.targetInstrument.toValue()));
    fields.add(new DamlRecord.Field("newInstrument", this.newInstrument.toValue()));
    fields.add(new DamlRecord.Field("perUnitDistribution", this.perUnitDistribution.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue(v$1 -> v$1.toValue(),
        v$2 -> new Numeric(v$2))))));
    fields.add(new DamlRecord.Field("observers", this.observers.toValue(v$0 -> new Party(v$0))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Event> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(8,0, recordValue$);
      Set<String> providers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(1).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(2).getValue());
      Instant effectiveTime = PrimitiveValueDecoders.fromTimestamp
          .decode(fields$.get(3).getValue());
      InstrumentKey targetInstrument = InstrumentKey.valueDecoder()
          .decode(fields$.get(4).getValue());
      InstrumentKey newInstrument = InstrumentKey.valueDecoder().decode(fields$.get(5).getValue());
      List<Quantity<InstrumentKey, BigDecimal>> perUnitDistribution =
          PrimitiveValueDecoders.fromList(
            Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
            java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
            PrimitiveValueDecoders.fromNumeric)).decode(fields$.get(6).getValue());
      Set<String> observers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(7).getValue());
      return new Event(providers, id, description, effectiveTime, targetInstrument, newInstrument,
          perUnitDistribution, observers);
    } ;
  }

  public static JsonLfDecoder<Event> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("providers", "id", "description", "effectiveTime", "targetInstrument", "newInstrument", "perUnitDistribution", "observers"), name -> {
          switch (name) {
            case "providers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "effectiveTime": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp);
            case "targetInstrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "newInstrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "perUnitDistribution": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10))));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            default: return null;
          }
        }
        , (Object[] args) -> new Event(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7])));
  }

  public static Event fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("providers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), providers)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("effectiveTime", apply(JsonLfEncoders::timestamp, effectiveTime)),
        JsonLfEncoders.Field.of("targetInstrument", apply(InstrumentKey::jsonEncoder, targetInstrument)),
        JsonLfEncoders.Field.of("newInstrument", apply(InstrumentKey::jsonEncoder, newInstrument)),
        JsonLfEncoders.Field.of("perUnitDistribution", apply(JsonLfEncoders.list(_x1 -> _x1.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric)), perUnitDistribution)),
        JsonLfEncoders.Field.of("observers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), observers)));
  }

  public static ContractFilter<Contract> contractFilter() {
    return ContractFilter.of(COMPANION);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Event)) {
      return false;
    }
    Event other = (Event) object;
    return Objects.equals(this.providers, other.providers) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.effectiveTime, other.effectiveTime) &&
        Objects.equals(this.targetInstrument, other.targetInstrument) &&
        Objects.equals(this.newInstrument, other.newInstrument) &&
        Objects.equals(this.perUnitDistribution, other.perUnitDistribution) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.providers, this.id, this.description, this.effectiveTime,
        this.targetInstrument, this.newInstrument, this.perUnitDistribution, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.lifecycle.event.distribution.Event(%s, %s, %s, %s, %s, %s, %s, %s)",
        this.providers, this.id, this.description, this.effectiveTime, this.targetInstrument,
        this.newInstrument, this.perUnitDistribution, this.observers);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Event> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Event, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.lifecycle.event.distribution.Event.ContractId toInterface(
        daml.daml.finance.interface$.lifecycle.event.distribution.Event.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.lifecycle.event.distribution.Event.ContractId(this.contractId);
    }

    public daml.daml.finance.interface$.lifecycle.event.Event.ContractId toInterface(
        daml.daml.finance.interface$.lifecycle.event.Event.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.lifecycle.event.Event.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.lifecycle.event.distribution.Event.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.lifecycle.event.Event.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Event> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Event> {
    public Contract(ContractId id, Event data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Event> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, signatories, observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Event, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.lifecycle.event.distribution.Event.CreateAnd toInterface(
        daml.daml.finance.interface$.lifecycle.event.distribution.Event.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.lifecycle.event.distribution.Event.CreateAnd(COMPANION, this.createArguments);
    }

    public daml.daml.finance.interface$.lifecycle.event.Event.CreateAnd toInterface(
        daml.daml.finance.interface$.lifecycle.event.Event.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.lifecycle.event.Event.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
