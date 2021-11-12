package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.Requirement;
import com.oldmutual.omjavainsights.model.RequirementsWrapper;
import com.oldmutual.omjavainsights.model.Role;
import com.oldmutual.omjavainsights.model.mapper.IRequirementMapper;
import com.oldmutual.omjavainsights.model.mapper.IRequirementsWrapperMapper;
import com.oldmutual.omjavainsights.model.mapper.IRoleMapper;
import com.oldmutual.omjavainsights.repositories.IRequirementsWrapperRepository;
import com.oldmutual.omjavainsights.services.interfaces.IRequirementsWrapperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RequirementsWrapperServiceTest {

    public static final Long ID = 1L;
    public static final Role ROLE = Role.builder()
            .roleId(1L)
            .roleDescription("role description")
            .roleCategory("role category")
            .screeningRole("screening role")
            .determinedNationality("South African")
            .build();
    public static final Boolean FULLREQUIREMENTS = true;
    public static final String PARTYCAT = "Party Categorization";
    public static final List<Requirement> REQUIREMENTS = Arrays.asList(
            Requirement.builder()
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
                    .build()
    );
    public static  final String RRDFAT = "RiskRatingDoneFOrActiveTransactions";
    public static  final String SDFAT = "ScreeningDoneFOrActiveTransactions";
    public static  final String HADMARKERS = "This may be removed";

    IRequirementsWrapperService requirementsWrapperService;

    @Mock
    IRequirementsWrapperRepository requirementsWrapperRepository;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        requirementsWrapperService = new RequirementsWrapperService(IRequirementsWrapperMapper.INSTANCE, requirementsWrapperRepository);
    }

    @Test
    void getRWById() {

        //given
        var reqWrapper = RequirementsWrapper.builder()
                .requirementsWrapperId(ID)
                .roleInTransaction(ROLE)
                .fullRequirements(FULLREQUIREMENTS)
                .partyCategorization(PARTYCAT)
                .requirementsOutput(REQUIREMENTS)
                .riskRatingDoneForActiveTransactions(RRDFAT)
                .screeningDoneForActiveTransactions(SDFAT)
                .hadMarkers(HADMARKERS)
                .build();

        //when
        when(requirementsWrapperRepository.findById(1L)).thenReturn(Optional.of(reqWrapper));
        var reqWrapperDTO = requirementsWrapperService.getRWById(ID);

        //then
        assertAll("Assert that repo retrieved a Requirement and successfully mapped it (Needs to map types as well)",
                () -> assertEquals(ID, reqWrapperDTO.getRequirementsWrapperId()),
                () -> assertEquals(IRoleMapper.INSTANCE.roleToRoleDTO(ROLE), reqWrapperDTO.getRoleInTransaction()),
                () -> assertEquals(FULLREQUIREMENTS, reqWrapperDTO.getFullRequirements()),
                () -> assertEquals(PARTYCAT, reqWrapperDTO.getPartyCategorization()),
                () -> assertEquals(IRequirementMapper.INSTANCE.requirementListToRequirementDTOList(REQUIREMENTS), reqWrapperDTO.getRequirementsOutput()),
                () -> assertEquals(RRDFAT, reqWrapperDTO.getRiskRatingDoneForActiveTransactions()),
                () -> assertEquals(SDFAT, reqWrapperDTO.getScreeningDoneForActiveTransactions()),
                () -> assertEquals(HADMARKERS, reqWrapperDTO.getHadMarkers())

        );
    }
}