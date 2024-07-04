package daml.daml.finance.interface$.holding.transferable;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.da.set.types.Set;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Transfer extends DamlRecord<Transfer> {
  public static final String _packageId = "1b3dd202f2b5f6e97f0cc3426598a0c6c4725d8885e9e91d14377dce3e451348";

  public final Set<String> actors;

  public final AccountKey newOwnerAccount;

  public Transfer(Set<String> actors, AccountKey newOwnerAccount) {
    this.actors = actors;
    this.newOwnerAccount = newOwnerAccount;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Transfer fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Transfer> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Set<String> actors = Set.<java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty)
          .decode(fields$.get(0).getValue());
      AccountKey newOwnerAccount = AccountKey.valueDecoder().decode(fields$.get(1).getValue());
      return new Transfer(actors, newOwnerAccount);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("actors", this.actors.toValue(v$0 -> new Party(v$0))));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newOwnerAccount", this.newOwnerAccount.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Transfer> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("actors", "newOwnerAccount"), name -> {
          switch (name) {
            case "actors": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.da.set.types.Set.jsonDecoder(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party));
            case "newOwnerAccount": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.daml.finance.interface$.types.common.types.AccountKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new Transfer(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static Transfer fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("actors", apply(_x0 -> _x0.jsonEncoder(JsonLfEncoders::party), actors)),
        JsonLfEncoders.Field.of("newOwnerAccount", apply(AccountKey::jsonEncoder, newOwnerAccount)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Transfer)) {
      return false;
    }
    Transfer other = (Transfer) object;
    return Objects.equals(this.actors, other.actors) &&
        Objects.equals(this.newOwnerAccount, other.newOwnerAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.actors, this.newOwnerAccount);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.holding.transferable.Transfer(%s, %s)",
        this.actors, this.newOwnerAccount);
  }
}
