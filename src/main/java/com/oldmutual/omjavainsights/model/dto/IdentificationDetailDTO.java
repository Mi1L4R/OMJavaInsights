package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.NaturalPerson;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class IdentificationDetailDTO {

    private Long identificationDetailId;
    private String idNumber;
    private String idType;
    private CountryDTO countryOfIssue;
    private String visaPermitType;
    private Date dateOfExpiry;
    private Date modifiedOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdentificationDetailDTO)) return false;

        IdentificationDetailDTO that = (IdentificationDetailDTO) o;

        if (getIdentificationDetailId() != null ? !getIdentificationDetailId().equals(that.getIdentificationDetailId()) : that.getIdentificationDetailId() != null)
            return false;
        if (getIdNumber() != null ? !getIdNumber().equals(that.getIdNumber()) : that.getIdNumber() != null)
            return false;
        if (getIdType() != null ? !getIdType().equals(that.getIdType()) : that.getIdType() != null) return false;
        if (getCountryOfIssue() != null ? !getCountryOfIssue().equals(that.getCountryOfIssue()) : that.getCountryOfIssue() != null)
            return false;
        if (getVisaPermitType() != null ? !getVisaPermitType().equals(that.getVisaPermitType()) : that.getVisaPermitType() != null)
            return false;
        if (getDateOfExpiry() != null ? !getDateOfExpiry().equals(that.getDateOfExpiry()) : that.getDateOfExpiry() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(that.getModifiedOn()) : that.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdentificationDetailId() != null ? getIdentificationDetailId().hashCode() : 0;
        result = 31 * result + (getIdNumber() != null ? getIdNumber().hashCode() : 0);
        result = 31 * result + (getIdType() != null ? getIdType().hashCode() : 0);
        result = 31 * result + (getCountryOfIssue() != null ? getCountryOfIssue().hashCode() : 0);
        result = 31 * result + (getVisaPermitType() != null ? getVisaPermitType().hashCode() : 0);
        result = 31 * result + (getDateOfExpiry() != null ? getDateOfExpiry().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
