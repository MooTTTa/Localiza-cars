package com.localiza.Localizacars.service;

import com.localiza.Localizacars.dto.carro.AlterarCorCarroDTO;
import com.localiza.Localizacars.dto.carro.CarroCadastroResponseDTO;
import com.localiza.Localizacars.enums.StatusCarro;
import com.localiza.Localizacars.exception.CarrosErrorException;
import com.localiza.Localizacars.model.Carro;
import com.localiza.Localizacars.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarroSerive {

    @Autowired
    private CarroRepository repository;

    public void cadastarCarro(CarroCadastroResponseDTO carro) throws CarrosErrorException {

        if (repository.existsByPlaca(carro.placa())){
            throw new CarrosErrorException("Veiculo com essa placa já cadastrado!");
        }

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
        if (repository.findAll().isEmpty()){
            throw new CarrosErrorException("Não existe carros!");
        }
        return repository.findAll();
    }

    public Carro findByCar(String placa) throws CarrosErrorException {
        Carro carro = repository.findByPlaca(placa);
        if (carro == null){
            throw new CarrosErrorException("Veiculo não encontrado!");
        }
       return carro;
    }

    public void removerCarro(String placa) throws CarrosErrorException {
        Carro carro = repository.findByPlaca(placa);
        if (carro == null){
            throw new CarrosErrorException("Não existe este carro!");
        }
        repository.delete(carro);
    }

    public Carro alterarCor(AlterarCorCarroDTO dto) throws CarrosErrorException {

        Carro carro = repository.findByPlaca(dto.placa());

        if (carro == null){
            throw new CarrosErrorException("Veiculo não encontrado!");
        }

        if (Objects.equals(dto.cor(), carro.getCor())){
            throw new CarrosErrorException("Veiculo já está registrado com está cor!");
        }

        carro.setCor(dto.cor());

        return repository.save(carro);
    }
}
