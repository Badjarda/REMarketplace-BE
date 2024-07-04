package daml.daml.finance.interface$.holding.fungible;

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
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Merge extends DamlRecord<Merge> {
  public static final String _packageId = "1b3dd202f2b5f6e97f0cc3426598a0c6c4725d8885e9e91d14377dce3e451348";

  public final List<Fungible.ContractId> fungibleCids;

  public Merge(List<Fungible.ContractId> fungibleCids) {
    this.fungibleCids = fungibleCids;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Merge fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Merge> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      List<Fungible.ContractId> fungibleCids = PrimitiveValueDecoders.fromList(v$0 ->
              new Fungible.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected fungibleCids to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
          .decode(fields$.get(0).getValue());
      return new Merge(fungibleCids);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("fungibleCids", this.fungibleCids.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Merge> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("fungibleCids"), name -> {
          switch (name) {
            case "fungibleCids": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.holding.fungible.Fungible.ContractId::new)));
            default: return null;
          }
        }
        , (Object[] args) -> new Merge(JsonLfDecoders.cast(args[0])));
  }

  public static Merge fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("fungibleCids", apply(JsonLfEncoders.list(JsonLfEncoders::contractId), fungibleCids)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Merge)) {
      return false;
    }
    Merge other = (Merge) object;
    return Objects.equals(this.fungibleCids, other.fungibleCids);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.fungibleCids);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.holding.fungible.Merge(%s)",
        this.fungibleCids);
  }
}
