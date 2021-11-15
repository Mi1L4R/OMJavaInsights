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
        if (!(o instanceof DHAVerification)) return false;

        DHAVerification that = (DHAVerification) o;

        if (getDhaVerificationId() != null ? !getDhaVerificationId().equals(that.getDhaVerificationId()) : that.getDhaVerificationId() != null)
            return false;
        if (getDhaIdNumber() != null ? !getDhaIdNumber().equals(that.getDhaIdNumber()) : that.getDhaIdNumber() != null)
            return false;
        if (getDhaFirstNames() != null ? !getDhaFirstNames().equals(that.getDhaFirstNames()) : that.getDhaFirstNames() != null)
            return false;
        if (getDhaLastName() != null ? !getDhaLastName().equals(that.getDhaLastName()) : that.getDhaLastName() != null)
            return false;
        if (getDhaDateOfBirth() != null ? !getDhaDateOfBirth().equals(that.getDhaDateOfBirth()) : that.getDhaDateOfBirth() != null)
            return false;
        if (getDhaGender() != null ? !getDhaGender().equals(that.getDhaGender()) : that.getDhaGender() != null)
            return false;
        if (getDhaDateReceived() != null ? !getDhaDateReceived().equals(that.getDhaDateReceived()) : that.getDhaDateReceived() != null)
            return false;
        return getNaturalPerson() != null ? getNaturalPerson().equals(that.getNaturalPerson()) : that.getNaturalPerson() == null;
    }

    @Override
    public int hashCode() {
        int result = getDhaVerificationId() != null ? getDhaVerificationId().hashCode() : 0;
        result = 31 * result + (getDhaIdNumber() != null ? getDhaIdNumber().hashCode() : 0);
        result = 31 * result + (getDhaFirstNames() != null ? getDhaFirstNames().hashCode() : 0);
        result = 31 * result + (getDhaLastName() != null ? getDhaLastName().hashCode() : 0);
        result = 31 * result + (getDhaDateOfBirth() != null ? getDhaDateOfBirth().hashCode() : 0);
        result = 31 * result + (getDhaGender() != null ? getDhaGender().hashCode() : 0);
        result = 31 * result + (getDhaDateReceived() != null ? getDhaDateReceived().hashCode() : 0);
        result = 31 * result + (getNaturalPerson() != null ? getNaturalPerson().hashCode() : 0);
        return result;
    }
}
