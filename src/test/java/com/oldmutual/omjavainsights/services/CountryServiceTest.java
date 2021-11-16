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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CountryServiceTest {

    public static final Long ID = 123L;
    public static final String CODE = "Code1";
    public static final String CLASSIFICATION = "Classified";

    @MockBean
    CountryService countryService;

    @MockBean
    ICountryRepository countryRepository;

    //mappers
    @SpyBean
    ICountryMapper countryMapper;

    @BeforeEach
    void setUp() {
        countryService = new CountryService(countryMapper, countryRepository);
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