package com.codigo.apis_externas.controller.advice;

import com.codigo.apis_externas.aggregates.constants.Constants;
import com.codigo.apis_externas.aggregates.response.PersonaResponse;
import com.codigo.apis_externas.controller.personalizado.ApiException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.Optional;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PersonaResponse> controlandoException(Exception exception){
        PersonaResponse response = new PersonaResponse();
        response.setCode(Constants.ERROR_TRX_CODE);
        response.setMessage(Constants.ERROR_TRX_MESS + exception.getMessage());
        response.setData(Optional.empty());
        log.error("EXCEPTION CAPUTRADA EN:. . . controlandoException");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<PersonaResponse> controlandoIoException(IOException ioException){
        PersonaResponse response = new PersonaResponse();
        response.setCode(Constants.ERROR_TRX_CODE);
        response.setMessage(Constants.ERROR_TRX_MESS + ioException.getMessage());
        response.setData(Optional.empty());
        log.error("EXCEPTION CAPUTRADA EN:. . . controlandoIoException");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<PersonaResponse> controlandoApiException(ApiException apiException){
        PersonaResponse response = new PersonaResponse();
        response.setCode(Constants.ERROR_TRX_API_EXCEPTION_CODE);
        response.setMessage(Constants.ERROR_TRX_API_EXCEPTION_MESS + apiException.getMessage());
        response.setData(Optional.empty());
        log.error("EXCEPTION CAPUTRADA EN:. . . controlandoApiException");
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
}
