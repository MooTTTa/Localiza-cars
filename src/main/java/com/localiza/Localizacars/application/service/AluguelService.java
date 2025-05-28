package com.localiza.Localizacars.application.service;

import com.localiza.Localizacars.utils.dto.aluguel.CadastroAluguel;
import com.localiza.Localizacars.utils.enums.StatusAluguel;
import com.localiza.Localizacars.utils.enums.StatusCarro;
import com.localiza.Localizacars.infrastructure.exception.AluguelErrorException;
import com.localiza.Localizacars.domain.Aluguel;
import com.localiza.Localizacars.domain.Carro;
import com.localiza.Localizacars.domain.Cliente;
import com.localiza.Localizacars.adapters.outbound.repository.AluguelRepository;
import com.localiza.Localizacars.adapters.outbound.repository.CarroRepository;
import com.localiza.Localizacars.adapters.outbound.repository.ClienteRepository;
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
    public Aluguel cadastrarAluguel(CadastroAluguel aluguel) throws AluguelErrorException{
        Cliente cliente1 = clienteRepository.findByCpf(aluguel.cliente());
        Carro carro1 = carroRepository.findByPlaca(aluguel.carro());

        Aluguel aluguel1 = new Aluguel();
        aluguel1.setCliente(cliente1.getCpf());
        aluguel1.setCarro(carro1.getPlaca());
        aluguel1.setCidade(aluguel.cidade());
        aluguel1.setDataHoraInicio(LocalDateTime.now());
        aluguel1.setTempoAluguel(aluguel.tempoAluguel());
        aluguel1.setDataHoraFim(LocalDateTime.now().plusDays(aluguel.tempoAluguel()));
        aluguel1.setStatusAluguel(StatusAluguel.ATIVO);

        carro1.setStatusCarro(StatusCarro.ALUGADO);
        carroRepository.save(carro1);

        aluguelRepository.save(aluguel1);
        return aluguel1;
    }

    public List<Aluguel> buscarAlugueis() throws AluguelErrorException {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        if (alugueis.isEmpty()) throw new AluguelErrorException("Não há carros alugados.");

        for (Aluguel a : alugueis) {
            if (a.getStatusAluguel() == StatusAluguel.ATIVO && a.getDataHoraFim().isBefore(LocalDateTime.now())) {
                a.setStatusAluguel(StatusAluguel.FINALIZADO);
                aluguelRepository.save(a);
            }
        }
        return alugueis;
    }
}
