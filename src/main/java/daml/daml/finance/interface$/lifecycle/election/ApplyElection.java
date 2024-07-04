package daml.daml.finance.interface$.lifecycle.election;

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
import daml.daml.finance.interface$.lifecycle.observable.numericobservable.NumericObservable;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ApplyElection extends DamlRecord<ApplyElection> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final Election.ContractId electionCid;

  public final List<NumericObservable.ContractId> observableCids;

  public ApplyElection(Election.ContractId electionCid,
      List<NumericObservable.ContractId> observableCids) {
    this.electionCid = electionCid;
    this.observableCids = observableCids;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ApplyElection fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ApplyElection> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Election.ContractId electionCid =
          new Election.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected electionCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      List<NumericObservable.ContractId> observableCids = PrimitiveValueDecoders.fromList(v$0 ->
              new NumericObservable.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected observableCids to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
          .decode(fields$.get(1).getValue());
      return new ApplyElection(electionCid, observableCids);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("electionCid", this.electionCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observableCids", this.observableCids.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ApplyElection> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("electionCid", "observableCids"), name -> {
          switch (name) {
            case "electionCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.lifecycle.election.Election.ContractId::new));
            case "observableCids": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.lifecycle.observable.numericobservable.NumericObservable.ContractId::new)));
            default: return null;
          }
        }
        , (Object[] args) -> new ApplyElection(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static ApplyElection fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("electionCid", apply(JsonLfEncoders::contractId, electionCid)),
        JsonLfEncoders.Field.of("observableCids", apply(JsonLfEncoders.list(JsonLfEncoders::contractId), observableCids)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ApplyElection)) {
      return false;
    }
    ApplyElection other = (ApplyElection) object;
    return Objects.equals(this.electionCid, other.electionCid) &&
        Objects.equals(this.observableCids, other.observableCids);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.electionCid, this.observableCids);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.election.ApplyElection(%s, %s)",
        this.electionCid, this.observableCids);
  }
}
