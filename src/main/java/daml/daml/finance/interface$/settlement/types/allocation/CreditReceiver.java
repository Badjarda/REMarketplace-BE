package daml.daml.finance.interface$.settlement.types.allocation;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import daml.daml.finance.interface$.settlement.types.Allocation;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class CreditReceiver extends Allocation {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public final Unit unitValue;

  public CreditReceiver(Unit unitValue) {
    this.unitValue = unitValue;
  }

  public Variant toValue() {
    return new Variant("CreditReceiver", Unit.getInstance());
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static CreditReceiver fromValue(Value value$) throws IllegalArgumentException {
    return (CreditReceiver)valueDecoder().decode(value$);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof CreditReceiver)) {
      return false;
    }
    CreditReceiver other = (CreditReceiver) object;
    return Objects.equals(this.unitValue, other.unitValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unitValue);
  }

  @Override
  public String toString() {
    return String.format("CreditReceiver(%s)", this.unitValue);
  }

  @Override
  protected JsonLfEncoders.Field fieldForJsonEncoder() {
    return JsonLfEncoders.Field.of("CreditReceiver", apply(JsonLfEncoders::unit, unitValue));
  }
}
