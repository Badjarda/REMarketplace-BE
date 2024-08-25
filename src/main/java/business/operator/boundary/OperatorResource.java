package business.operator.boundary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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
import business.userproperty.service.UserPropertyService;
import business.userrole.service.UserRoleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;
import daml.marketplace.interface$.propertymanager.property.common.GarageType;
import daml.marketplace.interface$.propertymanager.property.common.ResidenceType;
import daml.marketplace.interface$.propertymanager.property.common.LandType;
import daml.marketplace.interface$.propertymanager.property.common.WarehouseType;
import daml.marketplace.interface$.propertymanager.property.common.ViableConstructionTypes;
import daml.marketplace.interface$.propertymanager.property.common.Parking;
import daml.marketplace.interface$.propertymanager.property.common.Orientation;

@Path("/operator") // Base path for all endpoints in this resource
public class OperatorResource {
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

    @Inject
    OperatorService service; // Injecting the service layer

    private void test(){
        if(service.getAllPropertyRequests().get("APARTMENT").size() == 0){
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
            System.out.println(userService.createUser(uuid2, uuid2, "Profile" + uuid2, "MariaSilva", "Maria",
                "Silva", "Maria José da Silva", "SecurePassword!2023", LocalDate.of(1988, 5, 12),
                Optional.of(Gender.FEMALE), Nationality.BRAZILIAN, "maria.silva@example.com",
                Optional.of((long) 919876543L), (long) 203456789L, (long) 22345678901L, (long) 223456789L,
                Arrays.asList("maria_photo1.jpg", "maria_photo2.jpg")));

            // Creating a user profile for John Smith
            System.out.println(userService.createUser(uuid3, uuid3, "Profile" + uuid3, "JohnSmith", "John", 
                "Smith", "John Arthur Smith", "JohnsPass#123", LocalDate.of(1975, 11, 8), 
                Optional.of(Gender.MALE), Nationality.CANADIAN, "john.smith@example.com",
                Optional.of((long) 987654321L), (long) 315678901L, (long) 13579246801L, (long) 198765432L,
                Arrays.asList("john_photo1.jpg", "john_photo2.jpg")));

            // Modify Profile
            //System.out.println(userProfileService.modifyUserProfileFields(uuid1, uuid2, "JoséCosta", "José", "Costa", "José António Costa", "passwordTeste", LocalDate.of(2000, 1, 1), Optional.of(Gender.MALE), Nationality.PORTUGUESE, "jacosta.arq@gmail.com", Optional.of((long) 987654321L), (long) 212345678L, (long) 12345678901L, (long) 987654321L, photoReferences));
                
            // Create Deposit Currency Requests + Accept
            System.out.println(userAccountService.requestDepositCurrencyInstrument(uuid3, new BigDecimal("200000.0")));

            System.out.println(userAccountService.requestDepositCurrencyInstrument(uuid3, new BigDecimal("450000.0")));

            System.out.println(userAccountService.requestDepositCurrencyInstrument(uuid2, new BigDecimal("1000000.0")));

            // Create Withdraw Currency Requests
            //System.out.println(userAccountService.requestWithdrawFungible(uuid1, uuid2));

            // Request Create Apartment Property
            String postalCode1 = "1000-001";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid2, "PropertyId" + postalCode1, new BigDecimal(320000.0), 
                "Avenida da Liberdade, 55", postalCode1, "Lisbon", "Lisbon", new BigDecimal(120.0), 
                new BigDecimal(110.0), (long) 3L, (long) 2L, (long) 8L, (long) 1L, true, LocalDate.of(2010, 5, 1), 
                "Samsung Refrigerator", "Private balcony with city view", "Modern 3-bedroom apartment in central Lisbon, perfect for families or professionals", photoReferences));

            // Accept Request Create Apartment Property
            System.out.println(operatorService.acceptRequestCreateApartmentProperty(uuid1, uuid2, postalCode1));

