package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.IdentificationDetail;
import com.oldmutual.omjavainsights.model.mapper.ICountryMapper;
import com.oldmutual.omjavainsights.model.mapper.IIdentificationDetailMapper;
import com.oldmutual.omjavainsights.repositories.IIdentificationDetailRepository;
import com.oldmutual.omjavainsights.services.interfaces.IIdentificationDetailService;
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
class IdentificationDetailServiceTest {

    public static final Long ID =1L;
    public static final String IDNUMBER = "1234567";
    public static final String IDTYPE = "Type1";
    public static final Country COUNTRYOFISSUE = Country.builder().countryId(1L).countryCode("Code1").countryClassification("Classified").build();
    public static final String VISATYPE ="Visa1";
    public static final Date DATEOFEXPIRY = new Date();
    public static final Date MODIFIEDON = new Date();

    @InjectMocks
    IdentificationDetailService identificationDetailService;

    @Mock
    IIdentificationDetailRepository identificationDetailRepository;

    @Spy
    IIdentificationDetailMapper identificationDetailMapper;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getIdDetailById() {

        //given
        var idDetail = IdentificationDetail.builder()
                .identificationDetailId(ID)
                .idNumber(IDNUMBER)
                .idType(IDTYPE)
                .countryOfIssue(COUNTRYOFISSUE)
                .visaPermitType(VISATYPE)
                .dateOfExpiry(DATEOFEXPIRY)
                .modifiedOn(MODIFIEDON)
                .build();

        //when
        when(identificationDetailRepository.findById(1L)).thenReturn(Optional.of(idDetail));
        var idDetailDTO = identificationDetailService.getIdDetailById(ID);

        //then
        assertAll("Assert that repo retrieved a IdentificationDetail and successfully mapped it",
                () -> assertEquals(ID, idDetailDTO.getIdentificationDetailId()),
                () -> assertEquals(IDNUMBER, idDetailDTO.getIdNumber()),
                () -> assertEquals(IDTYPE, idDetailDTO.getIdType()),
                () -> assertEquals(COUNTRYOFISSUE, idDetailDTO.getCountryOfIssue()),
                () -> assertEquals(VISATYPE, idDetailDTO.getVisaPermitType()),
                () -> assertEquals(DATEOFEXPIRY, idDetailDTO.getDateOfExpiry()),
                () -> assertEquals(MODIFIEDON, idDetailDTO.getModifiedOn())
                );
    }
}