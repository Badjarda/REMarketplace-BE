package business.operator.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestCreateApartmentDTO {
  private String partyId;
  private String owner;
  private String propertyId;
  private String propertyType;
  private BigDecimal apartmentPrice;
  private String propertyAddress;
  private String propertyPostalCode;
  private String propertyDistrict;
  private String propertyCounty;
  private BigDecimal grossArea;
  private BigDecimal usableArea;
  private Long bedrooms;
  private Long bathrooms;
  private Long floor;
  private Long parkingSpaces;
  private Boolean elevator;
  private LocalDate buildDate;
  private String installedEquipment;
  private String additionalInformation;
  private String description;
  private List<String> photoReferences;
}

