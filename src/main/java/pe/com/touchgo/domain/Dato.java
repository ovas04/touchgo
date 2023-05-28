package pe.com.touchgo.domain;

public class Dato {

    private String nombre;

    private String tipo;

    private String detalle;

    public Dato(String nombre, String tipo, String detalle) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }


}
