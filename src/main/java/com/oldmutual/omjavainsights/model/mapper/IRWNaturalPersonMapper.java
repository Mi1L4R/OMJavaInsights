package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.RWNaturalPerson;
import com.oldmutual.omjavainsights.model.dto.RWNaturalPersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = IRequirementsWrapperMapper.class)
public interface IRWNaturalPersonMapper {

    // todo add mapping needed for RWNaturalPerson and RWNaturalPerson dto differences
    RWNaturalPersonDTO rwNatPerTorwNatPerDTO(RWNaturalPerson rwNaturalPerson);

    // todo add mapping needed for RWNaturalPerson and RWNaturalPerson dto differences
    RWNaturalPerson rwNatPerDTOTorwNatPer(RWNaturalPersonDTO rwNaturalPersonDTO);

    //List Conversions
    List<RWNaturalPersonDTO> rwNatPerListToRWNatPerDTOList(List<RWNaturalPerson> rwNaturalPersons);
    List<RWNaturalPerson> rwNatPerDTOListToRWNatPerList(List<RWNaturalPersonDTO> rwNaturalPersonsDTO);
}
