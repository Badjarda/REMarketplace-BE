package business.custody.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daml.ledger.api.v1.TransactionOuterClass.Transaction;
import com.daml.ledger.javaapi.data.Command;
import com.daml.ledger.javaapi.data.Unit;
import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.custody.entity.model.AccountFactory;
import business.custody.entity.model.HoldingFactory;
import business.custody.entity.model.SettlementFactory;
import business.custody.entity.repository.AccountFactoryRepository;
import business.custody.entity.repository.HoldingFactoryRepository;
import business.custody.entity.repository.RouteProviderRepository;
import business.custody.entity.repository.SettlementFactoryRepository;
import business.user.entity.repository.UserRepository;
import daml.da.set.types.Set;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.daml.finance.settlement.hierarchy.Hierarchy;
import daml.daml.finance.interface$.holding.factory.View;

@ApplicationScoped
public class AccountManagerService {

    @Inject
    DamlLedgerClientProvider clientProvider;

    @Inject
    UserRepository userRepository;

    @Inject
    Transactions transactionService;

    @Inject
    HoldingFactoryRepository holdingFactoryRepository;

    @Inject
    SettlementFactoryRepository settlementFactoryRepository;

    @Inject
    RouteProviderRepository routeProviderRepository;

    @Inject
    AccountFactoryRepository accountFactoryRepository;

    public static final String APP_ID = "OperatorId";

    public AccountManagerService() {

    }

    public String createCustodyService(String operator, String user, String publicString, String holdingTypeId) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            String publicParty = userRepository.findById(publicString).getPartyId();

            Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
            Set<String> observers = new Set<>(singletonMap);
            Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
            observersMap.put("Default", observers);

            Map<String, Unit> singletonMap2 = Collections.singletonMap(publicParty, Unit.getInstance());
            Set<String> observers2 = new Set<>(singletonMap2);
            Map<String, Set<String>> observersMap2 = new HashMap<String, Set<String>>();
            observersMap2.put("Default", observers2);

            Map<String, Unit> singletonMap3 = Collections.singletonMap(userParty, Unit.getInstance());
            Set<String> observers3 = new Set<>(singletonMap3);
            Map<String, Set<String>> observersMap3 = new HashMap<String, Set<String>>();
            observersMap3.put("Default", observers3);

            Id holdingId = new Id(holdingTypeId);

            createAccountFactory(operatorParty, observersMap3);

            createHoldingFactory(operatorParty, holdingId, observersMap2);

            createHoldingFactoryReference(operatorParty, holdingId, observersMap2);

            createRouteSettlement(operatorParty, userParty, observers3);

            createSettlementFactory(operatorParty, observers3);

