package com.example.Aula_De_Spring_9.exception;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(IllegalArgumentException erro) {
        return ResponseEntity.badRequest().body(Map.of( "mensagem",erro.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(RuntimeException erro) {
        return ResponseEntity.badRequest().body(Map.of( "mensagem",erro.getMessage()));
    }

    //validar os coampos do validation (RequestDTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methoArguentNotValidException(MethodArgumentNotValidException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
    }
    
}