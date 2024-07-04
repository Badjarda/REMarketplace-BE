package business.propertymanager.boundary;

import business.propertymanager.service.PropertyManagerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/propertyManager")
public class PropertyManagerResource {

  @Inject
  PropertyManagerService propertyManagerService;

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/createPropertyFactories/{operator}")
  public String createPropertyFactories(String operator) {
    return propertyManagerService.createPropertyFactories(operator);
  }

}