            // Request Create Apartment Property
            String postalCode2 = "1000-002";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid3, "PropertyId" + postalCode2, new BigDecimal(320000.0), 
                "Rua Hermano Sousa, 22", postalCode2, "Lisbon", "Lisbon", new BigDecimal(120.0), 
                new BigDecimal(110.0), (long) 3L, (long) 2L, (long) 8L, (long) 1L, true, LocalDate.of(2010, 5, 1), 
                "Samsung Refrigerator", "Private balcony with city view", "Modern 3-bedroom apartment in central Lisbon, perfect for families or professionals", photoReferences));

            // Accept Request Create Apartment Property
            System.out.println(operatorService.acceptRequestCreateApartmentProperty(uuid1, uuid3, postalCode2));

            // Request Create Land Property
            String postalCode3 = "3000-123";
            List<ViableConstructionTypes> viableConstructionTypes = Arrays.asList(ViableConstructionTypes.BUILDING, ViableConstructionTypes.RESIDENCE); 
            System.out.println(userPropertyService.requestCreateLandProperty(uuid2, "PropertyId" + postalCode3, new BigDecimal(180000.0), 
                "Estrada de Coimbra, Km 22", postalCode3, "Coimbra", "Coimbra", LandType.RUSTIC, new BigDecimal(5000.0), new BigDecimal(5000.0),
                new BigDecimal(4500.0), (long) 1L, true, "Open land suitable for farming or construction", viableConstructionTypes, "Located near major roadways", "A large rustic plot ideal for agricultural use or future residential development", photoReferences));

            // Accept Request Create Land Property
            System.out.println(operatorService.acceptRequestCreateLandProperty(uuid1, uuid2, postalCode3));

            // Request Create Land Property
            String postalCode30 = "3000-124";
            System.out.println(userPropertyService.requestCreateLandProperty(uuid2, "PropertyId" + postalCode30, new BigDecimal(180000.0), 
                "Estrada de Coimbra, Km 22", postalCode30, "Coimbra", "Coimbra", LandType.RUSTIC, new BigDecimal(5000.0), new BigDecimal(5000.0),
                new BigDecimal(4500.0), (long) 1L, true, "Open land suitable for farming or construction", viableConstructionTypes, "Located near major roadways", "A large rustic plot ideal for agricultural use or future residential development", photoReferences));

            // Accept Request Create Land Property
            System.out.println(operatorService.acceptRequestCreateLandProperty(uuid1, uuid2, postalCode30));

            // Request Create Garage Property
            String postalCode4 = "1100-234";
            System.out.println(userPropertyService.requestCreateGarageProperty(uuid2, "PropertyId" + postalCode4, new BigDecimal(50000.0), 
                "Rua dos Anjos, 24B", postalCode4, "Lisbon", "Lisbon", new BigDecimal(25.0), GarageType.CONDOMINIUMPRIVATE,
                (long) 1L, "Secure garage with 24/7 access", "Conveniently located near metro station", "Spacious underground garage in a condominium with security", photoReferences));

            // Accept Request Create Garage Property
            System.out.println(operatorService.acceptRequestCreateGarageProperty(uuid1, uuid2, postalCode4));

            // Request Create Residence Property
            String postalCode5 = "2750-515";
            System.out.println(userPropertyService.requestCreateResidenceProperty(uuid2, "PropertyId" + postalCode5, new BigDecimal(850000.0), 
                "Rua das Acácias, 12", postalCode5, "Cascais", "Cascais", new BigDecimal(350.0), new BigDecimal(300.0),
                (long) 4L, (long) 3L, (long) 2L, ResidenceType.DETACHED, "Large private backyard", Parking.COVERED, LocalDate.of(2020, 6, 1),
                Orientation.SOUTH, "Bosch Refrigerator", "Spacious backyard with private pool", "Luxurious detached home in Cascais, with modern amenities and close to the beach", photoReferences));

            // Accept Request Create Residence Property
            System.out.println(operatorService.acceptRequestCreateResidenceProperty(uuid1, uuid2, postalCode5));

            // Request Create Warehouse Property
            String postalCode6 = "4000-345";
            System.out.println(userPropertyService.requestCreateWarehouseProperty(uuid2, "PropertyId" + postalCode6, new BigDecimal(600000.0), 
                "Zona Industrial do Porto, Rua A", postalCode6, "Porto", "Porto", WarehouseType.BUILDINGWAREHOUSE, new BigDecimal(2000.0), new BigDecimal(1800.0),
                (long) 5L, LocalDate.of(2005, 11, 15), "Large cold storage room", "Includes offices and parking space", "Industrial warehouse ideal for logistics or manufacturing, located in a key industrial zone", photoReferences));

            // Accept Request Create Warehouse Property
            System.out.println(operatorService.acceptRequestCreateWarehouseProperty(uuid1, uuid2, postalCode6));

            // Request Create Apartment Property
            String postalCode19 = "5000-000";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid2, "PropertyId" + postalCode19, new BigDecimal(320000.0), 
                "Avenida da Liberdade, 55", postalCode19, "Lisbon", "Lisbon", new BigDecimal(120.0), 
                new BigDecimal(110.0), (long) 3L, (long) 2L, (long) 8L, (long) 1L, true, LocalDate.of(2010, 5, 1), 
                "Samsung Refrigerator", "Private balcony with city view", "Modern 3-bedroom apartment in central Lisbon, perfect for families or professionals", photoReferences));

            // Accept Request Create Apartment Property
            System.out.println(operatorService.acceptRequestCreateApartmentProperty(uuid1, uuid2, postalCode19));

            // Request Create Apartment Property
            String postalCode20 = "5000-001";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid2, "PropertyId" + postalCode20, new BigDecimal(320000.0), 
                "Avenida da Liberdade, 55", postalCode20, "Lisbon", "Lisbon", new BigDecimal(120.0), 
                new BigDecimal(110.0), (long) 3L, (long) 2L, (long) 8L, (long) 1L, true, LocalDate.of(2010, 5, 1), 
                "Samsung Refrigerator", "Private balcony with city view", "Modern 3-bedroom apartment in central Lisbon, perfect for families or professionals", photoReferences));

            // Accept Request Create Apartment Property
            System.out.println(operatorService.acceptRequestCreateApartmentProperty(uuid1, uuid2, postalCode20));

            // Request Create Apartment Property
            String postalCode21 = "5000-002";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid2, "PropertyId" + postalCode21, new BigDecimal(320000.0), 
                "Avenida da Liberdade, 55", postalCode21, "Lisbon", "Lisbon", new BigDecimal(120.0), 
                new BigDecimal(110.0), (long) 3L, (long) 2L, (long) 8L, (long) 1L, true, LocalDate.of(2010, 5, 1), 
                "Samsung Refrigerator", "Private balcony with city view", "Modern 3-bedroom apartment in central Lisbon, perfect for families or professionals", photoReferences));

            // Accept Request Create Apartment Property
            System.out.println(operatorService.acceptRequestCreateApartmentProperty(uuid1, uuid2, postalCode21));

            // Request Create Apartment Property
            String postalCode22 = "5000-003";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid2, "PropertyId" + postalCode22, new BigDecimal(320000.0), 
                "Avenida da Liberdade, 55", postalCode22, "Lisbon", "Lisbon", new BigDecimal(120.0), 
                new BigDecimal(110.0), (long) 3L, (long) 2L, (long) 8L, (long) 1L, true, LocalDate.of(2010, 5, 1), 
                "Samsung Refrigerator", "Private balcony with city view", "Modern 3-bedroom apartment in central Lisbon, perfect for families or professionals", photoReferences));

            // Accept Request Create Apartment Property
            System.out.println(operatorService.acceptRequestCreateApartmentProperty(uuid1, uuid2, postalCode22));

            // Request Create Apartment Property
            String postalCode23 = "5000-004";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid2, "PropertyId" + postalCode23, new BigDecimal(320000.0), 
                "Avenida da Liberdade, 55", postalCode23, "Lisbon", "Lisbon", new BigDecimal(120.0), 
                new BigDecimal(110.0), (long) 3L, (long) 2L, (long) 8L, (long) 1L, true, LocalDate.of(2010, 5, 1), 
                "Samsung Refrigerator", "Private balcony with city view", "Modern 3-bedroom apartment in central Lisbon, perfect for families or professionals", photoReferences));

            // Accept Request Create Apartment Property
            System.out.println(operatorService.acceptRequestCreateApartmentProperty(uuid1, uuid2, postalCode23));

            // Request Create Apartment Property
            String postalCode24 = "5000-005";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid2, "PropertyId" + postalCode24, new BigDecimal(320000.0), 
                "Avenida da Liberdade, 55", postalCode24, "Lisbon", "Lisbon", new BigDecimal(120.0), 
                new BigDecimal(110.0), (long) 3L, (long) 2L, (long) 8L, (long) 1L, true, LocalDate.of(2010, 5, 1), 
                "Samsung Refrigerator", "Private balcony with city view", "Modern 3-bedroom apartment in central Lisbon, perfect for families or professionals", photoReferences));

            // Accept Request Create Apartment Property
            System.out.println(operatorService.acceptRequestCreateApartmentProperty(uuid1, uuid2, postalCode24));


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
            System.out.println(issuanceService.requestDeIssueTransferable(uuid2, "IssuanceId"+uuid2, postalCode3));

            // Atomic Swap Request
            System.out.println(issuanceService.requestSwap(uuid1, uuid3, uuid2, postalCode1));

            // Accept Atomic Swap Request
            System.out.println(userAccountService.acceptSwapRequest(uuid1, uuid3, uuid2, uuid4, postalCode1, "APARTMENT"));

            // Atomic Swap Request
            System.out.println(issuanceService.requestSwap(uuid1, uuid2, uuid3, postalCode2));

            // Atomic Swap Request
            System.out.println(issuanceService.requestSwap(uuid1, uuid2, uuid3, postalCode4));

            // Atomic Swap Request
            System.out.println(issuanceService.requestSwap(uuid1, uuid2, uuid3, postalCode5));
            
            // Test GETS of individual property
            System.out.println("GET INDIVIDUAL PROPERTY : ");
            System.out.println(userPropertyService.getApartmentPropertyById(postalCode1));
            //System.out.println(userPropertyService.getLandPropertyById(postalCode2));
            System.out.println(userPropertyService.getGaragePropertyById(postalCode4));
            System.out.println(userPropertyService.getResidencePropertyById(postalCode5));
            System.out.println(userPropertyService.getWarehousePropertyById(postalCode6));

            // Test GETS of all properties of a user
            Map<String, List<?>> allUserProperties = userPropertyService.getAllUserProperties(uuid2);
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
            for (SwapRequestGETDTO request: userAccountService.getAllUserSwapRequests(uuid3)) {
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
            System.out.println("\nGET USER PROFILE : " + uuid2);
            System.out.println(userProfileService.getUserProfile(uuid2).getFullName());

            // Test GET USER BALANCE
            System.out.println("\nGET USER BALANCE : ");
            System.out.println(userAccountService.getUserHoldingFungible(uuid3).getAmount());

            String postalCode8 = "2675-620";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid3, "PropertyId" + postalCode8, 
                new BigDecimal("320000.00"), 
                "Avenida da Liberdade, n10 3Esq", postalCode8, "Lisbon", "Lisbon", new BigDecimal("120.0"), 
                new BigDecimal("110.0"), 3L, 2L, 3L, 1L, true, LocalDate.of(2005, 6, 15), 
                "Washing machine, Air conditioning", "Recently renovated with high-end finishes.", 
                "A modern 3-bedroom apartment located in the heart of Lisbon, close to shops and public transport.", photoReferences));

            String postalCode9 = "2675-621";
            System.out.println(userPropertyService.requestCreateApartmentProperty(uuid2, "PropertyId" + postalCode9, 
                new BigDecimal("280000.00"), 
                "Rua da Prata, n5 2Dir", postalCode9, "Lisbon", "Lisbon", new BigDecimal("90.0"), 
                new BigDecimal("85.0"), 2L, 1L, 2L, 0L, false, LocalDate.of(2010, 9, 10), 
                "Dishwasher, Built-in wardrobes", "Sunny apartment with a large living room and open kitchen.", 
                "A cozy 2-bedroom apartment perfect for young professionals or a small family.", photoReferences));

            String postalCode10 = "2675-622";
            System.out.println(userPropertyService.requestCreateLandProperty(uuid3, "PropertyId" + postalCode10, 
                new BigDecimal("150000.00"), 
                "Estrada Nacional 1, Km 58", postalCode10, "Leiria", "Leiria", LandType.URBAN, new BigDecimal("1000.0"), new BigDecimal("500.0"),
                new BigDecimal("800.0"), 3L, true, "Paved road access, Electricity", viableConstructionTypes, 
                "Ideal for building a small residential complex or a large private villa.", 
                "Urban land in a rapidly developing area, close to schools and shopping centers.", photoReferences));

            String postalCode11 = "2675-623";
            System.out.println(userPropertyService.requestCreateGarageProperty(uuid2, "PropertyId" + postalCode11, 
                new BigDecimal("30000.00"), 
                "Rua da Alegria, n12", postalCode11, "Porto", "Porto", new BigDecimal("20.0"), GarageType.CONDOMINIUMPRIVATE,
                1L, "Automatic door, Lighting", "Secure and well-maintained garage space.", 
                "Single garage in the city center, perfect for protecting your vehicle from the elements.", photoReferences));

            String postalCode12 = "2675-624";
            System.out.println(userPropertyService.requestCreateResidenceProperty(uuid2, "PropertyId" + postalCode12, 
                new BigDecimal("500000.00"), 
                "Rua das Flores, n22", postalCode12, "Faro", "Faro", new BigDecimal("250.0"), new BigDecimal("220.0"),
                5L, 4L, 3L, ResidenceType.CORNERLOT, "Private garden with pool", Parking.COVERED, LocalDate.of(2015, 3, 22),
                Orientation.SOUTH, "Solar panels, Central heating", "Luxury residence with modern amenities and beautiful sea views.", 
                "A stunning semi-detached house with a pool, ideal for a large family.", photoReferences));

            String postalCode13 = "2675-625";
            System.out.println(userPropertyService.requestCreateWarehouseProperty(uuid3, "PropertyId" + postalCode13, 
                new BigDecimal("750000.00"), 
                "Zona Industrial de Alverca", postalCode13, "Lisbon", "Alverca", WarehouseType.STORAGEROOM, new BigDecimal("1200.0"), new BigDecimal("1100.0"),
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

    @GET
    @Produces(MediaType.APPLICATION_JSON) // The method will return JSON
    @Path("/getAllPropertyRequests") // This method is accessible at /operator/getAllPropertyRequests
    public Map<String, List<?>> getAllPropertyRequests() {
        test();
        return service.getAllPropertyRequests(); // Fetches and returns all property requests
    }
}
