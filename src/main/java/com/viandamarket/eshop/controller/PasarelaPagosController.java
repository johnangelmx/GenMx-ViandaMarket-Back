package com.viandamarket.eshop.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.viandamarket.eshop.model.PasarelaProductosDTO;
import com.viandamarket.eshop.model.Pedido;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasarelaPagosController {

	@Value("${stripe.secretKey}") // Se debe configurar en el archivo application.properties
	private String stripeSecretKey;

	@PostMapping("/ruta-hacia-el-backend") // Mismo endpoint que se utilizó en el frontend
	public ResponseEntity<String> crearSessionPago(@RequestBody PasarelaProductosDTO pasarelaProductos) {
		try {
			// Configurar la clave secreta de Stripe
			Stripe.apiKey = stripeSecretKey;

        try {
            // Configurar la clave secreta de Stripe
            Stripe.apiKey = stripeSecretKey;
            // Crear un objeto SessionCreateParams.Builder con los detalles de la compra
            SessionCreateParams.Builder builder = new SessionCreateParams.Builder();
            builder.setSuccessUrl("http://localhost:8080/gracias-compra.html?" + encriptarPedidos(pedidos))
                    .setCancelUrl("http://localhost:8080/carrito.html")
                    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                    .setMode(SessionCreateParams.Mode.PAYMENT);

			for (Pedido producto : pasarelaProductos.getProductos()) {
				builder.addLineItem(
					SessionCreateParams.LineItem
						.builder().setQuantity((long) producto.getCantidad()).setPriceData(
							SessionCreateParams.LineItem.PriceData.builder().setCurrency("USD") // Moneda de
																											// la compra
						.setUnitAmount((long) (producto.getPrecio() * 100)) // Precio en centavos
						.setProductData(SessionCreateParams.LineItem.PriceData.ProductData
						.builder().setName(producto.getNombre()).build())
					.build())
					.build());
			}

			// Crear la sesión de pago en Stripe
			SessionCreateParams createParams = builder.build();
			Session session = Session.create(createParams);

                SessionCreateParams.LineItem lineItem =
                        SessionCreateParams.LineItem.builder()
                                .setQuantity((long) pedido.getCantidad())
                                .setPriceData(priceData)
                                .build();

                builder.addLineItem(lineItem);
            }

            // Crear la sesión de pago en Stripe
            SessionCreateParams createParams = builder.build();
            Session session = Session.create(createParams);
            // Obtener la URL de pago de la sesión
            String urlPago = session.getUrl();
            String sessionStripeId = session.getId();
            // Crear un mapa con sessionPedidosId y urlPago
            Map<String, String> jsonResponse = new HashMap<>();
            jsonResponse.put("sessionPedidosId", sessionStripeId);
            jsonResponse.put("urlPago", urlPago);

            // Devolver el mapa como respuesta
            return ResponseEntity.ok(jsonResponse.toString());
        } catch (StripeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la sesión de pago");
        }
    }


    private String encriptarPedidos(List<Pedido> pedidos) {
        String pedidosString = convertirPedidosAString(pedidos);
        // Configurar el cifrador
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("Fj7$@sT9!"); // Reemplaza con tu propia contraseña secreta
        encryptor.setConfig(config);

        // Encriptar la URL
        String encryptedUrl = encryptor.encrypt(pedidosString);

        // Codificar en base64
        String base64EncodedUrl = Base64.getEncoder().encodeToString(encryptedUrl.getBytes());

        return base64EncodedUrl;
    }

    public String convertirPedidosAString(List<Pedido> pedidos) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        for (Pedido pedido : pedidos) {
            sb.append("    {\n");
            sb.append("        \"nombre\": \"" + pedido.getNombre() + "\",\n");
            sb.append("        \"precio\": " + pedido.getPrecio() + ",\n");
            sb.append("        \"gramaje\": " + pedido.getGramaje() + ",\n");
            sb.append("        \"cantidad\": " + pedido.getCantidad() + ",\n");
            sb.append("        \"id_usuarios\": " + pedido.getId_usuarios() + "\n");
            sb.append("    },\n");
        }

        if (!pedidos.isEmpty()) {
            // Elimina la última coma y el salto de línea adicionales
            sb.setLength(sb.length() - 2);
        }

        sb.append("\n]");

        return sb.toString();
    }

			// Devolver la URL de pago al frontend
			return ResponseEntity.ok(urlPago);
		} catch (StripeException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la sesión de pago");
		}
	}
}
