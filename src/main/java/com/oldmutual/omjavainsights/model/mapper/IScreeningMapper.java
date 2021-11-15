package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.Screening;
import com.oldmutual.omjavainsights.model.dto.ScreeningDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IScreeningMapper {

    // todo add mapping needed for Screening and Screening dto differences
    ScreeningDTO screeningToScreeningDTO(Screening screening);

    // todo add mapping needed for Screening and Screening dto differences
    Screening screeningDTOToScreening(ScreeningDTO screeningDTO);

    //List Conversions
    List<ScreeningDTO> screeningListToScreeningDTOList(List<Screening> screenings);
    List<Screening> screeningDTOListToScreeningList(List<ScreeningDTO> screeningsDTO);
}
