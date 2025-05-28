package com.localiza.Localizacars.adapters.outbound.repository;

import com.localiza.Localizacars.utils.enums.StatusCarro;
import com.localiza.Localizacars.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    boolean existsByPlaca(String placa);
    Carro findByPlaca(String Placa);
    List<Carro> findByCidade(String cidade);
    List<Carro> findByStatusCarro(StatusCarro statusCarro);
}
