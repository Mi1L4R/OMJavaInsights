package com.oldmutual.omjavainsights.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "RequirementWrapperNaturalPerson")
public class RWNaturalPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RWNaturalPersonId")
    private Long rwNaturalPersonId;

    @OneToOne
    @JoinColumn(name = "requirementsWrapperId", referencedColumnName = "requirementsWrapperId" )
    private RequirementsWrapper requirementsWrapper;

    @Column(name = "DecisionId")//todo find out if this is mapped to another entity
    private String decisionId;

    public RWNaturalPerson(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RWNaturalPerson)) return false;

        RWNaturalPerson that = (RWNaturalPerson) o;

        if (getRwNaturalPersonId() != null ? !getRwNaturalPersonId().equals(that.getRwNaturalPersonId()) : that.getRwNaturalPersonId() != null)
            return false;
        if (getRequirementsWrapper() != null ? !getRequirementsWrapper().equals(that.getRequirementsWrapper()) : that.getRequirementsWrapper() != null)
            return false;
        return getDecisionId() != null ? getDecisionId().equals(that.getDecisionId()) : that.getDecisionId() == null;
    }

    @Override
    public int hashCode() {
        int result = getRwNaturalPersonId() != null ? getRwNaturalPersonId().hashCode() : 0;
        result = 31 * result + (getRequirementsWrapper() != null ? getRequirementsWrapper().hashCode() : 0);
        result = 31 * result + (getDecisionId() != null ? getDecisionId().hashCode() : 0);
        return result;
    }
}
