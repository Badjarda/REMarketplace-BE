package daml.interface$.custody.service;

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
import daml.da.set.types.Set;
import daml.da.types.Tuple2;
import daml.daml.finance.interface$.account.account.Controllers;
import daml.daml.finance.interface$.holding.holding.Holding;
import daml.daml.finance.interface$.holding.transferable.Transferable;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.daml.finance.interface$.types.common.types.Quantity;
import daml.interface$.common.types.PropertyKey;
import daml.interface$.custody.choices.closeaccountrequest.CloseAccountRequest;
import daml.interface$.custody.choices.depositrequest.DepositRequest;
import daml.interface$.custody.choices.openaccountrequest.OpenAccountRequest;
import daml.interface$.custody.choices.swaprequest.SwapRequest;
import daml.interface$.custody.choices.withdrawrequest.WithdrawRequest;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public final class Service {
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.Custody.Service", "Service");

  public static final Choice<Service, AtomicSwapLand, Tuple2<Transferable.ContractId, Transferable.ContractId>> CHOICE_AtomicSwapLand = 
      Choice.create("AtomicSwapLand", value$ -> value$.toValue(), value$ ->
        AtomicSwapLand.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.holding.transferable.Transferable.ContractId,
        daml.daml.finance.interface$.holding.transferable.Transferable.ContractId>valueDecoder(v$0 ->
          new Transferable.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()),
        v$1 ->
          new Transferable.ContractId(v$1.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
        .decode(value$));

  public static final Choice<Service, AtomicSwapResidence, Tuple2<Transferable.ContractId, Transferable.ContractId>> CHOICE_AtomicSwapResidence = 
      Choice.create("AtomicSwapResidence", value$ -> value$.toValue(), value$ ->
        AtomicSwapResidence.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.holding.transferable.Transferable.ContractId,
        daml.daml.finance.interface$.holding.transferable.Transferable.ContractId>valueDecoder(v$0 ->
          new Transferable.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()),
        v$1 ->
          new Transferable.ContractId(v$1.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
        .decode(value$));

  public static final Choice<Service, RequestCloseAccount, CloseAccountRequest.ContractId> CHOICE_RequestCloseAccount = 
      Choice.create("RequestCloseAccount", value$ -> value$.toValue(), value$ ->
        RequestCloseAccount.valueDecoder().decode(value$), value$ ->
        new CloseAccountRequest.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, RequestOpenAccount, OpenAccountRequest.ContractId> CHOICE_RequestOpenAccount = 
      Choice.create("RequestOpenAccount", value$ -> value$.toValue(), value$ ->
        RequestOpenAccount.valueDecoder().decode(value$), value$ ->
        new OpenAccountRequest.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, RequestDeposit, DepositRequest.ContractId> CHOICE_RequestDeposit = 
      Choice.create("RequestDeposit", value$ -> value$.toValue(), value$ ->
        RequestDeposit.valueDecoder().decode(value$), value$ ->
        new DepositRequest.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, Deposit, Holding.ContractId> CHOICE_Deposit = 
      Choice.create("Deposit", value$ -> value$.toValue(), value$ -> Deposit.valueDecoder()
        .decode(value$), value$ ->
        new Holding.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, OpenAccount, AccountKey> CHOICE_OpenAccount = 
      Choice.create("OpenAccount", value$ -> value$.toValue(), value$ -> OpenAccount.valueDecoder()
        .decode(value$), value$ -> AccountKey.valueDecoder().decode(value$));

  public static final Choice<Service, AtomicSwapApartment, Tuple2<Transferable.ContractId, Transferable.ContractId>> CHOICE_AtomicSwapApartment = 
      Choice.create("AtomicSwapApartment", value$ -> value$.toValue(), value$ ->
        AtomicSwapApartment.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.holding.transferable.Transferable.ContractId,
        daml.daml.finance.interface$.holding.transferable.Transferable.ContractId>valueDecoder(v$0 ->
          new Transferable.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()),
        v$1 ->
          new Transferable.ContractId(v$1.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
        .decode(value$));

  public static final Choice<Service, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, Withdrawal, Unit> CHOICE_Withdrawal = 
      Choice.create("Withdrawal", value$ -> value$.toValue(), value$ -> Withdrawal.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, CloseAccount, Unit> CHOICE_CloseAccount = 
      Choice.create("CloseAccount", value$ -> value$.toValue(), value$ ->
        CloseAccount.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, AtomicSwapWarehouse, Tuple2<Transferable.ContractId, Transferable.ContractId>> CHOICE_AtomicSwapWarehouse = 
      Choice.create("AtomicSwapWarehouse", value$ -> value$.toValue(), value$ ->
        AtomicSwapWarehouse.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.holding.transferable.Transferable.ContractId,
        daml.daml.finance.interface$.holding.transferable.Transferable.ContractId>valueDecoder(v$0 ->
          new Transferable.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()),
        v$1 ->
          new Transferable.ContractId(v$1.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
        .decode(value$));

  public static final Choice<Service, RequestWithdraw, WithdrawRequest.ContractId> CHOICE_RequestWithdraw = 
      Choice.create("RequestWithdraw", value$ -> value$.toValue(), value$ ->
        RequestWithdraw.valueDecoder().decode(value$), value$ ->
        new WithdrawRequest.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, RequestSwap, SwapRequest.ContractId> CHOICE_RequestSwap = 
      Choice.create("RequestSwap", value$ -> value$.toValue(), value$ -> RequestSwap.valueDecoder()
        .decode(value$), value$ ->
        new SwapRequest.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Service, AtomicSwapGarage, Tuple2<Transferable.ContractId, Transferable.ContractId>> CHOICE_AtomicSwapGarage = 
      Choice.create("AtomicSwapGarage", value$ -> value$.toValue(), value$ ->
        AtomicSwapGarage.valueDecoder().decode(value$), value$ ->
        Tuple2.<daml.daml.finance.interface$.holding.transferable.Transferable.ContractId,
        daml.daml.finance.interface$.holding.transferable.Transferable.ContractId>valueDecoder(v$0 ->
          new Transferable.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()),
        v$1 ->
          new Transferable.ContractId(v$1.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
        .decode(value$));

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
    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapLand(
        AtomicSwapLand arg) {
      return makeExerciseCmd(CHOICE_AtomicSwapLand, arg);
    }

    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapLand(
        String seller, String buyer, AccountKey sellerAccount,
        Transferable.ContractId transferableHoldingCid, SwapRequest.ContractId transferRequestCid,
        PropertyKey propertyKey) {
      return exerciseAtomicSwapLand(new AtomicSwapLand(seller, buyer, sellerAccount,
          transferableHoldingCid, transferRequestCid, propertyKey));
    }

    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapResidence(
        AtomicSwapResidence arg) {
      return makeExerciseCmd(CHOICE_AtomicSwapResidence, arg);
    }

    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapResidence(
        String seller, String buyer, AccountKey sellerAccount,
        Transferable.ContractId transferableHoldingCid, SwapRequest.ContractId transferRequestCid,
        PropertyKey propertyKey) {
      return exerciseAtomicSwapResidence(new AtomicSwapResidence(seller, buyer, sellerAccount,
          transferableHoldingCid, transferRequestCid, propertyKey));
    }

    default Update<Exercised<CloseAccountRequest.ContractId>> exerciseRequestCloseAccount(
        RequestCloseAccount arg) {
      return makeExerciseCmd(CHOICE_RequestCloseAccount, arg);
    }

    default Update<Exercised<CloseAccountRequest.ContractId>> exerciseRequestCloseAccount(
        AccountKey account) {
      return exerciseRequestCloseAccount(new RequestCloseAccount(account));
    }

    default Update<Exercised<OpenAccountRequest.ContractId>> exerciseRequestOpenAccount(
        RequestOpenAccount arg) {
      return makeExerciseCmd(CHOICE_RequestOpenAccount, arg);
    }

    default Update<Exercised<OpenAccountRequest.ContractId>> exerciseRequestOpenAccount(Id id,
        String description, Controllers controllers, Map<String, Set<String>> observers) {
      return exerciseRequestOpenAccount(new RequestOpenAccount(id, description, controllers,
          observers));
    }

    default Update<Exercised<DepositRequest.ContractId>> exerciseRequestDeposit(
        RequestDeposit arg) {
      return makeExerciseCmd(CHOICE_RequestDeposit, arg);
    }

    default Update<Exercised<DepositRequest.ContractId>> exerciseRequestDeposit(
        Quantity<InstrumentKey, BigDecimal> quantity, AccountKey account) {
      return exerciseRequestDeposit(new RequestDeposit(quantity, account));
    }

    default Update<Exercised<Holding.ContractId>> exerciseDeposit(Deposit arg) {
      return makeExerciseCmd(CHOICE_Deposit, arg);
    }

    default Update<Exercised<Holding.ContractId>> exerciseDeposit(
        DepositRequest.ContractId depositRequestCid) {
      return exerciseDeposit(new Deposit(depositRequestCid));
    }

    default Update<Exercised<AccountKey>> exerciseOpenAccount(OpenAccount arg) {
      return makeExerciseCmd(CHOICE_OpenAccount, arg);
    }

    default Update<Exercised<AccountKey>> exerciseOpenAccount(
        OpenAccountRequest.ContractId openAccountRequestCid) {
      return exerciseOpenAccount(new OpenAccount(openAccountRequestCid));
    }

    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapApartment(
        AtomicSwapApartment arg) {
      return makeExerciseCmd(CHOICE_AtomicSwapApartment, arg);
    }

    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapApartment(
        String seller, String buyer, AccountKey sellerAccount,
        Transferable.ContractId transferableHoldingCid, SwapRequest.ContractId transferRequestCid,
        PropertyKey propertyKey) {
      return exerciseAtomicSwapApartment(new AtomicSwapApartment(seller, buyer, sellerAccount,
          transferableHoldingCid, transferRequestCid, propertyKey));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<Unit>> exerciseWithdrawal(Withdrawal arg) {
      return makeExerciseCmd(CHOICE_Withdrawal, arg);
    }

    default Update<Exercised<Unit>> exerciseWithdrawal(
        WithdrawRequest.ContractId withdrawRequestCid) {
      return exerciseWithdrawal(new Withdrawal(withdrawRequestCid));
    }

    default Update<Exercised<Unit>> exerciseCloseAccount(CloseAccount arg) {
      return makeExerciseCmd(CHOICE_CloseAccount, arg);
    }

    default Update<Exercised<Unit>> exerciseCloseAccount(
        CloseAccountRequest.ContractId closeAccountRequestCid) {
      return exerciseCloseAccount(new CloseAccount(closeAccountRequestCid));
    }

    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapWarehouse(
        AtomicSwapWarehouse arg) {
      return makeExerciseCmd(CHOICE_AtomicSwapWarehouse, arg);
    }

    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapWarehouse(
        String seller, String buyer, AccountKey sellerAccount,
        Transferable.ContractId transferableHoldingCid, SwapRequest.ContractId transferRequestCid,
        PropertyKey propertyKey) {
      return exerciseAtomicSwapWarehouse(new AtomicSwapWarehouse(seller, buyer, sellerAccount,
          transferableHoldingCid, transferRequestCid, propertyKey));
    }

    default Update<Exercised<WithdrawRequest.ContractId>> exerciseRequestWithdraw(
        RequestWithdraw arg) {
      return makeExerciseCmd(CHOICE_RequestWithdraw, arg);
    }

    default Update<Exercised<WithdrawRequest.ContractId>> exerciseRequestWithdraw(
        Holding.ContractId holdingCid) {
      return exerciseRequestWithdraw(new RequestWithdraw(holdingCid));
    }

    default Update<Exercised<SwapRequest.ContractId>> exerciseRequestSwap(RequestSwap arg) {
      return makeExerciseCmd(CHOICE_RequestSwap, arg);
    }

    default Update<Exercised<SwapRequest.ContractId>> exerciseRequestSwap(String seller,
        AccountKey sellerAccount, AccountKey buyerAccount,
        Transferable.ContractId fungibleHoldingCid, BigDecimal fungibleAmount) {
      return exerciseRequestSwap(new RequestSwap(seller, sellerAccount, buyerAccount,
          fungibleHoldingCid, fungibleAmount));
    }

    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapGarage(
        AtomicSwapGarage arg) {
      return makeExerciseCmd(CHOICE_AtomicSwapGarage, arg);
    }

    default Update<Exercised<Tuple2<Transferable.ContractId, Transferable.ContractId>>> exerciseAtomicSwapGarage(
        String seller, String buyer, AccountKey sellerAccount,
        Transferable.ContractId transferableHoldingCid, SwapRequest.ContractId transferRequestCid,
        PropertyKey propertyKey) {
      return exerciseAtomicSwapGarage(new AtomicSwapGarage(seller, buyer, sellerAccount,
          transferableHoldingCid, transferRequestCid, propertyKey));
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
            "daml.interface$.custody.service.Service", Service.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_Deposit, CHOICE_RequestDeposit,
            CHOICE_AtomicSwapWarehouse, CHOICE_Withdrawal, CHOICE_AtomicSwapResidence,
            CHOICE_Archive, CHOICE_RequestCloseAccount, CHOICE_AtomicSwapApartment,
            CHOICE_RequestOpenAccount, CHOICE_CloseAccount, CHOICE_AtomicSwapLand,
            CHOICE_OpenAccount, CHOICE_AtomicSwapGarage, CHOICE_RequestSwap,
            CHOICE_RequestWithdraw));
    }
  }
}
