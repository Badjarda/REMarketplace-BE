package daml.interface$.propertymanager.property.common;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlEnum;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum GarageType implements DamlEnum<GarageType> {
  ISOLATEDPRIVATE,

  PARKINGSPACE,

  CONDOMINIUMPRIVATE;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("IsolatedPrivate"), new com.daml.ledger.javaapi.data.DamlEnum("ParkingSpace"), new com.daml.ledger.javaapi.data.DamlEnum("CondominiumPrivate")};

  private static final Map<String, GarageType> __enums$ = __buildEnumsMap$();

  private static final Map<String, GarageType> __buildEnumsMap$() {
    Map<String, GarageType> m = new HashMap<String, GarageType>();
    m.put("IsolatedPrivate", ISOLATEDPRIVATE);
    m.put("ParkingSpace", PARKINGSPACE);
    m.put("CondominiumPrivate", CONDOMINIUMPRIVATE);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final GarageType fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<GarageType> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum GarageType")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with GarageType constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<GarageType> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static GarageType fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((GarageType e$) -> e$.getConstructor()).apply(this);
  }
}
