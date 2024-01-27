package com.localiza.Localizacars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarroCadastroResponseDTO {

    private String modelo;
    private String cor;
    private int ano;
    private String proprietario;
    private String cidade;
    private String placa;
}
