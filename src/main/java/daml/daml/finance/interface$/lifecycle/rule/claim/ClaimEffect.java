package daml.daml.finance.interface$.lifecycle.rule.claim;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.daml.finance.interface$.holding.holding.Holding;
import daml.daml.finance.interface$.lifecycle.effect.Effect;
import daml.daml.finance.interface$.types.common.types.Id;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ClaimEffect extends DamlRecord<ClaimEffect> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final String claimer;

  public final List<Holding.ContractId> holdingCids;

  public final Effect.ContractId effectCid;

  public final Id batchId;

  public ClaimEffect(String claimer, List<Holding.ContractId> holdingCids,
      Effect.ContractId effectCid, Id batchId) {
    this.claimer = claimer;
    this.holdingCids = holdingCids;
    this.effectCid = effectCid;
    this.batchId = batchId;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ClaimEffect fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ClaimEffect> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(4,0,
          recordValue$);
      String claimer = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      List<Holding.ContractId> holdingCids = PrimitiveValueDecoders.fromList(v$0 ->
              new Holding.ContractId(v$0.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected holdingCids to be of type com.daml.ledger.javaapi.data.ContractId")).getValue()))
          .decode(fields$.get(1).getValue());
      Effect.ContractId effectCid =
          new Effect.ContractId(fields$.get(2).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected effectCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      Id batchId = Id.valueDecoder().decode(fields$.get(3).getValue());
      return new ClaimEffect(claimer, holdingCids, effectCid, batchId);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(4);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("claimer", new Party(this.claimer)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("holdingCids", this.holdingCids.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("effectCid", this.effectCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("batchId", this.batchId.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ClaimEffect> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("claimer", "holdingCids", "effectCid", "batchId"), name -> {
          switch (name) {
            case "claimer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "holdingCids": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.holding.holding.Holding.ContractId::new)));
            case "effectCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.lifecycle.effect.Effect.ContractId::new));
            case "batchId": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new ClaimEffect(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3])));
  }

  public static ClaimEffect fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("claimer", apply(JsonLfEncoders::party, claimer)),
        JsonLfEncoders.Field.of("holdingCids", apply(JsonLfEncoders.list(JsonLfEncoders::contractId), holdingCids)),
        JsonLfEncoders.Field.of("effectCid", apply(JsonLfEncoders::contractId, effectCid)),
        JsonLfEncoders.Field.of("batchId", apply(Id::jsonEncoder, batchId)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ClaimEffect)) {
      return false;
    }
    ClaimEffect other = (ClaimEffect) object;
    return Objects.equals(this.claimer, other.claimer) &&
        Objects.equals(this.holdingCids, other.holdingCids) &&
        Objects.equals(this.effectCid, other.effectCid) &&
        Objects.equals(this.batchId, other.batchId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.claimer, this.holdingCids, this.effectCid, this.batchId);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.rule.claim.ClaimEffect(%s, %s, %s, %s)",
        this.claimer, this.holdingCids, this.effectCid, this.batchId);
  }
}
