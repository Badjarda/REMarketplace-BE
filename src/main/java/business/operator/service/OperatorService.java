package business.operator.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.custody.entity.repository.AccountFactoryRepository;
import business.custody.entity.repository.CustodyManagerRepository;
import business.issuance.entity.repository.IssuanceManagerRepository;
import business.issuer.entity.repository.DeIssueRequestRepository;
import business.issuer.entity.repository.IssueRequestRepository;
import business.operator.entity.repository.OperatorRepository;
import business.profilemanager.entity.repository.UserProfileManagerRepository;
import business.propertymanager.entity.repository.ApartmentPropertyFactoryRepository;
import business.propertymanager.entity.repository.GaragePropertyFactoryRepository;
import business.propertymanager.entity.repository.LandPropertyFactoryRepository;
import business.propertymanager.entity.repository.PropertyManagerRepository;
import business.propertymanager.entity.repository.ResidencePropertyFactoryRepository;
import business.propertymanager.entity.repository.WarehousePropertyFactoryRepository;
import business.rolemanager.entity.repository.UserRoleFactoryRepository;
import business.user.entity.repository.UserRepository;
import business.useraccount.entity.repository.UserAccountCloseRequestRepository;
import business.useraccount.entity.repository.UserAccountCreateRequestRepository;
import business.useraccount.entity.repository.UserAccountDepositRequestRepository;
import business.useraccount.entity.repository.UserAccountWithdrawRequestRepository;
import business.userprofile.entity.repository.UserProfileCreateRequestRepository;
import business.userproperty.entity.repository.RequestCreateApartmentRepository;
import business.userproperty.entity.repository.RequestCreateGarageRepository;
import business.userproperty.entity.repository.RequestCreateLandRepository;
import business.userproperty.entity.repository.RequestCreateResidenceRepository;
import business.userproperty.entity.repository.RequestCreateWarehouseRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import daml.da.set.types.Set;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.interface$.types.common.types.HoldingFactoryKey;

import com.daml.ledger.api.v1.TransactionOuterClass.Transaction;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.codegen.Created;
import com.daml.ledger.javaapi.data.codegen.Update;
import daml.marketplace.app.role.operator.Role;
import daml.marketplace.interface$.rolemanager.userrole.permission.Permission;
import business.profilemanager.entity.repository.UserProfileFactoryRepository;
import daml.marketplace.interface$.common.types.UserRoleKey;

@ApplicationScoped
public class OperatorService {
    @Inject
    DamlLedgerClientProvider clientProvider;

    @Inject
    UserRepository userRepository;

    @Inject
    OperatorRepository operatorRepository;

    @Inject
    UserRoleFactoryRepository userRoleFactoryRepository;

    @Inject
    UserProfileFactoryRepository userProfileFactoryRepository;

    @Inject
    UserProfileManagerRepository userProfileManagerRepository;

    @Inject
    CustodyManagerRepository custodyManagerRepository;

    @Inject
    UserProfileCreateRequestRepository userProfileCreateRequestRepository;

    @Inject
    UserAccountCreateRequestRepository userAccountCreateRequestRepository;

    @Inject
    UserAccountCloseRequestRepository userAccountCloseRequestRepository;
    
    @Inject
    UserAccountDepositRequestRepository userAccountDepositRequestRepository;

    @Inject
    UserAccountWithdrawRequestRepository userAccountWithdrawRequestRepository;

    @Inject
    AccountFactoryRepository accountFactoryRepository;

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
    PropertyManagerRepository propertyManagerRepository;
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
    IssuanceManagerRepository issuanceManagerRepository;
    @Inject
    IssueRequestRepository issueRequestRepository;
    @Inject
    DeIssueRequestRepository deIssueRequestRepository;
    @Inject
    Transactions transactionService;

    public static final String APP_ID = "OperatorId";

    public OperatorService() {

    }

    public String createOperatorRole(String operator) {

        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userRoleFactoryCid = userRoleFactoryRepository.findById(operatorParty).getContractId();

            var contractId = new daml.marketplace.interface$.rolemanager.userrole.factory.Factory.ContractId(
                    userRoleFactoryCid);

            Update<Created<Role.ContractId>> createRole = Role.create(operatorParty, contractId);

            List<com.daml.ledger.javaapi.data.Command> createCommands = createRole.commands();

            Transaction transaction =  transactionService.submitTransaction(createCommands, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Creating Operator: " + operator + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Creating Operator : " + operator + e.getMessage() + "\n";
        }

        return "Operator Role " + operator + " successfully created!\n";
    }

