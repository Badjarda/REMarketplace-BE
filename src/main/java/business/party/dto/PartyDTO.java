package business.party.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartyDTO {

    private String partyName;
    private String partyId;

    @Override
    public String toString() {
        return "PartyDTO{" +
                "partyName='" + partyName + '\'' +
                ", partyId='" + partyId + '\'' +
                '}';
    }
}
