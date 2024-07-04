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

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/createOperator/{operator}")
    public String createOperator(String operator) {
        return service.createOperatorRole(operator);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/createInitialRole/{operator}/{publicUser}")
    public String createInitialRole(String operator, String publicUser) {
        return service.createInitialRole(operator, publicUser);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/offerUserRole/{operator}/{user}/{userRoleId}")
    public String offerUserRole(String operator, String user, String userRoleId) {
        return service.offerUserRole(operator, user, userRoleId);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/offerCustodianService/{operator}/{user}")
    public String offerCustodianService(String operator, String user) {
        return service.offerCustodianService(operator, user);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/offerUserProfileService/{operator}/{user}")
    public String offerUserProfileService(String operator, String user) {
        return service.offerUserProfileService(operator, user);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/offerPropertyManagerService/{operator}/{user}")
    public String offerPropertyManagerService(String operator, String user) {
        return service.offerPropertyManagerService(operator, user);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/offerIssuanceService/{operator}/{user}")
    public String offerIssuanceService(String operator, String user) {
        return service.offerIssuanceService(operator, user);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/acceptRequestCreateProfile/{operator}/{user}")
    public String acceptRequestCreateProfile(String operator, String user) {
        return service.acceptRequestCreateProfile(operator, user);
    }

}