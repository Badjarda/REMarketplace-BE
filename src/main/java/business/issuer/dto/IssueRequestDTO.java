package business.issuer.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueRequestDTO {

  private String operator;

  private String user;

  private String issuanceIdString;

  private String propertyIdString;

  private String postalCode;

  private String tokenStringId;

  private BigDecimal amount;
}