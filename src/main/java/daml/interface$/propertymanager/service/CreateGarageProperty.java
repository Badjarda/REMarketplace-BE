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
import daml.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CreateGarageProperty extends DamlRecord<CreateGarageProperty> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final RequestCreateGarageProperty.ContractId createGaragePropertyRequest;

  public CreateGarageProperty(RequestCreateGarageProperty.ContractId createGaragePropertyRequest) {
    this.createGaragePropertyRequest = createGaragePropertyRequest;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CreateGarageProperty fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<CreateGarageProperty> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      RequestCreateGarageProperty.ContractId createGaragePropertyRequest =
          new RequestCreateGarageProperty.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected createGaragePropertyRequest to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new CreateGarageProperty(createGaragePropertyRequest);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("createGaragePropertyRequest", this.createGaragePropertyRequest.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<CreateGarageProperty> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("createGaragePropertyRequest"), name -> {
          switch (name) {
            case "createGaragePropertyRequest": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.propertymanager.choices.requestcreategarageproperty.RequestCreateGarageProperty.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new CreateGarageProperty(JsonLfDecoders.cast(args[0])));
  }

  public static CreateGarageProperty fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("createGaragePropertyRequest", apply(JsonLfEncoders::contractId, createGaragePropertyRequest)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof CreateGarageProperty)) {
      return false;
    }
    CreateGarageProperty other = (CreateGarageProperty) object;
    return Objects.equals(this.createGaragePropertyRequest, other.createGaragePropertyRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.createGaragePropertyRequest);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.service.CreateGarageProperty(%s)",
        this.createGaragePropertyRequest);
  }
}
