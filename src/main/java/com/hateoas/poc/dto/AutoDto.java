package com.hateoas.poc.dto;

public class AutoDto {
    private Long id;
    private String marca;
    private int modelo;
    private String color;
    private Long agenciaAutosId;

    public Long getAgenciaAutosId() {
        return agenciaAutosId;
    }

    public void setAgenciaAutosId(Long agenciaAutosId) {
        this.agenciaAutosId = agenciaAutosId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
