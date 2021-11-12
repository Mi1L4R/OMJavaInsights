package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.mapper.ICountryMapper;
import com.oldmutual.omjavainsights.repositories.ICountryRepository;
import com.oldmutual.omjavainsights.services.interfaces.ICountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CountryServiceTest {

    public static final Long ID = 123L;
    public static final String CODE = "Code1";
    public static final String CLASSIFICATION = "Classified";

    ICountryService countryService;

    @Mock
    ICountryRepository countryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        countryService = new CountryService(ICountryMapper.INSTANCE, countryRepository);
    }

    @Test
    void getCountryById() {

        //given
        var country = Country.builder()
                .countryId(ID)
                .countryCode(CODE)
                .countryClassification(CLASSIFICATION)
                .build();

        //when
        when(countryRepository.findById(123L)).thenReturn(Optional.of(country));
        var countryDTO = countryService.getCountryById(ID);

        //then
        assertAll("Assert that repo retrieved a country and successfully mapped it",
                () -> assertEquals(ID, countryDTO.getCountryId()),
                () -> assertEquals(CODE, countryDTO.getCountryCode()),
                () -> assertEquals(CLASSIFICATION, countryDTO.getCountryClassification())
        );
    }
}