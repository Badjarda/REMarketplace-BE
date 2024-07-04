package business.issuer.boundary;

import business.issuer.dto.IssuanceServiceOfferDTO;
import business.issuer.dto.IssueRequestDTO;
import business.issuer.dto.TransferDTO;
import business.issuer.service.IssuanceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/issuer")
public class IssuerResource {

  @Inject
  IssuanceService issuanceService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/acceptIssuanceService")
  public String acceptIssuanceService(IssuanceServiceOfferDTO offer) {
    return issuanceService.acceptIssuanceService(offer.getOperator(), offer.getUser());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/declineIssuanceService")
  public String declineIssuanceService(IssuanceServiceOfferDTO offer) {
    return issuanceService.declineIssuanceService(offer.getOperator(), offer.getUser());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/requestIssueTransferable")
  public String requestIssueTransferable(IssueRequestDTO request) {
    return issuanceService.requestIssueTransferable(request.getOperator(), request.getUser(),
        request.getIssuanceIdString(), request.getPropertyIdString());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/requestIssueFungible")
  public String requestIssueFungible(IssueRequestDTO request) {
    return issuanceService.requestIssueFungible(request.getOperator(), request.getUser(), request.getIssuanceIdString(),
        request.getTokenStringId(), request.getAmount());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/issueTransferCurrency")
  public String issueTransferCurrency(TransferDTO request) {
    return issuanceService.issueTransferCurrency(request.getOperator(), request.getBuyer(), request.getSeller());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/issueTransferProperty")
  public String issueTransferProperty(TransferDTO request) {
    return issuanceService.issueTransferProperty(request.getOperator(), request.getBuyer(), request.getSeller());
  }
}