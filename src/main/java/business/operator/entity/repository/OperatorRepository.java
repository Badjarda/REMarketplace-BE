package business.operator.entity.repository;

import business.operator.entity.model.Operator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
@Transactional
public class OperatorRepository implements PanacheRepositoryBase<Operator, String>{   
    
}