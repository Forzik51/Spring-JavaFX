package s28216.g33c.masfinal.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s28216.g33c.masfinal.model.*;
import s28216.g33c.masfinal.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DyrektorService {

    private final DyrektorRepository dyrektorRepository;
    private final FabrykaRepository fabrykaRepository;
    private final PracownikRepository pracownikRepository;
    private final PojazdRepository pojazdRepository;
    private final KontraktRepository kontraktRepository;


    /**
     * Tworzy nową Fabrykę o podanej nazwie i lokalizacji
     */
    @Transactional
    public void TworzenieFabryki(String nazwa, String lokalizacja){

        Fabryka fabryka = Fabryka.builder()
                .nazwa(nazwa)
                .lokalizacja(lokalizacja)
                .build();

        fabrykaRepository.save(fabryka);
    }

    /**
     * Przypisuje pracownika do fabryki.
     */
    @Transactional
    public void przypiszPracownikaDoFabryki(int pracownikId, int fabrykaId) {
        Pracownik p = pracownikRepository.findById(pracownikId)
                .orElseThrow(() -> new EntityNotFoundException("Brak pracownika o id=" + pracownikId));

        Fabryka f = fabrykaRepository.findById(fabrykaId)
                .orElseThrow(() -> new EntityNotFoundException("Brak fabryki o id=" + fabrykaId));


        Fabryka poprzednia = p.getPracujeW();
        if (poprzednia != null) {
            poprzednia.getPracowniki().remove(p);
        }

        p.setPracujeW(f);

        pracownikRepository.save(p);

    }


    /**
     * Przekazuje do produkcji: klonuje pojazd o podanym id,
     *   ustawia mu nowy kontrakt i fabrykę,
     *   modyfikuje model (dokłada sekwencyjny sufiks).
     *
     */
    @Transactional
    public void przekazDoProdukcji(int idKontraktu, int idFabryki, int idPojazdu) {
        Pojazd oryg = pojazdRepository.findById(idPojazdu)
                .orElseThrow(() -> new EntityNotFoundException("Brak pojazdu " + idPojazdu));

        Kontrakt kontrakt = kontraktRepository.findById(idKontraktu)
                .orElseThrow(() -> new EntityNotFoundException("Brak kontraktu " + idKontraktu));
        Fabryka fabryka = fabrykaRepository.findById(idFabryki)
                .orElseThrow(() -> new EntityNotFoundException("Brak fabryki " + idFabryki));


        String baseModel = oryg.getModel();
        long countCopies = pojazdRepository.countByModelStartingWith(baseModel);
        String newModel = baseModel + "-" + (countCopies + 1);

        Pojazd clone;
        if (oryg instanceof Samolot s) {
            clone = Samolot.builder()
                    .model(newModel)
                    .opisStatusu("W produkcji dla kontraktu " + idKontraktu)
                    .rozpietoscSkrzydel(s.getRozpietoscSkrzydel())
                    .liczbaSilnikow(s.getLiczbaSilnikow())
                    .mocSilnika(s.getMocSilnika())
                    .build();
        } else if (oryg instanceof Tank t) {
            clone = Tank.builder()
                    .model(newModel)
                    .opisStatusu("W produkcji dla kontraktu " + idKontraktu)
                    .gruboscPancerza(t.getGruboscPancerza())
                    .waga(t.getWaga())
                    .mocSilnika(t.getMocSilnika())
                    .uzbrojenie(t.getUzbrojenie())
                    .build();
        } else {
            throw new IllegalStateException("Nieznany typ pojazdu: " + oryg.getClass());
        }

        clone.setPrzypisanyDo(kontrakt);
        clone.setProdukuje(fabryka);


        pojazdRepository.save(clone);
    }

    public List<Dyrektor> wyswietlPracownikow() {
        return dyrektorRepository.findAll();
    }

}
