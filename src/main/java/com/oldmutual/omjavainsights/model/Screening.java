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
@Table(name = "Screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScreeningId")
    private Long screeningId;

    @Column(name = "AMEOutcome")
    private String ameOutcome;

    @Column(name = "AMLOutcome")
    private String amlOutcome;

    @Column(name = "DateRequested")
    private Date dateRequested;

    @Column(name = "SanctionsOutcome")
    private String sanctionsOutcome;

    @Column(name = "ScreeningStatus")
    private String screeningStatus;

    @Column(name = "DPIPOutcome")
    private String dpipOutcome;

    @Column(name = "FPPOOutcome")
    private String fppoOutcome;

    @Column(name = "RCAFPPOOutcome")
    private String rcafppoOutcome;

    @Column(name = "RCADPIPOutcome")
    private String rcadpipOutcome;

    @Column(name = "ScreeningResultType")
    private String screeningResultType;

    @Column(name = "ModifiedOn")
    private Date modifiedOn;

    @OneToOne(mappedBy = "screening")
    private NaturalPerson naturalPerson;


    public Screening(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Screening)) return false;

        Screening screening = (Screening) o;

        if (getScreeningId() != null ? !getScreeningId().equals(screening.getScreeningId()) : screening.getScreeningId() != null)
            return false;
        if (getAmeOutcome() != null ? !getAmeOutcome().equals(screening.getAmeOutcome()) : screening.getAmeOutcome() != null)
            return false;
        if (getAmlOutcome() != null ? !getAmlOutcome().equals(screening.getAmlOutcome()) : screening.getAmlOutcome() != null)
            return false;
        if (getDateRequested() != null ? !getDateRequested().equals(screening.getDateRequested()) : screening.getDateRequested() != null)
            return false;
        if (getSanctionsOutcome() != null ? !getSanctionsOutcome().equals(screening.getSanctionsOutcome()) : screening.getSanctionsOutcome() != null)
            return false;
        if (getScreeningStatus() != null ? !getScreeningStatus().equals(screening.getScreeningStatus()) : screening.getScreeningStatus() != null)
            return false;
        if (getDpipOutcome() != null ? !getDpipOutcome().equals(screening.getDpipOutcome()) : screening.getDpipOutcome() != null)
            return false;
        if (getFppoOutcome() != null ? !getFppoOutcome().equals(screening.getFppoOutcome()) : screening.getFppoOutcome() != null)
            return false;
        if (getRcafppoOutcome() != null ? !getRcafppoOutcome().equals(screening.getRcafppoOutcome()) : screening.getRcafppoOutcome() != null)
            return false;
        if (getRcadpipOutcome() != null ? !getRcadpipOutcome().equals(screening.getRcadpipOutcome()) : screening.getRcadpipOutcome() != null)
            return false;
        if (getScreeningResultType() != null ? !getScreeningResultType().equals(screening.getScreeningResultType()) : screening.getScreeningResultType() != null)
            return false;
        if (getModifiedOn() != null ? !getModifiedOn().equals(screening.getModifiedOn()) : screening.getModifiedOn() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(screening.getNaturalPerson()) : screening.getNaturalPerson() == null;
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
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
