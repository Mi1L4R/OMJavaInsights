package com.oldmutual.omjavainsights.model.mapper;

import com.oldmutual.omjavainsights.model.TaxResidency;
import com.oldmutual.omjavainsights.model.dto.TaxResidencyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ICountryMapper.class)
public interface ITaxResidencyMapper {

    ITaxResidencyMapper INSTANCE = Mappers.getMapper(ITaxResidencyMapper.class);

    // todo add mapping needed for TaxResidency and TaxResidency dto
    TaxResidencyDTO taxResidencyToTaxResidencyDTO(TaxResidency taxResidency);

    // todo add mapping needed for TaxResidency and TaxResidency dto
    TaxResidency taxResidencyDTOToTaxResidency(TaxResidencyDTO taxResidencyDTO);

    //List Conversions
    List<TaxResidencyDTO> taxResListToTaxResDTOList(List<TaxResidency> taxResidencies);
    List<TaxResidency> taxResDTOListToTaxResList(List<TaxResidencyDTO> taxResidenciesDTO);
}