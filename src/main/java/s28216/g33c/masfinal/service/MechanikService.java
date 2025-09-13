package s28216.g33c.masfinal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import s28216.g33c.masfinal.model.Inzynier;
import s28216.g33c.masfinal.model.Mechanik;
import s28216.g33c.masfinal.repository.MechanikRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MechanikService {

    private final MechanikRepository mechanikRepository;

    public List<Mechanik> wyswietlPracownikow() {
        return mechanikRepository.findAll();
    }
}
