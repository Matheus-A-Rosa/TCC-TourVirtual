package br.com.pinkeritours.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ImovelResponseDTO {

  private Long id;
  private String titulo;
  private String tipo;
  @JsonProperty("area_total")
  private String areaTotal;
  private Double valor;
  @JsonProperty("quantidade_quarto")
  private String quantidadeQuartos;
  @JsonProperty("quantidade_banheiro")
  private String quantidadeBanheiros;
  @JsonProperty("quantidade_vaga_garagem")
  private String quantidadeVagasGaragem;
  private String descricao;
  private String status;
  private Boolean ativado;
  private EnderecoDTO endereco;

}
