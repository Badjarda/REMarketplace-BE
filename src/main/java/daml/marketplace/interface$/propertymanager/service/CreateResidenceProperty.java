package daml.marketplace.interface$.propertymanager.service;

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
import daml.marketplace.interface$.propertymanager.choices.requestcreateresidenceproperty.RequestCreateResidenceProperty;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CreateResidenceProperty extends DamlRecord<CreateResidenceProperty> {
  public static final String _packageId = "b93cea58d2cd7e7792117719e7c79bd5a10ca2a87dc57a03f202a3ec5bc6c5d9";

  public final RequestCreateResidenceProperty.ContractId createResidencePropertyRequest;

  public CreateResidenceProperty(
      RequestCreateResidenceProperty.ContractId createResidencePropertyRequest) {
    this.createResidencePropertyRequest = createResidencePropertyRequest;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CreateResidenceProperty fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<CreateResidenceProperty> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      RequestCreateResidenceProperty.ContractId createResidencePropertyRequest =
          new RequestCreateResidenceProperty.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected createResidencePropertyRequest to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new CreateResidenceProperty(createResidencePropertyRequest);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("createResidencePropertyRequest", this.createResidencePropertyRequest.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<CreateResidenceProperty> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("createResidencePropertyRequest"), name -> {
          switch (name) {
            case "createResidencePropertyRequest": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.marketplace.interface$.propertymanager.choices.requestcreateresidenceproperty.RequestCreateResidenceProperty.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new CreateResidenceProperty(JsonLfDecoders.cast(args[0])));
  }

  public static CreateResidenceProperty fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("createResidencePropertyRequest", apply(JsonLfEncoders::contractId, createResidencePropertyRequest)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof CreateResidenceProperty)) {
      return false;
    }
    CreateResidenceProperty other = (CreateResidenceProperty) object;
    return Objects.equals(this.createResidencePropertyRequest, other.createResidencePropertyRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.createResidencePropertyRequest);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.service.CreateResidenceProperty(%s)",
        this.createResidencePropertyRequest);
  }
}
