package daml.daml.finance.interface$.settlement.types.approval;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import daml.daml.finance.interface$.settlement.types.Approval;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class SettleOffledgerAcknowledge extends Approval {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public final Unit unitValue;

  public SettleOffledgerAcknowledge(Unit unitValue) {
    this.unitValue = unitValue;
  }

  public Variant toValue() {
    return new Variant("SettleOffledgerAcknowledge", Unit.getInstance());
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SettleOffledgerAcknowledge fromValue(Value value$) throws IllegalArgumentException {
    return (SettleOffledgerAcknowledge)valueDecoder().decode(value$);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SettleOffledgerAcknowledge)) {
      return false;
    }
    SettleOffledgerAcknowledge other = (SettleOffledgerAcknowledge) object;
    return Objects.equals(this.unitValue, other.unitValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unitValue);
  }

  @Override
  public String toString() {
    return String.format("SettleOffledgerAcknowledge(%s)", this.unitValue);
  }

  @Override
  protected JsonLfEncoders.Field fieldForJsonEncoder() {
    return JsonLfEncoders.Field.of("SettleOffledgerAcknowledge",
        apply(JsonLfEncoders::unit, unitValue));
  }
}
