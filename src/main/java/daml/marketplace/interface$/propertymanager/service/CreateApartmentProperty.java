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
import daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CreateApartmentProperty extends DamlRecord<CreateApartmentProperty> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final RequestCreateApartmentProperty.ContractId createApartmentPropertyRequest;

  public CreateApartmentProperty(
      RequestCreateApartmentProperty.ContractId createApartmentPropertyRequest) {
    this.createApartmentPropertyRequest = createApartmentPropertyRequest;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CreateApartmentProperty fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<CreateApartmentProperty> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      RequestCreateApartmentProperty.ContractId createApartmentPropertyRequest =
          new RequestCreateApartmentProperty.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected createApartmentPropertyRequest to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new CreateApartmentProperty(createApartmentPropertyRequest);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("createApartmentPropertyRequest", this.createApartmentPropertyRequest.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<CreateApartmentProperty> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("createApartmentPropertyRequest"), name -> {
          switch (name) {
            case "createApartmentPropertyRequest": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.propertymanager.choices.requestcreateapartmentproperty.RequestCreateApartmentProperty.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new CreateApartmentProperty(JsonLfDecoders.cast(args[0])));
  }

  public static CreateApartmentProperty fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("createApartmentPropertyRequest", apply(JsonLfEncoders::contractId, createApartmentPropertyRequest)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof CreateApartmentProperty)) {
      return false;
    }
    CreateApartmentProperty other = (CreateApartmentProperty) object;
    return Objects.equals(this.createApartmentPropertyRequest, other.createApartmentPropertyRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.createApartmentPropertyRequest);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.service.CreateApartmentProperty(%s)",
        this.createApartmentPropertyRequest);
  }
}
