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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScreeningDTO)) return false;

        ScreeningDTO that = (ScreeningDTO) o;

        if (getScreeningId() != null ? !getScreeningId().equals(that.getScreeningId()) : that.getScreeningId() != null)
            return false;
        if (getAmeOutcome() != null ? !getAmeOutcome().equals(that.getAmeOutcome()) : that.getAmeOutcome() != null)
            return false;
        if (getAmlOutcome() != null ? !getAmlOutcome().equals(that.getAmlOutcome()) : that.getAmlOutcome() != null)
            return false;
        if (getDateRequested() != null ? !getDateRequested().equals(that.getDateRequested()) : that.getDateRequested() != null)
            return false;
        if (getSanctionsOutcome() != null ? !getSanctionsOutcome().equals(that.getSanctionsOutcome()) : that.getSanctionsOutcome() != null)
            return false;
        if (getScreeningStatus() != null ? !getScreeningStatus().equals(that.getScreeningStatus()) : that.getScreeningStatus() != null)
            return false;
        if (getDpipOutcome() != null ? !getDpipOutcome().equals(that.getDpipOutcome()) : that.getDpipOutcome() != null)
            return false;
        if (getFppoOutcome() != null ? !getFppoOutcome().equals(that.getFppoOutcome()) : that.getFppoOutcome() != null)
            return false;
        if (getRcafppoOutcome() != null ? !getRcafppoOutcome().equals(that.getRcafppoOutcome()) : that.getRcafppoOutcome() != null)
            return false;
        if (getRcadpipOutcome() != null ? !getRcadpipOutcome().equals(that.getRcadpipOutcome()) : that.getRcadpipOutcome() != null)
            return false;
        if (getScreeningResultType() != null ? !getScreeningResultType().equals(that.getScreeningResultType()) : that.getScreeningResultType() != null)
            return false;
        return getModifiedOn() != null ? getModifiedOn().equals(that.getModifiedOn()) : that.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getScreeningId() != null ? getScreeningId().hashCode() : 0;
        result = 31 * result + (getAmeOutcome() != null ? getAmeOutcome().hashCode() : 0);
        result = 31 * result + (getAmlOutcome() != null ? getAmlOutcome().hashCode() : 0);
        result = 31 * result + (getDateRequested() != null ? getDateRequested().hashCode() : 0);
        result = 31 * result + (getSanctionsOutcome() != null ? getSanctionsOutcome().hashCode() : 0);
        result = 31 * result + (getScreeningStatus() != null ? getScreeningStatus().hashCode() : 0);
        result = 31 * result + (getDpipOutcome() != null ? getDpipOutcome().hashCode() : 0);
        result = 31 * result + (getFppoOutcome() != null ? getFppoOutcome().hashCode() : 0);
        result = 31 * result + (getRcafppoOutcome() != null ? getRcafppoOutcome().hashCode() : 0);
        result = 31 * result + (getRcadpipOutcome() != null ? getRcadpipOutcome().hashCode() : 0);
        result = 31 * result + (getScreeningResultType() != null ? getScreeningResultType().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
