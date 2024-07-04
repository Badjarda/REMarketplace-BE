package business.rolemanager.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.rolemanager.entity.model.UserRoleManager;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserRoleManagerRepository implements PanacheRepositoryBase<UserRoleManager, String> {

}
