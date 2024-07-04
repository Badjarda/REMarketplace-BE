package business.useraccount.entity.repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.useraccount.entity.model.UserAccountWithdrawRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserAccountWithdrawRequestRepository implements PanacheRepositoryBase<UserAccountWithdrawRequest, String> {
    
}
