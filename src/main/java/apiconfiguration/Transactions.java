package apiconfiguration;

import java.util.List;
import java.util.UUID;

import com.daml.ledger.api.v1.EventOuterClass.CreatedEvent;
import com.daml.ledger.api.v1.EventOuterClass.Event;
import com.daml.ledger.api.v1.TransactionOuterClass;
import com.daml.ledger.api.v1.TransactionServiceOuterClass;
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
import business.issuance.entity.model.IssuanceManager;
import business.issuance.entity.repository.IssuanceManagerRepository;
import business.issuer.entity.model.DeIssueRequest;
import business.issuer.entity.model.IssuanceServiceOffer;
import business.issuer.entity.model.IssueRequest;
import business.issuer.entity.repository.DeIssueRequestRepository;
import business.issuer.entity.repository.IssuanceServiceOfferRepository;
import business.issuer.entity.repository.IssueRequestRepository;
import business.operator.entity.model.Operator;

import business.operator.entity.repository.OperatorRepository;
import business.party.entity.repository.PartyRepository;

import business.rolemanager.entity.model.UserRoleFactory;
import business.rolemanager.entity.model.UserRoleManager;
import business.rolemanager.entity.repository.UserRoleFactoryRepository;
import business.rolemanager.entity.repository.UserRoleManagerRepository;
import business.useraccount.entity.model.CustodyServiceOffer;
import business.useraccount.entity.model.UserAccount;
import business.useraccount.entity.model.UserAccountCloseRequest;
import business.useraccount.entity.model.UserAccountCreateRequest;
import business.useraccount.entity.model.UserAccountDepositRequest;
import business.useraccount.entity.model.UserAccountWithdrawRequest;
import business.useraccount.entity.model.UserHoldingFungible;
import business.useraccount.entity.model.UserHoldingTransferable;
import business.useraccount.entity.repository.CustodyServiceOfferRepository;
import business.useraccount.entity.repository.UserAccountCloseRequestRepository;
import business.useraccount.entity.repository.UserAccountCreateRequestRepository;
import business.useraccount.entity.repository.UserAccountDepositRequestRepository;
import business.useraccount.entity.repository.UserAccountRepository;
import business.useraccount.entity.repository.UserAccountWithdrawRequestRepository;
import business.useraccount.entity.repository.UserHoldingFungibleRepository;
import business.useraccount.entity.repository.UserHoldingTransferableRepository;
import business.userprofile.entity.model.ProfileServiceOffer;
import business.userprofile.entity.model.UserProfile;
import business.userprofile.entity.model.UserProfileCreateRequest;
import business.userprofile.entity.repository.ProfileServiceOfferRepository;
import business.userprofile.entity.repository.UserProfileCreateRequestRepository;
import business.userprofile.entity.repository.UserProfileRepository;
import business.userproperty.entity.model.ApartmentProperty;
import business.userproperty.entity.model.GarageProperty;
import business.userproperty.entity.model.LandProperty;
import business.userproperty.entity.model.PropertyServiceOffer;
import business.userproperty.entity.model.RequestCreateApartment;
import business.userproperty.entity.model.RequestCreateGarage;
import business.userproperty.entity.model.RequestCreateLand;
import business.userproperty.entity.model.RequestCreateResidence;
import business.userproperty.entity.model.RequestCreateWarehouse;
import business.userproperty.entity.model.ResidenceProperty;
import business.userproperty.entity.model.WarehouseProperty;
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
import business.userrole.entity.model.UserRole;
import business.userrole.entity.model.UserRoleApp;
import business.userrole.entity.model.UserRoleInterface;
import business.userrole.entity.model.UserRoleOffer;
import business.userrole.entity.repository.UserRoleAppRepository;
import business.userrole.entity.repository.UserRoleInterfaceRepository;
import business.userrole.entity.repository.UserRoleOfferRepository;
import business.userrole.entity.repository.UserRoleRepository;
import business.profilemanager.entity.model.UserProfileFactory;
import business.profilemanager.entity.model.UserProfileManager;
import business.profilemanager.entity.repository.UserProfileFactoryRepository;
import business.profilemanager.entity.repository.UserProfileManagerRepository;
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
import daml.marketplace.app.role.operator.Role;
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
  UserProfileFactoryRepository userProfileFactoryRepository;
  @Inject
  UserProfileManagerRepository userProfileManagerRepository;
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
  UserAccountRepository userAccountRepository;
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
    } else if (templateId.equals(daml.daml.finance.account.account.Factory.TEMPLATE_ID.toProto())) {
      handleAccountFactoryCreatedEvent(created, contractId);
    } else if (templateId.equals(daml.daml.finance.holding.factory.Factory.TEMPLATE_ID.toProto())) {
      handleHoldingFactoryCreatedEvent(created, contractId);
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
    } else {
      System.out.println("Unsupported template ID: " + templateId.toString() + "\n");
    }
  }

  private void handleArchivedEvent(ArchivedEvent archived) {
    Identifier templateId = archived.getTemplateId();
    String contractId = archived.getContractId();
    if (templateId.equals(Role.TEMPLATE_ID.toProto())) {
      handleOperatorRoleArchivedEvent(contractId);
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
    } else if (templateId.equals(daml.daml.finance.account.account.Factory.TEMPLATE_ID.toProto())) {
      handleAccountFactoryArchivedEvent(contractId);
    } else if (templateId.equals(daml.daml.finance.holding.factory.Factory.TEMPLATE_ID.toProto())) {
      handleHoldingFactoryArchivedEvent(contractId);
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
    } else {
      System.out.println("Unsupported template ID: " + templateId.toString() + "\n");
    }
  }

  // ----------- Handle Create Event Methods------------------------

  private void handleOperatorRoleCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    operatorRepository.persist(new Operator(partyId, contractId));
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
    System.out.println(operatorId+userId);
    userProfileCreateRequestRepository.persist(new UserProfileCreateRequest(operatorId+userId, contractId));
  }

  private void handleRequestCreateUserAccountCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    userAccountCreateRequestRepository.persist(new UserAccountCreateRequest(partyId, contractId));
  }

  private void handleRequestCloseUserAccountCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    userAccountCloseRequestRepository.persist(new UserAccountCloseRequest(partyId, contractId));
  }

  private void handleRequestDepositCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    userAccountDepositRequestRepository.persist(new UserAccountDepositRequest(partyId, contractId));
  }

  private void handleRequestWithdrawCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    userAccountWithdrawRequestRepository.persist(new UserAccountWithdrawRequest(partyId, contractId));
  }

  private void handleRequestIssueCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    issueRequestRepository.persist(new IssueRequest(partyId, contractId));
  }

  private void handleRequestDeIssueCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    deIssueRequestRepository.persist(new DeIssueRequest(partyId, contractId));
  }

  private void handleUserAccountCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String accountId = event.getCreateArguments().getFields(2).getValue().getParty();
    userAccountRepository.persist(new UserAccount(operatorId + userId, contractId, accountId));
  }

  private void handleUserProfileCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String profileId = event.getCreateArguments().getFields(2).getValue().getParty();
    userProfileRepository.persist(new UserProfile(operatorId + userId, contractId, profileId));
  }

  private void handleApartmentPropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getParty();
    apartmentPropertyRepository.persist(new ApartmentProperty(operatorId + userId, contractId, propertyId));
  }

  private void handleGaragePropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getParty();
    garagePropertyRepository.persist(new GarageProperty(operatorId + userId, contractId, propertyId));
  }

  private void handleLandPropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getParty();
    landPropertyRepository.persist(new LandProperty(operatorId + userId, contractId, propertyId));
  }

  private void handleResidencePropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getParty();
    residencePropertyRepository.persist(new ResidenceProperty(operatorId + userId, contractId, propertyId));
  }

  private void handleWarehousePropertyCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String propertyId = event.getCreateArguments().getFields(2).getValue().getParty();
    warehousePropertyRepository.persist(new WarehouseProperty(operatorId + userId, contractId, propertyId));
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
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    requestCreateApartmentRepository.persist(new RequestCreateApartment(partyId, contractId));
  }

  private void handleRequestCreateGarageCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    requestCreateGarageRepository.persist(new RequestCreateGarage(partyId, contractId));
  }

  private void handleRequestCreateLandCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    requestCreateLandRepository.persist(new RequestCreateLand(partyId, contractId));
  }

  private void handleRequestCreateResidenceCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    requestCreateResidenceRepository.persist(new RequestCreateResidence(partyId, contractId));
  }

  private void handleRequestCreateWarehouseCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    requestCreateWarehouseRepository.persist(new RequestCreateWarehouse(partyId, contractId));
  }

  private void handlePropertyServiceOfferCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    propertyServiceOfferRepository.persist(new PropertyServiceOffer(partyId, contractId));
  }

  private void handleAccountFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    accountFactoryRepository.persist(new AccountFactory(partyId, contractId));
  }

  private void handleHoldingFactoryCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    holdingFactoryRepository.persist(new HoldingFactory(partyId, contractId));
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
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    custodyServiceOfferRepository.persist(new CustodyServiceOffer(partyId, contractId));
  }

  private void handleIssuanceServiceOfferCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    issuanceServiceOfferRepository.persist(new IssuanceServiceOffer(partyId, contractId));
  }

  private void handleIssuanceServiceCreatedEvent(CreatedEvent event, String contractId) {
    String partyId = event.getCreateArguments().getFields(0).getValue().getParty();
    issuanceManagerRepository.persist(new IssuanceManager(partyId, contractId));
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
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String holdingCid = event.getCreateArguments().getFields(2).getValue().getParty();
    userHoldingFungibleRepository.persist(new UserHoldingFungible(operatorId + userId, contractId, holdingCid));
  }

  private void handleUserHoldingTransferableCreatedEvent(CreatedEvent event, String contractId) {
    String operatorId = event.getCreateArguments().getFields(0).getValue().getParty();
    String userId = event.getCreateArguments().getFields(1).getValue().getParty();
    String holdingCid = event.getCreateArguments().getFields(2).getValue().getParty();
    userHoldingTransferableRepository.persist(new UserHoldingTransferable(operatorId + userId, contractId, holdingCid));
  }

  // ----------- Handle Archived Event Methods------------------------

  private void handleOperatorRoleArchivedEvent(String contractId) {
    operatorRepository.delete("contractId", contractId);
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

  private void handleUserAccountArchivedEvent(String contractId) {
    userAccountRepository.delete("contractId", contractId);
  }

  private void handleUserProfileArchivedEvent(String contractId) {
    userProfileRepository.delete("contractId", contractId);
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
