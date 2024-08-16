package daml.marketplace.interface$.custody.service;

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
import daml.daml.finance.interface$.types.common.types.AccountKey;
import daml.marketplace.interface$.common.types.PropertyKey;
import daml.marketplace.interface$.custody.choices.swaprequest.SwapRequest;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AtomicSwapGarage extends DamlRecord<AtomicSwapGarage> {
  public static final String _packageId = "b93cea58d2cd7e7792117719e7c79bd5a10ca2a87dc57a03f202a3ec5bc6c5d9";

  public final String seller;

  public final String buyer;

  public final AccountKey sellerAccount;

  public final SwapRequest.ContractId transferRequestCid;

  public final PropertyKey propertyKey;

  public AtomicSwapGarage(String seller, String buyer, AccountKey sellerAccount,
      SwapRequest.ContractId transferRequestCid, PropertyKey propertyKey) {
    this.seller = seller;
    this.buyer = buyer;
    this.sellerAccount = sellerAccount;
    this.transferRequestCid = transferRequestCid;
    this.propertyKey = propertyKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AtomicSwapGarage fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AtomicSwapGarage> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(5,0,
          recordValue$);
      String seller = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String buyer = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      AccountKey sellerAccount = AccountKey.valueDecoder().decode(fields$.get(2).getValue());
      SwapRequest.ContractId transferRequestCid =
          new SwapRequest.ContractId(fields$.get(3).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected transferRequestCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      PropertyKey propertyKey = PropertyKey.valueDecoder().decode(fields$.get(4).getValue());
      return new AtomicSwapGarage(seller, buyer, sellerAccount, transferRequestCid, propertyKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(5);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("seller", new Party(this.seller)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("buyer", new Party(this.buyer)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("sellerAccount", this.sellerAccount.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("transferRequestCid", this.transferRequestCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("propertyKey", this.propertyKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AtomicSwapGarage> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("seller", "buyer", "sellerAccount", "transferRequestCid", "propertyKey"), name -> {
          switch (name) {
            case "seller": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "buyer": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "sellerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            case "transferRequestCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.marketplace.interface$.custody.choices.swaprequest.SwapRequest.ContractId::new));
            case "propertyKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, daml.marketplace.interface$.common.types.PropertyKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new AtomicSwapGarage(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4])));
  }

  public static AtomicSwapGarage fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("seller", apply(JsonLfEncoders::party, seller)),
        JsonLfEncoders.Field.of("buyer", apply(JsonLfEncoders::party, buyer)),
        JsonLfEncoders.Field.of("sellerAccount", apply(AccountKey::jsonEncoder, sellerAccount)),
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
    if (!(object instanceof AtomicSwapGarage)) {
      return false;
    }
    AtomicSwapGarage other = (AtomicSwapGarage) object;
    return Objects.equals(this.seller, other.seller) && Objects.equals(this.buyer, other.buyer) &&
        Objects.equals(this.sellerAccount, other.sellerAccount) &&
        Objects.equals(this.transferRequestCid, other.transferRequestCid) &&
        Objects.equals(this.propertyKey, other.propertyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.seller, this.buyer, this.sellerAccount, this.transferRequestCid,
        this.propertyKey);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.custody.service.AtomicSwapGarage(%s, %s, %s, %s, %s)",
        this.seller, this.buyer, this.sellerAccount, this.transferRequestCid, this.propertyKey);
  }
}
