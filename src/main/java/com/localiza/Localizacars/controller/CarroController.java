package com.localiza.Localizacars.controller;

import com.localiza.Localizacars.dto.carro.*;
import com.localiza.Localizacars.enums.StatusCarro;
import com.localiza.Localizacars.exception.CarrosErrorException;
import com.localiza.Localizacars.model.Carro;
import com.localiza.Localizacars.service.CarroSerive;
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

    @GetMapping("/listarDisponivel")
    public List<Carro> buscarCarrosDisponivel(@RequestBody CarroCadastroRequestDTO statusCarro) throws CarrosErrorException {
        return service.buscarCarrosAllDisponiveis(statusCarro);
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
    public void deletarCarro(@RequestBody PlacaDto placa) throws CarrosErrorException {
         service.removerCarro(placa.placa());
    }

    @PatchMapping("/alterarCor")
    public Carro AlterarCorCarro(@RequestBody AlterarCorCarroDTO dto) throws CarrosErrorException {
        return service.alterarCor(dto);
    }
}
