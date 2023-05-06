package men.voll.api.domain.patient;

import jakarta.validation.Valid;
import men.voll.api.domain.address.AddressData;

public record DataUpdatePatient(Long id, String name, String phone , @Valid AddressData address) {
}
