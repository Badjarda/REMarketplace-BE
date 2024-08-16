package apiconfiguration;

import java.util.HashMap;
import java.util.Map;

import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import daml.marketplace.interface$.profilemanager.userprofile.common.Nationality;

public class UserProfileHelper {

    // Gender map for converting string to enum
    private static final Map<String, Gender> genderMap = new HashMap<>();

    static {
        for (Gender gender : Gender.values()) {
            genderMap.put(gender.name().toLowerCase(), gender);
        }
    }

    // Static method to convert string to Gender enum
    public static Gender genderFromString(String genderStr) {
        return genderMap.getOrDefault(genderStr.toLowerCase(), null);
    }

    // Nationality map for converting string to enum
    private static final Map<String, Nationality> nationalityMap = new HashMap<>();

    static {
        for (Nationality nationality : Nationality.values()) {
            nationalityMap.put(nationality.name().toLowerCase(), nationality);
        }
    }

    // Static method to convert string to Nationality enum
    public static Nationality nationalityFromString(String nationalityStr) {
        return nationalityMap.getOrDefault(nationalityStr.toLowerCase(), null);
    }
}
