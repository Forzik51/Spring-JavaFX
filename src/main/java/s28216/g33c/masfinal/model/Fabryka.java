package s28216.g33c.masfinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fabryka {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "fabryka_seq")
    @SequenceGenerator(
            name = "fabryka_seq",
            sequenceName = "fabryka_sequence",
            initialValue = 4,
            allocationSize = 1
    )
    private int id;

    @NotBlank(message = "Nazwa nie może być pusta")
    @Size(min = 2, max = 50)
    private String nazwa;

    @NotBlank(message = "Lokalizacja nie może być puste")
    @Size(min = 2, max = 50)
    private String lokalizacja;

    @OneToMany(mappedBy = "pracujeW", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Pracownik> pracowniki = new HashSet<>();

    @OneToMany(mappedBy = "produkuje",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Pojazd> pojazdy = new HashSet<>();
}
