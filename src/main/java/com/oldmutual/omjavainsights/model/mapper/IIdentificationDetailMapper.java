package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.IdentificationDetail;
import com.oldmutual.omjavainsights.model.dto.IdentificationDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = ICountryMapper.class)
public interface IIdentificationDetailMapper {

    // todo add mapping needed for IdentificationDetail and IdentificationDetail dto differences
    IdentificationDetailDTO idDetailToIdDetailDTO(IdentificationDetail identificationDetail);

    // todo add mapping needed for IdentificationDetail and IdentificationDetail dto differences
    IdentificationDetail idDetailDTOToIdDetail(IdentificationDetailDTO identificationDetailDTO);

    //List Conversions
    List<IdentificationDetailDTO> idDetailListToIdDetailDTOList(List<IdentificationDetail> identificationDetails);
    List<IdentificationDetail> idDetailDTOListToIdDetailList(List<IdentificationDetailDTO> identificationDetailsDTO);
}
