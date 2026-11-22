package kimosense.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeportistaController {

    @GetMapping("/deportista")
    public String getDeportista() {
        return "Deportista: Carlos Perez - Disciplina: Ciclismo - Pulsaciones: 72 - Estado: Activo";
    }
}