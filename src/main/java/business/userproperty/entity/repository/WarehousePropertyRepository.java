package business.userproperty.entity.repository;

import java.util.List;

import business.userproperty.entity.model.WarehouseProperty;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class WarehousePropertyRepository implements PanacheRepositoryBase<WarehouseProperty, String>{

    public List<WarehouseProperty> findByPartyIdStartingWith(String partyIdPrefix) {
        return find("partyId like ?1", partyIdPrefix + "%").list();
    }
}
