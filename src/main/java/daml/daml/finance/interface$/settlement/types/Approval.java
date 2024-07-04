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
import daml.daml.finance.interface$.settlement.types.approval.DebitSender;
import daml.daml.finance.interface$.settlement.types.approval.PassThroughTo;
import daml.daml.finance.interface$.settlement.types.approval.SettleOffledgerAcknowledge;
import daml.daml.finance.interface$.settlement.types.approval.TakeDelivery;
import daml.daml.finance.interface$.settlement.types.approval.Unapproved;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.Arrays;

public abstract class Approval extends Variant<Approval> {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public Approval() {
  }

  public abstract com.daml.ledger.javaapi.data.Variant toValue();

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Approval fromValue(Value value$) {
    com.daml.ledger.javaapi.data.Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant daml.daml.finance.interface$.settlement.types.Approval"));
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Approval> valueDecoder() {
    return value$ -> {
      com.daml.ledger.javaapi.data.Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant daml.daml.finance.interface$.settlement.types.Approval"));
      if ("Unapproved".equals(variant$.getConstructor())) {
        return valueDecoderUnapproved().decode(variant$);
      }
      if ("TakeDelivery".equals(variant$.getConstructor())) {
        return valueDecoderTakeDelivery().decode(variant$);
      }
      if ("DebitSender".equals(variant$.getConstructor())) {
        return valueDecoderDebitSender().decode(variant$);
      }
      if ("SettleOffledgerAcknowledge".equals(variant$.getConstructor())) {
        return valueDecoderSettleOffledgerAcknowledge().decode(variant$);
      }
      if ("PassThroughTo".equals(variant$.getConstructor())) {
        return valueDecoderPassThroughTo().decode(variant$);
      }
      throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant daml.daml.finance.interface$.settlement.types.Approval, expected one of [Unapproved, TakeDelivery, DebitSender, SettleOffledgerAcknowledge, PassThroughTo]");
    } ;
  }

  public static JsonLfDecoder<Approval> jsonDecoder() {
    return JsonLfDecoders.variant(Arrays.asList("Unapproved", "TakeDelivery", "DebitSender", "SettleOffledgerAcknowledge", "PassThroughTo"), name -> {
          switch (name) {
            case "Unapproved": return jsonDecoderUnapproved();
            case "TakeDelivery": return jsonDecoderTakeDelivery();
            case "DebitSender": return jsonDecoderDebitSender();
            case "SettleOffledgerAcknowledge": return jsonDecoderSettleOffledgerAcknowledge();
            case "PassThroughTo": return jsonDecoderPassThroughTo();
            default: return null;
          }
        }
        );
  }

  public static Approval fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  protected abstract JsonLfEncoders.Field fieldForJsonEncoder();

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.variant(Approval::fieldForJsonEncoder).apply(this);
  }

  private static ValueDecoder<Unapproved> valueDecoderUnapproved() throws IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("Unapproved", value$);
      Unit body = PrimitiveValueDecoders.fromUnit.decode(variantValue$);
      return new Unapproved(body);
    } ;
  }

  private static JsonLfDecoder<Unapproved> jsonDecoderUnapproved() {
    return r -> new Unapproved(JsonLfDecoders.unit.decode(r));
  }

  private static ValueDecoder<TakeDelivery> valueDecoderTakeDelivery() throws
      IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("TakeDelivery", value$);
      AccountKey body = AccountKey.valueDecoder().decode(variantValue$);
      return new TakeDelivery(body);
    } ;
  }

  private static JsonLfDecoder<TakeDelivery> jsonDecoderTakeDelivery() {
    return r -> new TakeDelivery(AccountKey.jsonDecoder().decode(r));
  }

  private static ValueDecoder<DebitSender> valueDecoderDebitSender() throws
      IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("DebitSender", value$);
      Unit body = PrimitiveValueDecoders.fromUnit.decode(variantValue$);
      return new DebitSender(body);
    } ;
  }

  private static JsonLfDecoder<DebitSender> jsonDecoderDebitSender() {
    return r -> new DebitSender(JsonLfDecoders.unit.decode(r));
  }

  private static ValueDecoder<SettleOffledgerAcknowledge> valueDecoderSettleOffledgerAcknowledge()
      throws IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("SettleOffledgerAcknowledge",
          value$);
      Unit body = PrimitiveValueDecoders.fromUnit.decode(variantValue$);
      return new SettleOffledgerAcknowledge(body);
    } ;
  }

  private static JsonLfDecoder<SettleOffledgerAcknowledge> jsonDecoderSettleOffledgerAcknowledge() {
    return r -> new SettleOffledgerAcknowledge(JsonLfDecoders.unit.decode(r));
  }

  private static ValueDecoder<PassThroughTo> valueDecoderPassThroughTo() throws
      IllegalArgumentException {
    return value$ -> {
      Value variantValue$ = PrimitiveValueDecoders.variantCheck("PassThroughTo", value$);
      Tuple2<AccountKey, InstructionKey> body =
          Tuple2.<daml.daml.finance.interface$.types.common.types.AccountKey,
          daml.daml.finance.interface$.settlement.types.InstructionKey>valueDecoder(AccountKey.valueDecoder(),
          InstructionKey.valueDecoder()).decode(variantValue$);
      return new PassThroughTo(body);
    } ;
  }

  private static JsonLfDecoder<PassThroughTo> jsonDecoderPassThroughTo() {
    return r -> new PassThroughTo(Tuple2.jsonDecoder(AccountKey.jsonDecoder(), InstructionKey.jsonDecoder()).decode(r));
  }
}
