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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RWNaturalPerson that = (RWNaturalPerson) o;
        return rwNaturalPersonId != null && Objects.equals(rwNaturalPersonId, that.rwNaturalPersonId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
