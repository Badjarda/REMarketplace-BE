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

public enum WarehouseType implements DamlEnum<WarehouseType> {
  ISOLATEDWAREHOUSE,

  BUILDINGWAREHOUSE,

  STORAGEROOM;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("IsolatedWarehouse"), new com.daml.ledger.javaapi.data.DamlEnum("BuildingWarehouse"), new com.daml.ledger.javaapi.data.DamlEnum("StorageRoom")};

  private static final Map<String, WarehouseType> __enums$ = __buildEnumsMap$();

  private static final Map<String, WarehouseType> __buildEnumsMap$() {
    Map<String, WarehouseType> m = new HashMap<String, WarehouseType>();
    m.put("IsolatedWarehouse", ISOLATEDWAREHOUSE);
    m.put("BuildingWarehouse", BUILDINGWAREHOUSE);
    m.put("StorageRoom", STORAGEROOM);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final WarehouseType fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<WarehouseType> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum WarehouseType")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with WarehouseType constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<WarehouseType> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static WarehouseType fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((WarehouseType e$) -> e$.getConstructor()).apply(this);
  }
}
