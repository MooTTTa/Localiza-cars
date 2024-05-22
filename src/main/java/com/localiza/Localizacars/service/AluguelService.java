package com.localiza.Localizacars.service;

import com.localiza.Localizacars.dto.aluguel.CadastroAluguel;
import com.localiza.Localizacars.enums.StatusCarro;
import com.localiza.Localizacars.model.Aluguel;
import com.localiza.Localizacars.model.Carro;
import com.localiza.Localizacars.model.Cliente;
import com.localiza.Localizacars.repository.AluguelRepository;
import com.localiza.Localizacars.repository.CarroRepository;
import com.localiza.Localizacars.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private AluguelRepository aluguelRepository;

    @Transactional
    public Aluguel cadastrarAluguel(CadastroAluguel aluguel){
        Cliente cliente1 = clienteRepository.findByCpf(aluguel.cliente());
        Carro carro1 = carroRepository.findByPlaca(aluguel.carro());

        Aluguel aluguel1 = new Aluguel();
        aluguel1.setCliente(cliente1.getCpf());
        aluguel1.setCarro(carro1.getPlaca());
        aluguel1.setCidade(aluguel.cidade());
        aluguel1.setDataHoraInicio(LocalDateTime.now());
        aluguel1.setTempoAluguel(aluguel.tempoAluguel());
        aluguel1.setDataHoraFim(LocalDateTime.now().plusDays(aluguel.tempoAluguel()));

        carro1.setStatusCarro(StatusCarro.ALUGADO);
        carroRepository.save(carro1);

        aluguelRepository.save(aluguel1);
        return aluguel1;
    }

    public List<Aluguel> buscarCarrosAlugados(){
        return aluguelRepository.findAll();
    }
}
