package s28216.g33c.masfinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Osoba {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Pesel nie może być pusty")
    @Pattern(regexp = "\\d{11}",
            message = "PESEL musi składać się z dokładnie 11 cyfr.")
    private String PESEL;


    @NotBlank(message = "Imię nie może być puste")
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-ZŁŚĆŻŹŃÓĄĘ][a-złśźćżźńóąę-]{2,50}$",
            message = "Imię powinno zaczynać się wielką literą i zawierać tylko litery.")
    private String imie;

    @NotBlank(message = "Nazwisko nie może być puste")
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-ZŁŚĆŻŹŃÓĄĘ][a-złśźćżźńóąę-]{2,50}$",
            message = "Nazwisko powinno zaczynać się wielką literą i zawierać tylko litery.")
    private String nazwisko;


    @NotBlank(message = "Email nie może być pusty")
    @Email(message = "Niepoprawny Email.")
    private String adresEmail;

}
