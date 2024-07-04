package business.propertymanager.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.propertymanager.entity.model.ResidencePropertyFactory;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class ResidencePropertyFactoryRepository implements PanacheRepositoryBase<ResidencePropertyFactory, String> {

}
