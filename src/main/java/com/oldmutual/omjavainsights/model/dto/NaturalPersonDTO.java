package com.oldmutual.omjavainsights.model.dto;


import com.oldmutual.omjavainsights.generics.GenericsForDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class NaturalPersonDTO {

    private Long naturalPersonId;
    private List<DHAVerificationDTO> dhaVerifications;
    private List<AddressDTO> addresses;
    private List<ContactDetailDTO> contactDetails;
    private List<ContractDTO> contracts;
    private CountryDTO countryOfBirth;
    private CountryDTO countryOfResidence;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private String employeeLevel;
    private String firstName;
    private String lastName;
    private String previousFirstName;
    private String previousLastName;
    private String gender;
    private List<IdentificationDetailDTO> identificationDetails;
    private String industry;
    private String nationality;
    private List<RoleDTO> roles;
    private ScreeningDTO screening;
    private String sourceOfIncome;
    private List<TaxResidencyDTO> taxResidencies;
    private List<VerificationDocumentDTO> verificationDocuments;
    private List<RequirementDTO> requirements;
    private PartyDTO party;
    private Integer totalRiskRating;


    //Generic methods used for adding/removing dto from dtoList
    public void addDHAVerification(DHAVerificationDTO dhaVerificationDTO){
        GenericsForDTO.addDTOObjectToList(dhaVerificationDTO, dhaVerifications);
    }

    public void removeDHAVerification(DHAVerificationDTO dhaVerificationDTO){
        GenericsForDTO.removeDTOObjectFromList(dhaVerificationDTO, dhaVerifications);
    }

    public void addAddress(AddressDTO addressDTO){
        GenericsForDTO.addDTOObjectToList(addressDTO, addresses);
    }

    public void removeAddress(AddressDTO addressDTO){
        GenericsForDTO.removeDTOObjectFromList(addressDTO, addresses);
    }

    public void addContactDetail(ContactDetailDTO contactDetailDTO){
        GenericsForDTO.addDTOObjectToList(contactDetailDTO, contactDetails);
    }

    public void removeContactDetail(ContactDetailDTO contactDetailDTO){
        GenericsForDTO.removeDTOObjectFromList(contactDetailDTO, contactDetails);
    }

    public void addContract(ContractDTO contractDTO){
        GenericsForDTO.addDTOObjectToList(contractDTO, contracts);
    }

    public void removeContract(ContractDTO contractDTO){
        GenericsForDTO.removeDTOObjectFromList(contractDTO, contracts);
    }

    public void addIdentificationDetail(IdentificationDetailDTO identificationDetailDTO){
        GenericsForDTO.addDTOObjectToList(identificationDetailDTO, identificationDetails);
    }

    public void removeIdentificationDetail(IdentificationDetailDTO identificationDetailDTO){
        GenericsForDTO.removeDTOObjectFromList(identificationDetailDTO, identificationDetails);
    }

    public void addRole(RoleDTO roleDTO){
        GenericsForDTO.addDTOObjectToList(roleDTO, roles);
    }

    public void removeRole(RoleDTO roleDTO){
        GenericsForDTO.removeDTOObjectFromList(roleDTO, roles);
    }

    public void addTaxResidency(TaxResidencyDTO taxResidencyDTO){
        GenericsForDTO.addDTOObjectToList(taxResidencyDTO, taxResidencies);
    }

    public void removeTaxResidency(TaxResidencyDTO taxResidencyDTO){
        GenericsForDTO.removeDTOObjectFromList(taxResidencyDTO, taxResidencies);
    }

    public void addVerificationDocument(VerificationDocumentDTO verificationDocumentDTO){
        GenericsForDTO.addDTOObjectToList(verificationDocumentDTO, verificationDocuments);
    }

    public void removeVerificationDocument(VerificationDocumentDTO verificationDocumentDTO){
        GenericsForDTO.removeDTOObjectFromList(verificationDocumentDTO, verificationDocuments);
    }

    public void addRequirement(RequirementDTO requirementDTO){
        GenericsForDTO.addDTOObjectToList(requirementDTO, requirements);
    }

    public void removeRequirement(RequirementDTO requirementDTO){
        GenericsForDTO.removeDTOObjectFromList(requirementDTO, requirements);
    }
}
