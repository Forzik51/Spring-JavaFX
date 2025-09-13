package s28216.g33c.masfinal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s28216.g33c.masfinal.model.Kontrakt;
import s28216.g33c.masfinal.repository.KontraktRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KontraktService {

    private final KontraktRepository kontraktRepository;

    public List<Kontrakt> wyswietlKontrakty() {
        return kontraktRepository.findAll();
    }

    public Kontrakt wyswietlKontrakt(int id) {
        return kontraktRepository.findById(id).get();
    }

}
