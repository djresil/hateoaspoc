package com.hateoas.poc.dto;


import org.springframework.hateoas.RepresentationModel;

public class AgenciaAutosDto extends RepresentationModel<AgenciaAutosDto> {

    private Long id;

    private String razonSocial;

    private String domicilio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
