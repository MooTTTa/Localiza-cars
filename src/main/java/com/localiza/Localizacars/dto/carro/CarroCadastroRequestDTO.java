package com.localiza.Localizacars.dto.carro;

import com.localiza.Localizacars.enums.StatusCarro;

public record CarroCadastroRequestDTO(
        String modelo,
        String cor,
        int ano,
        String proprietario,
        String cidade,
        String placa,
        StatusCarro statusCarro
) {
}
