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

public enum Parking implements DamlEnum<Parking> {
  COVERED,

  STREET,

  PRIVATEGARAGE;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("Covered"), new com.daml.ledger.javaapi.data.DamlEnum("Street"), new com.daml.ledger.javaapi.data.DamlEnum("PrivateGarage")};

  private static final Map<String, Parking> __enums$ = __buildEnumsMap$();

  private static final Map<String, Parking> __buildEnumsMap$() {
    Map<String, Parking> m = new HashMap<String, Parking>();
    m.put("Covered", COVERED);
    m.put("Street", STREET);
    m.put("PrivateGarage", PRIVATEGARAGE);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final Parking fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<Parking> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum Parking")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with Parking constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<Parking> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static Parking fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((Parking e$) -> e$.getConstructor()).apply(this);
  }
}
