package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.dto.PartyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IPartyMapper {

    IPartyMapper INSTANCE = Mappers.getMapper(IPartyMapper.class);

    // todo add mapping needed for party and party dto differences
    PartyDTO partyToPartyDto(Party party);

    //todo add mapping needed for party and party dto differences
    Party partyDTOToParty(PartyDTO partyDTO);

    //List Conversions
    List<PartyDTO> partyListToPartyDTOList(List<Party> parties);
    List<Party> partyDTOListToPartyList(List<PartyDTO> partiesDTO);
}
