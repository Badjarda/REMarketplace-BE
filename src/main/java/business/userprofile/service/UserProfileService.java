package business.userprofile.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.daml.ledger.javaapi.data.Unit;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import apiconfiguration.Transactions;
import business.DamlLedgerClientProvider;
import business.operator.entity.repository.OperatorRepository;
import business.profilemanager.entity.repository.UserProfileManagerRepository;
import business.user.entity.repository.UserRepository;
import business.userprofile.entity.repository.ProfileServiceOfferRepository;
import business.userprofile.entity.repository.UserProfileRepository;
import daml.da.set.types.Set;
import daml.daml.finance.interface$.types.common.types.Id;
import daml.marketplace.interface$.common.types.UserProfileKey;
import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserProfileService {
  @Inject
  DamlLedgerClientProvider clientProvider;

  @Inject
  UserRepository userRepository;

  @Inject
  Transactions transactionService;

  @Inject
  OperatorRepository operatorRepository;

  @Inject
  ProfileServiceOfferRepository profileServiceOfferRepository;

  @Inject
  UserProfileManagerRepository userProfileManagerRepository;

  @Inject
  UserProfileRepository userProfileRepository;

  public static final String APP_ID = "OperatorId";

  public UserProfileService() {

  }

  private void handleProfileServiceOffer(String operator, String user, String action)
      throws IllegalArgumentException, IllegalStateException, Exception {

    String operatorParty = userRepository.findById(operator).getPartyId();
    String userParty = userRepository.findById(user).getPartyId();
    String offerContractId = profileServiceOfferRepository.findById(operatorParty + userParty)
        .getContractId();
    List<com.daml.ledger.javaapi.data.Command> command = null;

    var serviceAcceptId = new daml.marketplace.interface$.profilemanager.service.Offer.ContractId(
        offerContractId);

    if (action.equals("accept"))
      command = serviceAcceptId.exerciseAccept().commands();
    else if (action.equals("decline"))
      command = serviceAcceptId.exerciseDecline().commands();

    transactionService.submitTransaction(command, Arrays.asList(operatorParty, userParty), null);

  }

  public String acceptProfileService(String operator, String user) {
    try {
      handleProfileServiceOffer(operator, user, "accept");
    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error accepting Profile Service: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error accepting Profile Service : " + e.getMessage() + "\n";
    }

    return "Accepted Profile Service!\n";
  }

  public String declineProfileService(String operator, String user) {
    try {
      handleProfileServiceOffer(operator, user, "decline");

    } catch (IllegalArgumentException | IllegalStateException e) {
      // Handle input validation or contract existence check errors
      return "Error declining Profile Service: " + e.getMessage() + "\n";
    } catch (Exception e) {
      // Handle other exceptions
      return "Error declining Profile Service: " + e.getMessage() + "\n";
    }
    return "Declined Profile Service!\n";
  }

  public String requestCreateUserProfile(String operator, String user, String publicString, String profileId,
      String username, String firstName, String lastName, String fullName, String password, LocalDate birthday,
      Optional<Gender> gender, Nationality nationality, String contactMail, Optional<Long> cellphoneNumber,
      Long idNumber, Long taxId, Long socialSecurityId, List<String> photoReferences) {
    try {
      System.out.println("ola1 " + user);
      System.out.println("Creating a new Profile:\n");
      System.out.println("ProfileId: " + profileId);
      System.out.println("Username: " + username);
      System.out.println("FirstName: " + firstName);
      System.out.println("LastName: " + lastName);
      System.out.println("FullName: " + fullName);
      System.out.println("Password: " + password);
      System.out.println("Birthday: " + birthday);
      System.out.println("Gender: " + gender);
      System.out.println("Nationality: " + nationality);
      System.out.println("ContactMail: " + contactMail);
      System.out.println("CellphoneNumber: " + cellphoneNumber);
      System.out.println("IdNumber: " + idNumber);
      System.out.println("TaxId: " + taxId);
      System.out.println("SocialSecurityId: " + socialSecurityId);
      System.out.println("Photo References: " + photoReferences.toString());

      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String publicParty = userRepository.findById(publicString).getPartyId();
      System.out.println("ola2 " + user);
      List<com.daml.ledger.javaapi.data.Command> command = null;
      String servicId = userProfileManagerRepository.findById(operatorParty + userParty).getContractId();
      System.out.println("ola3 " + user);
      Id userProfileKeyId = new Id(profileId);
      daml.marketplace.interface$.profilemanager.service.Service.ContractId serviceId = new daml.marketplace.interface$.profilemanager.service.Service.ContractId(
          servicId);
      System.out.println("ola4 " + user);
      Map<String, Unit> singletonMap = Collections.singletonMap(operatorParty, Unit.getInstance());
      Set<String> observers = new Set<>(singletonMap);
      Map<String, Set<String>> observersMap = new HashMap<String, Set<String>>();
      observersMap.put("Default", observers);
      System.out.println("ola5 " + user);
      command = serviceId
          .exerciseRequestCreateUserProfile(userProfileKeyId, username, firstName,
              lastName, fullName, password, birthday, gender, nationality, contactMail,
              cellphoneNumber, idNumber, taxId, socialSecurityId, photoReferences, observersMap)
          .commands();
      System.out.println("ola6 " + user);
      transactionService.submitTransaction(command, Arrays.asList(userParty), Arrays.asList(publicParty));
      System.out.println("ola7 " + user);
    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error request Create User Profile: " + e.getMessage();
    } catch (Exception e) {
      return "Error request Create User Profile : " + e.getMessage();
    }
    System.out.println("ola8 " + user);
    return "Success Create User Profile Request!\n";
  }

  public String modifyUserProfileFields(String operator, String user, String username,
      String firstName, String lastName, String fullName, LocalDate birthday, Optional<Gender> gender,
      Nationality nationality, String contactMail, Optional<Long> cellphoneNumber, Long taxId,
      Long socialSecurityId) {
    try {
      String operatorParty = userRepository.findById(operator).getPartyId();
      String userParty = userRepository.findById(user).getPartyId();
      String servicId = userProfileManagerRepository.findById(operatorParty + userParty)
          .getContractId();

      String profileIdString = userProfileRepository.findById(operatorParty + userParty).getProfileId();
      UserProfileKey key = new UserProfileKey(operatorParty, userParty, new Id(profileIdString));
      var serviceId = new daml.marketplace.interface$.profilemanager.service.Service.ContractId(
          servicId);
      transactionService.submitTransaction(serviceId.exerciseUpdateUsername(username, key).commands(),
          Arrays.asList(userParty), null);

      transactionService.submitTransaction(
          serviceId.exerciseUpdateFirstName(firstName, key).commands(),
          Arrays.asList(userParty), null);

      transactionService.submitTransaction(serviceId.exerciseUpdateLastName(lastName, key).commands(),
          Arrays.asList(userParty),null);

      transactionService.submitTransaction(serviceId.exerciseUpdateFullName(fullName, key).commands(),
          Arrays.asList(userParty), null);

      transactionService.submitTransaction(serviceId.exerciseUpdateBirthday(birthday, key).commands(),
          Arrays.asList(userParty), null);

      if (gender.isPresent())
        transactionService.submitTransaction(
            serviceId.exerciseUpdateGender(gender, key).commands(),
            Arrays.asList(userParty), null);

      transactionService.submitTransaction(
          serviceId.exerciseUpdateNationality(nationality, key).commands(),
          Arrays.asList(userParty), null);

      transactionService.submitTransaction(
          serviceId.exerciseUpdateContactMail(contactMail, key).commands(),
          Arrays.asList(userParty), null);

      if (cellphoneNumber.isPresent())
        transactionService.submitTransaction(
            serviceId.exerciseUpdateCellphoneNumber(cellphoneNumber, key)
                .commands(),
            Arrays.asList(userParty), null);

      transactionService.submitTransaction(serviceId.exerciseUpdateTaxId(taxId, key).commands(),
          Arrays.asList(userParty), null);

      transactionService.submitTransaction(
          serviceId.exerciseUpdateSocialSecurityId(socialSecurityId, key).commands(),
          Arrays.asList(userParty), null);

    } catch (IllegalArgumentException | IllegalStateException e) {
      return "Error Updating User Profile: " + e.getMessage();
    } catch (Exception e) {
      return "Error Updating User Profile: " + e.getMessage();
    }
    return "Success Updating User Profile:\n";
  }

}
