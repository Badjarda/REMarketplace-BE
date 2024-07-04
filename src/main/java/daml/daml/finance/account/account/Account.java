package daml.daml.finance.account.account;

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
import daml.daml.finance.interface$.account.account.Controllers;
import daml.daml.finance.interface$.types.common.types.HoldingFactoryKey;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.util.disclosure.Disclosure;
import daml.daml.finance.interface$.util.lockable.Lock;
import daml.daml.finance.interface$.util.lockable.Lockable;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class Account extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("24a2deca43fad2e0010e2b864ed3f652a223165c72b9dbc29121eafe245793ad", "Daml.Finance.Account.Account", "Account");

  public static final Choice<Account, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Account> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.daml.finance.account.account.Account", TEMPLATE_ID,
        ContractId::new, v -> Account.templateValueDecoder().decode(v), Account::fromJson,
        Contract::new, List.of(CHOICE_Archive));

  public final String custodian;

  public final String owner;

  public final Optional<Lock> lock;

  public final Controllers controllers;

  public final Id id;

  public final String description;

  public final HoldingFactoryKey holdingFactory;

  public final Map<String, Set<String>> observers;

  public Account(String custodian, String owner, Optional<Lock> lock, Controllers controllers,
      Id id, String description, HoldingFactoryKey holdingFactory,
      Map<String, Set<String>> observers) {
    this.custodian = custodian;
    this.owner = owner;
    this.lock = lock;
    this.controllers = controllers;
    this.id = id;
    this.description = description;
    this.holdingFactory = holdingFactory;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Account.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(String custodian, String owner,
      Optional<Lock> lock, Controllers controllers, Id id, String description,
      HoldingFactoryKey holdingFactory, Map<String, Set<String>> observers) {
    return new Account(custodian, owner, lock, controllers, id, description, holdingFactory,
        observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Account> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Account fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Account> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(8);
    fields.add(new DamlRecord.Field("custodian", new Party(this.custodian)));
    fields.add(new DamlRecord.Field("owner", new Party(this.owner)));
    fields.add(new DamlRecord.Field("lock", DamlOptional.of(this.lock.map(v$0 -> v$0.toValue()))));
    fields.add(new DamlRecord.Field("controllers", this.controllers.toValue()));
    fields.add(new DamlRecord.Field("id", this.id.toValue()));
    fields.add(new DamlRecord.Field("description", new Text(this.description)));
    fields.add(new DamlRecord.Field("holdingFactory", this.holdingFactory.toValue()));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Account> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(8,0, recordValue$);
      String custodian = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String owner = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Optional<Lock> lock = PrimitiveValueDecoders.fromOptional(Lock.valueDecoder())
          .decode(fields$.get(2).getValue());
      Controllers controllers = Controllers.valueDecoder().decode(fields$.get(3).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(4).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      HoldingFactoryKey holdingFactory = HoldingFactoryKey.valueDecoder()
          .decode(fields$.get(6).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(7).getValue());
      return new Account(custodian, owner, lock, controllers, id, description, holdingFactory,
          observers);
    } ;
  }

  public static JsonLfDecoder<Account> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("custodian", "owner", "lock", "controllers", "id", "description", "holdingFactory", "observers"), name -> {
          switch (name) {
            case "custodian": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "owner": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "lock": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.daml.finance.interface$.util.lockable.Lock.jsonDecoder()));
            case "controllers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.account.account.Controllers.jsonDecoder());
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "holdingFactory": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, daml.daml.finance.interface$.types.common.types.HoldingFactoryKey.jsonDecoder());
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Account(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7])));
  }

  public static Account fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("custodian", apply(JsonLfEncoders::party, custodian)),
        JsonLfEncoders.Field.of("owner", apply(JsonLfEncoders::party, owner)),
        JsonLfEncoders.Field.of("lock", apply(JsonLfEncoders.optional(Lock::jsonEncoder), lock)),
        JsonLfEncoders.Field.of("controllers", apply(Controllers::jsonEncoder, controllers)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("holdingFactory", apply(HoldingFactoryKey::jsonEncoder, holdingFactory)),
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
    if (!(object instanceof Account)) {
      return false;
    }
    Account other = (Account) object;
    return Objects.equals(this.custodian, other.custodian) &&
        Objects.equals(this.owner, other.owner) && Objects.equals(this.lock, other.lock) &&
        Objects.equals(this.controllers, other.controllers) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.holdingFactory, other.holdingFactory) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.custodian, this.owner, this.lock, this.controllers, this.id,
        this.description, this.holdingFactory, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.account.account.Account(%s, %s, %s, %s, %s, %s, %s, %s)",
        this.custodian, this.owner, this.lock, this.controllers, this.id, this.description,
        this.holdingFactory, this.observers);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Account> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Account, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public Lockable.ContractId toInterface(Lockable.INTERFACE_ interfaceCompanion) {
      return new Lockable.ContractId(this.contractId);
    }

    public Disclosure.ContractId toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.ContractId(this.contractId);
    }

    public daml.daml.finance.interface$.account.account.Account.ContractId toInterface(
        daml.daml.finance.interface$.account.account.Account.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.account.account.Account.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(Lockable.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Disclosure.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.account.account.Account.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Account> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Account> {
    public Contract(ContractId id, Account data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Account> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Account, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public Lockable.CreateAnd toInterface(Lockable.INTERFACE_ interfaceCompanion) {
      return new Lockable.CreateAnd(COMPANION, this.createArguments);
    }

    public Disclosure.CreateAnd toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.CreateAnd(COMPANION, this.createArguments);
    }

    public daml.daml.finance.interface$.account.account.Account.CreateAnd toInterface(
        daml.daml.finance.interface$.account.account.Account.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.account.account.Account.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
