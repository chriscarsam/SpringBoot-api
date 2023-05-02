package men.voll.api.doctor;

public record MedicalListData(String name, String speciality, String document, String email) {

    public MedicalListData(Doctor doctor){
        this(doctor.getName(), doctor.getSpecialty().toString(), doctor.getDocument(), doctor.getEmail());
    }
}
