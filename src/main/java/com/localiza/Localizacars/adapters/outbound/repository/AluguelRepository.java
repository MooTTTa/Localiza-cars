package com.localiza.Localizacars.adapters.outbound.repository;

import com.localiza.Localizacars.domain.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
