package business.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {

  private final String name;
  private final String party;
  private final String profileId;
  private final String username;
  private final String firstName;
  private final String lastName;
  private final String fullName;
  private final String password;
  private final LocalDate birthday;
  private final Optional<Gender> gender;
  private final Nationality nationality;
  private final String contactMail;
  private final Optional<Long> cellphoneNumber;
  private final Long idNumber;
  private final Long taxId;
  private final Long socialSecurityId;
  private final List<String> photoReferences;

  @JsonCreator
  public CreateUserDTO(
      @JsonProperty("name") String name,
      @JsonProperty("party") String party,
      @JsonProperty("profileId") String profileId,
      @JsonProperty("username") String username,
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("fullName") String fullName,
      @JsonProperty("password") String password,
      @JsonProperty("birthday") LocalDate birthday,
      @JsonProperty("gender") Optional<Gender> gender,
      @JsonProperty("nationality") Nationality nationality,
      @JsonProperty("contactMail") String contactMail,
      @JsonProperty("cellphoneNumber") Optional<Long> cellphoneNumber,
      @JsonProperty("idNumber") Long idNumber,
      @JsonProperty("taxId") Long taxId,
      @JsonProperty("socialSecurityId") Long socialSecurityId,
      @JsonProperty("photoReferences") List<String> photoReferences
  ) {
      this.name = name;
      this.party = party;
      this.profileId = profileId;
      this.username = username;
      this.firstName = firstName;
      this.lastName = lastName;
      this.fullName = fullName;
      this.password = password;
      this.birthday = birthday;
      this.gender = gender;
      this.nationality = nationality;
      this.contactMail = contactMail;
      this.cellphoneNumber = cellphoneNumber;
      this.idNumber = idNumber;
      this.taxId = taxId;
      this.socialSecurityId = socialSecurityId;
      this.photoReferences = photoReferences;
  }
}
