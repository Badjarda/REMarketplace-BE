package business.profilemanager.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.profilemanager.entity.model.UserProfileManager;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserProfileManagerRepository implements PanacheRepositoryBase<UserProfileManager, String> {

}
