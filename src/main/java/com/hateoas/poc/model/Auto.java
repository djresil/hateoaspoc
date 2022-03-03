package com.hateoas.poc.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private int modelo;
    private String color;


    private Long agenciaId;


    public Auto(){}

    public Auto(String marca, int modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgenciaId() {
        return agenciaId;
    }

    public void setAgenciaId(Long agenciaId) {
        this.agenciaId = agenciaId;
    }




    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
