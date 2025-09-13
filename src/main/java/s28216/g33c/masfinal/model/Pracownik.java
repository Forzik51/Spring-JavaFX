package s28216.g33c.masfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Pracownik extends Osoba {

    @NotNull(message = "Data rozpoczecia nie może być pusta")
    private LocalDate dataRozpoczecia;

    private LocalDate dataZakonczenia;

    @NotNull(message = "Pensja nie może być pusta")
    @Positive(message = "Pensja musi być większa niż 0")
    private Double pensja;



    @AssertTrue(
            message = "Data zakończenia nie może być wcześniejsza niż data rozpoczęcia"
    )
    private boolean isDateRangeValid() {
        if (dataZakonczenia == null) {
            return true;
        }
        return !dataZakonczenia.isBefore(dataRozpoczecia);
    }

    @ManyToOne
    @JoinColumn(name = "fabryka_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Fabryka pracujeW;

    @ManyToOne
    @JoinColumn(name = "poziom_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PoziomUmietnosci ma;
}


