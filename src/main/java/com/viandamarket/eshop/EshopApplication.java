package com.viandamarket.eshop;

import com.viandamarket.eshop.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.FilterRegistration;

@SpringBootApplication
public class EshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
    }

    //? Componente a ejecutar esta aplicacion, y por el tipo de metodo detectará que es un filtro ⬇️
    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter());
//        registrationBean.addUrlPatterns("/api/*");
        registrationBean.addUrlPatterns("/api/calidad/*");
        registrationBean.addUrlPatterns("/api/complementos/*");
        registrationBean.addUrlPatterns("/api/cortes/*");
        registrationBean.addUrlPatterns("/api/usuarios/*");
        registrationBean.addUrlPatterns("/api/gramos/*");
        registrationBean.addUrlPatterns("/api/pedidos/*");
        registrationBean.addUrlPatterns("/api/pasarela-pagos/*");
        return registrationBean;
    }

}
