package com.viandamarket.eshop.controller;

import java.util.List;

import com.viandamarket.eshop.service.PedidoService;
import com.viandamarket.eshop.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/pedidos/")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    //-- GETs -Read
    // Gets para todos
    @GetMapping
    public List<Pedido> getAllpedidos() {
        return pedidoService.getAllPedidos();
    }

    // Gets para uno en especifico
    @GetMapping(path = "{idPedido}")
    public Pedido getpedidos(@PathVariable("idPedido") Long id) {
        return pedidoService.getPedido(id);

    }

    //-- DELETE - Delete
    // Delete para uno en especifico
    @DeleteMapping(path = "{idPedido}")
    public Pedido deletePedido(@PathVariable("idPedido") Long id) {
        return pedidoService.deletePedido(id);

    }

    //-- Posts - Create
    // Post para crear un elemento en especifico
    @PostMapping
    public Pedido addPedido(@RequestBody Pedido pedidos) {
        return pedidoService.addPedido(pedidos);

    }

    //-- Put - Update
    // Put para crear un elemento en especifico
    @PutMapping(path = "{idPedido}")
    public Pedido addPedido(@PathVariable("idPedido") long id_pedido,
                            @RequestParam(required = false) String nombre,
                            @RequestParam(required = false) Long precio,
                            @RequestParam(required = false) Integer gramaje,
                            @RequestParam(required = false) Integer cantidad,
                            @RequestParam(required = false) Boolean estatus,
                            @RequestParam(required = false) Long id_usuarios) {
        return pedidoService.updatePedido(id_pedido, nombre, precio, gramaje, cantidad, estatus, id_usuarios);
    }

}
