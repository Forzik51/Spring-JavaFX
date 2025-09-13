package s28216.g33c.masfinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "poziom_umiejetnosci")
public class PoziomUmietnosci {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PoziomPracownika nazwa;

    @NotBlank(message = "Opis nie może być pusty")
    @Size(min = 4, max = 500)
    private String opis;

    @OneToMany(mappedBy = "ma", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Pracownik> pracowniki = new HashSet<>();
}
