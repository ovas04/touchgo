package pe.com.touchgo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipoSangre")
    private String tipoSangre;

    @Column(name = "telefonoEmergencia")
    private String telefonoEmergencia;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "alergia")
    @Size(max = 1000)
    private String alergia;

    @Column(name = "enfermedad")
    @Size(max = 1000)
    private String enfermedad;

    @Column(name = "historial")
    @Size(max = 1000)
    private String historial;

    @Column(name = "foto")
    private String foto;


    public Paciente() {
    }

    public Paciente(String nombre, String tipoSangre, String telefonoEmergencia, String direccion, String alergia, String enfermedad, String historial) {
        this.nombre = nombre;
        this.tipoSangre = tipoSangre;
        this.telefonoEmergencia = telefonoEmergencia;
        this.direccion = direccion;
        this.alergia = alergia;
        this.enfermedad = enfermedad;
        this.historial = historial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
