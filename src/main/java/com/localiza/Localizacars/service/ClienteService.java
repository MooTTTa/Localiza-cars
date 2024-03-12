package com.localiza.Localizacars.service;

import com.localiza.Localizacars.dto.cliente.ClienteRequestDto;
import com.localiza.Localizacars.exception.CpfErrorException;
import com.localiza.Localizacars.exception.EmailErrorException;
import com.localiza.Localizacars.model.Cliente;
import com.localiza.Localizacars.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente insert(ClienteRequestDto cliente) throws CpfErrorException, EmailErrorException {

        if (repository.existsByCpf(cliente.cpf())) {
            throw new CpfErrorException("CPF já está sendo utilizado por outro usuário");
        }
        if (repository.existsByEmail(cliente.email())) {
            throw new EmailErrorException("Email já está sendo utilizado por outro usuário");
        }

        Cliente cliente1 = new Cliente();
        cliente1.setCpf(cliente.cpf());
        cliente1.setNome(cliente.nome());
        cliente1.setEmail(cliente.email());
        cliente1.setCidade(cliente.cidade());
        cliente1.setIdade(cliente.idade());
        cliente1.setSenha(cliente.senha());

        return repository.save(cliente1);
    }

    public void delete(Long cpf) throws CpfErrorException {
        Cliente cliente = repository.findByCpf(cpf);

        if (cliente == null) {
            throw new CpfErrorException("CPF inexistente!");
        }

        repository.delete(cliente);
    }

    public Cliente findCliente(Long cpf) throws CpfErrorException {

        Cliente cliente = repository.findByCpf(cpf);

        if (cliente == null) {
            throw new CpfErrorException("Cliente inexistente!");
        }
        return cliente;
    }

    public List<Cliente> findAllCliente() throws CpfErrorException {
        if (repository.findAll().isEmpty()) {
            throw new CpfErrorException("Não existe clientes!");
        }
        return repository.findAll();
    }
}
