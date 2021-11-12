package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.Country;
import com.oldmutual.omjavainsights.model.NaturalPerson;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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

}
