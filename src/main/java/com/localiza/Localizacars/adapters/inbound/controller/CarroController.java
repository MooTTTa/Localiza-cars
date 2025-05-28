package com.localiza.Localizacars.adapters.inbound.controller;

import com.localiza.Localizacars.utils.dto.carro.*;
import com.localiza.Localizacars.infrastructure.exception.CarrosErrorException;
import com.localiza.Localizacars.domain.Carro;
import com.localiza.Localizacars.application.service.CarroSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroSerive service;

    @PostMapping("/cadastrar")
    public ResponseEntity<CarroResponseDTO> cadastrarCarro(@RequestBody CarroCadastroRequestDTO carro) throws CarrosErrorException {
        service.cadastarCarro(carro);
        return new ResponseEntity<>(new CarroResponseDTO("Veiculo com a placa: (" + carro.placa() + "), cadastrado com sucesso!"), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public List<Carro> buscarCarros() throws CarrosErrorException {
        return service.findAllCars();
    }

    @GetMapping("/listarCarrosForStatus")
    public List<Carro> findCarrosForStatus(@RequestBody StatusCarroRequest statusCarro) throws CarrosErrorException {
        return service.findCarrosForStatus(statusCarro);
    }

    @GetMapping("/buscarCarrosNaCidade")
    public List<Carro> buscarCarrosNaCidade(@RequestBody CarroByCidade cidade) throws CarrosErrorException {
        return service.findByCarByCity(cidade);
    }

    @GetMapping("/buscarCarro")
    public Carro buscarCarro(@RequestBody PlacaDto dto) throws CarrosErrorException {
        return service.findByCar(dto.placa());
    }

    @DeleteMapping("/remover")
    public ResponseEntity<CarroResponseDTO> deletarCarro(@RequestBody PlacaDto placa) throws CarrosErrorException {
         service.removerCarro(placa.placa());
         return new ResponseEntity<>(new CarroResponseDTO("Veiculo com a placa: (" + placa.placa() + "), removido com sucesso!"), HttpStatus.OK);
    }

    @PatchMapping("/alterarVeiculo")
    public ResponseEntity<CarroResponseDTO> AlterarCorCarro(@RequestBody CarroCadastroRequestDTO carroedit) throws CarrosErrorException {
        service.alterarVeiculo(carroedit);
        return new ResponseEntity<>(new CarroResponseDTO("Veiculo com a placa: (" + carroedit.placa() + "), foi alterado com sucesso!"), HttpStatus.OK);
    }
}
