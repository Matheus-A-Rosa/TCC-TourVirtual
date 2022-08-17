package br.com.pinkeritours.uttils;

import br.com.pinkeritours.dto.EnderecoDTO;
import br.com.pinkeritours.entity.EnderecoEntity;

public abstract class EnderecoUtils {

  public static EnderecoDTO getEnderecoDTO() {
    return EnderecoDTO.builder()
        .cep("88015601")
        .rua("rua almirante lamego")
        .bairro("centro")
        .cidade("florianopolis")
        .uf("SC")
        .complemento("numero 943, apto 504")
        .build();
  }

  public static EnderecoEntity getEnderecoEntity() {
    return EnderecoEntity.builder()
        .id(1L)
        .cep("88015601")
        .rua("rua almirante lamego")
        .bairro("centro")
        .cidade("florianopolis")
        .uf("SC")
        .complemento("numero 943, apto 504")
        .build();
  }

}
