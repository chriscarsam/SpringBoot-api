package men.voll.api.domain.doctor;

import men.voll.api.domain.address.AddressData;

public record MedicalResponseData(Long id, String name, String email, String phone, String document, AddressData address
) {
}
