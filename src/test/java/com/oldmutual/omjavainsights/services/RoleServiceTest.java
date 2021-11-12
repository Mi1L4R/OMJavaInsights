package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Role;
import com.oldmutual.omjavainsights.model.mapper.IRoleMapper;
import com.oldmutual.omjavainsights.repositories.IRoleRepository;
import com.oldmutual.omjavainsights.services.interfaces.IRoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RoleServiceTest {

    public static final Long ID = 1L;
    public static final String DESCRIPTION= "Description";
    public static final String CATEGORY= "Category";
    public static final String SCREENINGROLE= "Screening Role";
    public static final String DETNATIONALITY= "South African";

    IRoleService roleService;

    @Mock
    IRoleRepository roleRepository;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);

        roleService = new RoleService(IRoleMapper.INSTANCE, roleRepository);
    }

    @Test
    void getRoleById() {

        //given
        var role = Role.builder()
                .roleId(ID)
                .roleDescription(DESCRIPTION)
                .roleCategory(CATEGORY)
                .screeningRole(SCREENINGROLE)
                .determinedNationality(DETNATIONALITY)
                .build();

        //when
        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
        var roleDTO = roleService.getRoleById(ID);

        //then
        assertAll("Assert that repo retrieved a Requirement and successfully mapped it",
                () -> assertEquals(ID, roleDTO.getRoleId()),
                () -> assertEquals(DESCRIPTION, roleDTO.getRoleDescription()),
                () -> assertEquals(CATEGORY, roleDTO.getRoleCategory()),
                () -> assertEquals(SCREENINGROLE, roleDTO.getScreeningRole()),
                () -> assertEquals(DETNATIONALITY, roleDTO.getDeterminedNationality())
                );
    }
}