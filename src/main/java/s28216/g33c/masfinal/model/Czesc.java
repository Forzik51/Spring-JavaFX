package s28216.g33c.masfinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Czesc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Imię nie może być puste")
    @Size(min = 2, max = 50)
    private String nazwa;

    @NotBlank(message = "Imię nie może być puste")
    @Size(min = 2, max = 1000)
    private String opis;

    @NotNull(message = "Cena nie może być pusta")
    @Positive(message = "Cena musi być większa niż 0")
    private Double cena;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pojazd_id", nullable = false, updatable = false)
    private Pojazd skladaSieZ;
}
