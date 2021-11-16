package com.oldmutual.omjavainsights.services;

import com.oldmutual.omjavainsights.model.*;
import com.oldmutual.omjavainsights.model.mapper.*;
import com.oldmutual.omjavainsights.repositories.INaturalPersonRepository;
import com.oldmutual.omjavainsights.services.interfaces.INaturalPersonService;
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
import org.springframework.boot.test.mock.mockito.SpyBeans;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NaturalPersonServiceTest {

    public static final Long ID = 1L;
    public static final List<DHAVerification> DHA_VERIFICATIONS = Arrays.asList(
            DHAVerification.builder()
                    .dhaVerificationId(1L)
                    .dhaIdNumber("123456")
                    .dhaFirstNames("firstName1_1,firstname1_2")
                    .dhaLastName("LastName1")
                    .dhaDateOfBirth(new Date())
                    .dhaGender("Male")
                    .dhaDateReceived(new Date())
                    .build(),
            DHAVerification.builder()
                    .dhaVerificationId(2L)
                    .dhaIdNumber("654321")
                    .dhaFirstNames("firstName2_1,firstname2_2")
                    .dhaLastName("LastName2")
                    .dhaDateOfBirth(new Date())
                    .dhaGender("Female")
                    .dhaDateReceived(new Date())
                    .build()
    );
    public static final List<Address> ADDRESSES = Arrays.asList(
            Address.builder()
                    .addressId(1L)
                    .addressLineOne("ADDRESSONE_1")
                    .addressLineTwo("ADDRESSTWO_1")
                    .addressLineThree("ADDRESSTHREE_1")
                    .addressLineFour("ADDRESSFOUR_1")
                    .city("CITY_1")
                    .postalCode("POSTALCODE_1")
                    .country(Country.builder()
                            .countryId(1L)
                            .countryClassification("classified1")
                            .countryCode("code1")
                            .build())
                    .careOfIndicator("CAREOFINDICATOR_1")
                    .careOfName("CAREOFNAME_1")
                    .modifiedOn(new Date())
                    .build(),
            Address.builder()
                    .addressId(2L)
                    .addressLineOne("ADDRESSONE_2")
                    .addressLineTwo("ADDRESSTWO_2")
                    .addressLineThree("ADDRESSTHREE_2")
                    .addressLineFour("ADDRESSFOUR_2")
                    .city("CITY_2")
                    .postalCode("POSTALCODE_2")
                    .country(Country.builder()
                            .countryId(2L)
                            .countryClassification("classified2")
                            .countryCode("code2")
                            .build())
                    .careOfIndicator("CAREOFINDICATOR_2")
                    .careOfName("CAREOFNAME_2")
                    .modifiedOn(new Date())
                    .build()
    );
    public static final List<ContactDetail> CONTACT_DETAILS = Arrays.asList(
            ContactDetail.builder()
                    .contactDetailId(1L)
                    .contactType("CONTACTTYPE_1")
                    .countryCode("COUNTRYCODE_1")
                    .areaCode("AREACODE_1")
                    .number("NUMBER_1")
                    .phoneNumber("PHONENUMBER_1")
                    .build(),
            ContactDetail.builder()
                    .contactDetailId(2L)
                    .contactType("CONTACTTYPE_2")
                    .countryCode("COUNTRYCODE_2")
                    .areaCode("AREACODE_2")
                    .number("NUMBER_2")
                    .phoneNumber("PHONENUMBER_2")
                    .build()
    );
    public static final List<Contract> CONTRACTS = Arrays.asList(
            Contract.builder()
                    .contractId(1L)
                    .businessUnit("BUSINESSUNIT_1")
                    .contractSource("CONTRACTSOURCE_1")
                    .contractRoles(Arrays.asList(
                                    ContractRole.builder()
                                            .contractRoleId(1L)
                                            .roleDescription("RoleDescription1")
                                            .party(Party.builder().lisId("12345678EFG").partyType("Type1").build())
                                            .build(),
                                    ContractRole.builder()
                                            .contractRoleId(2L)
                                            .roleDescription("RoleDescription2")
                                            .party(Party.builder().lisId("384384HVUVHH").partyType("Type2").build())
                                            .build()))
                    .modifiedOn(new Date())
                    .build());
    public static final Country COUNTRYOFBIRTH = Country.builder()
            .countryId(1L)
            .countryCode("CountryOfBirthCode")
            .countryClassification("ClassificationOfBirth")
            .build();
    public static final Country COUNTRYOFRES = Country.builder()
            .countryId(2L)
            .countryCode("CountryOfResidence")
            .countryClassification("ClassificationOfResidence")
            .build();
    public static final Date DOB = new Date();
    public static final Date DOD = new Date();
    public static final String EMPLEVEL = "Employee Level";
    public static final String FIRSTNAME = "FirstName";
    public static final String LASTNAME = "LastName";
    public static final String PREVFIRSTNAME = "Previous FirstName";
    public static final String PREVLASTNAME = "Previous LastName";
    public static final String GENDER = "Male";
    public static final List<IdentificationDetail> IDENTIFICATION_DETAILS = Arrays.asList(
            IdentificationDetail.builder()
                    .identificationDetailId(1L)
                    .idNumber("IDNUMBER_1")
                    .idType("IDTYPE_1")
                    .countryOfIssue(Country.builder()
                            .countryId(1L)
                            .countryCode("CountryCode1")
                            .countryClassification("Classification1")
                            .build())
                    .visaPermitType("VISATYPE_1")
                    .dateOfExpiry(new Date())
                    .modifiedOn(new Date())
                    .build(),
            IdentificationDetail.builder()
                    .identificationDetailId(2L)
                    .idNumber("IDNUMBER_2")
                    .idType("IDTYPE_2")
                    .countryOfIssue(Country.builder()
                            .countryId(2L)
                            .countryCode("CountryCode2")
                            .countryClassification("Classification2")
                            .build())
                    .visaPermitType("VISATYPE_2")
                    .dateOfExpiry(new Date())
                    .modifiedOn(new Date())
                    .build()
    );
    public static final String INDUSTRY = "Industry";
    public static final String NATIONALITY = "Nationality";
    public static final List<Role> ROLES = Arrays.asList(
            Role.builder()
                    .roleId(1L)
                    .roleDescription("DESCRIPTION_1")
                    .roleCategory("CATEGORY_1")
                    .screeningRole("SCREENINGROLE_1")
                    .determinedNationality("DETNATIONALITY_1")
                    .build(),
            Role.builder()
                    .roleId(2L)
                    .roleDescription("DESCRIPTION_2")
                    .roleCategory("CATEGORY_2")
                    .screeningRole("SCREENINGROLE_2")
                    .determinedNationality("DETNATIONALITY_2")
                    .build()
    );
    public static final Screening SCREENING = Screening.builder()
            .screeningId(1L)
            .ameOutcome("AMEOUTCOME")
            .amlOutcome("AMLOUTCOME")
            .dateRequested(new Date())
            .sanctionsOutcome("SANCTIONSOUTCOME")
            .screeningStatus("SCREENINGSTATUS")
            .dpipOutcome("DPIPOUTCOME")
            .fppoOutcome("FPPOOUTCOME")
            .rcafppoOutcome("RCAFPPOOUTCOME")
            .rcadpipOutcome("RCADPIPOUTCOME")
            .screeningResultType("SCREENINGRESULTTYPE")
            .modifiedOn(new Date())
            .build();
    public static final String SRCOFINCOME = "Source of Income";
    public static final List<TaxResidency> TAX_RESIDENCIES = Arrays.asList(
            TaxResidency.builder()
                    .taxResidencyId(1L)
                    .countryOfTaxResidency(Country.builder()
                            .countryId(1L)
                            .countryCode("CountryCode1")
                            .countryClassification("Classification1")
                            .build())
                    .countryOfTaxReferenceNumber("COUNTRYOFTAXREFNUMBER_1")
                    .taxIdentificationNumber("IDENTIFICATIONNUM_1")
                    .selfCertificationDeclarationReason("SCDREASON_1")
                    .selfCertificationDeclarationDate(new Date())
                    .build(),
            TaxResidency.builder()
                    .taxResidencyId(2L)
                    .countryOfTaxResidency(Country.builder()
                            .countryId(2L)
                            .countryCode("CountryCode2")
                            .countryClassification("Classification2")
                            .build())
                    .countryOfTaxReferenceNumber("COUNTRYOFTAXREFNUMBER_2")
                    .taxIdentificationNumber("IDENTIFICATIONNUM_2")
                    .selfCertificationDeclarationReason("SCDREASON_2")
                    .selfCertificationDeclarationDate(new Date())
                    .build()
    );
    public static final List<VerificationDocument> VERIFICATION_DOCUMENTS = Arrays.asList(
            VerificationDocument.builder()
                    .verificationDocumentId(1L)
                    .verificationCategory("CATEGORY_1")
                    .verificationDocument("DOCUMENT_1")
                    .documentName("DOCUMENTNAME_1")
                    .status("STATUS_1")
                    .endDate(new Date())
                    .modifiedOn(new Date())
                    .build(),
            VerificationDocument.builder()
                    .verificationDocumentId(2L)
                    .verificationCategory("CATEGORY_2")
                    .verificationDocument("DOCUMENT_2")
                    .documentName("DOCUMENTNAME_2")
                    .status("STATUS_2")
                    .endDate(new Date())
                    .modifiedOn(new Date())
                    .build()
    );
    public static final List<Requirement> REQUIREMENTS = Arrays.asList(
            Requirement.builder()
                    .requirementId(1L)
                    .status("STATUS")
                    .country(Country.builder()
                            .countryId(1L)
                            .countryCode("CountryCode1")
                            .countryClassification("Classification1")
                            .build())
                    .requirementsCategory("REQCATEGORY")
                    .requirementsType("REQTYPE")
                    .requirementsSubType("REQSUBTYPE")
                    .regulation("REGULATION")
                    .adjacency("ADJACENCY")
                    .createdDate(new Date())
                    .newRequirement(true)
                    .build(),
            Requirement.builder()
                    .requirementId(1L)
                    .status("STATUS")
                    .country(Country.builder()
                            .countryId(1L)
                            .countryCode("CountryCode1")
                            .countryClassification("Classification1")
                            .build())
                    .requirementsCategory("REQCATEGORY")
                    .requirementsType("REQTYPE")
                    .requirementsSubType("REQSUBTYPE")
                    .regulation("REGULATION")
                    .adjacency("ADJACENCY")
                    .createdDate(new Date())
                    .newRequirement(true)
                    .build()
    );
    public static final Party PARTY = Party.builder()
            .lisId("ID")
            .partyType("PARTYTYPE")
            .build();
    public static final Integer TOTRISKRATING = 10000;


    @MockBean
    NaturalPersonService naturalPersonService;

    @MockBean
    INaturalPersonRepository naturalPersonRepository;

    //mappers
    @SpyBean
    INaturalPersonMapper naturalPersonMapper;

    @SpyBean
    IDHAVerificationMapper verificationMapper;

    @SpyBean
    IAddressMapper addressMapper;

    @SpyBean
    IContactDetailMapper contactDetailMapper;

    @SpyBean
    IContractMapper contractMapper;

    @SpyBean
    ICountryMapper countryMapper;

    @SpyBean
    IIdentificationDetailMapper identificationDetailMapper;

    @SpyBean
    IRoleMapper roleMapper;

    @SpyBean
    IScreeningMapper screeningMapper;

    @SpyBean
    ITaxResidencyMapper taxResidencyMapper;

    @SpyBean
    IVerificationDocumentMapper verificationDocumentMapper;

    @SpyBean
    IRequirementMapper requirementMapper;

    @SpyBean
    IPartyMapper partyMapper;

    @BeforeEach
    void setUp() {

        naturalPersonService = new NaturalPersonService(naturalPersonMapper,naturalPersonRepository);
    }

    @Test
    void getNaturalPersonById() {

        //given
        var naturalPerson = NaturalPerson.builder()
                .naturalPersonId(ID)
                .dhaVerifications(DHA_VERIFICATIONS)
                .addresses(ADDRESSES)
                .contactDetails(CONTACT_DETAILS)
                .contracts(CONTRACTS)
                .countryOfBirth(COUNTRYOFBIRTH)
                .countryOfResidence(COUNTRYOFRES)
                .dateOfBirth(DOB)
                .dateOfDeath(DOD)
                .employeeLevel(EMPLEVEL)
                .firstName(FIRSTNAME)
                .lastName(LASTNAME)
                .previousFirstName(PREVFIRSTNAME)
                .previousLastName(PREVLASTNAME)
                .gender(GENDER)
                .identificationDetails(IDENTIFICATION_DETAILS)
                .industry(INDUSTRY)
                .nationality(NATIONALITY)
                .roles(ROLES)
                .screening(SCREENING)
                .sourceOfIncome(SRCOFINCOME)
                .taxResidencies(TAX_RESIDENCIES)
                .verificationDocuments(VERIFICATION_DOCUMENTS)
                .requirements(REQUIREMENTS)
                .party(PARTY)
                .totalRiskRating(TOTRISKRATING)
                .build();

        //when
        when(naturalPersonRepository.findById(1L)).thenReturn(Optional.of(naturalPerson));
        var naturalPersonDTO = naturalPersonService.getNaturalPersonById(ID);

        //then
        assertAll("Assert that repo retrieved a party and successfully mapped it (Including List mapping)",
                () -> assertEquals(ID, naturalPersonDTO.getNaturalPersonId()),
                () -> assertEquals(verificationMapper.dhaListTodhaDTOList(DHA_VERIFICATIONS), naturalPersonDTO.getDhaVerifications()),
                () -> assertEquals(addressMapper.addressListToAddressListDTO(ADDRESSES), naturalPersonDTO.getAddresses()),
                () -> assertEquals(contactDetailMapper.cDetailListToCDetailDTOList(CONTACT_DETAILS), naturalPersonDTO.getContactDetails()),
                () -> assertEquals(contractMapper.contractListToContractListDTO(CONTRACTS), naturalPersonDTO.getContracts()),
                () -> assertEquals(countryMapper.countryToCountryDTO(COUNTRYOFBIRTH), naturalPersonDTO.getCountryOfBirth()),
                () -> assertEquals(countryMapper.countryToCountryDTO(COUNTRYOFRES), naturalPersonDTO.getCountryOfResidence()),
                () -> assertEquals(DOB, naturalPersonDTO.getDateOfBirth()),
                () -> assertEquals(DOD, naturalPersonDTO.getDateOfDeath()),
                () -> assertEquals(EMPLEVEL, naturalPersonDTO.getEmployeeLevel()),
                () -> assertEquals(FIRSTNAME, naturalPersonDTO.getFirstName()),
                () -> assertEquals(LASTNAME, naturalPersonDTO.getLastName()),
                () -> assertEquals(PREVFIRSTNAME, naturalPersonDTO.getPreviousFirstName()),
                () -> assertEquals(PREVLASTNAME, naturalPersonDTO.getPreviousLastName()),
                () -> assertEquals(GENDER, naturalPersonDTO.getGender()),
                () -> assertEquals(identificationDetailMapper.idDetailListToIdDetailDTOList(IDENTIFICATION_DETAILS), naturalPersonDTO.getIdentificationDetails()),
                () -> assertEquals(INDUSTRY, naturalPersonDTO.getIndustry()),
                () -> assertEquals(NATIONALITY, naturalPersonDTO.getNationality()),
                () -> assertEquals(roleMapper.roleListToRoleDTOList(ROLES), naturalPersonDTO.getRoles()),
                () -> assertEquals(screeningMapper.screeningToScreeningDTO(SCREENING), naturalPersonDTO.getScreening()),
                () -> assertEquals(SRCOFINCOME, naturalPersonDTO.getSourceOfIncome()),
                () -> assertEquals(taxResidencyMapper.taxResListToTaxResDTOList(TAX_RESIDENCIES), naturalPersonDTO.getTaxResidencies()),
                () -> assertEquals(verificationDocumentMapper.verDocListToVerDocDTOList(VERIFICATION_DOCUMENTS), naturalPersonDTO.getVerificationDocuments()),
                () -> assertEquals(requirementMapper.requirementListToRequirementDTOList(REQUIREMENTS), naturalPersonDTO.getRequirements()),
                () -> assertEquals(partyMapper.partyToPartyDTO(PARTY), naturalPersonDTO.getParty()),
                () -> assertEquals(TOTRISKRATING, naturalPersonDTO.getTotalRiskRating())
        );
    }
}