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
@Table(name = "ContactDetail")
public class ContactDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContactDetailId")
    private Long contactDetailId;

    @Column(name = "ContactType")
    private String contactType;

    @Column(name = "CountryCode")
    private String countryCode;

    @Column(name = "AreaCode")
    private String areaCode;

    @Column(name = "Number")
    private String number;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturalPerson naturalPerson;

    public ContactDetail() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ContactDetail that = (ContactDetail) o;
        return contactDetailId != null && Objects.equals(contactDetailId, that.contactDetailId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
