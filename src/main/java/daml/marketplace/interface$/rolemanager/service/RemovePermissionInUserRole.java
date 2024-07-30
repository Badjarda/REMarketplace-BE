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

public class RemovePermissionInUserRole extends DamlRecord<RemovePermissionInUserRole> {
  public static final String _packageId = "f8883c36e16696951f0e9312ee45dacca92b05226daf215a5159b95d1b1c4079";

  public final UserRoleKey userRole;

  public final Permission permission;

  public RemovePermissionInUserRole(UserRoleKey userRole, Permission permission) {
    this.userRole = userRole;
    this.permission = permission;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static RemovePermissionInUserRole fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RemovePermissionInUserRole> valueDecoder() throws
      IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      UserRoleKey userRole = UserRoleKey.valueDecoder().decode(fields$.get(0).getValue());
      Permission permission = Permission.valueDecoder().decode(fields$.get(1).getValue());
      return new RemovePermissionInUserRole(userRole, permission);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userRole", this.userRole.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("permission", this.permission.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RemovePermissionInUserRole> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("userRole", "permission"), name -> {
          switch (name) {
            case "userRole": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.interface$.common.types.UserRoleKey.jsonDecoder());
            case "permission": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, daml.interface$.rolemanager.userrole.permission.Permission.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new RemovePermissionInUserRole(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static RemovePermissionInUserRole fromJson(String json) throws JsonLfDecoder.Error {
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
    if (!(object instanceof RemovePermissionInUserRole)) {
      return false;
    }
    RemovePermissionInUserRole other = (RemovePermissionInUserRole) object;
    return Objects.equals(this.userRole, other.userRole) &&
        Objects.equals(this.permission, other.permission);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.userRole, this.permission);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.rolemanager.service.RemovePermissionInUserRole(%s, %s)",
        this.userRole, this.permission);
  }
}
