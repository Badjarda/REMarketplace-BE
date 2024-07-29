package business.profilemanager.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daml.ledger.api.v1.TransactionOuterClass.Transaction;
import com.daml.ledger.javaapi.data.Unit;
import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import daml.da.set.types.Set;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import business.operator.entity.repository.OperatorRepository;
import business.user.entity.repository.UserRepository;
import business.profilemanager.entity.repository.UserProfileManagerRepository;
import daml.marketplace.app.profilemanager.userprofile.Factory;


@ApplicationScoped
public class ProfileManagerService {

        @Inject
        DamlLedgerClientProvider clientProvider;

        @Inject
        UserRepository userRepository;

        @Inject
        Transactions transactionService;

        @Inject
        OperatorRepository operatorRepository;

        @Inject
        UserProfileManagerRepository userProfileManagerRepository;

        public static final String APP_ID = "OperatorId";

        public ProfileManagerService() {

        }

        public String createUserProfileFactory(String operator) {
                try {
                        String operatorParty = userRepository.findById(operator).getPartyId();
                        Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
                        Set<String> observers = new Set<>(singletonMap);
                        Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
                        observersMap.put("Default", observers);

                        List<com.daml.ledger.javaapi.data.Command> createCommands = Factory
                                        .create(operatorParty, observersMap)
                                        .commands();

                        Transaction transaction = transactionService.submitTransaction(createCommands, Arrays.asList(operatorParty), null);
                        transactionService.handleTransaction(transaction);
                } catch (IllegalArgumentException | IllegalStateException e) {
                        return "Error creating User Profile Factory: " + e.getMessage() + "\n";
                } catch (Exception e) {
                        return "Error creating User Profile Factory : " + e.getMessage() + "\n";
                }
                return "Created User Profile Factory!\n";
        }

}
