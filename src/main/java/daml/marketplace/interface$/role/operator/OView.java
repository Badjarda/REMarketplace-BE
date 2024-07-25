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

public class OView extends DamlRecord<OView> {
  public static final String _packageId = "8c6e592f5a33911df4c5cbfd683c840613ba80718b2d85f183257ac23495fc1f";

  public final String operator;

  public final Factory.ContractId userRoleFactoryCid;

  public OView(String operator, Factory.ContractId userRoleFactoryCid) {
    this.operator = operator;
    this.userRoleFactoryCid = userRoleFactoryCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static OView fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<OView> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Factory.ContractId userRoleFactoryCid =
          new Factory.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected userRoleFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new OView(operator, userRoleFactoryCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userRoleFactoryCid", this.userRoleFactoryCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<OView> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "userRoleFactoryCid"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "userRoleFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.rolemanager.userrole.factory.Factory.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new OView(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static OView fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
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
    if (!(object instanceof OView)) {
      return false;
    }
    OView other = (OView) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.userRoleFactoryCid, other.userRoleFactoryCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.userRoleFactoryCid);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.role.operator.OView(%s, %s)", this.operator,
        this.userRoleFactoryCid);
  }
}
