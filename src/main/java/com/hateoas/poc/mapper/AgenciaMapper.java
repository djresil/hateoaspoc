package com.hateoas.poc.mapper;

import com.hateoas.poc.controller.AutoController;
import com.hateoas.poc.dto.AgenciaAutosDto;
import com.hateoas.poc.model.Agencia;
import com.hateoas.poc.service.AgenciaAutosService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AgenciaMapper {

    private final AgenciaAutosService agenciaAutosService;

    public AgenciaMapper(AgenciaAutosService agenciaAutosService) {
        this.agenciaAutosService = agenciaAutosService;
    }

    public List<AgenciaAutosDto> agenciaMapper(int limit, int offset) {
        List<Agencia> agenciaAutos = agenciaAutosService.agenciaAutosList();
        List<AgenciaAutosDto> list = new ArrayList<>();

        for (Agencia autosDto : agenciaAutos) {
            AgenciaAutosDto agenciaAutosDto = new AgenciaAutosDto();
            agenciaAutosDto.setId(autosDto.getId());
            agenciaAutosDto.setDomicilio(autosDto.getDomicilio());
            agenciaAutosDto.setRazonSocial(autosDto.getRazonSocial());
            agenciaAutosDto.add(linkTo(methodOn(AutoController.class).getAll(agenciaAutosDto.getId(), limit, offset, null))
                    .withRel("autos"));
            list.add(agenciaAutosDto);

        }
        return list;

    }
}
