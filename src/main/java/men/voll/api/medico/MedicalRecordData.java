package men.voll.api.medico;

import men.voll.api.AddressData;

public record MedicalRecordData(String name, String email, String document, Specialty specialty, AddressData address) {
}
