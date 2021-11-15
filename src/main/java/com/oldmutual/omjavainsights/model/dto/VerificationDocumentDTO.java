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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerificationDocumentDTO)) return false;

        VerificationDocumentDTO that = (VerificationDocumentDTO) o;

        if (getVerificationDocumentId() != null ? !getVerificationDocumentId().equals(that.getVerificationDocumentId()) : that.getVerificationDocumentId() != null)
            return false;
        if (getVerificationCategory() != null ? !getVerificationCategory().equals(that.getVerificationCategory()) : that.getVerificationCategory() != null)
            return false;
        if (getVerificationDocument() != null ? !getVerificationDocument().equals(that.getVerificationDocument()) : that.getVerificationDocument() != null)
            return false;
        if (getDocumentName() != null ? !getDocumentName().equals(that.getDocumentName()) : that.getDocumentName() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getEndDate() != null ? !getEndDate().equals(that.getEndDate()) : that.getEndDate() != null) return false;
        return getModifiedOn() != null ? getModifiedOn().equals(that.getModifiedOn()) : that.getModifiedOn() == null;
    }

    @Override
    public int hashCode() {
        int result = getVerificationDocumentId() != null ? getVerificationDocumentId().hashCode() : 0;
        result = 31 * result + (getVerificationCategory() != null ? getVerificationCategory().hashCode() : 0);
        result = 31 * result + (getVerificationDocument() != null ? getVerificationDocument().hashCode() : 0);
        result = 31 * result + (getDocumentName() != null ? getDocumentName().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        return result;
    }
}
