package business.user.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import business.user.entity.model.LedgerUser;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "partyId", source = "partyId")
    LedgerUser toDTO(LedgerUser user);

    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "partyId", source = "partyId")
    LedgerUser fromDTO(LedgerUser userDTO);
}
