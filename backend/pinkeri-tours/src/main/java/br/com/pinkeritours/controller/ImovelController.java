package br.com.pinkeritours.controller;

import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.service.ImovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

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


}
