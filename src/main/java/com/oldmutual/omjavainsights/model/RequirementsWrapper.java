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
        if (!(o instanceof RequirementsWrapper)) return false;

        RequirementsWrapper that = (RequirementsWrapper) o;

        if (getRequirementsWrapperId() != null ? !getRequirementsWrapperId().equals(that.getRequirementsWrapperId()) : that.getRequirementsWrapperId() != null)
            return false;
        if (getRoleInTransaction() != null ? !getRoleInTransaction().equals(that.getRoleInTransaction()) : that.getRoleInTransaction() != null)
            return false;
        if (getFullRequirements() != null ? !getFullRequirements().equals(that.getFullRequirements()) : that.getFullRequirements() != null)
            return false;
        if (getPartyCategorization() != null ? !getPartyCategorization().equals(that.getPartyCategorization()) : that.getPartyCategorization() != null)
            return false;
        if (getRequirementsOutput() != null ? !getRequirementsOutput().equals(that.getRequirementsOutput()) : that.getRequirementsOutput() != null)
            return false;
        if (getRiskRatingDoneForActiveTransactions() != null ? !getRiskRatingDoneForActiveTransactions().equals(that.getRiskRatingDoneForActiveTransactions()) : that.getRiskRatingDoneForActiveTransactions() != null)
            return false;
        if (getScreeningDoneForActiveTransactions() != null ? !getScreeningDoneForActiveTransactions().equals(that.getScreeningDoneForActiveTransactions()) : that.getScreeningDoneForActiveTransactions() != null)
            return false;
        if (getHadMarkers() != null ? !getHadMarkers().equals(that.getHadMarkers()) : that.getHadMarkers() != null)
            return false;
        return getRwNaturalPerson() != null ? getRwNaturalPerson().equals(that.getRwNaturalPerson()) : that.getRwNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getRequirementsWrapperId() != null ? getRequirementsWrapperId().hashCode() : 0;
        result = 31 * result + (getRoleInTransaction() != null ? getRoleInTransaction().hashCode() : 0);
        result = 31 * result + (getFullRequirements() != null ? getFullRequirements().hashCode() : 0);
        result = 31 * result + (getPartyCategorization() != null ? getPartyCategorization().hashCode() : 0);
        result = 31 * result + (getRequirementsOutput() != null ? getRequirementsOutput().hashCode() : 0);
        result = 31 * result + (getRiskRatingDoneForActiveTransactions() != null ? getRiskRatingDoneForActiveTransactions().hashCode() : 0);
        result = 31 * result + (getScreeningDoneForActiveTransactions() != null ? getScreeningDoneForActiveTransactions().hashCode() : 0);
        result = 31 * result + (getHadMarkers() != null ? getHadMarkers().hashCode() : 0);
        result = 31 * result + (getRwNaturalPerson() != null ? getRwNaturalPerson().hashCode() : 0);
        return result;
    }
}
