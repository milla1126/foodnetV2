package com.foodnet.Pedido.Service;

import com.foodnet.pedido.cl.Foodnet.model.Pedidos;
import com.foodnet.pedido.cl.Foodnet.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class pedidoService {

    @Autowired
    private pedidoRepository pedidoRepository;

    public List<pedido> listarPedido() {
        return pedidosRepository.findAll();
    }

    public Optional<pedidos> obtenerPedido(Integer id) {
        return pedidosRepository.findById(id);
    }

    public Pedido guardarPedido(Pedido pedido) {
        return pedidosRepository.save(pedido);
    }

    public void eliminarPedido(Integer id) {
        pedidosRepository.deleteById(id);
    }
}
