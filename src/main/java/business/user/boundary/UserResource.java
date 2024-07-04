package business.user.boundary;

import apiconfiguration.Transactions;
import business.party.service.PartyService;
import business.user.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @Inject
    Transactions transactions;

    @Inject
    PartyService partyService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public void update() {
        transactions.update();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/createUser/{name}/{party}")
    public String createUser(String name, String party) {
        return userService.createUser(name, party);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteUser/{name}")
    public String deleteUser(String name) {
        return userService.deleteUser(name);
    }

}
