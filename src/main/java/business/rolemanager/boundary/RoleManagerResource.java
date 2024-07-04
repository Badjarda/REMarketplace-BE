package business.rolemanager.boundary;

import business.rolemanager.service.RoleManagerService;
import business.rolemanager.dto.UserRoleRequestDTO;
import business.rolemanager.dto.UserRolePermissionsDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/roleManager")
public class RoleManagerResource {

  @Inject
  RoleManagerService userRoleManagerService;

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/createUserFactory/{operator}")
  public String createUserFactory(String operator) {
    return userRoleManagerService.createUserFactory(operator);
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/createUserRole/{operator}/{user}")
  public String createUserRole(String operator, String user, UserRoleRequestDTO request) {
    return userRoleManagerService.createUserRole(operator, user, request.getRoleId(),
        request.getDescription(), request.getPermissions());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/deleteUserRole/{operator}/{user}")
  public String deleteUserRole(String operator, String user) {
    return userRoleManagerService.deleteUserRole(operator, user);
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/requestAddPermissionUserRole/{operator}/{user}")
  public String requestAddPermissionUserRole(String operator, String user, UserRolePermissionsDTO permissions) {
    return userRoleManagerService.addPermissionUserRole(operator, user, permissions.getPermissions().get(0));
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/requestRemovePermissionUserRole/{operator}/{user}")
  public String requestRemovePermissionUserRole(String operator, String user, UserRolePermissionsDTO permissions) {
    return userRoleManagerService.removePermissionUserRole(operator, user, permissions.getPermissions().get(0));
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/requestUpdateUserRole/{operator}/{user}")
  public String requestUpdateUserRole(String operator, String user, UserRolePermissionsDTO permissions) {
    return userRoleManagerService.updateUserRole(operator, user, permissions.getPermissions());
  }

}