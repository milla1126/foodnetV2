package com.foodnet.Producto.Controller;

import com.foodnet.Producto.Model.ProductoModel;
import com.foodnet.Producto.Service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoModel> listar() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoModel> obtener(@PathVariable Long id) {
        return productoService.obtenerProducto(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ProductoModel actualizar(@PathVariable Long id, @RequestBody ProductoModel producto) {
        return productoService.guardarProducto(producto);
    }

    @PostMapping
    public ProductoModel crear(@RequestBody ProductoModel producto) {
        return productoService.guardarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}

