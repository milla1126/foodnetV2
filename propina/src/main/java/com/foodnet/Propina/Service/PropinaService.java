package com.foodnet.Propina.Service;

import com.foodnet.Propina.Model.Propina;
import com.foodnet.Propina.Repository.PropinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropinaService {

    @Autowired
    private PropinaRepository propinaRepository;

    public List<Propina> listarPropinas() {
        return propinaRepository.findAll();
    }

    public Optional<Propina> obtenerPropina(Integer id) {
        return propinaRepository.findById(id);
    }

    public Propina guardarPropina(Propina propina) {
        return propinaRepository.save(propina);
    }

    public void eliminarPropina(Integer id) {
        propinaRepository.deleteById(id);
    }
}

