package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Screening;
import com.oldmutual.omjavainsights.model.mapper.IScreeningMapper;
import com.oldmutual.omjavainsights.repositories.IScreeningRepository;
import com.oldmutual.omjavainsights.services.interfaces.IScreeningService;
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
class ScreeningServiceTest {

    private static final Long ID = 1L;
    private static final String AMEOUTCOME = "ameOutcome";
    private static final String AMLOUTCOME = "amlOutcome";
    private static final Date DATEREQUESTED = new Date();
    private static final String SANCTIONSOUTCOME = "SanctionsOutcome";
    private static final String SCREENINGSTATUS = "ScreeningStatus";
    private static final String DPIPOUTCOME = "dpipOutcome";
    private static final String FPPOOUTCOME = "fppoOutcome";
    private static final String RCAFPPOOUTCOME = "rcafppoOutcome";
    private static final String RCADPIPOUTCOME = "rcadpipOutcome";
    private static final String SCREENINGRESULTTYPE = "screeningResultType";
    public static final Date MODIFIEDON = new Date();

    @InjectMocks
    ScreeningService screeningService;

    @Mock
    IScreeningRepository screeningRepository;

    @Spy
    IScreeningMapper screeningMapper;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

    }

    @Test
    void getScreeningById() {

        //given
        var screening = Screening.builder()
                .screeningId(ID)
                .ameOutcome(AMEOUTCOME)
                .amlOutcome(AMLOUTCOME)
                .dateRequested(DATEREQUESTED)
                .sanctionsOutcome(SANCTIONSOUTCOME)
                .screeningStatus(SCREENINGSTATUS)
                .dpipOutcome(DPIPOUTCOME)
                .fppoOutcome(FPPOOUTCOME)
                .rcafppoOutcome(RCAFPPOOUTCOME)
                .rcadpipOutcome(RCADPIPOUTCOME)
                .screeningResultType(SCREENINGRESULTTYPE)
                .modifiedOn(MODIFIEDON)
                .build();

        //when
        when(screeningRepository.findById(1L)).thenReturn(Optional.of(screening));
        var screeningDTO = screeningService.getScreeningById(ID);

        //then
        assertAll("Assert that repo retrieved a Screening and successfully mapped it",
                () -> assertEquals(ID, screeningDTO.getScreeningId()),
                () -> assertEquals(AMEOUTCOME, screeningDTO.getAmeOutcome()),
                () -> assertEquals(AMLOUTCOME, screeningDTO.getAmlOutcome()),
                () -> assertEquals(DATEREQUESTED, screeningDTO.getDateRequested()),
                () -> assertEquals(SANCTIONSOUTCOME, screeningDTO.getSanctionsOutcome()),
                () -> assertEquals(SCREENINGSTATUS, screeningDTO.getScreeningStatus()),
                () -> assertEquals(DPIPOUTCOME, screeningDTO.getDpipOutcome()),
                () -> assertEquals(FPPOOUTCOME, screeningDTO.getFppoOutcome()),
                () -> assertEquals(RCAFPPOOUTCOME, screeningDTO.getRcafppoOutcome()),
                () -> assertEquals(RCADPIPOUTCOME, screeningDTO.getRcadpipOutcome()),
                () -> assertEquals(SCREENINGRESULTTYPE, screeningDTO.getScreeningResultType()),
                () -> assertEquals(MODIFIEDON, screeningDTO.getModifiedOn())
                );
    }
}