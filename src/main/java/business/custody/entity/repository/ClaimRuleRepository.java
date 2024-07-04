package business.custody.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.custody.entity.model.ClaimRule;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class ClaimRuleRepository implements PanacheRepositoryBase<ClaimRule, String> {

}
