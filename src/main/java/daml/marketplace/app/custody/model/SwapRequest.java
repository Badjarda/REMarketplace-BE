package daml.app.custody.model;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Numeric;
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
import daml.daml.finance.interface$.holding.transferable.Transferable;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.interface$.common.removable.Removable;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class SwapRequest extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079", "App.Custody.Model", "SwapRequest");

  public static final Choice<SwapRequest, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, SwapRequest> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.app.custody.model.SwapRequest", TEMPLATE_ID,
        ContractId::new, v -> SwapRequest.templateValueDecoder().decode(v), SwapRequest::fromJson,
        Contract::new, List.of(CHOICE_Archive));

  public final String operator;

  public final String buyer;

  public final String seller;

  public final AccountKey sellerAccount;

  public final AccountKey buyerAccount;

  public final Transferable.ContractId fungibleHoldingCid;

  public final BigDecimal fungibleAmount;

  public SwapRequest(String operator, String buyer, String seller, AccountKey sellerAccount,
      AccountKey buyerAccount, Transferable.ContractId fungibleHoldingCid,
      BigDecimal fungibleAmount) {
    this.operator = operator;
    this.buyer = buyer;
    this.seller = seller;
    this.sellerAccount = sellerAccount;
    this.buyerAccount = buyerAccount;
    this.fungibleHoldingCid = fungibleHoldingCid;
    this.fungibleAmount = fungibleAmount;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(SwapRequest.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(String operator, String buyer, String seller,
      AccountKey sellerAccount, AccountKey buyerAccount, Transferable.ContractId fungibleHoldingCid,
      BigDecimal fungibleAmount) {
    return new SwapRequest(operator, buyer, seller, sellerAccount, buyerAccount, fungibleHoldingCid,
        fungibleAmount).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, SwapRequest> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SwapRequest fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SwapRequest> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(7);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("buyer", new Party(this.buyer)));
    fields.add(new DamlRecord.Field("seller", new Party(this.seller)));
    fields.add(new DamlRecord.Field("sellerAccount", this.sellerAccount.toValue()));
    fields.add(new DamlRecord.Field("buyerAccount", this.buyerAccount.toValue()));
    fields.add(new DamlRecord.Field("fungibleHoldingCid", this.fungibleHoldingCid.toValue()));
    fields.add(new DamlRecord.Field("fungibleAmount", new Numeric(this.fungibleAmount)));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<SwapRequest> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(7,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String buyer = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      String seller = PrimitiveValueDecoders.fromParty.decode(fields$.get(2).getValue());
      AccountKey sellerAccount = AccountKey.valueDecoder().decode(fields$.get(3).getValue());
      AccountKey buyerAccount = AccountKey.valueDecoder().decode(fields$.get(4).getValue());
      Transferable.ContractId fungibleHoldingCid =
          new Transferable.ContractId(fields$.get(5).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected fungibleHoldingCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      BigDecimal fungibleAmount = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(6).getValue());
      return new SwapRequest(operator, buyer, seller, sellerAccount, buyerAccount,
          fungibleHoldingCid, fungibleAmount);
    } ;
  }

  public static JsonLfDecoder<SwapRequest> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "buyer", "seller", "sellerAccount", "buyerAccount", "fungibleHoldingCid", "fungibleAmount"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "buyer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "seller": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "sellerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "buyerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "fungibleHoldingCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.holding.transferable.Transferable.ContractId::new));
            case "fungibleAmount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            default: return null;
          }
        }
        , (Object[] args) -> new SwapRequest(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6])));
  }

  public static SwapRequest fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("buyer", apply(JsonLfEncoders::party, buyer)),
        JsonLfEncoders.Field.of("seller", apply(JsonLfEncoders::party, seller)),
        JsonLfEncoders.Field.of("sellerAccount", apply(AccountKey::jsonEncoder, sellerAccount)),
        JsonLfEncoders.Field.of("buyerAccount", apply(AccountKey::jsonEncoder, buyerAccount)),
        JsonLfEncoders.Field.of("fungibleHoldingCid", apply(JsonLfEncoders::contractId, fungibleHoldingCid)),
        JsonLfEncoders.Field.of("fungibleAmount", apply(JsonLfEncoders::numeric, fungibleAmount)));
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
    if (!(object instanceof SwapRequest)) {
      return false;
    }
    SwapRequest other = (SwapRequest) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.buyer, other.buyer) && Objects.equals(this.seller, other.seller) &&
        Objects.equals(this.sellerAccount, other.sellerAccount) &&
        Objects.equals(this.buyerAccount, other.buyerAccount) &&
        Objects.equals(this.fungibleHoldingCid, other.fungibleHoldingCid) &&
        Objects.equals(this.fungibleAmount, other.fungibleAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.buyer, this.seller, this.sellerAccount,
        this.buyerAccount, this.fungibleHoldingCid, this.fungibleAmount);
  }

  @Override
  public String toString() {
    return String.format("daml.app.custody.model.SwapRequest(%s, %s, %s, %s, %s, %s, %s)",
        this.operator, this.buyer, this.seller, this.sellerAccount, this.buyerAccount,
        this.fungibleHoldingCid, this.fungibleAmount);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<SwapRequest> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, SwapRequest, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.custody.choices.swaprequest.SwapRequest.ContractId toInterface(
        daml.interface$.custody.choices.swaprequest.SwapRequest.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.custody.choices.swaprequest.SwapRequest.ContractId(this.contractId);
    }

    public Removable.ContractId toInterface(Removable.INTERFACE_ interfaceCompanion) {
      return new Removable.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.interface$.custody.choices.swaprequest.SwapRequest.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Removable.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<SwapRequest> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, SwapRequest> {
    public Contract(ContractId id, SwapRequest data, Optional<String> agreementText,
        Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, SwapRequest> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, SwapRequest, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.custody.choices.swaprequest.SwapRequest.CreateAnd toInterface(
        daml.interface$.custody.choices.swaprequest.SwapRequest.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.custody.choices.swaprequest.SwapRequest.CreateAnd(COMPANION, this.createArguments);
    }

    public Removable.CreateAnd toInterface(Removable.INTERFACE_ interfaceCompanion) {
      return new Removable.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
