package business.useraccount.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcceptSwapRequestDTO {

  private String buyer;

  private String seller;

  private String postalCode;

  private String propertyType;

}
