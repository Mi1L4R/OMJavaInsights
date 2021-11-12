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

    /**
     * Todo
     * - Add Natural Person Object
     *
     * private NaturalPerson naturalPerson;
     */

    public Screening(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Screening screening = (Screening) o;
        return screeningId != null && Objects.equals(screeningId, screening.screeningId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
