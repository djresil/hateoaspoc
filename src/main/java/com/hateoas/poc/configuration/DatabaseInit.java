package com.hateoas.poc.configuration;

import com.hateoas.poc.model.Auto;
import com.hateoas.poc.repository.AutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final AutoRepository autoRepository;

    public DatabaseInit(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Auto auto = new Auto();
        auto.setColor("Verde");
        System.out.println(auto);
    }

    public void crearAgencias(){
        String[] nombres = new String[]{"Autos TITO" };
        String[] domicilios = new String[]{"44 y 25" };


    }

}
