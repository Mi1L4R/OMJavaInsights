package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "TaxResidency")
public class TaxResidency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaxResidencyId")
    private Long taxResidencyId;

    @OneToOne //todo find out cascade type
    @JoinColumn(name = "countryId", referencedColumnName = "countryId")
    private Country countryOfTaxResidency;

    @Column(name = "CountryOfTaxReferenceNumber")
    private String countryOfTaxReferenceNumber;

    @Column(name = "TaxIdentificationNumber")
    private String taxIdentificationNumber;

    @Column(name = "SelfCertificationDeclarationReason")
    private String selfCertificationDeclarationReason;

    @Column(name = "SelfCertificationDeclarationDate")
    private Date selfCertificationDeclarationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturalPerson naturalPerson;

    public TaxResidency(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaxResidency that = (TaxResidency) o;
        return taxResidencyId != null && Objects.equals(taxResidencyId, that.taxResidencyId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
