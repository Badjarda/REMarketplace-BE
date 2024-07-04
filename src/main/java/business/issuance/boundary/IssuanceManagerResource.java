package business.issuance.boundary;

import business.issuance.service.IssuanceManagerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/issuanceManager")
public class IssuanceManagerResource {

  @Inject
  IssuanceManagerService issuanceManagerService;

}