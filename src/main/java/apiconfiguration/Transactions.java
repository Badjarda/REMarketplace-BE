package apiconfiguration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.daml.ledger.api.v1.EventOuterClass.CreatedEvent;
import com.daml.ledger.api.v1.EventOuterClass.Event;
import com.daml.ledger.api.v1.TransactionOuterClass;
import com.daml.ledger.api.v1.TransactionServiceOuterClass;
import com.daml.ledger.api.v1.ValueOuterClass;
import com.daml.ledger.api.v1.ValueOuterClass.Identifier;
import com.daml.ledger.javaapi.data.CommandsSubmission;
import com.daml.ledger.rxjava.DamlLedgerClient;
import com.daml.ledger.api.v1.EventOuterClass.ArchivedEvent;

import business.DamlLedgerClientProvider;
import business.custody.entity.model.AccountFactory;
import business.custody.entity.model.HoldingFactory;
import business.custody.entity.model.RouteProvider;
import business.custody.entity.model.SettlementFactory;
import business.custody.entity.model.ClaimRule;
import business.custody.entity.model.CustodyManager;
import business.custody.entity.repository.AccountFactoryRepository;
import business.custody.entity.repository.ClaimRuleRepository;
import business.custody.entity.repository.CustodyManagerRepository;
import business.custody.entity.repository.HoldingFactoryRepository;
import business.custody.entity.repository.RouteProviderRepository;
import business.custody.entity.repository.SettlementFactoryRepository;
import business.custody.service.AccountManagerService;
import business.issuance.entity.model.IssuanceManager;
import business.issuance.entity.repository.IssuanceManagerRepository;
import business.issuer.entity.model.DeIssueRequest;
import business.issuer.entity.model.IssuanceServiceOffer;
import business.issuer.entity.model.IssueRequest;
import business.issuer.entity.repository.DeIssueRequestRepository;
import business.issuer.entity.repository.IssuanceServiceOfferRepository;
import business.issuer.entity.repository.IssueRequestRepository;
import business.issuer.service.IssuanceService;
import business.operator.entity.model.Operator;

