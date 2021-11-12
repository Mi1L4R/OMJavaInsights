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
@Table(name = "IdentificationDetail")
public class IdentificationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdentificationDetailId")
    private Long identificationDetailId;

    @Column(name = "IDNumber")
    private String idNumber;

    @Column(name = "IDType")
    private String idType;

    @OneToOne //todo find out cascading type
    @JoinColumn(name = "countryId", referencedColumnName = "countryId")
    private Country countryOfIssue;

    @Column(name = "VisaPermitType")
    private String visaPermitType;

    @Column(name = "DateOfExpiry")
    private Date dateOfExpiry;

    @Column(name = "ModifiedOn")
    private Date modifiedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturalPerson naturalPerson;

    public IdentificationDetail() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IdentificationDetail that = (IdentificationDetail) o;
        return identificationDetailId != null && Objects.equals(identificationDetailId, that.identificationDetailId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
