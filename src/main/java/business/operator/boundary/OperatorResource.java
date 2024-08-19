package business.operator.boundary;

import business.operator.service.OperatorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/operator")
public class OperatorResource {

    @Inject
    OperatorService service;

}