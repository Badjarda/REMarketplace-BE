package daml.interface$.rolemanager.service;

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
import daml.interface$.rolemanager.userrole.permission.Permission;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AddPermissionToUserRole extends DamlRecord<AddPermissionToUserRole> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final UserRoleKey userRole;

  public final Permission permission;

  public AddPermissionToUserRole(UserRoleKey userRole, Permission permission) {
    this.userRole = userRole;
    this.permission = permission;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static AddPermissionToUserRole fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<AddPermissionToUserRole> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      UserRoleKey userRole = UserRoleKey.valueDecoder().decode(fields$.get(0).getValue());
      Permission permission = Permission.valueDecoder().decode(fields$.get(1).getValue());
      return new AddPermissionToUserRole(userRole, permission);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userRole", this.userRole.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("permission", this.permission.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<AddPermissionToUserRole> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("userRole", "permission"), name -> {
          switch (name) {
            case "userRole": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.interface$.common.types.UserRoleKey.jsonDecoder());
            case "permission": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.interface$.rolemanager.userrole.permission.Permission.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new AddPermissionToUserRole(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static AddPermissionToUserRole fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("userRole", apply(UserRoleKey::jsonEncoder, userRole)),
        JsonLfEncoders.Field.of("permission", apply(Permission::jsonEncoder, permission)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof AddPermissionToUserRole)) {
      return false;
    }
    AddPermissionToUserRole other = (AddPermissionToUserRole) object;
    return Objects.equals(this.userRole, other.userRole) &&
        Objects.equals(this.permission, other.permission);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.userRole, this.permission);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.rolemanager.service.AddPermissionToUserRole(%s, %s)",
        this.userRole, this.permission);
  }
}
