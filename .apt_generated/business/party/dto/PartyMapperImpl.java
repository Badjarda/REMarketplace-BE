package business.party.dto;

import business.party.entity.model.Party;
import jakarta.enterprise.context.ApplicationScoped;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T09:28:33+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@ApplicationScoped
public class PartyMapperImpl implements PartyMapper {

    @Override
    public PartyDTO toDTO(Party party) {
        if ( party == null ) {
            return null;
        }

        PartyDTO partyDTO = new PartyDTO();

        partyDTO.setPartyName( party.getPartyName() );
        partyDTO.setPartyId( party.getPartyId() );

        return partyDTO;
    }

    @Override
    public Party fromDTO(PartyDTO partyDTO) {
        if ( partyDTO == null ) {
            return null;
        }

        Party party = new Party();

        party.setPartyName( partyDTO.getPartyName() );
        party.setPartyId( partyDTO.getPartyId() );

        return party;
    }
}
