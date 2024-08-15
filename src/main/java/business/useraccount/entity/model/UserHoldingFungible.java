package business.useraccount.entity.model;

import java.math.BigDecimal;

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
public class UserHoldingFungible {
  @Id
  private String partyId;

  @Column(name = "contractId")
  private String contractId;

  @Column(name = "amount")
  private BigDecimal amount;
}