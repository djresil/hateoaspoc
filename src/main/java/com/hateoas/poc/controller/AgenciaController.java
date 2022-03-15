package com.hateoas.poc.controller;

import com.hateoas.poc.dto.AgenciaAutosDto;
import com.hateoas.poc.dto.OffsetLimitPageRequest;
import com.hateoas.poc.model.Agencia;
import com.hateoas.poc.service.AgenciaAutosService;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@ExposesResourceFor(OffsetLimitPageRequest.class)
@RequestMapping("/api/agencias")
public class AgenciaController {

    private final AgenciaAutosService agenciaAutosService;

    public AgenciaController(AgenciaAutosService agenciaAutosService) {
        this.agenciaAutosService = agenciaAutosService;
    }

    @GetMapping()
    public ResponseEntity<AgenciaAutosDto> getAgencias(@RequestParam int limit, @RequestParam int offset){


        List<Agencia> agenciaAutos = agenciaAutosService.agenciaAutosList();



        return  new ResponseEntity(   agenciaAutos.stream().map((Agencia e) -> map(e ,limit, offset)).collect(Collectors.toList()) , HttpStatus.OK);
    }

    private AgenciaAutosDto map(Agencia agencia, int limit, int offset){
        AgenciaAutosDto agenciaAutosDto = new AgenciaAutosDto();


        agenciaAutosDto.add(linkTo(methodOn(AutoController.class).getAll(agencia.getId(), limit, offset ,  null))
                .withRel("autos"));


        agenciaAutosDto.setId(agencia.getId());
        agenciaAutosDto.setDomicilio(agencia.getDomicilio());
        agenciaAutosDto.setRazonSocial(agencia.getRazonSocial());

        return agenciaAutosDto;

    }

}
