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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return roleId != null && Objects.equals(roleId, role.roleId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
