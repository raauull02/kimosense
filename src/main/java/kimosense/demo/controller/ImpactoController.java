package kimosense.demo.controller;

import java.util.List;
import kimosense.demo.model.Impacto;
import kimosense.demo.service.ImpactoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/impactos")
public class ImpactoController {

    private final ImpactoService service;

    public ImpactoController(ImpactoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Impacto> listar(@RequestParam(value = "zona", required = false) String zona) {
        return service.listar(zona);
    }

    @GetMapping("/{id}")
    public Impacto buscar(@PathVariable("id") Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Impacto> crear(@RequestBody Impacto impacto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(impacto));
    }

    @PutMapping("/{id}")
    public Impacto actualizar(@PathVariable("id") Long id, @RequestBody Impacto impacto) {
        return service.actualizar(id, impacto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable("id") Long id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}