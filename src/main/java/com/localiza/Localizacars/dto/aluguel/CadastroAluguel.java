package com.localiza.Localizacars.dto.aluguel;

import com.localiza.Localizacars.model.Carro;

public record CadastroAluguel(Long cliente, String carro, int tempoAluguel, String cidade) {
}
