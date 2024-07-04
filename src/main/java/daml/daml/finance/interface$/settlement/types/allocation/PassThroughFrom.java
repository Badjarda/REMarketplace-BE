package daml.daml.finance.interface$.settlement.types.allocation;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import daml.da.types.Tuple2;
import daml.daml.finance.interface$.settlement.types.Allocation;
import daml.daml.finance.interface$.settlement.types.InstructionKey;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class PassThroughFrom extends Allocation {
  public static final String _packageId = "388d50fcef966aedb231d3bb2c520fcccd235ad92ce07feb40d311c4be06d7b5";

  public final Tuple2<AccountKey, InstructionKey> tuple2Value;

  public PassThroughFrom(Tuple2<AccountKey, InstructionKey> tuple2Value) {
    this.tuple2Value = tuple2Value;
  }

  public Variant toValue() {
    return new Variant("PassThroughFrom", this.tuple2Value.toValue(v$0 -> v$0.toValue(),
        v$1 -> v$1.toValue()));
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static PassThroughFrom fromValue(Value value$) throws IllegalArgumentException {
    return (PassThroughFrom)valueDecoder().decode(value$);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof PassThroughFrom)) {
      return false;
    }
    PassThroughFrom other = (PassThroughFrom) object;
    return Objects.equals(this.tuple2Value, other.tuple2Value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tuple2Value);
  }

  @Override
  public String toString() {
    return String.format("PassThroughFrom(%s)", this.tuple2Value);
  }

  @Override
  protected JsonLfEncoders.Field fieldForJsonEncoder() {
    return JsonLfEncoders.Field.of("PassThroughFrom",
        apply(_x0 -> _x0.jsonEncoder(AccountKey::jsonEncoder, InstructionKey::jsonEncoder), tuple2Value));
  }
}
