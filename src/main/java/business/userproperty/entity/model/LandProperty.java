package business.userproperty.entity.model;

import java.math.BigDecimal;
import java.util.List;

import daml.marketplace.interface$.propertymanager.property.common.LandType;
import daml.marketplace.interface$.propertymanager.property.common.ViableConstructionTypes;
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
public class LandProperty {
  @Id
  private String partyId;

  @Column(name = "contractId")
  private String contractId;

  @Column(name = "propertyId")
  private String propertyId;

  @Column(name = "landPrice")
  private BigDecimal landPrice;

  @Column(name = "propertyAddress")
  private String propertyAddress;

  @Column(name = "propertyPostalCode")
  private String propertyPostalCode;

  @Column(name = "propertyDistrict")
  private String propertyDistrict;

  @Column(name = "propertyCounty")
  private String propertyCounty;

  @Column(name = "landType")
  private LandType landType;

  @Column(name = "totalLandArea")
  private BigDecimal totalLandArea;

  @Column(name = "minimumSurfaceForSale")
  private BigDecimal minimumSurfaceForSale;

  @Column(name = "buildableArea")
  private BigDecimal buildableArea;

  @Column(name = "buildableFloors")
  private Long buildableFloors;

  @Column(name = "accessByRoad")
  private Boolean accessByRoad;

  @Column(name = "installedEquipment")
  private String installedEquipment;

  @Column(name = "viableConstructionTypes")
  private List<ViableConstructionTypes> viableConstructionTypes;

  @Column(name = "additionalInformation")
  private String additionalInformation;

  @Column(name = "description")
  private String description;

  @Column(name = "photoReferences")
  private List<String> photoReferences;
}