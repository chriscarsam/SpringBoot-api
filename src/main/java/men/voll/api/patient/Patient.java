package men.voll.api.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import men.voll.api.address.Address;

@Table(name = "patients")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String identityCard;
    private String phone;

    @Embedded
    private Address address;

    public Patient(PatientRegistrationData patientRegistrationData){
        this.name = patientRegistrationData.name();
        this.email = patientRegistrationData.email();
        this.phone = patientRegistrationData.phone();
        this.identityCard = patientRegistrationData.identityCard();
        this.address = new Address(patientRegistrationData.address());
    }

}
