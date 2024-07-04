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

public class Apply extends DamlRecord<Apply> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final List<NumericObservable.ContractId> observableCids;

  public final Exercisable.ContractId exercisableCid;

  public Apply(List<NumericObservable.ContractId> observableCids,
      Exercisable.ContractId exercisableCid) {
    this.observableCids = observableCids;
    this.exercisableCid = exercisableCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Apply fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Apply> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      List<NumericObservable.ContractId> observableCids = PrimitiveValueDecoders.fromList(v$0 ->
              new NumericObservable.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected observableCids to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
          .decode(fields$.get(0).getValue());
      Exercisable.ContractId exercisableCid =
          new Exercisable.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected exercisableCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new Apply(observableCids, exercisableCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("observableCids", this.observableCids.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("exercisableCid", this.exercisableCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Apply> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("observableCids", "exercisableCid"), name -> {
          switch (name) {
            case "observableCids": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.lifecycle.observable.numericobservable.NumericObservable.ContractId::new)));
            case "exercisableCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.lifecycle.election.Exercisable.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new Apply(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static Apply fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("observableCids", apply(JsonLfEncoders.list(JsonLfEncoders::contractId), observableCids)),
        JsonLfEncoders.Field.of("exercisableCid", apply(JsonLfEncoders::contractId, exercisableCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Apply)) {
      return false;
    }
    Apply other = (Apply) object;
    return Objects.equals(this.observableCids, other.observableCids) &&
        Objects.equals(this.exercisableCid, other.exercisableCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.observableCids, this.exercisableCid);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.election.Apply(%s, %s)",
        this.observableCids, this.exercisableCid);
  }
}
