package com.angel.restexample.controller;

import com.angel.restexample.dto.ErrorDto;
import com.angel.restexample.dto.RequestDto;
import com.angel.restexample.dto.ResponseDto;
import com.angel.restexample.exception.InputDataException;
import com.angel.restexample.facade.UserzFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/")
public class RestExampleController {

    private final UserzFacade userzFacade;

    public RestExampleController(final UserzFacade userService) {
        this.userzFacade = userService;
    }

    @Operation(summary = "Registrar un usuario", description = "Registrar usuario con listado de números de télefono")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación realizada con éxito",
                    content = {@Content(schema = @Schema(implementation = ResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error",
                    content = {@Content(schema = @Schema(implementation = ErrorDto.class))})
    })
    @PostMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto register(@RequestBody final RequestDto dto) throws InputDataException, NoSuchAlgorithmException {
        return userzFacade.register(dto);
    }
}
