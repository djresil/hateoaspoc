package com.hateoas.poc.controller;


import com.hateoas.poc.dto.AutoCompletoDto;
import com.hateoas.poc.dto.AutoDto;
import com.hateoas.poc.dto.PageBODto;
import com.hateoas.poc.mapper.AutoMapper;
import com.hateoas.poc.mapper.PageMapper;
import com.hateoas.poc.service.AutosService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/api/autos")
public class AutoController {

    private final AutosService autosService;
    private final AutoMapper autoMapper;
    private  final PageMapper pageMapper;

    public AutoController(AutosService autosService, AutoMapper autoMapper, PageMapper pageMapper) {
        this.autosService = autosService;
        this.autoMapper = autoMapper;
        this.pageMapper = pageMapper;
    }


    @GetMapping()
    public PageBODto<AutoDto> getAll(@RequestParam Long agenciaId, @RequestParam int limit, @RequestParam int offset, HttpServletRequest request) {

        return pageMapper.toDto(autosService.findWithPage(agenciaId, limit, offset, request.getRequestURL() + "?" + request.getQueryString()), autoMapper::mapConList);
    }


    @GetMapping("/{id}")
    public AutoCompletoDto getById(@PathVariable Long id) {

        return autoMapper.mapCompleto(autosService.findById(id));
    }

}
