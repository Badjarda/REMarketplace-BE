package business.userproperty.entity.model;

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
public class PropertyServiceOffer {
  @Id
  @Column(columnDefinition = "TEXT")
  private String key;

  @Column(name = "contractId")
  private String contractId;
}
