package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Role;
import com.oldmutual.omjavainsights.model.mapper.IRoleMapper;
import com.oldmutual.omjavainsights.repositories.IRoleRepository;
import com.oldmutual.omjavainsights.services.interfaces.IRoleService;
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

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RoleServiceTest {

    public static final Long ID = 1L;
    public static final String DESCRIPTION= "Description";
    public static final String CATEGORY= "Category";
    public static final String SCREENINGROLE= "Screening Role";
    public static final String DETNATIONALITY= "South African";

    @MockBean
    RoleService roleService;

    @MockBean
    IRoleRepository roleRepository;

    @SpyBean
    IRoleMapper roleMapper;

    @BeforeEach
    void setUp(){

        roleService = new RoleService(roleMapper, roleRepository);
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