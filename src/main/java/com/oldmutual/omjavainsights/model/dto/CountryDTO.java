package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.*;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;

@Data
public class CountryDTO {

    private Long countryId;
    private String countryCode;
    private String countryClassification;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryDTO)) return false;

        CountryDTO that = (CountryDTO) o;

        if (getCountryId() != null ? !getCountryId().equals(that.getCountryId()) : that.getCountryId() != null)
            return false;
        if (getCountryCode() != null ? !getCountryCode().equals(that.getCountryCode()) : that.getCountryCode() != null)
            return false;
        return getCountryClassification() != null ? getCountryClassification().equals(that.getCountryClassification()) : that.getCountryClassification() == null;
    }

    @Override
    public int hashCode() {
        int result = getCountryId() != null ? getCountryId().hashCode() : 0;
        result = 31 * result + (getCountryCode() != null ? getCountryCode().hashCode() : 0);
        result = 31 * result + (getCountryClassification() != null ? getCountryClassification().hashCode() : 0);
        return result;
    }
}
