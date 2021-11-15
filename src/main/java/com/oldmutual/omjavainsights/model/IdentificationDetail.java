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
        if (!(o instanceof IdentificationDetail)) return false;

        IdentificationDetail that = (IdentificationDetail) o;

        if (getIdentificationDetailId() != null ? !getIdentificationDetailId().equals(that.getIdentificationDetailId()) : that.getIdentificationDetailId() != null)
            return false;
        if (getIdNumber() != null ? !getIdNumber().equals(that.getIdNumber()) : that.getIdNumber() != null)
            return false;
        if (getIdType() != null ? !getIdType().equals(that.getIdType()) : that.getIdType() != null) return false;
        if (getCountryOfIssue() != null ? !getCountryOfIssue().equals(that.getCountryOfIssue()) : that.getCountryOfIssue() != null)
            return false;
        if (getVisaPermitType() != null ? !getVisaPermitType().equals(that.getVisaPermitType()) : that.getVisaPermitType() != null)
            return false;
        if (getDateOfExpiry() != null ? !getDateOfExpiry().equals(that.getDateOfExpiry()) : that.getDateOfExpiry() != null)
            return false;
        if (getModifiedOn() != null ? !getModifiedOn().equals(that.getModifiedOn()) : that.getModifiedOn() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(that.getNaturalPerson()) : that.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdentificationDetailId() != null ? getIdentificationDetailId().hashCode() : 0;
        result = 31 * result + (getIdNumber() != null ? getIdNumber().hashCode() : 0);
        result = 31 * result + (getIdType() != null ? getIdType().hashCode() : 0);
        result = 31 * result + (getCountryOfIssue() != null ? getCountryOfIssue().hashCode() : 0);
        result = 31 * result + (getVisaPermitType() != null ? getVisaPermitType().hashCode() : 0);
        result = 31 * result + (getDateOfExpiry() != null ? getDateOfExpiry().hashCode() : 0);
        result = 31 * result + (getModifiedOn() != null ? getModifiedOn().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
