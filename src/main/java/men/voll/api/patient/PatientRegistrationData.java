package men.voll.api.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import men.voll.api.address.AddressData;

public record PatientRegistrationData(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String phone,
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String identityCard,
        @NotNull @Valid AddressData address
        ) {
}
