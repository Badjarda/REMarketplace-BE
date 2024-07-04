package business.userproperty.dto;

import java.math.BigDecimal;

import daml.marketplace.interface$.propertymanager.property.common.GarageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GaragePropertyDTO {
  private final String operator;
  private final String user;
  private final String propertyId;
  
  private final String propertyAddress;

  private final String propertyPostalCode;

  private final String propertyDistrict;

  private final String propertyCounty;

  private final BigDecimal garageArea;

  private final GarageType garageType;

  private final Long vehicleCapacity;

  private final String installedEquipment;

  private final String additionalInformation;

  private final String description;
}
