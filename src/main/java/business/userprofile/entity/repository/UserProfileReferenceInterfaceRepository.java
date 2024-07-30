package business.userprofile.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.userprofile.entity.model.UserProfileReferenceInterface;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserProfileReferenceInterfaceRepository implements PanacheRepositoryBase<UserProfileReferenceInterface, String> {
    
}
