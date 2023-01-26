package com.medhead.ers.bsns_pms.domain.entity;

import com.medhead.ers.bsns_pms.domain.valueObject.Gender;
import com.medhead.ers.bsns_pms.exception.InvalidPatientAgeException;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Patient
{
    public final static int MAXIMUM_PATIENT_AGE = 150;
    public final static int MINIMUM_PATIENT_AGE = 0;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private UUID id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName ;
    @NonNull
    private Integer age;
    private Gender gender = Gender.UNKNOWN;

    public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }

    public void setAge(int age) throws InvalidPatientAgeException {
        if(age > MAXIMUM_PATIENT_AGE || age < MINIMUM_PATIENT_AGE) {
            throw new InvalidPatientAgeException(age);
        }
        this.age = age;
    }
}
