package br.com.pinkeritours.service;

import static br.com.pinkeritours.uttils.ImovelUtils.getImovelEntity;
import static br.com.pinkeritours.uttils.ImovelUtils.getImovelRequestDTO;
import static br.com.pinkeritours.uttils.ImovelUtils.getImovelResponseDTO;
import static br.com.pinkeritours.uttils.UsuarioUtils.getUsuarioEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.entity.ImovelEntity;
import br.com.pinkeritours.exception.ErrorBusinessException;
import br.com.pinkeritours.exception.NotFoundException;
import br.com.pinkeritours.mapper.ImovelMapper;
import br.com.pinkeritours.repository.ImovelRepository;
import br.com.pinkeritours.repository.UsuarioRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ImovelServiceTest {

  @InjectMocks
  private ImovelService service;

  @Mock
  private ImovelMapper mapper;

  @Mock
  private ImovelRepository repository;

  @Mock
  private UsuarioRepository usuarioRepository;


  @Test
  void quandoSalvar_retornaSucesso() {
    ImovelEntity entity = getImovelEntity();
    ImovelResponseDTO responseDTO = getImovelResponseDTO();

    when(mapper.requestDtoToEntity(any(ImovelRequestDTO.class)))
        .thenReturn(entity);
    entity.setId(1L);
    when(usuarioRepository.findById(anyLong()))
        .thenReturn(Optional.of(getUsuarioEntity()));
    when(repository.save(any(ImovelEntity.class)))
        .thenReturn(entity);
    when(mapper.entityToResponseDTO(any(ImovelEntity.class)))
        .thenReturn(responseDTO);

    assertThat(service.salvar(getImovelRequestDTO()))
        .isNotNull()
        .isEqualTo(responseDTO);
  }

  @Test
  void quandoSalvarComTipoImovelInvalido_retornaErro() {
    ImovelEntity entity = getImovelEntity();
    ImovelRequestDTO requestDTO = getImovelRequestDTO();
    requestDTO.setTipo("teste");

    when(mapper.requestDtoToEntity(any(ImovelRequestDTO.class)))
        .thenReturn(entity);

    assertThatThrownBy(() -> service.salvar(requestDTO))
        .isInstanceOf(ErrorBusinessException.class)
        .hasMessage("Tipo imóvel inválido, favor informar se é casa ou apartamento");
  }

  @Test
  void quandoSalvarComStatusInvalido_retornaErro() {
    ImovelEntity entity = getImovelEntity();
    ImovelRequestDTO requestDTO = getImovelRequestDTO();
    requestDTO.setStatus("teste");

    when(mapper.requestDtoToEntity(any(ImovelRequestDTO.class)))
        .thenReturn(entity);

    assertThatThrownBy(() -> service.salvar(requestDTO))
        .isInstanceOf(ErrorBusinessException.class)
        .hasMessage("Status do imóvel inválido, favor informar se está a venda ou para alugar");
  }

  @Test
  void quandoSalvarComUsuarioInvalido_retornaNotFoundException() {
    ImovelEntity entity = getImovelEntity();
    ImovelRequestDTO requestDTO = getImovelRequestDTO();

    when(mapper.requestDtoToEntity(any(ImovelRequestDTO.class)))
        .thenReturn(entity);
    when(usuarioRepository.findById(anyLong()))
        .thenReturn(Optional.empty());

    assertThatThrownBy(() -> service.salvar(requestDTO))
        .isInstanceOf(NotFoundException.class)
        .hasMessage(String.format("Usuário %d não encontrado", 1L));
  }
}