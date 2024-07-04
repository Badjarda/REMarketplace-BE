package daml.daml.finance.interface$.settlement.types.approval;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import daml.daml.finance.interface$.settlement.types.Approval;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class TakeDelivery extends Approval {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public final AccountKey accountKeyValue;

  public TakeDelivery(AccountKey accountKeyValue) {
    this.accountKeyValue = accountKeyValue;
  }

  public Variant toValue() {
    return new Variant("TakeDelivery", this.accountKeyValue.toValue());
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static TakeDelivery fromValue(Value value$) throws IllegalArgumentException {
    return (TakeDelivery)valueDecoder().decode(value$);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof TakeDelivery)) {
      return false;
    }
    TakeDelivery other = (TakeDelivery) object;
    return Objects.equals(this.accountKeyValue, other.accountKeyValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.accountKeyValue);
  }

  @Override
  public String toString() {
    return String.format("TakeDelivery(%s)", this.accountKeyValue);
  }

  @Override
  protected JsonLfEncoders.Field fieldForJsonEncoder() {
    return JsonLfEncoders.Field.of("TakeDelivery", apply(AccountKey::jsonEncoder, accountKeyValue));
  }
}
