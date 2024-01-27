package com.localiza.Localizacars.repository;

import com.localiza.Localizacars.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    boolean existsByPlaca(String placa);
    Carro findByPlaca(String Placa);
}
