package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.controllers.AddressController;
import com.oldmutual.omjavainsights.model.ContactDetail;
import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.dto.ContactDetailDTO;
import com.oldmutual.omjavainsights.model.mapper.IContactDetailMapper;
import com.oldmutual.omjavainsights.repositories.IContactDetailRepository;
import com.oldmutual.omjavainsights.services.interfaces.IContactDetailService;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
class ContactDetailServiceTest {

    public static final Long ID = 1L;
    public static final String CONTACTTYPE = "A Type";
    public static final String COUNTRYCODE = "+27";
    public static final String AREACODE = "12289";
    public static final String NUMBER = "THis is Number 1";
    public static final String PHONENUMBER = "0762779888";
    //public static final NaturalPerson NATURALPERSON = todo implementation of natural person

    @MockBean
    ContactDetailService contactDetailService;

    @MockBean
    IContactDetailRepository contactDetailRepository;

    //mappers
    @SpyBean
    IContactDetailMapper contactDetailMapper;

    @BeforeEach
    void setUp() {

        contactDetailService = new ContactDetailService(contactDetailMapper, contactDetailRepository);
    }

    @Test
    void getContactDetailById() {

        //given
        var contactDetail = ContactDetail.builder()
                .contactDetailId(ID)
                .contactType(CONTACTTYPE)
                .countryCode(COUNTRYCODE)
                .areaCode(AREACODE)
                .number(NUMBER)
                .phoneNumber(PHONENUMBER)
                .build();

        //when
        when(contactDetailRepository.findById(1L)).thenReturn(Optional.of(contactDetail));
        var contactDetailDTO = contactDetailService.getContactDetailById(ID);

        //then
        assertAll("Assert that repo retrieved a contactDetail and successfully mapped it",
                () -> assertEquals(ID, contactDetailDTO.getContactDetailId()),
                () -> assertEquals(CONTACTTYPE, contactDetailDTO.getContactType()),
                () -> assertEquals(COUNTRYCODE, contactDetailDTO.getCountryCode()),
                () -> assertEquals(AREACODE, contactDetailDTO.getAreaCode()),
                () -> assertEquals(NUMBER, contactDetailDTO.getNumber()),
                () -> assertEquals(PHONENUMBER, contactDetailDTO.getPhoneNumber())
        );
    }
}