package s28216.g33c.masfinal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s28216.g33c.masfinal.model.Fabryka;
import s28216.g33c.masfinal.model.Kontrakt;
import s28216.g33c.masfinal.repository.FabrykaRepository;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FabrykaService {

    private final FabrykaRepository fabrykaRepository;

    public List<Fabryka> wyswietlFabryki() {
        return fabrykaRepository.findAll();
    }

}
