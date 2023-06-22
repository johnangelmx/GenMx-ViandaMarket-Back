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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class PasarelaPagosController {

	@GetMapping("/success")
    public String redirectSuccess() {
        return "redirect:/static/exito.html";
    }
	@GetMapping("/cancel")
    public String redirectCansel() {
        return "redirect:/static/exito.html";
    }

    @Value("${stripe.secretKey}") // Se debe configurar en el archivo application.properties
    private String stripeSecretKey;

    @PostMapping("pasarela-pagos") // Mismo endpoint que se utilizó en el frontend
    public ResponseEntity<String> crearSessionPago(@RequestBody List<Pedido> pedidos) {
        try {
            // Configurar la clave secreta de Stripe
            Stripe.apiKey = stripeSecretKey;
 
            // Crear un objeto SessionCreateParams con los detalles de la compra
            SessionCreateParams.Builder builder = new SessionCreateParams.Builder();
            builder.setSuccessUrl("/success") // URL a la que se redirigirá después del pago exitoso
                    .setCancelUrl("/cancel") // URL a la que se redirigirá si el usuario cancela
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
