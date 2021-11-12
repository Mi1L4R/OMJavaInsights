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
@Table(name = "Requirement")
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequirementId")
    private Long requirementId;

    @Column(name = "Status")
    private String status;

    @OneToOne //todo find out cascading type
    @JoinColumn(name = "countryId", referencedColumnName = "countryId")
    private Country country;

    @Column(name = "RequirementsCategory")
    private String requirementsCategory;

    @Column(name = "RequirementsType")
    private String requirementsType;

    @Column(name = "RequirementsSubType")
    private String requirementsSubType;

    @Column(name = "Regulation")
    private String regulation;

    @Column(name = "Adjacency")
    private String adjacency;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "NewRequirement")
    private Boolean newRequirement;

    @ManyToOne(fetch = FetchType.LAZY)
    private RequirementsWrapper requirementsWrapper;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturalPerson naturalPerson;

    //Todo find out about below fields

    //<editor-fold desc="Fields excluded as they weren't in the rules model">
    /*@Column(name = "LocalRequirementType")
    private String localRequirementType;

    @Column(name = "LocalRequirementDescription")
    private String localRequirementDescription;

    @Column(name = "LocalRequirementStatus")
    private String localRequirementStatus;

    @Column(name = "CorrelationId")
    private String correlationId;

    @Column(name = "Evaluated")
    private Date evaluatedDate;*/
    //</editor-fold>\

    public Requirement(){

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Requirement that = (Requirement) o;
        return requirementId != null && Objects.equals(requirementId, that.requirementId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
