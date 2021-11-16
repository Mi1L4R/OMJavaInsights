package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.Address;
import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.NaturalPerson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
public class AddressDTO {

    private Long addressId;
    private String addressLineOne;
    private String addressLineTwo;
    private String addressLineThree;
    private String addressLineFour;
    private String city;
    private String postalCode;
    private CountryDTO country;
    private String careOfIndicator;
    private String careOfName;
    private Date modifiedOn;
    private NaturalPersonDTO naturalPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDTO)) return false;

        AddressDTO that = (AddressDTO) o;

        if (getAddressId() != null ? !getAddressId().equals(that.getAddressId()) : that.getAddressId() != null)
            return false;
        if (getAddressLineOne() != null ? !getAddressLineOne().equals(that.getAddressLineOne()) : that.getAddressLineOne() != null)
            return false;
        if (getAddressLineTwo() != null ? !getAddressLineTwo().equals(that.getAddressLineTwo()) : that.getAddressLineTwo() != null)
            return false;
        if (getAddressLineThree() != null ? !getAddressLineThree().equals(that.getAddressLineThree()) : that.getAddressLineThree() != null)
            return false;
        if (getAddressLineFour() != null ? !getAddressLineFour().equals(that.getAddressLineFour()) : that.getAddressLineFour() != null)
            return false;
        if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null) return false;
        if (getPostalCode() != null ? !getPostalCode().equals(that.getPostalCode()) : that.getPostalCode() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(that.getCountry()) : that.getCountry() != null) return false;
        if (getCareOfIndicator() != null ? !getCareOfIndicator().equals(that.getCareOfIndicator()) : that.getCareOfIndicator() != null)
            return false;
        if (getCareOfName() != null ? !getCareOfName().equals(that.getCareOfName()) : that.getCareOfName() != null)
            return false;
        if (getModifiedOn() != null ? !getModifiedOn().equals(that.getModifiedOn()) : that.getModifiedOn() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(that.getNaturalPerson()) : that.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getAddressId() != null ? getAddressId().hashCode() : 0;
        result = 31 * result + (getAddressLineOne() != null ? getAddressLineOne().hashCode() : 0);
        result = 31 * result + (getAddressLineTwo() != null ? getAddressLineTwo().hashCode() : 0);
        result = 31 * result + (getAddressLineThree() != null ? getAddressLineThree().hashCode() : 0);
        result = 31 * result + (getAddressLineFour() != null ? getAddressLineFour().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getCareOfIndicator() != null ? getCareOfIndicator().hashCode() : 0);
        result = 31 * result + (getCareOfName() != null ? getCareOfName().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }


}
