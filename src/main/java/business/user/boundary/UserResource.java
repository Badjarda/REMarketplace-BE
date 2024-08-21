package business.user.boundary;

import apiconfiguration.Transactions;
import business.party.service.PartyService;
import business.user.dto.CreateUserDTO;
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
    @Path("/createUser")
    public String createUser(CreateUserDTO request) {
        return userService.createUser(request.getName(), request.getParty(), request.getProfileId(), request.getUsername(), request.getFirstName(), request.getLastName(), 
        request.getFullName(), request.getPassword(), request.getBirthday(), request.getGender(), request.getNationality(), request.getContactMail(),
        request.getCellphoneNumber(), request.getIdNumber(), request.getTaxId(), request.getSocialSecurityId(), request.getPhotoReferences());
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteUser/{name}")
    public String deleteUser(String name) {
        return userService.deleteUser(name);
    }

}
