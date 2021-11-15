package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.NaturalPerson;
import lombok.Data;

@Data
public class ContactDetailDTO {

    private Long contactDetailId;
    private String contactType;
    private String countryCode;
    private String areaCode;
    private String number;
    private String phoneNumber;
    private NaturalPersonDTO naturalPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactDetailDTO)) return false;

        ContactDetailDTO that = (ContactDetailDTO) o;

        if (getContactDetailId() != null ? !getContactDetailId().equals(that.getContactDetailId()) : that.getContactDetailId() != null)
            return false;
        if (getContactType() != null ? !getContactType().equals(that.getContactType()) : that.getContactType() != null)
            return false;
        if (getCountryCode() != null ? !getCountryCode().equals(that.getCountryCode()) : that.getCountryCode() != null)
            return false;
        if (getAreaCode() != null ? !getAreaCode().equals(that.getAreaCode()) : that.getAreaCode() != null)
            return false;
        if (getNumber() != null ? !getNumber().equals(that.getNumber()) : that.getNumber() != null) return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(that.getNaturalPerson()) : that.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getContactDetailId() != null ? getContactDetailId().hashCode() : 0;
        result = 31 * result + (getContactType() != null ? getContactType().hashCode() : 0);
        result = 31 * result + (getCountryCode() != null ? getCountryCode().hashCode() : 0);
        result = 31 * result + (getAreaCode() != null ? getAreaCode().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
