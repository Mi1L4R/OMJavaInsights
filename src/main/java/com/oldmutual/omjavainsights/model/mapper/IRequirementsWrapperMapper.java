package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.RequirementsWrapper;
import com.oldmutual.omjavainsights.model.dto.RequirementsWrapperDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {
        IRequirementMapper.class,
        IRoleMapper.class
})
public interface IRequirementsWrapperMapper {

    IRequirementsWrapperMapper INSTANCE = Mappers.getMapper(IRequirementsWrapperMapper.class);

    // todo add mapping needed for contract and contract dto
    RequirementsWrapperDTO rwTorwDTO(RequirementsWrapper requirementsWrapper);

    // todo add mapping needed for contract and contract dto
    RequirementsWrapper rwDTOTorw(RequirementsWrapperDTO requirementsWrapperDTO);

    //List Conversions
    List<RequirementsWrapperDTO> reqWrapListToReqWrapDTOList(List<RequirementsWrapper> requirementsWrappers);
    List<RequirementsWrapper> reqWrapDTOListToReqWrapList(List<RequirementsWrapperDTO> requirementsWrappersDTO);
}