    public String createInitialRole(String operator, String publicUser) {

        try {
            List<Permission> registeredUserPermissions = new ArrayList<>(Arrays.asList(
                    Permission.VIEW_ALL_MARKETPLACE_TRANSACTIONS, Permission.MANAGE_ALL_MARKETPLACE_TRANSACTIONS,
                    Permission.VIEW_ROLE, Permission.MANAGE_ROLE,
                    Permission.MANAGE_PERMISSION, Permission.VIEW_TRANSACTION,
                    Permission.MANAGE_TRANSACTION));

            String registeredUserDescription = "Registered User Role";

            String operatorParty = userRepository.findById(operator).getPartyId();
            String publicParty = userRepository.findById(publicUser).getPartyId();
            String operatorContractId = operatorRepository.findById(operatorParty).getContractId();

            daml.marketplace.interface$.role.operator.Role.ContractId operatorId = new daml.marketplace.interface$.role.operator.Role.ContractId(
                    operatorContractId);

            Map<String, Unit> singletonMap = Collections.singletonMap(publicParty, Unit.getInstance());
            Set<String> observers = new Set<>(singletonMap);
            Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
            observersMap.put("Default", observers);
            List<com.daml.ledger.javaapi.data.Command> commands = operatorId.exerciseCreateInitialRole(
                    registeredUserDescription, registeredUserPermissions, observersMap).commands();

            Transaction transaction =  transactionService.submitTransaction(commands, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Creating Initial Role: " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Creating Initial Role: " + e.getMessage() + "\n";
        }
        return "Created Initial Roles!\n";
    }

    public String offerUserRole(String operator, String user, String userRoleId) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String operatorContractId = operatorRepository.findById(operatorParty).getContractId();

            var operatorId = new daml.marketplace.interface$.role.operator.Role.ContractId(
                    operatorContractId);

            Id userRoleKeyId = new Id(userRoleId);
            UserRoleKey key = new UserRoleKey(operatorParty, userRoleKeyId);

            List<com.daml.ledger.javaapi.data.Command> exerciseCommands = operatorId.exerciseOfferUserRole(userParty, key).commands();

            Transaction transaction = transactionService.submitTransaction(exerciseCommands, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Offer User : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Offer User : " + e.getMessage() + "\n";
        }
        return "User Role Successfully Offered!\n";
    }

    public String offerCustodianService(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String operatorContractId = operatorRepository.findById(operatorParty).getContractId();

            var operatorId = new daml.marketplace.interface$.role.operator.Role.ContractId(
                    operatorContractId);

            String accountFactoryCid = accountFactoryRepository.findById(operatorParty).getContractId();
            var accountFactoryContractid = new daml.daml.finance.interface$.account.factory.Factory.ContractId(
                    accountFactoryCid);

            Id holdingFactoryId = new Id("TransferableUser");
            HoldingFactoryKey holdingFactoryKey = new HoldingFactoryKey(operatorParty, holdingFactoryId);

            String claimRuleCid = accountFactoryRepository.findById(operatorParty).getContractId();
            var claimRuleContractid = new daml.daml.finance.interface$.lifecycle.rule.claim.Claim.ContractId(
                    claimRuleCid);

            List<com.daml.ledger.javaapi.data.Command> exerciseCommands = operatorId
                    .exerciseOfferCustodianService(userParty, accountFactoryContractid, holdingFactoryKey,
                            claimRuleContractid)
                    .commands();

            Transaction transaction = transactionService.submitTransaction(exerciseCommands, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Offer Custodian Service : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Offer Custodian Service : " + e.getMessage() + "\n";
        }
        return "Custodian Service Successfully Offered!\n";
    }

    public String offerUserProfileService(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String operatorContractId = operatorRepository.findById(operatorParty).getContractId();

            var operatorId = new daml.marketplace.interface$.role.operator.Role.ContractId(
                    operatorContractId);
            String userProfileFactoryCid = userProfileFactoryRepository.findById(operatorParty).getContractId();
            var userProfileFactoryContractid = new daml.marketplace.interface$.profilemanager.userprofile.factory.Factory.ContractId(
                    userProfileFactoryCid);

            List<com.daml.ledger.javaapi.data.Command> exerciseCommands = operatorId
                    .exerciseOfferUserProfileManagerService(userParty, userProfileFactoryContractid)
                    .commands();
            
            Transaction transaction = transactionService.submitTransaction(exerciseCommands, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Offer User Profile Service : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Offer User Profile Service : " + e.getMessage() + "\n";
        }
        return "User Profile Service Successfully Offered!\n";
    }

