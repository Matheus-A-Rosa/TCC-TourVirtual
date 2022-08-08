package br.com.pinkeritours.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "campo area_total é obrigatório")
    private String areaTotal;

    @NotNull(message = "campo valor é obrigatório")
    private Double valor;

    @JsonProperty("quantidade_quarto")
    @NotBlank(message = "campo quantidade_quarto é obrigatório")
    private String quantidadeQuartos;

    @JsonProperty("quantidade_banheiro")
    @NotBlank(message = "campo quantidade_banheiro é obrigatório")
    private String quantidadeBanheiros;

    @JsonProperty("quantidade_vaga_garagem")
    @NotBlank(message = "campo quantidade_vaga_garagem é obrigatório")
    private String quantidadeVagasGaragem;

    @NotBlank(message = "campo descricao é obrigatório")
    private String descricao;

    @NotBlank(message = "campo status é obrigatório")
    private String status;

    @Valid
    private EnderecoDTO enderecoDTO;

}
