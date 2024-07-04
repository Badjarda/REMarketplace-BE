package business.custody.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.custody.entity.model.RouteProvider;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class RouteProviderRepository implements PanacheRepositoryBase<RouteProvider, String> {

}
