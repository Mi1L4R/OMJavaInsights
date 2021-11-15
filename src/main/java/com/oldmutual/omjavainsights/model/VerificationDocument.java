package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "VerificationDocument")
public class VerificationDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VerificationDocumentId")
    private Long verificationDocumentId;

    @Column(name = "VerificationCategory")
    private String verificationCategory;

    @Column(name = "VerificationDocument")
    private String verificationDocument;

    @Column(name = "DocumentName")
    private String documentName;

    @Column(name = "Status")
    private String status;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "ModifiedOn")
    private Date modifiedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturalPerson naturalPerson;

    public VerificationDocument(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerificationDocument)) return false;

        VerificationDocument that = (VerificationDocument) o;

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
        if (getModifiedOn() != null ? !getModifiedOn().equals(that.getModifiedOn()) : that.getModifiedOn() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(that.getNaturalPerson()) : that.getNaturalPerson() == null;
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
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
