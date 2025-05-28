package com.localiza.Localizacars.application.service;

import com.localiza.Localizacars.utils.dto.carro.CarroByCidade;
import com.localiza.Localizacars.utils.dto.carro.CarroCadastroRequestDTO;
import com.localiza.Localizacars.utils.dto.carro.StatusCarroRequest;
import com.localiza.Localizacars.utils.enums.StatusCarro;
import com.localiza.Localizacars.infrastructure.exception.CarrosErrorException;
import com.localiza.Localizacars.domain.Carro;
import com.localiza.Localizacars.adapters.outbound.repository.CarroRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Carro> findCarrosForStatus(StatusCarroRequest statusCarro) throws CarrosErrorException {
        List<Carro> carrosDisponiveis = repository.findByStatusCarro(statusCarro.statusCarro());
        if (carrosDisponiveis.isEmpty()) throw new CarrosErrorException("Não há carros com esse status no momento.");
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

    public void alterarVeiculo(CarroCadastroRequestDTO carroedit) throws CarrosErrorException {
        Carro carro = repository.findByPlaca(carroedit.placa());
        if (carro == null) throw new CarrosErrorException("Veiculo não encontrado!");
        carro.setModelo(carroedit.modelo());
        carro.setAno(carroedit.ano());
        carro.setCor(carroedit.cor());
        carro.setCidade(carroedit.cidade());
        carro.setProprietario(carroedit.proprietario());
        carro.setPlaca(carroedit.placa());
        carro.setStatusCarro(carro.getStatusCarro());
        repository.save(carro);
    }
}
