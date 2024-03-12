package com.localiza.Localizacars.dto.carro;

public record CarroCadastroResponseDTO(
        String modelo,
        String cor,
        int ano,
        String proprietario,
        String cidade,
        String placa
) {
}
