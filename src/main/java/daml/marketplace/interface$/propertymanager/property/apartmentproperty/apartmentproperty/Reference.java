package daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty;

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
import daml.marketplace.interface$.common.types.PropertyKey;
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
  public static final Identifier TEMPLATE_ID = new Identifier("b93cea58d2cd7e7792117719e7c79bd5a10ca2a87dc57a03f202a3ec5bc6c5d9", "Interface.PropertyManager.Property.ApartmentProperty.ApartmentProperty", "Reference");

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

  public static final Choice<Reference, GetCid, ApartmentProperty.ContractId> CHOICE_GetCid = 
      Choice.create("GetCid", value$ -> value$.toValue(), value$ -> GetCid.valueDecoder()
        .decode(value$), value$ ->
        new ApartmentProperty.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final ContractCompanion.WithKey<Contract, ContractId, Reference, PropertyKey> COMPANION = 
      new ContractCompanion.WithKey<>(
        "daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty.Reference",
        TEMPLATE_ID, ContractId::new, v -> Reference.templateValueDecoder().decode(v),
        Reference::fromJson, Contract::new, List.of(CHOICE_SetCid, CHOICE_SetObservers,
        CHOICE_Archive, CHOICE_GetCid), e -> PropertyKey.valueDecoder().decode(e));

  public final View apartmentPropertyView;

  public final ApartmentProperty.ContractId cid;

  public final Map<String, Set<String>> observers;

  public Reference(View apartmentPropertyView, ApartmentProperty.ContractId cid,
      Map<String, Set<String>> observers) {
    this.apartmentPropertyView = apartmentPropertyView;
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
  public static Update<Exercised<ContractId>> exerciseByKeySetCid(PropertyKey key, SetCid arg) {
    return byKey(key).exerciseSetCid(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetCid(newCid)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetCid(PropertyKey key,
      ApartmentProperty.ContractId newCid) {
    return byKey(key).exerciseSetCid(newCid);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetObservers} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetObservers(PropertyKey key,
      SetObservers arg) {
    return byKey(key).exerciseSetObservers(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseSetObservers(newObservers)} instead
   */
  @Deprecated
  public static Update<Exercised<ContractId>> exerciseByKeySetObservers(PropertyKey key,
      Map<String, Set<String>> newObservers) {
    return byKey(key).exerciseSetObservers(newObservers);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(PropertyKey key,
      daml.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(PropertyKey key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseGetCid} instead
   */
  @Deprecated
  public static Update<Exercised<ApartmentProperty.ContractId>> exerciseByKeyGetCid(PropertyKey key,
      GetCid arg) {
    return byKey(key).exerciseGetCid(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseGetCid(viewer)} instead
   */
  @Deprecated
  public static Update<Exercised<ApartmentProperty.ContractId>> exerciseByKeyGetCid(PropertyKey key,
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
  public Update<Exercised<ContractId>> createAndExerciseSetCid(
      ApartmentProperty.ContractId newCid) {
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
  public Update<Exercised<ApartmentProperty.ContractId>> createAndExerciseGetCid(GetCid arg) {
    return createAnd().exerciseGetCid(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseGetCid} instead
   */
  @Deprecated
  public Update<Exercised<ApartmentProperty.ContractId>> createAndExerciseGetCid(String viewer) {
    return createAndExerciseGetCid(new GetCid(viewer));
  }

  public static Update<Created<ContractId>> create(View apartmentPropertyView,
      ApartmentProperty.ContractId cid, Map<String, Set<String>> observers) {
    return new Reference(apartmentPropertyView, cid, observers).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, Reference, PropertyKey> getCompanion() {
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
    fields.add(new DamlRecord.Field("apartmentPropertyView", this.apartmentPropertyView.toValue()));
    fields.add(new DamlRecord.Field("cid", this.cid.toValue()));
    fields.add(new DamlRecord.Field("observers", this.observers.entrySet().stream()
        .collect(DamlCollectors.toDamlGenMap(v$0 -> new Text(v$0.getKey()), v$0 -> v$0.getValue().toValue(v$1 -> new Party(v$1))))));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Reference> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0, recordValue$);
      View apartmentPropertyView = View.valueDecoder().decode(fields$.get(0).getValue());
      ApartmentProperty.ContractId cid =
          new ApartmentProperty.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected cid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      Map<String, Set<String>> observers = PrimitiveValueDecoders.fromGenMap(
            PrimitiveValueDecoders.fromText,
            Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty))
          .decode(fields$.get(2).getValue());
      return new Reference(apartmentPropertyView, cid, observers);
    } ;
  }

  public static JsonLfDecoder<Reference> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("apartmentPropertyView", "cid", "observers"), name -> {
          switch (name) {
            case "apartmentPropertyView": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty.View.jsonDecoder());
            case "cid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty.ApartmentProperty.ContractId::new));
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
        JsonLfEncoders.Field.of("apartmentPropertyView", apply(View::jsonEncoder, apartmentPropertyView)),
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
    return Objects.equals(this.apartmentPropertyView, other.apartmentPropertyView) &&
        Objects.equals(this.cid, other.cid) && Objects.equals(this.observers, other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.apartmentPropertyView, this.cid, this.observers);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty.Reference(%s, %s, %s)",
        this.apartmentPropertyView, this.cid, this.observers);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(PropertyKey key) {
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

  public static class Contract extends ContractWithKey<ContractId, Reference, PropertyKey> {
    public Contract(ContractId id, Reference data, Optional<String> agreementText,
        Optional<PropertyKey> key, java.util.Set<String> signatories,
        java.util.Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Reference> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<PropertyKey> key,
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

    default Update<Exercised<ContractId>> exerciseSetCid(ApartmentProperty.ContractId newCid) {
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

    default Update<Exercised<ApartmentProperty.ContractId>> exerciseGetCid(GetCid arg) {
      return makeExerciseCmd(CHOICE_GetCid, arg);
    }

    default Update<Exercised<ApartmentProperty.ContractId>> exerciseGetCid(String viewer) {
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
