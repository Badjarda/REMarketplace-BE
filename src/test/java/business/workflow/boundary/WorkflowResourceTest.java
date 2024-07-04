package business.workflow.boundary;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import apiconfiguration.Transactions;

import business.operator.service.OperatorService;
import business.party.service.PartyService;
import business.profilemanager.service.ProfileManagerService;
import business.rolemanager.dto.UserRoleRequestDTO;
import business.rolemanager.dto.UserRolePermissionsDTO;
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

                System.out.println("!!!!!   TESTE   !!!!!");
                String uuid1 = UUID.randomUUID().toString(); // Operator
                System.out.println("uuid1 : " + uuid1 + "\n");
                String uuid2 = UUID.randomUUID().toString(); // Seller
                System.out.println("uuid2 : " + uuid2 + "\n");
                String uuid3 = UUID.randomUUID().toString(); // Buyer
                System.out.println("uuid3 : " + uuid3 + "\n");
                String uuid4 = UUID.randomUUID().toString(); // Public
                System.out.println("uuid4 : " + uuid4 + "\n");

                System.out.println("############################################\n");

                // ############### Creating the parties ###############

                // given()
                // .pathParam("name", uuid)
                // .when().post("/party/createParty/{name}")
                // .then()
                // .statusCode(200)
                // .body(is("Party " + uuid + " Successfully created!\n"));

                System.out.println(partyService.createParty(uuid1));
                System.out.println(partyService.createParty(uuid2));
                System.out.println(partyService.createParty(uuid3));
                System.out.println(partyService.createParty(uuid4));

                System.out.println("############################################\n");

                // ############### Creating the User ###############
                /**
                 * given()
                 * .pathParam("name", uuid1)
                 * .pathParam("party", uuid1)
                 * .when().post("/user/createUser/{name}/{party}")
                 * .then()
                 * .statusCode(200)
                 * .body(is("User "+ uuid1 + " Successfully created!\n"));
                 */

                System.out.println(userService.createUser(uuid1, uuid1));
                System.out.println(userService.createUser(uuid2, uuid2));
                System.out.println(userService.createUser(uuid3, uuid3));
                System.out.println(userService.createUser(uuid4, uuid4));

                System.out.println("############################################\n");

                // ############### Update() ###############

                transactionService.update();

                // ############### CreateUserFactory ###############
                /**
                 * given()
                 * .pathParam("operator", uuid)
                 * .when().post("/roleManager/createUserFactory/{operator}")
                 * .then()
                 * .statusCode(200)
                 * .body(is("Created User Role Factory!\n"));
                 */

                System.out.println(roleManagerService.createUserFactory(uuid1));

                System.out.println("############################################\n");

                CompletableFuture<Void> completionFuture = CompletableFuture.completedFuture(null);
                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                // ############### createOperatorRole ###############
                /**
                 * given()
                 * .pathParam("operator", uuid)
                 * .when().post("/operator/createOperator/{operator}")
                 * .then()
                 * .statusCode(200)
                 * .body(is("Operator Role " + uuid + " successfully created!\n"));
                 */

                // ############### createInitialRole ###############

                completionFuture.thenRun(() -> System.out.println(operatorService.createOperatorRole(uuid1)))
                                .thenRun(() -> {
                                })
                                .join();

                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                completionFuture.thenRun(() -> System.out.println(operatorService.createInitialRole(uuid1, uuid4)))
                                .thenRun(() -> {
                                })
                                .join();

                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));
                // ############### offerUserRole ###############

                completionFuture.thenRun(() -> System.out
                                .println(operatorService.offerUserRole(uuid1, uuid2, "RegisteredUserRole")))
                                .thenRun(() -> System.out.println(
                                                operatorService.offerUserRole(uuid1, uuid3, "RegisteredUserRole")))
                                .thenRun(() -> {
                                })
                                .join();

                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                // ############### acceptUserRole ###############

                completionFuture.thenRun(() -> System.out.println(userRoleService.acceptUserRole(uuid1, uuid2)))
                                .thenRun(() -> System.out.println(userRoleService.acceptUserRole(uuid1, uuid3)))
                                .thenRun(() -> {
                                })
                                .join();

                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                // ############### Profile Service ###############

                completionFuture.thenRun(
                                () -> System.out.println(profileManagerService.createUserProfileFactory(uuid1)))
                                .thenRun(() -> {
                                })
                                .join();

                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                // ############### Offer User Profile Service ###############

                completionFuture.thenRun(
                                () -> System.out.println(operatorService.offerUserProfileService(uuid1, uuid2)))
                                .thenRun(() -> System.out
                                                .println(operatorService.offerUserProfileService(uuid1, uuid3)))
                                .thenRun(() -> {
                                })
                                .join();

                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                // ############### acceptProfileService ###############

                ProfileServiceOfferDTO offer = new ProfileServiceOfferDTO(uuid1, uuid2);
                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(offer)
                                .post("/userProfile/acceptProfileService")
                                .then()
                                .statusCode(200)
                                .body(is("Accepted Profile Service!\n"));

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                completionFuture.thenRun(
                                () -> System.out.println(userProfileService.acceptProfileService(uuid1, uuid3)))
                                .thenRun(() -> {
                                })
                                .join();

                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                // ############### Profile Create Requests ###############

                UserProfileDTO profileDTO = new UserProfileDTO(uuid1, uuid2, "Profile" + uuid2, "DuarteCosta", "Duarte",
                                "Costa", "Duarte Ferreira da Costa",
                                LocalDate.of(2000, 1, 1), Optional.of(Gender.MALE), Nationality.PORTUGUESE,
                                "ola@gmail.com",
                                Optional.of((long) 912345678L), (long) 212345678L, (long) 12345678901L);
                given()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(profileDTO)
                                .post("/userProfile/requestCreateUserProfile")
                                .then()
                                .statusCode(200)
                                .body(is("Success Create User Profile Request!\n"));

                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                completionFuture.thenRun(
                                () -> System.out.println(userProfileService.requestCreateUserProfile(uuid1, uuid3,
                                                "Profile" + uuid3,
                                                "João Maria", "João",
                                                "Maria", "João Barreiro Maria",
                                                LocalDate.of(2002, 10, 10), Optional.of(Gender.MALE),
                                                Nationality.PORTUGUESE,
                                                "adeus@gmail.com",
                                                Optional.of((long) 912445677L), (long) 212355578L,
                                                (long) 12345278101L)))
                                .thenRun(() -> {
                                })
                                .join();

                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

                // ############### Profile Request Accept ###############

                completionFuture.thenRun(
                                () -> System.out.println(operatorService.acceptRequestCreateProfile(uuid1, uuid2)))
                                .thenRun(() -> System.out
                                                .println(operatorService.acceptRequestCreateProfile(uuid1, uuid3)))
                                .thenRun(() -> {
                                })
                                .join();
                System.out.println("############################################\n");

                completionFuture = completionFuture.thenCompose(result -> CompletableFuture.runAsync(() -> {
                        try {
                                Thread.sleep(5000); // Adjust sleep time as needed
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                        }
                }));

        }

}
