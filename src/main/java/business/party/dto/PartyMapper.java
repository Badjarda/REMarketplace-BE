package business.party.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import business.party.entity.model.Party;

@Mapper(componentModel = "cdi")
public interface PartyMapper {

    @Mapping(target = "partyName", source = "partyName")
    @Mapping(target = "partyId", source = "partyId")
    PartyDTO toDTO(Party party);

    @Mapping(target = "partyName", source = "partyName")
    @Mapping(target = "partyId", source = "partyId")
    Party fromDTO(PartyDTO partyDTO);
}
