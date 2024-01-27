package com.localiza.Localizacars.exception;

import com.localiza.Localizacars.dto.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CpfErrorException.class)
    public ResponseEntity handleExceptionCpf(CpfErrorException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage(), "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EmailErrorException.class)
    public ResponseEntity handleExceptionEmail(EmailErrorException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage(), "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(CarrosErrorException.class)
    public ResponseEntity handleExceptionEmail(CarrosErrorException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage(), "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}