package br.com.pinkeritours.mapper;

import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.entity.ImovelEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface ImovelMapper {

  @Named("converterStatusToUpperCase")
  static String converterStatusToUpperCase(String status) {
    return status.toUpperCase();
  }

  @Mapping(source = "status", target = "status", qualifiedByName = "converterStatusToUpperCase")
  @Mapping(source = "descricao", target = "descricao", qualifiedByName = "removerAcentoString")
  ImovelEntity requestDtoToEntity(ImovelRequestDTO requestDTO);

  ImovelResponseDTO entityToResponseDTO(ImovelEntity entity);

  List<ImovelResponseDTO> entityListToResponseDTO(List<ImovelEntity> entity);

  default Page<ImovelResponseDTO> toPageResponseDto(Page<ImovelEntity> entities) {
    return entities.map(this::entityToResponseDTO);
  }
}
