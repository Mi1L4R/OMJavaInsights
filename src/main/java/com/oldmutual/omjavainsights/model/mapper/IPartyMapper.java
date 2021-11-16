package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPartyMapper {

    // todo add mapping needed for party and party dto differences
    PartyDTO partyToPartyDTO(Party party);

    //todo add mapping needed for party and party dto differences
    Party partyDTOToParty(PartyDTO partyDTO);

    //List Conversions
    List<PartyDTO> partyListToPartyDTOList(List<Party> parties);
    List<Party> partyDTOListToPartyList(List<PartyDTO> partiesDTO);
}
