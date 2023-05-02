package men.voll.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import men.voll.api.address.AddressData;

public record MedicalRecordData(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String document,
        @NotNull Specialty specialty,
        @NotNull @Valid AddressData address) {
}
