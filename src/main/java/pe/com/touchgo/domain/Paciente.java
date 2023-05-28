package pe.com.touchgo.domain;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private String nombre;

    private String tipoSangre;

    private String telefonoEmergencia;

    private String direccion;

    private List<Dato> datos;

    public Paciente(String nombre, String tipoSangre, String telefonoEmergencia, String direccion) {
        this.nombre = nombre;
        this.tipoSangre = tipoSangre;
        this.telefonoEmergencia = telefonoEmergencia;
        this.direccion = direccion;
        this.datos =  new ArrayList<Dato>();
    }

    public void AddDato(Dato dato){

        this.datos.add(dato);

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
}
