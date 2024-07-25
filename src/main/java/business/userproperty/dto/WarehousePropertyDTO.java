package business.userproperty.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import daml.marketplace.interface$.propertymanager.property.common.WarehouseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WarehousePropertyDTO {
  private final String operator;
  private final String user;
  private final String propertyId;
  private final BigDecimal warehousePrice;
  
  private final String propertyAddress;

  private final String propertyPostalCode;

  private final String propertyDistrict;

  private final String propertyCounty;

  private final WarehouseType warehouseType;

  private final BigDecimal grossArea;

  private final BigDecimal usableArea;

  private final Long floors;

  private final LocalDate buildDate;

  private final String installedEquipment;

  private final String additionalInformation;

  private final String description;

  private final List<String> photoReferences;
}
