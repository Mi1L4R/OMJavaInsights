package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.AssociatedParty;
import com.oldmutual.omjavainsights.model.dto.AssociatedPartyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = IPartyMapper.class)
public interface IAssociatedPartyMapper {

    // todo add mapping needed for associatedParty and associatedParty dto
    AssociatedPartyDTO assPartyToAssPartyDTO(AssociatedParty associatedParty);

    // todo add mapping needed for associatedParty and associatedParty dto
    AssociatedParty assPartyDTOToAssParty(AssociatedPartyDTO associatedPartyDTO);

    //List Conversions
    List<AssociatedPartyDTO> assPartyListToAssPartyDTOList(List<AssociatedParty> associatedParties);
    List<AssociatedParty> assPartyDTOListToAssPartyList(List<AssociatedPartyDTO> associatedPartiesDTO);
}
