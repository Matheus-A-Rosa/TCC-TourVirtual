package br.com.pinkeritours.uttils;

import static java.util.Collections.singletonList;
import static org.springframework.data.domain.Sort.Direction.ASC;

import br.com.pinkeritours.dto.EnderecoDTO;
import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.entity.ImovelEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public abstract class ImovelUtils {

  private static final EnderecoDTO enderecoDTO = EnderecoUtils.getEnderecoDTO();

  public static ImovelRequestDTO getImovelRequestDTO() {
    return ImovelRequestDTO.builder()
        .idUsuario(1L)
        .tipo("casa")
        .areaTotal(1000.0)
        .valor(2000000.0)
        .quantidadeQuartos(2)
        .quantidadeBanheiros(2)
        .quantidadeVagasGaragem(1)
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

  private static List<ImovelResponseDTO> getListImovelResponseDTO() {
    return singletonList(getImovelResponseDTO());
  }

  public static List<ImovelEntity> getListImovelEntity() {
    return singletonList(getImovelEntity());
  }

  public static Pageable getPageable() {
    return PageRequest.of(0, 1, ASC, "id");
  }

  public static Page<ImovelResponseDTO> getPageImovelResponseDTO() {
    return new PageImpl<>(getListImovelResponseDTO(), getPageable(), 1L);
  }

  public static Page<ImovelEntity> getPageImovelEntity() {
    return new PageImpl<>(getListImovelEntity(), getPageable(), 1L);
  }

}
