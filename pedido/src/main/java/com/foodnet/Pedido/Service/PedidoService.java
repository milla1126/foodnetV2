package com.foodnet.Pedido.Service;

import com.foodnet.Pedido.Model.Pedido;
import com.foodnet.Pedido.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedido() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPedido(Integer id) {
        return pedidoRepository.findById(id);
    }

    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void eliminarPedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
