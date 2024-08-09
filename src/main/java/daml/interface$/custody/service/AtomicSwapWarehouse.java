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
import daml.daml.finance.interface$.holding.transferable.Transferable;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.interface$.common.types.PropertyKey;
import daml.interface$.custody.choices.swaprequest.SwapRequest;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AtomicSwapWarehouse extends DamlRecord<AtomicSwapWarehouse> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final String seller;

  public final String buyer;

  public final AccountKey sellerAccount;

  public final Transferable.ContractId transferableHoldingCid;

  public final SwapRequest.ContractId transferRequestCid;

  public final PropertyKey propertyKey;

  public AtomicSwapWarehouse(String seller, String buyer, AccountKey sellerAccount,
      Transferable.ContractId transferableHoldingCid, SwapRequest.ContractId transferRequestCid,
      PropertyKey propertyKey) {
    this.seller = seller;
    this.buyer = buyer;
    this.sellerAccount = sellerAccount;
    this.transferableHoldingCid = transferableHoldingCid;
    this.transferRequestCid = transferRequestCid;
    this.propertyKey = propertyKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AtomicSwapWarehouse fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AtomicSwapWarehouse> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0,
          recordValue$);
      String seller = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String buyer = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      AccountKey sellerAccount = AccountKey.valueDecoder().decode(fields$.get(2).getValue());
      Transferable.ContractId transferableHoldingCid =
          new Transferable.ContractId(fields$.get(3).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected transferableHoldingCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      SwapRequest.ContractId transferRequestCid =
          new SwapRequest.ContractId(fields$.get(4).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected transferRequestCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      PropertyKey propertyKey = PropertyKey.valueDecoder().decode(fields$.get(5).getValue());
      return new AtomicSwapWarehouse(seller, buyer, sellerAccount, transferableHoldingCid,
          transferRequestCid, propertyKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(6);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("seller", new Party(this.seller)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buyer", new Party(this.buyer)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("sellerAccount", this.sellerAccount.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("transferableHoldingCid", this.transferableHoldingCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("transferRequestCid", this.transferRequestCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyKey", this.propertyKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AtomicSwapWarehouse> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("seller", "buyer", "sellerAccount", "transferableHoldingCid", "transferRequestCid", "propertyKey"), name -> {
          switch (name) {
            case "seller": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "buyer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "sellerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "transferableHoldingCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.daml.finance.interface$.holding.transferable.Transferable.ContractId::new));
            case "transferRequestCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.custody.choices.swaprequest.SwapRequest.ContractId::new));
            case "propertyKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, daml.interface$.common.types.PropertyKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new AtomicSwapWarehouse(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static AtomicSwapWarehouse fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("seller", apply(JsonLfEncoders::party, seller)),
        JsonLfEncoders.Field.of("buyer", apply(JsonLfEncoders::party, buyer)),
        JsonLfEncoders.Field.of("sellerAccount", apply(AccountKey::jsonEncoder, sellerAccount)),
        JsonLfEncoders.Field.of("transferableHoldingCid", apply(JsonLfEncoders::contractId, transferableHoldingCid)),
        JsonLfEncoders.Field.of("transferRequestCid", apply(JsonLfEncoders::contractId, transferRequestCid)),
        JsonLfEncoders.Field.of("propertyKey", apply(PropertyKey::jsonEncoder, propertyKey)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof AtomicSwapWarehouse)) {
      return false;
    }
    AtomicSwapWarehouse other = (AtomicSwapWarehouse) object;
    return Objects.equals(this.seller, other.seller) && Objects.equals(this.buyer, other.buyer) &&
        Objects.equals(this.sellerAccount, other.sellerAccount) &&
        Objects.equals(this.transferableHoldingCid, other.transferableHoldingCid) &&
        Objects.equals(this.transferRequestCid, other.transferRequestCid) &&
        Objects.equals(this.propertyKey, other.propertyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.seller, this.buyer, this.sellerAccount, this.transferableHoldingCid,
        this.transferRequestCid, this.propertyKey);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.custody.service.AtomicSwapWarehouse(%s, %s, %s, %s, %s, %s)",
        this.seller, this.buyer, this.sellerAccount, this.transferableHoldingCid,
        this.transferRequestCid, this.propertyKey);
  }
}
