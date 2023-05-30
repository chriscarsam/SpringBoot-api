package men.voll.api.domain.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import men.voll.api.domain.address.AddressData;

public record DataUpdateDoctor(@NotNull Long id, @NotBlank String name, @NotBlank String document, @Valid AddressData address) {
}
