package com.hateoas.poc.controller;

import com.hateoas.poc.dto.AgenciaAutosDto;
import com.hateoas.poc.model.Agencia;
import com.hateoas.poc.service.AgenciaAutosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/agencias")
public class AgenciaController {

    private final AgenciaAutosService agenciaAutosService;

    public AgenciaController(AgenciaAutosService agenciaAutosService) {
        this.agenciaAutosService = agenciaAutosService;
    }

    @GetMapping
    public ResponseEntity<AgenciaAutosDto> getAgencias(){


        List<Agencia> agenciaAutos = agenciaAutosService.agenciaAutosList();



        return  new ResponseEntity(   agenciaAutos.stream().map(this::map).collect(Collectors.toList()) , HttpStatus.OK);
    }

    private AgenciaAutosDto map(Agencia e){
        AgenciaAutosDto autosDto = new AgenciaAutosDto();

        autosDto.setId(e.getId());
        autosDto.setDomicilio(e.getDomicilio());
        autosDto.setRazonSocial(e.getRazonSocial());

        return autosDto;


    }

}
