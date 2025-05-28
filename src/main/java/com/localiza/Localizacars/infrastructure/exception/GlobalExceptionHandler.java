package com.localiza.Localizacars.infrastructure.exception;

import com.localiza.Localizacars.utils.dto.exception.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CpfErrorException.class)
    public ResponseEntity handleExceptionCpf(CpfErrorException ex) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(ex.getMessage()));
    }

    @ExceptionHandler(EmailErrorException.class)
    public ResponseEntity handleExceptionEmail(EmailErrorException ex) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(ex.getMessage()));
    }

    @ExceptionHandler(CarrosErrorException.class)
    public ResponseEntity handleExceptionEmail(CarrosErrorException ex) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(ex.getMessage()));
    }
}