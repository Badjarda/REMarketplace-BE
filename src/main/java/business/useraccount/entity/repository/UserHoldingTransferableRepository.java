package business.useraccount.entity.repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

import business.useraccount.entity.model.UserHoldingTransferable;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class UserHoldingTransferableRepository implements PanacheRepositoryBase<UserHoldingTransferable, String> {
    public List<UserHoldingTransferable> findByPartyIdStartingWith(String partyIdPrefix) {
        return find("partyId like ?1", partyIdPrefix + "%").list();
    }
}
