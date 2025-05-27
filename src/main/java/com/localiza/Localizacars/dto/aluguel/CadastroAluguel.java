package com.localiza.Localizacars.dto.aluguel;

import com.localiza.Localizacars.enums.StatusAluguel;

public record CadastroAluguel(Long cliente, String carro, int tempoAluguel, String cidade, StatusAluguel statusAluguel) {
}
