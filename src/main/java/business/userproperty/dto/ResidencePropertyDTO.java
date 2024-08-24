package business.userproperty.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import daml.marketplace.interface$.propertymanager.property.common.Orientation;
import daml.marketplace.interface$.propertymanager.property.common.Parking;
import daml.marketplace.interface$.propertymanager.property.common.ResidenceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResidencePropertyDTO {
    private final String user;
    private final String propertyId;
    private final BigDecimal residencePrice;
    private final String propertyAddress;
    private final String propertyPostalCode;
    private final String propertyDistrict;
    private final String propertyCounty;
    private final BigDecimal grossArea;
    private final BigDecimal usableArea;
    private final Long bedrooms;
    private final Long bathrooms;
    private final Long floors;
    private final ResidenceType residenceType;
    private final String backyard;
    private final Parking parking;
    private final LocalDate buildDate;
    private final Orientation orientation;
    private final String installedEquipment;
    private final String additionalInformation;
    private final String description;
    private final List<String> photoReferences;

    @JsonCreator
    public ResidencePropertyDTO(
        @JsonProperty("user") String user,
        @JsonProperty("propertyId") String propertyId,
        @JsonProperty("residencePrice") BigDecimal residencePrice,
        @JsonProperty("propertyAddress") String propertyAddress,
        @JsonProperty("propertyPostalCode") String propertyPostalCode,
        @JsonProperty("propertyDistrict") String propertyDistrict,
        @JsonProperty("propertyCounty") String propertyCounty,
        @JsonProperty("grossArea") BigDecimal grossArea,
        @JsonProperty("usableArea") BigDecimal usableArea,
        @JsonProperty("bedrooms") Long bedrooms,
        @JsonProperty("bathrooms") Long bathrooms,
        @JsonProperty("floors") Long floors,
        @JsonProperty("residenceType") ResidenceType residenceType,
        @JsonProperty("backyard") String backyard,
        @JsonProperty("parking") Parking parking,
        @JsonProperty("buildDate") LocalDate buildDate,
        @JsonProperty("orientation") Orientation orientation,
        @JsonProperty("installedEquipment") String installedEquipment,
        @JsonProperty("additionalInformation") String additionalInformation,
        @JsonProperty("description") String description,
        @JsonProperty("photoReferences") List<String> photoReferences
    ) {
        this.user = user;
        this.propertyId = propertyId;
        this.residencePrice = residencePrice;
        this.propertyAddress = propertyAddress;
        this.propertyPostalCode = propertyPostalCode;
        this.propertyDistrict = propertyDistrict;
        this.propertyCounty = propertyCounty;
        this.grossArea = grossArea;
        this.usableArea = usableArea;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.floors = floors;
        this.residenceType = residenceType;
        this.backyard = backyard;
        this.parking = parking;
        this.buildDate = buildDate;
        this.orientation = orientation;
        this.installedEquipment = installedEquipment;
        this.additionalInformation = additionalInformation;
        this.description = description;
        this.photoReferences = photoReferences;
    }
}
