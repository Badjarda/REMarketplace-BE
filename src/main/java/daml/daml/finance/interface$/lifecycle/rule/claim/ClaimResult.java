package daml.daml.finance.interface$.lifecycle.rule.claim;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.daml.finance.interface$.settlement.batch.Batch;
import daml.daml.finance.interface$.settlement.instruction.Instruction;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ClaimResult extends DamlRecord<ClaimResult> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final Batch.ContractId batchCid;

  public final List<Instruction.ContractId> instructionCids;

  public ClaimResult(Batch.ContractId batchCid, List<Instruction.ContractId> instructionCids) {
    this.batchCid = batchCid;
    this.instructionCids = instructionCids;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ClaimResult fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ClaimResult> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Batch.ContractId batchCid =
          new Batch.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected batchCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      List<Instruction.ContractId> instructionCids = PrimitiveValueDecoders.fromList(v$0 ->
              new Instruction.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected instructionCids to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
          .decode(fields$.get(1).getValue());
      return new ClaimResult(batchCid, instructionCids);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("batchCid", this.batchCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("instructionCids", this.instructionCids.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ClaimResult> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("batchCid", "instructionCids"), name -> {
          switch (name) {
            case "batchCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.settlement.batch.Batch.ContractId::new));
            case "instructionCids": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.settlement.instruction.Instruction.ContractId::new)));
            default: return null;
          }
        }
        , (Object[] args) -> new ClaimResult(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static ClaimResult fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("batchCid", apply(JsonLfEncoders::contractId, batchCid)),
        JsonLfEncoders.Field.of("instructionCids", apply(JsonLfEncoders.list(JsonLfEncoders::contractId), instructionCids)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ClaimResult)) {
      return false;
    }
    ClaimResult other = (ClaimResult) object;
    return Objects.equals(this.batchCid, other.batchCid) &&
        Objects.equals(this.instructionCids, other.instructionCids);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.batchCid, this.instructionCids);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.rule.claim.ClaimResult(%s, %s)",
        this.batchCid, this.instructionCids);
  }
}
