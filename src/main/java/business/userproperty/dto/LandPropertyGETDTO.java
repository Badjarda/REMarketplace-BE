package business.userproperty.dto;

import java.math.BigDecimal;
import java.util.List;

import daml.marketplace.interface$.propertymanager.property.common.LandType;
import daml.marketplace.interface$.propertymanager.property.common.ViableConstructionTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LandPropertyGETDTO {
  private final String propertyId;
  private final String owner;
  private final BigDecimal price;
  private final String propertyAddress;
  private final String propertyPostalCode;
  private final String propertyDistrict;
  private final String propertyCounty;
  private final LandType landType;
  private final BigDecimal totalLandArea;
  private final BigDecimal minimumSurfaceForSale;
  private final BigDecimal buildableArea;
  private final Long buildableFloors;
  private final Boolean accessByRoad;
  private final String installedEquipment;
  private final List<ViableConstructionTypes> viableConstructionTypes;
  private final String additionalInformation;
  private final String description;
  private final List<String> photoReferences;
}
