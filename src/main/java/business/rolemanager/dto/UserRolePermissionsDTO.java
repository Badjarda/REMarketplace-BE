package business.rolemanager.dto;

import java.util.List;
import daml.marketplace.interface$.rolemanager.userrole.permission.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePermissionsDTO {
  private List<Permission> permissions;
}

