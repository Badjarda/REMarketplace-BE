package business.issuer.entity.repository;

import business.issuer.entity.model.IssuanceServiceOffer;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class IssuanceServiceOfferRepository implements PanacheRepositoryBase<IssuanceServiceOffer, String> {

}
