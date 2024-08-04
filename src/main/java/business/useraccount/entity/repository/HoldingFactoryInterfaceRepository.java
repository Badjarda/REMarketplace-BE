package business.useraccount.entity.repository;

import business.useraccount.entity.model.HoldingFactoryInterface;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class HoldingFactoryInterfaceRepository implements PanacheRepositoryBase<HoldingFactoryInterface, String> {

}
