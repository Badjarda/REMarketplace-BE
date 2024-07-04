package daml.daml.finance.interface$.util.lockable;

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

public enum LockType implements DamlEnum<LockType> {
  SEMAPHORE,

  REENTRANT;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("Semaphore"), new com.daml.ledger.javaapi.data.DamlEnum("Reentrant")};

  private static final Map<String, LockType> __enums$ = __buildEnumsMap$();

  private static final Map<String, LockType> __buildEnumsMap$() {
    Map<String, LockType> m = new HashMap<String, LockType>();
    m.put("Semaphore", SEMAPHORE);
    m.put("Reentrant", REENTRANT);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final LockType fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<LockType> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum LockType")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with LockType constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<LockType> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static LockType fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((LockType e$) -> e$.getConstructor()).apply(this);
  }
}
