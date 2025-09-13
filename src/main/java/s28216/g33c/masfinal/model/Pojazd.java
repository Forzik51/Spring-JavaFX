package s28216.g33c.masfinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter
@SuperBuilder
public class Pojazd {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pojazd_seq")
    @SequenceGenerator(
            name = "pojazd_seq",
            sequenceName = "pojazd_sequence",
            initialValue = 4,
            allocationSize = 1
    )
    private int id;

    @NotBlank(message = "Model nie może być pusty")
    //@Column(unique = true)
    private String model;

    @NotBlank(message = "Opis statusu nie może być pusty")
    @Size(min = 2, max = 2000)
    private String opisStatusu;

    @OneToMany(mappedBy = "skladaSieZ", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Czesc> czesci = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Pojazd_Inzynier",
            joinColumns = { @JoinColumn(name = "pojazd_id") },
            inverseJoinColumns = { @JoinColumn(name = "inzynier_id") }
    )
    Set<Inzynier> projektuje = new HashSet<>();


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Pojazd_Mechanik",
            joinColumns = { @JoinColumn(name = "pojazd_id") },
            inverseJoinColumns = { @JoinColumn(name = "mechanik_id") }
    )
    Set<Mechanik> konstruuje = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "kontrakt_id", nullable = false)
    @NotNull
    private Kontrakt przypisanyDo;

    @ManyToOne
    @JoinColumn(name = "fabryka_id", nullable = false)
    @NotNull
    private Fabryka produkuje;


}
