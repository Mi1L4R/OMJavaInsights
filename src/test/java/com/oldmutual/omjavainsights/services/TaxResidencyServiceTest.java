package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.TaxResidency;
import com.oldmutual.omjavainsights.model.dto.CountryDTO;
import com.oldmutual.omjavainsights.model.mapper.ICountryMapper;
import com.oldmutual.omjavainsights.model.mapper.ITaxResidencyMapper;
import com.oldmutual.omjavainsights.repositories.ITaxResidencyRepository;
import com.oldmutual.omjavainsights.services.interfaces.ITaxResidencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaxResidencyServiceTest {

    private static final Long ID = 1L;
    private static final Country COUNTRYOFTR = Country.builder()
            .countryId(1L)
            .countryCode("code1")
            .countryClassification("countryClassification1")
            .build();
    private static final String COUNTRYOFTAXREFNUMBER = "countryOfTaxReferenceNumber";
    private static final String IDENTIFICATIONNUM = "ID number";
    private static final String SCDREASON = "selfCertificationDeclarationReason";
    private static final Date SCDDATE = new Date();

    @InjectMocks
    TaxResidencyService taxResidencyService;

    @Mock
    ITaxResidencyRepository taxResidencyRepository;

    @Spy
    ITaxResidencyMapper taxResidencyMapper;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTaxResidencyById() {

        //given
        var taxRes = TaxResidency.builder()
                .taxResidencyId(ID)
                .countryOfTaxResidency(COUNTRYOFTR)
                .countryOfTaxReferenceNumber(COUNTRYOFTAXREFNUMBER)
                .taxIdentificationNumber(IDENTIFICATIONNUM)
                .selfCertificationDeclarationReason(SCDREASON)
                .selfCertificationDeclarationDate(SCDDATE)
                .build();

        //when
        when(taxResidencyRepository.findById(1L)).thenReturn(Optional.of(taxRes));
        var taxResDTO = taxResidencyService.getTaxResidencyById(ID);

        //then
        assertAll("Assert that repo retrieved a TaxResidency and successfully mapped it",
                () -> assertEquals(ID, taxResDTO.getTaxResidencyId()),
                () -> assertEquals(COUNTRYOFTR, taxResDTO.getCountryOfTaxResidency()),
                () -> assertEquals(COUNTRYOFTAXREFNUMBER, taxResDTO.getCountryOfTaxReferenceNumber()),
                () -> assertEquals(IDENTIFICATIONNUM, taxResDTO.getTaxIdentificationNumber()),
                () -> assertEquals(SCDREASON, taxResDTO.getSelfCertificationDeclarationReason()),
                () -> assertEquals(SCDDATE, taxResDTO.getSelfCertificationDeclarationDate())
                );
    }
}