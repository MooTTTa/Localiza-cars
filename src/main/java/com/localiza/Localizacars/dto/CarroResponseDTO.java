package com.localiza.Localizacars.dto;

import com.localiza.Localizacars.model.Carro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarroResponseDTO {

    private CarroCadastroResponseDTO carro;
    private String mensagem;
}
