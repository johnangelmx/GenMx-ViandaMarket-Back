package com.viandamarket.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.viandamarket.eshop.model.Pedido;
import com.viandamarket.eshop.repository.PedidoRepository;

@Service
public class PedidoService {
    public final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }// constructor

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }// getAllPedidos

    public Pedido getPedido(Long id_pedido) {
        return pedidoRepository.findById(id_pedido).orElseThrow(() -> new IllegalArgumentException("Los Pedidos con id" + id_pedido + " no existen"));
    }// getPedido

    public Pedido deletePedido(Long id_pedido) {
        Pedido tmPedido = null;
        if (pedidoRepository.existsById(id_pedido)) {
            tmPedido = pedidoRepository.findById(id_pedido).get();
            pedidoRepository.deleteById(id_pedido);
        } // if
        return tmPedido;
    }// deletePedido

    public Pedido addPedido(Pedido id_pedido) {
        return pedidoRepository.save(id_pedido);
    }// addPedido

    public Pedido updatePedido(Long id_pedido, String nombre, Integer precio, Integer cantidad, Boolean estatus, Long id_usuarios) {
        Pedido tmPedido = null;
        if (pedidoRepository.existsById(id_pedido)) {
            tmPedido = pedidoRepository.findById(id_pedido).get();
            if (nombre != null) tmPedido.setNombre(nombre);
            if (precio != null) tmPedido.setPrecio(precio);
            if (cantidad != null) tmPedido.setCantidad(cantidad);
            if (estatus != null) tmPedido.setEstatus(estatus);
            if (id_usuarios != null) tmPedido.setId_usuarios(id_usuarios);
            pedidoRepository.save(tmPedido);
        } else {
            System.out.println("Update - Los Pedidos con id " + id_pedido + " no existen");
        }//else
        return tmPedido;
    }//updatePedido


}
