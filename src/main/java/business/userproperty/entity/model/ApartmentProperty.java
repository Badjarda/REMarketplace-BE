package business.userproperty.entity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class ApartmentProperty {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(name = "partyId")
  private String partyId;

  @Column(name = "contractId")
  private String contractId;

  @Column(name = "propertyId")
  private String propertyId;

  public ApartmentProperty(String partyId, String contractId, String propertyId) {
    this.partyId = partyId;
    this.contractId = contractId;
    this.propertyId = propertyId;
  }
}
