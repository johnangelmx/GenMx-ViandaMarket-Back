package com.viandamarket.eshop.service;

import java.util.ArrayList;
import java.util.Base64;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.viandamarket.eshop.model.Pedido;
import com.viandamarket.eshop.repository.PedidoRepository;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Service
public class VerificarPagosService {
    @Value("${stripe.secretKey}") // Se debe configurar en el archivo application.properties
    private String stripeSecretKey;


    public Boolean verificarCompra(String sessionId) {
        try {
            Stripe.apiKey = stripeSecretKey;

            // Obtener la sesión de pago de Stripe
            Session session = Session.retrieve(sessionId);

            // Obtener el ID del PaymentIntent desde la sesión de pago
            String paymentIntentId = session.getPaymentIntent();

            // Obtener los detalles del PaymentIntent
            PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentId);

            // Verificar el estado del pago
            return "succeeded".equals(paymentIntent.getStatus());
        } catch (StripeException e) {
            // Manejar la excepción de Stripe
            return ResponseEntity.status(500).body("Error al verificar el pago: " + e.getMessage()).hasBody();
        }
    }

    public List<Pedido> verificarToken(String token) {
        token = token.replaceAll("\\s", "");
        System.out.println("token = " + token);
        String pedidos = decryptUrl(token);
        System.out.println("token Desencriptado = " + pedidos);
        return convertirStringAPedidos(pedidos);
    }


    private String decryptUrl(String token) {
        // Decodificar desde base64
        byte[] base64DecodedToken = Base64.getDecoder().decode(token);

        // Convertir a String
        String encryptedToken = new String(base64DecodedToken);

        // Configurar el descifrador
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("Fj7$@sT9!"); // Reemplaza con tu propia contraseña secreta
        decryptor.setConfig(config);

        // Descifrar la URL
        return decryptor.decrypt(encryptedToken);
    }

    public List<Pedido> convertirStringAPedidos(String jsonPedidos) throws JSONException {
        List<Pedido> pedidos = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonPedidos);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String nombre = jsonObject.getString("nombre");
            long precio = jsonObject.getLong("precio");
            int cantidad = jsonObject.getInt("cantidad");
            int gramaje = jsonObject.getInt("gramaje");
            int id_usuarios = jsonObject.getInt("id_usuarios");

            Pedido pedido = new Pedido(nombre, precio, gramaje, cantidad, id_usuarios);
            pedidos.add(pedido);
        }

        return pedidos;
    }

}
