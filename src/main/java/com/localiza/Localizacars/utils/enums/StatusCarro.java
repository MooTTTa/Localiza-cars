package com.localiza.Localizacars.utils.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.localiza.Localizacars.infrastructure.config.StatusCarroDeserializer;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonDeserialize(using = StatusCarroDeserializer.class)
public enum StatusCarro {
    ALUGADO,
    DISPONIVEL;
}
