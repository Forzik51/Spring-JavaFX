package s28216.g33c.masfinal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s28216.g33c.masfinal.model.Administrator;
import s28216.g33c.masfinal.repository.AdministratorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministratorService  {

    private final AdministratorRepository administratorRepository;

    public List<Administrator> wyswietlPracownikow() {
        return administratorRepository.findAll();
    }
}
