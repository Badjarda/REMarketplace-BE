package business.userproperty.entity.repository;

import java.util.List;

import business.userproperty.entity.model.ResidenceProperty;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ResidencePropertyRepository implements PanacheRepositoryBase<ResidenceProperty, String>{

    public List<ResidenceProperty> findByPartyIdStartingWith(String partyIdPrefix) {
        return find("partyId like ?1", partyIdPrefix + "%").list();
    }
}
