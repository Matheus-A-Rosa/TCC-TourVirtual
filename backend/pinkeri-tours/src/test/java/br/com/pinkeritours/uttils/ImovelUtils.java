package br.com.pinkeritours.uttils;

import br.com.pinkeritours.dto.EnderecoDTO;
import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.entity.ImovelEntity;

public abstract class ImovelUtils {

  private static final EnderecoDTO enderecoDTO = EnderecoUtils.getEnderecoDTO();

  public static ImovelRequestDTO getImovelRequestDTO() {
    return ImovelRequestDTO.builder()
        .idUsuario(1L)
        .tipo("casa")
        .areaTotal("1000")
        .valor(2000000.0)
        .quantidadeQuartos("2")
        .quantidadeBanheiros("2")
        .quantidadeVagasGaragem("1")
        .descricao("teste teste teste")
        .status("venda")
        .endereco(enderecoDTO)
        .build();
  }

  public static ImovelEntity getImovelEntity() {
    return ImovelEntity.builder()
        .tipo("casa")
        .areaTotal("1000")
        .valor(2000000.0)
        .quantidadeQuartos("2")
        .quantidadeBanheiros("2")
        .quantidadeVagasGaragem("1")
        .descricao("teste teste teste")
        .status("venda")
        .endereco(null)
        .build();
  }

  public static ImovelResponseDTO getImovelResponseDTO() {
    return ImovelResponseDTO.builder()
        .id(1L)
        .titulo("Vende-se casa: centro - florianopolis, SC")
        .tipo("casa")
        .areaTotal("1000")
        .valor(2000000.0)
        .quantidadeQuartos("2")
        .quantidadeBanheiros("2")
        .quantidadeVagasGaragem("1")
        .descricao("teste teste teste")
        .status("venda")
        .endereco(enderecoDTO)
        .build();
  }

}
