package business.operator.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import business.operator.entity.model.Operator;

@Mapper(componentModel = "cdi")
public interface OperatorMapper {

    
    @Mapping(target = "contractId", source = "contractId")
    @Mapping(target = "partyId", source = "partyId")
    OperatorDTO toDTO(Operator operator);

    @Mapping(target = "contractId", source = "contractId")
    @Mapping(target = "partyId", source = "partyId")
    Operator fromDTO(OperatorDTO dto);
}