import business.operator.entity.repository.OperatorRepository;
import business.operator.service.OperatorService;
import business.party.entity.repository.PartyRepository;
import business.party.service.PartyService;
import business.rolemanager.entity.model.UserRoleFactory;
import business.rolemanager.entity.model.UserRoleManager;
import business.rolemanager.entity.repository.UserRoleFactoryRepository;
import business.rolemanager.entity.repository.UserRoleManagerRepository;
import business.rolemanager.service.RoleManagerService;
import business.user.service.UserService;
import business.useraccount.dto.SwapRequestGETDTO;
import business.useraccount.entity.model.CustodyServiceOffer;
import business.useraccount.entity.model.HoldingFactoryInterface;
import business.useraccount.entity.model.UserAccount;
import business.useraccount.entity.model.UserAccountCloseRequest;
import business.useraccount.entity.model.UserAccountCreateRequest;
import business.useraccount.entity.model.UserAccountDepositRequest;
import business.useraccount.entity.model.UserAccountInterface;
import business.useraccount.entity.model.UserAccountWithdrawRequest;
import business.useraccount.entity.model.UserHoldingFungible;
import business.useraccount.entity.model.UserHoldingTransferable;
import business.useraccount.entity.model.UserSwapRequest;
import business.useraccount.entity.repository.CustodyServiceOfferRepository;
import business.useraccount.entity.repository.HoldingFactoryInterfaceRepository;
import business.useraccount.entity.repository.UserAccountCloseRequestRepository;
import business.useraccount.entity.repository.UserAccountCreateRequestRepository;
import business.useraccount.entity.repository.UserAccountDepositRequestRepository;
import business.useraccount.entity.repository.UserAccountInterfaceRepository;
import business.useraccount.entity.repository.UserAccountRepository;
import business.useraccount.entity.repository.UserAccountWithdrawRequestRepository;
import business.useraccount.entity.repository.UserHoldingFungibleRepository;
import business.useraccount.entity.repository.UserHoldingTransferableRepository;
import business.useraccount.entity.repository.UserSwapRequestRepository;
import business.useraccount.service.UserAccountService;
import business.userprofile.entity.model.ProfileServiceOffer;
import business.userprofile.entity.model.UserProfile;
import business.userprofile.entity.model.UserProfileCreateRequest;
import business.userprofile.entity.model.UserProfileReferenceInterface;
import business.userprofile.entity.repository.ProfileServiceOfferRepository;
import business.userprofile.entity.repository.UserProfileCreateRequestRepository;
import business.userprofile.entity.repository.UserProfileReferenceInterfaceRepository;
import business.userprofile.entity.repository.UserProfileRepository;
import business.userprofile.service.UserProfileService;
import business.userproperty.entity.model.ApartmentProperty;
import business.userproperty.entity.model.ApartmentPropertyInterfaceReference;
import business.userproperty.entity.model.GarageProperty;
import business.userproperty.entity.model.GaragePropertyInterfaceReference;
import business.userproperty.entity.model.LandProperty;
import business.userproperty.entity.model.LandPropertyInterfaceReference;
import business.userproperty.entity.model.PropertyServiceOffer;
import business.userproperty.entity.model.RequestCreateApartment;
import business.userproperty.entity.model.RequestCreateGarage;
import business.userproperty.entity.model.RequestCreateLand;
import business.userproperty.entity.model.RequestCreateResidence;
import business.userproperty.entity.model.RequestCreateWarehouse;
import business.userproperty.entity.model.ResidenceProperty;
import business.userproperty.entity.model.ResidencePropertyInterfaceReference;
import business.userproperty.entity.model.WarehouseProperty;
import business.userproperty.entity.model.WarehousePropertyInterfaceReference;
import business.userproperty.entity.repository.ApartmentPropertyInterfaceReferenceRepository;
import business.userproperty.entity.repository.GaragePropertyInterfaceReferenceRepository;
import business.userproperty.entity.repository.LandPropertyInterfaceReferenceRepository;
import business.userproperty.entity.repository.ResidencePropertyInterfaceReferenceRepository;
import business.userproperty.entity.repository.WarehousePropertyInterfaceReferenceRepository;
import business.userproperty.entity.repository.ApartmentPropertyRepository;
import business.userproperty.entity.repository.GaragePropertyRepository;
import business.userproperty.entity.repository.LandPropertyRepository;
import business.userproperty.entity.repository.PropertyServiceOfferRepository;
import business.userproperty.entity.repository.RequestCreateApartmentRepository;
import business.userproperty.entity.repository.RequestCreateGarageRepository;
import business.userproperty.entity.repository.RequestCreateLandRepository;
import business.userproperty.entity.repository.RequestCreateResidenceRepository;
import business.userproperty.entity.repository.RequestCreateWarehouseRepository;
import business.userproperty.entity.repository.ResidencePropertyRepository;
import business.userproperty.entity.repository.WarehousePropertyRepository;
import business.userproperty.service.UserPropertyService;
import business.userrole.entity.model.CredentialApp;
import business.userrole.entity.model.UserRole;
import business.userrole.entity.model.UserRoleApp;
import business.userrole.entity.model.UserRoleInterface;
import business.userrole.entity.model.UserRoleOffer;
import business.userrole.entity.repository.CredentialAppRepository;
import business.userrole.entity.repository.UserRoleAppRepository;
import business.userrole.entity.repository.UserRoleInterfaceRepository;
import business.userrole.entity.repository.UserRoleOfferRepository;
import business.userrole.entity.repository.UserRoleRepository;
import business.userrole.service.UserRoleService;
import business.profilemanager.entity.model.UserProfileFactory;
import business.profilemanager.entity.model.UserProfileManager;
import business.profilemanager.entity.repository.UserProfileFactoryRepository;
import business.profilemanager.entity.repository.UserProfileManagerRepository;
import business.profilemanager.service.ProfileManagerService;
import business.propertymanager.entity.model.ApartmentPropertyFactory;
import business.propertymanager.entity.repository.ApartmentPropertyFactoryRepository;
import business.propertymanager.entity.model.GaragePropertyFactory;
import business.propertymanager.entity.repository.GaragePropertyFactoryRepository;
import business.propertymanager.entity.model.LandPropertyFactory;
import business.propertymanager.entity.model.PropertyManager;
import business.propertymanager.entity.repository.LandPropertyFactoryRepository;
import business.propertymanager.entity.repository.PropertyManagerRepository;
import business.propertymanager.entity.model.ResidencePropertyFactory;
import business.propertymanager.entity.repository.ResidencePropertyFactoryRepository;
import business.propertymanager.entity.model.WarehousePropertyFactory;
import business.propertymanager.entity.repository.WarehousePropertyFactoryRepository;
import business.propertymanager.service.PropertyManagerService;
import daml.marketplace.app.role.operator.Role;
import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;
import daml.marketplace.interface$.propertymanager.property.common.GarageType;
import daml.marketplace.interface$.propertymanager.property.common.LandType;
import daml.marketplace.interface$.propertymanager.property.common.Orientation;
import daml.marketplace.interface$.propertymanager.property.common.Parking;
import daml.marketplace.interface$.propertymanager.property.common.ViableConstructionTypes;
import daml.marketplace.interface$.propertymanager.property.common.WarehouseType;
import daml.marketplace.interface$.propertymanager.property.common.ResidenceType;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.daml.ledger.api.v1.TransactionOuterClass.Transaction;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Transactions {
  private static final String APP_ID = "OperatorId";

  @Inject
  DamlLedgerClientProvider clientProvider;
  @Inject
  PartyRepository partyRepository;
  @Inject
  OperatorRepository operatorRepository;
  @Inject
  UserRoleFactoryRepository userRoleFactoryRepository;
  @Inject
  UserRoleOfferRepository userRoleOfferRepository;
  @Inject
  UserRoleManagerRepository userRoleManagerRepository;
  @Inject
  CredentialAppRepository credentialAppRepository;
  @Inject
  UserProfileFactoryRepository userProfileFactoryRepository;
  @Inject
  UserProfileManagerRepository userProfileManagerRepository;
  @Inject
  UserProfileReferenceInterfaceRepository userProfileReferenceInterfaceRepository;
  @Inject
  ProfileServiceOfferRepository profileServiceOfferRepository;
  @Inject
  ApartmentPropertyFactoryRepository apartmentPropertyFactoryRepository;
  @Inject
  GaragePropertyFactoryRepository garagePropertyFactoryRepository;
  @Inject
  LandPropertyFactoryRepository landPropertyFactoryRepository;
  @Inject
  ResidencePropertyFactoryRepository residencePropertyFactoryRepository;
  @Inject
  WarehousePropertyFactoryRepository warehousePropertyFactoryRepository;
  @Inject
  RequestCreateApartmentRepository requestCreateApartmentRepository;
  @Inject
  RequestCreateGarageRepository requestCreateGarageRepository;
  @Inject
  RequestCreateLandRepository requestCreateLandRepository;
  @Inject
  RequestCreateResidenceRepository requestCreateResidenceRepository;
  @Inject
  RequestCreateWarehouseRepository requestCreateWarehouseRepository;
  @Inject
  PropertyManagerRepository propertyManagerRepository;
  @Inject
  AccountFactoryRepository accountFactoryRepository;
  @Inject
  HoldingFactoryRepository holdingFactoryRepository;
  @Inject
  HoldingFactoryInterfaceRepository holdingFactoryInterfaceRepository;
  @Inject
  SettlementFactoryRepository settlementFactoryRepository;
  @Inject
  RouteProviderRepository routeProviderRepository;
  @Inject
  ClaimRuleRepository claimRuleRepository;
  @Inject
  CustodyServiceOfferRepository custodyServiceOfferRepository;
  @Inject
  CustodyManagerRepository custodyManagerRepository;
  @Inject
  PropertyServiceOfferRepository propertyServiceOfferRepository;
  @Inject
  UserRoleRepository userRoleRepository;
  @Inject
  UserRoleAppRepository userRoleAppRepository;
  @Inject
  UserRoleInterfaceRepository userRoleInterfaceRepository;
  @Inject
  UserProfileCreateRequestRepository userProfileCreateRequestRepository;
  @Inject
  UserAccountCreateRequestRepository userAccountCreateRequestRepository;
  @Inject
  UserAccountCloseRequestRepository userAccountCloseRequestRepository;
  @Inject
  UserAccountDepositRequestRepository userAccountDepositRequestRepository;
  @Inject
  IssuanceServiceOfferRepository issuanceServiceOfferRepository;
  @Inject
  IssueRequestRepository issueRequestRepository;
  @Inject
  DeIssueRequestRepository deIssueRequestRepository;
  @Inject
  IssuanceManagerRepository issuanceManagerRepository;
  @Inject
  UserHoldingFungibleRepository userHoldingFungibleRepository;
  @Inject
  UserHoldingTransferableRepository userHoldingTransferableRepository;
  @Inject
  UserAccountWithdrawRequestRepository userAccountWithdrawRequestRepository;
  @Inject
  UserSwapRequestRepository userSwapRequestRepository;
  @Inject
  UserAccountRepository userAccountRepository;
  @Inject
  UserAccountInterfaceRepository userAccountInterfaceRepository;
  @Inject
  UserProfileRepository userProfileRepository;
  @Inject
  ApartmentPropertyRepository apartmentPropertyRepository;
  @Inject
  GaragePropertyRepository garagePropertyRepository;
  @Inject
  LandPropertyRepository landPropertyRepository;
  @Inject
  ResidencePropertyRepository residencePropertyRepository;
  @Inject
  WarehousePropertyRepository warehousePropertyRepository;
  @Inject
  ApartmentPropertyInterfaceReferenceRepository apartmentPropertyInterfaceReferenceRepository;
  @Inject
  GaragePropertyInterfaceReferenceRepository garagePropertyInterfaceReferenceRepository;
  @Inject
  LandPropertyInterfaceReferenceRepository landPropertyInterfaceReferenceRepository;
  @Inject
  ResidencePropertyInterfaceReferenceRepository residencePropertyInterfaceReferenceRepository;
  @Inject
  WarehousePropertyInterfaceReferenceRepository warehousePropertyInterfaceReferenceRepository;

  @Inject
  PartyService partyService;
  @Inject
  UserService userService;
  @Inject
  OperatorService operatorService;
  @Inject
  Transactions transactionService;
  @Inject
  RoleManagerService roleManagerService;
  @Inject
  UserRoleService userRoleService;
  @Inject
  ProfileManagerService profileManagerService;
  @Inject
  UserProfileService userProfileService;
  @Inject
  PropertyManagerService propertyManagerService;
  @Inject
  UserPropertyService userPropertyService;
  @Inject
  AccountManagerService accountManagerService;
  @Inject
  UserAccountService userAccountService;
  @Inject
  IssuanceService issuanceService;

  private ManagedChannel channel;

  private DamlLedgerClient client;

  public Transactions() {
    channel = ManagedChannelBuilder.forAddress("localhost", 6865).usePlaintext().build();
  }

  public void handleTransactions(TransactionServiceOuterClass.GetTransactionsResponse response) {
    for (TransactionOuterClass.Transaction transaction : response.getTransactionsList()) {
      handleTransaction(transaction);
    }
  }

  public void handleTransaction(TransactionOuterClass.Transaction transaction) {
    for (Event event : transaction.getEventsList()) {
      //System.out.println(event.toString());
      handleEvent(event);
    }
  }

  private void handleEvent(Event event) {
    if (event.hasCreated())
      handleCreatedEvent(event.getCreated());
    else if (event.hasArchived())
      handleArchivedEvent(event.getArchived());
  }

  private void handleCreatedEvent(CreatedEvent created) {
    Identifier templateId = created.getTemplateId();
    String contractId = created.getContractId();
    if (templateId.equals(daml.marketplace.app.role.operator.Role.TEMPLATE_ID.toProto())) {
      handleOperatorRoleCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.credential.credential.Credential.TEMPLATE_ID.toProto())) {
      handleCredentialAppCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.rolemanager.userrole.userrole.Factory.TEMPLATE_ID.toProto())) {
      handleUserRoleFactoryCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.profilemanager.userprofile.Factory.TEMPLATE_ID.toProto())) {
      handleUserProfileFactoryCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.profilemanager.service.Offer.TEMPLATE_ID.toProto())) {
      handleProfileServiceOfferCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.role.user.Offer.TEMPLATE_ID.toProto())) {
      handleUserRoleOfferCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.role.user.Role.TEMPLATE_ID.toProto())) {
      handleRoleUserRoleCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.interface$.rolemanager.userrole.userrole.Reference.TEMPLATE_ID.toProto())) {
      handleRoleUserRoleInterfaceCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.rolemanager.userrole.userrole.UserRole.TEMPLATE_ID.toProto())) {
      handleRoleManagerUserRoleCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.profilemanager.model.RequestCreateUserProfile.TEMPLATE_ID.toProto())) {
      handleRequestCreateUserProfileCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.interface$.profilemanager.userprofile.userprofile.Reference.TEMPLATE_ID.toProto())) {
      handleUserProfileReferenceInterfaceCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.OpenAccountRequest.TEMPLATE_ID.toProto())) {
      handleRequestCreateUserAccountCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.CloseAccountRequest.TEMPLATE_ID.toProto())) {
      handleRequestCloseUserAccountCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.DepositRequest.TEMPLATE_ID.toProto())) {
      handleRequestDepositCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.WithdrawRequest.TEMPLATE_ID.toProto())) {
      handleRequestWithdrawCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.issuance.model.IssueRequest.TEMPLATE_ID.toProto())) {
      handleRequestIssueCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.issuance.model.DeIssueRequest.TEMPLATE_ID.toProto())) {
      handleRequestDeIssueCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.daml.finance.account.account.Account.TEMPLATE_ID.toProto())) {
      handleUserAccountCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.daml.finance.interface$.account.account.Reference.TEMPLATE_ID.toProto())) {
      handleUserAccountInterfaceCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.profilemanager.userprofile.UserProfile.TEMPLATE_ID.toProto())) {
      handleUserProfileCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.apartmentproperty.Factory.TEMPLATE_ID.toProto())) {
      handleApartmentPropertyFactoryCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.garageproperty.Factory.TEMPLATE_ID.toProto())) {
      handleGaragePropertyFactoryCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.landproperty.Factory.TEMPLATE_ID.toProto())) {
      handleLandPropertyFactoryCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.residenceproperty.Factory.TEMPLATE_ID.toProto())) {
      handleResidencePropertyFactoryCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.warehouseproperty.Factory.TEMPLATE_ID.toProto())) {
      handleWarehousePropertyFactoryCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateApartmentProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateApartmentCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateGarageProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateGarageCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateLandProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateLandCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateResidenceProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateResidenceCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateWarehouseProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateWarehouseCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateApartmentProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateApartmentCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateGarageProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateGarageCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateLandProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateLandCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateResidenceProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateResidenceCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateWarehouseProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateWarehouseCreatedEvent(created, contractId);
    } else if (templateId.equals(
        daml.marketplace.app.propertymanager.property.apartmentproperty.ApartmentProperty.TEMPLATE_ID.toProto())) {
      handleApartmentPropertyCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.garageproperty.GarageProperty.TEMPLATE_ID.toProto())) {
      handleGaragePropertyCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.landproperty.LandProperty.TEMPLATE_ID.toProto())) {
      handleLandPropertyCreatedEvent(created, contractId);
    } else if (templateId.equals(
        daml.marketplace.app.propertymanager.property.residenceproperty.ResidenceProperty.TEMPLATE_ID.toProto())) {
      handleResidencePropertyCreatedEvent(created, contractId);
    } else if (templateId.equals(
        daml.marketplace.app.propertymanager.property.warehouseproperty.WarehouseProperty.TEMPLATE_ID.toProto())) {
      handleWarehousePropertyCreatedEvent(created, contractId);
    } else if (templateId.equals(
        daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty.Reference.TEMPLATE_ID.toProto())) {
      handleApartmentPropertyInterfaceReferenceCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.interface$.propertymanager.property.garageproperty.garageproperty.Reference.TEMPLATE_ID.toProto())) {
      handleGaragePropertyInterfaceReferenceCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.marketplace.interface$.propertymanager.property.landproperty.landproperty.Reference.TEMPLATE_ID.toProto())) {
      handleLandPropertyInterfaceReferenceCreatedEvent(created, contractId);
    } else if (templateId.equals(
        daml.marketplace.interface$.propertymanager.property.residenceproperty.residenceproperty.Reference.TEMPLATE_ID.toProto())) {
      handleResidencePropertyInterfaceReferenceCreatedEvent(created, contractId);
    } else if (templateId.equals(
        daml.marketplace.interface$.propertymanager.property.warehouseproperty.warehouseproperty.Reference.TEMPLATE_ID.toProto())) {
      handleWarehousePropertyInterfaceReferenceCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.daml.finance.account.account.Factory.TEMPLATE_ID.toProto())) {
      handleAccountFactoryCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.daml.finance.holding.factory.Factory.TEMPLATE_ID.toProto())) {
      handleHoldingFactoryCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.daml.finance.interface$.holding.factory.Reference.TEMPLATE_ID.toProto())) {
      handleHoldingFactoryInterfaceCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.daml.finance.settlement.factory.Factory.TEMPLATE_ID.toProto())) {
      handleSettlementFactoryCreatedEvent(created, contractId);
    } else if (templateId.equals(
        daml.daml.finance.settlement.routeprovider.intermediatedstatic.IntermediatedStatic.TEMPLATE_ID.toProto())) {
      handleRouteProviderCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.daml.finance.lifecycle.rule.claim.Rule.TEMPLATE_ID.toProto())) {
      handleClaimRuleCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.service.Offer.TEMPLATE_ID.toProto())) {
      handleCustodyServiceOfferCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.issuance.service.Offer.TEMPLATE_ID.toProto())) {
      handleIssuanceServiceOfferCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.issuance.service.Service.TEMPLATE_ID.toProto())) {
      handleIssuanceServiceCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.propertymanager.service.Offer.TEMPLATE_ID.toProto())) {
      handlePropertyServiceOfferCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.profilemanager.service.Service.TEMPLATE_ID.toProto())) {
      handleProfileManagerServiceCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.rolemanager.service.Service.TEMPLATE_ID.toProto())) {
      handleRoleManagerServiceCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.propertymanager.service.Service.TEMPLATE_ID.toProto())) {
      handlePropertyManagerServiceCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.service.Service.TEMPLATE_ID.toProto())) {
      handleCustodyManagerServiceCreatedEvent(created, contractId);
    } else if (templateId
        .equals(daml.daml.finance.holding.transferablefungible.TransferableFungible.TEMPLATE_ID.toProto())) {
      handleUserHoldingFungibleCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.daml.finance.holding.transferable.Transferable.TEMPLATE_ID.toProto())) {
      handleUserHoldingTransferableCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.SwapRequest.TEMPLATE_ID.toProto())) {
      handleUserSwapRequestCreatedEvent(created, contractId);
    } else {
      System.out.println("Unsupported template ID: " + templateId.toString() + "\n");
    }
  }

  private void handleArchivedEvent(ArchivedEvent archived) {
    Identifier templateId = archived.getTemplateId();
    String contractId = archived.getContractId();
    if (templateId.equals(Role.TEMPLATE_ID.toProto())) {
      handleOperatorRoleArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.credential.credential.Credential.TEMPLATE_ID.toProto())) {
      handleCredentialAppArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.rolemanager.userrole.userrole.Factory.TEMPLATE_ID.toProto())) {
      handleUserRoleFactoryArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.profilemanager.userprofile.Factory.TEMPLATE_ID.toProto())) {
      handleUserProfileFactoryArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.profilemanager.service.Offer.TEMPLATE_ID.toProto())) {
      handleProfileServiceOfferArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.role.user.Role.TEMPLATE_ID.toProto())) {
      handleRoleUserRoleArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.interface$.rolemanager.userrole.userrole.Reference.TEMPLATE_ID.toProto())) {
      handleRoleUserRoleInterfaceArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.rolemanager.userrole.userrole.UserRole.TEMPLATE_ID.toProto())) {
      handleRoleManagerUserRoleArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.profilemanager.model.RequestCreateUserProfile.TEMPLATE_ID.toProto())) {
      handleRequestCreateUserProfileArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.interface$.profilemanager.userprofile.userprofile.Reference.TEMPLATE_ID.toProto())) {
      handleUserProfileReferenceInterfaceArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.OpenAccountRequest.TEMPLATE_ID.toProto())) {
      handleRequestCreateUserAccountArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.CloseAccountRequest.TEMPLATE_ID.toProto())) {
      handleRequestCloseUserAccountArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.DepositRequest.TEMPLATE_ID.toProto())) {
      handleRequestDepositArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.WithdrawRequest.TEMPLATE_ID.toProto())) {
      handleRequestWithdrawArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.issuance.model.IssueRequest.TEMPLATE_ID.toProto())) {
      handleRequestIssueArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.issuance.model.DeIssueRequest.TEMPLATE_ID.toProto())) {
      handleRequestDeIssueArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateApartmentProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateApartmentArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateGarageProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateGarageArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateLandProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateLandArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateResidenceProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateResidenceArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.model.RequestCreateWarehouseProperty.TEMPLATE_ID.toProto())) {
      handleRequestCreateWarehouseArchivedEvent(contractId);
    } else if (templateId.equals(daml.daml.finance.account.account.Account.TEMPLATE_ID.toProto())) {
      handleUserAccountArchivedEvent(contractId);
    } else if (templateId.equals(daml.daml.finance.interface$.account.account.Reference.TEMPLATE_ID.toProto())) {
      handleUserAccountInterfaceArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.profilemanager.userprofile.UserProfile.TEMPLATE_ID.toProto())) {
      handleUserProfileArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.role.user.Offer.TEMPLATE_ID.toProto())) {
      handleUserRoleOfferArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.apartmentproperty.Factory.TEMPLATE_ID.toProto())) {
      handleApartmentPropertyFactoryArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.garageproperty.Factory.TEMPLATE_ID.toProto())) {
      handleGaragePropertyFactoryArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.landproperty.Factory.TEMPLATE_ID.toProto())) {
      handleLandPropertyFactoryArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.residenceproperty.Factory.TEMPLATE_ID.toProto())) {
      handleResidencePropertyFactoryArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.warehouseproperty.Factory.TEMPLATE_ID.toProto())) {
      handleWarehousePropertyFactoryArchivedEvent(contractId);
    } else if (templateId.equals(
        daml.marketplace.app.propertymanager.property.apartmentproperty.ApartmentProperty.TEMPLATE_ID.toProto())) {
      handleApartmentPropertyArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.garageproperty.GarageProperty.TEMPLATE_ID.toProto())) {
      handleGaragePropertyArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.app.propertymanager.property.landproperty.LandProperty.TEMPLATE_ID.toProto())) {
      handleLandPropertyArchivedEvent(contractId);
    } else if (templateId.equals(
        daml.marketplace.app.propertymanager.property.residenceproperty.ResidenceProperty.TEMPLATE_ID.toProto())) {
      handleResidencePropertyArchivedEvent(contractId);
    } else if (templateId.equals(
        daml.marketplace.app.propertymanager.property.warehouseproperty.WarehouseProperty.TEMPLATE_ID.toProto())) {
      handleWarehousePropertyArchivedEvent(contractId);
    } else if (templateId.equals(
      daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty.Reference.TEMPLATE_ID.toProto())) {
      handleApartmentPropertyInterfaceReferenceArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.interface$.propertymanager.property.garageproperty.garageproperty.Reference.TEMPLATE_ID.toProto())) {
      handleGaragePropertyInterfaceReferenceArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.marketplace.interface$.propertymanager.property.landproperty.landproperty.Reference.TEMPLATE_ID.toProto())) {
      handleLandPropertyInterfaceReferenceArchivedEvent(contractId);
    } else if (templateId.equals(
      daml.marketplace.interface$.propertymanager.property.residenceproperty.residenceproperty.Reference.TEMPLATE_ID.toProto())) {
      handleResidencePropertyInterfaceReferenceArchivedEvent(contractId);
    } else if (templateId.equals(
      daml.marketplace.interface$.propertymanager.property.warehouseproperty.warehouseproperty.Reference.TEMPLATE_ID.toProto())) {
      handleWarehousePropertyInterfaceReferenceArchivedEvent(contractId);
    } else if (templateId.equals(daml.daml.finance.account.account.Factory.TEMPLATE_ID.toProto())) {
      handleAccountFactoryArchivedEvent(contractId);
    } else if (templateId.equals(daml.daml.finance.holding.factory.Factory.TEMPLATE_ID.toProto())) {
      handleHoldingFactoryArchivedEvent(contractId);
    } else if (templateId.equals(daml.daml.finance.interface$.holding.factory.Reference.TEMPLATE_ID.toProto())) {
      handleHoldingFactoryInterfaceArchivedEvent(contractId);
    } else if (templateId.equals(daml.daml.finance.settlement.factory.Factory.TEMPLATE_ID.toProto())) {
      handleSettlementFactoryArchivedEvent(contractId);
    } else if (templateId.equals(
        daml.daml.finance.settlement.routeprovider.intermediatedstatic.IntermediatedStatic.TEMPLATE_ID.toProto())) {
      handleRouteProviderArchivedEvent(contractId);
    } else if (templateId.equals(daml.daml.finance.lifecycle.rule.claim.Rule.TEMPLATE_ID.toProto())) {
      handleClaimRuleArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.service.Offer.TEMPLATE_ID.toProto())) {
      handleCustodyServiceOfferArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.issuance.service.Offer.TEMPLATE_ID.toProto())) {
      handleIssuanceServiceOfferArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.issuance.service.Service.TEMPLATE_ID.toProto())) {
      handleIssuanceServiceArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.propertymanager.service.Offer.TEMPLATE_ID.toProto())) {
      handlePropertyServiceOfferArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.profilemanager.service.Service.TEMPLATE_ID.toProto())) {
      handleProfileManagerServiceArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.rolemanager.service.Service.TEMPLATE_ID.toProto())) {
      handleRoleManagerServiceArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.propertymanager.service.Service.TEMPLATE_ID.toProto())) {
      handlePropertyManagerServiceArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.service.Service.TEMPLATE_ID.toProto())) {
      handleCustodyManagerServiceArchivedEvent(contractId);
    } else if (templateId
        .equals(daml.daml.finance.holding.transferablefungible.TransferableFungible.TEMPLATE_ID.toProto())) {
      handleUserHoldingFungibleArchivedEvent(contractId);
    } else if (templateId.equals(daml.daml.finance.holding.transferable.Transferable.TEMPLATE_ID.toProto())) {
      handleUserHoldingTransferableArchivedEvent(contractId);
    } else if (templateId.equals(daml.marketplace.app.custody.model.SwapRequest.TEMPLATE_ID.toProto())) {
      handleUserSwapRequestArchivedEvent(contractId);
    } else {
      System.out.println("Unsupported template ID: " + templateId.toString() + "\n");
    }
  }

  // ----------- Handle Create Event Methods------------------------

  private void handleOperatorRoleCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    operatorRepository.persist(new Operator(partyId, contractId));
  }

  private void handleCredentialAppCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    credentialAppRepository.persist(new CredentialApp(operatorId+userId, contractId));
  }

  private void handleUserRoleFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    userRoleFactoryRepository.persist(new UserRoleFactory(partyId, contractId));
  }

  private void handleRoleUserRoleCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String roleId = event.getContractKey().getRecord().getRecordId().getPackageId();
    userRoleAppRepository
        .persist(new UserRoleApp(operatorId + userId, contractId, roleId));
  }

  private void handleRoleUserRoleInterfaceCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    userRoleInterfaceRepository.persist(new UserRoleInterface(partyId, contractId));
  }

  private void handleRoleManagerUserRoleCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String roleId = event.getCreateArguments().getFields(2).getValue().getParty();
    userRoleRepository
        .persist(new UserRole(operatorId + userId, contractId, roleId));
  }

  private void handleUserProfileFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    userProfileFactoryRepository.persist(new UserProfileFactory(partyId, contractId));
  }

  private void handleProfileServiceOfferCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    profileServiceOfferRepository.persist(new ProfileServiceOffer(operatorId + userId, contractId));
  }

  private void handleRequestCreateUserProfileCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    userProfileCreateRequestRepository.persist(new UserProfileCreateRequest(operatorId+userId, contractId));
  }

  private void handleUserProfileReferenceInterfaceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(1).getValue().getParty();
    userProfileReferenceInterfaceRepository.persist(new UserProfileReferenceInterface(operatorId+userId, contractId));
  }

  private void handleRequestCreateUserAccountCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    userAccountCreateRequestRepository.persist(new UserAccountCreateRequest(operatorId+userId, contractId));
  }

  private void handleRequestCloseUserAccountCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    userAccountCloseRequestRepository.persist(new UserAccountCloseRequest(partyId, contractId));
  }

  private void handleRequestDepositCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    userAccountDepositRequestRepository.persist(new UserAccountDepositRequest(operatorId + userId, contractId));
  }

  private void handleRequestWithdrawCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    userAccountWithdrawRequestRepository.persist(new UserAccountWithdrawRequest(operatorId+userId, contractId));
  }

  private void handleRequestIssueCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    issueRequestRepository.persist(new IssueRequest(operatorId + userId, contractId));
  }

  private void handleRequestDeIssueCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    deIssueRequestRepository.persist(new DeIssueRequest(operatorId + userId, contractId));
  }

  private void handleUserAccountCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String accountId = event.getCreateArguments().getFields(4).getValue().getRecord().getFields(0).getValue().getText();
    userAccountRepository.persist(new UserAccount(operatorId + userId, contractId, accountId));
  }

  private void handleUserAccountInterfaceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(1).getValue().getParty();
    String accountId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    userAccountInterfaceRepository.persist(new UserAccountInterface(operatorId + userId, contractId, accountId));
  }

  private void handleUserProfileCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String profileId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    
    String username = event.getCreateArguments().getFields(3).getValue().getText();
    String firstName = event.getCreateArguments().getFields(4).getValue().getText();
    String lastName = event.getCreateArguments().getFields(5).getValue().getText();
    String fullName = event.getCreateArguments().getFields(6).getValue().getText();
    String password = event.getCreateArguments().getFields(7).getValue().getText();
    LocalDate birthday = LocalDate.ofEpochDay(event.getCreateArguments().getFields(8).getValue().getDate());
    String genderValue = event.getCreateArguments().getFields(9).getValue().getOptional().getValue().getEnum().getConstructor().toString();
    Gender gender = UserProfileHelper.genderFromString(genderValue);
    String nationalityValue = event.getCreateArguments().getFields(10).getValue().getEnum().getConstructor();
    Nationality nationality = UserProfileHelper.nationalityFromString(nationalityValue);
    String contactMail = event.getCreateArguments().getFields(11).getValue().getText();
    Long cellphoneNumber = event.getCreateArguments().getFields(12).getValue().getOptional().getValue().getInt64();
    Long idNumber = event.getCreateArguments().getFields(13).getValue().getInt64();
    Long taxId = event.getCreateArguments().getFields(14).getValue().getInt64();
    Long socialSecurityId = event.getCreateArguments().getFields(15).getValue().getInt64();
    ValueOuterClass.List protoList = event.getCreateArguments().getFields(16).getValue().getList();
    List<String> photoReferences = new ArrayList<>();
    for (ValueOuterClass.Value element : protoList.getElementsList()) {
        String text = element.getText();
        photoReferences.add(text);
    }
    userProfileRepository.persist(new UserProfile(operatorId + userId, contractId, profileId, username, firstName, lastName, fullName,
      password, birthday, gender, nationality, contactMail, cellphoneNumber, idNumber, taxId, socialSecurityId, photoReferences));
  }

  private void handleApartmentPropertyInterfaceReferenceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    apartmentPropertyInterfaceReferenceRepository.persist(new ApartmentPropertyInterfaceReference(operatorId + userId + propertyId, contractId));
  }

  private void handleGaragePropertyInterfaceReferenceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    garagePropertyInterfaceReferenceRepository.persist(new GaragePropertyInterfaceReference(operatorId + userId + propertyId, contractId));
  }

  private void handleLandPropertyInterfaceReferenceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    landPropertyInterfaceReferenceRepository.persist(new LandPropertyInterfaceReference(operatorId + userId + propertyId, contractId));
  }

  private void handleResidencePropertyInterfaceReferenceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    residencePropertyInterfaceReferenceRepository.persist(new ResidencePropertyInterfaceReference(operatorId + userId + propertyId, contractId));
  }

  private void handleWarehousePropertyInterfaceReferenceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    warehousePropertyInterfaceReferenceRepository.persist(new WarehousePropertyInterfaceReference(operatorId + userId + propertyId, contractId));
  }

  private void handleApartmentPropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal apartmentPrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    BigDecimal grossArea = new BigDecimal(event.getCreateArguments().getFields(9).getValue().getNumeric());
    BigDecimal usableArea = new BigDecimal(event.getCreateArguments().getFields(10).getValue().getNumeric());
    Long bedrooms = event.getCreateArguments().getFields(11).getValue().getInt64();
    Long bathrooms = event.getCreateArguments().getFields(12).getValue().getInt64();
    Long floor = event.getCreateArguments().getFields(13).getValue().getInt64();
    Long parkingSpaces = event.getCreateArguments().getFields(14).getValue().getInt64();
    Boolean elevator = event.getCreateArguments().getFields(15).getValue().getBool();
    LocalDate buildDate = LocalDate.ofEpochDay(event.getCreateArguments().getFields(16).getValue().getDate());
    String installedEquipment = event.getCreateArguments().getFields(17).getValue().getText();
    String additionalInformation = event.getCreateArguments().getFields(18).getValue().getText();
    String description = event.getCreateArguments().getFields(19).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements = event.getCreateArguments().getFields(20).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements) {
        photoReferences.add(element.getText());
    }
    /** 
    System.out.println("Operator ID: " + operatorId);
    System.out.println("User ID: " + userId);
    System.out.println("Property ID: " + propertyId);
    System.out.println("Apartment Price: " + apartmentPrice);
    System.out.println("Property Address: " + propertyAddress);
    System.out.println("Property Postal Code: " + propertyPostalCode);
    System.out.println("Property District: " + propertyDistrict);
    System.out.println("Property County: " + propertyCounty);
    System.out.println("Gross Area: " + grossArea);
    System.out.println("Usable Area: " + usableArea);
    System.out.println("Bedrooms: " + bedrooms);
    System.out.println("Bathrooms: " + bathrooms);
    System.out.println("Floor: " + floor);
    System.out.println("Parking Spaces: " + parkingSpaces);
    System.out.println("Elevator: " + elevator);
    System.out.println("Build Date: " + buildDate);
    System.out.println("Installed Equipment: " + installedEquipment);
    System.out.println("Additional Information: " + additionalInformation);
    System.out.println("Description: " + description);
    System.out.println("Photo References: " + photoReferences);
    */
    ApartmentProperty apartmentProperty = new ApartmentProperty(operatorId + propertyPostalCode, contractId, propertyId,
     apartmentPrice, propertyAddress, propertyPostalCode, propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms, 
     bathrooms, floor, parkingSpaces, elevator, buildDate, installedEquipment, additionalInformation, description, photoReferences);
    apartmentPropertyRepository.persist(apartmentProperty);
}

  private void handleGaragePropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal garagePrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    BigDecimal garageArea = new BigDecimal(event.getCreateArguments().getFields(9).getValue().getNumeric());
    String garageTypeStr = event.getCreateArguments().getFields(10).getValue().getEnum().getConstructor();
    GarageType garageType = UserPropertyHelper.garageTypeFromString(garageTypeStr);
    Long vehicleCapacity = event.getCreateArguments().getFields(11).getValue().getInt64();
    String installedEquipment = event.getCreateArguments().getFields(12).getValue().getText();
    String additionalInformation = event.getCreateArguments().getFields(13).getValue().getText();
    String description = event.getCreateArguments().getFields(14).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements = event.getCreateArguments().getFields(15).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements) {
        photoReferences.add(element.getText());
    }
    /** 
    System.out.println("Operator ID: " + operatorId);
    System.out.println("User ID: " + userId);
    System.out.println("Property ID: " + propertyId);
    System.out.println("Garage Price: " + garagePrice);
    System.out.println("Property Address: " + propertyAddress);
    System.out.println("Property Postal Code: " + propertyPostalCode);
    System.out.println("Property District: " + propertyDistrict);
    System.out.println("Property County: " + propertyCounty);
    System.out.println("Garage Area: " + garageArea);
    System.out.println("Garage Type: " + garageType);
    System.out.println("Vehicle Capacity: " + vehicleCapacity);
    System.out.println("Installed Equipment: " + installedEquipment);
    System.out.println("Additional Information: " + additionalInformation);
    System.out.println("Description: " + description);
    System.out.println("Photo References: " + photoReferences);
    */
    GarageProperty garageProperty = new GarageProperty(operatorId + propertyPostalCode, contractId, propertyId, garagePrice, propertyAddress, 
    propertyPostalCode, propertyDistrict, propertyCounty, garageArea, garageType, vehicleCapacity, installedEquipment, 
    additionalInformation, description, photoReferences);
    garagePropertyRepository.persist(garageProperty);
  }

  private void handleLandPropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal landPrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    String landTypeStr = event.getCreateArguments().getFields(9).getValue().getEnum().getConstructor();
    LandType landType = UserPropertyHelper.landTypeFromString(landTypeStr);
    BigDecimal totalLandArea = new BigDecimal(event.getCreateArguments().getFields(10).getValue().getNumeric());
    BigDecimal minimumSurfaceForSale = new BigDecimal(event.getCreateArguments().getFields(11).getValue().getNumeric());
    BigDecimal buildableArea = new BigDecimal(event.getCreateArguments().getFields(12).getValue().getNumeric());
    Long buildableFloors = event.getCreateArguments().getFields(13).getValue().getInt64();
    Boolean accessByRoad = event.getCreateArguments().getFields(14).getValue().getBool();
    String installedEquipment = event.getCreateArguments().getFields(15).getValue().getText();
    List<ValueOuterClass.Value> elements = event.getCreateArguments().getFields(16).getValue().getList().getElementsList();
    List<String> constructionTypeStrs = new ArrayList<>();
    for (ValueOuterClass.Value element : elements) {
        constructionTypeStrs.add(element.getEnum().getConstructor());
    }
    List<ViableConstructionTypes> viableConstructionTypes = UserPropertyHelper.viableConstructionTypesFromStrings(constructionTypeStrs);
    String additionalInformation = event.getCreateArguments().getFields(17).getValue().getText();
    String description = event.getCreateArguments().getFields(18).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements1 = event.getCreateArguments().getFields(19).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements1) {
        photoReferences.add(element.getText());
    }
    /** 
    System.out.println("Operator ID: " + operatorId);
    System.out.println("User ID: " + userId);
    System.out.println("Property ID: " + propertyId);
    System.out.println("Land Price: " + landPrice);
    System.out.println("Property Address: " + propertyAddress);
    System.out.println("Property Postal Code: " + propertyPostalCode);
    System.out.println("Property District: " + propertyDistrict);
    System.out.println("Property County: " + propertyCounty);
    System.out.println("Land Type: " + landType);
    System.out.println("Total Land Area: " + totalLandArea);
    System.out.println("Minimum Surface For Sale: " + minimumSurfaceForSale);
    System.out.println("Buildable Area: " + buildableArea);
    System.out.println("Buildable Floors: " + buildableFloors);
    System.out.println("Access by Road: " + accessByRoad);
    System.out.println("Installed Equipment: " + installedEquipment);
    System.out.println("Viable Construction Types: " + viableConstructionTypes);
    System.out.println("Additional Information: " + additionalInformation);
    System.out.println("Description: " + description);
    System.out.println("Photo References: " + photoReferences);
    */
    landPropertyRepository.persist(new LandProperty(operatorId + propertyPostalCode, contractId, propertyId, landPrice, propertyAddress, propertyPostalCode, 
    propertyDistrict, propertyCounty, landType, totalLandArea, minimumSurfaceForSale, buildableArea, buildableFloors, accessByRoad, 
    installedEquipment, viableConstructionTypes, additionalInformation, description, photoReferences));
  }

  private void handleResidencePropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal residencePrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    BigDecimal grossArea = new BigDecimal(event.getCreateArguments().getFields(9).getValue().getNumeric());
    BigDecimal usableArea = new BigDecimal(event.getCreateArguments().getFields(10).getValue().getNumeric());
    Long bedrooms = event.getCreateArguments().getFields(11).getValue().getInt64();
    Long bathrooms = event.getCreateArguments().getFields(12).getValue().getInt64();
    Long floors = event.getCreateArguments().getFields(13).getValue().getInt64();
    String residenceTypeStr = event.getCreateArguments().getFields(14).getValue().getEnum().getConstructor();
    ResidenceType residenceType = UserPropertyHelper.residenceTypeFromString(residenceTypeStr);
    String backyard = event.getCreateArguments().getFields(15).getValue().getText();
    String parkingStr = event.getCreateArguments().getFields(16).getValue().getEnum().getConstructor();
    Parking parking = UserPropertyHelper.parkingFromString(parkingStr);
    LocalDate buildDate = LocalDate.ofEpochDay(event.getCreateArguments().getFields(17).getValue().getDate());
    String orientationStr = event.getCreateArguments().getFields(18).getValue().getEnum().getConstructor();
    Orientation orientation = UserPropertyHelper.orientationFromString(orientationStr);
    String installedEquipment = event.getCreateArguments().getFields(19).getValue().getText();
    String additionalInformation = event.getCreateArguments().getFields(20).getValue().getText();
    String description = event.getCreateArguments().getFields(21).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements1 = event.getCreateArguments().getFields(22).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements1) {
        photoReferences.add(element.getText());
    }
    /** 
    System.out.println("Operator ID: " + operatorId);
    System.out.println("User ID: " + userId);
    System.out.println("Property ID: " + propertyId);
    System.out.println("Residence Price: " + residencePrice);
    System.out.println("Property Address: " + propertyAddress);
    System.out.println("Property Postal Code: " + propertyPostalCode);
    System.out.println("Property District: " + propertyDistrict);
    System.out.println("Property County: " + propertyCounty);
    System.out.println("Gross Area: " + grossArea);
    System.out.println("Usable Area: " + usableArea);
    System.out.println("Bedrooms: " + bedrooms);
    System.out.println("Bathrooms: " + bathrooms);
    System.out.println("Floors: " + floors);
    System.out.println("Residence Type: " + residenceType);
    System.out.println("Backyard: " + backyard);
    System.out.println("Parking: " + parking);
    System.out.println("Build Date: " + buildDate);
    System.out.println("Orientation: " + orientation);
    System.out.println("Installed Equipment: " + installedEquipment);
    System.out.println("Additional Information: " + additionalInformation);
    System.out.println("Description: " + description);
    System.out.println("Photo References: " + photoReferences);
    */
    residencePropertyRepository.persist(new ResidenceProperty(operatorId + propertyPostalCode, contractId, propertyId, residencePrice, propertyAddress, 
    propertyPostalCode, propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms, bathrooms, floors, residenceType, 
    backyard, parking, buildDate, orientation, installedEquipment, additionalInformation, description, photoReferences));
  }

  private void handleWarehousePropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal warehousePrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    String warehouseTypeStr = event.getCreateArguments().getFields(9).getValue().getEnum().getConstructor();
    WarehouseType warehouseType = UserPropertyHelper.warehouseTypeFromString(warehouseTypeStr);
    BigDecimal grossArea = new BigDecimal(event.getCreateArguments().getFields(10).getValue().getNumeric());
    BigDecimal usableArea = new BigDecimal(event.getCreateArguments().getFields(11).getValue().getNumeric());
    Long floors = event.getCreateArguments().getFields(12).getValue().getInt64();
    LocalDate buildDate = LocalDate.ofEpochDay(event.getCreateArguments().getFields(13).getValue().getDate());
    String installedEquipment = event.getCreateArguments().getFields(14).getValue().getText();
    String additionalInformation = event.getCreateArguments().getFields(15).getValue().getText();
    String description = event.getCreateArguments().getFields(16).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements1 = event.getCreateArguments().getFields(17).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements1) {
        photoReferences.add(element.getText());
    }
    /**
    System.out.println("Operator ID: " + operatorId);
    System.out.println("User ID: " + userId);
    System.out.println("Property ID: " + propertyId);
    System.out.println("Warehouse Price: " + warehousePrice);
    System.out.println("Property Address: " + propertyAddress);
    System.out.println("Property Postal Code: " + propertyPostalCode);
    System.out.println("Property District: " + propertyDistrict);
    System.out.println("Property County: " + propertyCounty);
    System.out.println("Warehouse Type: " + warehouseType);
    System.out.println("Gross Area: " + grossArea);
    System.out.println("Usable Area: " + usableArea);
    System.out.println("Floors: " + floors);
    System.out.println("Build Date: " + buildDate);
    System.out.println("Installed Equipment: " + installedEquipment);
    System.out.println("Additional Information: " + additionalInformation);
    System.out.println("Description: " + description);
    System.out.println("Photo References: " + photoReferences);
     */
    warehousePropertyRepository.persist(new WarehouseProperty(operatorId + propertyPostalCode, contractId, propertyId, warehousePrice, propertyAddress, 
    propertyPostalCode, propertyDistrict, propertyCounty, warehouseType, grossArea, usableArea, floors, buildDate, installedEquipment, 
    additionalInformation, description, photoReferences));
  }

  private void handleUserRoleOfferCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    userRoleOfferRepository.persist(new UserRoleOffer(operatorId + userId, contractId));
  }

  private void handleApartmentPropertyFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    apartmentPropertyFactoryRepository.persist(new ApartmentPropertyFactory(partyId, contractId));
  }

  private void handleGaragePropertyFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    garagePropertyFactoryRepository.persist(new GaragePropertyFactory(partyId, contractId));
  }

  private void handleLandPropertyFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    landPropertyFactoryRepository.persist(new LandPropertyFactory(partyId, contractId));
  }

  private void handleResidencePropertyFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    residencePropertyFactoryRepository.persist(new ResidencePropertyFactory(partyId, contractId));
  }

  private void handleWarehousePropertyFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    warehousePropertyFactoryRepository.persist(new WarehousePropertyFactory(partyId, contractId));
  }

  private void handleRequestCreateApartmentCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal apartmentPrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    BigDecimal grossArea = new BigDecimal(event.getCreateArguments().getFields(9).getValue().getNumeric());
    BigDecimal usableArea = new BigDecimal(event.getCreateArguments().getFields(10).getValue().getNumeric());
    Long bedrooms = event.getCreateArguments().getFields(11).getValue().getInt64();
    Long bathrooms = event.getCreateArguments().getFields(12).getValue().getInt64();
    Long floor = event.getCreateArguments().getFields(13).getValue().getInt64();
    Long parkingSpaces = event.getCreateArguments().getFields(14).getValue().getInt64();
    Boolean elevator = event.getCreateArguments().getFields(15).getValue().getBool();
    LocalDate buildDate = LocalDate.ofEpochDay(event.getCreateArguments().getFields(16).getValue().getDate());
    String installedEquipment = event.getCreateArguments().getFields(17).getValue().getText();
    String additionalInformation = event.getCreateArguments().getFields(18).getValue().getText();
    String description = event.getCreateArguments().getFields(19).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements = event.getCreateArguments().getFields(20).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements) {
        photoReferences.add(element.getText());
    }
    RequestCreateApartment requestCreateApartment = new RequestCreateApartment(operatorId + userId + propertyPostalCode, contractId, propertyId,
    apartmentPrice, propertyAddress, propertyPostalCode, propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms, 
    bathrooms, floor, parkingSpaces, elevator, buildDate, installedEquipment, additionalInformation, description, photoReferences);
    requestCreateApartmentRepository.persist(requestCreateApartment);
  } 

  private void handleRequestCreateGarageCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal garagePrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    BigDecimal garageArea = new BigDecimal(event.getCreateArguments().getFields(9).getValue().getNumeric());
    String garageTypeStr = event.getCreateArguments().getFields(10).getValue().getEnum().getConstructor();
    GarageType garageType = UserPropertyHelper.garageTypeFromString(garageTypeStr);
    Long vehicleCapacity = event.getCreateArguments().getFields(11).getValue().getInt64();
    String installedEquipment = event.getCreateArguments().getFields(12).getValue().getText();
    String additionalInformation = event.getCreateArguments().getFields(13).getValue().getText();
    String description = event.getCreateArguments().getFields(14).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements = event.getCreateArguments().getFields(15).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements) {
        photoReferences.add(element.getText());
    }
    requestCreateGarageRepository.persist(new RequestCreateGarage(operatorId + userId + propertyPostalCode, contractId, propertyId, garagePrice, propertyAddress, 
    propertyPostalCode, propertyDistrict, propertyCounty, garageArea, garageType, vehicleCapacity, installedEquipment, 
    additionalInformation, description, photoReferences));
  }

  private void handleRequestCreateLandCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal landPrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    String landTypeStr = event.getCreateArguments().getFields(9).getValue().getEnum().getConstructor();
    LandType landType = UserPropertyHelper.landTypeFromString(landTypeStr);
    BigDecimal totalLandArea = new BigDecimal(event.getCreateArguments().getFields(10).getValue().getNumeric());
    BigDecimal minimumSurfaceForSale = new BigDecimal(event.getCreateArguments().getFields(11).getValue().getNumeric());
    BigDecimal buildableArea = new BigDecimal(event.getCreateArguments().getFields(12).getValue().getNumeric());
    Long buildableFloors = event.getCreateArguments().getFields(13).getValue().getInt64();
    Boolean accessByRoad = event.getCreateArguments().getFields(14).getValue().getBool();
    String installedEquipment = event.getCreateArguments().getFields(15).getValue().getText();
    List<ValueOuterClass.Value> elements = event.getCreateArguments().getFields(16).getValue().getList().getElementsList();
    List<String> constructionTypeStrs = new ArrayList<>();
    for (ValueOuterClass.Value element : elements) {
        constructionTypeStrs.add(element.getEnum().getConstructor());
    }
    List<ViableConstructionTypes> viableConstructionTypes = UserPropertyHelper.viableConstructionTypesFromStrings(constructionTypeStrs);
    String additionalInformation = event.getCreateArguments().getFields(17).getValue().getText();
    String description = event.getCreateArguments().getFields(18).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements1 = event.getCreateArguments().getFields(19).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements1) {
        photoReferences.add(element.getText());
    }
    requestCreateLandRepository.persist(new RequestCreateLand(operatorId + userId + propertyPostalCode, contractId, propertyId, landPrice, propertyAddress, propertyPostalCode, 
    propertyDistrict, propertyCounty, landType, totalLandArea, minimumSurfaceForSale, buildableArea, buildableFloors, accessByRoad, 
    installedEquipment, viableConstructionTypes, additionalInformation, description, photoReferences));
  }

  private void handleRequestCreateResidenceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal residencePrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    BigDecimal grossArea = new BigDecimal(event.getCreateArguments().getFields(9).getValue().getNumeric());
    BigDecimal usableArea = new BigDecimal(event.getCreateArguments().getFields(10).getValue().getNumeric());
    Long bedrooms = event.getCreateArguments().getFields(11).getValue().getInt64();
    Long bathrooms = event.getCreateArguments().getFields(12).getValue().getInt64();
    Long floors = event.getCreateArguments().getFields(13).getValue().getInt64();
    String residenceTypeStr = event.getCreateArguments().getFields(14).getValue().getEnum().getConstructor();
    ResidenceType residenceType = UserPropertyHelper.residenceTypeFromString(residenceTypeStr);
    String backyard = event.getCreateArguments().getFields(15).getValue().getText();
    String parkingStr = event.getCreateArguments().getFields(16).getValue().getEnum().getConstructor();
    Parking parking = UserPropertyHelper.parkingFromString(parkingStr);
    LocalDate buildDate = LocalDate.ofEpochDay(event.getCreateArguments().getFields(17).getValue().getDate());
    String orientationStr = event.getCreateArguments().getFields(18).getValue().getEnum().getConstructor();
    Orientation orientation = UserPropertyHelper.orientationFromString(orientationStr);
    String installedEquipment = event.getCreateArguments().getFields(19).getValue().getText();
    String additionalInformation = event.getCreateArguments().getFields(20).getValue().getText();
    String description = event.getCreateArguments().getFields(21).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements1 = event.getCreateArguments().getFields(22).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements1) {
        photoReferences.add(element.getText());
    }
    requestCreateResidenceRepository.persist(new RequestCreateResidence(operatorId + userId + propertyPostalCode, contractId, propertyId, residencePrice, propertyAddress, 
    propertyPostalCode, propertyDistrict, propertyCounty, grossArea, usableArea, bedrooms, bathrooms, floors, residenceType, 
    backyard, parking, buildDate, orientation, installedEquipment, additionalInformation, description, photoReferences));
  }

  private void handleRequestCreateWarehouseCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    BigDecimal warehousePrice = new BigDecimal(event.getCreateArguments().getFields(4).getValue().getNumeric());
    String propertyAddress = event.getCreateArguments().getFields(5).getValue().getText();
    String propertyPostalCode = event.getCreateArguments().getFields(6).getValue().getText();
    String propertyDistrict = event.getCreateArguments().getFields(7).getValue().getText();
    String propertyCounty = event.getCreateArguments().getFields(8).getValue().getText();
    String warehouseTypeStr = event.getCreateArguments().getFields(9).getValue().getEnum().getConstructor();
    WarehouseType warehouseType = UserPropertyHelper.warehouseTypeFromString(warehouseTypeStr);
    BigDecimal grossArea = new BigDecimal(event.getCreateArguments().getFields(10).getValue().getNumeric());
    BigDecimal usableArea = new BigDecimal(event.getCreateArguments().getFields(11).getValue().getNumeric());
    Long floors = event.getCreateArguments().getFields(12).getValue().getInt64();
    LocalDate buildDate = LocalDate.ofEpochDay(event.getCreateArguments().getFields(13).getValue().getDate());
    String installedEquipment = event.getCreateArguments().getFields(14).getValue().getText();
    String additionalInformation = event.getCreateArguments().getFields(15).getValue().getText();
    String description = event.getCreateArguments().getFields(16).getValue().getText();
    List<String> photoReferences = new ArrayList<>();
    List<ValueOuterClass.Value> elements1 = event.getCreateArguments().getFields(17).getValue().getList().getElementsList();
    for (ValueOuterClass.Value element : elements1) {
        photoReferences.add(element.getText());
    }
    requestCreateWarehouseRepository.persist(new RequestCreateWarehouse(operatorId + userId + propertyPostalCode, contractId, propertyId, warehousePrice, propertyAddress, 
    propertyPostalCode, propertyDistrict, propertyCounty, warehouseType, grossArea, usableArea, floors, buildDate, installedEquipment, 
    additionalInformation, description, photoReferences));
  }

  private void handlePropertyServiceOfferCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    propertyServiceOfferRepository.persist(new PropertyServiceOffer(operatorId + userId, contractId));
  }

  private void handleAccountFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    accountFactoryRepository.persist(new AccountFactory(operatorId, contractId));
  }

  private void handleHoldingFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    holdingFactoryRepository.persist(new HoldingFactory(operatorId, contractId));
  }

  private void handleHoldingFactoryInterfaceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    holdingFactoryInterfaceRepository.persist(new HoldingFactoryInterface(operatorId, contractId));
  }

  private void handleSettlementFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    settlementFactoryRepository.persist(new SettlementFactory(partyId, contractId));
  }

  private void handleRouteProviderCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    routeProviderRepository.persist(new RouteProvider(partyId, contractId));
  }

  private void handleClaimRuleCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    claimRuleRepository.persist(new ClaimRule(partyId, contractId));
  }

  private void handleCustodyServiceOfferCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    custodyServiceOfferRepository.persist(new CustodyServiceOffer(operatorId+userId, contractId));
  }

  private void handleIssuanceServiceOfferCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    issuanceServiceOfferRepository.persist(new IssuanceServiceOffer(operatorId+userId, contractId));
  }

  private void handleIssuanceServiceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    issuanceManagerRepository.persist(new IssuanceManager(operatorId+userId, contractId));
  }

  private void handleProfileManagerServiceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    userProfileManagerRepository.persist(new UserProfileManager(operatorId + userId, contractId));
  }

  private void handleRoleManagerServiceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    userRoleManagerRepository.persist(new UserRoleManager(operatorId + userId, contractId));
  }

  private void handlePropertyManagerServiceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    propertyManagerRepository.persist(new PropertyManager(operatorId + userId, contractId));
  }

  private void handleCustodyManagerServiceCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    custodyManagerRepository.persist(new CustodyManager(operatorId + userId, contractId));
  }

  private void handleUserHoldingFungibleCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(1).getValue().getParty();
    String userId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(0).getValue().getParty();
    String amountString = event.getCreateArguments().getFields(2).getValue().getNumeric();
    BigDecimal newAmount = new BigDecimal(amountString);
    try {
        UserHoldingFungible existingHolding = userHoldingFungibleRepository.findById(operatorId + userId);
        userHoldingFungibleRepository.deleteById(operatorId + userId);
        if (existingHolding != null) {
            // Sum the amounts
            BigDecimal updatedAmount = existingHolding.getAmount().add(newAmount);
            userHoldingFungibleRepository.persist(new UserHoldingFungible(operatorId + userId, contractId, updatedAmount));
        } else {
            // Create a new entry
            userHoldingFungibleRepository.persist(new UserHoldingFungible(operatorId + userId, contractId, newAmount));
        }
    } catch (Exception e) {
        // Handle any unexpected exceptions
        e.printStackTrace();
    }
  }

  private void handleUserHoldingTransferableCreatedEvent(CreatedEvent event, String contractId) {
    String propertyId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(2).getValue().getRecord().getFields(0).getValue().getText();
    String operatorId = event.getCreateArguments().getFields(0).getValue().getRecord().getFields(1).getValue().getParty();
    String userParty = event.getCreateArguments().getFields(1).getValue().getRecord().getFields(1).getValue().getParty();
    String postalCode = propertyId.substring("PropertyId".length());
    String propertyType = "";
    if(apartmentPropertyRepository.findById(operatorId+postalCode) != null)
      propertyType = "APARTMENT";
    else if(garagePropertyRepository.findById(operatorId+postalCode) != null)
      propertyType = "GARAGE";
    else if(landPropertyRepository.findById(operatorId+postalCode) != null)
      propertyType = "LAND";
    else if(residencePropertyRepository.findById(operatorId+postalCode) != null)
      propertyType = "RESIDENCE";
    else if(warehousePropertyRepository.findById(operatorId+postalCode) != null)
      propertyType = "WAREHOUSE";
    String userId = userParty.substring(0, userParty.indexOf("::"));
    userHoldingTransferableRepository.persist(new UserHoldingTransferable(operatorId + propertyId, contractId, userId, postalCode, propertyType));
  }

  private void handleUserSwapRequestCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String buyerId = event.getCreateArguments().getFields(1).getValue().getParty();
    String sellerId = event.getCreateArguments().getFields(2).getValue().getParty();
    String transferableCid = event.getCreateArguments().getFields(7).getValue().getContractId();
    String propertyType = "";
    String postalCode = "";
    List<UserHoldingTransferable> transferables = userHoldingTransferableRepository.findAll().list();
    for (UserHoldingTransferable userHoldingTransferable : transferables) {
      if(userHoldingTransferable.getContractId().equals(transferableCid)){
        propertyType = userHoldingTransferable.getPropertyType();
        postalCode = userHoldingTransferable.getPostalCode();
      }
    }
    userSwapRequestRepository.persist(new UserSwapRequest(operatorId + sellerId + buyerId + transferableCid, contractId, buyerId, propertyType, transferableCid, postalCode));
  }

  // ----------- Handle Archived Event Methods------------------------

  private void handleOperatorRoleArchivedEvent(String contractId) {
    operatorRepository.delete("contractId", contractId);
  }

  private void handleCredentialAppArchivedEvent(String contractId) {
    credentialAppRepository.delete("contractId", contractId);
  }

  private void handleUserRoleFactoryArchivedEvent(String contractId) {
    userRoleFactoryRepository.delete("contractId", contractId);
  }

  private void handleUserProfileFactoryArchivedEvent(String contractId) {
    userProfileFactoryRepository.delete("contractId", contractId);
  }

  private void handleProfileServiceOfferArchivedEvent(String contractId) {
    profileServiceOfferRepository.delete("contractId", contractId);
  }

  private void handleRequestCreateUserProfileArchivedEvent(String contractId) {
    userProfileCreateRequestRepository.delete("contractId", contractId);
  }

  private void handleRequestCreateUserAccountArchivedEvent(String contractId) {
    userAccountCreateRequestRepository.delete("contractId", contractId);
  }

  private void handleRequestCloseUserAccountArchivedEvent(String contractId) {
    userAccountCloseRequestRepository.delete("contractId", contractId);
  }

  private void handleRequestDepositArchivedEvent(String contractId) {
    userAccountDepositRequestRepository.delete("contractId", contractId);
  }

  private void handleRequestWithdrawArchivedEvent(String contractId) {
    userAccountWithdrawRequestRepository.delete("contractId", contractId);
  }

  private void handleRequestIssueArchivedEvent(String contractId) {
    issueRequestRepository.delete("contractId", contractId);
  }

  private void handleRequestDeIssueArchivedEvent(String contractId) {
    deIssueRequestRepository.delete("contractId", contractId);
  }

  private void handleRequestCreateApartmentArchivedEvent(String contractId) {
    requestCreateApartmentRepository.delete("contractId", contractId);
  }

  private void handleRequestCreateGarageArchivedEvent(String contractId) {
    requestCreateGarageRepository.delete("contractId", contractId);
  }

  private void handleRequestCreateLandArchivedEvent(String contractId) {
    requestCreateLandRepository.delete("contractId", contractId);
  }

  private void handleRequestCreateResidenceArchivedEvent(String contractId) {
    requestCreateResidenceRepository.delete("contractId", contractId);
  }

  private void handleRequestCreateWarehouseArchivedEvent(String contractId) {
    requestCreateWarehouseRepository.delete("contractId", contractId);
  }

  private void handleApartmentPropertyArchivedEvent(String contractId) {
    apartmentPropertyRepository.delete("contractId", contractId);
  }

  private void handleGaragePropertyArchivedEvent(String contractId) {
    garagePropertyRepository.delete("contractId", contractId);
  }

  private void handleLandPropertyArchivedEvent(String contractId) {
    landPropertyRepository.delete("contractId", contractId);
  }

  private void handleResidencePropertyArchivedEvent(String contractId) {
    residencePropertyRepository.delete("contractId", contractId);
  }

  private void handleWarehousePropertyArchivedEvent(String contractId) {
    warehousePropertyRepository.delete("contractId", contractId);
  }

  private void handleApartmentPropertyInterfaceReferenceArchivedEvent(String contractId) {
    apartmentPropertyInterfaceReferenceRepository.delete("contractId", contractId);
  }

  private void handleGaragePropertyInterfaceReferenceArchivedEvent(String contractId) {
    garagePropertyInterfaceReferenceRepository.delete("contractId", contractId);
  }

  private void handleLandPropertyInterfaceReferenceArchivedEvent(String contractId) {
    landPropertyInterfaceReferenceRepository.delete("contractId", contractId);
  }

  private void handleResidencePropertyInterfaceReferenceArchivedEvent(String contractId) {
    residencePropertyInterfaceReferenceRepository.delete("contractId", contractId);
  }

  private void handleWarehousePropertyInterfaceReferenceArchivedEvent(String contractId) {
    warehousePropertyInterfaceReferenceRepository.delete("contractId", contractId);
  }

  private void handleUserAccountArchivedEvent(String contractId) {
    userAccountRepository.delete("contractId", contractId);
  }

  private void handleUserAccountInterfaceArchivedEvent(String contractId) {
    userAccountInterfaceRepository.delete("contractId", contractId);
  }

  private void handleUserProfileArchivedEvent(String contractId) {
    userProfileRepository.delete("contractId", contractId);
  }

  private void handleUserProfileReferenceInterfaceArchivedEvent(String contractId) {
    userProfileReferenceInterfaceRepository.delete("contractId", contractId);
  }

  private void handleRoleUserRoleArchivedEvent(String contractId) {
    userRoleAppRepository.delete("contractId", contractId);
  }

  private void handleRoleUserRoleInterfaceArchivedEvent(String contractId) {
    userRoleInterfaceRepository.delete("contractId", contractId);
  }

  private void handleRoleManagerUserRoleArchivedEvent(String contractId) {
    userRoleRepository.delete("contractId", contractId);
  }

  private void handleUserRoleOfferArchivedEvent(String contractId) {
    userRoleOfferRepository.delete("contractId", contractId);
  }

  private void handleApartmentPropertyFactoryArchivedEvent(String contractId) {
    apartmentPropertyFactoryRepository.delete("contractId", contractId);
  }

  private void handleGaragePropertyFactoryArchivedEvent(String contractId) {
    garagePropertyFactoryRepository.delete("contractId", contractId);
  }

  private void handleLandPropertyFactoryArchivedEvent(String contractId) {
    landPropertyFactoryRepository.delete("contractId", contractId);
  }

  private void handleResidencePropertyFactoryArchivedEvent(String contractId) {
    residencePropertyFactoryRepository.delete("contractId", contractId);
  }

  private void handleWarehousePropertyFactoryArchivedEvent(String contractId) {
    warehousePropertyFactoryRepository.delete("contractId", contractId);
  }

  private void handlePropertyServiceOfferArchivedEvent(String contractId) {
    propertyServiceOfferRepository.delete("contractId", contractId);
  }

  private void handleAccountFactoryArchivedEvent(String contractId) {
    accountFactoryRepository.delete("contractId", contractId);
  }

  private void handleHoldingFactoryArchivedEvent(String contractId) {
    holdingFactoryRepository.delete("contractId", contractId);
  }

  private void handleHoldingFactoryInterfaceArchivedEvent(String contractId) {
    holdingFactoryInterfaceRepository.delete("contractId", contractId);
  }

  private void handleSettlementFactoryArchivedEvent(String contractId) {
    settlementFactoryRepository.delete("contractId", contractId);
  }

  private void handleRouteProviderArchivedEvent(String contractId) {
    routeProviderRepository.delete("contractId", contractId);
  }

  private void handleClaimRuleArchivedEvent(String contractId) {
    claimRuleRepository.delete("contractId", contractId);
  }

  private void handleCustodyServiceOfferArchivedEvent(String contractId) {
    custodyServiceOfferRepository.delete("contractId", contractId);
  }

  private void handleIssuanceServiceOfferArchivedEvent(String contractId) {
    issuanceServiceOfferRepository.delete("contractId", contractId);
  }

  private void handleIssuanceServiceArchivedEvent(String contractId) {
    issuanceManagerRepository.delete("contractId", contractId);
  }

  private void handleProfileManagerServiceArchivedEvent(String contractId) {
    userProfileManagerRepository.delete("contractId", contractId);
  }

  private void handleRoleManagerServiceArchivedEvent(String contractId) {
    userRoleManagerRepository.delete("contractId", contractId);
  }

  private void handlePropertyManagerServiceArchivedEvent(String contractId) {
    propertyManagerRepository.delete("contractId", contractId);
  }

  private void handleCustodyManagerServiceArchivedEvent(String contractId) {
    custodyManagerRepository.delete("contractId", contractId);
  }

  private void handleUserHoldingFungibleArchivedEvent(String contractId) {
    userHoldingFungibleRepository.delete("contractId", contractId);
  }

  private void handleUserHoldingTransferableArchivedEvent(String contractId) {
    userHoldingTransferableRepository.delete("contractId", contractId);
  }

  private void handleUserSwapRequestArchivedEvent(String contractId) {
    userSwapRequestRepository.delete("contractId", contractId);
  }

  // ------------------------------------------------------------------------

  public Transaction submitTransaction(List<com.daml.ledger.javaapi.data.Command> commands, List<String> actAs, List<String> readAs) throws IllegalArgumentException,IllegalStateException, Exception{
    client = clientProvider.getClient();
    CommandsSubmission commandsSubmission = CommandsSubmission.create(APP_ID,UUID.randomUUID().toString(),commands).withActAs(actAs); 
    if(readAs != null){
        commandsSubmission.withReadAs(readAs);
    }              
    Transaction response = client.getCommandClient().submitAndWaitForTransaction(commandsSubmission).blockingGet().toProto();
    return response;      
  }
}
