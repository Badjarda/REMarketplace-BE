package business.party.boundary;

import business.party.service.PartyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/party")
public class PartyResource {
    @Inject
    PartyService partyService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/createParty/{name}")
    public String createParty(String name) {
        return partyService.createParty(name);
    }
}
