package com.foodnet.Inventario.Controller;

import com.foodnet.Inventario.Model.Inventario;
import com.foodnet.Inventario.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> listar() {
        return inventarioService.listarInventario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> obtener(@PathVariable Integer id) {
        return inventarioService.obtenerInventario(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Integer id, @RequestBody Inventario inventario) {
        return inventarioService.guardarInventario(inventario);
    }

    @PostMapping
    public Inventario crear(@RequestBody Inventario inventario) {
        return inventarioService.guardarInventario(inventario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        inventarioService.eliminarInventario(id);
    }
}
