package daml.marketplace.interface$.rolemanager.userrole.userrole;

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

public class RemovePermission extends DamlRecord<RemovePermission> {
  public static final String _packageId = "b93cea58d2cd7e7792117719e7c79bd5a10ca2a87dc57a03f202a3ec5bc6c5d9";

  public final Permission permission;

  public RemovePermission(Permission permission) {
    this.permission = permission;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static RemovePermission fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<RemovePermission> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(1,0,
          recordValue$);
      Permission permission = Permission.valueDecoder().decode(fields$.get(0).getValue());
      return new RemovePermission(permission);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(1);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("permission", this.permission.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<RemovePermission> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("permission"), name -> {
          switch (name) {
            case "permission": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, daml.marketplace.interface$.rolemanager.userrole.permission.Permission.jsonDecoder());
            default: return null;
          }
        }
        , (Object[] args) -> new RemovePermission(JsonLfDecoders.cast(args[0])));
  }

  public static RemovePermission fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
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
    if (!(object instanceof RemovePermission)) {
      return false;
    }
    RemovePermission other = (RemovePermission) object;
    return Objects.equals(this.permission, other.permission);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.permission);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.rolemanager.userrole.userrole.RemovePermission(%s)",
        this.permission);
  }
}
