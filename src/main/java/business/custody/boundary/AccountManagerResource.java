package business.custody.boundary;

import business.custody.service.AccountManagerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/accountManager")
public class AccountManagerResource {

  @Inject
  AccountManagerService accountManagerService;

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/createCustodyService/{operator}/{user}/{publicString}/{holdingTypeId}")
  public String createCustodyService(String operator, String user, String publicString, String holdingTypeId) {
    return accountManagerService.createCustodyService(operator, user, publicString, holdingTypeId);
  }

}