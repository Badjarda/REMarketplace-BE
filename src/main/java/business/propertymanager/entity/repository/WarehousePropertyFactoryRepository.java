package business.propertymanager.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.propertymanager.entity.model.WarehousePropertyFactory;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class WarehousePropertyFactoryRepository implements PanacheRepositoryBase<WarehousePropertyFactory, String> {

}
