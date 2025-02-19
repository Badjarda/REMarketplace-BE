package daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetApartmentInstrumentKey extends DamlRecord<SetApartmentInstrumentKey> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final InstrumentKey newApartmentInstrumentKey;

  public SetApartmentInstrumentKey(InstrumentKey newApartmentInstrumentKey) {
    this.newApartmentInstrumentKey = newApartmentInstrumentKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetApartmentInstrumentKey fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetApartmentInstrumentKey> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      InstrumentKey newApartmentInstrumentKey = InstrumentKey.valueDecoder()
          .decode(fields$.get(0).getValue());
      return new SetApartmentInstrumentKey(newApartmentInstrumentKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentInstrumentKey", this.newApartmentInstrumentKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetApartmentInstrumentKey> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newApartmentInstrumentKey"), name -> {
          switch (name) {
            case "newApartmentInstrumentKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.daml.finance.interface$.types.common.types.InstrumentKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new SetApartmentInstrumentKey(JsonLfDecoders.cast(args[0])));
  }

  public static SetApartmentInstrumentKey fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newApartmentInstrumentKey", apply(InstrumentKey::jsonEncoder, newApartmentInstrumentKey)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetApartmentInstrumentKey)) {
      return false;
    }
    SetApartmentInstrumentKey other = (SetApartmentInstrumentKey) object;
    return Objects.equals(this.newApartmentInstrumentKey, other.newApartmentInstrumentKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newApartmentInstrumentKey);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty.SetApartmentInstrumentKey(%s)",
        this.newApartmentInstrumentKey);
  }
}
