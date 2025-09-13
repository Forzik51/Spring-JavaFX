package s28216.g33c.masfinal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s28216.g33c.masfinal.model.Pracownik;

import java.util.List;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik, Integer>  {
}
