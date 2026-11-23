package kimosense.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import kimosense.demo.model.Impacto;
import kimosense.demo.repository.ImpactoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ImpactoService {

    private final ImpactoRepository repository;

    public ImpactoService(ImpactoRepository repository) {
        this.repository = repository;
    }

    public List<Impacto> listar(String zona) {
        if (zona == null || zona.isBlank()) {
            return repository.findAll();
        }
        return repository.findByZonaCuerpoIgnoreCase(zona);
    }

    public Impacto buscar(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el impacto " + id));
    }

    public Impacto crear(Impacto impacto) {
        validar(impacto);
        impacto.setId(null);
        if (impacto.getInstante() == null) {
            impacto.setInstante(LocalDateTime.now());
        }
        return repository.save(impacto);
    }

    public Impacto actualizar(Long id, Impacto datos) {
        Impacto existente = buscar(id);
        validar(datos);
        existente.setDeportista(datos.getDeportista());
        existente.setFuerza(datos.getFuerza());
        existente.setZonaCuerpo(datos.getZonaCuerpo());
        if (datos.getInstante() != null) {
            existente.setInstante(datos.getInstante());
        }
        return repository.save(existente);
    }

    public void borrar(Long id) {
        buscar(id);
        repository.deleteById(id);
    }

    private void validar(Impacto impacto) {
        if (impacto.getFuerza() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fuerza debe ser mayor que 0");
        }
        if (impacto.getZonaCuerpo() == null || impacto.getZonaCuerpo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La zona del cuerpo es obligatoria");
        }
    }
}