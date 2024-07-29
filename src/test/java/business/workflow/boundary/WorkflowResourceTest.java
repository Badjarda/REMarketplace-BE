package business.workflow.boundary;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import apiconfiguration.Transactions;
import business.operator.service.OperatorService;
import business.party.service.PartyService;
import business.profilemanager.service.ProfileManagerService;
import business.rolemanager.service.RoleManagerService;
import business.user.service.UserService;
import business.userprofile.dto.ProfileServiceOfferDTO;
import business.userprofile.dto.UserProfileDTO;
import business.userprofile.service.UserProfileService;
import business.userrole.service.UserRoleService;
import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

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

    @Test
    public void testWorkflow() {
        String uuid1 = UUID.randomUUID().toString(); // Operator
        String uuid2 = UUID.randomUUID().toString(); // Seller
        String uuid3 = UUID.randomUUID().toString(); // Buyer
        String uuid4 = UUID.randomUUID().toString(); // Public

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

        sleep(5000);
        /*
        // Create Profile Requests
        List<String> photoReferences = Arrays.asList("url1", "url2", "url3");
        UserProfileDTO profileDTO = new UserProfileDTO(uuid1, uuid2, uuid4, "Profile" + uuid2, "DuarteCosta", "Duarte",
                        "Costa", "Duarte Ferreira da Costa", "passwordTest", LocalDate.of(2000, 1, 1),
                        Optional.of(Gender.MALE), Nationality.PORTUGUESE, "ola@gmail.com",
                        Optional.of((long) 912345678L), (long) 212345678L, (long) 12345678901L, (long) 987654321L,
                        photoReferences);
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(profileDTO)
            .post("/userProfile/requestCreateUserProfile")
            .then()
            .statusCode(200)
            .body(is("Success Create User Profile Request!\n"));

        completionFuture.thenRun(() -> System.out.println(userProfileService.requestCreateUserProfile(uuid1, uuid3, uuid4,
                        "Profile" + uuid2, "PauloSeixo", "Paulo", "Seixo", "Paulo Bem Seixc", "passwordTest1234",
                        LocalDate.of(2000, 1, 1), Optional.of(Gender.MALE), Nationality.NIGERIEN, "adeus@gmail.com",
                        Optional.of((long) 987654321L), (long) 212345678L, (long) 12345678901L, (long) 987654321L,
                        photoReferences))).join();

        // Accept Profile Request
        completionFuture.thenRun(() -> System.out.println(operatorService.acceptRequestCreateProfile(uuid1, uuid2)))
                        .thenRun(() -> System.out.println(operatorService.acceptRequestCreateProfile(uuid1, uuid3)))
                        .join();
        */
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
