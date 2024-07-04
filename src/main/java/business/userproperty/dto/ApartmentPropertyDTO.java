package business.userproperty.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApartmentPropertyDTO {

  private final String operator;
  private final String user;
  private final String propertyId;
  private final String propertyAddress;

  private final String propertyPostalCode;

  private final String propertyDistrict;

  private final String propertyCounty;

  private final BigDecimal grossArea;

  private final BigDecimal usableArea;

  private final Long bedrooms;

  private final Long bathrooms;

  private final Long floor;

  private final Long parkingSpaces;

  private final Boolean elevator;

  private final LocalDate buildDate;

  private final String installedEquipment;

  private final String additionalInformation;

  private final String description;

}

