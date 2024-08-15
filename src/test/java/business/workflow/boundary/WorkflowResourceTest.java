package business.workflow.boundary;

//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.is;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
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
import business.useraccount.service.UserAccountService;
//import business.userprofile.dto.ProfileServiceOfferDTO;
//import business.userprofile.dto.UserProfileDTO;
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
//import jakarta.ws.rs.core.MediaType;

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

        // Creating the parties
        System.out.println(partyService.createParty(uuid1));
        System.out.println(partyService.createParty(uuid2));
        System.out.println(partyService.createParty(uuid3));
        System.out.println(partyService.createParty(uuid4));

        // Creating the Users
        System.out.println(userService.createUser(uuid1, uuid1));
        System.out.println(userService.createUser(uuid2, uuid2));
        System.out.println(userService.createUser(uuid3, uuid3));
        System.out.println(userService.createUser(uuid4, uuid4));

        // Create User Factory
        System.out.println(roleManagerService.createUserFactory(uuid1));

        // Create Operator Role
        System.out.println(operatorService.createOperatorRole(uuid1));

        // Create Initial Role
        System.out.println(operatorService.createInitialRole(uuid1, uuid4));

        // Offer User Role
        System.out.println(operatorService.offerUserRole(uuid1, uuid2, "RegisteredUserRole"));
        System.out.println(operatorService.offerUserRole(uuid1, uuid3, "RegisteredUserRole"));

        // Accept User Role
        System.out.println(userRoleService.acceptUserRole(uuid1, uuid2));
        System.out.println(userRoleService.acceptUserRole(uuid1, uuid3));
        
        // Create User Profile Factory
        System.out.println(profileManagerService.createUserProfileFactory(uuid1));

        // Offer User Profile Service
        System.out.println(operatorService.offerUserProfileService(uuid1, uuid2));
        System.out.println(operatorService.offerUserProfileService(uuid1, uuid3));
        
        // Accept Profile Service
        //ProfileServiceOfferDTO offer = new ProfileServiceOfferDTO(uuid1, uuid2);
        //given()
            //.contentType(MediaType.APPLICATION_JSON)
            //.body(offer)
            //.post("/userProfile/acceptProfileService")
            //.then()
            //.statusCode(200)
            //.body(is("Accepted Profile Service!\n"));
        System.out.println(userProfileService.acceptProfileService(uuid1, uuid2));
        System.out.println(userProfileService.acceptProfileService(uuid1, uuid3));

        // Create Profile Requests
        List<String> photoReferences = Arrays.asList("url1", "url2", "url3");
        /** 
        UserProfileDTO profileDTO = new UserProfileDTO(uuid1, uuid2, uuid4, "Profile" + uuid2, "DuarteCosta", "Duarte",
                        "Costa", "Duarte Ferreira da Costa", "passwordTest", LocalDate.of(2000, 1, 1),
                        Optional.of(Gender.MALE), Nationality.PORTUGUESE, "ola@gmail.com",
                        Optional.of((long) 912345678L), (long) 212345678L, (long) 12345678901L, (long) 987654321L,
                        photoReferences);*/
        
        System.out.println(userProfileService.requestCreateUserProfile(uuid1, uuid2, uuid4, "Profile" + uuid2, "DuarteCosta", "Duarte",
                        "Costa", "Duarte Ferreira da Costa", "passwordTest", LocalDate.of(2000, 1, 1),
                        Optional.of(Gender.MALE), Nationality.PORTUGUESE, "ola@gmail.com",
                        Optional.of((long) 912345678L), (long) 212345678L, (long) 12345678901L, (long) 987654321L,
                        photoReferences));
        
        /**given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(profileDTO)
            .post("/userProfile/requestCreateUserProfile")
            .then()
            .statusCode(200)
            .body(is("Success Create User Profile Request!\n"));*/
        

        System.out.println(userProfileService.requestCreateUserProfile(uuid1, uuid3, uuid4,
                        "Profile" + uuid3, "PauloSeixo", "Paulo", "Seixo", "Paulo Bem Seixc", "passwordTest1234",
                        LocalDate.of(2000, 1, 1), Optional.of(Gender.MALE), Nationality.NIGERIEN, "adeus@gmail.com",
                        Optional.of((long) 987654321L), (long) 212345678L, (long) 12345678901L, (long) 987654321L,
                        photoReferences));
        // Accept Profile Request
        System.out.println(operatorService.acceptRequestCreateProfile(uuid1, uuid2));
        System.out.println(operatorService.acceptRequestCreateProfile(uuid1, uuid3));

        // Modify Profile
        System.out.println(userProfileService.modifyUserProfileFields(uuid1, uuid2, "JoséCosta", "José", "Costa", "José António Costa", "passwordTeste", LocalDate.of(2000, 1, 1), Optional.of(Gender.MALE), Nationality.PORTUGUESE, "jacosta.arq@gmail.com", Optional.of((long) 987654321L), (long) 212345678L, (long) 12345678901L, (long) 987654321L, photoReferences));
    
        // Create Account Factories
        System.out.println(accountManagerService.createCustodyService(uuid1, uuid2, uuid4, "TransferableUser"));
        
        // Offer Account Services
        System.out.println(operatorService.offerCustodianService(uuid1, uuid2));
        System.out.println(operatorService.offerCustodianService(uuid1, uuid3));
        
        // Accept Account Services
        System.out.println(userAccountService.acceptCustodyService(uuid1, uuid2));
        System.out.println(userAccountService.acceptCustodyService(uuid1, uuid3));
        
        // Create Account Open Requests
        System.out.println(userAccountService.requestOpenAccount(uuid1, uuid2, "Account"+uuid2, "My Daml.Finance Account"));
        System.out.println(userAccountService.requestOpenAccount(uuid1, uuid3, "Account"+uuid3, "My Daml.Finance Account"));
        
        // Accept Account Open Requests
        System.out.println(operatorService.acceptRequestOpenAccount(uuid1, uuid2));
        System.out.println(operatorService.acceptRequestOpenAccount(uuid1, uuid3));
        
        // Create Deposit Currency Requests + Accept
        System.out.println(userAccountService.requestDepositCurrencyInstrument(uuid1, uuid3, "EUR", new BigDecimal("200000.0")));

        System.out.println(operatorService.acceptRequestDeposit(uuid1, uuid3, uuid4));


        System.out.println(userAccountService.requestDepositCurrencyInstrument(uuid1, uuid3, "EUR", new BigDecimal("450000.0")));

        System.out.println(operatorService.acceptRequestDeposit(uuid1, uuid3, uuid4));

        // Create Withdraw Currency Requests
        //System.out.println(userAccountService.requestWithdrawFungible(uuid1, uuid2));

        // Accept Withdraw Currency Requests
        //System.out.println(operatorService.acceptRequestWithdraw(uuid1, uuid2));

        // Create Property Service
        System.out.println(propertyManagerService.createPropertyFactories(uuid1));

        // Offer Property Service
        System.out.println(operatorService.offerPropertyManagerService(uuid1, uuid2));
        System.out.println(operatorService.offerPropertyManagerService(uuid1, uuid3));

        // Accept Property Service
        System.out.println(userPropertyService.acceptPropertyService(uuid1, uuid2));
        System.out.println(userPropertyService.acceptPropertyService(uuid1, uuid3));

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

        // Offer Issuance Service
        System.out.println(operatorService.offerIssuanceService(uuid1, uuid2));
        System.out.println(operatorService.offerIssuanceService(uuid1, uuid3));

        // Accept Issuance Service
        System.out.println(issuanceService.acceptIssuanceService(uuid1, uuid2));
        System.out.println(issuanceService.acceptIssuanceService(uuid1, uuid3));
        
        // Create Issue Transferable Request 
        System.out.println(issuanceService.requestIssueTransferable(uuid1, uuid2, "IssuanceId"+uuid2, postalCode1, "APARTMENT"));

        // Accept Issue Transferable Request
        System.out.println(operatorService.acceptRequestIssue(uuid1, uuid2));

        // Create DeIssue Transferable Request
        //System.out.println(issuanceService.requestDeIssueTransferable(uuid1, uuid2, "IssuanceId"+uuid2));

        // Accept DeIssue Transferable Request
        //System.out.println(operatorService.acceptRequestDeIssue(uuid1, uuid2));

        // Atomic Swap Request
        System.out.println(issuanceService.requestSwap(uuid1, uuid3, uuid2, postalCode1));

        // Accept Atomic Swap Request
        System.out.println(userAccountService.acceptSwapRequest(uuid1, uuid3, uuid2, uuid4, postalCode1, "APARTMENT"));
    }

}
