package daml.daml.finance.instrument.token.instrument;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
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
import daml.daml.finance.interface$.types.common.types.HoldingStandard;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.util.disclosure.Disclosure;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class Instrument extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("82633b0841153f2965240f464315973d493dce7f4b721167137b004c8ff5e4cf", "Daml.Finance.Instrument.Token.Instrument", "Instrument");

  public static final Choice<Instrument, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Instrument> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.daml.finance.instrument.token.instrument.Instrument",
        TEMPLATE_ID, ContractId::new, v -> Instrument.templateValueDecoder().decode(v),
        Instrument::fromJson, Contract::new, List.of(CHOICE_Archive));

  public final String depository;

  public final String issuer;

  public final Id id;

  public final String version;

  public final HoldingStandard holdingStandard;

  public final String description;

  public final Instant validAsOf;

  public final Map<String, Set<String>> observers;

  public Instrument(String depository, String issuer, Id id, String version,
      HoldingStandard holdingStandard, String description, Instant validAsOf,
      Map<String, Set<String>> observers) {
    this.depository = depository;
    this.issuer = issuer;
    this.id = id;
    this.version = version;
    this.holdingStandard = holdingStandard;
    this.description = description;
    this.validAsOf = validAsOf;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Instrument.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(String depository, String issuer, Id id,
      String version, HoldingStandard holdingStandard, String description, Instant validAsOf,
      Map<String, Set<String>> observers) {
    return new Instrument(depository, issuer, id, version, holdingStandard, description, validAsOf,
        observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Instrument> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Instrument fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Instrument> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(8);
    fields.add(new DamlRecord.Field("depository", new Party(this.depository)));
    fields.add(new DamlRecord.Field("issuer", new Party(this.issuer)));
    fields.add(new DamlRecord.Field("id", this.id.toValue()));
    fields.add(new DamlRecord.Field("version", new Text(this.version)));
    fields.add(new DamlRecord.Field("holdingStandard", this.holdingStandard.toValue()));
    fields.add(new DamlRecord.Field("description", new Text(this.description)));
    fields.add(new DamlRecord.Field("validAsOf", Timestamp.fromInstant(this.validAsOf)));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Instrument> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(8,0, recordValue$);
      String depository = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String issuer = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(2).getValue());
      String version = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      HoldingStandard holdingStandard = HoldingStandard.valueDecoder()
          .decode(fields$.get(4).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      Instant validAsOf = PrimitiveValueDecoders.fromTimestamp.decode(fields$.get(6).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(7).getValue());
      return new Instrument(depository, issuer, id, version, holdingStandard, description,
          validAsOf, observers);
    } ;
  }

  public static JsonLfDecoder<Instrument> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("depository", "issuer", "id", "version", "holdingStandard", "description", "validAsOf", "observers"), name -> {
          switch (name) {
            case "depository": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "issuer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "version": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "holdingStandard": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.HoldingStandard.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "validAsOf": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp);
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Instrument(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7])));
  }

  public static Instrument fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("depository", apply(JsonLfEncoders::party, depository)),
        JsonLfEncoders.Field.of("issuer", apply(JsonLfEncoders::party, issuer)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("version", apply(JsonLfEncoders::text, version)),
        JsonLfEncoders.Field.of("holdingStandard", apply(HoldingStandard::jsonEncoder, holdingStandard)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("validAsOf", apply(JsonLfEncoders::timestamp, validAsOf)),
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
    if (!(object instanceof Instrument)) {
      return false;
    }
    Instrument other = (Instrument) object;
    return Objects.equals(this.depository, other.depository) &&
        Objects.equals(this.issuer, other.issuer) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.version, other.version) &&
        Objects.equals(this.holdingStandard, other.holdingStandard) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.validAsOf, other.validAsOf) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.depository, this.issuer, this.id, this.version, this.holdingStandard,
        this.description, this.validAsOf, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.instrument.token.instrument.Instrument(%s, %s, %s, %s, %s, %s, %s, %s)",
        this.depository, this.issuer, this.id, this.version, this.holdingStandard, this.description,
        this.validAsOf, this.observers);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Instrument> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Instrument, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.instrument.token.instrument.Instrument.ContractId toInterface(
        daml.daml.finance.interface$.instrument.token.instrument.Instrument.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.instrument.token.instrument.Instrument.ContractId(this.contractId);
    }

    public Disclosure.ContractId toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.ContractId(this.contractId);
    }

    public daml.daml.finance.interface$.instrument.base.instrument.Instrument.ContractId toInterface(
        daml.daml.finance.interface$.instrument.base.instrument.Instrument.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.instrument.base.instrument.Instrument.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.instrument.token.instrument.Instrument.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Disclosure.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.instrument.base.instrument.Instrument.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Instrument> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Instrument> {
    public Contract(ContractId id, Instrument data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Instrument> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Instrument, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.instrument.token.instrument.Instrument.CreateAnd toInterface(
        daml.daml.finance.interface$.instrument.token.instrument.Instrument.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.instrument.token.instrument.Instrument.CreateAnd(COMPANION, this.createArguments);
    }

    public Disclosure.CreateAnd toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.CreateAnd(COMPANION, this.createArguments);
    }

    public daml.daml.finance.interface$.instrument.base.instrument.Instrument.CreateAnd toInterface(
        daml.daml.finance.interface$.instrument.base.instrument.Instrument.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.instrument.base.instrument.Instrument.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
