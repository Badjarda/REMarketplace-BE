package daml.daml.finance.interface$.lifecycle.rule.lifecycle;

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
import daml.daml.finance.interface$.lifecycle.event.Event;
import daml.daml.finance.interface$.lifecycle.observable.numericobservable.NumericObservable;
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public final class Lifecycle {
  public static final Identifier TEMPLATE_ID = new Identifier("b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46", "Daml.Finance.Interface.Lifecycle.Rule.Lifecycle", "Lifecycle");

  public static final Choice<Lifecycle, Evolve, Tuple2<Optional<InstrumentKey>, List<Effect.ContractId>>> CHOICE_Evolve = 
      Choice.create("Evolve", value$ -> value$.toValue(), value$ -> Evolve.valueDecoder()
        .decode(value$), value$ ->
        Tuple2.<java.util.Optional<daml.daml.finance.interface$.types.common.types.InstrumentKey>,
        java.util.List<daml.daml.finance.interface$.lifecycle.effect.Effect.ContractId>>valueDecoder(PrimitiveValueDecoders.fromOptional(
          InstrumentKey.valueDecoder()), PrimitiveValueDecoders.fromList(v$0 ->
            new Effect.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue())))
        .decode(value$));

  public static final Choice<Lifecycle, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<Lifecycle, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private Lifecycle() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Lifecycle> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Lifecycle, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Tuple2<Optional<InstrumentKey>, List<Effect.ContractId>>>> exerciseEvolve(
        Evolve arg) {
      return makeExerciseCmd(CHOICE_Evolve, arg);
    }

    default Update<Exercised<Tuple2<Optional<InstrumentKey>, List<Effect.ContractId>>>> exerciseEvolve(
        Event.ContractId eventCid, InstrumentKey instrument,
        List<NumericObservable.ContractId> observableCids) {
      return exerciseEvolve(new Evolve(eventCid, instrument, observableCids));
    }

    default Update<Exercised<View>> exerciseGetView(GetView arg) {
      return makeExerciseCmd(CHOICE_GetView, arg);
    }

    default Update<Exercised<View>> exerciseGetView(String viewer) {
      return exerciseGetView(new GetView(viewer));
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
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Lifecycle, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Lifecycle, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<Lifecycle, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.daml.finance.interface$.lifecycle.rule.lifecycle.Lifecycle", Lifecycle.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_Evolve, CHOICE_GetView, CHOICE_Archive));
    }
  }
}
