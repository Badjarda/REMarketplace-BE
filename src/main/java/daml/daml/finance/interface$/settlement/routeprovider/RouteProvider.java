package daml.daml.finance.interface$.settlement.routeprovider;

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
import daml.daml.finance.interface$.settlement.types.RoutedStep;
import daml.daml.finance.interface$.settlement.types.Step;
import daml.daml.finance.interface$.types.common.types.Id;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public final class RouteProvider {
  public static final Identifier TEMPLATE_ID = new Identifier("388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5", "Daml.Finance.Interface.Settlement.RouteProvider", "RouteProvider");

  public static final Choice<RouteProvider, GetView, View> CHOICE_GetView = 
      Choice.create("GetView", value$ -> value$.toValue(), value$ -> GetView.valueDecoder()
        .decode(value$), value$ -> View.valueDecoder().decode(value$));

  public static final Choice<RouteProvider, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<RouteProvider, Discover, List<RoutedStep>> CHOICE_Discover = 
      Choice.create("Discover", value$ -> value$.toValue(), value$ -> Discover.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromList(RoutedStep.valueDecoder())
        .decode(value$));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private RouteProvider() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<RouteProvider> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, RouteProvider, ?> getCompanion(
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

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<List<RoutedStep>>> exerciseDiscover(Discover arg) {
      return makeExerciseCmd(CHOICE_Discover, arg);
    }

    default Update<Exercised<List<RoutedStep>>> exerciseDiscover(Set<String> discoverors,
        Optional<Id> contextId, List<Step> steps) {
      return exerciseDiscover(new Discover(discoverors, contextId, steps));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, RouteProvider, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, RouteProvider, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<RouteProvider, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.daml.finance.interface$.settlement.routeprovider.RouteProvider", RouteProvider.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_GetView, CHOICE_Archive, CHOICE_Discover));
    }
  }
}
