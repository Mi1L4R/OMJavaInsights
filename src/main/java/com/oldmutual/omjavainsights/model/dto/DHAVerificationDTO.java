package com.oldmutual.omjavainsights.model.dto;

import com.oldmutual.omjavainsights.model.NaturalPerson;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
public class DHAVerificationDTO {

    private Long dhaVerificationId;
    private String dhaIdNumber;
    private String dhaFirstNames;
    private String dhaLastName;
    private Date dhaDateOfBirth;
    private String dhaGender;
    private Date dhaDateReceived;
    private NaturalPersonDTO naturalPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DHAVerificationDTO)) return false;

        DHAVerificationDTO that = (DHAVerificationDTO) o;

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
