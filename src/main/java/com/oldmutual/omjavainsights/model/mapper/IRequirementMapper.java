package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.Requirement;
import com.oldmutual.omjavainsights.model.dto.RequirementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(uses = ICountryMapper.class)
public interface IRequirementMapper {

    IRequirementMapper INSTANCE = Mappers.getMapper(IRequirementMapper.class);


    // todo add mapping needed for requirement and requirement dto differences
    RequirementDTO requirementToRequirementDTO(Requirement requirement);

    // todo add mapping needed for requirement and requirement dto differences
    Requirement requirementDTOToRequirement(RequirementDTO requirementDTO);

    List<RequirementDTO> requirementListToRequirementDTOList(List<Requirement> requirements);
    List<Requirement> requirementDTOListToRequirementList(List<RequirementDTO> requirementsDTO);

}
