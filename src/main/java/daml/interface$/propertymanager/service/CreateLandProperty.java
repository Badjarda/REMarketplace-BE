package daml.interface$.propertymanager.service;

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
import daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CreateLandProperty extends DamlRecord<CreateLandProperty> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final RequestCreateLandProperty.ContractId createLandPropertyRequest;

  public CreateLandProperty(RequestCreateLandProperty.ContractId createLandPropertyRequest) {
    this.createLandPropertyRequest = createLandPropertyRequest;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CreateLandProperty fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<CreateLandProperty> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      RequestCreateLandProperty.ContractId createLandPropertyRequest =
          new RequestCreateLandProperty.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected createLandPropertyRequest to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new CreateLandProperty(createLandPropertyRequest);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("createLandPropertyRequest", this.createLandPropertyRequest.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<CreateLandProperty> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("createLandPropertyRequest"), name -> {
          switch (name) {
            case "createLandPropertyRequest": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.propertymanager.choices.requestcreatelandproperty.RequestCreateLandProperty.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new CreateLandProperty(JsonLfDecoders.cast(args[0])));
  }

  public static CreateLandProperty fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("createLandPropertyRequest", apply(JsonLfEncoders::contractId, createLandPropertyRequest)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof CreateLandProperty)) {
      return false;
    }
    CreateLandProperty other = (CreateLandProperty) object;
    return Objects.equals(this.createLandPropertyRequest, other.createLandPropertyRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.createLandPropertyRequest);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.service.CreateLandProperty(%s)",
        this.createLandPropertyRequest);
  }
}
