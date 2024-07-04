package business.userproperty.entity.repository;

import business.userproperty.entity.model.LandProperty;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class LandPropertyRepository implements PanacheRepositoryBase<LandProperty, String>{
}
