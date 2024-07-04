package daml.daml.finance.lifecycle.effect;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlOptional;
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
import daml.daml.finance.interface$.util.disclosure.Disclosure;
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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class Effect extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("26b39500d110bf1f69fc9d84e2ec281dd9a62fbdf35369e7321d5b30ccc46a97", "Daml.Finance.Lifecycle.Effect", "Effect");

  public static final Choice<Effect, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Effect> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.daml.finance.lifecycle.effect.Effect", TEMPLATE_ID,
        ContractId::new, v -> Effect.templateValueDecoder().decode(v), Effect::fromJson,
        Contract::new, List.of(CHOICE_Archive));

  public final Set<String> providers;

  public final Id id;

  public final String description;

  public final InstrumentKey targetInstrument;

  public final Optional<InstrumentKey> producedInstrument;

  public final List<Quantity<InstrumentKey, BigDecimal>> otherConsumed;

  public final List<Quantity<InstrumentKey, BigDecimal>> otherProduced;

  public final Optional<Instant> settlementTime;

  public final Map<String, Set<String>> observers;

  public Effect(Set<String> providers, Id id, String description, InstrumentKey targetInstrument,
      Optional<InstrumentKey> producedInstrument,
      List<Quantity<InstrumentKey, BigDecimal>> otherConsumed,
      List<Quantity<InstrumentKey, BigDecimal>> otherProduced, Optional<Instant> settlementTime,
      Map<String, Set<String>> observers) {
    this.providers = providers;
    this.id = id;
    this.description = description;
    this.targetInstrument = targetInstrument;
    this.producedInstrument = producedInstrument;
    this.otherConsumed = otherConsumed;
    this.otherProduced = otherProduced;
    this.settlementTime = settlementTime;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Effect.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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
      InstrumentKey targetInstrument, Optional<InstrumentKey> producedInstrument,
      List<Quantity<InstrumentKey, BigDecimal>> otherConsumed,
      List<Quantity<InstrumentKey, BigDecimal>> otherProduced, Optional<Instant> settlementTime,
      Map<String, Set<String>> observers) {
    return new Effect(providers, id, description, targetInstrument, producedInstrument,
        otherConsumed, otherProduced, settlementTime, observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Effect> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Effect fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Effect> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(9);
    fields.add(new DamlRecord.Field("providers", this.providers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("id", this.id.toValue()));
    fields.add(new DamlRecord.Field("description", new Text(this.description)));
    fields.add(new DamlRecord.Field("targetInstrument", this.targetInstrument.toValue()));
    fields.add(new DamlRecord.Field("producedInstrument", DamlOptional.of(this.producedInstrument.map(v$0 -> v$0.toValue()))));
    fields.add(new DamlRecord.Field("otherConsumed", this.otherConsumed.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue(v$1 -> v$1.toValue(),
        v$2 -> new Numeric(v$2))))));
    fields.add(new DamlRecord.Field("otherProduced", this.otherProduced.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue(v$1 -> v$1.toValue(),
        v$2 -> new Numeric(v$2))))));
    fields.add(new DamlRecord.Field("settlementTime", DamlOptional.of(this.settlementTime.map(v$0 -> Timestamp.fromInstant(v$0)))));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Effect> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(9,0, recordValue$);
      Set<String> providers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(1).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(2).getValue());
      InstrumentKey targetInstrument = InstrumentKey.valueDecoder()
          .decode(fields$.get(3).getValue());
      Optional<InstrumentKey> producedInstrument = PrimitiveValueDecoders.fromOptional(
            InstrumentKey.valueDecoder()).decode(fields$.get(4).getValue());
      List<Quantity<InstrumentKey, BigDecimal>> otherConsumed = PrimitiveValueDecoders.fromList(
            Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
            java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
            PrimitiveValueDecoders.fromNumeric)).decode(fields$.get(5).getValue());
      List<Quantity<InstrumentKey, BigDecimal>> otherProduced = PrimitiveValueDecoders.fromList(
            Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
            java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
            PrimitiveValueDecoders.fromNumeric)).decode(fields$.get(6).getValue());
      Optional<Instant> settlementTime = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromTimestamp).decode(fields$.get(7).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(8).getValue());
      return new Effect(providers, id, description, targetInstrument, producedInstrument,
          otherConsumed, otherProduced, settlementTime, observers);
    } ;
  }

  public static JsonLfDecoder<Effect> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("providers", "id", "description", "targetInstrument", "producedInstrument", "otherConsumed", "otherProduced", "settlementTime", "observers"), name -> {
          switch (name) {
            case "providers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "targetInstrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "producedInstrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder()));
            case "otherConsumed": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10))));
            case "otherProduced": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10))));
            case "settlementTime": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Effect(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8])));
  }

  public static Effect fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("providers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), providers)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("targetInstrument", apply(InstrumentKey::jsonEncoder, targetInstrument)),
        JsonLfEncoders.Field.of("producedInstrument", apply(JsonLfEncoders.optional(InstrumentKey::jsonEncoder), producedInstrument)),
        JsonLfEncoders.Field.of("otherConsumed", apply(JsonLfEncoders.list(_x1 -> _x1.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric)), otherConsumed)),
        JsonLfEncoders.Field.of("otherProduced", apply(JsonLfEncoders.list(_x1 -> _x1.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric)), otherProduced)),
        JsonLfEncoders.Field.of("settlementTime", apply(JsonLfEncoders.optional(JsonLfEncoders::timestamp), settlementTime)),
        JsonLfEncoders.Field.of("observers", apply(JsonLfEncoders.genMap(JsonLfEncoders::text, _x1 -> _x1.jsonEncoder(JsonLfEncoders::party)), observers)));
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
    if (!(object instanceof Effect)) {
      return false;
    }
    Effect other = (Effect) object;
    return Objects.equals(this.providers, other.providers) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.targetInstrument, other.targetInstrument) &&
        Objects.equals(this.producedInstrument, other.producedInstrument) &&
        Objects.equals(this.otherConsumed, other.otherConsumed) &&
        Objects.equals(this.otherProduced, other.otherProduced) &&
        Objects.equals(this.settlementTime, other.settlementTime) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.providers, this.id, this.description, this.targetInstrument,
        this.producedInstrument, this.otherConsumed, this.otherProduced, this.settlementTime,
        this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.lifecycle.effect.Effect(%s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.providers, this.id, this.description, this.targetInstrument, this.producedInstrument,
        this.otherConsumed, this.otherProduced, this.settlementTime, this.observers);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Effect> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Effect, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public Disclosure.ContractId toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.ContractId(this.contractId);
    }

    public daml.daml.finance.interface$.lifecycle.effect.Effect.ContractId toInterface(
        daml.daml.finance.interface$.lifecycle.effect.Effect.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.lifecycle.effect.Effect.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(Disclosure.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.lifecycle.effect.Effect.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Effect> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Effect> {
    public Contract(ContractId id, Effect data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Effect> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Effect, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public Disclosure.CreateAnd toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.CreateAnd(COMPANION, this.createArguments);
    }

    public daml.daml.finance.interface$.lifecycle.effect.Effect.CreateAnd toInterface(
        daml.daml.finance.interface$.lifecycle.effect.Effect.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.lifecycle.effect.Effect.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
