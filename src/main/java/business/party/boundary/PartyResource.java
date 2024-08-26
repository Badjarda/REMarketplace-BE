package business.party.boundary;

import business.party.dto.CreatePartyDTO;
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
    @Path("/createParty")
    public String createParty(CreatePartyDTO request) {
        return partyService.createParty(request.getPartyName());
    }
}
