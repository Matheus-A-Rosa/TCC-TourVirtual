package br.com.pinkeritours.service;

import static br.com.pinkeritours.uttils.UsuarioUtils.getUsuarioEntity;
import static br.com.pinkeritours.uttils.UsuarioUtils.getUsuarioResponseDTO;
import static br.com.pinkeritours.uttils.UsuarioUtils.getUsuarioResquestDTO;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import br.com.pinkeritours.dto.UsuarioRequestDTO;
import br.com.pinkeritours.dto.UsuarioResponseDTO;
import br.com.pinkeritours.entity.UsuarioEntity;
import br.com.pinkeritours.exception.ErrorBusinessException;
import br.com.pinkeritours.exception.NotFoundException;
import br.com.pinkeritours.mapper.UsuarioMapper;
import br.com.pinkeritours.repository.UsuarioRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

  @InjectMocks
  private UsuarioService service;

  @Mock
  private UsuarioMapper mapper;

  @Mock
  private UsuarioRepository repository;

  @Mock
  private BCryptPasswordEncoder passwordEncoder;

  @Test
  void whenLoadUserByUsername_returnErroUsernameNotFoundException() {
    String username = anyString();
    when(repository.findByEmail(username))
        .thenReturn(Optional.empty());
    assertThatThrownBy(() -> service.loadUserByUsername(username))
        .isInstanceOf(UsernameNotFoundException.class)
        .hasMessage(format("Usuário %s não encontrado", username));
  }

  @Test
  void whenLoadUserByUsername_returnSuccess() {
    String username = anyString();
    when(repository.findByEmail(username))
        .thenReturn(Optional.of(getUsuarioEntity()));
    assertNotNull(service.loadUserByUsername(username));
  }

  @Test
  void quandoBuscarPorId_comIdInvalido_retornaErro() {
    Long id = anyLong();

    when(repository.findById(id))
        .thenReturn(Optional.empty());

    assertThatThrownBy(() -> service.buscarPorId(id))
        .isInstanceOf(NotFoundException.class)
        .hasMessage(String.format("Usuário %d não encontrado", id));

  }

  @Test
  void quandoBuscarUsuarioPorId_retornaSucesso() {
    Long id = anyLong();
    when(repository.findById(id))
        .thenReturn(Optional.of(getUsuarioEntity()));
    assertNotNull(service.buscarPorId(id));
  }

  @Test
  void quandoRegistrarUsuario_comEmailExistente_retornaErrorBusinessException() {
    UsuarioEntity entity = getUsuarioEntity();

    when(mapper.requestDtoToEntity(any(UsuarioRequestDTO.class)))
        .thenReturn(entity);
    when(repository.findByEmail(anyString()))
        .thenReturn(Optional.of(entity));

    UsuarioRequestDTO resquestDTO = getUsuarioResquestDTO();
    assertThatThrownBy(() -> service.registrar(resquestDTO))
        .isInstanceOf(ErrorBusinessException.class)
        .hasMessage("Já exsite usuário com esse email");

  }

  @Test
  void quandoRegistrarUsuario_retornSucesso() {
    UsuarioEntity entity = getUsuarioEntity();
    String senhaCriptografada = "sdfughsaui";
    UsuarioResponseDTO responseDTO = getUsuarioResponseDTO();

    when(mapper.requestDtoToEntity(any(UsuarioRequestDTO.class)))
        .thenReturn(entity);
    when(repository.findByEmail(anyString()))
        .thenReturn(Optional.empty());
    when(passwordEncoder.encode(anyString()))
        .thenReturn(senhaCriptografada);
    when(repository.save(any(UsuarioEntity.class)))
        .thenReturn(entity);
    responseDTO.setSenha(senhaCriptografada);
    when(mapper.entityToDTO(any(UsuarioEntity.class)))
        .thenReturn(responseDTO);

    UsuarioResponseDTO response = service.registrar(getUsuarioResquestDTO());
    assertEquals(senhaCriptografada, response.getSenha());
  }
}