package s28216.g33c.masfinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Mechanik extends Pracownik {

    @NotBlank(message = "Doswiadczenie nie może być puste")
    @Size(min = 2, max = 100)
    private String doswiadczenie;

    @ToString.Exclude
    @ManyToMany(mappedBy = "konstruuje")
    private Set<Pojazd> employees = new HashSet<>();
}
