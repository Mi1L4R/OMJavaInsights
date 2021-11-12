package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Contract;
import com.oldmutual.omjavainsights.model.ContractRole;
import com.oldmutual.omjavainsights.model.mapper.IContractRoleMapper;
import com.oldmutual.omjavainsights.repositories.IContractRoleRepository;
import com.oldmutual.omjavainsights.services.interfaces.IContractRoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ContractRoleServiceTest {

    public static final Long ID =1L;
    public static final String DESCRIPTION = "THis is a description";
    public static final Contract CONTRACT = Contract.builder().contractId(2L).build();
    //Todo Add Contract and Party to test

    IContractRoleService contractRoleService;

    @Mock
    IContractRoleRepository contractRoleRepository;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        contractRoleService = new ContractRoleService(IContractRoleMapper.INSTANCE, contractRoleRepository);
    }

    @Test
    void getRoleById() {

        //given
        var contractRole = ContractRole.builder()
                .contractRoleId(ID)
                .roleDescription(DESCRIPTION)
                .contract(CONTRACT)
                .build();

        //when
        when(contractRoleRepository.findById(1L)).thenReturn(Optional.of(contractRole));
        var contractRoleDTO = contractRoleService.getRoleById(ID);

        //then
        assertAll("Assert that repo retrieved a contractRole and successfully mapped it",
                () -> assertEquals(ID, contractRoleDTO.getContractRoleId()),
                () -> assertEquals(DESCRIPTION, contractRoleDTO.getRoleDescription())
        );
    }
}