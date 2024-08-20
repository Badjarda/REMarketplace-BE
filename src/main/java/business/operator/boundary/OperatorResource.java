package business.operator.boundary;

import java.util.List;
import java.util.Map;

import business.operator.service.OperatorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/operator")
public class OperatorResource {

    @Inject
    OperatorService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllPropertyRequests")
    public Map<String, List<?>> getAllPropertyRequests() {
        return service.getAllPropertyRequests();
    }

}