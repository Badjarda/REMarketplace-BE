package daml.interface$.profilemanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.interface$.common.types.UserProfileKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UpdateUsername extends DamlRecord<UpdateUsername> {
  public static final String _packageId = "7410dc0c147f7a1f02e29af653f3db7c67fc88031d45c6c69171d322a8445411";

  public final String newUsername;

  public final UserProfileKey userProfileKey;

  public UpdateUsername(String newUsername, UserProfileKey userProfileKey) {
    this.newUsername = newUsername;
    this.userProfileKey = userProfileKey;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateUsername fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateUsername> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String newUsername = PrimitiveValueDecoders.fromText.decode(fields$.get(0).getValue());
      UserProfileKey userProfileKey = UserProfileKey.valueDecoder()
          .decode(fields$.get(1).getValue());
      return new UpdateUsername(newUsername, userProfileKey);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newUsername", new Text(this.newUsername)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userProfileKey", this.userProfileKey.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateUsername> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newUsername", "userProfileKey"), name -> {
          switch (name) {
            case "newUsername": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "userProfileKey": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.interface$.common.types.UserProfileKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateUsername(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static UpdateUsername fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newUsername", apply(JsonLfEncoders::text, newUsername)),
        JsonLfEncoders.Field.of("userProfileKey", apply(UserProfileKey::jsonEncoder, userProfileKey)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof UpdateUsername)) {
      return false;
    }
    UpdateUsername other = (UpdateUsername) object;
    return Objects.equals(this.newUsername, other.newUsername) &&
        Objects.equals(this.userProfileKey, other.userProfileKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newUsername, this.userProfileKey);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.profilemanager.service.UpdateUsername(%s, %s)",
        this.newUsername, this.userProfileKey);
  }
}
