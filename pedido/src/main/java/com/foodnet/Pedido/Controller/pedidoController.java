package com.foodnet.Pedido.Controller;


import com.Foodnet.cl.Foodnet.model.Pedidos;
import com.Foodnet.cl.Foodnet.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping
    public List<Pedidos> listar() {
        return pedidosService.listarPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> obtener(@PathVariable Integer id) {
        return pedidosService.obtenerPedido(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedidos crear(@RequestBody Pedidos pedido) {
        return pedidosService.guardarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        pedidosService.eliminarPedido(id);
    }
}
