package pe.com.touchgo.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "dispositivos")
@Entity
public class Dispostivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "so")
    private String so;

    public Dispostivo() {
    }

    public Dispostivo(String marca, String modelo, String so) {
        this.marca = marca;
        this.modelo = modelo;
        this.so = so;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
