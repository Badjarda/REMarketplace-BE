package business.userproperty.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import daml.marketplace.interface$.propertymanager.property.common.Orientation;
import daml.marketplace.interface$.propertymanager.property.common.Parking;
import daml.marketplace.interface$.propertymanager.property.common.ResidenceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResidencePropertyDTO {
  private final String operator;
  private final String user;
  private final String propertyId;
  private final BigDecimal residencePrice;
  
  private final String propertyAddress;

  private final String propertyPostalCode;

  private final String propertyDistrict;

  private final String propertyCounty;

  private final BigDecimal grossArea;

  private final BigDecimal usableArea;

  private final Long bedrooms;

  private final Long bathrooms;

  private final Long floors;

  private final ResidenceType residenceType;

  private final String backyard;

  private final Parking parking;

  private final LocalDate buildDate;

  private final Orientation orientation;

  private final String installedEquipment;

  private final String additionalInformation;

  private final String description;

  private final List<String> photoReferences;
}
