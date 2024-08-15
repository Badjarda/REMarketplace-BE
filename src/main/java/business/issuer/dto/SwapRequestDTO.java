package business.issuer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwapRequestDTO {
    private String operator;

    private String buyer;

    private String seller;

    private String postalCode;
}

  