package br.com.pinkeritours.controller;

import static org.springframework.http.HttpStatus.CREATED;

import br.com.pinkeritours.dto.UsuarioRequestDTO;
import br.com.pinkeritours.dto.UsuarioResponseDTO;
import br.com.pinkeritours.service.UsuarioService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/usuarios")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UsuarioController {

  private final UsuarioService service;

  @PostMapping(path = "/registrar")
  public ResponseEntity<UsuarioResponseDTO> registrar(
      @RequestBody @Valid UsuarioRequestDTO requestDTO) {
    return ResponseEntity
        .status(CREATED)
        .body(service.registrar(requestDTO));
  }

}
