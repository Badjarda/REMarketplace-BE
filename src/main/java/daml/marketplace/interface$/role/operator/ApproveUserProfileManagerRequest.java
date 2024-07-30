package daml.interface$.role.operator;

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
import daml.interface$.profilemanager.service.Request;
import daml.interface$.profilemanager.userprofile.factory.Factory;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ApproveUserProfileManagerRequest extends DamlRecord<ApproveUserProfileManagerRequest> {
  public static final String _packageId = "e09e7a18c217e8002e4a374c04915d394e5120e173ac8f1ee6decbc2d8c3c8b4";

  public final Request.ContractId userProfileManagerServiceRequestCid;

  public final Factory.ContractId userProfileFactoryCid;

  public ApproveUserProfileManagerRequest(Request.ContractId userProfileManagerServiceRequestCid,
      Factory.ContractId userProfileFactoryCid) {
    this.userProfileManagerServiceRequestCid = userProfileManagerServiceRequestCid;
    this.userProfileFactoryCid = userProfileFactoryCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ApproveUserProfileManagerRequest fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ApproveUserProfileManagerRequest> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Request.ContractId userProfileManagerServiceRequestCid =
          new Request.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected userProfileManagerServiceRequestCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      Factory.ContractId userProfileFactoryCid =
          new Factory.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected userProfileFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new ApproveUserProfileManagerRequest(userProfileManagerServiceRequestCid,
          userProfileFactoryCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userProfileManagerServiceRequestCid", this.userProfileManagerServiceRequestCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userProfileFactoryCid", this.userProfileFactoryCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ApproveUserProfileManagerRequest> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("userProfileManagerServiceRequestCid", "userProfileFactoryCid"), name -> {
          switch (name) {
            case "userProfileManagerServiceRequestCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.profilemanager.service.Request.ContractId::new));
            case "userProfileFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.profilemanager.userprofile.factory.Factory.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new ApproveUserProfileManagerRequest(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static ApproveUserProfileManagerRequest fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("userProfileManagerServiceRequestCid", apply(JsonLfEncoders::contractId, userProfileManagerServiceRequestCid)),
        JsonLfEncoders.Field.of("userProfileFactoryCid", apply(JsonLfEncoders::contractId, userProfileFactoryCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ApproveUserProfileManagerRequest)) {
      return false;
    }
    ApproveUserProfileManagerRequest other = (ApproveUserProfileManagerRequest) object;
    return Objects.equals(this.userProfileManagerServiceRequestCid, other.userProfileManagerServiceRequestCid) &&
        Objects.equals(this.userProfileFactoryCid, other.userProfileFactoryCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.userProfileManagerServiceRequestCid, this.userProfileFactoryCid);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.role.operator.ApproveUserProfileManagerRequest(%s, %s)",
        this.userProfileManagerServiceRequestCid, this.userProfileFactoryCid);
  }
}
