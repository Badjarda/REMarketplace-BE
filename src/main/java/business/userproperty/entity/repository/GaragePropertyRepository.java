package business.userproperty.entity.repository;

import business.userproperty.entity.model.GarageProperty;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class GaragePropertyRepository implements PanacheRepositoryBase<GarageProperty, String>{
}
