package com.localiza.Localizacars.utils.dto.carro;

import com.localiza.Localizacars.utils.enums.StatusCarro;

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
