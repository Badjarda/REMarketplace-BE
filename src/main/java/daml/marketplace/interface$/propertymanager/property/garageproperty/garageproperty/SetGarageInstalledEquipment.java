package daml.interface$.propertymanager.property.garageproperty.garageproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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

public class SetGarageInstalledEquipment extends DamlRecord<SetGarageInstalledEquipment> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final String newGarageInstalledEquipment;

  public SetGarageInstalledEquipment(String newGarageInstalledEquipment) {
    this.newGarageInstalledEquipment = newGarageInstalledEquipment;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetGarageInstalledEquipment fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetGarageInstalledEquipment> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      String newGarageInstalledEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(0).getValue());
      return new SetGarageInstalledEquipment(newGarageInstalledEquipment);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGarageInstalledEquipment", new Text(this.newGarageInstalledEquipment)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetGarageInstalledEquipment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newGarageInstalledEquipment"), name -> {
          switch (name) {
            case "newGarageInstalledEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            default: return null;
          }
        }
        , (Object[] args) -> new SetGarageInstalledEquipment(JsonLfDecoders.cast(args[0])));
  }

  public static SetGarageInstalledEquipment fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newGarageInstalledEquipment", apply(JsonLfEncoders::text, newGarageInstalledEquipment)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetGarageInstalledEquipment)) {
      return false;
    }
    SetGarageInstalledEquipment other = (SetGarageInstalledEquipment) object;
    return Objects.equals(this.newGarageInstalledEquipment, other.newGarageInstalledEquipment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newGarageInstalledEquipment);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.garageproperty.garageproperty.SetGarageInstalledEquipment(%s)",
        this.newGarageInstalledEquipment);
  }
}
