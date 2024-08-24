package business.userproperty.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;
import daml.marketplace.interface$.propertymanager.property.common.GarageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GaragePropertyDTO {
  
  private final String user;
  private final String propertyId;
  private final BigDecimal garagePrice;
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
  private final List<String> photoReferences;

  @JsonCreator
  public GaragePropertyDTO(
    @JsonProperty("user") String user,
    @JsonProperty("propertyId") String propertyId,
    @JsonProperty("garagePrice") BigDecimal garagePrice,
    @JsonProperty("propertyAddress") String propertyAddress,
    @JsonProperty("propertyPostalCode") String propertyPostalCode,
    @JsonProperty("propertyDistrict") String propertyDistrict,
    @JsonProperty("propertyCounty") String propertyCounty,
    @JsonProperty("garageArea") BigDecimal garageArea,
    @JsonProperty("garageType") GarageType garageType,
    @JsonProperty("vehicleCapacity") Long vehicleCapacity,
    @JsonProperty("installedEquipment") String installedEquipment,
    @JsonProperty("additionalInformation") String additionalInformation,
    @JsonProperty("description") String description,
    @JsonProperty("photoReferences") List<String> photoReferences
  ) {
    this.user = user;
    this.propertyId = propertyId;
    this.garagePrice = garagePrice;
    this.propertyAddress = propertyAddress;
    this.propertyPostalCode = propertyPostalCode;
    this.propertyDistrict = propertyDistrict;
    this.propertyCounty = propertyCounty;
    this.garageArea = garageArea;
    this.garageType = garageType;
    this.vehicleCapacity = vehicleCapacity;
    this.installedEquipment = installedEquipment;
    this.additionalInformation = additionalInformation;
    this.description = description;
    this.photoReferences = photoReferences;
  }

}
