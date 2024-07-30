package daml.interface$.issuance.service;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.Choice;
import com.daml.ledger.javaapi.data.codegen.Contract;
import com.daml.ledger.javaapi.data.codegen.ContractCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractTypeCompanion;
import com.daml.ledger.javaapi.data.codegen.Exercised;
import com.daml.ledger.javaapi.data.codegen.InterfaceCompanion;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.Update;
import daml.da.types.Tuple2;
import daml.daml.finance.interface$.holding.holding.Holding;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.daml.finance.interface$.types.common.types.Quantity;
import daml.interface$.issuance.choices.deissuerequest.DeIssueRequest;
import daml.interface$.issuance.choices.issuerequest.IssueRequest;
import daml.interface$.issuance.issuance.Issuance;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.List;

public final class Service {
  public static final Identifier TEMPLATE_ID = new Identifier("f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079", "Interface.Issuance.Service", "Service");

  public static final Choice<Service, RequestDeIssue, DeIssueRequest.ContractId> CHOICE_RequestDeIssue = 
      Choice.create("RequestDeIssue", value$ -> value$.toValue(), value$ ->
        RequestDeIssue.valueDecoder().decode(value$), value$ ->
        new DeIssueRequest.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, Issue, Tuple2<Issuance.ContractId, Holding.ContractId>> CHOICE_Issue = 
      Choice.create("Issue", value$ -> value$.toValue(), value$ -> Issue.valueDecoder()
        .decode(value$), value$ -> Tuple2.<daml.interface$.issuance.issuance.Issuance.ContractId,
        daml.daml.finance.interface$.holding.holding.Holding.ContractId>valueDecoder(v$0 ->
          new Issuance.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()),
        v$1 ->
          new Holding.ContractId(v$1.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
        .decode(value$));

  public static final Choice<Service, RequestIssue, IssueRequest.ContractId> CHOICE_RequestIssue = 
      Choice.create("RequestIssue", value$ -> value$.toValue(), value$ ->
        RequestIssue.valueDecoder().decode(value$), value$ ->
        new IssueRequest.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, DeIssue, Issuance.ContractId> CHOICE_DeIssue = 
      Choice.create("DeIssue", value$ -> value$.toValue(), value$ -> DeIssue.valueDecoder()
        .decode(value$), value$ ->
        new Issuance.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private Service() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Service> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<DeIssueRequest.ContractId>> exerciseRequestDeIssue(
        RequestDeIssue arg) {
      return makeExerciseCmd(CHOICE_RequestDeIssue, arg);
    }

    default Update<Exercised<DeIssueRequest.ContractId>> exerciseRequestDeIssue(Id issuanceId,
        Holding.ContractId holdingCid) {
      return exerciseRequestDeIssue(new RequestDeIssue(issuanceId, holdingCid));
    }

    default Update<Exercised<Tuple2<Issuance.ContractId, Holding.ContractId>>> exerciseIssue(
        Issue arg) {
      return makeExerciseCmd(CHOICE_Issue, arg);
    }

    default Update<Exercised<Tuple2<Issuance.ContractId, Holding.ContractId>>> exerciseIssue(
        IssueRequest.ContractId issueRequestCid) {
      return exerciseIssue(new Issue(issueRequestCid));
    }

    default Update<Exercised<IssueRequest.ContractId>> exerciseRequestIssue(RequestIssue arg) {
      return makeExerciseCmd(CHOICE_RequestIssue, arg);
    }

    default Update<Exercised<IssueRequest.ContractId>> exerciseRequestIssue(Id issuanceId,
        String description, Quantity<InstrumentKey, BigDecimal> quantity, AccountKey account) {
      return exerciseRequestIssue(new RequestIssue(issuanceId, description, quantity, account));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<Issuance.ContractId>> exerciseDeIssue(DeIssue arg) {
      return makeExerciseCmd(CHOICE_DeIssue, arg);
    }

    default Update<Exercised<Issuance.ContractId>> exerciseDeIssue(
        DeIssueRequest.ContractId deIssueRequestCid) {
      return exerciseDeIssue(new DeIssue(deIssueRequestCid));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<Service, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.issuance.service.Service", Service.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_Issue, CHOICE_Archive, CHOICE_RequestDeIssue,
            CHOICE_DeIssue, CHOICE_RequestIssue));
    }
  }
}
