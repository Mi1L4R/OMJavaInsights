package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.DHAVerification;
import com.oldmutual.omjavainsights.model.dto.DHAVerificationDTO;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IDHAVerificationMapper {


    // todo add mapping needed for dhaVerification and dhaVerification dto differences
    DHAVerificationDTO dhaVerificationTodhaVerificationDTO(DHAVerification dhaVerification);

    // todo add mapping needed for dhaVerification and dhaVerification dto differences
    DHAVerification dhaVerificationDTOTodhaVerification(DHAVerificationDTO dhaVerificationDTO);

    //List Conversions
    List<DHAVerificationDTO> dhaListTodhaDTOList(List<DHAVerification> dhaVerifications);
    List<DHAVerification> dhaListDTOTodhaList(List<DHAVerificationDTO> dhaVerificationDTO);

}
