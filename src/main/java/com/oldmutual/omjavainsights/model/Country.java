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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Country country = (Country) o;
        return countryId != null && Objects.equals(countryId, country.countryId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
