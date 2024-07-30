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

public enum LandType implements DamlEnum<LandType> {
  URBAN,

  URBANIZABLE,

  RUSTIC;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("Urban"), new com.daml.ledger.javaapi.data.DamlEnum("Urbanizable"), new com.daml.ledger.javaapi.data.DamlEnum("Rustic")};

  private static final Map<String, LandType> __enums$ = __buildEnumsMap$();

  private static final Map<String, LandType> __buildEnumsMap$() {
    Map<String, LandType> m = new HashMap<String, LandType>();
    m.put("Urban", URBAN);
    m.put("Urbanizable", URBANIZABLE);
    m.put("Rustic", RUSTIC);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final LandType fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<LandType> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum LandType")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with LandType constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<LandType> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static LandType fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((LandType e$) -> e$.getConstructor()).apply(this);
  }
}
