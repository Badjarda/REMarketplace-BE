package business.userprofile.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.userprofile.entity.model.UserProfile;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserProfileRepository implements PanacheRepositoryBase<UserProfile, String> {
    
}
