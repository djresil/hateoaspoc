package com.hateoas.poc.service;


import com.hateoas.poc.model.Auto;
import com.hateoas.poc.repository.AutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutosService {

    private final AutoRepository autoRepository;


    public AutosService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }


    public List<Auto> findAllByAgenciaAutosId(Long id){

        return  autoRepository.findByAgenciaId(id);
    }


    public Auto findById(Long id){

        return autoRepository.getById(id);
    }


}
