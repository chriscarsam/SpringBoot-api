package men.voll.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressData(
        @NotBlank String street,
        @NotBlank String district,
        @NotBlank String city,
        @NotNull int number,
        @NotBlank String complement) {
}
