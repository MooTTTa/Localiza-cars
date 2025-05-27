package com.localiza.Localizacars.controller;

import com.localiza.Localizacars.dto.cliente.ClienteRequestDto;
import com.localiza.Localizacars.dto.cliente.ClienteResponseDTO;
import com.localiza.Localizacars.dto.cliente.CpfDto;
import com.localiza.Localizacars.exception.CpfErrorException;
import com.localiza.Localizacars.exception.EmailErrorException;
import com.localiza.Localizacars.model.Cliente;
import com.localiza.Localizacars.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    private ResponseEntity<ClienteResponseDTO> inserirCliente(@RequestBody ClienteRequestDto cliente) throws EmailErrorException, CpfErrorException {
        service.insert(cliente);
        return new ResponseEntity<>(new ClienteResponseDTO("Cliente: ("+ cliente.nome() + "), cadastrado com sucesso!"), HttpStatus.CREATED);
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
}
