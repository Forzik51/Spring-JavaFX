package s28216.g33c.masfinal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import s28216.g33c.masfinal.model.Administrator;
import s28216.g33c.masfinal.model.Fabryka;
import s28216.g33c.masfinal.model.Inzynier;
import s28216.g33c.masfinal.repository.AdministratorRepository;
import s28216.g33c.masfinal.repository.InzynierRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InzynierService {

    private final InzynierRepository inzynierRepository;

    public List<Inzynier> wyswietlPracownikow() {
        return inzynierRepository.findAll();
    }
}
