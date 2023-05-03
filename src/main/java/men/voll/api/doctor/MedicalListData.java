package men.voll.api.doctor;

import men.voll.api.patient.Patient;

public record MedicalListData(Long id, String name, String speciality, String document, String email) {

    public MedicalListData(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getSpecialty().toString(), doctor.getDocument(), doctor.getEmail());
    }
}
