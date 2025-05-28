package com.localiza.Localizacars.utils.dto.aluguel;

import com.localiza.Localizacars.utils.enums.StatusAluguel;

public record CadastroAluguel(Long cliente, String carro, int tempoAluguel, String cidade, StatusAluguel statusAluguel) {
}
