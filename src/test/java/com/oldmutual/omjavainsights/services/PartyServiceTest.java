package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Party;
import com.oldmutual.omjavainsights.model.mapper.IPartyMapper;
import com.oldmutual.omjavainsights.repositories.IPartyRepository;
import com.oldmutual.omjavainsights.services.interfaces.IPartyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.repository.query.parser.Part;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PartyServiceTest {

    public static final String ID = "12E3-4F5G6-7RT89";
    public static final String PARTYTYPE = "Clubbing";

    @InjectMocks
    PartyService partyService;

    @Mock
    IPartyRepository partyRepository;

    @Spy
    IPartyMapper partyMapper;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPartyById() {

        //given
        var party =  Party.builder().lisId(ID).partyType(PARTYTYPE).build();

        //when
        when(partyRepository.findById("12E3-4F5G6-7RT89")).thenReturn(Optional.of(party));
        var partyDTO = partyService.getPartyById(ID);

        //then
        assertAll("Assert that repo retrieved a party and successfully mapped it",
                () -> assertEquals(ID, partyDTO.getLisId()),
                () -> assertEquals(PARTYTYPE, partyDTO.getPartyType()));
    }
}