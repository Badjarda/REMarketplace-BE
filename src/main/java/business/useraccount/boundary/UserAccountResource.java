package business.useraccount.boundary;

import java.math.BigDecimal;
import java.util.List;

import business.useraccount.dto.CustodyServiceOfferDTO;
import business.useraccount.dto.GetBalanceDTO;
import business.useraccount.dto.GetSwapRequests;
import business.useraccount.dto.SwapRequestGETDTO;
import business.useraccount.dto.UserAccountDTO;
import business.useraccount.dto.UserHoldingFungibleGETDTO;
import business.useraccount.service.UserAccountService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/userAccount")
public class UserAccountResource {
  @Inject
  UserAccountService userAccountService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/acceptCustodyService")
  public String acceptCustodyService(CustodyServiceOfferDTO offer) {
    return userAccountService.acceptCustodyService(offer.getOperator(), offer.getUser());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/declineCustodyService")
  public String declineCustodyService(CustodyServiceOfferDTO offer) {
    return userAccountService.declineCustodyService(offer.getOperator(), offer.getUser());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/requestOpenAccount/{operator}/{user}")
  public String requestOpenAccount(String operator, String user, UserAccountDTO request) {
    return userAccountService.requestOpenAccount(operator, user, request.getAccountId(), request.getDescription());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/requestCloseAccount/{operator}/{user}")
  public String requestCloseAccount(String operator, String user) {
    return userAccountService.requestCloseAccount(operator, user);
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/requestDepositCurrency/{operator}/{user}/{tokenId}/{amount}")
  public String requestDepositCurrency(String operator, String user, String tokenId, BigDecimal amount) {
    return userAccountService.requestDepositCurrencyInstrument(operator, user, tokenId, amount);
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/requestWithdrawCurrency/{operator}/{user}")
  public String requestWithdrawCurrency(String operator, String user) {
    return userAccountService.requestWithdrawFungible(operator, user);
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getUserBalance")
  public UserHoldingFungibleGETDTO getUserHoldingFungible(GetBalanceDTO request) {
      return userAccountService.getUserHoldingFungible(request.getUser());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getAllUserSwapRequests")
  public List<SwapRequestGETDTO> getAllUserSwapRequests(GetSwapRequests request) {
      return userAccountService.getAllUserSwapRequests(request.getUser());
  }
}
