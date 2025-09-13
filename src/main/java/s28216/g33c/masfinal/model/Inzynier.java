package s28216.g33c.masfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class Inzynier extends Pracownik{

    @NotBlank(message = "Specjalosc nie może być pusta")
    @Size(min = 4, max = 50)
    private String specjalnosc;

    @ManyToMany(mappedBy = "projektuje")
    @ToString.Exclude
    private Set<Pojazd> employees = new HashSet<>();
}
