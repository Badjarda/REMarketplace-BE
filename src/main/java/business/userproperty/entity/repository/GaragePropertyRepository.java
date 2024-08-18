package business.userproperty.entity.repository;

import java.util.List;

import business.userproperty.entity.model.GarageProperty;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class GaragePropertyRepository implements PanacheRepositoryBase<GarageProperty, String>{

    public List<GarageProperty> findByPartyIdStartingWith(String partyIdPrefix) {
        return find("partyId like ?1", partyIdPrefix + "%").list();
    }
}
