package daml.interface$.issuance.service;

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
import daml.interface$.issuance.choices.deissuerequest.DeIssueRequest;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DeIssue extends DamlRecord<DeIssue> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final DeIssueRequest.ContractId deIssueRequestCid;

  public DeIssue(DeIssueRequest.ContractId deIssueRequestCid) {
    this.deIssueRequestCid = deIssueRequestCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static DeIssue fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<DeIssue> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      DeIssueRequest.ContractId deIssueRequestCid =
          new DeIssueRequest.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected deIssueRequestCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new DeIssue(deIssueRequestCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("deIssueRequestCid", this.deIssueRequestCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<DeIssue> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("deIssueRequestCid"), name -> {
          switch (name) {
            case "deIssueRequestCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.issuance.choices.deissuerequest.DeIssueRequest.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new DeIssue(JsonLfDecoders.cast(args[0])));
  }

  public static DeIssue fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("deIssueRequestCid", apply(JsonLfEncoders::contractId, deIssueRequestCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof DeIssue)) {
      return false;
    }
    DeIssue other = (DeIssue) object;
    return Objects.equals(this.deIssueRequestCid, other.deIssueRequestCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.deIssueRequestCid);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.issuance.service.DeIssue(%s)", this.deIssueRequestCid);
  }
}
