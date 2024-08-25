package business.issuer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeIssueRequestDTO {

  private String user;

  private String issuanceIdString;

  private String postalCode;

}