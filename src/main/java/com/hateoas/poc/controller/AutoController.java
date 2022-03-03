package com.hateoas.poc.controller;


import com.hateoas.poc.model.Auto;
import com.hateoas.poc.service.AutosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auto")
public class AutoController {

    private final AutosService autosService;

    public AutoController(AutosService autosService) {
        this.autosService = autosService;
    }


    @GetMapping("/{id}")
    public List<Auto> getAll(@PathVariable Long id) {

        return autosService.findAllByAgenciaAutosId(id);
    }
}
