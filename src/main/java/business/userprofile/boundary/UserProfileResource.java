package business.userprofile.boundary;

import business.userprofile.dto.GetProfile;
import business.userprofile.dto.ProfileServiceOfferDTO;
import business.userprofile.dto.UserProfileDTO;
import business.userprofile.dto.UserProfileGETDTO;
import business.userprofile.service.UserProfileService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/userProfile")
public class UserProfileResource {

  @Inject
  UserProfileService userProfileService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/acceptProfileService")
  public String acceptProfileService(ProfileServiceOfferDTO offer) {
    return userProfileService.acceptProfileService(offer.getOperator(), offer.getUser());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/declineProfileService")
  public String declineProfileService(ProfileServiceOfferDTO offer) {
    return userProfileService.declineProfileService(offer.getOperator(), offer.getUser());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/requestCreateUserProfile")
  public String requestCreateUserProfile(UserProfileDTO request) {
    return userProfileService.requestCreateUserProfile(request.getUser(), request.getPublicString(), 
        request.getProfileId(), request.getUsername(), request.getFirstName(), request.getLastName(), request.getFullName(),
        request.getPassword(), request.getBirthday(), request.getGender(), request.getNationality(), request.getContactMail(),
        request.getCellphoneNumber(), request.getIdNumber(), request.getTaxId(), request.getSocialSecurityId(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/updateProfile")
  public String updateProfile(UserProfileDTO request) {
    return userProfileService.modifyUserProfileFields(request.getUser(), request.getUsername(),
        request.getFirstName(), request.getLastName(), request.getFullName(), request.getPassword(),
        request.getBirthday(), request.getGender(), request.getNationality(), request.getContactMail(),
        request.getCellphoneNumber(), request.getIdNumber(), request.getTaxId(), request.getSocialSecurityId(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getUserProfile")
  public UserProfileGETDTO getUserProfile(GetProfile request) {
      return userProfileService.getUserProfile(request.getUser());
  }

}