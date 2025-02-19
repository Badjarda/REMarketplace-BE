package daml.marketplace.interface$.profilemanager.userprofile.userprofile;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlOptional;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.marketplace.interface$.profilemanager.userprofile.common.Gender;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SetGender extends DamlRecord<SetGender> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final Optional<Gender> newGender;

  public SetGender(Optional<Gender> newGender) {
    this.newGender = newGender;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetGender fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetGender> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,1,
          recordValue$);
      Optional<Gender> newGender = PrimitiveValueDecoders.fromOptional(Gender.valueDecoder())
          .decode(fields$.get(0).getValue());
      return new SetGender(newGender);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newGender", DamlOptional.of(this.newGender.map(v$0 -> v$0.toValue()))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetGender> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newGender"), name -> {
          switch (name) {
            case "newGender": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.optional(daml.marketplace.interface$.profilemanager.userprofile.common.Gender.jsonDecoder()));
            default: return null;
          }
        }
        , (Object[] args) -> new SetGender(JsonLfDecoders.cast(args[0])));
  }

  public static SetGender fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newGender", apply(JsonLfEncoders.optional(Gender::jsonEncoder), newGender)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetGender)) {
      return false;
    }
    SetGender other = (SetGender) object;
    return Objects.equals(this.newGender, other.newGender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newGender);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.profilemanager.userprofile.userprofile.SetGender(%s)",
        this.newGender);
  }
}
