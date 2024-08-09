package daml.interface$.custody.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Numeric;
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
import daml.daml.finance.interface$.holding.transferable.Transferable;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RequestSwap extends DamlRecord<RequestSwap> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final String seller;

  public final AccountKey sellerAccount;

  public final AccountKey buyerAccount;

  public final Transferable.ContractId fungibleHoldingCid;

  public final BigDecimal fungibleAmount;

  public RequestSwap(String seller, AccountKey sellerAccount, AccountKey buyerAccount,
      Transferable.ContractId fungibleHoldingCid, BigDecimal fungibleAmount) {
    this.seller = seller;
    this.sellerAccount = sellerAccount;
    this.buyerAccount = buyerAccount;
    this.fungibleHoldingCid = fungibleHoldingCid;
    this.fungibleAmount = fungibleAmount;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static RequestSwap fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RequestSwap> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0,
          recordValue$);
      String seller = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      AccountKey sellerAccount = AccountKey.valueDecoder().decode(fields$.get(1).getValue());
      AccountKey buyerAccount = AccountKey.valueDecoder().decode(fields$.get(2).getValue());
      Transferable.ContractId fungibleHoldingCid =
          new Transferable.ContractId(fields$.get(3).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected fungibleHoldingCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      BigDecimal fungibleAmount = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(4).getValue());
      return new RequestSwap(seller, sellerAccount, buyerAccount, fungibleHoldingCid,
          fungibleAmount);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(5);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("seller", new Party(this.seller)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("sellerAccount", this.sellerAccount.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buyerAccount", this.buyerAccount.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("fungibleHoldingCid", this.fungibleHoldingCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("fungibleAmount", new Numeric(this.fungibleAmount)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RequestSwap> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("seller", "sellerAccount", "buyerAccount", "fungibleHoldingCid", "fungibleAmount"), name -> {
          switch (name) {
            case "seller": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "sellerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "buyerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "fungibleHoldingCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.holding.transferable.Transferable.ContractId::new));
            case "fungibleAmount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            default: return null;
          }
        }
        , (Object[] args) -> new RequestSwap(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static RequestSwap fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("seller", apply(JsonLfEncoders::party, seller)),
        JsonLfEncoders.Field.of("sellerAccount", apply(AccountKey::jsonEncoder, sellerAccount)),
        JsonLfEncoders.Field.of("buyerAccount", apply(AccountKey::jsonEncoder, buyerAccount)),
        JsonLfEncoders.Field.of("fungibleHoldingCid", apply(JsonLfEncoders::contractId, fungibleHoldingCid)),
        JsonLfEncoders.Field.of("fungibleAmount", apply(JsonLfEncoders::numeric, fungibleAmount)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof RequestSwap)) {
      return false;
    }
    RequestSwap other = (RequestSwap) object;
    return Objects.equals(this.seller, other.seller) &&
        Objects.equals(this.sellerAccount, other.sellerAccount) &&
        Objects.equals(this.buyerAccount, other.buyerAccount) &&
        Objects.equals(this.fungibleHoldingCid, other.fungibleHoldingCid) &&
        Objects.equals(this.fungibleAmount, other.fungibleAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.seller, this.sellerAccount, this.buyerAccount, this.fungibleHoldingCid,
        this.fungibleAmount);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.custody.service.RequestSwap(%s, %s, %s, %s, %s)",
        this.seller, this.sellerAccount, this.buyerAccount, this.fungibleHoldingCid,
        this.fungibleAmount);
  }
}
