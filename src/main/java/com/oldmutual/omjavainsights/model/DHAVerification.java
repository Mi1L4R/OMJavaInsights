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
@Table(name = "DHAVerification")
public class DHAVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DHAVerificationId")
    private Long dhaVerificationId;

    @Column(name = "DHAIdNumber")
    private String dhaIdNumber;

    @Column(name = "DHAFirstNames")
    private String dhaFirstNames;

    @Column(name = "DHALastName")
    private String dhaLastName;

    @Column(name = "DHADateOfBirth")
    private Date dhaDateOfBirth;

    @Column(name = "DHAGender")
    private String dhaGender;

    @Column(name = "DHADateReceived")
    private Date dhaDateReceived;

    @ManyToOne(fetch = FetchType.LAZY)
    private NaturalPerson naturalPerson;

    public DHAVerification() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DHAVerification that = (DHAVerification) o;
        return dhaIdNumber != null && Objects.equals(dhaIdNumber, that.dhaIdNumber);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
