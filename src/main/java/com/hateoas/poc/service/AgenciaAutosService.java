package com.hateoas.poc.service;

import com.hateoas.poc.model.Agencia;
import com.hateoas.poc.repository.AgenciaAutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaAutosService  {

    private final AgenciaAutosRepository agenciaAutosRepository;


    public AgenciaAutosService(AgenciaAutosRepository agenciaAutosRepository) {
        this.agenciaAutosRepository = agenciaAutosRepository;
    }



    public List<Agencia> agenciaAutosList(){


        return  agenciaAutosRepository.findAll();
    }
}
