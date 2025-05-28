package com.localiza.Localizacars.adapters.inbound.controller;

import com.localiza.Localizacars.utils.dto.aluguel.CadastroAluguel;
import com.localiza.Localizacars.infrastructure.exception.AluguelErrorException;
import com.localiza.Localizacars.domain.Aluguel;
import com.localiza.Localizacars.adapters.outbound.repository.CarroRepository;
import com.localiza.Localizacars.adapters.outbound.repository.ClienteRepository;
import com.localiza.Localizacars.application.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private ClienteRepository cliente;
    @Autowired
    private CarroRepository carro;

    @Autowired
    private AluguelService service;

    @PostMapping("/cadastrarAluguel")
    public Aluguel cadastrarAluguel(@RequestBody CadastroAluguel aluguel) throws AluguelErrorException {
       return service.cadastrarAluguel(aluguel);
    }

    @GetMapping("/buscarCarrosAlugados")
    public List<Aluguel> buscarCarrosAlugados() throws AluguelErrorException {
        return service.buscarAlugueis();
    }
}
