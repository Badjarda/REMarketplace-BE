package daml.daml.finance.interface$.account.account;

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
import daml.daml.finance.interface$.holding.holding.Holding;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.daml.finance.interface$.types.common.types.Quantity;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.List;

public final class Account {
  public static final Identifier TEMPLATE_ID = new Identifier("20095234ad30447a6c709382b0ff3ed4ed0cbaf588e1048499bcdfa78a9e774c", "Daml.Finance.Interface.Account.Account", "Account");

  public static final Choice<Account, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<Account, Remove, Unit> CHOICE_Remove = 
      Choice.create("Remove", value$ -> value$.toValue(), value$ -> Remove.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Account, Debit, Unit> CHOICE_Debit = 
      Choice.create("Debit", value$ -> value$.toValue(), value$ -> Debit.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Account, Credit, Holding.ContractId> CHOICE_Credit = 
      Choice.create("Credit", value$ -> value$.toValue(), value$ -> Credit.valueDecoder()
        .decode(value$), value$ ->
        new Holding.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Account, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private Account() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Account> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Account, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
    }

    default Update<Exercised<Unit>> exerciseRemove(Remove arg) {
      return makeExerciseCmd(CHOICE_Remove, arg);
    }

    default Update<Exercised<Unit>> exerciseRemove() {
      return exerciseRemove(new Remove());
    }

    default Update<Exercised<Unit>> exerciseDebit(Debit arg) {
      return makeExerciseCmd(CHOICE_Debit, arg);
    }

    default Update<Exercised<Unit>> exerciseDebit(Holding.ContractId holdingCid) {
      return exerciseDebit(new Debit(holdingCid));
    }

    default Update<Exercised<Holding.ContractId>> exerciseCredit(Credit arg) {
      return makeExerciseCmd(CHOICE_Credit, arg);
    }

    default Update<Exercised<Holding.ContractId>> exerciseCredit(
        Quantity<InstrumentKey, BigDecimal> quantity) {
      return exerciseCredit(new Credit(quantity));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Account, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Account, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<Account, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.daml.finance.interface$.account.account.Account", Account.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_Remove, CHOICE_Credit, CHOICE_Debit, CHOICE_Archive,
            CHOICE_GetView));
    }
  }
}
