package business.userrole.entity.repository;

import business.userrole.entity.model.UserRoleOffer;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UserRoleOfferRepository implements PanacheRepositoryBase<UserRoleOffer, String> {

}
