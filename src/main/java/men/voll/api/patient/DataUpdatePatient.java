package men.voll.api.patient;

import jakarta.validation.Valid;
import men.voll.api.address.AddressData;

public record DataUpdatePatient(Long id, String name, String phone , @Valid AddressData address) {
}
