package br.com.pinkeritours.controller;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.service.ImovelService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/imoveis")
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


}
