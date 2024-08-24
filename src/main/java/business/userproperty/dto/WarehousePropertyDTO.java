package business.userproperty.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import daml.marketplace.interface$.propertymanager.property.common.WarehouseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehousePropertyDTO {
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

    @JsonCreator
    public WarehousePropertyDTO(
        @JsonProperty("user") String user,
        @JsonProperty("propertyId") String propertyId,
        @JsonProperty("warehousePrice") BigDecimal warehousePrice,
        @JsonProperty("propertyAddress") String propertyAddress,
        @JsonProperty("propertyPostalCode") String propertyPostalCode,
        @JsonProperty("propertyDistrict") String propertyDistrict,
        @JsonProperty("propertyCounty") String propertyCounty,
        @JsonProperty("warehouseType") WarehouseType warehouseType,
        @JsonProperty("grossArea") BigDecimal grossArea,
        @JsonProperty("usableArea") BigDecimal usableArea,
        @JsonProperty("floors") Long floors,
        @JsonProperty("buildDate") LocalDate buildDate,
        @JsonProperty("installedEquipment") String installedEquipment,
        @JsonProperty("additionalInformation") String additionalInformation,
        @JsonProperty("description") String description,
        @JsonProperty("photoReferences") List<String> photoReferences
    ) {
        this.user = user;
        this.propertyId = propertyId;
        this.warehousePrice = warehousePrice;
        this.propertyAddress = propertyAddress;
        this.propertyPostalCode = propertyPostalCode;
        this.propertyDistrict = propertyDistrict;
        this.propertyCounty = propertyCounty;
        this.warehouseType = warehouseType;
        this.grossArea = grossArea;
        this.usableArea = usableArea;
        this.floors = floors;
        this.buildDate = buildDate;
        this.installedEquipment = installedEquipment;
        this.additionalInformation = additionalInformation;
        this.description = description;
        this.photoReferences = photoReferences;
    }
}
