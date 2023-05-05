package men.voll.api.doctor;

import men.voll.api.address.AddressData;

public record MedicalResponseData(Long id, String name, String email, String phone, String document, AddressData address
) {
}
