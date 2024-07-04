package daml.daml.finance.interface$.instrument.token.types;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
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

public class Token extends DamlRecord<Token> {
  public static final String _packageId = "ed0ddc9629bb602042cfa07ad9cab51df97016b81309db004c9d25ea8d6fbc9d";

  public final InstrumentKey instrument;

  public final String description;

  public final Instant validAsOf;

  public Token(InstrumentKey instrument, String description, Instant validAsOf) {
    this.instrument = instrument;
    this.description = description;
    this.validAsOf = validAsOf;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Token fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Token> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      InstrumentKey instrument = InstrumentKey.valueDecoder().decode(fields$.get(0).getValue());
      String description = PrimitiveValueDecoders.fromText.decode(fields$.get(1).getValue());
      Instant validAsOf = PrimitiveValueDecoders.fromTimestamp.decode(fields$.get(2).getValue());
      return new Token(instrument, description, validAsOf);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("instrument", this.instrument.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("description", new Text(this.description)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("validAsOf", Timestamp.fromInstant(this.validAsOf)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Token> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("instrument", "description", "validAsOf"), name -> {
          switch (name) {
            case "instrument": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            case "description": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "validAsOf": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.timestamp);
            default: return null;
          }
        }
        , (Object[] args) -> new Token(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static Token fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("instrument", apply(InstrumentKey::jsonEncoder, instrument)),
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
    if (!(object instanceof Token)) {
      return false;
    }
    Token other = (Token) object;
    return Objects.equals(this.instrument, other.instrument) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.validAsOf, other.validAsOf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.instrument, this.description, this.validAsOf);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.instrument.token.types.Token(%s, %s, %s)",
        this.instrument, this.description, this.validAsOf);
  }
}
