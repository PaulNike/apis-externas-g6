package com.codigo.apis_externas.controller;

import com.codigo.apis_externas.aggregates.constants.Constants;
import com.codigo.apis_externas.aggregates.request.PersonaRequest;
import com.codigo.apis_externas.aggregates.response.BaseResponse;
import com.codigo.apis_externas.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personas/v1")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<BaseResponse> crearPersona(
            @RequestBody PersonaRequest personaRequest){
        BaseResponse response = personaService.crearPersona(personaRequest);
        if(response.getCode().equals(Constants.OK_DNI_CODE)){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<BaseResponse> listarPersonas(){
        BaseResponse response = personaService.listarPersonas();
        if(response.getCode().equals(Constants.OK_DNI_CODE)){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{dni}")
    public ResponseEntity<BaseResponse> eliminar(@PathVariable("dni") String dni){
        BaseResponse response = personaService.eliminarPersona(dni);
        if(response.getCode().equals(Constants.OK_DNI_CODE)){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
