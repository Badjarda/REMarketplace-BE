package daml.daml.finance.holding.fungible;

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
import daml.daml.finance.interface$.holding.holding.Holding;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.daml.finance.interface$.util.disclosure.Disclosure;
import daml.daml.finance.interface$.util.lockable.Lock;
import daml.daml.finance.interface$.util.lockable.Lockable;
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
import java.util.Optional;

public final class Fungible extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0349f2f8bd17bedc616a1d4fb0f22c9b01ce39b41401f8a0f6cf77604e8c89f9", "Daml.Finance.Holding.Fungible", "Fungible");

  public static final Choice<Fungible, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Fungible> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.daml.finance.holding.fungible.Fungible", TEMPLATE_ID,
        ContractId::new, v -> Fungible.templateValueDecoder().decode(v), Fungible::fromJson,
        Contract::new, List.of(CHOICE_Archive));

  public final InstrumentKey instrument;

  public final AccountKey account;

  public final BigDecimal amount;

  public final Optional<Lock> lock;

  public final Map<String, Set<String>> observers;

  public Fungible(InstrumentKey instrument, AccountKey account, BigDecimal amount,
      Optional<Lock> lock, Map<String, Set<String>> observers) {
    this.instrument = instrument;
    this.account = account;
    this.amount = amount;
    this.lock = lock;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Fungible.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(InstrumentKey instrument, AccountKey account,
      BigDecimal amount, Optional<Lock> lock, Map<String, Set<String>> observers) {
    return new Fungible(instrument, account, amount, lock, observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Fungible> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Fungible fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Fungible> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(5);
    fields.add(new DamlRecord.Field("instrument", this.instrument.toValue()));
    fields.add(new DamlRecord.Field("account", this.account.toValue()));
    fields.add(new DamlRecord.Field("amount", new Numeric(this.amount)));
    fields.add(new DamlRecord.Field("lock", DamlOptional.of(this.lock.map(v$0 -> v$0.toValue()))));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Fungible> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0, recordValue$);
      InstrumentKey instrument = InstrumentKey.valueDecoder().decode(fields$.get(0).getValue());
      AccountKey account = AccountKey.valueDecoder().decode(fields$.get(1).getValue());
      BigDecimal amount = PrimitiveValueDecoders.fromNumeric.decode(fields$.get(2).getValue());
      Optional<Lock> lock = PrimitiveValueDecoders.fromOptional(Lock.valueDecoder())
          .decode(fields$.get(3).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(4).getValue());
      return new Fungible(instrument, account, amount, lock, observers);
    } ;
  }

  public static JsonLfDecoder<Fungible> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("instrument", "account", "amount", "lock", "observers"), name -> {
          switch (name) {
            case "instrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "account": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "amount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "lock": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.daml.finance.interface$.util.lockable.Lock.jsonDecoder()));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Fungible(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static Fungible fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("instrument", apply(InstrumentKey::jsonEncoder, instrument)),
        JsonLfEncoders.Field.of("account", apply(AccountKey::jsonEncoder, account)),
        JsonLfEncoders.Field.of("amount", apply(JsonLfEncoders::numeric, amount)),
        JsonLfEncoders.Field.of("lock", apply(JsonLfEncoders.optional(Lock::jsonEncoder), lock)),
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
    if (!(object instanceof Fungible)) {
      return false;
    }
    Fungible other = (Fungible) object;
    return Objects.equals(this.instrument, other.instrument) &&
        Objects.equals(this.account, other.account) && Objects.equals(this.amount, other.amount) &&
        Objects.equals(this.lock, other.lock) && Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.instrument, this.account, this.amount, this.lock, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.holding.fungible.Fungible(%s, %s, %s, %s, %s)",
        this.instrument, this.account, this.amount, this.lock, this.observers);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Fungible> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Fungible, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.holding.fungible.Fungible.ContractId toInterface(
        daml.daml.finance.interface$.holding.fungible.Fungible.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.holding.fungible.Fungible.ContractId(this.contractId);
    }

    public Lockable.ContractId toInterface(Lockable.INTERFACE_ interfaceCompanion) {
      return new Lockable.ContractId(this.contractId);
    }

    public Disclosure.ContractId toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.ContractId(this.contractId);
    }

    public Holding.ContractId toInterface(Holding.INTERFACE_ interfaceCompanion) {
      return new Holding.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.holding.fungible.Fungible.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Lockable.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Disclosure.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Holding.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Fungible> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Fungible> {
    public Contract(ContractId id, Fungible data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Fungible> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Fungible, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.holding.fungible.Fungible.CreateAnd toInterface(
        daml.daml.finance.interface$.holding.fungible.Fungible.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.holding.fungible.Fungible.CreateAnd(COMPANION, this.createArguments);
    }

    public Lockable.CreateAnd toInterface(Lockable.INTERFACE_ interfaceCompanion) {
      return new Lockable.CreateAnd(COMPANION, this.createArguments);
    }

    public Disclosure.CreateAnd toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.CreateAnd(COMPANION, this.createArguments);
    }

    public Holding.CreateAnd toInterface(Holding.INTERFACE_ interfaceCompanion) {
      return new Holding.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
