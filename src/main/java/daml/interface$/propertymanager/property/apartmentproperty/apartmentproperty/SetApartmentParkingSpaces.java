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

public class SetApartmentParkingSpaces extends DamlRecord<SetApartmentParkingSpaces> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final Long newApartmentParkingSpaces;

  public SetApartmentParkingSpaces(Long newApartmentParkingSpaces) {
    this.newApartmentParkingSpaces = newApartmentParkingSpaces;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetApartmentParkingSpaces fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetApartmentParkingSpaces> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Long newApartmentParkingSpaces = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(0).getValue());
      return new SetApartmentParkingSpaces(newApartmentParkingSpaces);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentParkingSpaces", new Int64(this.newApartmentParkingSpaces)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetApartmentParkingSpaces> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newApartmentParkingSpaces"), name -> {
          switch (name) {
            case "newApartmentParkingSpaces": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            default: return null;
          }
        }
        , (Object[] args) -> new SetApartmentParkingSpaces(JsonLfDecoders.cast(args[0])));
  }

  public static SetApartmentParkingSpaces fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newApartmentParkingSpaces", apply(JsonLfEncoders::int64, newApartmentParkingSpaces)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetApartmentParkingSpaces)) {
      return false;
    }
    SetApartmentParkingSpaces other = (SetApartmentParkingSpaces) object;
    return Objects.equals(this.newApartmentParkingSpaces, other.newApartmentParkingSpaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newApartmentParkingSpaces);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.apartmentproperty.apartmentproperty.SetApartmentParkingSpaces(%s)",
        this.newApartmentParkingSpaces);
  }
}
