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

public enum ResidenceType implements DamlEnum<ResidenceType> {
  DETACHED,

  TOWNHOUSE,

  CORNERLOT;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("Detached"), new com.daml.ledger.javaapi.data.DamlEnum("Townhouse"), new com.daml.ledger.javaapi.data.DamlEnum("CornerLot")};

  private static final Map<String, ResidenceType> __enums$ = __buildEnumsMap$();

  private static final Map<String, ResidenceType> __buildEnumsMap$() {
    Map<String, ResidenceType> m = new HashMap<String, ResidenceType>();
    m.put("Detached", DETACHED);
    m.put("Townhouse", TOWNHOUSE);
    m.put("CornerLot", CORNERLOT);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final ResidenceType fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<ResidenceType> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum ResidenceType")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with ResidenceType constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<ResidenceType> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static ResidenceType fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((ResidenceType e$) -> e$.getConstructor()).apply(this);
  }
}
