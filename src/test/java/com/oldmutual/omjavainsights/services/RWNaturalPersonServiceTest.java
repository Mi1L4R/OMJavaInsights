package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.*;
import com.oldmutual.omjavainsights.model.mapper.IRWNaturalPersonMapper;
import com.oldmutual.omjavainsights.model.mapper.IRequirementsWrapperMapper;
import com.oldmutual.omjavainsights.repositories.IRWNaturalPersonRepository;
import com.oldmutual.omjavainsights.services.interfaces.IRWNaturalPersonService;
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

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RWNaturalPersonServiceTest {

    public static final Long ID = 1L;
    public static final RequirementsWrapper REQUIREMENTSWRAPPER = RequirementsWrapper.builder()
            .requirementsWrapperId(1L)
            .roleInTransaction(Role.builder()
                    .roleId(1L)
                    .roleCategory("RoleCategory")
                    .roleDescription("RoleDescription")
                    .screeningRole("ScreeningRole")
                    .determinedNationality("South Africa")
                    .build())
            .fullRequirements(true)
            .requirementsOutput(Arrays.asList(Requirement.builder()
                            .requirementId(1L)
                            .status("Status1")
                            .country(Country.builder().countryId(1L).countryCode("code1").countryClassification("classified1").build())
                            .requirementsCategory("reqCategory1")
                            .requirementsType("reqType1")
                            .requirementsSubType("reqSubType1")
                            .regulation("regulation1")
                            .adjacency("adjacency1")
                            .createdDate(new Date())
                            .newRequirement(true)
                            .build(),
                    Requirement.builder()
                            .requirementId(2L)
                            .status("Status2")
                            .country(Country.builder().countryId(1L).countryCode("code1").countryClassification("classified1").build())
                            .requirementsCategory("reqCategory2")
                            .requirementsType("reqType2")
                            .requirementsSubType("reqSubType2")
                            .regulation("regulation2")
                            .adjacency("adjacency2")
                            .createdDate(new Date())
                            .newRequirement(false)
                            .build()))
            .riskRatingDoneForActiveTransactions("RiskRatingDoneForActiveTransactions")
            .screeningDoneForActiveTransactions("ScreeningDoneForActiveTransactions")
            .hadMarkers("Markers")
            .build();
    private static final String DECISIONID = "DecisionId";

    @MockBean
    RWNaturalPersonService rwNaturalPersonService;

    @MockBean
    IRWNaturalPersonRepository rwNaturalPersonRepository;

    //Mappers
    @SpyBean
    IRWNaturalPersonMapper rwNaturalPersonMapper;

    @SpyBean
    IRequirementsWrapperMapper requirementsWrapperMapper;


    @BeforeEach
    void setUp() {

        rwNaturalPersonService = new RWNaturalPersonService(rwNaturalPersonMapper,rwNaturalPersonRepository);
    }

    @Test
    void getRWNaturalPersonById() {

        //given
        var rwNatPer = RWNaturalPerson.builder()
                .rwNaturalPersonId(ID)
                .requirementsWrapper(REQUIREMENTSWRAPPER)
                .decisionId(DECISIONID)
                .build();

        //when
        when(rwNaturalPersonRepository.findById(1L)).thenReturn(Optional.of(rwNatPer));
        var rwNatPerDTO = rwNaturalPersonService.getRWNaturalPersonById(ID);

        //then
        assertAll("Assert that repo retrieved a IdentificationDetail and successfully mapped it",
                () -> assertEquals(ID, rwNatPerDTO.getRwNaturalPersonId()),
                () -> assertEquals(requirementsWrapperMapper.rwTorwDTO(REQUIREMENTSWRAPPER), rwNatPerDTO.getRequirementsWrapper()),
                () -> assertEquals(DECISIONID, rwNatPer.getDecisionId())
                );
    }
}