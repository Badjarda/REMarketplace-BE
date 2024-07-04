package business.userrole.entity.model;

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
public class UserRole {

  @Id
  private String key;

  @Column(name = "contractId")
  private String contractId;

  @Column(name = "roleId")
  private String roleId;

}
