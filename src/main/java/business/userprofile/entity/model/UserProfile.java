package business.userprofile.entity.model;

import java.time.LocalDate;
import java.util.List;

import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    @Id
  private String partyId;

  @Column(name = "contractId")
  private String contractId;

  @Column(name = "profileId")
  private String profileId;

  @Column(name = "username")
  private String username;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "fullName")
  private String fullName;

  @Column(name = "password")
  private String password;

  @Column(name = "birthday")
  private LocalDate birthday;

  @Column(name = "gender")
  private Gender gender;

  @Column(name = "nationality")
  private Nationality nationality;

  @Column(name = "contactMail")
  private String contactMail;

  @Column(name = "cellphoneNumber")
  private Long cellphoneNumber;

  @Column(name = "idNumber")
  private Long idNumber;

  @Column(name = "taxId")
  private Long taxId;

  @Column(name = "socialSecurityId")
  private Long socialSecurityId;

  @Column(name = "photoReferences")
  private List<String> photoReferences;
}
