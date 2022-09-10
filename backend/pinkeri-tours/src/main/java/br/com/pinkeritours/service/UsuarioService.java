package br.com.pinkeritours.service;

import static java.lang.String.format;

import br.com.pinkeritours.dto.UsuarioRequestDTO;
import br.com.pinkeritours.dto.UsuarioResponseDTO;
import br.com.pinkeritours.entity.UsuarioEntity;
import br.com.pinkeritours.exception.ErrorBusinessException;
import br.com.pinkeritours.exception.NotFoundException;
import br.com.pinkeritours.mapper.UsuarioMapper;
import br.com.pinkeritours.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService /*implements UserDetailsService*/ {

  private final UsuarioRepository repository;
  private final UsuarioMapper mapper;
//  private final BCryptPasswordEncoder passwordEncoder;

//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    return repository.findByEmail(username)
//        .orElseThrow(
//            () -> new UsernameNotFoundException(format("Usuário %s não encontrado", username)));
//  }

  public UsuarioEntity findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Usuário %d não encontrado", id)));
  }

  public UsuarioResponseDTO registrar(UsuarioRequestDTO requestDTO) {
    UsuarioEntity entity = mapper.requestDtoToEntity(requestDTO);
    validaEmail(requestDTO.getEmail());
//    entity.setSenha(passwordEncoder.encode(requestDTO.getSenha()));
    return mapper.entityToDTO(repository.save(entity));
  }

  private void validaEmail(String email) {
    var emailExiste = repository.findByEmail(email).isPresent();
    if (emailExiste) {
      throw new ErrorBusinessException("Já exsite usuário com esse email");
    }
  }
}
