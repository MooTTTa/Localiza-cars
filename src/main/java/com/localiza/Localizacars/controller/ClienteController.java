package com.localiza.Localizacars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.localiza.Localizacars.dto.ClienteResponseDTO;
import com.localiza.Localizacars.dto.CpfDto;
import com.localiza.Localizacars.exception.CpfErrorException;
import com.localiza.Localizacars.exception.EmailErrorException;
import com.localiza.Localizacars.model.Cliente;
import com.localiza.Localizacars.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> inserirCliente(@RequestBody Cliente cliente) throws EmailErrorException, CpfErrorException {
        Cliente cliente1 = service.insert(cliente);
        ClienteResponseDTO dto = new ClienteResponseDTO(cliente.getNome(), "Cliente cadastrado com sucesso!");
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public void delete(@RequestBody CpfDto cpf) throws CpfErrorException {
        service.delete(cpf.cpf());
    }

    @GetMapping("/buscarCliente")
    public Cliente findCliente(@RequestBody CpfDto cpf) throws CpfErrorException {
        return service.findCliente(cpf.cpf());
    }

    @GetMapping("/buscarAllClientes")
    public List<Cliente> findCliente() throws CpfErrorException {
        return service.findAllCliente();
    }

//    @PostMapping
//    public void logar(){
//
//    }
}
