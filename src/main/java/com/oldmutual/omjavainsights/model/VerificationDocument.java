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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VerificationDocument that = (VerificationDocument) o;
        return verificationDocumentId != null && Objects.equals(verificationDocumentId, that.verificationDocumentId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
