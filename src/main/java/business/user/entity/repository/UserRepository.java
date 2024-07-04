package business.user.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.user.entity.model.LedgerUser;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserRepository implements PanacheRepositoryBase<LedgerUser, String> {
    
}
