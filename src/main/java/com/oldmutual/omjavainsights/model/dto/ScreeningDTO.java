package com.oldmutual.omjavainsights.model.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class ScreeningDTO {

    private Long screeningId;
    private String ameOutcome;
    private String amlOutcome;
    private Date dateRequested;
    private String sanctionsOutcome;
    private String screeningStatus;
    private String dpipOutcome;
    private String fppoOutcome;
    private String rcafppoOutcome;
    private String rcadpipOutcome;
    private String screeningResultType;
    private Date modifiedOn;
}
