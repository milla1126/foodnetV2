package com.foodnet.Propina.Controller;

import com.foodnet.Propina.Model.Propina;
import com.foodnet.Propina.Service.PropinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/propinas")
public class PropinaController {

    @Autowired
    private PropinaService propinaService;

    @GetMapping
    public List<Propina> listar() {
        return propinaService.listarPropinas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propina> obtener(@PathVariable Integer id) {
        return propinaService.obtenerPropina(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Propina actualizar(@PathVariable Integer id, @RequestBody Propina propina) {
        return propinaService.guardarPropina(propina);
    }

    @PostMapping
    public Propina crear(@RequestBody Propina propina) {
        return propinaService.guardarPropina(propina);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        propinaService.eliminarPropina(id);
    }
}

