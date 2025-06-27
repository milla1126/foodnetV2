package com.foodnet.Trabajador.Model;

import com.foodnet.Trabajador.Repository.TrabajadorRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();
        // Generar trabajadores
        for (int i = 0; i < 15; i++) {
            Trabajador trabajador = new Trabajador();
            trabajador.setId_trabajador(i + 1);
            trabajador.setNombre(faker.name().name());
            trabajador.setRol(faker.job().position());
            trabajador.setTurno();
            tipoSalaRepository.save(tipoSala);
        }
    }
}

