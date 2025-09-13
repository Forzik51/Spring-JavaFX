package s28216.g33c.masfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class Tank  extends Pojazd {

    @NotNull(message = "Grubosc Pancera nie może być pusta")
    @Positive(message = "Grubosc Pancera musi być większa niż 0")
    private Double gruboscPancerza;

    @NotNull(message = "Waga nie może być pusta")
    @Positive(message = "Waga musi być większa niż 0")
    private Double waga;

    @NotNull(message = "Moc Silnika nie może być pusta")
    @Positive(message = "Moc Silnika musi być większa niż 0")
    private Double mocSilnika;

    @NotBlank(message = "Uzbrojenie nie może być puste")
    @Size(min = 2, max = 200)
    private String uzbrojenie;

    public Double MaksymalnaPredkosc() {
        return mocSilnika * 3 / (mocSilnika * 0.02) / (gruboscPancerza / 10);
    }
}
