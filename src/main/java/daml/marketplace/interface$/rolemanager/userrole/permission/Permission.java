package daml.interface$.rolemanager.userrole.permission;

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

public enum Permission implements DamlEnum<Permission> {
  VIEW_ALL_MARKETPLACE_TRANSACTIONS,

  MANAGE_ALL_MARKETPLACE_TRANSACTIONS,

  VIEW_ROLE,

  MANAGE_ROLE,

  MANAGE_PERMISSION,

  VIEW_TRANSACTION,

  MANAGE_TRANSACTION;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("VIEW_ALL_MARKETPLACE_TRANSACTIONS"), new com.daml.ledger.javaapi.data.DamlEnum("MANAGE_ALL_MARKETPLACE_TRANSACTIONS"), new com.daml.ledger.javaapi.data.DamlEnum("VIEW_ROLE"), new com.daml.ledger.javaapi.data.DamlEnum("MANAGE_ROLE"), new com.daml.ledger.javaapi.data.DamlEnum("MANAGE_PERMISSION"), new com.daml.ledger.javaapi.data.DamlEnum("VIEW_TRANSACTION"), new com.daml.ledger.javaapi.data.DamlEnum("MANAGE_TRANSACTION")};

  private static final Map<String, Permission> __enums$ = __buildEnumsMap$();

  private static final Map<String, Permission> __buildEnumsMap$() {
    Map<String, Permission> m = new HashMap<String, Permission>();
    m.put("VIEW_ALL_MARKETPLACE_TRANSACTIONS", VIEW_ALL_MARKETPLACE_TRANSACTIONS);
    m.put("MANAGE_ALL_MARKETPLACE_TRANSACTIONS", MANAGE_ALL_MARKETPLACE_TRANSACTIONS);
    m.put("VIEW_ROLE", VIEW_ROLE);
    m.put("MANAGE_ROLE", MANAGE_ROLE);
    m.put("MANAGE_PERMISSION", MANAGE_PERMISSION);
    m.put("VIEW_TRANSACTION", VIEW_TRANSACTION);
    m.put("MANAGE_TRANSACTION", MANAGE_TRANSACTION);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final Permission fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<Permission> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum Permission")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with Permission constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<Permission> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static Permission fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((Permission e$) -> e$.getConstructor()).apply(this);
  }
}
