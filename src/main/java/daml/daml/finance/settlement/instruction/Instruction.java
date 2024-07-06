package daml.daml.finance.settlement.instruction;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
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
import com.daml.ledger.javaapi.data.codegen.ContractWithKey;
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
import daml.daml.finance.interface$.settlement.types.Allocation;
import daml.daml.finance.interface$.settlement.types.Approval;
import daml.daml.finance.interface$.settlement.types.InstructionKey;
import daml.daml.finance.interface$.settlement.types.RoutedStep;
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

public final class Instruction extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("ea5a2fa6a1df87c3279c4672835e49813545489febd9d5f9e076ca36db837b33", "Daml.Finance.Settlement.Instruction", "Instruction");

  public static final Choice<Instruction, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithKey<Contract, ContractId, Instruction, InstructionKey> COMPANION = 
      new ContractCompanion.WithKey<>("daml.daml.finance.settlement.instruction.Instruction",
        TEMPLATE_ID, ContractId::new, v -> Instruction.templateValueDecoder().decode(v),
        Instruction::fromJson, Contract::new, List.of(CHOICE_Archive),
        e -> InstructionKey.valueDecoder().decode(e));

  public final String instructor;

  public final Set<String> consenters;

  public final Set<String> settlers;

  public final Id batchId;

  public final Id id;

  public final RoutedStep routedStep;

  public final Optional<Instant> settlementTime;

  public final Allocation allocation;

  public final Approval approval;

  public final Set<String> signedSenders;

  public final Set<String> signedReceivers;

  public final Map<String, Set<String>> observers;

  public Instruction(String instructor, Set<String> consenters, Set<String> settlers, Id batchId,
      Id id, RoutedStep routedStep, Optional<Instant> settlementTime, Allocation allocation,
      Approval approval, Set<String> signedSenders, Set<String> signedReceivers,
      Map<String, Set<String>> observers) {
    this.instructor = instructor;
    this.consenters = consenters;
    this.settlers = settlers;
    this.batchId = batchId;
    this.id = id;
    this.routedStep = routedStep;
    this.settlementTime = settlementTime;
    this.allocation = allocation;
    this.approval = approval;
    this.signedSenders = signedSenders;
    this.signedReceivers = signedReceivers;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Instruction.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(InstructionKey key,
      daml.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(InstructionKey key) {
    return byKey(key).exerciseArchive();
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

  public static Update<Created<ContractId>> create(String instructor, Set<String> consenters,
      Set<String> settlers, Id batchId, Id id, RoutedStep routedStep,
      Optional<Instant> settlementTime, Allocation allocation, Approval approval,
      Set<String> signedSenders, Set<String> signedReceivers, Map<String, Set<String>> observers) {
    return new Instruction(instructor, consenters, settlers, batchId, id, routedStep,
        settlementTime, allocation, approval, signedSenders, signedReceivers, observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, Instruction, InstructionKey> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Instruction fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Instruction> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(12);
    fields.add(new DamlRecord.Field("instructor", new Party(this.instructor)));
    fields.add(new DamlRecord.Field("consenters", this.consenters.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("settlers", this.settlers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("batchId", this.batchId.toValue()));
    fields.add(new DamlRecord.Field("id", this.id.toValue()));
    fields.add(new DamlRecord.Field("routedStep", this.routedStep.toValue()));
    fields.add(new DamlRecord.Field("settlementTime", DamlOptional.of(this.settlementTime.map(v$0 -> Timestamp.fromInstant(v$0)))));
    fields.add(new DamlRecord.Field("allocation", this.allocation.toValue()));
    fields.add(new DamlRecord.Field("approval", this.approval.toValue()));
    fields.add(new DamlRecord.Field("signedSenders", this.signedSenders.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("signedReceivers", this.signedReceivers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Instruction> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(12,0, recordValue$);
      String instructor = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Set<String> consenters = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      Set<String> settlers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      Id batchId = Id.valueDecoder().decode(fields$.get(3).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(4).getValue());
      RoutedStep routedStep = RoutedStep.valueDecoder().decode(fields$.get(5).getValue());
      Optional<Instant> settlementTime = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromTimestamp).decode(fields$.get(6).getValue());
      Allocation allocation = Allocation.valueDecoder().decode(fields$.get(7).getValue());
      Approval approval = Approval.valueDecoder().decode(fields$.get(8).getValue());
      Set<String> signedSenders =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(9).getValue());
      Set<String> signedReceivers =
          Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(10).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(11).getValue());
      return new Instruction(instructor, consenters, settlers, batchId, id, routedStep,
          settlementTime, allocation, approval, signedSenders, signedReceivers, observers);
    } ;
  }

  public static JsonLfDecoder<Instruction> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("instructor", "consenters", "settlers", "batchId", "id", "routedStep", "settlementTime", "allocation", "approval", "signedSenders", "signedReceivers", "observers"), name -> {
          switch (name) {
            case "instructor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "consenters": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "settlers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "batchId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "routedStep": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, daml.daml.finance.interface$.settlement.types.RoutedStep.jsonDecoder());
            case "settlementTime": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp));
            case "allocation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, daml.daml.finance.interface$.settlement.types.Allocation.jsonDecoder());
            case "approval": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, daml.daml.finance.interface$.settlement.types.Approval.jsonDecoder());
            case "signedSenders": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "signedReceivers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Instruction(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11])));
  }

  public static Instruction fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("instructor", apply(JsonLfEncoders::party, instructor)),
        JsonLfEncoders.Field.of("consenters", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), consenters)),
        JsonLfEncoders.Field.of("settlers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), settlers)),
        JsonLfEncoders.Field.of("batchId", apply(Id::jsonEncoder, batchId)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("routedStep", apply(RoutedStep::jsonEncoder, routedStep)),
        JsonLfEncoders.Field.of("settlementTime", apply(JsonLfEncoders.optional(JsonLfEncoders::timestamp), settlementTime)),
        JsonLfEncoders.Field.of("allocation", apply(Allocation::jsonEncoder, allocation)),
        JsonLfEncoders.Field.of("approval", apply(Approval::jsonEncoder, approval)),
        JsonLfEncoders.Field.of("signedSenders", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), signedSenders)),
        JsonLfEncoders.Field.of("signedReceivers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), signedReceivers)),
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
    if (!(object instanceof Instruction)) {
      return false;
    }
    Instruction other = (Instruction) object;
    return Objects.equals(this.instructor, other.instructor) &&
        Objects.equals(this.consenters, other.consenters) &&
        Objects.equals(this.settlers, other.settlers) &&
        Objects.equals(this.batchId, other.batchId) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.routedStep, other.routedStep) &&
        Objects.equals(this.settlementTime, other.settlementTime) &&
        Objects.equals(this.allocation, other.allocation) &&
        Objects.equals(this.approval, other.approval) &&
        Objects.equals(this.signedSenders, other.signedSenders) &&
        Objects.equals(this.signedReceivers, other.signedReceivers) &&
        Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.instructor, this.consenters, this.settlers, this.batchId, this.id,
        this.routedStep, this.settlementTime, this.allocation, this.approval, this.signedSenders,
        this.signedReceivers, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.settlement.instruction.Instruction(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.instructor, this.consenters, this.settlers, this.batchId, this.id, this.routedStep,
        this.settlementTime, this.allocation, this.approval, this.signedSenders,
        this.signedReceivers, this.observers);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(InstructionKey key) {
    return new ByKey(key.toValue());
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Instruction> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Instruction, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.settlement.instruction.Instruction.ContractId toInterface(
        daml.daml.finance.interface$.settlement.instruction.Instruction.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.settlement.instruction.Instruction.ContractId(this.contractId);
    }

    public Disclosure.ContractId toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.settlement.instruction.Instruction.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Disclosure.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Instruction> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, Instruction, InstructionKey> {
    public Contract(ContractId id, Instruction data, Optional<String> agreementText,
        Optional<InstructionKey> key, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Instruction> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<InstructionKey> key,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Instruction, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.settlement.instruction.Instruction.CreateAnd toInterface(
        daml.daml.finance.interface$.settlement.instruction.Instruction.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.settlement.instruction.Instruction.CreateAnd(COMPANION, this.createArguments);
    }

    public Disclosure.CreateAnd toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.CreateAnd(COMPANION, this.createArguments);
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Instruction, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.settlement.instruction.Instruction.ByKey toInterface(
        daml.daml.finance.interface$.settlement.instruction.Instruction.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.settlement.instruction.Instruction.ByKey(COMPANION, this.contractKey);
    }

    public Disclosure.ByKey toInterface(Disclosure.INTERFACE_ interfaceCompanion) {
      return new Disclosure.ByKey(COMPANION, this.contractKey);
    }
  }
}
