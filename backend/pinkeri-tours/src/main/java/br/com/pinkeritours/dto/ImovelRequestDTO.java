package br.com.pinkeritours.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class ImovelRequestDTO {

  @JsonProperty("id_usuario")
  private Long idUsuario;

  @NotBlank(message = "campo tipo é obrigatório")
  private String tipo;

  @JsonProperty("area_total")
  @NotNull(message = "campo area_total é obrigatório")
  private Double areaTotal;

  @NotNull(message = "campo valor é obrigatório")
  private Double valor;

  @JsonProperty("quantidade_quarto")
  @NotNull(message = "campo quantidade_quarto é obrigatório")
  private Integer quantidadeQuartos;

  @JsonProperty("quantidade_banheiro")
  @NotNull(message = "campo quantidade_banheiro é obrigatório")
  private Integer quantidadeBanheiros;

  @JsonProperty("quantidade_vaga_garagem")
  @NotNull(message = "campo quantidade_vaga_garagem é obrigatório")
  private Integer quantidadeVagasGaragem;

  @NotBlank(message = "campo descricao é obrigatório")
  private String descricao;

  @NotBlank(message = "campo status é obrigatório")
  private String status;

  @Valid
  @NotNull(message = "campo endereco é obrigatório")
  private EnderecoDTO endereco;

  @NotNull
  @JsonProperty("url_imagem")
  private String urlImagem;

}
