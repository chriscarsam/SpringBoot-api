package men.voll.api.patient;

import men.voll.api.doctor.Doctor;

public record PatientListData(Long id, String name, String identityCard, String phone, String email) {

    public PatientListData(Patient patient){
        this(patient.getId(), patient.getName(), patient.getIdentityCard(), patient.getPhone(), patient.getEmail());
    }
}
