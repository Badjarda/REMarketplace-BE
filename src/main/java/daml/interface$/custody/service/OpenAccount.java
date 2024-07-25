package daml.interface$.custody.service;

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
import daml.interface$.custody.choices.openaccountrequest.OpenAccountRequest;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OpenAccount extends DamlRecord<OpenAccount> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final OpenAccountRequest.ContractId openAccountRequestCid;

  public OpenAccount(OpenAccountRequest.ContractId openAccountRequestCid) {
    this.openAccountRequestCid = openAccountRequestCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static OpenAccount fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<OpenAccount> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      OpenAccountRequest.ContractId openAccountRequestCid =
          new OpenAccountRequest.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected openAccountRequestCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new OpenAccount(openAccountRequestCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("openAccountRequestCid", this.openAccountRequestCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<OpenAccount> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("openAccountRequestCid"), name -> {
          switch (name) {
            case "openAccountRequestCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.custody.choices.openaccountrequest.OpenAccountRequest.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new OpenAccount(JsonLfDecoders.cast(args[0])));
  }

  public static OpenAccount fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("openAccountRequestCid", apply(JsonLfEncoders::contractId, openAccountRequestCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof OpenAccount)) {
      return false;
    }
    OpenAccount other = (OpenAccount) object;
    return Objects.equals(this.openAccountRequestCid, other.openAccountRequestCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.openAccountRequestCid);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.custody.service.OpenAccount(%s)",
        this.openAccountRequestCid);
  }
}
