package br.com.pinkeritours.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class UsuarioResponseDTO {

  private Long id;
  private String nome;
  private String email;
  private String telefone;
  private String senha;
//  private List<ImovelResponseDTO> imoveis;

}
