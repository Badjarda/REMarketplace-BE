package daml.interface$.propertymanager.service;

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
import daml.interface$.propertymanager.property.apartmentproperty.factory.Factory;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public final class Request {
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.PropertyManager.Service", "Request");

  public static final Choice<Request, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Request, Cancel, Unit> CHOICE_Cancel = 
      Choice.create("Cancel", value$ -> value$.toValue(), value$ -> Cancel.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Request, Reject, Unit> CHOICE_Reject = 
      Choice.create("Reject", value$ -> value$.toValue(), value$ -> Reject.valueDecoder()
        .decode(value$), value$ -> PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Request, Approve, Service.ContractId> CHOICE_Approve = 
      Choice.create("Approve", value$ -> value$.toValue(), value$ -> Approve.valueDecoder()
        .decode(value$), value$ ->
        new Service.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private Request() {
  }

  public static ContractFilter<Contract<ContractId, RView>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Request> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Request, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<Unit>> exerciseCancel(Cancel arg) {
      return makeExerciseCmd(CHOICE_Cancel, arg);
    }

    default Update<Exercised<Unit>> exerciseCancel() {
      return exerciseCancel(new Cancel());
    }

    default Update<Exercised<Unit>> exerciseReject(Reject arg) {
      return makeExerciseCmd(CHOICE_Reject, arg);
    }

    default Update<Exercised<Unit>> exerciseReject() {
      return exerciseReject(new Reject());
    }

    default Update<Exercised<Service.ContractId>> exerciseApprove(Approve arg) {
      return makeExerciseCmd(CHOICE_Approve, arg);
    }

    default Update<Exercised<Service.ContractId>> exerciseApprove(String operator,
        Factory.ContractId apartmentPropertyFactoryCid,
        daml.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid,
        daml.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid,
        daml.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid,
        daml.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid) {
      return exerciseApprove(new Approve(operator, apartmentPropertyFactoryCid,
          landPropertyFactoryCid, residencePropertyFactoryCid, garagePropertyFactoryCid,
          warehousePropertyFactoryCid));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Request, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Request, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<Request, ContractId, RView> {
    INTERFACE_() {
      super(
            "daml.interface$.propertymanager.service.Request", Request.TEMPLATE_ID, ContractId::new, RView.valueDecoder(),
            RView::fromJson,List.of(CHOICE_Archive, CHOICE_Cancel, CHOICE_Reject, CHOICE_Approve));
    }
  }
}
