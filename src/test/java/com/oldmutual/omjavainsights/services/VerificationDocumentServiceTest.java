package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.VerificationDocument;
import com.oldmutual.omjavainsights.model.mapper.IVerificationDocumentMapper;
import com.oldmutual.omjavainsights.repositories.IVerificationDocumentRepository;
import com.oldmutual.omjavainsights.services.interfaces.IVerificationDocumentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class VerificationDocumentServiceTest {

    private static final Long ID = 1L;
    private static final String CATEGORY = "VerificationCategory";
    private static final String DOCUMENT = "VerificationDocument";
    private static final String DOCUMENTNAME = "NameOfDocument";
    private static final String STATUS = "StatusOfDocument";
    private static final Date ENDDATE = new Date();
    private static final Date MODIFIEDON = new Date();

    IVerificationDocumentService verificationDocumentService;

    @Mock
    IVerificationDocumentRepository verificationDocumentRepository;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        verificationDocumentService = new VerificationDocumentService(IVerificationDocumentMapper.INSTANCE, verificationDocumentRepository);
    }

    @Test
    void getVerDocById() {

        //given
        var verDoc = VerificationDocument.builder()
                .verificationDocumentId(ID)
                .verificationCategory(CATEGORY)
                .verificationDocument(DOCUMENT)
                .documentName(DOCUMENTNAME)
                .status(STATUS)
                .endDate(ENDDATE)
                .modifiedOn(MODIFIEDON)
                .build();

        //when
        when(verificationDocumentRepository.findById(1L)).thenReturn(Optional.of(verDoc));
        var verDocDTO = verificationDocumentService.getVerDocById(ID);

        //then
        assertAll("Assert that repo retrieved a VerificationDocument and successfully mapped it",
                () -> assertEquals(ID, verDocDTO.getVerificationDocumentId()),
                () -> assertEquals(CATEGORY, verDocDTO.getVerificationCategory()),
                () -> assertEquals(DOCUMENT, verDocDTO.getVerificationDocument()),
                () -> assertEquals(DOCUMENTNAME, verDocDTO.getDocumentName()),
                () -> assertEquals(STATUS, verDocDTO.getStatus()),
                () -> assertEquals(ENDDATE, verDocDTO.getEndDate()),
                () -> assertEquals(MODIFIEDON, verDocDTO.getModifiedOn())
                );
    }
}