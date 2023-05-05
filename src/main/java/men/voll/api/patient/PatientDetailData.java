package men.voll.api.patient;

import men.voll.api.address.Address;

public record PatientDetailData(String name, String email, String phone, String identityCard, Address address) {
    public PatientDetailData(Patient patient){
        this(patient.getName(), patient.getEmail(), patient.getPhone(), patient.getIdentityCard(), patient.getAddress());
    }
}
