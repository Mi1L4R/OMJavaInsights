package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.AssociatedParty;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.mapper.IAssociatedPartyMapper;
import com.oldmutual.omjavainsights.model.mapper.IPartyMapper;
import com.oldmutual.omjavainsights.repositories.IAssociatedPartyRepository;
import com.oldmutual.omjavainsights.services.interfaces.IAssociatedPartyService;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AssociatedPartyServiceTest {

    private static final Long ID = 1L;
    private static final Party PARTY = Party.builder()
            .lisId("1234efrt")
            .partyType("Type")
            .build();

    @MockBean
    AssociatedPartyService associatedPartyService;

    @MockBean
    IAssociatedPartyRepository associatedPartyRepository;

    //mappers
    @SpyBean
    IAssociatedPartyMapper associatedPartyMapper;

    @SpyBean
    IPartyMapper partyMapper;

    @BeforeEach
    void setUp() {

       associatedPartyService =  new AssociatedPartyService(associatedPartyMapper, associatedPartyRepository);
    }

    @Test
    void getAssociatedPartyById() {

        //given
        var assParty = AssociatedParty.builder()
                .associatedPartyId(ID)
                .party(PARTY)
                .build();

        //when
        when(associatedPartyRepository.findById(1L)).thenReturn(Optional.of(assParty));
        var assPartyDTO = associatedPartyService.getAssociatedPartyById(ID);


        //then
        assertAll("Assert that repo retrieved a party and successfully mapped it",
                () -> assertEquals(ID, assPartyDTO.getAssociatedPartyId()),
                () -> assertEquals(partyMapper.partyToPartyDTO(PARTY), assPartyDTO.getParty())
                );
    }
}