package com.localiza.Localizacars.adapters.outbound.repository;

import com.localiza.Localizacars.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(Long cpf);
    boolean existsByEmail(String email);
    Cliente findByCpf(Long cpf);
}
