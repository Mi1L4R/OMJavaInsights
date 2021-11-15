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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NaturalPersonDTO)) return false;

        NaturalPersonDTO that = (NaturalPersonDTO) o;

        if (getNaturalPersonId() != null ? !getNaturalPersonId().equals(that.getNaturalPersonId()) : that.getNaturalPersonId() != null)
            return false;
        if (getDhaVerifications() != null ? !getDhaVerifications().equals(that.getDhaVerifications()) : that.getDhaVerifications() != null)
            return false;
        if (getAddresses() != null ? !getAddresses().equals(that.getAddresses()) : that.getAddresses() != null)
            return false;
        if (getContactDetails() != null ? !getContactDetails().equals(that.getContactDetails()) : that.getContactDetails() != null)
            return false;
        if (getContracts() != null ? !getContracts().equals(that.getContracts()) : that.getContracts() != null)
            return false;
        if (getCountryOfBirth() != null ? !getCountryOfBirth().equals(that.getCountryOfBirth()) : that.getCountryOfBirth() != null)
            return false;
        if (getCountryOfResidence() != null ? !getCountryOfResidence().equals(that.getCountryOfResidence()) : that.getCountryOfResidence() != null)
            return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(that.getDateOfBirth()) : that.getDateOfBirth() != null)
            return false;
        if (getDateOfDeath() != null ? !getDateOfDeath().equals(that.getDateOfDeath()) : that.getDateOfDeath() != null)
            return false;
        if (getEmployeeLevel() != null ? !getEmployeeLevel().equals(that.getEmployeeLevel()) : that.getEmployeeLevel() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getPreviousFirstName() != null ? !getPreviousFirstName().equals(that.getPreviousFirstName()) : that.getPreviousFirstName() != null)
            return false;
        if (getPreviousLastName() != null ? !getPreviousLastName().equals(that.getPreviousLastName()) : that.getPreviousLastName() != null)
            return false;
        if (getGender() != null ? !getGender().equals(that.getGender()) : that.getGender() != null) return false;
        if (getIdentificationDetails() != null ? !getIdentificationDetails().equals(that.getIdentificationDetails()) : that.getIdentificationDetails() != null)
            return false;
        if (getIndustry() != null ? !getIndustry().equals(that.getIndustry()) : that.getIndustry() != null)
            return false;
        if (getNationality() != null ? !getNationality().equals(that.getNationality()) : that.getNationality() != null)
            return false;
        if (getRoles() != null ? !getRoles().equals(that.getRoles()) : that.getRoles() != null) return false;
        if (getScreening() != null ? !getScreening().equals(that.getScreening()) : that.getScreening() != null)
            return false;
        if (getSourceOfIncome() != null ? !getSourceOfIncome().equals(that.getSourceOfIncome()) : that.getSourceOfIncome() != null)
            return false;
        if (getTaxResidencies() != null ? !getTaxResidencies().equals(that.getTaxResidencies()) : that.getTaxResidencies() != null)
            return false;
        if (getVerificationDocuments() != null ? !getVerificationDocuments().equals(that.getVerificationDocuments()) : that.getVerificationDocuments() != null)
            return false;
        if (getRequirements() != null ? !getRequirements().equals(that.getRequirements()) : that.getRequirements() != null)
            return false;
        if (getParty() != null ? !getParty().equals(that.getParty()) : that.getParty() != null) return false;
        return getTotalRiskRating() != null ? getTotalRiskRating().equals(that.getTotalRiskRating()) : that.getTotalRiskRating() == null;
    }

    @Override
    public int hashCode() {
        int result = getNaturalPersonId() != null ? getNaturalPersonId().hashCode() : 0;
        result = 31 * result + (getDhaVerifications() != null ? getDhaVerifications().hashCode() : 0);
        result = 31 * result + (getAddresses() != null ? getAddresses().hashCode() : 0);
        result = 31 * result + (getContactDetails() != null ? getContactDetails().hashCode() : 0);
        result = 31 * result + (getContracts() != null ? getContracts().hashCode() : 0);
        result = 31 * result + (getCountryOfBirth() != null ? getCountryOfBirth().hashCode() : 0);
        result = 31 * result + (getCountryOfResidence() != null ? getCountryOfResidence().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getDateOfDeath() != null ? getDateOfDeath().hashCode() : 0);
        result = 31 * result + (getEmployeeLevel() != null ? getEmployeeLevel().hashCode() : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getPreviousFirstName() != null ? getPreviousFirstName().hashCode() : 0);
        result = 31 * result + (getPreviousLastName() != null ? getPreviousLastName().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getIdentificationDetails() != null ? getIdentificationDetails().hashCode() : 0);
        result = 31 * result + (getIndustry() != null ? getIndustry().hashCode() : 0);
        result = 31 * result + (getNationality() != null ? getNationality().hashCode() : 0);
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        result = 31 * result + (getScreening() != null ? getScreening().hashCode() : 0);
        result = 31 * result + (getSourceOfIncome() != null ? getSourceOfIncome().hashCode() : 0);
        result = 31 * result + (getTaxResidencies() != null ? getTaxResidencies().hashCode() : 0);
        result = 31 * result + (getVerificationDocuments() != null ? getVerificationDocuments().hashCode() : 0);
        result = 31 * result + (getRequirements() != null ? getRequirements().hashCode() : 0);
        result = 31 * result + (getParty() != null ? getParty().hashCode() : 0);
        result = 31 * result + (getTotalRiskRating() != null ? getTotalRiskRating().hashCode() : 0);
        return result;
    }
}
