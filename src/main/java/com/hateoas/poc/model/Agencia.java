package com.hateoas.poc.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razonSocial;

    private String domicilio;

    @OneToMany(mappedBy = "agenciaId", cascade = CascadeType.ALL)
    private List<Auto> autos = new ArrayList<>();

    public Agencia(){

    }

    public Agencia(String razonSocial, String domicilio) {
        this.razonSocial = razonSocial;
        this.domicilio = domicilio;
    }


    public Long getId() {
        return id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public void addAuto(Auto auto){
        this.autos.add(auto);
    }
}