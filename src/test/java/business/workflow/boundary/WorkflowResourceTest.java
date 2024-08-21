package business.workflow.boundary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import apiconfiguration.Transactions;
import business.custody.service.AccountManagerService;
import business.issuer.service.IssuanceService;
import business.operator.service.OperatorService;
import business.party.service.PartyService;
import business.profilemanager.service.ProfileManagerService;
import business.propertymanager.service.PropertyManagerService;
import business.rolemanager.service.RoleManagerService;
import business.user.service.UserService;
import business.useraccount.dto.SwapRequestGETDTO;
import business.useraccount.service.UserAccountService;
import business.userprofile.service.UserProfileService;
import business.userrole.service.UserRoleService;
import business.userproperty.service.UserPropertyService;
import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;
import daml.marketplace.interface$.propertymanager.property.common.GarageType;
import daml.marketplace.interface$.propertymanager.property.common.ResidenceType;
import daml.marketplace.interface$.propertymanager.property.common.LandType;
import daml.marketplace.interface$.propertymanager.property.common.WarehouseType;
import daml.marketplace.interface$.propertymanager.property.common.ViableConstructionTypes;
import daml.marketplace.interface$.propertymanager.property.common.Parking;
import daml.marketplace.interface$.propertymanager.property.common.Orientation;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class WorkflowResourceTest {
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

    @Test
    public void testWorkflow() {
        String uuid1 = UUID.randomUUID().toString(); // Operator
        String uuid2 = UUID.randomUUID().toString(); // Seller
        String uuid3 = UUID.randomUUID().toString(); // Buyer
        String uuid4 = UUID.randomUUID().toString(); // Public

        System.out.println();

// SETUP OPERATOR + PUBLIC PARTY

        // Creating the parties
        System.out.println(partyService.createParty(uuid1)); // OPERATOR
        System.out.println(partyService.createParty(uuid4)); // PUBLIC

        // Creating the Users
        System.out.println(userService.createOperator(uuid1, uuid1)); // OPERATOR
        System.out.println(userService.createPublic(uuid4, uuid4)); // PUBLIC

        // Create Operator Role
        System.out.println(operatorService.createOperatorRole(uuid1));

        // Create Initial Role
        System.out.println(operatorService.createInitialRole(uuid1, uuid4));

// SETUP USER

        System.out.println(partyService.createParty(uuid2));
        System.out.println(partyService.createParty(uuid3));

        List<String> photoReferences = Arrays.asList("url1", "url2", "url3");
        System.out.println(userService.createUser(uuid2, uuid2, "Profile" + uuid2, "DuarteCosta", "Duarte",
                        "Costa", "Duarte Ferreira da Costa", "passwordTest", LocalDate.of(1874, 12, 15),
                        Optional.of(Gender.MALE), Nationality.PORTUGUESE, "ola@gmail.com",
                        Optional.of((long) 912345678L), (long) 212345678L, (long) 12345678901L, (long) 987654321L,
                        photoReferences));
        System.out.println(userService.createUser(uuid3, uuid3, "Profile" + uuid3, "PauloSeixo", "Paulo", "Seixo", "Paulo Bem Seixc", "passwordTest1234",
                        LocalDate.of(2000, 1, 1), Optional.of(Gender.MALE), Nationality.NIGERIEN, "adeus@gmail.com",
                        Optional.of((long) 987654321L), (long) 212345678L, (long) 12345678901L, (long) 987654321L,
                        photoReferences));

        // Modify Profile
        //System.out.println(userProfileService.modifyUserProfileFields(uuid1, uuid2, "JoséCosta", "José", "Costa", "José António Costa", "passwordTeste", LocalDate.of(2000, 1, 1), Optional.of(Gender.MALE), Nationality.PORTUGUESE, "jacosta.arq@gmail.com", Optional.of((long) 987654321L), (long) 212345678L, (long) 12345678901L, (long) 987654321L, photoReferences));
              
        // Create Deposit Currency Requests + Accept
        System.out.println(userAccountService.requestDepositCurrencyInstrument(uuid1, uuid3, "EUR", new BigDecimal("200000.0")));

        System.out.println(userAccountService.requestDepositCurrencyInstrument(uuid1, uuid3, "EUR", new BigDecimal("450000.0")));

        // Create Withdraw Currency Requests
        //System.out.println(userAccountService.requestWithdrawFungible(uuid1, uuid2));

        // Request Create Apartment Property
        String postalCode1 = "2675-614";
        System.out.println(userPropertyService.requestCreateApartmentProperty(uuid1, uuid2, "PropertyId" + postalCode1, new BigDecimal(250000.0), 
            "Rua Abel Manta n4 7Frente", postalCode1, "Lisbon", "Odivelas", new BigDecimal(100.0), 
            new BigDecimal(95.0), (long) 2L, (long) 1L, (long) 7L, (long) 1L, true, LocalDate.of(1900, 1, 1), 
            "Frigorífico", "Terraço comunitário no piso 0", "Long description", photoReferences));
        
        // Accept Request Create Apartment Property
        System.out.println(operatorService.acceptRequestCreateApartmentProperty(uuid1, uuid2, postalCode1));

        // Request Create Land Property
        String postalCode2 = "2675-615";
        List<ViableConstructionTypes> viableConstructionTypes = Arrays.asList(ViableConstructionTypes.BUILDING, ViableConstructionTypes.RESIDENCE); 
        System.out.println(userPropertyService.requestCreateLandProperty(uuid1, uuid2, "PropertyId" + postalCode2, new BigDecimal(250000.0), 
            "Rua Abel Manta n4 7Frente", postalCode2, "Lisbon", "Odivelas", LandType.RUSTIC, new BigDecimal(100.0), new BigDecimal(100.0),
            new BigDecimal(100.0), (long) 2L, true, "Frigorífico", viableConstructionTypes, "Terraço comunitário no piso 0", "Long description", photoReferences));
        
        // Accept Request Create Land Property
        System.out.println(operatorService.acceptRequestCreateLandProperty(uuid1, uuid2, postalCode2));

        // Request Create Garage Property
        String postalCode3 = "2675-616";
        System.out.println(userPropertyService.requestCreateGarageProperty(uuid1, uuid2, "PropertyId" + postalCode3, new BigDecimal(250000.0), 
        "Rua Abel Manta n4 7Frente", postalCode3, "Lisbon", "Odivelas", new BigDecimal(100.0), GarageType.CONDOMINIUMPRIVATE,
        (long) 2L, "Frigorífico", "Terraço comunitário no piso 0", "Long description", photoReferences));
        
        // Accept Request Create Garage Property
        System.out.println(operatorService.acceptRequestCreateGarageProperty(uuid1, uuid2, postalCode3));

        // Request Create Residence Property
        String postalCode4 = "2675-617";
        System.out.println(userPropertyService.requestCreateResidenceProperty(uuid1, uuid2, "PropertyId" + postalCode4, new BigDecimal(250000.0), 
            "Rua Abel Manta n4 7Frente", postalCode4, "Lisbon", "Odivelas", new BigDecimal(100.0), new BigDecimal(100.0),
            (long) 2L, (long) 2L, (long) 2L, ResidenceType.DETACHED, "In the back", Parking.COVERED, LocalDate.of(1900, 1, 1),
            Orientation.EAST, "Frigorífico", "Terraço comunitário no piso 0", "Long description", photoReferences));
        
        // Accept Request Create Residence Property
        System.out.println(operatorService.acceptRequestCreateResidenceProperty(uuid1, uuid2, postalCode4));

        // Request Create Warehouse Property
        String postalCode5 = "2675-618";
        System.out.println(userPropertyService.requestCreateWarehouseProperty(uuid1, uuid2, "PropertyId" + postalCode5, new BigDecimal(250000.0), 
            "Rua Abel Manta n4 7Frente", postalCode5, "Lisbon", "Odivelas", WarehouseType.BUILDINGWAREHOUSE, new BigDecimal(100.0), new BigDecimal(100.0),
            (long) 2L, LocalDate.of(1900, 1, 1), "Frigorífico", "Terraço comunitário no piso 0", "Long description", photoReferences));
        
        // Accept Request Create Warehouse Property
        System.out.println(operatorService.acceptRequestCreateWarehouseProperty(uuid1, uuid2, postalCode5));

        // Modify Apartment Property Fields
        /** 
        System.out.println(userPropertyService.modifyUserApartmentPropertyFields(uuid1, uuid2, new BigDecimal(250001.0), 
        "Rua Abel Manta n4 8Frente", postalCode1, "Lisbon", "Odivelas", new BigDecimal(100.0), 
        new BigDecimal(95.0), (long) 2L, (long) 1L, (long) 7L, (long) 1L, true, LocalDate.of(1900, 1, 1), 
        "Frigorífico", "Terraço comunitário no piso 0", "Long description", photoReferences));
        
        // Modify Land Property Fields
        System.out.println(userPropertyService.modifyUserLandPropertyFields(uuid1, uuid2, new BigDecimal(250001.0), 
        "Rua Abel Manta n4 8Frente", postalCode2, "Lisbon", "Odivelas", LandType.RUSTIC, new BigDecimal(121.0), new BigDecimal(100.0),
        new BigDecimal(100.0), (long) 2L, true, "Frigorífico", viableConstructionTypes, "Terraço comunitário no piso 0", "Long description", photoReferences));

        // Modify Garage Property Fields
        System.out.println(userPropertyService.modifyUserGaragePropertyFields(uuid1, uuid2, new BigDecimal(250001.0), 
        "Rua Abel Manta n4 8Frente", postalCode3, "Lisbon", "Odivelas", new BigDecimal(121.0), GarageType.CONDOMINIUMPRIVATE,
        (long) 2L, "Frigorífico", "Terraço comunitário no piso 0", "Long description", photoReferences));

        // Modify Residence Property Fields
        System.out.println(userPropertyService.modifyUserResidencePropertyFields(uuid1, uuid2, new BigDecimal(250001.0), 
        "Rua Abel Manta n4 8Frente", postalCode4, "Lisbon", "Odivelas", new BigDecimal(121.0), new BigDecimal(100.0),
        (long) 2L, (long) 2L, (long) 2L, ResidenceType.DETACHED, "In the back", Parking.COVERED, LocalDate.of(1900, 1, 1),
        Orientation.EAST, "Frigorífico", "Terraço comunitário no piso 0", "Long description", photoReferences));

        // Modify Warehouse Property Fields
        System.out.println(userPropertyService.modifyUserWarehousePropertyFields(uuid1, uuid2, new BigDecimal(250001.0), 
        "Rua Abel Manta n4 8Frente", postalCode5, "Lisbon", "Odivelas", WarehouseType.BUILDINGWAREHOUSE, new BigDecimal(121.0), new BigDecimal(100.0),
        (long) 2L, LocalDate.of(1900, 1, 1), "Frigorífico", "Terraço comunitário no piso 0", "Long description", photoReferences));
        */

        // Create DeIssue Transferable Request
        System.out.println(issuanceService.requestDeIssueTransferable(uuid1, uuid2, "IssuanceId"+uuid2, postalCode2));

        // Atomic Swap Request
        System.out.println(issuanceService.requestSwap(uuid1, uuid3, uuid2, postalCode1));

        // Accept Atomic Swap Request
        System.out.println(userAccountService.acceptSwapRequest(uuid1, uuid3, uuid2, uuid4, postalCode1, "APARTMENT"));

        // Atomic Swap Request
        System.out.println(issuanceService.requestSwap(uuid1, uuid3, uuid2, postalCode3));

        // Atomic Swap Request
        System.out.println(issuanceService.requestSwap(uuid1, uuid3, uuid2, postalCode4));

        // Atomic Swap Request
        System.out.println(issuanceService.requestSwap(uuid1, uuid3, uuid2, postalCode5));
        
        // Test GETS of individual property
        System.out.println("GET INDIVIDUAL PROPERTY : ");
        System.out.println(userPropertyService.getApartmentPropertyById(uuid1, postalCode1));
        //System.out.println(userPropertyService.getLandPropertyById(uuid1, postalCode2));
        System.out.println(userPropertyService.getGaragePropertyById(uuid1, postalCode3));
        System.out.println(userPropertyService.getResidencePropertyById(uuid1, postalCode4));
        System.out.println(userPropertyService.getWarehousePropertyById(uuid1, postalCode5));

        // Test GETS of all properties of a user
        Map<String, List<?>> allUserProperties = userPropertyService.getAllUserProperties(uuid1, uuid2);
        System.out.println("\nGET ALL USER PROPERTIES : ");
        System.out.println("APARTMENTS : " + allUserProperties.get("APARTMENT"));
        System.out.println("GARAGES : " + allUserProperties.get("GARAGE"));
        System.out.println("LANDS : " + allUserProperties.get("LAND"));
        System.out.println("RESIDENCES : " + allUserProperties.get("RESIDENCE"));
        System.out.println("WAREHOUSES : " + allUserProperties.get("WAREHOUSE"));

        // Test GET ALL PROPERTIES
        System.out.println("\nGET ALL PROPERTIES : ");
        Map<String, List<?>> allProperties = userPropertyService.getAllProperties();
        System.out.println("APARTMENTS : " + allProperties.get("APARTMENT"));
        System.out.println("GARAGES : " + allProperties.get("GARAGE"));
        System.out.println("LANDS : " + allProperties.get("LAND"));
        System.out.println("RESIDENCES : " + allProperties.get("RESIDENCE"));
        System.out.println("WAREHOUSES : " + allProperties.get("WAREHOUSE"));

        // Test GET ALL USER SWAP REQUESTS
        System.out.println("\nGET ALL USER SWAP REQUESTS : ");
        for (SwapRequestGETDTO request: userAccountService.getAllUserSwapRequests(uuid1, uuid2)) {
            System.out.println("\nSWAP REQUEST FOR: " + request.getSellerId());
            System.out.println("Buyer: " + request.getBuyerId());
            switch (request.getPropertyType()) {
                case "APARTMENT":
                    System.out.println(request.getApartmentDTO().getPropertyPostalCode());
                    break;
                case "GARAGE":
                    System.out.println(request.getGarageDTO().getPropertyPostalCode());
                    break;
                case "LAND":
                    System.out.println(request.getLandDTO().getPropertyPostalCode());
                    break;
                case "RESIDENCE":
                    System.out.println(request.getResidenceDTO().getPropertyPostalCode());
                    break;
                case "WAREHOUSE":
                    System.out.println(request.getWarehouseDTO().getPropertyPostalCode());
                    break;
                default:
                    break;
            }
        }

        // Test GET USER PROFILE
        System.out.println("\nGET USER PROFILE : ");
        System.out.println(userProfileService.getUserProfile(uuid2).getFullName());

        // Test GET USER BALANCE
        System.out.println("\nGET USER BALANCE : ");
        System.out.println(userAccountService.getUserHoldingFungible(uuid1, uuid3).getAmount());

        String postalCode6 = "2675-620";
        System.out.println(userPropertyService.requestCreateApartmentProperty(uuid1, uuid2, "PropertyId" + postalCode6, 
            new BigDecimal("320000.00"), 
            "Avenida da Liberdade, n10 3Esq", postalCode6, "Lisbon", "Lisbon", new BigDecimal("120.0"), 
            new BigDecimal("110.0"), 3L, 2L, 3L, 1L, true, LocalDate.of(2005, 6, 15), 
            "Washing machine, Air conditioning", "Recently renovated with high-end finishes.", 
            "A modern 3-bedroom apartment located in the heart of Lisbon, close to shops and public transport.", photoReferences));

        String postalCode7 = "2675-621";
        System.out.println(userPropertyService.requestCreateApartmentProperty(uuid1, uuid2, "PropertyId" + postalCode7, 
            new BigDecimal("280000.00"), 
            "Rua da Prata, n5 2Dir", postalCode7, "Lisbon", "Lisbon", new BigDecimal("90.0"), 
            new BigDecimal("85.0"), 2L, 1L, 2L, 0L, false, LocalDate.of(2010, 9, 10), 
            "Dishwasher, Built-in wardrobes", "Sunny apartment with a large living room and open kitchen.", 
            "A cozy 2-bedroom apartment perfect for young professionals or a small family.", photoReferences));

        String postalCode8 = "2675-622";
        System.out.println(userPropertyService.requestCreateLandProperty(uuid1, uuid2, "PropertyId" + postalCode8, 
            new BigDecimal("150000.00"), 
            "Estrada Nacional 1, Km 58", postalCode8, "Leiria", "Leiria", LandType.URBAN, new BigDecimal("1000.0"), new BigDecimal("500.0"),
            new BigDecimal("800.0"), 3L, true, "Paved road access, Electricity", viableConstructionTypes, 
            "Ideal for building a small residential complex or a large private villa.", 
            "Urban land in a rapidly developing area, close to schools and shopping centers.", photoReferences));

        String postalCode9 = "2675-623";
        System.out.println(userPropertyService.requestCreateGarageProperty(uuid1, uuid2, "PropertyId" + postalCode9, 
            new BigDecimal("30000.00"), 
            "Rua da Alegria, n12", postalCode9, "Porto", "Porto", new BigDecimal("20.0"), GarageType.CONDOMINIUMPRIVATE,
            1L, "Automatic door, Lighting", "Secure and well-maintained garage space.", 
            "Single garage in the city center, perfect for protecting your vehicle from the elements.", photoReferences));

        String postalCode10 = "2675-624";
        System.out.println(userPropertyService.requestCreateResidenceProperty(uuid1, uuid2, "PropertyId" + postalCode10, 
            new BigDecimal("500000.00"), 
            "Rua das Flores, n22", postalCode10, "Faro", "Faro", new BigDecimal("250.0"), new BigDecimal("220.0"),
            5L, 4L, 3L, ResidenceType.CORNERLOT, "Private garden with pool", Parking.COVERED, LocalDate.of(2015, 3, 22),
            Orientation.SOUTH, "Solar panels, Central heating", "Luxury residence with modern amenities and beautiful sea views.", 
            "A stunning semi-detached house with a pool, ideal for a large family.", photoReferences));

        String postalCode11 = "2675-625";
        System.out.println(userPropertyService.requestCreateWarehouseProperty(uuid1, uuid2, "PropertyId" + postalCode11, 
            new BigDecimal("750000.00"), 
            "Zona Industrial de Alverca", postalCode11, "Lisbon", "Alverca", WarehouseType.STORAGEROOM, new BigDecimal("1200.0"), new BigDecimal("1100.0"),
            1L, LocalDate.of(2018, 11, 30), "High ceilings, Large loading bays", "Perfect for logistics operations with easy access to main highways.", 
            "A modern logistic warehouse with excellent facilities and infrastructure.", photoReferences));

        
        // Test GET USER CREATE PROPERTY REQUESTS
        System.out.println("\nGET USER CREATE PROPERTY REQUESTS : ");
        
        Map<String, List<?>> requests = operatorService.getAllPropertyRequests();
        System.out.println("APARTMENT : " + requests.get("APARTMENT"));
        System.out.println("GARAGE : " + requests.get("GARAGE"));
        System.out.println("LAND : " + requests.get("LAND"));
        System.out.println("RESIDENCE : " + requests.get("RESIDENCE"));
        System.out.println("WAREHOUSE : " + requests.get("WAREHOUSE"));
       
    }
}
