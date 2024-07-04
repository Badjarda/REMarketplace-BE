package business.operator.dto;

import business.operator.entity.model.Operator;
import jakarta.enterprise.context.ApplicationScoped;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T09:28:33+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@ApplicationScoped
public class OperatorMapperImpl implements OperatorMapper {

    @Override
    public OperatorDTO toDTO(Operator operator) {
        if ( operator == null ) {
            return null;
        }

        OperatorDTO operatorDTO = new OperatorDTO();

        operatorDTO.setContractId( operator.getContractId() );
        operatorDTO.setPartyId( operator.getPartyId() );

        return operatorDTO;
    }

    @Override
    public Operator fromDTO(OperatorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Operator operator = new Operator();

        operator.setContractId( dto.getContractId() );
        operator.setPartyId( dto.getPartyId() );

        return operator;
    }
}
