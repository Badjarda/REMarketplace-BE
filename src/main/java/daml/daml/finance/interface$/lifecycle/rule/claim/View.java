package daml.daml.finance.interface$.lifecycle.rule.claim;

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
import daml.da.set.types.Set;
import daml.daml.finance.interface$.settlement.factory.Factory;
import daml.daml.finance.interface$.settlement.routeprovider.RouteProvider;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class View extends DamlRecord<View> {
  public static final String _packageId = "b915eb59058bda9951c2eb9ff1ef32c9a4042cc0d1604fb008d84dad7cab5e46";

  public final Set<String> providers;

  public final Set<String> claimers;

  public final Set<String> settlers;

  public final RouteProvider.ContractId routeProviderCid;

  public final Factory.ContractId settlementFactoryCid;

  public View(Set<String> providers, Set<String> claimers, Set<String> settlers,
      RouteProvider.ContractId routeProviderCid, Factory.ContractId settlementFactoryCid) {
    this.providers = providers;
    this.claimers = claimers;
    this.settlers = settlers;
    this.routeProviderCid = routeProviderCid;
    this.settlementFactoryCid = settlementFactoryCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static View fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<View> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0,
          recordValue$);
      Set<String> providers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      Set<String> claimers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(1).getValue());
      Set<String> settlers = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(2).getValue());
      RouteProvider.ContractId routeProviderCid =
          new RouteProvider.ContractId(fields$.get(3).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected routeProviderCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      Factory.ContractId settlementFactoryCid =
          new Factory.ContractId(fields$.get(4).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected settlementFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new View(providers, claimers, settlers, routeProviderCid, settlementFactoryCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(5);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("providers", this.providers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("claimers", this.claimers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("settlers", this.settlers.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("routeProviderCid", this.routeProviderCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("settlementFactoryCid", this.settlementFactoryCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("providers", "claimers", "settlers", "routeProviderCid", "settlementFactoryCid"), name -> {
          switch (name) {
            case "providers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "claimers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "settlers": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "routeProviderCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.settlement.routeprovider.RouteProvider.ContractId::new));
            case "settlementFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.settlement.factory.Factory.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new View(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static View fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("providers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), providers)),
        JsonLfEncoders.Field.of("claimers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), claimers)),
        JsonLfEncoders.Field.of("settlers", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), settlers)),
        JsonLfEncoders.Field.of("routeProviderCid", apply(JsonLfEncoders::contractId, routeProviderCid)),
        JsonLfEncoders.Field.of("settlementFactoryCid", apply(JsonLfEncoders::contractId, settlementFactoryCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof View)) {
      return false;
    }
    View other = (View) object;
    return Objects.equals(this.providers, other.providers) &&
        Objects.equals(this.claimers, other.claimers) &&
        Objects.equals(this.settlers, other.settlers) &&
        Objects.equals(this.routeProviderCid, other.routeProviderCid) &&
        Objects.equals(this.settlementFactoryCid, other.settlementFactoryCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.providers, this.claimers, this.settlers, this.routeProviderCid,
        this.settlementFactoryCid);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.lifecycle.rule.claim.View(%s, %s, %s, %s, %s)",
        this.providers, this.claimers, this.settlers, this.routeProviderCid,
        this.settlementFactoryCid);
  }
}
