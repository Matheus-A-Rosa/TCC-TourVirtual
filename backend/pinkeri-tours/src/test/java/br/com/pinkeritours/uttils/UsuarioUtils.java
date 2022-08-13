package br.com.pinkeritours.uttils;

import br.com.pinkeritours.dto.UsuarioResponseDTO;
import br.com.pinkeritours.entity.UsuarioEntity;

public abstract class UsuarioUtils {

  public static UsuarioResponseDTO getUsuarioResponseDTO() {
    return UsuarioResponseDTO.builder()
        .id(1L)
        .nome("teste")
        .email("teste@gmail.com")
        .telefone("99999999999")
        .senha("teste123")
        .build();
  }

  public static UsuarioEntity getUsuarioEntity() {
    return UsuarioEntity.builder()
        .id(1L)
        .nome("teste")
        .email("teste@gmail.com")
        .telefone("99999999999")
        .senha("teste123")
        .build();
  }

}
