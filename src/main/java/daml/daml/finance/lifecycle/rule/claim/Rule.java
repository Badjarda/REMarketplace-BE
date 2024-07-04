package daml.daml.finance.lifecycle.rule.claim;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
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
import daml.da.set.types.Set;
import daml.daml.finance.interface$.lifecycle.rule.claim.Claim;
import daml.daml.finance.interface$.settlement.factory.Factory;
import daml.daml.finance.interface$.settlement.routeprovider.RouteProvider;
import java.lang.Boolean;
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

public final class Rule extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("26b39500d110bf1f69fc9d84e2ec281dd9a62fbdf35369e7321d5b30ccc46a97", "Daml.Finance.Lifecycle.Rule.Claim", "Rule");

  public static final Choice<Rule, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, Rule> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.daml.finance.lifecycle.rule.claim.Rule", TEMPLATE_ID,
        ContractId::new, v -> Rule.templateValueDecoder().decode(v), Rule::fromJson, Contract::new,
        List.of(CHOICE_Archive));

  public final String provider;

  public final Set<String> claimers;

  public final Set<String> settlers;

  public final RouteProvider.ContractId routeProviderCid;

  public final Factory.ContractId settlementFactoryCid;

  public final Boolean netInstructions;

  public Rule(String provider, Set<String> claimers, Set<String> settlers,
      RouteProvider.ContractId routeProviderCid, Factory.ContractId settlementFactoryCid,
      Boolean netInstructions) {
    this.provider = provider;
    this.claimers = claimers;
    this.settlers = settlers;
    this.routeProviderCid = routeProviderCid;
    this.settlementFactoryCid = settlementFactoryCid;
    this.netInstructions = netInstructions;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Rule.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(String provider, Set<String> claimers,
      Set<String> settlers, RouteProvider.ContractId routeProviderCid,
      Factory.ContractId settlementFactoryCid, Boolean netInstructions) {
    return new Rule(provider, claimers, settlers, routeProviderCid, settlementFactoryCid,
        netInstructions).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, Rule> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Rule fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Rule> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(6);
    fields.add(new DamlRecord.Field("provider", new Party(this.provider)));
    fields.add(new DamlRecord.Field("claimers", this.claimers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("settlers", this.settlers.toValue(v$0 -> new Party(v$0))));
    fields.add(new DamlRecord.Field("routeProviderCid", this.routeProviderCid.toValue()));
    fields.add(new DamlRecord.Field("settlementFactoryCid", this.settlementFactoryCid.toValue()));
    fields.add(new DamlRecord.Field("netInstructions", Bool.of(this.netInstructions)));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Rule> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0, recordValue$);
      String provider = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Set<String> claimers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      Set<String> settlers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      RouteProvider.ContractId routeProviderCid =
          new RouteProvider.ContractId(fields$.get(3).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected routeProviderCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      Factory.ContractId settlementFactoryCid =
          new Factory.ContractId(fields$.get(4).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected settlementFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      Boolean netInstructions = PrimitiveValueDecoders.fromBool.decode(fields$.get(5).getValue());
      return new Rule(provider, claimers, settlers, routeProviderCid, settlementFactoryCid,
          netInstructions);
    } ;
  }

  public static JsonLfDecoder<Rule> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("provider", "claimers", "settlers", "routeProviderCid", "settlementFactoryCid", "netInstructions"), name -> {
          switch (name) {
            case "provider": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "claimers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "settlers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "routeProviderCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.settlement.routeprovider.RouteProvider.ContractId::new));
            case "settlementFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.settlement.factory.Factory.ContractId::new));
            case "netInstructions": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            default: return null;
          }
        }
        , (Object[] args) -> new Rule(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static Rule fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("provider", apply(JsonLfEncoders::party, provider)),
        JsonLfEncoders.Field.of("claimers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), claimers)),
        JsonLfEncoders.Field.of("settlers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), settlers)),
        JsonLfEncoders.Field.of("routeProviderCid", apply(JsonLfEncoders::contractId, routeProviderCid)),
        JsonLfEncoders.Field.of("settlementFactoryCid", apply(JsonLfEncoders::contractId, settlementFactoryCid)),
        JsonLfEncoders.Field.of("netInstructions", apply(JsonLfEncoders::bool, netInstructions)));
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
    if (!(object instanceof Rule)) {
      return false;
    }
    Rule other = (Rule) object;
    return Objects.equals(this.provider, other.provider) &&
        Objects.equals(this.claimers, other.claimers) &&
        Objects.equals(this.settlers, other.settlers) &&
        Objects.equals(this.routeProviderCid, other.routeProviderCid) &&
        Objects.equals(this.settlementFactoryCid, other.settlementFactoryCid) &&
        Objects.equals(this.netInstructions, other.netInstructions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.provider, this.claimers, this.settlers, this.routeProviderCid,
        this.settlementFactoryCid, this.netInstructions);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.lifecycle.rule.claim.Rule(%s, %s, %s, %s, %s, %s)",
        this.provider, this.claimers, this.settlers, this.routeProviderCid,
        this.settlementFactoryCid, this.netInstructions);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Rule> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Rule, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public Claim.ContractId toInterface(Claim.INTERFACE_ interfaceCompanion) {
      return new Claim.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(Claim.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Rule> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, Rule> {
    public Contract(ContractId id, Rule data, Optional<String> agreementText,
        java.util.Set<String> signatories, java.util.Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Rule> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Rule, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public Claim.CreateAnd toInterface(Claim.INTERFACE_ interfaceCompanion) {
      return new Claim.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
