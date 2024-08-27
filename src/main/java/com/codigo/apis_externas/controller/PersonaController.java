package com.codigo.apis_externas.controller;

import com.codigo.apis_externas.aggregates.constants.Constants;
import com.codigo.apis_externas.aggregates.request.PersonaRequest;
import com.codigo.apis_externas.aggregates.response.PersonaResponse;
import com.codigo.apis_externas.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personas/v1")
@Tag(
        name = "API GESTION DE PERSONAS",
        description = "Esta api contiene los endPoints para la gestión de las personas, " +
                "desde crear hasta eliminar de manera logica")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/crear")
    @Operation(summary = "EndPoint que te permite crear una Persona con estado Activo")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Persona creada correctamente",
            content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = PersonaResponse.class),
            examples = @ExampleObject(name = "PersonaResponse",
            value = "{\n" +
                    "\"code\": 201,\n" +
                    "\"message\": \"Persona Creada Exitosamente\",\n" +
                    "\"data\": {\n" +
                    "\"id\": 1,\n" +
                    "\"numDoc\": \"12345678\",\n" +
                    "\"tipoDoc\": \"DNI\",\n" +
                    "\"nombres\": \"Paul\",\n" +
                    "\"apellidos\": \"Rodriguez\",\n" +
                    "\"estado\": 1,\n" +
                    "\"usua_crea\": \"admin\",\n" +
                    "\"date_crea\": \"2024-08-26 14:00:00\",\n" +
                    "\"usua_upda\": \"admin\",\n" +
                    "\"date_upda\": \"2024-08-26 15:00:00\",\n" +
                    "\"usua_dele\": \"\",\n" +
                    "\"date_dele\": null\n" +
                    "}\n" +
                    "}"))}),
            @ApiResponse(responseCode = "400", description = "El request no cumple con los datos requeridos.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaResponse.class),
                            examples = @ExampleObject(name = "PersonaResponse",
                            value = "{\n" +
                                    "\"code\": 400,\n" +
                                    "\"message\": \"Request Incorrecto\",\n" +
                                    "\"data\": null\n" +
                                    "}"))})
    })
    public ResponseEntity<PersonaResponse> crearPersona(
            @RequestBody PersonaRequest personaRequest){
        PersonaResponse response = personaService.crearPersona(personaRequest);
        if(response.getCode().equals(Constants.OK_DNI_CODE)){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<PersonaResponse> listarPersonas(){
        PersonaResponse response = personaService.listarPersonas();
        if(response.getCode().equals(Constants.OK_DNI_CODE)){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{dni}")
    public ResponseEntity<PersonaResponse> eliminar(@PathVariable("dni") String dni){
        PersonaResponse response = personaService.eliminarPersona(dni);
        if(response.getCode().equals(Constants.OK_DNI_CODE)){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/buscarDatosReniec/{dni}")
    public ResponseEntity<PersonaResponse> listarPersonas(@PathVariable("dni")String dni){
        PersonaResponse response = personaService.buscarDatosReniec(dni);
        if(response.getCode().equals(Constants.OK_DNI_CODE)){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
