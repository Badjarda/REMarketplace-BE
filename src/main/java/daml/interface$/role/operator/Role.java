package daml.interface$.role.operator;

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
import daml.daml.finance.interface$.lifecycle.rule.claim.Claim;
import daml.daml.finance.interface$.types.common.types.HoldingFactoryKey;
import daml.interface$.common.types.UserRoleKey;
import daml.interface$.issuance.service.Offer;
import daml.interface$.issuance.service.Request;
import daml.interface$.issuance.service.Service;
import daml.interface$.propertymanager.property.apartmentproperty.factory.Factory;
import daml.interface$.rolemanager.userrole.permission.Permission;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;

public final class Role {
  public static final Identifier TEMPLATE_ID = new Identifier("8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1", "Interface.Role.Operator", "Role");

  public static final Choice<Role, TerminateCustodianService, Unit> CHOICE_TerminateCustodianService = 
      Choice.create("TerminateCustodianService", value$ -> value$.toValue(), value$ ->
        TerminateCustodianService.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Role, OfferIssuanceService, Offer.ContractId> CHOICE_OfferIssuanceService = 
      Choice.create("OfferIssuanceService", value$ -> value$.toValue(), value$ ->
        OfferIssuanceService.valueDecoder().decode(value$), value$ ->
        new Offer.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, ApproveIssuanceRequest, Service.ContractId> CHOICE_ApproveIssuanceRequest = 
      Choice.create("ApproveIssuanceRequest", value$ -> value$.toValue(), value$ ->
        ApproveIssuanceRequest.valueDecoder().decode(value$), value$ ->
        new Service.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, ApprovePropertyManagerRequest, daml.interface$.propertymanager.service.Service.ContractId> CHOICE_ApprovePropertyManagerRequest = 
      Choice.create("ApprovePropertyManagerRequest", value$ -> value$.toValue(), value$ ->
        ApprovePropertyManagerRequest.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.service.Service.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, TerminatePropertyManagerService, Unit> CHOICE_TerminatePropertyManagerService = 
      Choice.create("TerminatePropertyManagerService", value$ -> value$.toValue(), value$ ->
        TerminatePropertyManagerService.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Role, ApproveUserProfileManagerRequest, daml.interface$.profilemanager.service.Service.ContractId> CHOICE_ApproveUserProfileManagerRequest = 
      Choice.create("ApproveUserProfileManagerRequest", value$ -> value$.toValue(), value$ ->
        ApproveUserProfileManagerRequest.valueDecoder().decode(value$), value$ ->
        new daml.interface$.profilemanager.service.Service.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, OfferUserProfileManagerService, daml.interface$.profilemanager.service.Offer.ContractId> CHOICE_OfferUserProfileManagerService = 
      Choice.create("OfferUserProfileManagerService", value$ -> value$.toValue(), value$ ->
        OfferUserProfileManagerService.valueDecoder().decode(value$), value$ ->
        new daml.interface$.profilemanager.service.Offer.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, CreateInitialRole, UserRoleKey> CHOICE_CreateInitialRole = 
      Choice.create("CreateInitialRole", value$ -> value$.toValue(), value$ ->
        CreateInitialRole.valueDecoder().decode(value$), value$ -> UserRoleKey.valueDecoder()
        .decode(value$));

  public static final Choice<Role, TerminateUserRoleManagerService, Unit> CHOICE_TerminateUserRoleManagerService = 
      Choice.create("TerminateUserRoleManagerService", value$ -> value$.toValue(), value$ ->
        TerminateUserRoleManagerService.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Role, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Role, OfferCustodianService, daml.interface$.custody.service.Offer.ContractId> CHOICE_OfferCustodianService = 
      Choice.create("OfferCustodianService", value$ -> value$.toValue(), value$ ->
        OfferCustodianService.valueDecoder().decode(value$), value$ ->
        new daml.interface$.custody.service.Offer.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, OfferUserRoleManagerService, daml.interface$.rolemanager.service.Offer.ContractId> CHOICE_OfferUserRoleManagerService = 
      Choice.create("OfferUserRoleManagerService", value$ -> value$.toValue(), value$ ->
        OfferUserRoleManagerService.valueDecoder().decode(value$), value$ ->
        new daml.interface$.rolemanager.service.Offer.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, TerminateUserProfileManagerService, Unit> CHOICE_TerminateUserProfileManagerService = 
      Choice.create("TerminateUserProfileManagerService", value$ -> value$.toValue(), value$ ->
        TerminateUserProfileManagerService.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Role, OfferUserRole, daml.interface$.role.user.Offer.ContractId> CHOICE_OfferUserRole = 
      Choice.create("OfferUserRole", value$ -> value$.toValue(), value$ ->
        OfferUserRole.valueDecoder().decode(value$), value$ ->
        new daml.interface$.role.user.Offer.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, ApproveCustodianRequest, daml.interface$.custody.service.Service.ContractId> CHOICE_ApproveCustodianRequest = 
      Choice.create("ApproveCustodianRequest", value$ -> value$.toValue(), value$ ->
        ApproveCustodianRequest.valueDecoder().decode(value$), value$ ->
        new daml.interface$.custody.service.Service.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, OfferPropertyManagerService, daml.interface$.propertymanager.service.Offer.ContractId> CHOICE_OfferPropertyManagerService = 
      Choice.create("OfferPropertyManagerService", value$ -> value$.toValue(), value$ ->
        OfferPropertyManagerService.valueDecoder().decode(value$), value$ ->
        new daml.interface$.propertymanager.service.Offer.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, TerminateRole, Unit> CHOICE_TerminateRole = 
      Choice.create("TerminateRole", value$ -> value$.toValue(), value$ ->
        TerminateRole.valueDecoder().decode(value$), value$ -> PrimitiveValueDecoders.fromUnit
        .decode(value$));

  public static final Choice<Role, TerminateIssuanceService, Unit> CHOICE_TerminateIssuanceService = 
      Choice.create("TerminateIssuanceService", value$ -> value$.toValue(), value$ ->
        TerminateIssuanceService.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final Choice<Role, ApproveUserRole, daml.interface$.role.user.Role.ContractId> CHOICE_ApproveUserRole = 
      Choice.create("ApproveUserRole", value$ -> value$.toValue(), value$ ->
        ApproveUserRole.valueDecoder().decode(value$), value$ ->
        new daml.interface$.role.user.Role.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final Choice<Role, ApproveUserRoleManagerRequest, daml.interface$.rolemanager.service.Service.ContractId> CHOICE_ApproveUserRoleManagerRequest = 
      Choice.create("ApproveUserRoleManagerRequest", value$ -> value$.toValue(), value$ ->
        ApproveUserRoleManagerRequest.valueDecoder().decode(value$), value$ ->
        new daml.interface$.rolemanager.service.Service.ContractId(value$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected value$ to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()));

  public static final INTERFACE_ INTERFACE = new INTERFACE_();

  private Role() {
  }

  public static ContractFilter<Contract<ContractId, View>> contractFilter() {
    return ContractFilter.of(INTERFACE);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Role> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Role, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Unit>> exerciseTerminateCustodianService(
        TerminateCustodianService arg) {
      return makeExerciseCmd(CHOICE_TerminateCustodianService, arg);
    }

    default Update<Exercised<Unit>> exerciseTerminateCustodianService(String user) {
      return exerciseTerminateCustodianService(new TerminateCustodianService(user));
    }

    default Update<Exercised<Offer.ContractId>> exerciseOfferIssuanceService(
        OfferIssuanceService arg) {
      return makeExerciseCmd(CHOICE_OfferIssuanceService, arg);
    }

    default Update<Exercised<Offer.ContractId>> exerciseOfferIssuanceService(String user) {
      return exerciseOfferIssuanceService(new OfferIssuanceService(user));
    }

    default Update<Exercised<Service.ContractId>> exerciseApproveIssuanceRequest(
        ApproveIssuanceRequest arg) {
      return makeExerciseCmd(CHOICE_ApproveIssuanceRequest, arg);
    }

    default Update<Exercised<Service.ContractId>> exerciseApproveIssuanceRequest(
        Request.ContractId issuanceServiceRequestCid) {
      return exerciseApproveIssuanceRequest(new ApproveIssuanceRequest(issuanceServiceRequestCid));
    }

    default Update<Exercised<daml.interface$.propertymanager.service.Service.ContractId>> exerciseApprovePropertyManagerRequest(
        ApprovePropertyManagerRequest arg) {
      return makeExerciseCmd(CHOICE_ApprovePropertyManagerRequest, arg);
    }

    default Update<Exercised<daml.interface$.propertymanager.service.Service.ContractId>> exerciseApprovePropertyManagerRequest(
        daml.interface$.propertymanager.service.Request.ContractId propertyManagerServiceRequestCid,
        Factory.ContractId apartmentPropertyFactoryCid,
        daml.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid,
        daml.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid,
        daml.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid,
        daml.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid) {
      return exerciseApprovePropertyManagerRequest(new ApprovePropertyManagerRequest(propertyManagerServiceRequestCid,
          apartmentPropertyFactoryCid, landPropertyFactoryCid, residencePropertyFactoryCid,
          garagePropertyFactoryCid, warehousePropertyFactoryCid));
    }

    default Update<Exercised<Unit>> exerciseTerminatePropertyManagerService(
        TerminatePropertyManagerService arg) {
      return makeExerciseCmd(CHOICE_TerminatePropertyManagerService, arg);
    }

    default Update<Exercised<Unit>> exerciseTerminatePropertyManagerService(String user) {
      return exerciseTerminatePropertyManagerService(new TerminatePropertyManagerService(user));
    }

    default Update<Exercised<daml.interface$.profilemanager.service.Service.ContractId>> exerciseApproveUserProfileManagerRequest(
        ApproveUserProfileManagerRequest arg) {
      return makeExerciseCmd(CHOICE_ApproveUserProfileManagerRequest, arg);
    }

    default Update<Exercised<daml.interface$.profilemanager.service.Service.ContractId>> exerciseApproveUserProfileManagerRequest(
        daml.interface$.profilemanager.service.Request.ContractId userProfileManagerServiceRequestCid,
        daml.interface$.profilemanager.userprofile.factory.Factory.ContractId userProfileFactoryCid) {
      return exerciseApproveUserProfileManagerRequest(new ApproveUserProfileManagerRequest(userProfileManagerServiceRequestCid,
          userProfileFactoryCid));
    }

    default Update<Exercised<daml.interface$.profilemanager.service.Offer.ContractId>> exerciseOfferUserProfileManagerService(
        OfferUserProfileManagerService arg) {
      return makeExerciseCmd(CHOICE_OfferUserProfileManagerService, arg);
    }

    default Update<Exercised<daml.interface$.profilemanager.service.Offer.ContractId>> exerciseOfferUserProfileManagerService(
        String user,
        daml.interface$.profilemanager.userprofile.factory.Factory.ContractId userProfileFactoryCid) {
      return exerciseOfferUserProfileManagerService(new OfferUserProfileManagerService(user,
          userProfileFactoryCid));
    }

    default Update<Exercised<UserRoleKey>> exerciseCreateInitialRole(CreateInitialRole arg) {
      return makeExerciseCmd(CHOICE_CreateInitialRole, arg);
    }

    default Update<Exercised<UserRoleKey>> exerciseCreateInitialRole(String userDescription,
        List<Permission> userPermissions, Map<String, Set<String>> observers) {
      return exerciseCreateInitialRole(new CreateInitialRole(userDescription, userPermissions,
          observers));
    }

    default Update<Exercised<Unit>> exerciseTerminateUserRoleManagerService(
        TerminateUserRoleManagerService arg) {
      return makeExerciseCmd(CHOICE_TerminateUserRoleManagerService, arg);
    }

    default Update<Exercised<Unit>> exerciseTerminateUserRoleManagerService(String user) {
      return exerciseTerminateUserRoleManagerService(new TerminateUserRoleManagerService(user));
    }

    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }

    default Update<Exercised<daml.interface$.custody.service.Offer.ContractId>> exerciseOfferCustodianService(
        OfferCustodianService arg) {
      return makeExerciseCmd(CHOICE_OfferCustodianService, arg);
    }

    default Update<Exercised<daml.interface$.custody.service.Offer.ContractId>> exerciseOfferCustodianService(
        String user,
        daml.daml.finance.interface$.account.factory.Factory.ContractId accountFactoryCid,
        HoldingFactoryKey holdingFactoryKey, Claim.ContractId claimRuleCid) {
      return exerciseOfferCustodianService(new OfferCustodianService(user, accountFactoryCid,
          holdingFactoryKey, claimRuleCid));
    }

    default Update<Exercised<daml.interface$.rolemanager.service.Offer.ContractId>> exerciseOfferUserRoleManagerService(
        OfferUserRoleManagerService arg) {
      return makeExerciseCmd(CHOICE_OfferUserRoleManagerService, arg);
    }

    default Update<Exercised<daml.interface$.rolemanager.service.Offer.ContractId>> exerciseOfferUserRoleManagerService(
        String user,
        daml.interface$.rolemanager.userrole.factory.Factory.ContractId userRoleFactoryCid) {
      return exerciseOfferUserRoleManagerService(new OfferUserRoleManagerService(user,
          userRoleFactoryCid));
    }

    default Update<Exercised<Unit>> exerciseTerminateUserProfileManagerService(
        TerminateUserProfileManagerService arg) {
      return makeExerciseCmd(CHOICE_TerminateUserProfileManagerService, arg);
    }

    default Update<Exercised<Unit>> exerciseTerminateUserProfileManagerService(String user) {
      return exerciseTerminateUserProfileManagerService(new TerminateUserProfileManagerService(user));
    }

    default Update<Exercised<daml.interface$.role.user.Offer.ContractId>> exerciseOfferUserRole(
        OfferUserRole arg) {
      return makeExerciseCmd(CHOICE_OfferUserRole, arg);
    }

    default Update<Exercised<daml.interface$.role.user.Offer.ContractId>> exerciseOfferUserRole(
        String user, UserRoleKey userRole) {
      return exerciseOfferUserRole(new OfferUserRole(user, userRole));
    }

    default Update<Exercised<daml.interface$.custody.service.Service.ContractId>> exerciseApproveCustodianRequest(
        ApproveCustodianRequest arg) {
      return makeExerciseCmd(CHOICE_ApproveCustodianRequest, arg);
    }

    default Update<Exercised<daml.interface$.custody.service.Service.ContractId>> exerciseApproveCustodianRequest(
        daml.interface$.custody.service.Request.ContractId custodyServiceRequestCid,
        daml.daml.finance.interface$.account.factory.Factory.ContractId accountFactoryCid,
        HoldingFactoryKey holdingFactoryKey, Claim.ContractId claimRuleCid) {
      return exerciseApproveCustodianRequest(new ApproveCustodianRequest(custodyServiceRequestCid,
          accountFactoryCid, holdingFactoryKey, claimRuleCid));
    }

    default Update<Exercised<daml.interface$.propertymanager.service.Offer.ContractId>> exerciseOfferPropertyManagerService(
        OfferPropertyManagerService arg) {
      return makeExerciseCmd(CHOICE_OfferPropertyManagerService, arg);
    }

    default Update<Exercised<daml.interface$.propertymanager.service.Offer.ContractId>> exerciseOfferPropertyManagerService(
        String user, Factory.ContractId apartmentPropertyFactoryCid,
        daml.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid,
        daml.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid,
        daml.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid,
        daml.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid) {
      return exerciseOfferPropertyManagerService(new OfferPropertyManagerService(user,
          apartmentPropertyFactoryCid, landPropertyFactoryCid, residencePropertyFactoryCid,
          garagePropertyFactoryCid, warehousePropertyFactoryCid));
    }

    default Update<Exercised<Unit>> exerciseTerminateRole(TerminateRole arg) {
      return makeExerciseCmd(CHOICE_TerminateRole, arg);
    }

    default Update<Exercised<Unit>> exerciseTerminateRole() {
      return exerciseTerminateRole(new TerminateRole());
    }

    default Update<Exercised<Unit>> exerciseTerminateIssuanceService(TerminateIssuanceService arg) {
      return makeExerciseCmd(CHOICE_TerminateIssuanceService, arg);
    }

    default Update<Exercised<Unit>> exerciseTerminateIssuanceService(String user) {
      return exerciseTerminateIssuanceService(new TerminateIssuanceService(user));
    }

    default Update<Exercised<daml.interface$.role.user.Role.ContractId>> exerciseApproveUserRole(
        ApproveUserRole arg) {
      return makeExerciseCmd(CHOICE_ApproveUserRole, arg);
    }

    default Update<Exercised<daml.interface$.role.user.Role.ContractId>> exerciseApproveUserRole(
        daml.interface$.role.user.Request.ContractId userRoleRequestCid, UserRoleKey userRole) {
      return exerciseApproveUserRole(new ApproveUserRole(userRoleRequestCid, userRole));
    }

    default Update<Exercised<daml.interface$.rolemanager.service.Service.ContractId>> exerciseApproveUserRoleManagerRequest(
        ApproveUserRoleManagerRequest arg) {
      return makeExerciseCmd(CHOICE_ApproveUserRoleManagerRequest, arg);
    }

    default Update<Exercised<daml.interface$.rolemanager.service.Service.ContractId>> exerciseApproveUserRoleManagerRequest(
        daml.interface$.rolemanager.service.Request.ContractId userRoleManagerServiceRequestCid,
        daml.interface$.rolemanager.userrole.factory.Factory.ContractId userRoleFactoryCid) {
      return exerciseApproveUserRoleManagerRequest(new ApproveUserRoleManagerRequest(userRoleManagerServiceRequestCid,
          userRoleFactoryCid));
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd.ToInterface implements Exercises<CreateAndExerciseCommand> {
    public CreateAnd(ContractCompanion<?, ?, ?> companion, Template createArguments) {
      super(companion, createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Role, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey.ToInterface implements Exercises<ExerciseByKeyCommand> {
    public ByKey(ContractCompanion<?, ?, ?> companion, Value key) {
      super(companion, key);
    }

    @Override
    protected ContractTypeCompanion<? extends Contract<ContractId, ?>, ContractId, Role, ?> getCompanion(
        ) {
      return INTERFACE;
    }
  }

  public static final class INTERFACE_ extends InterfaceCompanion<Role, ContractId, View> {
    INTERFACE_() {
      super(
            "daml.interface$.role.operator.Role", Role.TEMPLATE_ID, ContractId::new, View.valueDecoder(),
            View::fromJson,List.of(CHOICE_OfferIssuanceService, CHOICE_ApproveUserRole,
            CHOICE_TerminateUserRoleManagerService, CHOICE_OfferUserRole,
            CHOICE_ApprovePropertyManagerRequest, CHOICE_TerminatePropertyManagerService,
            CHOICE_OfferUserProfileManagerService, CHOICE_OfferCustodianService,
            CHOICE_OfferUserRoleManagerService, CHOICE_OfferPropertyManagerService,
            CHOICE_TerminateUserProfileManagerService, CHOICE_CreateInitialRole,
            CHOICE_TerminateRole, CHOICE_TerminateIssuanceService, CHOICE_TerminateCustodianService,
            CHOICE_ApproveUserRoleManagerRequest, CHOICE_ApproveCustodianRequest, CHOICE_Archive,
            CHOICE_ApproveIssuanceRequest, CHOICE_ApproveUserProfileManagerRequest));
    }
  }
}
