package com.localiza.Localizacars.controller;

import com.localiza.Localizacars.dto.aluguel.CadastroAluguel;
import com.localiza.Localizacars.enums.StatusCarro;
import com.localiza.Localizacars.model.Aluguel;
import com.localiza.Localizacars.model.Carro;
import com.localiza.Localizacars.model.Cliente;
import com.localiza.Localizacars.repository.AluguelRepository;
import com.localiza.Localizacars.repository.CarroRepository;
import com.localiza.Localizacars.repository.ClienteRepository;
import com.localiza.Localizacars.service.AluguelService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public Aluguel cadastrarAluguel(@RequestBody CadastroAluguel aluguel){
       return service.cadastrarAluguel(aluguel);
    }

    @GetMapping("/buscarCarrosAlugados")
    public List<Aluguel> buscarCarrosAlugados(){
        return service.buscarCarrosAlugados();
    }
}
