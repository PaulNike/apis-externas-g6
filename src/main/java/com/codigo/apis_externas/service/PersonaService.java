package com.codigo.apis_externas.service;

import com.codigo.apis_externas.aggregates.request.PersonaRequest;
import com.codigo.apis_externas.aggregates.response.PersonaResponse;
import com.codigo.apis_externas.aggregates.response.ReniecResponse;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PersonaService {
    PersonaResponse crearPersona(PersonaRequest request);
    PersonaResponse listarPersonas();
    PersonaResponse buscarPersonaDni(String dni);
    PersonaResponse actualizarPersona(Long id, PersonaRequest personaRequest);
    PersonaResponse eliminarPersona(String dni);
    PersonaResponse buscarDatosReniec(String dni);
    PersonaResponse buscarPrueba(int code) throws Exception;
    PersonaResponse buscarPrueba2(String dni);

}
