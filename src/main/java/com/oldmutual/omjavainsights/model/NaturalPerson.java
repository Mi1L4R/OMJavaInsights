package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "NaturalPerson")
public class NaturalPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NaturalPersonId")
    private Long naturalPersonId;

    @OneToMany(mappedBy = "naturalPerson")
    @ToString.Exclude //todo figure out cascade and orphanRemoval
    private List<DHAVerification> dhaVerifications;

    @OneToMany(mappedBy = "naturalPerson")
    @ToString.Exclude
    private List<Address> addresses;

    @OneToMany(mappedBy = "naturalPerson")
    @ToString.Exclude
    private List<ContactDetail> contactDetails;

    @OneToMany(mappedBy = "naturalPerson")
    @ToString.Exclude
    private List<Contract> contracts;

    @OneToOne //todo Need to find out cascade type
    @JoinColumn(name = "country_COB_Id", referencedColumnName = "countryId")
    private Country countryOfBirth;

    @OneToOne //todo Need to find out cascade type
    @JoinColumn(name = "country_COR_Id", referencedColumnName = "countryId")
    private Country countryOfResidence;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @Column(name = "DateOfDeath")
    private Date dateOfDeath;

    @Column(name = "EmployeeLevel")
    private String employeeLevel;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "PreviousFirstName")
    private String previousFirstName;

    @Column(name = "PreviousLastName")
    private String previousLastName;

    @Column(name = "Gender")
    private String gender;

    @OneToMany(mappedBy = "naturalPerson")
    @ToString.Exclude//todo Need to find out cascade type
    private List<IdentificationDetail> identificationDetails;

    @Column(name = "Industry")
    private String industry;

    @Column(name = "Nationality")
    private String nationality;

    //Todo find out if below is correct, as in rules model it was a list of strings and not a list of roles
    @OneToMany(mappedBy = "naturalPerson")
    @ToString.Exclude //todo find out cascade type
    private List<Role> roles;

    @OneToOne //todo Need to find out cascade type
    @JoinColumn(name = "screeningId", referencedColumnName = "screeningId")
    private Screening screening;//todo find out if screening should be a collection

    @Column(name = "SourceOfIncome")
    private String sourceOfIncome;

    @OneToMany(mappedBy = "naturalPerson")
    @ToString.Exclude
    private List<TaxResidency> taxResidencies;

    @OneToMany(mappedBy = "naturalPerson")
    @ToString.Exclude
    private List<VerificationDocument> verificationDocuments;

    @OneToMany(mappedBy = "naturalPerson")
    @ToString.Exclude
    private List<Requirement> requirements;

    @OneToOne //todo Need to find out cascade type
    @JoinColumn(name = "lisId", referencedColumnName = "lisId")
    private Party party;

    //todo check if we need below if we are going to add PartyRiskRating table
    @Column(name = "TotalRiskRating")
    private Integer totalRiskRating;

    public NaturalPerson(){

    }


    public void addDHAVerification(DHAVerification dhaVerification) {
        dhaVerifications.add(dhaVerification);
        dhaVerification.setNaturalPerson(this);
    }

    public void removeDHAVerification(DHAVerification dhaVerification) {
        dhaVerifications.remove(dhaVerification);
        dhaVerification.setNaturalPerson(null);
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setNaturalPerson(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setNaturalPerson(null);
    }

    public void addContactDetail(ContactDetail contactDetail) {
        contactDetails.add(contactDetail);
        contactDetail.setNaturalPerson(this);
    }

    public void removeContactDetail(ContactDetail contactDetail) {
        contactDetails.remove(contactDetail);
        contactDetail.setNaturalPerson(null);
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
        contract.setNaturalPerson(this);
    }

    public void removeContract(Contract contract) {
        contracts.remove(contract);
        contract.setNaturalPerson(null);
    }

    public void addIdentificationDetail(IdentificationDetail identificationDetail) {
        identificationDetails.add(identificationDetail);
        identificationDetail.setNaturalPerson(this);
    }

    public void removeIdentificationDetail(IdentificationDetail identificationDetail) {
        identificationDetails.remove(identificationDetail);
        identificationDetail.setNaturalPerson(null);
    }

    public void addRole(Role role) {
        roles.add(role);
        role.setNaturalPerson(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.setNaturalPerson(null);
    }

    public void addTaxResidency(TaxResidency taxResidency) {
        taxResidencies.add(taxResidency);
        taxResidency.setNaturalPerson(this);
    }

    public void removeTaxResidency(TaxResidency taxResidency) {
        taxResidencies.remove(taxResidency);
        taxResidency.setNaturalPerson(null);
    }

    public void addVerificationDocument(VerificationDocument verificationDocument) {
        verificationDocuments.add(verificationDocument);
        verificationDocument.setNaturalPerson(this);
    }

    public void removeVerificationDocument(VerificationDocument verificationDocument) {
        verificationDocuments.remove(verificationDocument);
        verificationDocument.setNaturalPerson(null);
    }

    public void addRequirement(Requirement requirement) {
        requirements.add(requirement);
        requirement.setNaturalPerson(this);
    }

    public void removeRequirement(Requirement requirement) {
        requirements.remove(requirement);
        requirement.setNaturalPerson(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NaturalPerson)) return false;

        NaturalPerson that = (NaturalPerson) o;

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