    public String offerPropertyManagerService(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String operatorContractId = operatorRepository.findById(operatorParty).getContractId();

            var operatorId = new daml.marketplace.interface$.role.operator.Role.ContractId(
                    operatorContractId);

            String apartmentPropertyFactoryCid = apartmentPropertyFactoryRepository.findById(operatorParty)
                    .getContractId();
            var apartmentPropertyFactoryContractid = new daml.marketplace.interface$.propertymanager.property.apartmentproperty.factory.Factory.ContractId(
                    apartmentPropertyFactoryCid);

            String landPropertyFactoryCid = landPropertyFactoryRepository.findById(operatorParty)
                    .getContractId();
            var landPropertyFactoryContractid = new daml.marketplace.interface$.propertymanager.property.landproperty.factory.Factory.ContractId(
                    landPropertyFactoryCid);

            String residencePropertyFactoryCid = residencePropertyFactoryRepository.findById(operatorParty)
                    .getContractId();
            var residencePropertyFactoryContractid = new daml.marketplace.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId(
                    residencePropertyFactoryCid);

            String garagePropertyFactoryCid = garagePropertyFactoryRepository.findById(operatorParty)
                    .getContractId();
            var garagePropertyFactoryContractid = new daml.marketplace.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId(
                    garagePropertyFactoryCid);

            String warehousePropertyFactoryCid = warehousePropertyFactoryRepository.findById(operatorParty)
                    .getContractId();
            var warehousePropertyFactoryContractid = new daml.marketplace.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId(
                    warehousePropertyFactoryCid);

            List<com.daml.ledger.javaapi.data.Command> exerciseCommands = operatorId
                    .exerciseOfferPropertyManagerService(userParty, apartmentPropertyFactoryContractid,
                            landPropertyFactoryContractid, residencePropertyFactoryContractid,
                            garagePropertyFactoryContractid, warehousePropertyFactoryContractid)
                    .commands();

            Transaction transaction =  transactionService.submitTransaction(exerciseCommands, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Offer Property Manager Service : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Offer Property Manager Service : " + e.getMessage() + "\n";
        }
        return "Property Manager Service Successfully Offered!\n";
    }

    public String offerIssuanceService(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String operatorContractId = operatorRepository.findById(operatorParty).getContractId();

            var operatorId = new daml.marketplace.interface$.role.operator.Role.ContractId(
                    operatorContractId);

            List<com.daml.ledger.javaapi.data.Command> exerciseCommands = operatorId
                    .exerciseOfferIssuanceService(userParty)
                    .commands();

            Transaction transaction =  transactionService.submitTransaction(exerciseCommands, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Offer Issuance Service : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Offer Issuance Service : " + e.getMessage() + "\n";
        }
        return "Issuance Service Successfully Offered!\n";
    }

    public String acceptRequestCreateProfile(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = userProfileManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            daml.marketplace.interface$.profilemanager.service.Service.ContractId serviceId = new daml.marketplace.interface$.profilemanager.service.Service.ContractId(
                    servicId);

            String rId = userProfileCreateRequestRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId(
                    rId);

            var command = serviceId.exerciseCreateUserProfile(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Creating User Profile : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Creating User Profile  : " + e.getMessage() + "\n";
        }

        return "User Profile Successfully Created!\n";
    }

    public String acceptRequestOpenAccount(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = custodyManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(
                    servicId);

            String rId = userAccountCreateRequestRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.custody.choices.openaccountrequest.OpenAccountRequest.ContractId(
                    rId);

            var command = serviceId.exerciseOpenAccount(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Opening User Account : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Opening User Account  : " + e.getMessage() + "\n";
        }

        return "User Account Successfully Opened!\n";
    }

    public String acceptRequestCloseAccount(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = custodyManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(
                    servicId);

            String rId = userAccountCloseRequestRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.custody.choices.closeaccountrequest.CloseAccountRequest.ContractId(rId);

            var command = serviceId.exerciseCloseAccount(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Closing User Account : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Closing User Account  : " + e.getMessage() + "\n";
        }

        return "User Account Successfully Closed!\n";
    }

