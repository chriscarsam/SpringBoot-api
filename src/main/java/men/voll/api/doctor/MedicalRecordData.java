package men.voll.api.doctor;

import men.voll.api.address.AddressData;

public record MedicalRecordData(String name, String email, String document, Specialty specialty, AddressData address) {
}
