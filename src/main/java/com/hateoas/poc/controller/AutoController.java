package com.hateoas.poc.controller;


import com.hateoas.poc.dto.AutoCompletoDto;
import com.hateoas.poc.dto.AutoDto;
import com.hateoas.poc.model.Auto;
import com.hateoas.poc.service.AutosService;
import com.hateoas.poc.service.bo.PageBO;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/autos")
public class AutoController {

    private final AutosService autosService;

    public AutoController(AutosService autosService) {
        this.autosService = autosService;
    }


    @GetMapping()
    public PageBO<AutoDto> getAll(@RequestParam Long agenciaId, @RequestParam int limit, @RequestParam int offset, HttpServletRequest request) {


        PageBO<Auto> withPage = autosService.findWithPage(agenciaId, limit, offset, request.getRequestURL() + "?" + request.getQueryString());


        PageBO<AutoDto> autoDtoPageBO = new PageBO<>();
        autoDtoPageBO.setContent(withPage.getContent().stream().map(this::map).collect(Collectors.toList()));
        autoDtoPageBO.setNext(withPage.getNext());
        autoDtoPageBO.setPrevious(withPage.getPrevious());


        return autoDtoPageBO;
    }


    @GetMapping("/{id}")
    public AutoCompletoDto getById(@PathVariable Long id) {


        return mapCompleto(autosService.findById(id));
    }

    private AutoDto map(Auto auto) {
        AutoDto autoDto = new AutoDto();

        autoDto.add(linkTo(methodOn(AutoController.class).getById(auto.getId())).withSelfRel());
        autoDto.setId(auto.getId());
        autoDto.setAgenciaAutosId(auto.getAgencia().getId());
        autoDto.setColor(auto.getColor());


        return autoDto;
    }

    private AutoCompletoDto mapCompleto(Auto auto) {

        AutoCompletoDto autoCompletoDto = new AutoCompletoDto();

        autoCompletoDto.setId(auto.getId());
        autoCompletoDto.setAgenciaId(auto.getAgencia().getId());
        autoCompletoDto.setMarca(auto.getMarca());
        autoCompletoDto.setModelo(auto.getModelo());
        autoCompletoDto.setColor(auto.getColor());

        return autoCompletoDto;
    }


}
