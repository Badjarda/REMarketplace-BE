package business.custody.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.custody.entity.model.HoldingFactory;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class HoldingFactoryRepository implements PanacheRepositoryBase<HoldingFactory, String> {

}
