package com.hateoas.poc.mapper;

import com.hateoas.poc.controller.AutoController;
import com.hateoas.poc.dto.AutoCompletoDto;
import com.hateoas.poc.dto.AutoDto;
import com.hateoas.poc.model.Auto;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class AutoMapper {

    public AutoDto listaAutoMapperConLink(Auto auto) {
        AutoDto autoDto = new AutoDto();

        autoDto.add(linkTo(methodOn(AutoController.class).getById(auto.getId())).withSelfRel());
        autoDto.setId(auto.getId());
        autoDto.setAgenciaAutosId(auto.getAgencia().getId());
        autoDto.setColor(auto.getColor());


        return autoDto;
    }

    public AutoCompletoDto autoMapper(Auto auto) {

        AutoCompletoDto autoCompletoDto = new AutoCompletoDto();

        autoCompletoDto.setId(auto.getId());
        autoCompletoDto.setAgenciaId(auto.getAgencia().getId());
        autoCompletoDto.setMarca(auto.getMarca());
        autoCompletoDto.setModelo(auto.getModelo());
        autoCompletoDto.setColor(auto.getColor());

        return autoCompletoDto;
    }
}
