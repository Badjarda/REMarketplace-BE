package daml.daml.finance.interface$.holding.factory;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
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
import daml.daml.finance.interface$.types.common.types.HoldingFactoryKey;
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

public final class Reference extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("1b3dd202f2b5f6e97f0cc3426598a0c6c4725d8885e9e91d14377dce3e451348", "Daml.Finance.Interface.Holding.Factory", "Reference");

  public static final Choice<Reference, SetCid, ContractId> CHOICE_SetCid = 
      Choice.create("SetCid", value$ -> value$.toValue(), value$ -> SetCid.valueDecoder()
        .decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Reference, SetObservers, ContractId> CHOICE_SetObservers = 
      Choice.create("SetObservers", value$ -> value$.toValue(), value$ ->
        SetObservers.valueDecoder().decode(value$), value$ ->
        new ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Reference, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Reference, GetCid, Factory.ContractId> CHOICE_GetCid = 
      Choice.create("GetCid", value$ -> value$.toValue(), value$ -> GetCid.valueDecoder()
        .decode(value$), value$ ->
        new Factory.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithKey<Contract, ContractId, Reference, HoldingFactoryKey> COMPANION = 
      new ContractCompanion.WithKey<>("daml.daml.finance.interface$.holding.factory.Reference",
        TEMPLATE_ID, ContractId::new, v -> Reference.templateValueDecoder().decode(v),
        Reference::fromJson, Contract::new, List.of(CHOICE_SetCid, CHOICE_SetObservers,
        CHOICE_Archive, CHOICE_GetCid), e -> HoldingFactoryKey.valueDecoder().decode(e));

  public final View factoryView;

  public final Factory.ContractId cid;

  public final Map<String, Set<String>> observers;

  public Reference(View factoryView, Factory.ContractId cid, Map<String, Set<String>> observers) {
    this.factoryView = factoryView;
    this.cid = cid;
    this.observers = observers;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Reference.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetCid} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetCid(HoldingFactoryKey key,
      SetCid arg) {
    return byKey(key).exerciseSetCid(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetCid(newCid)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetCid(HoldingFactoryKey key,
      Factory.ContractId newCid) {
    return byKey(key).exerciseSetCid(newCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetObservers} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetObservers(HoldingFactoryKey key,
      SetObservers arg) {
    return byKey(key).exerciseSetObservers(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetObservers(newObservers)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetObservers(HoldingFactoryKey key,
      Map<String, Set<String>> newObservers) {
    return byKey(key).exerciseSetObservers(newObservers);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(HoldingFactoryKey key,
      daml.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(HoldingFactoryKey key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseGetCid} instead
   */
  @Deprecated
  public static Update<Exercised<Factory.ContractId>> exerciseByKeyGetCid(HoldingFactoryKey key,
      GetCid arg) {
    return byKey(key).exerciseGetCid(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseGetCid(viewer)} instead
   */
  @Deprecated
  public static Update<Exercised<Factory.ContractId>> exerciseByKeyGetCid(HoldingFactoryKey key,
      String viewer) {
    return byKey(key).exerciseGetCid(viewer);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetCid} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetCid(SetCid arg) {
    return createAnd().exerciseSetCid(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetCid} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetCid(Factory.ContractId newCid) {
    return createAndExerciseSetCid(new SetCid(newCid));
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetObservers} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetObservers(SetObservers arg) {
    return createAnd().exerciseSetObservers(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseSetObservers} instead
   */
  @Deprecated
  public Update<Exercised<ContractId>> createAndExerciseSetObservers(
      Map<String, Set<String>> newObservers) {
    return createAndExerciseSetObservers(new SetObservers(newObservers));
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

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseGetCid} instead
   */
  @Deprecated
  public Update<Exercised<Factory.ContractId>> createAndExerciseGetCid(GetCid arg) {
    return createAnd().exerciseGetCid(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseGetCid} instead
   */
  @Deprecated
  public Update<Exercised<Factory.ContractId>> createAndExerciseGetCid(String viewer) {
    return createAndExerciseGetCid(new GetCid(viewer));
  }

  public static Update<Created<ContractId>> create(View factoryView, Factory.ContractId cid,
      Map<String, Set<String>> observers) {
    return new Reference(factoryView, cid, observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, Reference, HoldingFactoryKey> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Reference fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Reference> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(3);
    fields.add(new DamlRecord.Field("factoryView", this.factoryView.toValue()));
    fields.add(new DamlRecord.Field("cid", this.cid.toValue()));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Reference> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0, recordValue$);
      View factoryView = View.valueDecoder().decode(fields$.get(0).getValue());
      Factory.ContractId cid =
          new Factory.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected cid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(2).getValue());
      return new Reference(factoryView, cid, observers);
    } ;
  }

  public static JsonLfDecoder<Reference> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("factoryView", "cid", "observers"), name -> {
          switch (name) {
            case "factoryView": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.holding.factory.View.jsonDecoder());
            case "cid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.holding.factory.Factory.ContractId::new));
            case "observers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.genMap(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party)));
            default: return null;
          }
        }
        , (Object[] args) -> new Reference(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static Reference fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("factoryView", apply(View::jsonEncoder, factoryView)),
        JsonLfEncoders.Field.of("cid", apply(JsonLfEncoders::contractId, cid)),
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
    if (!(object instanceof Reference)) {
      return false;
    }
    Reference other = (Reference) object;
    return Objects.equals(this.factoryView, other.factoryView) &&
        Objects.equals(this.cid, other.cid) && Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.factoryView, this.cid, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.holding.factory.Reference(%s, %s, %s)",
        this.factoryView, this.cid, this.observers);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(HoldingFactoryKey key) {
    return new ByKey(key.toValue());
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Reference> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Reference, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Reference> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, Reference, HoldingFactoryKey> {
    public Contract(ContractId id, Reference data, Optional<String> agreementText,
        Optional<HoldingFactoryKey> key, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Reference> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<HoldingFactoryKey> key,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<ContractId>> exerciseSetCid(SetCid arg) {
      return makeExerciseCmd(CHOICE_SetCid, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetCid(Factory.ContractId newCid) {
      return exerciseSetCid(new SetCid(newCid));
    }

    default Update<Exercised<ContractId>> exerciseSetObservers(SetObservers arg) {
      return makeExerciseCmd(CHOICE_SetObservers, arg);
    }

    default Update<Exercised<ContractId>> exerciseSetObservers(
        Map<String, Set<String>> newObservers) {
      return exerciseSetObservers(new SetObservers(newObservers));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<Factory.ContractId>> exerciseGetCid(GetCid arg) {
      return makeExerciseCmd(CHOICE_GetCid, arg);
    }

    default Update<Exercised<Factory.ContractId>> exerciseGetCid(String viewer) {
      return exerciseGetCid(new GetCid(viewer));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Reference, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Reference, ?> getCompanion(
        ) {
      return COMPANION;
    }
  }
}
