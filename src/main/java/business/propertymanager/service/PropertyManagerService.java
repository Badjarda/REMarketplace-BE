package business.propertymanager.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daml.ledger.api.v1.TransactionOuterClass.Transaction;
import com.daml.ledger.javaapi.data.Unit;

import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.operator.entity.repository.OperatorRepository;
import business.user.entity.repository.UserRepository;
import daml.da.set.types.Set;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PropertyManagerService {
  @Inject
  DamlLedgerClientProvider clientProvider;

  @Inject
  UserRepository userRepository;

  @Inject
  Transactions transactionService;

  @Inject
  OperatorRepository operatorRepository;

  public static final String APP_ID = "OperatorId";

  public PropertyManagerService() {

  }

  public String createPropertyFactories(String operator) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);
      createApartmentPropertyFactory(operatorParty, observersMap);
      createGaragePropertyFactory(operatorParty, observersMap);
      createLandPropertyFactory(operatorParty, observersMap);
      createResidencePropertyFactory(operatorParty, observersMap);
      createWarehousePropertyFactory(operatorParty, observersMap);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error creating Property Factories: " + e.getMessage() + "\n";
    } catch (Exception e) {
      return "Error creating Property Factories : " + e.getMessage() + "\n";
    }
    return "Created Property Factories!\n";
  }

  public String createApartmentPropertyFactory(String operatorParty, Map<String, Set<String>> observersMap) {
    try {
      List<com.daml.ledger.javaapi.data.Command> createCommands = daml.marketplace.app.propertymanager.property.apartmentproperty.Factory
          .create(operatorParty, observersMap)
          .commands();
      Transaction transaction = transactionService.submitTransaction(createCommands, Arrays.asList(operatorParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error creating Apartment Property Factory: " + e.getMessage() + "\n";
    } catch (Exception e) {
      return "Error creating Apartment Property Factory : " + e.getMessage() + "\n";
    }
    return "Created Apartment Property Factory!\n";
  }

  public String createGaragePropertyFactory(String operatorParty, Map<String, Set<String>> observersMap) {
    try {
      List<com.daml.ledger.javaapi.data.Command> createCommands = daml.marketplace.app.propertymanager.property.garageproperty.Factory
          .create(operatorParty, observersMap)
          .commands();
      Transaction transaction = transactionService.submitTransaction(createCommands, Arrays.asList(operatorParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error creating Garage Property Factory: " + e.getMessage() + "\n";
    } catch (Exception e) {
      return "Error creating Garage Property Factory : " + e.getMessage() + "\n";
    }
    return "Created Garage Property Factory!\n";
  }

  public String createLandPropertyFactory(String operatorParty, Map<String, Set<String>> observersMap) {
    try {
      List<com.daml.ledger.javaapi.data.Command> createCommands = daml.marketplace.app.propertymanager.property.landproperty.Factory
          .create(operatorParty, observersMap)
          .commands();
      Transaction transaction = transactionService.submitTransaction(createCommands, Arrays.asList(operatorParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error creating Land Property Factory: " + e.getMessage() + "\n";
    } catch (Exception e) {
      return "Error creating Land Property Factory : " + e.getMessage() + "\n";
    }
    return "Created Land Property Factory!\n";
  }

  public String createResidencePropertyFactory(String operatorParty, Map<String, Set<String>> observersMap) {
    try {
      List<com.daml.ledger.javaapi.data.Command> createCommands = daml.marketplace.app.propertymanager.property.residenceproperty.Factory
          .create(operatorParty, observersMap)
          .commands();
      Transaction transaction = transactionService.submitTransaction(createCommands, Arrays.asList(operatorParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error creating Residence Property Factory: " + e.getMessage() + "\n";
    } catch (Exception e) {
      return "Error creating Residence Property Factory : " + e.getMessage() + "\n";
    }
    return "Created Residence Property Factory!\n";
  }

  public String createWarehousePropertyFactory(String operatorParty, Map<String, Set<String>> observersMap) {
    try {
      List<com.daml.ledger.javaapi.data.Command> createCommands = daml.marketplace.app.propertymanager.property.warehouseproperty.Factory
          .create(operatorParty, observersMap)
          .commands();
      Transaction transaction = transactionService.submitTransaction(createCommands, Arrays.asList(operatorParty), null);
      transactionService.handleTransaction(transaction);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error creating Warehouse Property Factory: " + e.getMessage() + "\n";
    } catch (Exception e) {
      return "Error creating Warehouse Property Factory : " + e.getMessage() + "\n";
    }
    return "Created Warehouse Property Factory!\n";
  }

}
