package br.com.pinkeritours.mapper;

import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.entity.ImovelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ImovelMapper {

  @Named("validarUF")
  static String validarUF(String uf) {
    return uf.toUpperCase();
  }

  @Named("validarStatus")
  static String validarStatus(String status) {
    return status.toUpperCase();
  }

  @Mapping(source = "endereco.uf", target = "endereco.uf", qualifiedByName = "validarUF")
  @Mapping(source = "status", target = "status", qualifiedByName = "validarStatus")
  ImovelEntity requestDtoToEntity(ImovelRequestDTO requestDTO);

  ImovelResponseDTO entityToResponseDTO(ImovelEntity entity);

  default Page<ImovelResponseDTO> toPageResponseDto(Page<ImovelEntity> entities) {
    return entities.map(this::entityToResponseDTO);
  }
}
