package s28216.g33c.masfinal.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Dyrektor extends Pracownik {

    @NotBlank(message = "Numer telefonu nie może być pusty")
    @Pattern(
            regexp = "\\+?\\d[\\d\\s-]{5,13}\\d",
            message = "Numer telefonu musi zawierać 7–15 cyfr i może mieć spacje lub myślniki"
    )
    private String numerTelefonu;

}
