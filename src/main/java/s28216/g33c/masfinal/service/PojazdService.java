package s28216.g33c.masfinal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s28216.g33c.masfinal.model.Kontrakt;
import s28216.g33c.masfinal.model.Pojazd;
import s28216.g33c.masfinal.repository.PojazdRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PojazdService {

    private final PojazdRepository pojazdRepository;

    public List<Pojazd> wyswietlPojazdy() {
        return pojazdRepository.findAll();
    }

}
