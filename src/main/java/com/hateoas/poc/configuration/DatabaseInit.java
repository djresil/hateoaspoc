package com.hateoas.poc.configuration;

import com.hateoas.poc.model.AgenciaAutos;
import com.hateoas.poc.model.Auto;
import com.hateoas.poc.repository.AgenciaAutosRepository;
import com.hateoas.poc.repository.AutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final AutoRepository autoRepository;

    private  final AgenciaAutosRepository agenciaAutosRepository;

    public DatabaseInit(AutoRepository autoRepository, AgenciaAutosRepository agenciaAutosRepository) {
        this.autoRepository = autoRepository;
        this.agenciaAutosRepository = agenciaAutosRepository;
    }


    @Override
    public void run(String... args) throws Exception {
      String[] color = new String[]{"Rojo", "Azul", "Verde", "Blanco", "Negro"};
      String[]  marca = new String[]{"Chevrolet", "Fort", "Peg"}



    }

    public void crearAgencias(){
        String[] nombres = new String[]{"Autos TITO", "Autos Baires", "Baires Motors", "MotorStorm", "Drift BA",
                "Autos Colina", "MaxiAutos" };
        String[] domicilios = new String[]{"44 y 25", "Av Bolivar 1099", "Santa Fe 1598", "San Martin 1015",
                "9 de mayo 1764", "Av Libertador 5600", "Rivadavia 10950"};

        for (int i = 0; i < nombres.length; i ++) {
            AgenciaAutos agenciaAutos =   new AgenciaAutos(nombres[i], domicilios[i]);
            agenciaAutosRepository.save(agenciaAutos);
        }


    }

}
