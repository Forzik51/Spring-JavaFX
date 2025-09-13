package s28216.g33c.masfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s28216.g33c.masfinal.model.Dyrektor;

@Repository
public interface DyrektorRepository extends JpaRepository<Dyrektor, Integer> {
}
