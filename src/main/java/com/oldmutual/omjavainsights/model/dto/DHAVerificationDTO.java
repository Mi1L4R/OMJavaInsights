package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.NaturalPerson;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
public class DHAVerificationDTO {

    private Long dhaVerificationId;
    private String dhaIdNumber;
    private String dhaFirstNames;
    private String dhaLastName;
    private Date dhaDateOfBirth;
    private String dhaGender;
    private Date dhaDateReceived;
}
