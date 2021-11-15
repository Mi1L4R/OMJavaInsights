package com.oldmutual.omjavainsights.model.mapper;


import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICountryMapper {

    // todo add mapping needed for country and country dto differences
    CountryDTO countryToCountryDTO(Country country);

    // todo add mapping needed for country and country dto differences
    Country countryDtoToCountry(CountryDTO countryDTO);

    //List Conversions
    List<CountryDTO> countryListToCountryListDTO(List<Country> countries);
    List<Country> countryListDTOToCountryList(List<CountryDTO> countriesDTO);
}
