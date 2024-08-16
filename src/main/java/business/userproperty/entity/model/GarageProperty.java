package business.userproperty.entity.model;

import java.math.BigDecimal;
import java.util.List;

import daml.marketplace.interface$.propertymanager.property.common.GarageType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GarageProperty {
  @Id
  private String partyId;

  @Column(name = "contractId")
  private String contractId;

  @Column(name = "propertyId")
  private String propertyId;

  @Column(name = "garagePrice")
  private BigDecimal garagePrice;

  @Column(name = "propertyAddress")
  private String propertyAddress;

  @Column(name = "propertyPostalCode")
  private String propertyPostalCode;

  @Column(name = "propertyDistrict")
  private String propertyDistrict;

  @Column(name = "propertyCounty")
  private String propertyCounty;

  @Column(name = "garageArea")
  private BigDecimal garageArea;

  @Column(name = "garageType")
  private GarageType garageType;

  @Column(name = "vehicleCapacity")
  private Long vehicleCapacity;

  @Column(name = "installedEquipment")
  private String installedEquipment;

  @Column(name = "additionalInformation")
  private String additionalInformation;

  @Column(name = "description")
  private String description;

  @Column(name = "photoReferences")
  private List<String> photoReferences;
}