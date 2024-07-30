package daml.interface$.profilemanager.service;

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
import daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CreateUserProfile extends DamlRecord<CreateUserProfile> {
  public static final String _packageId = "e09e7a18c217e8002e4a374c04915d394e5120e173ac8f1ee6decbc2d8c3c8b4";

  public final RequestCreateUserProfile.ContractId createUserProfileRequest;

  public CreateUserProfile(RequestCreateUserProfile.ContractId createUserProfileRequest) {
    this.createUserProfileRequest = createUserProfileRequest;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CreateUserProfile fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<CreateUserProfile> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      RequestCreateUserProfile.ContractId createUserProfileRequest =
          new RequestCreateUserProfile.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected createUserProfileRequest to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new CreateUserProfile(createUserProfileRequest);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("createUserProfileRequest", this.createUserProfileRequest.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<CreateUserProfile> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("createUserProfileRequest"), name -> {
          switch (name) {
            case "createUserProfileRequest": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.profilemanager.choices.requestcreateuserprofile.RequestCreateUserProfile.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new CreateUserProfile(JsonLfDecoders.cast(args[0])));
  }

  public static CreateUserProfile fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("createUserProfileRequest", apply(JsonLfEncoders::contractId, createUserProfileRequest)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof CreateUserProfile)) {
      return false;
    }
    CreateUserProfile other = (CreateUserProfile) object;
    return Objects.equals(this.createUserProfileRequest, other.createUserProfileRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.createUserProfileRequest);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.profilemanager.service.CreateUserProfile(%s)",
        this.createUserProfileRequest);
  }
}
