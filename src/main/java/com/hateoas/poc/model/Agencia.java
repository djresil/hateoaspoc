package com.hateoas.poc.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razonSocial;

    private String domicilio;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Auto> autos = new HashSet<>();

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

    public Set<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }

    public void addAuto(Auto auto){
        this.autos.add(auto);
    }
}
