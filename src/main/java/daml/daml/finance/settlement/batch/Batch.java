package daml.daml.finance.settlement.batch;

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
import daml.da.types.Tuple2;
import daml.daml.finance.interface$.settlement.types.RoutedStep;
import daml.daml.finance.interface$.types.common.types.Id;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class Batch extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("ea5a2fa6a1df87c3279c4672835e49813545489febd9d5f9e076ca36db837b33", "Daml.Finance.Settlement.Batch", "Batch");

  public static final Choice<Batch, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Batch> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.daml.finance.settlement.batch.Batch", TEMPLATE_ID,
        ContractId::new, v -> Batch.templateValueDecoder().decode(v), Batch::fromJson,
        Contract::new, List.of(CHOICE_Archive));

  public final String instructor;

  public final Set<String> consenters;

  public final Set<String> settlers;

  public final Id id;

  public final String description;

  public final Optional<Id> contextId;

  public final List<Tuple2<RoutedStep, Id>> routedStepsWithInstructionId;

  public final Optional<Instant> settlementTime;

  public Batch(String instructor, Set<String> consenters, Set<String> settlers, Id id,
      String description, Optional<Id> contextId,
      List<Tuple2<RoutedStep, Id>> routedStepsWithInstructionId, Optional<Instant> settlementTime) {
    this.instructor = instructor;
    this.consenters = consenters;
    this.settlers = settlers;
    this.id = id;
    this.description = description;
    this.contextId = contextId;
    this.routedStepsWithInstructionId = routedStepsWithInstructionId;
    this.settlementTime = settlementTime;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Batch.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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
      Set<String> settlers, Id id, String description, Optional<Id> contextId,
      List<Tuple2<RoutedStep, Id>> routedStepsWithInstructionId, Optional<Instant> settlementTime) {
    return new Batch(instructor, consenters, settlers, id, description, contextId,
        routedStepsWithInstructionId, settlementTime).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Batch> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Batch fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Batch> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(8);
    fields.add(new DamlRecord.Field("instructor", new Party(this.instructor)));
    fields.add(new DamlRecord.Field("consenters", this.consenters.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("settlers", this.settlers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("id", this.id.toValue()));
    fields.add(new DamlRecord.Field("description", new Text(this.description)));
    fields.add(new DamlRecord.Field("contextId", DamlOptional.of(this.contextId.map(v$0 -> v$0.toValue()))));
    fields.add(new DamlRecord.Field("routedStepsWithInstructionId", this.routedStepsWithInstructionId.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue(v$1 -> v$1.toValue(),
        v$2 -> v$2.toValue())))));
    fields.add(new DamlRecord.Field("settlementTime", DamlOptional.of(this.settlementTime.map(v$0 -> Timestamp.fromInstant(v$0)))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Batch> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(8,1, recordValue$);
      String instructor = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Set<String> consenters = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      Set<String> settlers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(3).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(4).getValue());
      Optional<Id> contextId = PrimitiveValueDecoders.fromOptional(Id.valueDecoder())
          .decode(fields$.get(5).getValue());
      List<Tuple2<RoutedStep, Id>> routedStepsWithInstructionId = PrimitiveValueDecoders.fromList(
            Tuple2.<daml.daml.finance.interface$.settlement.types.RoutedStep,
            daml.daml.finance.interface$.types.common.types.Id>valueDecoder(RoutedStep.valueDecoder(),
            Id.valueDecoder())).decode(fields$.get(6).getValue());
      Optional<Instant> settlementTime = PrimitiveValueDecoders.fromOptional(
            PrimitiveValueDecoders.fromTimestamp).decode(fields$.get(7).getValue());
      return new Batch(instructor, consenters, settlers, id, description, contextId,
          routedStepsWithInstructionId, settlementTime);
    } ;
  }

  public static JsonLfDecoder<Batch> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("instructor", "consenters", "settlers", "id", "description", "contextId", "routedStepsWithInstructionId", "settlementTime"), name -> {
          switch (name) {
            case "instructor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "consenters": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "settlers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "contextId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.daml.finance.interface$.types.common.types.Id.jsonDecoder()));
            case "routedStepsWithInstructionId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.da.types.Tuple2.jsonDecoder(daml.daml.finance.interface$.settlement.types.RoutedStep.jsonDecoder(), daml.daml.finance.interface$.types.common.types.Id.jsonDecoder())));
            case "settlementTime": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp));
            default: return null;
          }
        }
        , (Object[] args) -> new Batch(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7])));
  }

  public static Batch fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("instructor", apply(JsonLfEncoders::party, instructor)),
        JsonLfEncoders.Field.of("consenters", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), consenters)),
        JsonLfEncoders.Field.of("settlers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), settlers)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("contextId", apply(JsonLfEncoders.optional(Id::jsonEncoder), contextId)),
        JsonLfEncoders.Field.of("routedStepsWithInstructionId", apply(JsonLfEncoders.list(_x1 -> _x1.jsonEncoder(RoutedStep::jsonEncoder, Id::jsonEncoder)), routedStepsWithInstructionId)),
        JsonLfEncoders.Field.of("settlementTime", apply(JsonLfEncoders.optional(JsonLfEncoders::timestamp), settlementTime)));
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
    if (!(object instanceof Batch)) {
      return false;
    }
    Batch other = (Batch) object;
    return Objects.equals(this.instructor, other.instructor) &&
        Objects.equals(this.consenters, other.consenters) &&
        Objects.equals(this.settlers, other.settlers) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.contextId, other.contextId) &&
        Objects.equals(this.routedStepsWithInstructionId, other.routedStepsWithInstructionId) &&
        Objects.equals(this.settlementTime, other.settlementTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.instructor, this.consenters, this.settlers, this.id, this.description,
        this.contextId, this.routedStepsWithInstructionId, this.settlementTime);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.settlement.batch.Batch(%s, %s, %s, %s, %s, %s, %s, %s)",
        this.instructor, this.consenters, this.settlers, this.id, this.description, this.contextId,
        this.routedStepsWithInstructionId, this.settlementTime);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Batch> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Batch, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.settlement.batch.Batch.ContractId toInterface(
        daml.daml.finance.interface$.settlement.batch.Batch.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.settlement.batch.Batch.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.daml.finance.interface$.settlement.batch.Batch.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Batch> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Batch> {
    public Contract(ContractId id, Batch data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Batch> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Batch, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.daml.finance.interface$.settlement.batch.Batch.CreateAnd toInterface(
        daml.daml.finance.interface$.settlement.batch.Batch.INTERFACE_ interfaceCompanion) {
      return new daml.daml.finance.interface$.settlement.batch.Batch.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
