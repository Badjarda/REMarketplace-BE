package business.issuance.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.issuance.entity.model.IssuanceManager;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class IssuanceManagerRepository implements PanacheRepositoryBase<IssuanceManager, String> {

}