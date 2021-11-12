package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "RequirementsWrapper")
public class RequirementsWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequirementsWrapperId")
    private Long requirementsWrapperId;

    @OneToOne
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Role roleInTransaction;

    @Column(name = "FullRequirements")
    private Boolean fullRequirements;

    @Column(name = "PartyCategorization")
    private String partyCategorization;

    @OneToMany(mappedBy = "requirementsWrapper")
    @ToString.Exclude//todo figure out cascade type and orphanRemoval
    private List<Requirement> requirementsOutput = new ArrayList<>();

    @Column(name = "RiskRatingDoneForActiveTransactions")
    private String riskRatingDoneForActiveTransactions;

    @Column(name = "ScreeningDoneForActiveTransactions")
    private String screeningDoneForActiveTransactions;

    //todo find out if we need below property
    @Column(name = "HadMarkers")
    private String hadMarkers;

    @OneToOne(mappedBy = "requirementsWrapper")
    private RWNaturalPerson rwNaturalPerson;


    public RequirementsWrapper(){

    }

    public void addRequirement(Requirement requirement){
        requirementsOutput.add(requirement);
        requirement.setRequirementsWrapper(this);
    }

    public void removeRequirement(Requirement requirement){
        requirementsOutput.remove(requirement);
        requirement.setRequirementsWrapper(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RequirementsWrapper that = (RequirementsWrapper) o;
        return requirementsWrapperId != null && Objects.equals(requirementsWrapperId, that.requirementsWrapperId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
