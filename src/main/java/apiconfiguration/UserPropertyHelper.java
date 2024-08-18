package apiconfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import daml.marketplace.interface$.propertymanager.property.common.GarageType;
import daml.marketplace.interface$.propertymanager.property.common.LandType;
import daml.marketplace.interface$.propertymanager.property.common.WarehouseType;
import daml.marketplace.interface$.propertymanager.property.common.ResidenceType;
import daml.marketplace.interface$.propertymanager.property.common.ViableConstructionTypes;
import daml.marketplace.interface$.propertymanager.property.common.Parking;
import daml.marketplace.interface$.propertymanager.property.common.Orientation;

public class UserPropertyHelper {

    // Map for converting string to GarageType enum
    private static final Map<String, GarageType> garageTypeMap = new HashMap<>();

    static {
        for (GarageType garageType : GarageType.values()) {
            garageTypeMap.put(garageType.name().toLowerCase(), garageType);
        }
    }

    // Static method to convert string to GarageType enum
    public static GarageType garageTypeFromString(String garageTypeStr) {
        return garageTypeMap.getOrDefault(garageTypeStr.toLowerCase(), null);
    }

    //----------------------------------------------------------------------------------

    // Map for converting string to LandType enum
    private static final Map<String, LandType> landTypeMap = new HashMap<>();

    static {
        for (LandType landType : LandType.values()) {
            landTypeMap.put(landType.name().toLowerCase(), landType);
        }
    }

    // Static method to convert string to LandType enum
    public static LandType landTypeFromString(String landTypeStr) {
        return landTypeMap.getOrDefault(landTypeStr.toLowerCase(), null);
    }

    //----------------------------------------------------------------------------------

    // Map for converting string to ResidenceType enum
    private static final Map<String, ResidenceType> residenceTypeMap = new HashMap<>();

    static {
        for (ResidenceType residenceType : ResidenceType.values()) {
            residenceTypeMap.put(residenceType.name().toLowerCase(), residenceType);
        }
    }

    // Static method to convert string to ResidenceType enum
    public static ResidenceType residenceTypeFromString(String residenceTypeStr) {
        return residenceTypeMap.getOrDefault(residenceTypeStr.toLowerCase(), null);
    }

    //----------------------------------------------------------------------------------

    // Map for converting string to WarehouseType enum
    private static final Map<String, WarehouseType> warehouseTypeMap = new HashMap<>();

    static {
        for (WarehouseType warehouseType : WarehouseType.values()) {
            warehouseTypeMap.put(warehouseType.name().toLowerCase(), warehouseType);
        }
    }

    // Static method to convert string to WarehouseType enum
    public static WarehouseType warehouseTypeFromString(String warehouseTypeStr) {
        return warehouseTypeMap.getOrDefault(warehouseTypeStr.toLowerCase(), null);
    }

    //-------------------------------------------------------------------------------------------

    // Map for converting string to ViableConstructionTypes enum
    private static final Map<String, ViableConstructionTypes> viableConstructionTypesMap = new HashMap<>();

    static {
        for (ViableConstructionTypes type : ViableConstructionTypes.values()) {
            viableConstructionTypesMap.put(type.name().toLowerCase(), type);
        }
    }

    // Static method to convert a list of strings to a list of ViableConstructionTypes enums
    public static List<ViableConstructionTypes> viableConstructionTypesFromStrings(List<String> typesStrList) {
        List<ViableConstructionTypes> typesList = new ArrayList<>();
        for (String typeStr : typesStrList) {
            ViableConstructionTypes type = viableConstructionTypesMap.get(typeStr.toLowerCase());
            if (type != null) {
                typesList.add(type);
            }
        }
        return typesList;
    }

    //----------------------------------------------------------------------------------

    // Map for converting string to Parking enum
    private static final Map<String, Parking> parkingMap = new HashMap<>();

    static {
        for (Parking parking : Parking.values()) {
            parkingMap.put(parking.name().toLowerCase(), parking);
        }
    }

    // Static method to convert string to Parking enum
    public static Parking parkingFromString(String parkingStr) {
        return parkingMap.getOrDefault(parkingStr.toLowerCase(), null);
    }

    //----------------------------------------------------------------------------------

    // Map for converting string to Orientation enum
    private static final Map<String, Orientation> orientationMap = new HashMap<>();

    static {
        for (Orientation orientation : Orientation.values()) {
            orientationMap.put(orientation.name().toLowerCase(), orientation);
        }
    }

    // Static method to convert string to Orientation enum
    public static Orientation orientationFromString(String orientationStr) {
        return orientationMap.getOrDefault(orientationStr.toLowerCase(), null);
    }

}

