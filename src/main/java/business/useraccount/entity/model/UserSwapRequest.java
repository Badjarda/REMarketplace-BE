package business.useraccount.entity.model;

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

  @Column(name = "buyerId")
  private String buyerId;

  @Column(name = "sellerId")
  private String sellerId;

  @Column(name = "propertyType")
  private String propertyType;

  @Column(name = "transferableCid")
  private String transferableCid;

  @Column(name = "postalCode")
  private String postalCode;
}
