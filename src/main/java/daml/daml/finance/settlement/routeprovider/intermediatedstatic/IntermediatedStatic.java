package daml.daml.finance.settlement.routeprovider.intermediatedstatic;

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
import daml.daml.finance.interface$.settlement.routeprovider.RouteProvider;
import daml.daml.finance.settlement.hierarchy.Hierarchy;
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

public final class IntermediatedStatic extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("ea5a2fa6a1df87c3279c4672835e49813545489febd9d5f9e076ca36db837b33", "Daml.Finance.Settlement.RouteProvider.IntermediatedStatic", "IntermediatedStatic");

  public static final Choice<IntermediatedStatic, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, IntermediatedStatic> COMPANION = 
      new ContractCompanion.WithoutKey<>(
        "daml.daml.finance.settlement.routeprovider.intermediatedstatic.IntermediatedStatic",
        TEMPLATE_ID, ContractId::new, v -> IntermediatedStatic.templateValueDecoder().decode(v),
        IntermediatedStatic::fromJson, Contract::new, List.of(CHOICE_Archive));

  public final String provider;

  public final Set<String> observers;

  public final Map<String, Hierarchy> paths;

  public IntermediatedStatic(String provider, Set<String> observers, Map<String, Hierarchy> paths) {
    this.provider = provider;
    this.observers = observers;
    this.paths = paths;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(IntermediatedStatic.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(String provider, Set<String> observers,
      Map<String, Hierarchy> paths) {
    return new IntermediatedStatic(provider, observers, paths).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, IntermediatedStatic> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static IntermediatedStatic fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<IntermediatedStatic> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(3);
    fields.add(new DamlRecord.Field("provider", new Party(this.provider)));
    fields.add(new DamlRecord.Field("observers", this.observers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("paths", this.paths.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue()))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<IntermediatedStatic> templateValueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0, recordValue$);
      String provider = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Set<String> observers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      Map<String, Hierarchy> paths = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText, Hierarchy.valueDecoder())
          .decode(fields$.get(2).getValue());
      return new IntermediatedStatic(provider, observers, paths);
    } ;
  }

  public static JsonLfDecoder<IntermediatedStatic> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("provider", "observers", "paths"), name -> {
          switch (name) {
            case "provider": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "paths": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.daml.finance.settlement.hierarchy.Hierarchy.jsonDecoder()));
            default: return null;
          }
        }
        , (Object[] args) -> new IntermediatedStatic(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static IntermediatedStatic fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("provider", apply(JsonLfEncoders::party, provider)),
        JsonLfEncoders.Field.of("observers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), observers)),
        JsonLfEncoders.Field.of("paths", apply(JsonLfEncoders.genMap(JsonLfEncoders::text, Hierarchy::jsonEncoder), paths)));
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
    if (!(object instanceof IntermediatedStatic)) {
      return false;
    }
    IntermediatedStatic other = (IntermediatedStatic) object;
    return Objects.equals(this.provider, other.provider) &&
        Objects.equals(this.observers, other.observers) && Objects.equals(this.paths, other.paths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.provider, this.observers, this.paths);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.settlement.routeprovider.intermediatedstatic.IntermediatedStatic(%s, %s, %s)",
        this.provider, this.observers, this.paths);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<IntermediatedStatic> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, IntermediatedStatic, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public RouteProvider.ContractId toInterface(RouteProvider.INTERFACE_ interfaceCompanion) {
      return new RouteProvider.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(RouteProvider.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<IntermediatedStatic> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, IntermediatedStatic> {
    public Contract(ContractId id, IntermediatedStatic data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, IntermediatedStatic> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, IntermediatedStatic, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public RouteProvider.CreateAnd toInterface(RouteProvider.INTERFACE_ interfaceCompanion) {
      return new RouteProvider.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
