package business.useraccount.entity.model;

import java.math.BigDecimal;

import daml.daml.finance.interface$.holding.transferable.Transferable;
import daml.daml.finance.interface$.types.common.types.AccountKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSwapRequest {
  @Id 
  @Column(length=500)
  private String partyId;

  @Column(name = "contractId", length=500)
  private String contractId;

  @Column(name = "buyer")
  public String buyer;

  @Column(name = "seller")
  public String seller;

  @Column(name = "sellerAccount")
  public AccountKey sellerAccount;

  @Column(name = "buyerAccount")
  public AccountKey buyerAccount;

  @Column(name = "fungibleHoldingCid")
  public Transferable.ContractId fungibleHoldingCid;

  @Column(name = "fungibleAmount")
  public BigDecimal fungibleAmount;

  @Column(name = "transferableHoldingCid")
  public Transferable.ContractId transferableHoldingCid;
}
