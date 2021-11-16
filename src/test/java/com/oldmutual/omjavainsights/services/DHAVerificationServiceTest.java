package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.DHAVerification;
import com.oldmutual.omjavainsights.model.mapper.IDHAVerificationMapper;
import com.oldmutual.omjavainsights.repositories.IDHAVerificationRepository;
import com.oldmutual.omjavainsights.services.interfaces.IDHAVerificationService;
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
class DHAVerificationServiceTest {

    public static final Long ID = 1L;
    public static final String IDNUMBER = "123456789";
    public static final String FIRSTNAMES= "Ben,Stiller";
    public static final String LASTNAME = "HelloWorld";
    public static final Date DOB = new Date();
    public static final String GENDER = "Male";
    public static final Date DATERECEIVED = new Date();

    @MockBean
    DHAVerificationService verificationService;

    @MockBean
    IDHAVerificationRepository verificationRepository;

    @SpyBean
    IDHAVerificationMapper verificationMapper;

    @BeforeEach
    void setUp() {

        verificationService = new DHAVerificationService(verificationMapper, verificationRepository);
    }

    @Test
    void getDHAVerificationById() {

        //given
        var verification = DHAVerification.builder()
                .dhaVerificationId(ID)
                .dhaIdNumber(IDNUMBER)
                .dhaFirstNames(FIRSTNAMES)
                .dhaLastName(LASTNAME)
                .dhaDateOfBirth(DOB)
                .dhaGender(GENDER)
                .dhaDateReceived(DATERECEIVED)
                .build();

        //when
        when(verificationRepository.findById(1L)).thenReturn(Optional.of(verification));
        var verificationDTO = verificationService.getDHAVerificationById(ID);

        //then
        assertAll("Assert that repo retrieved a DHAVerification and successfully mapped it (Needs to map Lists as well)",
                () -> assertEquals(ID, verificationDTO.getDhaVerificationId()),
                () -> assertEquals(IDNUMBER, verificationDTO.getDhaIdNumber()),
                () -> assertEquals(FIRSTNAMES, verificationDTO.getDhaFirstNames()),
                () -> assertEquals(LASTNAME, verificationDTO.getDhaLastName()),
                () -> assertEquals(DOB, verificationDTO.getDhaDateOfBirth()),
                () -> assertEquals(GENDER, verificationDTO.getDhaGender()),
                () -> assertEquals(DATERECEIVED, verificationDTO.getDhaDateReceived())
                );
    }
}