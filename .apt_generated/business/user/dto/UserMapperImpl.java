package business.user.dto;

import business.user.entity.model.LedgerUser;
import jakarta.enterprise.context.ApplicationScoped;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T09:28:33+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@ApplicationScoped
public class UserMapperImpl implements UserMapper {

    @Override
    public LedgerUser toDTO(LedgerUser user) {
        if ( user == null ) {
            return null;
        }

        LedgerUser ledgerUser = new LedgerUser();

        ledgerUser.setUserName( user.getUserName() );
        ledgerUser.setPartyId( user.getPartyId() );

        return ledgerUser;
    }

    @Override
    public LedgerUser fromDTO(LedgerUser userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        LedgerUser ledgerUser = new LedgerUser();

        ledgerUser.setUserName( userDTO.getUserName() );
        ledgerUser.setPartyId( userDTO.getPartyId() );

        return ledgerUser;
    }
}
