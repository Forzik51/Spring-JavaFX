package s28216.g33c.masfinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kontrakt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Opis nie może być pusty")
    @Size(min = 5, max = 500)
    private String opis;

    @NotNull(message = "Wartość nie może być pusta")
    @Positive(message = "Wartość musi być większa niż 0")
    private Double wartoscKontraktu;

    @NotNull(message = "Liczba nie może być pusta")
    @Positive(message = "Liczba musi być większa niż 0")
    private int liczba;

    @NotBlank(message = "Status nie może być pusty")
    @Enumerated(EnumType.STRING)
    private KontraktStatus status;

    @ManyToOne
    @JoinColumn(name = "klient_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Klient tworzy;

    @OneToMany(mappedBy = "przypisanyDo",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Pojazd> pojazdy = new HashSet<>();

}
