package business.party.entity.repository;


import business.party.entity.model.Party;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class PartyRepository implements PanacheRepositoryBase<Party, String> {
    
}
