package business.userrole.boundary;

import business.userrole.dto.UserRoleOfferDTO;
import business.userrole.service.UserRoleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/userRole")
public class UserRoleResource {
  @Inject
  UserRoleService userRoleService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/acceptUserRole")
  public String acceptUserRole(UserRoleOfferDTO offer) {
    return userRoleService.acceptUserRole(offer.getOperator(), offer.getUser());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/declineUserRole")
  public String declineUserRole(UserRoleOfferDTO offer) {
    return userRoleService.declineUserRole(offer.getOperator(), offer.getUser());
  }
}
