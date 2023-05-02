package men.voll.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import men.voll.api.address.Address;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;

    public Doctor(MedicalRecordData medicalRecordData) {
        this.name = medicalRecordData.name();
        this.email = medicalRecordData.email();
        this.phone = medicalRecordData.phone();
        this.document = medicalRecordData.document();
        this.specialty = medicalRecordData.specialty();
        this.address = new Address(medicalRecordData.address());
    }
}
