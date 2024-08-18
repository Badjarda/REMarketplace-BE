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
public class UserHoldingTransferable {
  @Id
  private String partyId;

  @Column(name = "contractId")
  private String contractId;

  @Column(name = "postalCode")
  private String postalCode;

  @Column(name = "propertyType")
  private String propertyType;
}