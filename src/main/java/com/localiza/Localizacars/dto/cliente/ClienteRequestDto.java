package com.localiza.Localizacars.dto.cliente;

import org.jetbrains.annotations.NotNull;

public record ClienteRequestDto(

        @NotNull Long cpf,
        @NotNull String email,
        @NotNull String nome,
        @NotNull String cidade,
        @NotNull String senha,
        @NotNull Long idade

) {

}
