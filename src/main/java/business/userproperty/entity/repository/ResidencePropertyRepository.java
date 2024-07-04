package business.userproperty.entity.repository;

import business.userproperty.entity.model.ResidenceProperty;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ResidencePropertyRepository implements PanacheRepositoryBase<ResidenceProperty, String>{
}
