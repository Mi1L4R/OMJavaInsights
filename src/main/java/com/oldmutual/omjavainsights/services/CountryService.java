package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.dto.ContractDTO;
import com.oldmutual.omjavainsights.model.dto.CountryDTO;
import com.oldmutual.omjavainsights.model.mapper.ICountryMapper;
import com.oldmutual.omjavainsights.repositories.ICountryRepository;
import com.oldmutual.omjavainsights.services.interfaces.ICountryService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CountryService implements ICountryService {

    private final ICountryMapper countryMapper;
    private final ICountryRepository countryRepository;

    public CountryService(ICountryMapper countryMapper, ICountryRepository countryRepository) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
    }

    @Override
    public CountryDTO getCountryById(Long id) {
        try {

            var country = countryRepository.findById(id).get();
            return countryMapper.countryToCountryDTO(country);
        } catch (Exception e) {

            //todo implement logging
            return new CountryDTO();
        }
    }
}