            createLifecycleClaimRule(operatorParty, userParty, false);

        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error creating Account Factory: " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error creating Account Factory : " + e.getMessage() + "\n";
        }
        return "Created Account Factory!\n";
    }

    public String createAccountFactory(String operatorParty, Map<String, Set<String>> observersMap) {
        try {
            AccountFactory accFactory = accountFactoryRepository.findById(operatorParty);
            if (accFactory == null) {
                List<Command> accFactoryCommands = daml.daml.finance.account.account.Factory
                    .create(operatorParty, observersMap)
                    .commands();
                Transaction transaction = transactionService.submitTransaction(accFactoryCommands, Arrays.asList(operatorParty), null);
                transactionService.handleTransaction(transaction);
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error creating Account Factory : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error creating Account Factory : " + e.getMessage() + "\n";
        }
        return "Created Account Factory!\n";
    }
    

    public String createHoldingFactory(String operatorParty, Id holdingId,
            Map<String, Set<String>> observersMap) {
        try {
            HoldingFactory holdingFactory = holdingFactoryRepository.findById(operatorParty);
            if(holdingFactory==null){
                List<Command> holdingFacCommands = daml.daml.finance.holding.factory.Factory
                        .create(operatorParty, holdingId, observersMap)
                        .commands();
                Transaction transaction = transactionService.submitTransaction(holdingFacCommands, Arrays.asList(operatorParty), null);
                transactionService.handleTransaction(transaction);
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error creating Holding Factory : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error creating Holding Factory : " + e.getMessage() + "\n";
        }
        return "Created Holding Factory!\n";
    }

    public String createSettlementFactory(String operatorParty,
            Set<String> observers) {
        try {
            SettlementFactory settlementFactory = settlementFactoryRepository.findById(operatorParty);
            if(settlementFactory == null){
                List<Command> settlementFactoryCommands = daml.daml.finance.settlement.factory.Factory
                        .create(operatorParty, observers)
                        .commands();
                Transaction transaction = transactionService.submitTransaction(settlementFactoryCommands,
                        Arrays.asList(operatorParty), null);
                transactionService.handleTransaction(transaction);
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error creating Settlement Factory : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error creating Settlement Factory : " + e.getMessage() + "\n";
        }
        return "Created Settlement Factory!\n";
    }

    public String createHoldingFactoryReference(String operatorParty, Id holdingId, Map<String, Set<String>> observersMap) {
        try {
            View factoryView = new daml.daml.finance.interface$.holding.factory.View(
                    operatorParty, holdingId);

            String holdFactoryCid = holdingFactoryRepository.findById(operatorParty).getContractId();
            var holdFactoryContractid = new daml.daml.finance.interface$.holding.factory.Factory.ContractId(
                    holdFactoryCid);

            List<Command> createHoldingFactoryRefCommand = daml.daml.finance.interface$.holding.factory.Reference
                    .create(factoryView, holdFactoryContractid, observersMap)
                    .commands();
            Transaction transaction = transactionService.submitTransaction(createHoldingFactoryRefCommand,
                    Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error creating Holding Factory Reference : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error creating Holding Factory Reference : " + e.getMessage() + "\n";
        }
        return "Created Holding Factory Reference!\n";
    }

    public String createRouteSettlement(String operatorParty, String userParty, Set<String> observers) {
        try {
            List<List<String>> pathsToRootCustodian = Arrays.asList(Arrays.asList(userParty), null);

            var cashRoute = new daml.daml.finance.settlement.hierarchy.Hierarchy(operatorParty, pathsToRootCustodian);

            Map<String, Hierarchy> paths = new HashMap<String, Hierarchy>();
            paths.put("EUR", cashRoute);
            paths.put("UNLK", cashRoute);
            List<Command> createSettlementCommand = daml.daml.finance.settlement.routeprovider.intermediatedstatic.IntermediatedStatic
                    .create(operatorParty, observers, paths)
                    .commands();
            Transaction transaction = transactionService.submitTransaction(createSettlementCommand,
                    Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error creating Route Settlement: " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error creating Route Settlement : " + e.getMessage() + "\n";
        }
        return "Created Route Settlement!\n";
    }

    public String createLifecycleClaimRule(String operatorParty, String userParty, Boolean bool) {
        try {
            Map<String, Unit> singletonMapUser = Collections.singletonMap(userParty, Unit.getInstance());
            Set<String> claimers = new Set<>(singletonMapUser);

            Map<String, Unit> singletonMapOperator = Collections.singletonMap(operatorParty, Unit.getInstance());
            Set<String> settlers = new Set<>(singletonMapOperator);

            String routeProviderCid = routeProviderRepository.findById(operatorParty).getContractId();
            var routeProviderContractid = new daml.daml.finance.interface$.settlement.routeprovider.RouteProvider.ContractId(
                    routeProviderCid);

            String settlementFactoryCid = settlementFactoryRepository.findById(operatorParty).getContractId();
            var settlementFactoryContractid = new daml.daml.finance.interface$.settlement.factory.Factory.ContractId(
                    settlementFactoryCid);
            List<Command> createLifecycleClaimRuleCommand = daml.daml.finance.lifecycle.rule.claim.Rule
                    .create(operatorParty, claimers, settlers, routeProviderContractid, settlementFactoryContractid,
                            bool)
                    .commands();
            Transaction transaction = transactionService.submitTransaction(createLifecycleClaimRuleCommand,
                    Arrays.asList(operatorParty), null);
            transactionService.handleTransaction(transaction);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error creating Lifecycle Claim Rule : " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error creating Lifecycle Claim Rule : " + e.getMessage() + "\n";
        }
        return "Created Lifecycle Claim Rule!\n";
    }
}
