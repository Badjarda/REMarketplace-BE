package business.userrole.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.userrole.entity.model.UserRoleInterface;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserRoleInterfaceRepository implements PanacheRepositoryBase<UserRoleInterface, String> {

}
