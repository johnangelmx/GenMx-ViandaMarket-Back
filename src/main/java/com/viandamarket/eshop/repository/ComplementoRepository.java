package com.viandamarket.eshop.repository;
import java.util.Optional;
import com.viandamarket.eshop.model.Complemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplementoRepository extends JpaRepository<Complemento, Long>{
}
