package daml.daml.finance.interface$.lifecycle.election;

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
import daml.daml.finance.interface$.lifecycle.effect.Effect;
import daml.daml.finance.interface$.lifecycle.observable.numericobservable.NumericObservable;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public final class Exercisable {
  public static final Identifier TEMPLATE_ID = new Identifier("b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46", "Daml.Finance.Interface.Lifecycle.Election", "Exercisable");

  public static final Choice<Exercisable, ApplyElection, Tuple2<Optional<InstrumentKey>, List<Effect.ContractId>>> CHOICE_ApplyElection = 
      Choice.create("ApplyElection", value$ -> value$.toValue(), value$ ->
        ApplyElection.valueDecoder().decode(value$), value$ ->
        Tuple2.<java.util.Optional<daml.daml.finance.interface$.types.common.types.InstrumentKey>,
        java.util.List<daml.daml.finance.interface$.lifecycle.effect.Effect.ContractId>>valueDecoder(PrimitiveValueDecoders.fromOptional(
          InstrumentKey.valueDecoder()), PrimitiveValueDecoders.fromList(v$0 ->
            new Effect.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue())))
        .decode(value$));

  public static final Choice<Exercisable, Exercisable_GetView, ExercisableView> CHOICE_Exercisable_GetView = 
      Choice.create("Exercisable_GetView", value$ -> value$.toValue(), value$ ->
        Exercisable_GetView.valueDecoder().decode(value$), value$ -> ExercisableView.valueDecoder()
        .decode(value$));

  public static final Choice<Exercisable, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private Exercisable() {
  }

  public static ContractFilter<Contract<ContractId, ExercisableView>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Exercisable> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Exercisable, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Tuple2<Optional<InstrumentKey>, List<Effect.ContractId>>>> exerciseApplyElection(
        ApplyElection arg) {
      return makeExerciseCmd(CHOICE_ApplyElection, arg);
    }

    default Update<Exercised<Tuple2<Optional<InstrumentKey>, List<Effect.ContractId>>>> exerciseApplyElection(
        Election.ContractId electionCid, List<NumericObservable.ContractId> observableCids) {
      return exerciseApplyElection(new ApplyElection(electionCid, observableCids));
    }

    default Update<Exercised<ExercisableView>> exerciseExercisable_GetView(
        Exercisable_GetView arg) {
      return makeExerciseCmd(CHOICE_Exercisable_GetView, arg);
    }

    default Update<Exercised<ExercisableView>> exerciseExercisable_GetView(String viewer) {
      return exerciseExercisable_GetView(new Exercisable_GetView(viewer));
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
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Exercisable, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Exercisable, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<Exercisable, ContractId, ExercisableView> {
    INTERFACE_() {
      super(
            "daml.daml.finance.interface$.lifecycle.election.Exercisable", Exercisable.TEMPLATE_ID, ContractId::new, ExercisableView.valueDecoder(),
            ExercisableView::fromJson,List.of(CHOICE_ApplyElection, CHOICE_Exercisable_GetView,
            CHOICE_Archive));
    }
  }
}
