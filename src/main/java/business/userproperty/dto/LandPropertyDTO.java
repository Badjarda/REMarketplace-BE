package business.userproperty.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;
import daml.marketplace.interface$.propertymanager.property.common.LandType;
import daml.marketplace.interface$.propertymanager.property.common.ViableConstructionTypes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandPropertyDTO {
    private final String user;
    private final String propertyId;
    private final BigDecimal landPrice;
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

    @JsonCreator
    public LandPropertyDTO(
        @JsonProperty("user") String user,
        @JsonProperty("propertyId") String propertyId,
        @JsonProperty("landPrice") BigDecimal landPrice,
        @JsonProperty("propertyAddress") String propertyAddress,
        @JsonProperty("propertyPostalCode") String propertyPostalCode,
        @JsonProperty("propertyDistrict") String propertyDistrict,
        @JsonProperty("propertyCounty") String propertyCounty,
        @JsonProperty("landType") LandType landType,
        @JsonProperty("totalLandArea") BigDecimal totalLandArea,
        @JsonProperty("minimumSurfaceForSale") BigDecimal minimumSurfaceForSale,
        @JsonProperty("buildableArea") BigDecimal buildableArea,
        @JsonProperty("buildableFloors") Long buildableFloors,
        @JsonProperty("accessByRoad") Boolean accessByRoad,
        @JsonProperty("installedEquipment") String installedEquipment,
        @JsonProperty("viableConstructionTypes") List<ViableConstructionTypes> viableConstructionTypes,
        @JsonProperty("additionalInformation") String additionalInformation,
        @JsonProperty("description") String description,
        @JsonProperty("photoReferences") List<String> photoReferences
    ) {
        this.user = user;
        this.propertyId = propertyId;
        this.landPrice = landPrice;
        this.propertyAddress = propertyAddress;
        this.propertyPostalCode = propertyPostalCode;
        this.propertyDistrict = propertyDistrict;
        this.propertyCounty = propertyCounty;
        this.landType = landType;
        this.totalLandArea = totalLandArea;
        this.minimumSurfaceForSale = minimumSurfaceForSale;
        this.buildableArea = buildableArea;
        this.buildableFloors = buildableFloors;
        this.accessByRoad = accessByRoad;
        this.installedEquipment = installedEquipment;
        this.viableConstructionTypes = viableConstructionTypes;
        this.additionalInformation = additionalInformation;
        this.description = description;
        this.photoReferences = photoReferences;
    }
}
