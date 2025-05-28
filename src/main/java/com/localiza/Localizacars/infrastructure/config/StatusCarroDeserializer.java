package com.localiza.Localizacars.infrastructure.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.localiza.Localizacars.utils.enums.StatusCarro;

import java.io.IOException;

public class StatusCarroDeserializer extends JsonDeserializer<StatusCarro> {
    @Override
    public StatusCarro deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().toUpperCase();
        return StatusCarro.valueOf(value);
    }
}