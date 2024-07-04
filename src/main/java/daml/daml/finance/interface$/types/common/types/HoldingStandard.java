package daml.daml.finance.interface$.types.common.types;

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

public enum HoldingStandard implements DamlEnum<HoldingStandard> {
  TRANSFERABLEFUNGIBLE,

  TRANSFERABLE,

  FUNGIBLE,

  BASEHOLDING;

  private static final com.daml.ledger.javaapi.data.DamlEnum[] __values$ = {new com.daml.ledger.javaapi.data.DamlEnum("TransferableFungible"), new com.daml.ledger.javaapi.data.DamlEnum("Transferable"), new com.daml.ledger.javaapi.data.DamlEnum("Fungible"), new com.daml.ledger.javaapi.data.DamlEnum("BaseHolding")};

  private static final Map<String, HoldingStandard> __enums$ = __buildEnumsMap$();

  private static final Map<String, HoldingStandard> __buildEnumsMap$() {
    Map<String, HoldingStandard> m = new HashMap<String, HoldingStandard>();
    m.put("TransferableFungible", TRANSFERABLEFUNGIBLE);
    m.put("Transferable", TRANSFERABLE);
    m.put("Fungible", FUNGIBLE);
    m.put("BaseHolding", BASEHOLDING);
    return m;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static final HoldingStandard fromValue(Value value$) {
    return valueDecoder().decode(value$);
  }

  public static final ValueDecoder<HoldingStandard> valueDecoder() {
    return value$ -> {
      String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum HoldingStandard")).getConstructor();
      if (!__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with HoldingStandard constructor, found " + constructor$);
      return __enums$.get(constructor$);
    } ;
  }

  public final com.daml.ledger.javaapi.data.DamlEnum toValue() {
    return __values$[ordinal()];
  }

  public static JsonLfDecoder<HoldingStandard> jsonDecoder() {
    return JsonLfDecoders.enumeration(__enums$);
  }

  public static HoldingStandard fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public String getConstructor() {
    return toValue().getConstructor();
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.enumeration((HoldingStandard e$) -> e$.getConstructor()).apply(this);
  }
}
