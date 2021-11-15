package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.Country;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
public class TaxResidencyDTO {

    private Long taxResidencyId;
    private CountryDTO countryOfTaxResidency;
    private String countryOfTaxReferenceNumber;
    private String taxIdentificationNumber;
    private String selfCertificationDeclarationReason;
    private Date selfCertificationDeclarationDate;
    private NaturalPersonDTO naturalPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaxResidencyDTO)) return false;

        TaxResidencyDTO that = (TaxResidencyDTO) o;

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
