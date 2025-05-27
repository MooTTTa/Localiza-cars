package com.localiza.Localizacars.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonDeserialize(using = StatusCarroDeserializer.class)
public enum StatusAluguel {
    ATIVO,
    FINALIZADO;
}
