package com.viandamarket.eshop.controller;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.viandamarket.eshop.model.Pedido;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class PasarelaPagosController {

    @Value("${stripe.secretKey}") // Se debe configurar en el archivo application.properties
    private String stripeSecretKey;

    @PostMapping("pasarela-pagos") // Mismo endpoint que se utilizó en el frontend
    public ResponseEntity<String> crearSessionPago(@RequestBody List<Pedido> pedidos) {
        try {
            // Configurar la clave secreta de Stripe
            Stripe.apiKey = stripeSecretKey;

            String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
            String successUrl = baseUrl + "/exito";
            String cancelUrl = baseUrl + "/cancelar";
            // Crear un objeto SessionCreateParams con los detalles de la compra
            SessionCreateParams.Builder builder = new SessionCreateParams.Builder();
            builder.setSuccessUrl("http://localhost:8080/exito") // URL a la que se redirigirá después del pago exitoso
                    .setCancelUrl("http://localhost:8080/carrito.html") // URL a la que se redirigirá si el usuario cancela
                    // el pago
                    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                    .setMode(SessionCreateParams.Mode.PAYMENT);

            for (Pedido pedido : pedidos) {
                builder.addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity((long) pedido.getCantidad())
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("USD") // Moneda de la compra
                                                .setUnitAmount((long) (pedido.getPrecio() * 100)) // Precio en centavos
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                .setName(pedido.getNombre())
                                                                .build()
                                                )
                                                .build()
                                )
                                .build()
                );
            }

            // Crear la sesión de pago en Stripe
            SessionCreateParams createParams = builder.build();
            Session session = Session.create(createParams);

            // Obtener la URL de pago de la sesión
            String urlPago = session.getUrl();

            // Devolver la URL de pago al frontend
            return ResponseEntity.ok(urlPago);
        } catch (StripeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la sesión de pago");
        }
    }
}
