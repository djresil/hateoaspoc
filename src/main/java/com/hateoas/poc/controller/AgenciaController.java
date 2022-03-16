package com.hateoas.poc.controller;

import com.hateoas.poc.dto.AgenciaAutosDto;
import com.hateoas.poc.dto.OffsetLimitPageRequest;
import com.hateoas.poc.mapper.AgenciaMapper;
import com.hateoas.poc.service.AgenciaAutosService;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@ExposesResourceFor(OffsetLimitPageRequest.class)
@RequestMapping("/api/agencias")
public class AgenciaController {

    private final AgenciaAutosService agenciaAutosService;
    private  final AgenciaMapper agenciaMapper;

    public AgenciaController(AgenciaAutosService agenciaAutosService, AgenciaMapper agenciaMapper) {
        this.agenciaAutosService = agenciaAutosService;
        this.agenciaMapper = agenciaMapper;
    }

    @GetMapping()
    public ResponseEntity<AgenciaAutosDto> getAgencias(@RequestParam int limit, @RequestParam int offset){

        return  new ResponseEntity(  agenciaMapper.agenciaMapper(limit, offset) , HttpStatus.OK);
    }

 }
