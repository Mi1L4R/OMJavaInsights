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
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId")
    private Long roleId;

    @Column(name = "RoleDescription")
    private String roleDescription;

    @Column(name = "RoleCategory")
    private String roleCategory;

    @Column(name = "ScreeningRole")
    private String screeningRole;

    @Column(name = "DeterminedNationality") //todo find out if this should be a country object
    private String determinedNationality;

    @OneToOne(mappedBy = "roleInTransaction")
    private RequirementsWrapper requirementsWrapper;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturalPerson naturalPerson;

    public Role(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (getRoleId() != null ? !getRoleId().equals(role.getRoleId()) : role.getRoleId() != null) return false;
        if (getRoleDescription() != null ? !getRoleDescription().equals(role.getRoleDescription()) : role.getRoleDescription() != null)
            return false;
        if (getRoleCategory() != null ? !getRoleCategory().equals(role.getRoleCategory()) : role.getRoleCategory() != null)
            return false;
        if (getScreeningRole() != null ? !getScreeningRole().equals(role.getScreeningRole()) : role.getScreeningRole() != null)
            return false;
        if (getDeterminedNationality() != null ? !getDeterminedNationality().equals(role.getDeterminedNationality()) : role.getDeterminedNationality() != null)
            return false;
        if (getRequirementsWrapper() != null ? !getRequirementsWrapper().equals(role.getRequirementsWrapper()) : role.getRequirementsWrapper() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(role.getNaturalPerson()) : role.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getRoleId() != null ? getRoleId().hashCode() : 0;
        result = 31 * result + (getRoleDescription() != null ? getRoleDescription().hashCode() : 0);
        result = 31 * result + (getRoleCategory() != null ? getRoleCategory().hashCode() : 0);
        result = 31 * result + (getScreeningRole() != null ? getScreeningRole().hashCode() : 0);
        result = 31 * result + (getDeterminedNationality() != null ? getDeterminedNationality().hashCode() : 0);
        result = 31 * result + (getRequirementsWrapper() != null ? getRequirementsWrapper().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
