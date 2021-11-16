package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.Address;
import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.mapper.IAddressMapper;
import com.oldmutual.omjavainsights.model.mapper.ICountryMapper;
import com.oldmutual.omjavainsights.repositories.IAddressRepository;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AddressServiceTest {

    public static final Long ID = 1L;
    public static final String ADDRESSONE = "1st Line";
    public static final String ADDRESSTWO = "2nd Line";
    public static final String ADDRESSTHREE = "3rd Line";
    public static final String ADDRESSFOUR = "4th Line";
    public static final String CITY = "Johannesburg";
    public static final String POSTALCODE = "2123";
    public static final Country COUNTRY = Country.builder().countryId(1L).countryCode("1234").countryClassification("Classified").build();
    public static final String CAREOFINDICATOR = "Indicator";
    public static final String CAREOFNAME = "NAME";
    public static final Date MODIFIEDON = new Date();
    //public static final NaturalPerson NATURALPERSON = todo implementation of natural person


    @MockBean
    AddressService addressService;

    @MockBean
    IAddressRepository addressRepository;

    //mappers
    @SpyBean
    IAddressMapper addressMapper;

    @SpyBean
    ICountryMapper countryMapper;

    @BeforeEach
    void setUp() {

        addressService =  new AddressService(addressMapper, addressRepository);

    }

    @Test
    void getAddressById() {

        //given
        var address = Address.builder()
                .addressId(ID)
                .addressLineOne(ADDRESSONE)
                .addressLineTwo(ADDRESSTWO)
                .addressLineThree(ADDRESSTHREE)
                .addressLineFour(ADDRESSFOUR)
                .city(CITY)
                .postalCode(POSTALCODE)
                .country(COUNTRY)
                .careOfIndicator(CAREOFINDICATOR)
                .careOfName(CAREOFNAME)
                .modifiedOn(MODIFIEDON)
                .build();

        //when
        when(addressRepository.findById(1L)).thenReturn(Optional.of(address));
        var addressDTO = addressService.getAddressById(ID);

        //then
        assertAll("Assert that repo retrieved an address and successfully mapped it",
                () -> assertEquals(ID, addressDTO.getAddressId()),
                () -> assertEquals(ADDRESSONE, addressDTO.getAddressLineOne()),
                () -> assertEquals(ADDRESSTWO, addressDTO.getAddressLineTwo()),
                () -> assertEquals(ADDRESSTHREE, addressDTO.getAddressLineThree()),
                () -> assertEquals(ADDRESSFOUR, addressDTO.getAddressLineFour()),
                () -> assertEquals(CITY, addressDTO.getCity()),
                () -> assertEquals(POSTALCODE, addressDTO.getPostalCode()),
                () -> assertEquals(countryMapper.countryToCountryDTO(COUNTRY), addressDTO.getCountry()),
                () -> assertEquals(CAREOFINDICATOR, addressDTO.getCareOfIndicator()),
                () -> assertEquals(CAREOFNAME, addressDTO.getCareOfName()),
                () -> assertEquals(MODIFIEDON, addressDTO.getModifiedOn())
        );
    }
}