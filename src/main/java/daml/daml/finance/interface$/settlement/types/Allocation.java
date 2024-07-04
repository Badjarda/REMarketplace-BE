package daml.daml.finance.interface$.settlement.types;

import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.Variant;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.da.types.Tuple2;
import daml.daml.finance.interface$.holding.holding.Holding;
import daml.daml.finance.interface$.settlement.types.allocation.CreditReceiver;
import daml.daml.finance.interface$.settlement.types.allocation.PassThroughFrom;
import daml.daml.finance.interface$.settlement.types.allocation.Pledge;
import daml.daml.finance.interface$.settlement.types.allocation.SettleOffledger;
import daml.daml.finance.interface$.settlement.types.allocation.Unallocated;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.Arrays;

public abstract class Allocation extends Variant<Allocation> {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public Allocation() {
  }

  public abstract com.daml.ledger.javaapi.data.Variant toValue();

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Allocation fromValue(Value value$) {
    com.daml.ledger.javaapi.data.Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant daml.daml.finance.interface$.settlement.types.Allocation"));
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Allocation> valueDecoder() {
    return value$ -> {
      com.daml.ledger.javaapi.data.Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant daml.daml.finance.interface$.settlement.types.Allocation"));
      if ("Unallocated".equals(variant$.getConstructor())) {
        return valueDecoderUnallocated().decode(variant$);
      }
      if ("Pledge".equals(variant$.getConstructor())) {
        return valueDecoderPledge().decode(variant$);
      }
      if ("CreditReceiver".equals(variant$.getConstructor())) {
        return valueDecoderCreditReceiver().decode(variant$);
      }
      if ("SettleOffledger".equals(variant$.getConstructor())) {
        return valueDecoderSettleOffledger().decode(variant$);
      }
      if ("PassThroughFrom".equals(variant$.getConstructor())) {
        return valueDecoderPassThroughFrom().decode(variant$);
      }
      throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant daml.daml.finance.interface$.settlement.types.Allocation, expected one of [Unallocated, Pledge, CreditReceiver, SettleOffledger, PassThroughFrom]");
    } ;
  }

  public static JsonLfDecoder<Allocation> jsonDecoder() {
    return JsonLfDecoders.variant(Arrays.asList("Unallocated", "Pledge", "CreditReceiver", "SettleOffledger", "PassThroughFrom"), name -> {
          switch (name) {
            case "Unallocated": return jsonDecoderUnallocated();
            case "Pledge": return jsonDecoderPledge();
            case "CreditReceiver": return jsonDecoderCreditReceiver();
            case "SettleOffledger": return jsonDecoderSettleOffledger();
            case "PassThroughFrom": return jsonDecoderPassThroughFrom();
            default: return null;
          }
        }
        );
  }

  public static Allocation fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  protected abstract JsonLfEncoders.Field fieldForJsonEncoder();

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.variant(Allocation::fieldForJsonEncoder).apply(this);
  }

  private static ValueDecoder<Unallocated> valueDecoderUnallocated() throws
      IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("Unallocated", value$);
      Unit body = PrimitiveValueDecoders.fromUnit.decode(variantValue$);
      return new Unallocated(body);
    } ;
  }

  private static JsonLfDecoder<Unallocated> jsonDecoderUnallocated() {
    return r -> new Unallocated(JsonLfDecoders.unit.decode(r));
  }

  private static ValueDecoder<Pledge> valueDecoderPledge() throws IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("Pledge", value$);
      Holding.ContractId body =
          new Holding.ContractId(variantValue$.asContractId().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new Pledge(body);
    } ;
  }

  private static JsonLfDecoder<Pledge> jsonDecoderPledge() {
    return r -> new Pledge(JsonLfDecoders.contractId(Holding.ContractId::new).decode(r));
  }

  private static ValueDecoder<CreditReceiver> valueDecoderCreditReceiver() throws
      IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("CreditReceiver", value$);
      Unit body = PrimitiveValueDecoders.fromUnit.decode(variantValue$);
      return new CreditReceiver(body);
    } ;
  }

  private static JsonLfDecoder<CreditReceiver> jsonDecoderCreditReceiver() {
    return r -> new CreditReceiver(JsonLfDecoders.unit.decode(r));
  }

  private static ValueDecoder<SettleOffledger> valueDecoderSettleOffledger() throws
      IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("SettleOffledger", value$);
      Unit body = PrimitiveValueDecoders.fromUnit.decode(variantValue$);
      return new SettleOffledger(body);
    } ;
  }

  private static JsonLfDecoder<SettleOffledger> jsonDecoderSettleOffledger() {
    return r -> new SettleOffledger(JsonLfDecoders.unit.decode(r));
  }

  private static ValueDecoder<PassThroughFrom> valueDecoderPassThroughFrom() throws
      IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("PassThroughFrom", value$);
      Tuple2<AccountKey, InstructionKey> body =
          Tuple2.<daml.daml.finance.interface$.types.common.types.AccountKey,
          daml.daml.finance.interface$.settlement.types.InstructionKey>valueDecoder(AccountKey.valueDecoder(),
          InstructionKey.valueDecoder()).decode(variantValue$);
      return new PassThroughFrom(body);
    } ;
  }

  private static JsonLfDecoder<PassThroughFrom> jsonDecoderPassThroughFrom() {
    return r -> new PassThroughFrom(Tuple2.jsonDecoder(AccountKey.jsonDecoder(), InstructionKey.jsonDecoder()).decode(r));
  }
}
