package business.rolemanager.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.daml.ledger.javaapi.data.Unit;
import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.operator.entity.repository.OperatorRepository;
import business.user.entity.repository.UserRepository;
import business.userrole.entity.repository.UserRoleOfferRepository;
import business.userrole.entity.repository.UserRoleRepository;
import daml.da.set.types.Set;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import business.rolemanager.entity.repository.UserRoleManagerRepository;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.marketplace.app.rolemanager.userrole.userrole.Factory;
import daml.marketplace.interface$.common.types.UserRoleKey;
import daml.marketplace.interface$.rolemanager.userrole.permission.Permission;

@ApplicationScoped
public class RoleManagerService {

    @Inject
    DamlLedgerClientProvider clientProvider;

    @Inject
    UserRepository userRepository;

    @Inject
    Transactions transactionService;

    @Inject
    OperatorRepository operatorRepository;

    @Inject
    UserRoleOfferRepository userRoleOfferRepository;

    @Inject
    UserRoleManagerRepository userRoleManagerRepository;

    @Inject
    UserRoleRepository userRoleRepository;

    public static final String APP_ID = "OperatorId";

    public RoleManagerService() {

    }

    public String createUserFactory(String operator) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();

            Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
            Set<String> observers = new Set<>(singletonMap);
            Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
            observersMap.put("Default", observers);

            List<com.daml.ledger.javaapi.data.Command> createCommands = Factory.create(operatorParty, observersMap)
                    .commands();

            transactionService.submitTransaction(createCommands, Arrays.asList(operatorParty), null);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error creating User Role Factory: " + e.getMessage() + "\n";
        } catch (Exception e) {
            return "Error creating User Role Factory : " + e.getMessage() + "\n";
        }
        return "Created User Role Factory!\n";
    }

    public void requestUserRoleServices(String operator, String user, String roleId,
            String description, List<Permission> permissions, String requestType)
            throws IllegalStateException, IllegalArgumentException, Exception {
        String operatorParty = userRepository.findById(operator).getPartyId();
        String userParty = userRepository.findById(user).getPartyId();
        List<com.daml.ledger.javaapi.data.Command> command = null;
        String servicId = userRoleManagerRepository.findById(operatorParty + userParty)
                .getContractId();

        Id userRoleKeyId = new Id(roleId);
        UserRoleKey key = new UserRoleKey(operatorParty, userRoleKeyId);
        daml.marketplace.interface$.rolemanager.service.Service.ContractId serviceId = new daml.marketplace.interface$.rolemanager.service.Service.ContractId(
                servicId);

        switch (requestType) {
            case "create":
                Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
                Set<String> observers = new Set<>(singletonMap);
                Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
                observersMap.put("Default", observers);

                command = serviceId
                        .exerciseCreateUserRole(userRoleKeyId, description, permissions, observersMap)
                        .commands();
                break;
            case "delete":
                command = serviceId.exerciseDeleteUserRole(key).commands();
                break;
            case "addPermission":
                command = serviceId.exerciseAddPermissionToUserRole(key, permissions.get(0)).commands();
                break;
            case "removePermission":
                command = serviceId.exerciseRemovePermissionInUserRole(key, permissions.get(0)).commands();
                break;
            case "update":
                command = serviceId.exerciseUpdateUserRole(key, permissions).commands();
                break;
            default:
                break;
        }
        transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);
    }

    public String createUserRole(String operator, String user, String id,
            String description, List<Permission> permissions) {
        try {
            System.out.println(id);
            System.out.println(description);
            System.out.println(permissions.toString());

            requestUserRoleServices(operator, user, id, description, permissions, "create");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error request Create User role: " + e.getMessage();
        } catch (Exception e) {
            return "Error request Create User role : " + e.getMessage();
        }
        return "Success Create User Role\n";
    }

    public String deleteUserRole(String operator, String user) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            var roleId = userRoleRepository.findById(operatorParty + userParty).getRoleId();
            requestUserRoleServices(operator, user, roleId, null, null, "delete");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error request Delete User role: " + e.getMessage();
        } catch (Exception e) {
            return "Error request Delete User role : " + e.getMessage();
        }
        return "Success Delete User Role\n";
    }

    public String addPermissionUserRole(String operator, String user, Permission permission) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            List<Permission> permissions = new ArrayList<>(Arrays.asList(permission));
            var roleId = userRoleRepository.findById(operatorParty + userParty).getRoleId();
            requestUserRoleServices(operator, user, roleId, null, permissions, "addPermission");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error request Add permission to User role: " + e.getMessage();
        } catch (Exception e) {
            return "Error request Add permission to User role : " + e.getMessage();
        }
        return "Success Add Permission To User Role\n";
    }

    public String removePermissionUserRole(String operator, String user, Permission permission) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            List<Permission> permissions = new ArrayList<>(Arrays.asList(permission));
            var roleId = userRoleRepository.findById(operatorParty + userParty).getRoleId();
            requestUserRoleServices(operator, user, roleId, null, permissions, "removePermission");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error request Remove permission to User role: " + e.getMessage();
        } catch (Exception e) {
            return "Error request Remove permission to User role : " + e.getMessage();
        }

        return "Success Remove Permission To User Role\n";
    }

    public String updateUserRole(String operator, String user, List<Permission> permissions) {
        try {
            String operatorParty = userRepository.findById(operator).getPartyId();
            String userParty = userRepository.findById(user).getPartyId();
            var roleId = userRoleRepository.findById(operatorParty + userParty).getRoleId();
            requestUserRoleServices(operator, user, roleId, null, permissions, "update");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return "Error request Update User role: " + e.getMessage();
        } catch (Exception e) {
            return "Error request Update User role : " + e.getMessage();
        }

        return "Success Update User Role\n";
    }

}
