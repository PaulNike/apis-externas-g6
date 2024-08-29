package com.codigo.apis_externas.controller.personalizado;

public class ApiException extends Exception{

    public ApiException(String mensaje){
        super(mensaje);
    }

}
