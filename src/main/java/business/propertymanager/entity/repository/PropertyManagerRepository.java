package business.propertymanager.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.propertymanager.entity.model.PropertyManager;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class PropertyManagerRepository implements PanacheRepositoryBase<PropertyManager, String> {

}
