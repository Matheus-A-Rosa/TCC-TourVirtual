package br.com.pinkeritours.controller;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.service.ImovelService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/imoveis")
@RequiredArgsConstructor
public class ImovelController {

  private final ImovelService service;

  @PostMapping
  public ResponseEntity<ImovelResponseDTO> salvar(@RequestBody @Valid ImovelRequestDTO requestDTO) {
    return ResponseEntity
        .status(CREATED)
        .body(service.salvar(requestDTO));
  }

  @GetMapping
  public ResponseEntity<Page<ImovelResponseDTO>> listar(@RequestParam int page,
      @RequestParam int size) {
    return ResponseEntity
        .status(OK)
        .body(service.listar(PageRequest.of(page, size, ASC, "id")));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ImovelResponseDTO> buscarPorId(@PathVariable Long id) {
    return ResponseEntity
        .status(OK)
        .body(service.buscarPorId(id));
  }

  @GetMapping(path = "/busca_personalizada")
  public ResponseEntity<Page<ImovelResponseDTO>> buscar(
      @RequestParam int page,
      @RequestParam int size,
      @RequestParam String tipo,
      @RequestParam String status
  ) {
    return ResponseEntity
        .status(OK)
        .body(service.buscar(PageRequest.of(page, size, ASC, "id"), tipo, status));
  }
  @GetMapping(path = "/busca")
  public ResponseEntity<List<ImovelResponseDTO>> buscar(
      @RequestParam String tipo, @RequestParam String status) {
    return ResponseEntity
        .status(OK)
        .body(service.buscar(tipo, status));
  }

}
