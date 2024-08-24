package business.userproperty.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ApartmentPropertyDTO {

    private final String user;
    private final String propertyId;
    private final BigDecimal apartmentPrice;
    private final String propertyAddress;
    private final String propertyPostalCode;
    private final String propertyDistrict;
    private final String propertyCounty;
    private final BigDecimal grossArea;
    private final BigDecimal usableArea;
    private final Long bedrooms;
    private final Long bathrooms;
    private final Long floor;
    private final Long parkingSpaces;
    private final Boolean elevator;
    private final LocalDate buildDate;
    private final String installedEquipment;
    private final String additionalInformation;
    private final String description;
    private final List<String> photoReferences;

    @JsonCreator
    public ApartmentPropertyDTO(
        @JsonProperty("user") String user,
        @JsonProperty("propertyId") String propertyId,
        @JsonProperty("apartmentPrice") BigDecimal apartmentPrice,
        @JsonProperty("propertyAddress") String propertyAddress,
        @JsonProperty("propertyPostalCode") String propertyPostalCode,
        @JsonProperty("propertyDistrict") String propertyDistrict,
        @JsonProperty("propertyCounty") String propertyCounty,
        @JsonProperty("grossArea") BigDecimal grossArea,
        @JsonProperty("usableArea") BigDecimal usableArea,
        @JsonProperty("bedrooms") Long bedrooms,
        @JsonProperty("bathrooms") Long bathrooms,
        @JsonProperty("floor") Long floor,
        @JsonProperty("parkingSpaces") Long parkingSpaces,
        @JsonProperty("elevator") Boolean elevator,
        @JsonProperty("buildDate") LocalDate buildDate,
        @JsonProperty("installedEquipment") String installedEquipment,
        @JsonProperty("additionalInformation") String additionalInformation,
        @JsonProperty("description") String description,
        @JsonProperty("photoReferences") List<String> photoReferences
    ) {
        this.user = user;
        this.propertyId = propertyId;
        this.apartmentPrice = apartmentPrice;
        this.propertyAddress = propertyAddress;
        this.propertyPostalCode = propertyPostalCode;
        this.propertyDistrict = propertyDistrict;
        this.propertyCounty = propertyCounty;
        this.grossArea = grossArea;
        this.usableArea = usableArea;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.floor = floor;
        this.parkingSpaces = parkingSpaces;
        this.elevator = elevator;
        this.buildDate = buildDate;
        this.installedEquipment = installedEquipment;
        this.additionalInformation = additionalInformation;
        this.description = description;
        this.photoReferences = photoReferences;
    }
}
