package daml.interface$.rolemanager.service;

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
import daml.daml.finance.interface$.types.common.types.Id;
import daml.interface$.common.types.UserRoleKey;
import daml.interface$.rolemanager.userrole.permission.Permission;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;

public final class Service {
  public static final Identifier TEMPLATE_ID = new Identifier("e09e7a18c217e8002e4a374c04915d394e5120e173ac8f1ee6decbc2d8c3c8b4", "Interface.RoleManager.Service", "Service");

  public static final Choice<Service, UpdateUserRole, Unit> CHOICE_UpdateUserRole = 
      Choice.create("UpdateUserRole", value$ -> value$.toValue(), value$ ->
        UpdateUserRole.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, CreateUserRole, UserRoleKey> CHOICE_CreateUserRole = 
      Choice.create("CreateUserRole", value$ -> value$.toValue(), value$ ->
        CreateUserRole.valueDecoder().decode(value$), value$ -> UserRoleKey.valueDecoder()
        .decode(value$));

  public static final Choice<Service, RemovePermissionInUserRole, Unit> CHOICE_RemovePermissionInUserRole = 
      Choice.create("RemovePermissionInUserRole", value$ -> value$.toValue(), value$ ->
        RemovePermissionInUserRole.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, AddPermissionToUserRole, Unit> CHOICE_AddPermissionToUserRole = 
      Choice.create("AddPermissionToUserRole", value$ -> value$.toValue(), value$ ->
        AddPermissionToUserRole.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Service, DeleteUserRole, Unit> CHOICE_DeleteUserRole = 
      Choice.create("DeleteUserRole", value$ -> value$.toValue(), value$ ->
        DeleteUserRole.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Service, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

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
    default Update<Exercised<Unit>> exerciseUpdateUserRole(UpdateUserRole arg) {
      return makeExerciseCmd(CHOICE_UpdateUserRole, arg);
    }

    default Update<Exercised<Unit>> exerciseUpdateUserRole(UserRoleKey userRole,
        List<Permission> permissions) {
      return exerciseUpdateUserRole(new UpdateUserRole(userRole, permissions));
    }

    default Update<Exercised<UserRoleKey>> exerciseCreateUserRole(CreateUserRole arg) {
      return makeExerciseCmd(CHOICE_CreateUserRole, arg);
    }

    default Update<Exercised<UserRoleKey>> exerciseCreateUserRole(Id id, String description,
        List<Permission> permissions, Map<String, Set<String>> observers) {
      return exerciseCreateUserRole(new CreateUserRole(id, description, permissions, observers));
    }

    default Update<Exercised<Unit>> exerciseRemovePermissionInUserRole(
        RemovePermissionInUserRole arg) {
      return makeExerciseCmd(CHOICE_RemovePermissionInUserRole, arg);
    }

    default Update<Exercised<Unit>> exerciseRemovePermissionInUserRole(UserRoleKey userRole,
        Permission permission) {
      return exerciseRemovePermissionInUserRole(new RemovePermissionInUserRole(userRole,
          permission));
    }

    default Update<Exercised<Unit>> exerciseAddPermissionToUserRole(AddPermissionToUserRole arg) {
      return makeExerciseCmd(CHOICE_AddPermissionToUserRole, arg);
    }

    default Update<Exercised<Unit>> exerciseAddPermissionToUserRole(UserRoleKey userRole,
        Permission permission) {
      return exerciseAddPermissionToUserRole(new AddPermissionToUserRole(userRole, permission));
    }

    default Update<Exercised<Unit>> exerciseDeleteUserRole(DeleteUserRole arg) {
      return makeExerciseCmd(CHOICE_DeleteUserRole, arg);
    }

    default Update<Exercised<Unit>> exerciseDeleteUserRole(UserRoleKey userRole) {
      return exerciseDeleteUserRole(new DeleteUserRole(userRole));
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
            "daml.interface$.rolemanager.service.Service", Service.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_UpdateUserRole, CHOICE_DeleteUserRole,
            CHOICE_AddPermissionToUserRole, CHOICE_Archive, CHOICE_RemovePermissionInUserRole,
            CHOICE_CreateUserRole));
    }
  }
}
