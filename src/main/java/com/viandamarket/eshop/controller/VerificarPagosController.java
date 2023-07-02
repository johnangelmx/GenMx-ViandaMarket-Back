package com.viandamarket.eshop.controller;

import com.viandamarket.eshop.model.Pedido;
import com.viandamarket.eshop.service.PedidoService;
import com.viandamarket.eshop.service.VerificarPagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verificar-pagos")
public class VerificarPagosController {
    private final VerificarPagosService verificarPagosService;
    private final PedidoService pedidoService;

    @Autowired
    public VerificarPagosController(VerificarPagosService verificarPagosService, PedidoService pedidoService) {
        this.verificarPagosService = verificarPagosService;
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<String> verificarToken(@RequestParam("sessionPedidosId") String sessionId, @RequestParam("token") String token) {
        if (verificarPagosService.verificarCompra(sessionId)) {
            List<Pedido> pedidos = verificarPagosService.verificarToken(token);
            if (pedidos != null) {
                // Guardar la lista de pedidos en la base de datos
                System.out.println("pedidos = " + pedidos);
                System.out.println("pedidos = " + pedidos.getClass().getSimpleName());
                for (Pedido pedido : pedidos) {
                    pedidoService.addPedido(pedido);
                }
                return ResponseEntity.status(HttpStatus.OK).body("OK");
            }
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error compra aun no pagada");
        }

        return null;
    }
}
