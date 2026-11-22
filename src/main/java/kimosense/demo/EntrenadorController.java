package kimosense.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntrenadorController {

    @GetMapping("/entrenador")
    public String getEntrenador() {
        return "Entrenador: Laura Gomez - Deportistas a cargo: 5 - Plan actual: Resistencia";
    }
    @GetMapping("/entrenador/nombre")
    public String getNombre() {
        return "Laura Gomez";
    }
}
