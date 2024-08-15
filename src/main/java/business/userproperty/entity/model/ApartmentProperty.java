package business.userproperty.entity.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
public class ApartmentProperty {
  @Id
  private String partyId;

  @Column(name = "contractId")
  private String contractId;

  @Column(name = "propertyId")
  private String propertyId;

  @Column(name = "apartmentPrice")
  private BigDecimal apartmentPrice;

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

  @Column(name = "floor")
  private Long floor;

  @Column(name = "parkingSpaces")
  private Long parkingSpaces;

  @Column(name = "elevator")
  private Boolean elevator;

  @Column(name = "buildDate")
  private LocalDate buildDate;

  @Column(name = "installedEquipment")
  private String installedEquipment;

  @Column(name = "additionalInformation")
  private String additionalInformation;

  @Column(name = "description")
  private String description;

  @Column(name = "photoReferences")
  private List<String> photoReferences;
}
