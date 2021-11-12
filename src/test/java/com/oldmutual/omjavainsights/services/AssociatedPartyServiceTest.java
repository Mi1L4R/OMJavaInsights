package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.AssociatedParty;
import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.mapper.IAssociatedPartyMapper;
import com.oldmutual.omjavainsights.model.mapper.IPartyMapper;
import com.oldmutual.omjavainsights.repositories.IAssociatedPartyRepository;
import com.oldmutual.omjavainsights.services.interfaces.IAssociatedPartyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AssociatedPartyServiceTest {

    private static final Long ID = 1L;
    private static final Party PARTY = Party.builder()
            .lisId("1234efrt")
            .partyType("Type")
            .build();

    IAssociatedPartyService associatedPartyService;

    @Mock
    IAssociatedPartyRepository associatedPartyRepository;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        associatedPartyService = new AssociatedPartyService(IAssociatedPartyMapper.INSTANCE, associatedPartyRepository);
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
                () -> assertEquals(ID, assPartyDTO.getAssociatedPartyId())
                );
    }
}