    public String acceptRequestDeposit(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = custodyManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(
                    servicId);

            String rId = userAccountDepositRequestRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.custody.choices.depositrequest.DepositRequest.ContractId(rId);

            var command = serviceId.exerciseDeposit(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Deposit in User Account : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Deposit in User Account  : " + e.getMessage() + "\n";
        }
        return "Successfully Deposit in User Account!\n";
    }

    public String acceptRequestWithdraw(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = custodyManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            var serviceId = new daml.marketplace.interface$.custody.service.Service.ContractId(
                    servicId);

            String rId = userAccountWithdrawRequestRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.custody.choices.withdrawrequest.WithdrawRequest.ContractId(rId);

            var command = serviceId.exerciseWithdrawal(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Withdraw in User Account : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Withdraw in User Account  : " + e.getMessage() + "\n";
        }
        return "Successfully Withdraw in User Account!\n";
    }

    public String acceptRequestIssue(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = issuanceManagerRepository.findById(operatorParty + userParty).getContractId();
            var serviceId = new daml.marketplace.interface$.issuance.service.Service.ContractId(
                    servicId);

            String rId = issueRequestRepository.findById(operatorParty + userParty).getContractId();
            var requestId = new daml.marketplace.interface$.issuance.choices.issuerequest.IssueRequest.ContractId(rId);

            var command = serviceId.exerciseIssue(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Issue in User Account : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Issue in User Account  : " + e.getMessage() + "\n";
        }
        return "Successfully Issue in User Account!\n";
    }

    public String acceptRequestDeIssue(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = issuanceManagerRepository.findById(operatorParty + userParty).getContractId();
            var serviceId = new daml.marketplace.interface$.issuance.service.Service.ContractId(
                    servicId);

            String rId = deIssueRequestRepository.findById(operatorParty + userParty).getContractId();
            var requestId = new daml.marketplace.interface$.issuance.choices.deissuerequest.DeIssueRequest.ContractId(rId);

            var command = serviceId.exerciseDeIssue(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error DeIssue in User Account : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error DeIssue in User Account  : " + e.getMessage() + "\n";
        }
        return "Successfully DeIssue in User Account!\n";
    }

    public String acceptRequestCreateApartmentProperty(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = propertyManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
                    servicId);

            String rId = requestCreateApartmentRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId(
                    rId);

            var command = serviceId.exerciseCreateApartmentProperty(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Creating Apartment Property : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Creating Apartment Property  : " + e.getMessage() + "\n";
        }
        return "Apartment Property Successfully Created!\n";
    }

    public String acceptRequestCreateGarageProperty(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = propertyManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
                    servicId);

            String rId = requestCreateGarageRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty.ContractId(
                    rId);

            var command = serviceId.exerciseCreateGarageProperty(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Creating Garage Property : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Creating Garage Property  : " + e.getMessage() + "\n";
        }
        return "Garage Property Successfully Created!\n";
    }

    public String acceptRequestCreateLandProperty(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = propertyManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
                    servicId);

            String rId = requestCreateLandRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId(
                    rId);

            var command = serviceId.exerciseCreateLandProperty(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Creating Land Property : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Creating Land Property  : " + e.getMessage() + "\n";
        }
        return "Land Property Successfully Created!\n";
    }

    public String acceptRequestCreateResidenceProperty(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = propertyManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
                    servicId);

            String rId = requestCreateResidenceRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.propertymanager.choices.requestcreateresidenceproperty.RequestCreateResidenceProperty.ContractId(
                    rId);

            var command = serviceId.exerciseCreateResidenceProperty(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Creating Residence Property : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Creating Residence Property  : " + e.getMessage() + "\n";
        }
        return "Residence Property Successfully Created!\n";
    }

    public String acceptRequestCreateWarehouseProperty(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String servicId = propertyManagerRepository.findById(operatorParty + userParty)
                    .getContractId();
            var serviceId = new daml.marketplace.interface$.propertymanager.service.Service.ContractId(
                    servicId);

            String rId = requestCreateWarehouseRepository.findById(operatorParty + userParty)
                    .getContractId();
            var requestId = new daml.marketplace.interface$.propertymanager.choices.requestcreatewarehouseproperty.RequestCreateWarehouseProperty.ContractId(
                    rId);

            var command = serviceId.exerciseCreateWarehouseProperty(requestId).commands();
            Transaction transaction = transactionService.submitTransaction(command, Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error Creating Warehouse Property : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error Creating Warehouse Property  : " + e.getMessage() + "\n";
        }
        return "Warehouse Property Successfully Created!\n";
    }

}
