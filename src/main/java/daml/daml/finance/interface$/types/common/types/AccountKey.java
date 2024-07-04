package daml.daml.finance.interface$.types.common.types;

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
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AccountKey extends DamlRecord<AccountKey> {
  public static final String _packageId = "6ea0a5ef5513821304e7830999cbeedb0867b1bd7bc826f0efee61d5d53aa6a6";

  public final String custodian;

  public final String owner;

  public final Id id;

  public AccountKey(String custodian, String owner, Id id) {
    this.custodian = custodian;
    this.owner = owner;
    this.id = id;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AccountKey fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AccountKey> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(3,0,
          recordValue$);
      String custodian = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String owner = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Id id = Id.valueDecoder().decode(fields$.get(2).getValue());
      return new AccountKey(custodian, owner, id);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(3);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("custodian", new Party(this.custodian)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("owner", new Party(this.owner)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("id", this.id.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AccountKey> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("custodian", "owner", "id"), name -> {
          switch (name) {
            case "custodian": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "owner": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "id": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, daml.daml.finance.interface$.types.common.types.Id.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new AccountKey(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2])));
  }

  public static AccountKey fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("custodian", apply(JsonLfEncoders::party, custodian)),
        JsonLfEncoders.Field.of("owner", apply(JsonLfEncoders::party, owner)),
        JsonLfEncoders.Field.of("id", apply(Id::jsonEncoder, id)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof AccountKey)) {
      return false;
    }
    AccountKey other = (AccountKey) object;
    return Objects.equals(this.custodian, other.custodian) &&
        Objects.equals(this.owner, other.owner) && Objects.equals(this.id, other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.custodian, this.owner, this.id);
  }

  @Override
  public String toString() {
    return String.format("daml.daml.finance.interface$.types.common.types.AccountKey(%s, %s, %s)",
        this.custodian, this.owner, this.id);
  }
}
