package daml.daml.finance.lifecycle.election;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
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
import daml.daml.finance.interface$.lifecycle.event.Event;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.daml.finance.interface$.util.disclosure.Disclosure;
import java.lang.Boolean;
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

public final class Election extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("26b39500d110bf1f69fc9d84e2ec281dd9a62fbdf35369e7321d5b30ccc46a97", "Daml.Finance.Lifecycle.Election", "Election");

  public static final Choice<Election, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Election> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.daml.finance.lifecycle.election.Election",
        TEMPLATE_ID, ContractId::new, v -> Election.templateValueDecoder().decode(v),
        Election::fromJson, Contract::new, List.of(CHOICE_Archive));

  public final String elector;

  public final String counterparty;

  public final String provider;

  public final Id id;

  public final String description;

  public final InstrumentKey instrument;

  public final BigDecimal amount;

  public final String claim;

  public final Boolean electorIsOwner;

  public final Instant electionTime;

  public final Map<String, Set<String>> observers;

  public Election(String elector, String counterparty, String provider, Id id, String description,
      InstrumentKey instrument, BigDecimal amount, String claim, Boolean electorIsOwner,
      Instant electionTime, Map<String, Set<String>> observers) {
    this.elector = elector;
    this.counterparty = counterparty;
    this.provider = provider;
    this.id = id;
    this.description = description;
    this.instrument = instrument;
    this.amount = amount;
    this.claim = claim;
    this.electorIsOwner = electorIsOwner;
    this.electionTime = electionTime;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Election.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(String elector, String counterparty,
      String provider, Id id, String description, InstrumentKey instrument, BigDecimal amount,
      String claim, Boolean electorIsOwner, Instant electionTime,
      Map<String, Set<String>> observers) {
    return new Election(elector, counterparty, provider, id, description, instrument, amount, claim,
        electorIsOwner, electionTime, observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Election> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Election fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Election> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(11);
    fields.add(new DamlRecord.Field("elector", new Party(this.elector)));
    fields.add(new DamlRecord.Field("counterparty", new Party(this.counterparty)));
    fields.add(new DamlRecord.Field("provider", new Party(this.provider)));
    fields.add(new DamlRecord.Field("id", this.id.toValue()));
    fields.add(new DamlRecord.Field("description", new Text(this.description)));
    fields.add(new DamlRecord.Field("instrument", this.instrument.toValue()));
    fields.add(new DamlRecord.Field("amount", new Numeric(this.amount)));
    fields.add(new DamlRecord.Field("claim", new Text(this.claim)));
    fields.add(new DamlRecord.Field("electorIsOwner", Bool.of(this.electorIsOwner)));
    fields.add(new DamlRecord.Field("electionTime", Timestamp.fromInstant(this.electionTime)));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Election> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(11,0, recordValue$);
      String elector = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String counterparty = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      String provider = PrimitiveValueDecoders.fromParty.decode(fields$.get(2).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(3).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      InstrumentKey instrument = InstrumentKey.valueDecoder().decode(fields$.get(5).getValue());
      BigDecimal amount = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(6).getValue());
      String claim = PrimitiveValueDecoders.fromText.decode(fields$.get(7).getValue());
      Boolean electorIsOwner = PrimitiveValueDecoders.fromBool.decode(fields$.get(8).getValue());
      Instant electionTime = PrimitiveValueDecoders.fromTimestamp.decode(fields$.get(9).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(10).getValue());
      return new Election(elector, counterparty, provider, id, description, instrument, amount,
          claim, electorIsOwner, electionTime, observers);
    } ;
  }

  public static JsonLfDecoder<Election> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("elector", "counterparty", "provider", "id", "description", "instrument", "amount", "claim", "electorIsOwner", "electionTime", "observers"), name -> {
          switch (name) {
            case "elector": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "counterparty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "provider": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "instrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "amount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "claim": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "electorIsOwner": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            case "electionTime": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp);
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Election(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10])));
  }

  public static Election fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("elector", apply(JsonLfEncoders::party, elector)),
        JsonLfEncoders.Field.of("counterparty", apply(JsonLfEncoders::party, counterparty)),
        JsonLfEncoders.Field.of("provider", apply(JsonLfEncoders::party, provider)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("instrument", apply(InstrumentKey::jsonEncoder, instrument)),
        JsonLfEncoders.Field.of("amount", apply(JsonLfEncoders::numeric, amount)),
        JsonLfEncoders.Field.of("claim", apply(JsonLfEncoders::text, claim)),
        JsonLfEncoders.Field.of("electorIsOwner", apply(JsonLfEncoders::bool, electorIsOwner)),
        JsonLfEncoders.Field.of("electionTime", apply(JsonLfEncoders::timestamp, electionTime)),
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
    if (!(object instanceof Election)) {
      return false;
    }
    Election other = (Election) object;
    return Objects.equals(this.elector, other.elector) &&
        Objects.equals(this.counterparty, other.counterparty) &&
        Objects.equals(this.provider, other.provider) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.instrument, other.instrument) &&
        Objects.equals(this.amount, other.amount) && Objects.equals(this.claim, other.claim) &&
        Objects.equals(this.electorIsOwner, other.electorIsOwner) &&
        Objects.equals(this.electionTime, other.electionTime) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.elector, this.counterparty, this.provider, this.id, this.description,
        this.instrument, this.amount, this.claim, this.electorIsOwner, this.electionTime,
        this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.lifecycle.election.Election(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.elector, this.counterparty, this.provider, this.id, this.description, this.instrument,
        this.amount, this.claim, this.electorIsOwner, this.electionTime, this.observers);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Election> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Election, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public Event.ContractId toInterface(Event.INTERFACE_ interfaceCompanion) {
      return new Event.ContractId(this.contractId);
    }

    public daml.daml.finance.interface$.lifecycle.election.Election.ContractId toInterface(
        daml.daml.finance.interface$.lifecycle.election.Election.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.lifecycle.election.Election.ContractId(this.contractId);
    }

    public Disclosure.ContractId toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(Event.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.lifecycle.election.Election.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Disclosure.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Election> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Election> {
    public Contract(ContractId id, Election data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Election> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Election, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public Event.CreateAnd toInterface(Event.INTERFACE_ interfaceCompanion) {
      return new Event.CreateAnd(COMPANION, this.createArguments);
    }

    public daml.daml.finance.interface$.lifecycle.election.Election.CreateAnd toInterface(
        daml.daml.finance.interface$.lifecycle.election.Election.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.lifecycle.election.Election.CreateAnd(COMPANION, this.createArguments);
    }

    public Disclosure.CreateAnd toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
