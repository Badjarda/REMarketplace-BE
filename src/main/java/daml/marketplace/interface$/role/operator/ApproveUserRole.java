package daml.interface$.role.operator;

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
import daml.interface$.common.types.UserRoleKey;
import daml.interface$.role.user.Request;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ApproveUserRole extends DamlRecord<ApproveUserRole> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final Request.ContractId userRoleRequestCid;

  public final UserRoleKey userRole;

  public ApproveUserRole(Request.ContractId userRoleRequestCid, UserRoleKey userRole) {
    this.userRoleRequestCid = userRoleRequestCid;
    this.userRole = userRole;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static ApproveUserRole fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<ApproveUserRole> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      Request.ContractId userRoleRequestCid =
          new Request.ContractId(fields$.get(0).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected userRoleRequestCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      UserRoleKey userRole = UserRoleKey.valueDecoder().decode(fields$.get(1).getValue());
      return new ApproveUserRole(userRoleRequestCid, userRole);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userRoleRequestCid", this.userRoleRequestCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userRole", this.userRole.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<ApproveUserRole> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("userRoleRequestCid", "userRole"), name -> {
          switch (name) {
            case "userRoleRequestCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.role.user.Request.ContractId::new));
            case "userRole": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.interface$.common.types.UserRoleKey.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new ApproveUserRole(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static ApproveUserRole fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("userRoleRequestCid", apply(JsonLfEncoders::contractId, userRoleRequestCid)),
        JsonLfEncoders.Field.of("userRole", apply(UserRoleKey::jsonEncoder, userRole)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ApproveUserRole)) {
      return false;
    }
    ApproveUserRole other = (ApproveUserRole) object;
    return Objects.equals(this.userRoleRequestCid, other.userRoleRequestCid) &&
        Objects.equals(this.userRole, other.userRole);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.userRoleRequestCid, this.userRole);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.role.operator.ApproveUserRole(%s, %s)",
        this.userRoleRequestCid, this.userRole);
  }
}
