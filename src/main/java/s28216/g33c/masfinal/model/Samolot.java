package s28216.g33c.masfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class Samolot extends Pojazd {

    @NotNull(message = "Rozpoetosc Skrzydel nie może być pusta")
    @Positive(message = "Rozpoetosc Skrzydel musi być większa niż 0")
    private Double rozpietoscSkrzydel;

    @NotNull(message = "liczba Silnikow nie może być pusta")
    @Positive(message = "liczba Silnikow musi być większa niż 0")
    private int liczbaSilnikow;

    @NotNull(message = "Moc Silnika nie może być pusta")
    @Positive(message = "Moc Silnika musi być większa niż 0")
    private Double mocSilnika;


    public Double MaksymalnaWysokosc(){
        return mocSilnika * liczbaSilnikow / rozpietoscSkrzydel ;
    }

}
