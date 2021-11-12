package com.oldmutual.omjavainsights.model.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class VerificationDocumentDTO {

    private Long verificationDocumentId;
    private String verificationCategory;
    private String verificationDocument;
    private String documentName;
    private String status;
    private Date endDate;
    private Date modifiedOn;
}
