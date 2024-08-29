package com.codigo.apis_externas.aggregates.constants;

public class Constants {
    public static final String USU_CREA = "PRODRIGUEZ";
    public static final Integer ERROR_DNI_CODE = 2004;
    public static final String ERROR_DNI_MESS = "ERROR CON EL DNI";
    public static final Integer ERROR_TRX_CODE = 4009;
    public static final String ERROR_TRX_MESS = "ERROR DURANTE LA TRANSACCION ";
    public static final Integer ERROR_TRX_API_EXCEPTION_CODE = 4006;
    public static final String ERROR_TRX_API_EXCEPTION_MESS = "ERROR DURANTE LA TRANSACCION - EXCEPTION PERSONALIZADA:  ";
    public static final Integer ERROR_CODE_LIST_EMPTY= 2009;
    public static final String ERROR_MESS_LIST_EMPTY = "NO HAY REGISTROS!!";
    public static final Integer OK_DNI_CODE = 2000;
    public static final String OK_DNI_MESS = "EJECUTADO SIN PROBLEMAS!";
    public static final Integer STATUS_ACTIVE = 1;
    public static final Integer STATUS_INACTIVE = 0;
    public static final Integer REDIS_EXP = 1;
    public static final String REDIS_KEY_API_PERSON = "MS:APIS:EXTERNAS:";

}
