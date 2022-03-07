package com.hateoas.poc.controller;

import com.hateoas.poc.dto.AgenciaAutosDto;
import com.hateoas.poc.model.Agencia;
import com.hateoas.poc.service.AgenciaAutosService;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/agencias")
public class AgenciaController {

    private final AgenciaAutosService agenciaAutosService;

    public AgenciaController(AgenciaAutosService agenciaAutosService) {
        this.agenciaAutosService = agenciaAutosService;
    }

    @GetMapping()
    public ResponseEntity<AgenciaAutosDto> getAgencias(@RequestParam int limit, @RequestParam int offset){


        List<Agencia> agenciaAutos = agenciaAutosService.agenciaAutosList();




        return  new ResponseEntity(   agenciaAutos.stream().map((Agencia e) -> map(e , limit, offset)).collect(Collectors.toList()) , HttpStatus.OK);
    }

    private AgenciaAutosDto map(Agencia e, int limit, int offset){
        AgenciaAutosDto agenciaAutosDto = new AgenciaAutosDto();
        agenciaAutosDto.add(linkTo(methodOn(AutoController.class).getAll(e.getId(), limit, offset)).withRel("autos"));


        agenciaAutosDto.setId(e.getId());
        agenciaAutosDto.setDomicilio(e.getDomicilio());
        agenciaAutosDto.setRazonSocial(e.getRazonSocial());

        return agenciaAutosDto;


    }

}
