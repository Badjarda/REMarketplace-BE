package business.profilemanager.boundary;

import business.profilemanager.service.ProfileManagerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/profileManager")
public class ProfileManagerResource {
  @Inject
  ProfileManagerService profileManagerService;

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/createUserProfileFactory/{operator}")
  public String createUserProfileFactory(String operator) {
    return profileManagerService.createUserProfileFactory(operator);
  }

}
