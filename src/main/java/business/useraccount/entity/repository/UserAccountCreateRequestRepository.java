package business.useraccount.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.useraccount.entity.model.UserAccountCreateRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserAccountCreateRequestRepository implements PanacheRepositoryBase<UserAccountCreateRequest, String>{
    
}
