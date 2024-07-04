package business.rolemanager.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.rolemanager.entity.model.UserRoleFactory;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserRoleFactoryRepository implements PanacheRepositoryBase<UserRoleFactory, String> {

}
