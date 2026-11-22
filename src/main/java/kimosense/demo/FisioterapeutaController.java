package kimosense.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FisioterapeutaController {

    @GetMapping("/fisioterapeuta")
    public String getFisioterapeuta() {
        return "Fisioterapeuta: Marta Ruiz - Pacientes en seguimiento: 3 - Ultima sesion: lunes";
    }
}
