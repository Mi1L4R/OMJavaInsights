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
}
