package com.hateoas.poc.dto;

import org.springframework.hateoas.RepresentationModel;

public class AutoDto extends RepresentationModel<AutoDto> {
    private Long id;

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


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
