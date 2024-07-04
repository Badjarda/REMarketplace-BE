package business.issuer.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import business.issuer.entity.model.DeIssueRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class DeIssueRequestRepository implements PanacheRepositoryBase<DeIssueRequest, String> {

}
