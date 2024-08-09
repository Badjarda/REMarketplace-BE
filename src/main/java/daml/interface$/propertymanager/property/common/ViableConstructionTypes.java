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

public enum ViableConstructionTypes implements DamlEnum<ViableConstructionTypes> {
  RUSTICSTRUCTURE,

  PUBLICINFRASTRUCTURE,

  RESIDENCE,

  BUILDING,

  WAREHOUSE;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("RusticStructure"), new com.daml.ledger.javaapi.data.DamlEnum("PublicInfrastructure"), new com.daml.ledger.javaapi.data.DamlEnum("Residence"), new com.daml.ledger.javaapi.data.DamlEnum("Building"), new com.daml.ledger.javaapi.data.DamlEnum("Warehouse")};

  private static final Map<String, ViableConstructionTypes> __enums$ = __buildEnumsMap$();

  private static final Map<String, ViableConstructionTypes> __buildEnumsMap$() {
    Map<String, ViableConstructionTypes> m = new HashMap<String, ViableConstructionTypes>();
    m.put("RusticStructure", RUSTICSTRUCTURE);
    m.put("PublicInfrastructure", PUBLICINFRASTRUCTURE);
    m.put("Residence", RESIDENCE);
    m.put("Building", BUILDING);
    m.put("Warehouse", WAREHOUSE);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final ViableConstructionTypes fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<ViableConstructionTypes> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum ViableConstructionTypes")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with ViableConstructionTypes constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<ViableConstructionTypes> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static ViableConstructionTypes fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((ViableConstructionTypes e$) -> e$.getConstructor()).apply(this);
  }
}
