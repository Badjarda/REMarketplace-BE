package daml.interface$.custody.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

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
import daml.daml.finance.interface$.account.factory.Factory;
import daml.daml.finance.interface$.lifecycle.rule.claim.Claim;
import daml.daml.finance.interface$.types.common.types.HoldingFactoryKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OView extends DamlRecord<OView> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final String user;

  public final String operator;

  public final Factory.ContractId accountFactoryCid;

  public final HoldingFactoryKey holdingFactoryKey;

  public final Claim.ContractId claimRuleCid;

  public OView(String user, String operator, Factory.ContractId accountFactoryCid,
      HoldingFactoryKey holdingFactoryKey, Claim.ContractId claimRuleCid) {
    this.user = user;
    this.operator = operator;
    this.accountFactoryCid = accountFactoryCid;
    this.holdingFactoryKey = holdingFactoryKey;
    this.claimRuleCid = claimRuleCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static OView fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<OView> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0,
          recordValue$);
      String user = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Factory.ContractId accountFactoryCid =
          new Factory.ContractId(fields$.get(2).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected accountFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      HoldingFactoryKey holdingFactoryKey = HoldingFactoryKey.valueDecoder()
          .decode(fields$.get(3).getValue());
      Claim.ContractId claimRuleCid =
          new Claim.ContractId(fields$.get(4).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected claimRuleCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new OView(user, operator, accountFactoryCid, holdingFactoryKey, claimRuleCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(5);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("user", new Party(this.user)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("accountFactoryCid", this.accountFactoryCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("holdingFactoryKey", this.holdingFactoryKey.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("claimRuleCid", this.claimRuleCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<OView> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("user", "operator", "accountFactoryCid", "holdingFactoryKey", "claimRuleCid"), name -> {
          switch (name) {
            case "user": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "accountFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.account.factory.Factory.ContractId::new));
            case "holdingFactoryKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.HoldingFactoryKey.jsonDecoder());
            case "claimRuleCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.lifecycle.rule.claim.Claim.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new OView(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static OView fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("user", apply(JsonLfEncoders::party, user)),
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("accountFactoryCid", apply(JsonLfEncoders::contractId, accountFactoryCid)),
        JsonLfEncoders.Field.of("holdingFactoryKey", apply(HoldingFactoryKey::jsonEncoder, holdingFactoryKey)),
        JsonLfEncoders.Field.of("claimRuleCid", apply(JsonLfEncoders::contractId, claimRuleCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof OView)) {
      return false;
    }
    OView other = (OView) object;
    return Objects.equals(this.user, other.user) && Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.accountFactoryCid, other.accountFactoryCid) &&
        Objects.equals(this.holdingFactoryKey, other.holdingFactoryKey) &&
        Objects.equals(this.claimRuleCid, other.claimRuleCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.user, this.operator, this.accountFactoryCid, this.holdingFactoryKey,
        this.claimRuleCid);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.custody.service.OView(%s, %s, %s, %s, %s)", this.user,
        this.operator, this.accountFactoryCid, this.holdingFactoryKey, this.claimRuleCid);
  }
}
