package daml.interface$.profilemanager.userprofile.common;

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

public enum Gender implements DamlEnum<Gender> {
  MALE,

  FEMALE;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("Male"), new com.daml.ledger.javaapi.data.DamlEnum("Female")};

  private static final Map<String, Gender> __enums$ = __buildEnumsMap$();

  private static final Map<String, Gender> __buildEnumsMap$() {
    Map<String, Gender> m = new HashMap<String, Gender>();
    m.put("Male", MALE);
    m.put("Female", FEMALE);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final Gender fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<Gender> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum Gender")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with Gender constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<Gender> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static Gender fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((Gender e$) -> e$.getConstructor()).apply(this);
  }
}
