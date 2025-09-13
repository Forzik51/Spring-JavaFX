package s28216.g33c.masfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Klient extends Osoba {

    @NotBlank(message = "Nazwa firmy nie może być pusta")
    @Size(min = 2, max = 50)
    private String nazwaFirmy;

    @OneToMany(mappedBy = "tworzy", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Kontrakt> kontrakts = new HashSet<>();
}
