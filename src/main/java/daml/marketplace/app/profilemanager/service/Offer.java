package daml.app.profilemanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Template;
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
import daml.interface$.profilemanager.userprofile.factory.Factory;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class Offer extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("7410dc0c147f7a1f02e29af653f3db7c67fc88031d45c6c69171d322a8445411", "App.ProfileManager.Service", "Offer");

  public static final Choice<Offer, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Offer> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.app.profilemanager.service.Offer", TEMPLATE_ID,
        ContractId::new, v -> Offer.templateValueDecoder().decode(v), Offer::fromJson,
        Contract::new, List.of(CHOICE_Archive));

  public final String operator;

  public final String user;

  public final Factory.ContractId userProfileFactoryCid;

  public Offer(String operator, String user, Factory.ContractId userProfileFactoryCid) {
    this.operator = operator;
    this.user = user;
    this.userProfileFactoryCid = userProfileFactoryCid;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Offer.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(String operator, String user,
      Factory.ContractId userProfileFactoryCid) {
    return new Offer(operator, user, userProfileFactoryCid).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Offer> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Offer fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Offer> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(3);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("user", new Party(this.user)));
    fields.add(new DamlRecord.Field("userProfileFactoryCid", this.userProfileFactoryCid.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Offer> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String user = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Factory.ContractId userProfileFactoryCid =
          new Factory.ContractId(fields$.get(2).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected userProfileFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new Offer(operator, user, userProfileFactoryCid);
    } ;
  }

  public static JsonLfDecoder<Offer> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "user", "userProfileFactoryCid"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "user": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "userProfileFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.profilemanager.userprofile.factory.Factory.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new Offer(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static Offer fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("user", apply(JsonLfEncoders::party, user)),
        JsonLfEncoders.Field.of("userProfileFactoryCid", apply(JsonLfEncoders::contractId, userProfileFactoryCid)));
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
    if (!(object instanceof Offer)) {
      return false;
    }
    Offer other = (Offer) object;
    return Objects.equals(this.operator, other.operator) && Objects.equals(this.user, other.user) &&
        Objects.equals(this.userProfileFactoryCid, other.userProfileFactoryCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.user, this.userProfileFactoryCid);
  }

  @Override
  public String toString() {
    return String.format("daml.app.profilemanager.service.Offer(%s, %s, %s)", this.operator,
        this.user, this.userProfileFactoryCid);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Offer> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Offer, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.profilemanager.service.Offer.ContractId toInterface(
        daml.interface$.profilemanager.service.Offer.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.profilemanager.service.Offer.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.interface$.profilemanager.service.Offer.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Offer> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Offer> {
    public Contract(ContractId id, Offer data, Optional<String> agreementText,
        Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Offer> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Set<String> signatories, Set<String> observers) {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Offer, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.profilemanager.service.Offer.CreateAnd toInterface(
        daml.interface$.profilemanager.service.Offer.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.profilemanager.service.Offer.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
