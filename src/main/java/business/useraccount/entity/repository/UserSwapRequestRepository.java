package business.useraccount.entity.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

import business.useraccount.entity.model.UserSwapRequest;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserSwapRequestRepository implements PanacheRepositoryBase<UserSwapRequest, String> {

    public List<UserSwapRequest> findByPartyIdStartingWith(String partyIdPrefix) {
        return find("partyId like ?1", partyIdPrefix + "%").list();
    }
    
}
