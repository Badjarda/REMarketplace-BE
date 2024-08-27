package business.operator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePropertyRequestDTO {
  private String user;
  private String postalCode;
  private String propertyType;
}

