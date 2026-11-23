package kimosense.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "impacto")
public class Impacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deportista;
    private double fuerza;
    private String zonaCuerpo;
    private LocalDateTime instante;

    public Impacto() {
    }

    public Impacto(String deportista, double fuerza, String zonaCuerpo, LocalDateTime instante) {
        this.deportista = deportista;
        this.fuerza = fuerza;
        this.zonaCuerpo = zonaCuerpo;
        this.instante = instante;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeportista() { return deportista; }
    public void setDeportista(String deportista) { this.deportista = deportista; }

    public double getFuerza() { return fuerza; }
    public void setFuerza(double fuerza) { this.fuerza = fuerza; }

    public String getZonaCuerpo() { return zonaCuerpo; }
    public void setZonaCuerpo(String zonaCuerpo) { this.zonaCuerpo = zonaCuerpo; }

    public LocalDateTime getInstante() { return instante; }
    public void setInstante(LocalDateTime instante) { this.instante = instante; }
}