package s28216.g33c.masfinal.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Administrator extends Pracownik {

    @NotBlank(message = "Rola nie może być pusta")
    @Size(min = 2, max = 100)
    private String rola;
}
