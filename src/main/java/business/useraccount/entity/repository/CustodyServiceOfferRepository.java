package business.useraccount.entity.repository;

import business.useraccount.entity.model.CustodyServiceOffer;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CustodyServiceOfferRepository implements PanacheRepositoryBase<CustodyServiceOffer, String> {

}
