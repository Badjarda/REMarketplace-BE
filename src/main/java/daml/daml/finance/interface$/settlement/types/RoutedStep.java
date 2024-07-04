package daml.daml.finance.interface$.settlement.types;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Numeric;
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
import daml.daml.finance.interface$.types.common.types.InstrumentKey;
import daml.daml.finance.interface$.types.common.types.Quantity;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RoutedStep extends DamlRecord<RoutedStep> {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public final String sender;

  public final String receiver;

  public final String custodian;

  public final Quantity<InstrumentKey, BigDecimal> quantity;

  public RoutedStep(String sender, String receiver, String custodian,
      Quantity<InstrumentKey, BigDecimal> quantity) {
    this.sender = sender;
    this.receiver = receiver;
    this.custodian = custodian;
    this.quantity = quantity;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static RoutedStep fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RoutedStep> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0,
          recordValue$);
      String sender = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String receiver = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      String custodian = PrimitiveValueDecoders.fromParty.decode(fields$.get(2).getValue());
      Quantity<InstrumentKey, BigDecimal> quantity =
          Quantity.<daml.daml.finance.interface$.types.common.types.InstrumentKey,
          java.math.BigDecimal>valueDecoder(InstrumentKey.valueDecoder(),
          PrimitiveValueDecoders.fromNumeric).decode(fields$.get(3).getValue());
      return new RoutedStep(sender, receiver, custodian, quantity);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(4);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("sender", new Party(this.sender)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("receiver", new Party(this.receiver)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("custodian", new Party(this.custodian)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("quantity", this.quantity.toValue(v$0 -> v$0.toValue(),
        v$1 -> new Numeric(v$1))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RoutedStep> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("sender", "receiver", "custodian", "quantity"), name -> {
          switch (name) {
            case "sender": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "receiver": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "custodian": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "quantity": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.Quantity.jsonDecoder(daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder(), com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10)));
            default: return null;
          }
        }
        , (Object[] args) -> new RoutedStep(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static RoutedStep fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("sender", apply(JsonLfEncoders::party, sender)),
        JsonLfEncoders.Field.of("receiver", apply(JsonLfEncoders::party, receiver)),
        JsonLfEncoders.Field.of("custodian", apply(JsonLfEncoders::party, custodian)),
        JsonLfEncoders.Field.of("quantity", apply(_x0 -> _x0.jsonEncoder(InstrumentKey::jsonEncoder, JsonLfEncoders::numeric), quantity)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof RoutedStep)) {
      return false;
    }
    RoutedStep other = (RoutedStep) object;
    return Objects.equals(this.sender, other.sender) &&
        Objects.equals(this.receiver, other.receiver) &&
        Objects.equals(this.custodian, other.custodian) &&
        Objects.equals(this.quantity, other.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.sender, this.receiver, this.custodian, this.quantity);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.settlement.types.RoutedStep(%s, %s, %s, %s)",
        this.sender, this.receiver, this.custodian, this.quantity);
  }
}
