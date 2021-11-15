package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.ContractRole;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.mapper.IContractMapper;
import com.oldmutual.omjavainsights.model.mapper.IContractRoleMapper;
import com.oldmutual.omjavainsights.repositories.IContractRepository;
import com.oldmutual.omjavainsights.services.interfaces.IContractService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ContractServiceTest {

    public static final Long ID = 1L;
    public static final String PRODUCTCODE = "12F3RE";
    public static final String POLICYNUMBER = "0000879";
    public static final String BUSINESSUNIT = "BU1,BU2,BU3";
    public static final String CONTRACTSOURCE = "SourceType";
    public static final String AMLPCBT = "Above";
    public static final List<ContractRole> CONTRACT_ROLES = new ArrayList<>(Arrays.asList(
            ContractRole.builder()
                    .contractRoleId(1L)
                    .roleDescription("RoleDescription1")
                    .party(Party.builder().lisId("12345678EFG").partyType("Type1").build())
                    .build(),
            ContractRole.builder()
                    .contractRoleId(2L)
                    .roleDescription("RoleDescription2")
                    .party(Party.builder().lisId("384384HVUVHH").partyType("Type2").build())
                    .build()

    ));
    public static final Date MODIFIEDON = new Date();

    //todo add Product for testing


    @Mock
    ContractService contractService;


    @MockBean
    IContractRepository contractRepository;

    //mappers
    @SpyBean
    IContractMapper contractMapper;

    @SpyBean
    IContractRoleMapper contractRoleMapper;


    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        contractService = new ContractService(contractMapper, contractRepository);
    }

    @Test
    void getContractById() {



        //given
        var contract = Contract.builder()
                .contractId(ID)
                .businessUnit(BUSINESSUNIT)
                .contractSource(CONTRACTSOURCE)
                .contractRoles(CONTRACT_ROLES)
                .modifiedOn(MODIFIEDON)
                .build();

        //when
        when(contractRepository.findById(1L)).thenReturn(Optional.of(contract));
        var contractDTO = contractService.getContractById(ID);
        //then
        assertAll("Assert that repo retrieved a Contract and successfully mapped it (Needs to map Lists as well)",
                () -> assertEquals(ID, contractDTO.getContractId()),
                () -> assertEquals(BUSINESSUNIT, contractDTO.getBusinessUnit()),
                () -> assertEquals(CONTRACTSOURCE, contractDTO.getContractSource()),
                () -> assertEquals(contractRoleMapper.contractRoleListToContractRoleDTOList(CONTRACT_ROLES), contractDTO.getContractRoles()),
                () -> assertEquals(MODIFIEDON, contractDTO.getModifiedOn())
        );

    }
}