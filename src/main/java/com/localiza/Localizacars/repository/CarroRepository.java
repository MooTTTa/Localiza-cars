package com.localiza.Localizacars.repository;

import com.localiza.Localizacars.enums.StatusCarro;
import com.localiza.Localizacars.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    boolean existsByPlaca(String placa);
    Carro findByPlaca(String Placa);
    List<Carro> findByCidade(String cidade);
    List<Carro> findByStatusCarro(StatusCarro statusCarro);
}
