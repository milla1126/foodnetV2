package com.foodnet.Trabajador.Controller;

import com.foodnet.Trabajador.Model.Trabajador;
import com.foodnet.Trabajador.Service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador> listar() {
        return trabajadorService.listarTrabajadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> obtener(@PathVariable Integer id) {
        return trabajadorService.obtenerTrabajador(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Trabajador crear(@RequestBody Trabajador trabajador) {
        return trabajadorService.guardarTrabajador(trabajador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        trabajadorService.eliminarTrabajador(id);
    }
}

