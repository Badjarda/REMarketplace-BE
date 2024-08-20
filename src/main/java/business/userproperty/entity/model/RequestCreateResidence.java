package business.userproperty.entity.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import daml.marketplace.interface$.propertymanager.property.common.Orientation;
import daml.marketplace.interface$.propertymanager.property.common.Parking;
import daml.marketplace.interface$.propertymanager.property.common.ResidenceType;

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
public class RequestCreateResidence {
    @Id
  private String partyId;

  @Column(name = "contractId")
  private String contractId;

  @Column(name = "propertyId")
  private String propertyId;

  @Column(name = "residencePrice")
  private BigDecimal residencePrice;

  @Column(name = "propertyAddress")
  private String propertyAddress;

  @Column(name = "propertyPostalCode")
  private String propertyPostalCode;

  @Column(name = "propertyDistrict")
  private String propertyDistrict;

  @Column(name = "propertyCounty")
  private String propertyCounty;

  @Column(name = "grossArea")
  private BigDecimal grossArea;

  @Column(name = "usableArea")
  private BigDecimal usableArea;

  @Column(name = "bedrooms")
  private Long bedrooms;

  @Column(name = "bathrooms")
  private Long bathrooms;

  @Column(name = "floors")
  private Long floors;

  @Column(name = "residenceType")
  private ResidenceType residenceType;

  @Column(name = "backyard")
  private String backyard;

  @Column(name = "parking")
  private Parking parking;

  @Column(name = "buildDate")
  private LocalDate buildDate;

  @Column(name = "orientation")
  private Orientation orientation;

  @Column(name = "installedEquipment")
  private String installedEquipment;

  @Column(name = "additionalInformation")
  private String additionalInformation;

  @Column(name = "description")
  private String description;

  @Column(name = "photoReferences")
  private List<String> photoReferences;
}
