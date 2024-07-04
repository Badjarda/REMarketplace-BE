package daml.daml.finance.interface$.settlement.types.allocation;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import daml.daml.finance.interface$.holding.holding.Holding;
import daml.daml.finance.interface$.settlement.types.Allocation;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class Pledge extends Allocation {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public final Holding.ContractId contractIdValue;

  public Pledge(Holding.ContractId contractIdValue) {
    this.contractIdValue = contractIdValue;
  }

  public Variant toValue() {
    return new Variant("Pledge", this.contractIdValue.toValue());
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Pledge fromValue(Value value$) throws IllegalArgumentException {
    return (Pledge)valueDecoder().decode(value$);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Pledge)) {
      return false;
    }
    Pledge other = (Pledge) object;
    return Objects.equals(this.contractIdValue, other.contractIdValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.contractIdValue);
  }

  @Override
  public String toString() {
    return String.format("Pledge(%s)", this.contractIdValue);
  }

  @Override
  protected JsonLfEncoders.Field fieldForJsonEncoder() {
    return JsonLfEncoders.Field.of("Pledge", apply(JsonLfEncoders::contractId, contractIdValue));
  }
}
