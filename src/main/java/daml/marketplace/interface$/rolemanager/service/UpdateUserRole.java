package daml.marketplace.interface$.rolemanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.marketplace.interface$.common.types.UserRoleKey;
import daml.marketplace.interface$.rolemanager.userrole.permission.Permission;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UpdateUserRole extends DamlRecord<UpdateUserRole> {
  public static final String _packageId = "b93cea58d2cd7e7792117719e7c79bd5a10ca2a87dc57a03f202a3ec5bc6c5d9";

  public final UserRoleKey userRole;

  public final List<Permission> permissions;

  public UpdateUserRole(UserRoleKey userRole, List<Permission> permissions) {
    this.userRole = userRole;
    this.permissions = permissions;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateUserRole fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateUserRole> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(2,0,
          recordValue$);
      UserRoleKey userRole = UserRoleKey.valueDecoder().decode(fields$.get(0).getValue());
      List<Permission> permissions = PrimitiveValueDecoders.fromList(Permission.valueDecoder())
          .decode(fields$.get(1).getValue());
      return new UpdateUserRole(userRole, permissions);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(2);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("userRole", this.userRole.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("permissions", this.permissions.stream().collect(DamlCollectors.toDamlList(v$0 -> v$0.toValue()))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateUserRole> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("userRole", "permissions"), name -> {
          switch (name) {
            case "userRole": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.marketplace.interface$.common.types.UserRoleKey.jsonDecoder());
            case "permissions": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(daml.marketplace.interface$.rolemanager.userrole.permission.Permission.jsonDecoder()));
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateUserRole(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1])));
  }

  public static UpdateUserRole fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("userRole", apply(UserRoleKey::jsonEncoder, userRole)),
        JsonLfEncoders.Field.of("permissions", apply(JsonLfEncoders.list(Permission::jsonEncoder), permissions)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof UpdateUserRole)) {
      return false;
    }
    UpdateUserRole other = (UpdateUserRole) object;
    return Objects.equals(this.userRole, other.userRole) &&
        Objects.equals(this.permissions, other.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.userRole, this.permissions);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.rolemanager.service.UpdateUserRole(%s, %s)",
        this.userRole, this.permissions);
  }
}
