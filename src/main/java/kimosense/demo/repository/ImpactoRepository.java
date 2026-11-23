package kimosense.demo.repository;

import java.util.List;
import kimosense.demo.model.Impacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpactoRepository extends JpaRepository<Impacto, Long> {

    List<Impacto> findByZonaCuerpoIgnoreCase(String zonaCuerpo);
}