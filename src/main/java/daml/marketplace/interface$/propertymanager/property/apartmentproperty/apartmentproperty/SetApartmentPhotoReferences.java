package daml.interface$.propertymanager.property.apartmentproperty.apartmentproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
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

public class SetApartmentPhotoReferences extends DamlRecord<SetApartmentPhotoReferences> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final List<String> newPhotoReferences;

  public SetApartmentPhotoReferences(List<String> newPhotoReferences) {
    this.newPhotoReferences = newPhotoReferences;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetApartmentPhotoReferences fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetApartmentPhotoReferences> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      List<String> newPhotoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(0).getValue());
      return new SetApartmentPhotoReferences(newPhotoReferences);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newPhotoReferences", this.newPhotoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetApartmentPhotoReferences> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newPhotoReferences"), name -> {
          switch (name) {
            case "newPhotoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            default: return null;
          }
        }
        , (Object[] args) -> new SetApartmentPhotoReferences(JsonLfDecoders.cast(args[0])));
  }

  public static SetApartmentPhotoReferences fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newPhotoReferences", apply(JsonLfEncoders.list(JsonLfEncoders::text), newPhotoReferences)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetApartmentPhotoReferences)) {
      return false;
    }
    SetApartmentPhotoReferences other = (SetApartmentPhotoReferences) object;
    return Objects.equals(this.newPhotoReferences, other.newPhotoReferences);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newPhotoReferences);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.apartmentproperty.apartmentproperty.SetApartmentPhotoReferences(%s)",
        this.newPhotoReferences);
  }
}
