package men.voll.api.domain.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import men.voll.api.domain.address.Address;

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
    private Boolean active;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;

    public Doctor(MedicalRecordData medicalRecordData) {
        this.name = medicalRecordData.name();
        this.email = medicalRecordData.email();
        this.phone = medicalRecordData.phone();
        this.document = medicalRecordData.document();
        this.active = true;
        this.specialty = medicalRecordData.specialty();
        this.address = new Address(medicalRecordData.address());
    }

    public void updateData(DataUpdateDoctor dataUpdateDoctor) {
        if (dataUpdateDoctor.name() != null){
            this.name = dataUpdateDoctor.name();
        }
        if (dataUpdateDoctor.document() != null){
            this.document = dataUpdateDoctor.document();
        }
        if (dataUpdateDoctor.address() != null){
            this.address = address.updateData(dataUpdateDoctor.address());
        }
    }

    public void deactivateDoctor() {
        this.active = false;
    }
}
