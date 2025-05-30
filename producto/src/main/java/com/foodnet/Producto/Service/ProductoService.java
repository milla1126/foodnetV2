package com.foodnet.Producto.Service;


import com.foodnet.Producto.Model.ProductoModel;
import com.foodnet.Producto.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {


    @Autowired
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoModel> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<ProductoModel> obtenerProducto(Long id) {
        return productoRepository.findById(id);
    }

    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
