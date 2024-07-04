package business.userprofile.dto;

import java.time.LocalDate;
import java.util.Optional;

import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {

  private String operator;

  private String user;

  private String profileId;

  private String username;

  private String firstName;

  private String lastName;

  private String fullName;

  private LocalDate birthday;

  private Optional<Gender> gender;

  private Nationality nationality;

  private String contactMail;

  private Optional<Long> cellphoneNumber;

  private Long taxId;

  private Long socialSecurityId;
}
