package com.foodnet.Cliente.Model;

import com.foodnet.Cliente.Repository.ClienteRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        // Generar clientes
        for (int i = 0; i < 15; i++) {
            Cliente cliente = new Cliente();
            cliente.setId_cliente(i + 1);
            cliente.setNombre(faker.name().name());
            cliente.setApellido(faker.name().lastName());
            cliente.setCorreo(faker.internet().emailAddress());
            cliente.setTelefono(faker.phoneNumber().cellPhone());
            clienteRepository.save(cliente);
        }
    }
}
