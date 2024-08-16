package daml.marketplace.interface$.custody.service;

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
  public static final String _packageId = "b93cea58d2cd7e7792117719e7c79bd5a10ca2a87dc57a03f202a3ec5bc6c5d9";

  public final String seller;

  public final AccountKey sellerAccount;

  public final AccountKey buyerAccount;

  public final Transferable.ContractId fungibleHoldingCid;

  public final BigDecimal fungibleAmount;

  public final Transferable.ContractId transferableHoldingCid;

  public RequestSwap(String seller, AccountKey sellerAccount, AccountKey buyerAccount,
      Transferable.ContractId fungibleHoldingCid, BigDecimal fungibleAmount,
      Transferable.ContractId transferableHoldingCid) {
    this.seller = seller;
    this.sellerAccount = sellerAccount;
    this.buyerAccount = buyerAccount;
    this.fungibleHoldingCid = fungibleHoldingCid;
    this.fungibleAmount = fungibleAmount;
    this.transferableHoldingCid = transferableHoldingCid;
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
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0,
          recordValue$);
      String seller = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      AccountKey sellerAccount = AccountKey.valueDecoder().decode(fields$.get(1).getValue());
      AccountKey buyerAccount = AccountKey.valueDecoder().decode(fields$.get(2).getValue());
      Transferable.ContractId fungibleHoldingCid =
          new Transferable.ContractId(fields$.get(3).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected fungibleHoldingCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      BigDecimal fungibleAmount = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(4).getValue());
      Transferable.ContractId transferableHoldingCid =
          new Transferable.ContractId(fields$.get(5).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected transferableHoldingCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new RequestSwap(seller, sellerAccount, buyerAccount, fungibleHoldingCid,
          fungibleAmount, transferableHoldingCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(6);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("seller", new Party(this.seller)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("sellerAccount", this.sellerAccount.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buyerAccount", this.buyerAccount.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("fungibleHoldingCid", this.fungibleHoldingCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("fungibleAmount", new Numeric(this.fungibleAmount)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("transferableHoldingCid", this.transferableHoldingCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RequestSwap> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("seller", "sellerAccount", "buyerAccount", "fungibleHoldingCid", "fungibleAmount", "transferableHoldingCid"), name -> {
          switch (name) {
            case "seller": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "sellerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "buyerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "fungibleHoldingCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.holding.transferable.Transferable.ContractId::new));
            case "fungibleAmount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "transferableHoldingCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.holding.transferable.Transferable.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new RequestSwap(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
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
        JsonLfEncoders.Field.of("fungibleAmount", apply(JsonLfEncoders::numeric, fungibleAmount)),
        JsonLfEncoders.Field.of("transferableHoldingCid", apply(JsonLfEncoders::contractId, transferableHoldingCid)));
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
        Objects.equals(this.fungibleAmount, other.fungibleAmount) &&
        Objects.equals(this.transferableHoldingCid, other.transferableHoldingCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.seller, this.sellerAccount, this.buyerAccount, this.fungibleHoldingCid,
        this.fungibleAmount, this.transferableHoldingCid);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.custody.service.RequestSwap(%s, %s, %s, %s, %s, %s)",
        this.seller, this.sellerAccount, this.buyerAccount, this.fungibleHoldingCid,
        this.fungibleAmount, this.transferableHoldingCid);
  }
}
