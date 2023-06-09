package com.viandamarket.eshop.repository; 
import com.viandamarket.eshop.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>  {

}
