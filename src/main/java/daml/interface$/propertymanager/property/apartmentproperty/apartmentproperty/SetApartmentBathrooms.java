package daml.interface$.propertymanager.property.apartmentproperty.apartmentproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Int64;
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
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetApartmentBathrooms extends DamlRecord<SetApartmentBathrooms> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final Long newApartmentBathrooms;

  public SetApartmentBathrooms(Long newApartmentBathrooms) {
    this.newApartmentBathrooms = newApartmentBathrooms;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetApartmentBathrooms fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetApartmentBathrooms> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Long newApartmentBathrooms = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(0).getValue());
      return new SetApartmentBathrooms(newApartmentBathrooms);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentBathrooms", new Int64(this.newApartmentBathrooms)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetApartmentBathrooms> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newApartmentBathrooms"), name -> {
          switch (name) {
            case "newApartmentBathrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            default: return null;
          }
        }
        , (Object[] args) -> new SetApartmentBathrooms(JsonLfDecoders.cast(args[0])));
  }

  public static SetApartmentBathrooms fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newApartmentBathrooms", apply(JsonLfEncoders::int64, newApartmentBathrooms)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetApartmentBathrooms)) {
      return false;
    }
    SetApartmentBathrooms other = (SetApartmentBathrooms) object;
    return Objects.equals(this.newApartmentBathrooms, other.newApartmentBathrooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newApartmentBathrooms);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.apartmentproperty.apartmentproperty.SetApartmentBathrooms(%s)",
        this.newApartmentBathrooms);
  }
}
