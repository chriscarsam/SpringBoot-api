package men.voll.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import men.voll.api.address.AddressData;

public record DataUpdateDoctor(@NotNull Long id, String name, String document, @Valid AddressData address) {
}
