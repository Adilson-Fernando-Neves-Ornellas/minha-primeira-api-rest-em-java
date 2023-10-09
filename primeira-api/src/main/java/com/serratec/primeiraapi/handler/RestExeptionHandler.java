package com.serratec.primeiraapi.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.serratec.primeiraapi.common.ConversorData;
import com.serratec.primeiraapi.error.exeptions.ResouceBadRequestExeption;
import com.serratec.primeiraapi.error.exeptions.ResouceNotFoundExeption;
import com.serratec.primeiraapi.error.ErrorResponse;

@ControllerAdvice
public class RestExeptionHandler {
    
    String dataAtual = ConversorData.converterDateParaDataHora(new Date());
    
    @ExceptionHandler(ResouceNotFoundExeption.class)
    public ResponseEntity<ErrorResponse> handlerResouceNotFoundExeption(ResouceNotFoundExeption ex){
        
        ErrorResponse erro = new ErrorResponse(404,"Not Found", ex.getMessage(), dataAtual);

        return new ResponseEntity<>(erro,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResouceBadRequestExeption.class)
    public ResponseEntity<ErrorResponse> handlerResouceBadRequestExeption(ResouceBadRequestExeption ex){
        
        ErrorResponse erro = new ErrorResponse(500,"Bad Request", ex.getMessage(), dataAtual);

        return new ResponseEntity<>(erro,HttpStatus.BAD_REQUEST);
    }

}
