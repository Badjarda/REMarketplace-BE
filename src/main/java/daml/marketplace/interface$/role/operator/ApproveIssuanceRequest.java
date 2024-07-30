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
import daml.interface$.issuance.service.Request;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ApproveIssuanceRequest extends DamlRecord<ApproveIssuanceRequest> {
  public static final String _packageId = "e09e7a18c217e8002e4a374c04915d394e5120e173ac8f1ee6decbc2d8c3c8b4";

  public final Request.ContractId issuanceServiceRequestCid;

  public ApproveIssuanceRequest(Request.ContractId issuanceServiceRequestCid) {
    this.issuanceServiceRequestCid = issuanceServiceRequestCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ApproveIssuanceRequest fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ApproveIssuanceRequest> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Request.ContractId issuanceServiceRequestCid =
          new Request.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected issuanceServiceRequestCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new ApproveIssuanceRequest(issuanceServiceRequestCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("issuanceServiceRequestCid", this.issuanceServiceRequestCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ApproveIssuanceRequest> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("issuanceServiceRequestCid"), name -> {
          switch (name) {
            case "issuanceServiceRequestCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.issuance.service.Request.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new ApproveIssuanceRequest(JsonLfDecoders.cast(args[0])));
  }

  public static ApproveIssuanceRequest fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("issuanceServiceRequestCid", apply(JsonLfEncoders::contractId, issuanceServiceRequestCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ApproveIssuanceRequest)) {
      return false;
    }
    ApproveIssuanceRequest other = (ApproveIssuanceRequest) object;
    return Objects.equals(this.issuanceServiceRequestCid, other.issuanceServiceRequestCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.issuanceServiceRequestCid);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.role.operator.ApproveIssuanceRequest(%s)",
        this.issuanceServiceRequestCid);
  }
}
