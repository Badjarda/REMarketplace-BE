package daml.interface$.profilemanager.userprofile.userprofile;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.interface$.profilemanager.userprofile.common.Nationality;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SetNationality extends DamlRecord<SetNationality> {
  public static final String _packageId = "7410dc0c147f7a1f02e29af653f3db7c67fc88031d45c6c69171d322a8445411";

  public final Nationality newNationality;

  public SetNationality(Nationality newNationality) {
    this.newNationality = newNationality;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static SetNationality fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<SetNationality> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Nationality newNationality = Nationality.valueDecoder().decode(fields$.get(0).getValue());
      return new SetNationality(newNationality);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newNationality", this.newNationality.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<SetNationality> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newNationality"), name -> {
          switch (name) {
            case "newNationality": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.interface$.profilemanager.userprofile.common.Nationality.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new SetNationality(JsonLfDecoders.cast(args[0])));
  }

  public static SetNationality fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newNationality", apply(Nationality::jsonEncoder, newNationality)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof SetNationality)) {
      return false;
    }
    SetNationality other = (SetNationality) object;
    return Objects.equals(this.newNationality, other.newNationality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newNationality);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.profilemanager.userprofile.userprofile.SetNationality(%s)",
        this.newNationality);
  }
}
