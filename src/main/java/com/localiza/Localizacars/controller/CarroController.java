package com.localiza.Localizacars.controller;

import com.localiza.Localizacars.dto.AlterarCorCarroDTO;
import com.localiza.Localizacars.dto.CarroCadastroResponseDTO;
import com.localiza.Localizacars.dto.CarroResponseDTO;
import com.localiza.Localizacars.dto.PlacaDto;
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

    @PostMapping("throw new CarrosErrorException(\"Veiculo com essa placa já cadastrado!\");")
    public ResponseEntity<CarroResponseDTO> cadastrarCarro(@RequestBody CarroCadastroResponseDTO carro) throws CarrosErrorException {
        service.cadastarCarro(carro);
        CarroResponseDTO DTO = new CarroResponseDTO(carro, "Veiculo cadastrado com sucesso!");
        return new ResponseEntity<>(DTO, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public List<Carro> buscarCarros() throws CarrosErrorException {
        return service.findAllCars();
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
