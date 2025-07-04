package com.foodnet.Inventario.Service;

import com.foodnet.Inventario.Model.Inventario;
import com.foodnet.Inventario.Repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> listarInventario() {
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> obtenerInventario(Integer id) {
        return inventarioRepository.findById(id);
    }

    public Inventario guardarInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public void eliminarInventario(Integer id) {
        inventarioRepository.deleteById(id);
    }
}
