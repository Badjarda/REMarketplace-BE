package daml.interface$.role.operator;

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
import daml.interface$.rolemanager.userrole.factory.Factory;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OfferUserRoleManagerService extends DamlRecord<OfferUserRoleManagerService> {
  public static final String _packageId = "e09e7a18c217e8002e4a374c04915d394e5120e173ac8f1ee6decbc2d8c3c8b4";

  public final String user;

  public final Factory.ContractId userRoleFactoryCid;

  public OfferUserRoleManagerService(String user, Factory.ContractId userRoleFactoryCid) {
    this.user = user;
    this.userRoleFactoryCid = userRoleFactoryCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static OfferUserRoleManagerService fromValue(Value value$) throws
      IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<OfferUserRoleManagerService> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String user = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Factory.ContractId userRoleFactoryCid =
          new Factory.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected userRoleFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new OfferUserRoleManagerService(user, userRoleFactoryCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("user", new Party(this.user)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userRoleFactoryCid", this.userRoleFactoryCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<OfferUserRoleManagerService> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("user", "userRoleFactoryCid"), name -> {
          switch (name) {
            case "user": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "userRoleFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.rolemanager.userrole.factory.Factory.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new OfferUserRoleManagerService(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static OfferUserRoleManagerService fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("user", apply(JsonLfEncoders::party, user)),
        JsonLfEncoders.Field.of("userRoleFactoryCid", apply(JsonLfEncoders::contractId, userRoleFactoryCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof OfferUserRoleManagerService)) {
      return false;
    }
    OfferUserRoleManagerService other = (OfferUserRoleManagerService) object;
    return Objects.equals(this.user, other.user) &&
        Objects.equals(this.userRoleFactoryCid, other.userRoleFactoryCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.user, this.userRoleFactoryCid);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.role.operator.OfferUserRoleManagerService(%s, %s)",
        this.user, this.userRoleFactoryCid);
  }
}
