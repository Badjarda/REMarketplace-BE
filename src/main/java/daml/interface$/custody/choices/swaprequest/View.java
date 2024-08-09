package daml.interface$.custody.choices.swaprequest;

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

public class View extends DamlRecord<View> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final String operator;

  public final String buyer;

  public final String seller;

  public final AccountKey sellerAccount;

  public final AccountKey buyerAccount;

  public final Transferable.ContractId fungibleHoldingCid;

  public final BigDecimal fungibleAmount;

  public View(String operator, String buyer, String seller, AccountKey sellerAccount,
      AccountKey buyerAccount, Transferable.ContractId fungibleHoldingCid,
      BigDecimal fungibleAmount) {
    this.operator = operator;
    this.buyer = buyer;
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
  public static View fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<View> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(7,0,
          recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String buyer = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      String seller = PrimitiveValueDecoders.fromParty.decode(fields$.get(2).getValue());
      AccountKey sellerAccount = AccountKey.valueDecoder().decode(fields$.get(3).getValue());
      AccountKey buyerAccount = AccountKey.valueDecoder().decode(fields$.get(4).getValue());
      Transferable.ContractId fungibleHoldingCid =
          new Transferable.ContractId(fields$.get(5).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected fungibleHoldingCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      BigDecimal fungibleAmount = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(6).getValue());
      return new View(operator, buyer, seller, sellerAccount, buyerAccount, fungibleHoldingCid,
          fungibleAmount);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(7);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buyer", new Party(this.buyer)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("seller", new Party(this.seller)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("sellerAccount", this.sellerAccount.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buyerAccount", this.buyerAccount.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("fungibleHoldingCid", this.fungibleHoldingCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("fungibleAmount", new Numeric(this.fungibleAmount)));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<View> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "buyer", "seller", "sellerAccount", "buyerAccount", "fungibleHoldingCid", "fungibleAmount"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "buyer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "seller": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "sellerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "buyerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "fungibleHoldingCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.holding.transferable.Transferable.ContractId::new));
            case "fungibleAmount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            default: return null;
          }
        }
        , (Object[] args) -> new View(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6])));
  }

  public static View fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("buyer", apply(JsonLfEncoders::party, buyer)),
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
    if (!(object instanceof View)) {
      return false;
    }
    View other = (View) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.buyer, other.buyer) && Objects.equals(this.seller, other.seller) &&
        Objects.equals(this.sellerAccount, other.sellerAccount) &&
        Objects.equals(this.buyerAccount, other.buyerAccount) &&
        Objects.equals(this.fungibleHoldingCid, other.fungibleHoldingCid) &&
        Objects.equals(this.fungibleAmount, other.fungibleAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.buyer, this.seller, this.sellerAccount,
        this.buyerAccount, this.fungibleHoldingCid, this.fungibleAmount);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.custody.choices.swaprequest.View(%s, %s, %s, %s, %s, %s, %s)",
        this.operator, this.buyer, this.seller, this.sellerAccount, this.buyerAccount,
        this.fungibleHoldingCid, this.fungibleAmount);
  }
}
