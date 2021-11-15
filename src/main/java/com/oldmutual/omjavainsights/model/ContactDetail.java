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
        if (!(o instanceof ContactDetail)) return false;

        ContactDetail that = (ContactDetail) o;

        if (getContactDetailId() != null ? !getContactDetailId().equals(that.getContactDetailId()) : that.getContactDetailId() != null)
            return false;
        if (getContactType() != null ? !getContactType().equals(that.getContactType()) : that.getContactType() != null)
            return false;
        if (getCountryCode() != null ? !getCountryCode().equals(that.getCountryCode()) : that.getCountryCode() != null)
            return false;
        if (getAreaCode() != null ? !getAreaCode().equals(that.getAreaCode()) : that.getAreaCode() != null)
            return false;
        if (getNumber() != null ? !getNumber().equals(that.getNumber()) : that.getNumber() != null) return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(that.getNaturalPerson()) : that.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getContactDetailId() != null ? getContactDetailId().hashCode() : 0;
        result = 31 * result + (getContactType() != null ? getContactType().hashCode() : 0);
        result = 31 * result + (getCountryCode() != null ? getCountryCode().hashCode() : 0);
        result = 31 * result + (getAreaCode() != null ? getAreaCode().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
