package daml.app.issuance.model;

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
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.daml.finance.interface$.types.common.types.Quantity;
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

public final class IssueRequest extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "App.Issuance.Model", "IssueRequest");

  public static final Choice<IssueRequest, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithoutKey<Contract, ContractId, IssueRequest> COMPANION = 
      new ContractCompanion.WithoutKey<>("daml.app.issuance.model.IssueRequest", TEMPLATE_ID,
        ContractId::new, v -> IssueRequest.templateValueDecoder().decode(v), IssueRequest::fromJson,
        Contract::new, List.of(CHOICE_Archive));

  public final String operator;

  public final String user;

  public final Id issuanceId;

  public final String description;

  public final Quantity<InstrumentKey, BigDecimal> quantity;

  public final AccountKey account;

  public IssueRequest(String operator, String user, Id issuanceId, String description,
      Quantity<InstrumentKey, BigDecimal> quantity, AccountKey account) {
    this.operator = operator;
    this.user = user;
    this.issuanceId = issuanceId;
    this.description = description;
    this.quantity = quantity;
    this.account = account;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(IssueRequest.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
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

  public static Update<Created<ContractId>> create(String operator, String user, Id issuanceId,
      String description, Quantity<InstrumentKey, BigDecimal> quantity, AccountKey account) {
    return new IssueRequest(operator, user, issuanceId, description, quantity, account).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithoutKey<Contract, ContractId, IssueRequest> getCompanion() {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static IssueRequest fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<IssueRequest> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(6);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("user", new Party(this.user)));
    fields.add(new DamlRecord.Field("issuanceId", this.issuanceId.toValue()));
    fields.add(new DamlRecord.Field("description", new Text(this.description)));
    fields.add(new DamlRecord.Field("quantity", this.quantity.toValue(v$0 -> v$0.toValue(),
        v$1 -> new Numeric(v$1))));
    fields.add(new DamlRecord.Field("account", this.account.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<IssueRequest> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String user = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Id issuanceId = Id.valueDecoder().decode(fields$.get(2).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      Quantity<InstrumentKey, BigDecimal> quantity =
          Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
          java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
          PrimitiveValueDecoders.fromNumeric).decode(fields$.get(4).getValue());
      AccountKey account = AccountKey.valueDecoder().decode(fields$.get(5).getValue());
      return new IssueRequest(operator, user, issuanceId, description, quantity, account);
    } ;
  }

  public static JsonLfDecoder<IssueRequest> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "user", "issuanceId", "description", "quantity", "account"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "user": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "issuanceId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "quantity": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10)));
            case "account": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new IssueRequest(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static IssueRequest fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("user", apply(JsonLfEncoders::party, user)),
        JsonLfEncoders.Field.of("issuanceId", apply(Id::jsonEncoder, issuanceId)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("quantity", apply(_x0 -> _x0.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric), quantity)),
        JsonLfEncoders.Field.of("account", apply(AccountKey::jsonEncoder, account)));
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
    if (!(object instanceof IssueRequest)) {
      return false;
    }
    IssueRequest other = (IssueRequest) object;
    return Objects.equals(this.operator, other.operator) && Objects.equals(this.user, other.user) &&
        Objects.equals(this.issuanceId, other.issuanceId) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.quantity, other.quantity) &&
        Objects.equals(this.account, other.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.user, this.issuanceId, this.description, this.quantity,
        this.account);
  }

  @Override
  public String toString() {
    return String.format("daml.app.issuance.model.IssueRequest(%s, %s, %s, %s, %s, %s)",
        this.operator, this.user, this.issuanceId, this.description, this.quantity, this.account);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<IssueRequest> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, IssueRequest, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.issuance.choices.issuerequest.IssueRequest.ContractId toInterface(
        daml.interface$.issuance.choices.issuerequest.IssueRequest.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.issuance.choices.issuerequest.IssueRequest.ContractId(this.contractId);
    }

    public Removable.ContractId toInterface(Removable.INTERFACE_ interfaceCompanion) {
      return new Removable.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.interface$.issuance.choices.issuerequest.IssueRequest.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(Removable.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<IssueRequest> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, IssueRequest> {
    public Contract(ContractId id, IssueRequest data, Optional<String> agreementText,
        Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, IssueRequest> getCompanion() {
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
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, IssueRequest, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.issuance.choices.issuerequest.IssueRequest.CreateAnd toInterface(
        daml.interface$.issuance.choices.issuerequest.IssueRequest.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.issuance.choices.issuerequest.IssueRequest.CreateAnd(COMPANION, this.createArguments);
    }

    public Removable.CreateAnd toInterface(Removable.INTERFACE_ interfaceCompanion) {
      return new Removable.CreateAnd(COMPANION, this.createArguments);
    }
  }
}
