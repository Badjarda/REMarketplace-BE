package business.useraccount.entity.repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.useraccount.entity.model.UserAccount;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserAccountRepository implements PanacheRepositoryBase<UserAccount, String>{
    
}
