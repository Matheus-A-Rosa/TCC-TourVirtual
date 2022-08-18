package br.com.pinkeritours.service;

import br.com.pinkeritours.dto.EnderecoDTO;
import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.entity.ImovelEntity;
import br.com.pinkeritours.entity.UsuarioEntity;
import br.com.pinkeritours.enumeration.StatusEnum;
import br.com.pinkeritours.enumeration.TipoImovelEnum;
import br.com.pinkeritours.exception.ErrorBusinessException;
import br.com.pinkeritours.exception.NotFoundException;
import br.com.pinkeritours.mapper.ImovelMapper;
import br.com.pinkeritours.repository.ImovelRepository;
import br.com.pinkeritours.repository.UsuarioRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.WordUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ImovelService {

  private final ImovelMapper mapper;
  private final ImovelRepository repository;
  private final UsuarioRepository usuarioRepository;

  public Page<ImovelResponseDTO> listar(Pageable pageable) {
    return mapper.toPageResponseDto(repository.listar(pageable));
  }

  public ImovelResponseDTO buscarPorId(Long id) {
    return mapper.entityToResponseDTO(repository.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Imóvel %d não encontrado", id))));
  }

  public Page<ImovelResponseDTO> buscar(Pageable pageable, String tipo, String status) {
    return mapper.toPageResponseDto(
        repository.buscarPorTipoImovelStatus(pageable,
            validaTipoImovel(tipo),
            validaStatus(status).name())
    );
  }

  public List<ImovelResponseDTO> buscar(String tipo, String status) {
    return mapper.entityListToResponseDTO(
        repository.find(validaTipoImovel(tipo), validaStatus(status).name(), "", ""));
  }

  public ImovelResponseDTO salvar(ImovelRequestDTO requestDTO) {
    ImovelEntity entity = mapper.requestDtoToEntity(requestDTO);
    entity.setAtivado(false);
    entity.setTipo(validaTipoImovel(requestDTO.getTipo()));
    entity.setTitulo(criarTitulo(requestDTO, requestDTO.getEndereco()));
    entity.setUsuario(validaUsuario(requestDTO.getIdUsuario()));
    return mapper.entityToResponseDTO(repository.save(entity));
  }

  private String validaTipoImovel(String tipoImovel) {
    return TipoImovelEnum.findByTipoImovel(tipoImovel)
        .orElseThrow(() -> new ErrorBusinessException(
            "Tipo imóvel inválido, favor informar se é casa ou apartamento"))
        .name();
  }

  private String criarTitulo(ImovelRequestDTO imovel, EnderecoDTO endereco) {
    String status = validaStatus(imovel.getStatus()).getDescricao();
    String titulo = String.format("%s %s: %s - %s, %s", status, imovel.getTipo(),
        endereco.getBairro(), endereco.getCidade(), endereco.getUf().toUpperCase());
    return WordUtils.capitalize(titulo);
  }

  private StatusEnum validaStatus(String status) {
    return StatusEnum.findByStatus(status)
        .orElseThrow(() -> new ErrorBusinessException(
            "Status do imóvel inválido, favor informar se está a venda ou para alugar"));
  }

  private UsuarioEntity validaUsuario(Long idUsuario) {
    return usuarioRepository.findById(idUsuario)
        .orElseThrow(
            () -> new NotFoundException(String.format("Usuário %d não encontrado", idUsuario)));
  }
}
