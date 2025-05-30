package com.foodnet.Trabajador.Service;

import com.foodnet.Trabajador.Model.Trabajador;
import com.foodnet.Trabajador.Repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<Trabajador> listarTrabajadores() {
        return trabajadorRepository.findAll();
    }

    public Optional<Trabajador> obtenerTrabajador(Integer id) {
        return trabajadorRepository.findById(id);
    }

    public Trabajador guardarTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public void eliminarTrabajador(Integer id) {
        trabajadorRepository.deleteById(id);
    }
}

