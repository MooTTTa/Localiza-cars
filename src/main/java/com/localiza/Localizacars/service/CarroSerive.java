package com.localiza.Localizacars.service;

import com.localiza.Localizacars.dto.carro.AlterarCorCarroDTO;
import com.localiza.Localizacars.dto.carro.CarroByCidade;
import com.localiza.Localizacars.dto.carro.CarroCadastroRequestDTO;
import com.localiza.Localizacars.enums.StatusCarro;
import com.localiza.Localizacars.exception.CarrosErrorException;
import com.localiza.Localizacars.model.Aluguel;
import com.localiza.Localizacars.model.Carro;
import com.localiza.Localizacars.repository.CarroRepository;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CarroSerive {

    @Autowired
    private CarroRepository repository;

    public void cadastarCarro(CarroCadastroRequestDTO carro) throws CarrosErrorException {
        if (repository.existsByPlaca(carro.placa())) throw new CarrosErrorException("Veiculo com essa placa já cadastrado!");

        Carro carro1 = new Carro();
        carro1.setModelo(carro.modelo());
        carro1.setAno(carro.ano());
        carro1.setCor(carro.cor());
        carro1.setCidade(carro.cidade());
        carro1.setProprietario(carro.proprietario());
        carro1.setPlaca(carro.placa());
        carro1.setStatusCarro(StatusCarro.DISPONIVEL);

        repository.save(carro1);
    }

    public List<Carro> findAllCars() throws CarrosErrorException {
        if (repository.findAll().isEmpty()) throw new CarrosErrorException("Não existe carros!");
        return repository.findAll();
    }

    public Carro findByCar(String placa) throws CarrosErrorException {
        Carro carro = repository.findByPlaca(placa);
        if (carro == null) throw new CarrosErrorException("Veiculo não encontrado!");
        return carro;
    }

    public List<Carro> buscarCarrosAllDisponiveis(CarroCadastroRequestDTO statusCarro) throws CarrosErrorException {
        List<Carro> carrosDisponiveis = new ArrayList<>();
        for (Carro carro : repository.findAll()){
            if (carro.getStatusCarro().equals(statusCarro.statusCarro())){
                carrosDisponiveis.add(carro);
            }
        }
        return carrosDisponiveis;
    }

    public List<Carro> findByCarByCity(@NotNull CarroByCidade cidade) throws CarrosErrorException {
        List<Carro> carros = repository.findByCidade(cidade.cidade());
        if (carros.isEmpty()) throw new CarrosErrorException("Não existe carros na cidade");
        return carros;
    }

    public void removerCarro(String placa) throws CarrosErrorException {
        Carro carro = repository.findByPlaca(placa);
        if (carro == null) throw new CarrosErrorException("Não existe este carro!");
        repository.delete(carro);
    }

    public Carro alterarCor(AlterarCorCarroDTO dto) throws CarrosErrorException {
        Carro carro = repository.findByPlaca(dto.placa());
        if (carro == null) throw new CarrosErrorException("Veiculo não encontrado!");
        if (Objects.equals(dto.cor(), carro.getCor())) throw new CarrosErrorException("Veiculo já está registrado com está cor!");
        carro.setCor(dto.cor());
        return repository.save(carro);
    }
}
