package daml.daml.finance.interface$.types.common.types;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HoldingFactoryKey extends DamlRecord<HoldingFactoryKey> {
  public static final String _packageId = "6ea0a5ef5513821304e7830999cbeedb0867b1bd7bc826f0efee61d5d53aa6a6";

  public final String provider;

  public final Id id;

  public HoldingFactoryKey(String provider, Id id) {
    this.provider = provider;
    this.id = id;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static HoldingFactoryKey fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<HoldingFactoryKey> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String provider = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(1).getValue());
      return new HoldingFactoryKey(provider, id);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("provider", new Party(this.provider)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<HoldingFactoryKey> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("provider", "id"), name -> {
          switch (name) {
            case "provider": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new HoldingFactoryKey(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static HoldingFactoryKey fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("provider", apply(JsonLfEncoders::party, provider)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof HoldingFactoryKey)) {
      return false;
    }
    HoldingFactoryKey other = (HoldingFactoryKey) object;
    return Objects.equals(this.provider, other.provider) && Objects.equals(this.id, other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.provider, this.id);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.types.common.types.HoldingFactoryKey(%s, %s)",
        this.provider, this.id);
  }
}
