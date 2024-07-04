package business.userprofile.entity.repository;

import business.userprofile.entity.model.ProfileServiceOffer;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfileServiceOfferRepository implements PanacheRepositoryBase<ProfileServiceOffer, String> {

}
