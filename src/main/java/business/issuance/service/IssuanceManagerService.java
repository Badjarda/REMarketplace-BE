package business.issuance.service;


import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.user.entity.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class IssuanceManagerService {

    @Inject
    DamlLedgerClientProvider clientProvider;

    @Inject
    UserRepository userRepository;

    @Inject
    Transactions transactionService;


    public static final String APP_ID = "OperatorId";

    public IssuanceManagerService() {

    }

}
