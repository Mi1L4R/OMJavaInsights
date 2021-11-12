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
    @JoinColumn(name = "countryId", referencedColumnName = "countryId")
    private Country countryOfBirth;

    @OneToOne //todo Need to find out cascade type
    @JoinColumn(name = "countryId", referencedColumnName = "countryId")
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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NaturalPerson that = (NaturalPerson) o;
        return naturalPersonId != null && Objects.equals(naturalPersonId, that.naturalPersonId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
