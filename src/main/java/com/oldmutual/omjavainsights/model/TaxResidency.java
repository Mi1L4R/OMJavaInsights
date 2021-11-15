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
        if (!(o instanceof TaxResidency)) return false;

        TaxResidency that = (TaxResidency) o;

        if (getTaxResidencyId() != null ? !getTaxResidencyId().equals(that.getTaxResidencyId()) : that.getTaxResidencyId() != null)
            return false;
        if (getCountryOfTaxResidency() != null ? !getCountryOfTaxResidency().equals(that.getCountryOfTaxResidency()) : that.getCountryOfTaxResidency() != null)
            return false;
        if (getCountryOfTaxReferenceNumber() != null ? !getCountryOfTaxReferenceNumber().equals(that.getCountryOfTaxReferenceNumber()) : that.getCountryOfTaxReferenceNumber() != null)
            return false;
        if (getTaxIdentificationNumber() != null ? !getTaxIdentificationNumber().equals(that.getTaxIdentificationNumber()) : that.getTaxIdentificationNumber() != null)
            return false;
        if (getSelfCertificationDeclarationReason() != null ? !getSelfCertificationDeclarationReason().equals(that.getSelfCertificationDeclarationReason()) : that.getSelfCertificationDeclarationReason() != null)
            return false;
        if (getSelfCertificationDeclarationDate() != null ? !getSelfCertificationDeclarationDate().equals(that.getSelfCertificationDeclarationDate()) : that.getSelfCertificationDeclarationDate() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(that.getNaturalPerson()) : that.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getTaxResidencyId() != null ? getTaxResidencyId().hashCode() : 0;
        result = 31 * result + (getCountryOfTaxResidency() != null ? getCountryOfTaxResidency().hashCode() : 0);
        result = 31 * result + (getCountryOfTaxReferenceNumber() != null ? getCountryOfTaxReferenceNumber().hashCode() : 0);
        result = 31 * result + (getTaxIdentificationNumber() != null ? getTaxIdentificationNumber().hashCode() : 0);
        result = 31 * result + (getSelfCertificationDeclarationReason() != null ? getSelfCertificationDeclarationReason().hashCode() : 0);
        result = 31 * result + (getSelfCertificationDeclarationDate() != null ? getSelfCertificationDeclarationDate().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
