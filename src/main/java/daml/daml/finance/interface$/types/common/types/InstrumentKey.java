package daml.daml.finance.interface$.types.common.types;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Text;
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

public class InstrumentKey extends DamlRecord<InstrumentKey> {
  public static final String _packageId = "6ea0a5ef5513821304e7830999cbeedb0867b1bd7bc826f0efee61d5d53aa6a6";

  public final String depository;

  public final String issuer;

  public final Id id;

  public final String version;

  public final HoldingStandard holdingStandard;

  public InstrumentKey(String depository, String issuer, Id id, String version,
      HoldingStandard holdingStandard) {
    this.depository = depository;
    this.issuer = issuer;
    this.id = id;
    this.version = version;
    this.holdingStandard = holdingStandard;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static InstrumentKey fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<InstrumentKey> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0,
          recordValue$);
      String depository = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String issuer = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(2).getValue());
      String version = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      HoldingStandard holdingStandard = HoldingStandard.valueDecoder()
          .decode(fields$.get(4).getValue());
      return new InstrumentKey(depository, issuer, id, version, holdingStandard);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(5);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("depository", new Party(this.depository)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("issuer", new Party(this.issuer)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("version", new Text(this.version)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("holdingStandard", this.holdingStandard.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<InstrumentKey> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("depository", "issuer", "id", "version", "holdingStandard"), name -> {
          switch (name) {
            case "depository": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "issuer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "version": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "holdingStandard": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.HoldingStandard.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new InstrumentKey(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static InstrumentKey fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("depository", apply(JsonLfEncoders::party, depository)),
        JsonLfEncoders.Field.of("issuer", apply(JsonLfEncoders::party, issuer)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("version", apply(JsonLfEncoders::text, version)),
        JsonLfEncoders.Field.of("holdingStandard", apply(HoldingStandard::jsonEncoder, holdingStandard)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof InstrumentKey)) {
      return false;
    }
    InstrumentKey other = (InstrumentKey) object;
    return Objects.equals(this.depository, other.depository) &&
        Objects.equals(this.issuer, other.issuer) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.version, other.version) &&
        Objects.equals(this.holdingStandard, other.holdingStandard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.depository, this.issuer, this.id, this.version, this.holdingStandard);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.types.common.types.InstrumentKey(%s, %s, %s, %s, %s)",
        this.depository, this.issuer, this.id, this.version, this.holdingStandard);
  }
}
