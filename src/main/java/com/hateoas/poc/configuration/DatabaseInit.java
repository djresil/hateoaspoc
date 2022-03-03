package com.hateoas.poc.configuration;

import com.hateoas.poc.model.Agencia;
import com.hateoas.poc.model.Auto;
import com.hateoas.poc.repository.AgenciaAutosRepository;
import com.hateoas.poc.repository.AutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



@Component
public class DatabaseInit implements CommandLineRunner {

    private final AutoRepository autoRepository;

    private  final AgenciaAutosRepository agenciaAutosRepository;

    private List<Agencia> agencias = new ArrayList<>();

    public DatabaseInit(AutoRepository autoRepository, AgenciaAutosRepository agenciaAutosRepository) {
        this.autoRepository = autoRepository;
        this.agenciaAutosRepository = agenciaAutosRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        crearAgencias();
        createAuto();


    }

    public void crearAgencias(){
        String[] nombres = new String[]{"Autos TITO", "Autos Baires", "Baires Motors", "MotorStorm", "Drift BA",
                "Autos Colina", "MaxiAutos" };
        String[] domicilios = new String[]{"44 y 25", "Av Bolivar 1099", "Santa Fe 1598", "San Martin 1015",
                "9 de mayo 1764", "Av Libertador 5600", "Rivadavia 10950"};

        for (int i = 0; i < nombres.length; i ++) {

            Agencia agencia =   new Agencia(nombres[i], domicilios[i]);
            agenciaAutosRepository.save(agencia);

            agencias.add(agencia);
        }


    }

    public void createAuto(){

        String[] color = new String[]{"Rojo", "Azul", "Verde", "Blanco", "Negro"};
        String[]  marca = new String[]{"Chevrolet", "Ford", "BMW", "Renault", "Dodge", "Audi"};

        Random random = new Random();


        for (int i = 0; i < 10000 ; i++) {
           int indexColor = random.nextInt(color.length -1) ;
           int indexMarca = random.nextInt( marca.length-1 ) ;
           int anio = random.nextInt(30 ) +1990;
           int indexAgencia = random.nextInt(agencias.size()-1);

           Auto auto = new Auto(marca[indexMarca],  anio,  color[indexColor]);

           autoRepository.save(auto);
           agenciaAutosRepository.findById(indexAgencia);
           agencias.get(indexAgencia).addAuto(auto);

        }

        agencias.forEach( a -> agenciaAutosRepository.save(a));

    }

}
