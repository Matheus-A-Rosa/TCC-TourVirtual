package br.com.pinkeritours.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
public class EnderecoDTO {

  @NotBlank(message = "campo cep é obrigatório")
  @Size(min = 8, max = 8, message = "cep inválido - revise a quantidade de números")
  private String cep;

  @NotBlank(message = "campo rua é obrigatório")
  private String rua;

  @NotBlank(message = "campo bairro é obrigatório")
  private String bairro;

  @NotBlank(message = "campo cidade é obrigatório")
  private String cidade;

  @NotBlank(message = "campo uf é obrigatório")
  @Size(min = 2, max = 2, message = "uf inválida")
  private String uf;

  @NotBlank(message = "campo complemento é obrigatório")
  private String complemento;

}
