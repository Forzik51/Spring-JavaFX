package s28216.g33c.masfinal.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s28216.g33c.masfinal.model.Pracownik;
import s28216.g33c.masfinal.repository.PracownikRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public  class PracownikService  {

    private final PracownikRepository pracownikRepository;

    public List<Pracownik> WyswietlPracownikow(){
        return pracownikRepository.findAll();
    }
}
