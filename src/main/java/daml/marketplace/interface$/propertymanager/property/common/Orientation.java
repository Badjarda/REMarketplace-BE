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

public enum Orientation implements DamlEnum<Orientation> {
  EAST,

  WEST,

  SOUTH,

  NORTH;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("East"), new com.daml.ledger.javaapi.data.DamlEnum("West"), new com.daml.ledger.javaapi.data.DamlEnum("South"), new com.daml.ledger.javaapi.data.DamlEnum("North")};

  private static final Map<String, Orientation> __enums$ = __buildEnumsMap$();

  private static final Map<String, Orientation> __buildEnumsMap$() {
    Map<String, Orientation> m = new HashMap<String, Orientation>();
    m.put("East", EAST);
    m.put("West", WEST);
    m.put("South", SOUTH);
    m.put("North", NORTH);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final Orientation fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<Orientation> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum Orientation")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with Orientation constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<Orientation> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static Orientation fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((Orientation e$) -> e$.getConstructor()).apply(this);
  }
}
