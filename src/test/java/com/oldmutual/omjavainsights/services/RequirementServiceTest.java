package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.Requirement;
import com.oldmutual.omjavainsights.model.mapper.IContractRoleMapper;
import com.oldmutual.omjavainsights.model.mapper.ICountryMapper;
import com.oldmutual.omjavainsights.model.mapper.IRequirementMapper;
import com.oldmutual.omjavainsights.repositories.IRequirementRepository;
import com.oldmutual.omjavainsights.services.interfaces.IRequirementService;
import lombok.Data;
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

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RequirementServiceTest {

    public static final Long ID = 1L;
    public static final String STATUS = "Status";
    public static final Country COUNTRY = Country.builder().countryId(1L).countryCode("211").countryClassification("Classified").build();
    public static final String REQCATEGORY = "Category";
    public static final String REQTYPE = "Type";
    public static final String REQSUBTYPE = "SubType";
    public static final String REGULATION= "Regulation";
    public static final String ADJACENCY = "Adjacency";
    public static final Date CREATEDDATE = new Date();
    public static final Boolean NEWREQ = true;

    @MockBean
    RequirementService requirementService;

    @MockBean
    IRequirementRepository requirementRepository;

    //mappers
    @SpyBean
    IRequirementMapper requirementMapper;

    @SpyBean
    ICountryMapper countryMapper;

    @BeforeEach
    void setUp() {

        requirementService = new RequirementService(requirementMapper, requirementRepository);
    }

    @Test
    void getRequirementById() {

        //given
        var requirement = Requirement.builder()
                .requirementId(ID)
                .status(STATUS)
                .country(COUNTRY)
                .requirementsCategory(REQCATEGORY)
                .requirementsType(REQTYPE)
                .requirementsSubType(REQSUBTYPE)
                .regulation(REGULATION)
                .adjacency(ADJACENCY)
                .createdDate(CREATEDDATE)
                .newRequirement(NEWREQ)
                .build();

        //when
        when(requirementRepository.findById(1L)).thenReturn(Optional.of(requirement));
        var requirementDTO = requirementService.getRequirementById(ID);

        //then
        assertAll("Assert that repo retrieved a Requirement and successfully mapped it (Needs to map types as well)",
                () -> assertEquals(ID, requirementDTO.getRequirementId()),
                () -> assertEquals(STATUS, requirementDTO.getStatus()),
                () -> assertEquals(countryMapper.countryToCountryDTO(COUNTRY), requirementDTO.getCountry()),
                () -> assertEquals(REQCATEGORY, requirementDTO.getRequirementsCategory()),
                () -> assertEquals(REQTYPE, requirementDTO.getRequirementsType()),
                () -> assertEquals(REQSUBTYPE, requirementDTO.getRequirementsSubType()),
                () -> assertEquals(REGULATION, requirementDTO.getRegulation()),
                () -> assertEquals(ADJACENCY, requirementDTO.getAdjacency()),
                () -> assertEquals(CREATEDDATE, requirementDTO.getCreatedDate()),
                () -> assertEquals(NEWREQ, requirementDTO.getNewRequirement())
        );
    }
}