package com.localiza.Localizacars.repository;

import com.localiza.Localizacars.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(Long cpf);
    boolean existsByEmail(String email);
    Cliente findByCpf(Long cpf);
}
