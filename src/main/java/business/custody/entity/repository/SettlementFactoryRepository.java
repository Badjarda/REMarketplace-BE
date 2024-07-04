package business.custody.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.custody.entity.model.SettlementFactory;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class SettlementFactoryRepository implements PanacheRepositoryBase<SettlementFactory, String> {

}
