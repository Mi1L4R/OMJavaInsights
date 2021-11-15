package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "Country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CountryId")
    private Long countryId;

    @Column(name = "CountryCode")
    private String countryCode;

    @Column(name = "CountryClassification")
    private String countryClassification;

    @OneToOne(mappedBy = "country")
    private Address address;

    @OneToOne(mappedBy = "countryOfIssue")
    private IdentificationDetail identificationDetail;

    @OneToOne(mappedBy = "country")
    private Requirement requirement;

    @OneToOne(mappedBy = "countryOfTaxResidency")
    private TaxResidency taxResidency;

    @OneToOne(mappedBy = "countryOfBirth")
    private NaturalPerson naturalPersonCOB;

    @OneToOne(mappedBy = "countryOfResidence")
    private NaturalPerson naturalPersonCOR;

    public Country() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (getCountryId() != null ? !getCountryId().equals(country.getCountryId()) : country.getCountryId() != null)
            return false;
        if (getCountryCode() != null ? !getCountryCode().equals(country.getCountryCode()) : country.getCountryCode() != null)
            return false;
        if (getCountryClassification() != null ? !getCountryClassification().equals(country.getCountryClassification()) : country.getCountryClassification() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(country.getAddress()) : country.getAddress() != null)
            return false;
        if (getIdentificationDetail() != null ? !getIdentificationDetail().equals(country.getIdentificationDetail()) : country.getIdentificationDetail() != null)
            return false;
        if (getRequirement() != null ? !getRequirement().equals(country.getRequirement()) : country.getRequirement() != null)
            return false;
        if (getTaxResidency() != null ? !getTaxResidency().equals(country.getTaxResidency()) : country.getTaxResidency() != null)
            return false;
        if (getNaturalPersonCOB() != null ? !getNaturalPersonCOB().equals(country.getNaturalPersonCOB()) : country.getNaturalPersonCOB() != null)
            return false;
        return getNaturalPersonCOR() != null ? getNaturalPersonCOR().equals(country.getNaturalPersonCOR()) : country.getNaturalPersonCOR() == null;
    }

    @Override
    public int hashCode() {
        int result = getCountryId() != null ? getCountryId().hashCode() : 0;
        result = 31 * result + (getCountryCode() != null ? getCountryCode().hashCode() : 0);
        result = 31 * result + (getCountryClassification() != null ? getCountryClassification().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getIdentificationDetail() != null ? getIdentificationDetail().hashCode() : 0);
        result = 31 * result + (getRequirement() != null ? getRequirement().hashCode() : 0);
        result = 31 * result + (getTaxResidency() != null ? getTaxResidency().hashCode() : 0);
        result = 31 * result + (getNaturalPersonCOB() != null ? getNaturalPersonCOB().hashCode() : 0);
        result = 31 * result + (getNaturalPersonCOR() != null ? getNaturalPersonCOR().hashCode() : 0);
        return result;
    }
}
