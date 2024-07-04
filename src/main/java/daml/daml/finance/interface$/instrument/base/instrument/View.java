package daml.daml.finance.interface$.instrument.base.instrument;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Timestamp;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.daml.finance.interface$.types.common.types.HoldingStandard;
import daml.daml.finance.interface$.types.common.types.Id;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class View extends DamlRecord<View> {
  public static final String _packageId = "0337d95cbc03800a2dea97d4d6edad768f08b69e119abf4729f77705965e0f58";

  public final String issuer;

  public final String depository;

  public final Id id;

  public final String version;

  public final HoldingStandard holdingStandard;

  public final String description;

  public final Instant validAsOf;

  public View(String issuer, String depository, Id id, String version,
      HoldingStandard holdingStandard, String description, Instant validAsOf) {
    this.issuer = issuer;
    this.depository = depository;
    this.id = id;
    this.version = version;
    this.holdingStandard = holdingStandard;
    this.description = description;
    this.validAsOf = validAsOf;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static View fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<View> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(7,0,
          recordValue$);
      String issuer = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String depository = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(2).getValue());
      String version = PrimitiveValueDecoders.fromText.decode(fields$.get(3).getValue());
      HoldingStandard holdingStandard = HoldingStandard.valueDecoder()
          .decode(fields$.get(4).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(5).getValue());
      Instant validAsOf = PrimitiveValueDecoders.fromTimestamp.decode(fields$.get(6).getValue());
      return new View(issuer, depository, id, version, holdingStandard, description, validAsOf);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(7);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("issuer", new Party(this.issuer)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("depository", new Party(this.depository)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("version", new Text(this.version)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("holdingStandard", this.holdingStandard.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("validAsOf", Timestamp.fromInstant(this.validAsOf)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("issuer", "depository", "id", "version", "holdingStandard", "description", "validAsOf"), name -> {
          switch (name) {
            case "issuer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "depository": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            case "version": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "holdingStandard": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.HoldingStandard.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "validAsOf": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp);
            default: return null;
          }
        }
        , (Object[] args) -> new View(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6])));
  }

  public static View fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("issuer", apply(JsonLfEncoders::party, issuer)),
        JsonLfEncoders.Field.of("depository", apply(JsonLfEncoders::party, depository)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)),
        JsonLfEncoders.Field.of("version", apply(JsonLfEncoders::text, version)),
        JsonLfEncoders.Field.of("holdingStandard", apply(HoldingStandard::jsonEncoder, holdingStandard)),
        JsonLfEncoders.Field.of("description", apply(JsonLfEncoders::text, description)),
        JsonLfEncoders.Field.of("validAsOf", apply(JsonLfEncoders::timestamp, validAsOf)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof View)) {
      return false;
    }
    View other = (View) object;
    return Objects.equals(this.issuer, other.issuer) &&
        Objects.equals(this.depository, other.depository) && Objects.equals(this.id, other.id) &&
        Objects.equals(this.version, other.version) &&
        Objects.equals(this.holdingStandard, other.holdingStandard) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.validAsOf, other.validAsOf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.issuer, this.depository, this.id, this.version, this.holdingStandard,
        this.description, this.validAsOf);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.instrument.base.instrument.View(%s, %s, %s, %s, %s, %s, %s)",
        this.issuer, this.depository, this.id, this.version, this.holdingStandard, this.description,
        this.validAsOf);
  }
}
