package daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Numeric;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetApartmentGrossArea extends DamlRecord<SetApartmentGrossArea> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final BigDecimal newApartmentGrossArea;

  public SetApartmentGrossArea(BigDecimal newApartmentGrossArea) {
    this.newApartmentGrossArea = newApartmentGrossArea;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetApartmentGrossArea fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetApartmentGrossArea> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      BigDecimal newApartmentGrossArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(0).getValue());
      return new SetApartmentGrossArea(newApartmentGrossArea);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentGrossArea", new Numeric(this.newApartmentGrossArea)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetApartmentGrossArea> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newApartmentGrossArea"), name -> {
          switch (name) {
            case "newApartmentGrossArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            default: return null;
          }
        }
        , (Object[] args) -> new SetApartmentGrossArea(JsonLfDecoders.cast(args[0])));
  }

  public static SetApartmentGrossArea fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newApartmentGrossArea", apply(JsonLfEncoders::numeric, newApartmentGrossArea)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetApartmentGrossArea)) {
      return false;
    }
    SetApartmentGrossArea other = (SetApartmentGrossArea) object;
    return Objects.equals(this.newApartmentGrossArea, other.newApartmentGrossArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newApartmentGrossArea);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.property.apartmentproperty.apartmentproperty.SetApartmentGrossArea(%s)",
        this.newApartmentGrossArea);
  }
}
