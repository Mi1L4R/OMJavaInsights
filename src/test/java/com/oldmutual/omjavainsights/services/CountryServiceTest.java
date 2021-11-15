package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.mapper.ICountryMapper;
import com.oldmutual.omjavainsights.repositories.ICountryRepository;
import com.oldmutual.omjavainsights.services.interfaces.ICountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    public static final Long ID = 123L;
    public static final String CODE = "Code1";
    public static final String CLASSIFICATION = "Classified";

    @InjectMocks
    CountryService countryService;

    @Mock
    ICountryRepository countryRepository;

    @Spy
    ICountryMapper countryMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
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