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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ImovelService {

    private final ImovelMapper mapper;
    private final ImovelRepository repository;
    private final UsuarioRepository usuarioRepository;

    public ImovelResponseDTO salvar(ImovelRequestDTO requestDTO) {
        ImovelEntity entity = mapper.requestDtoToEntity(requestDTO);
        entity.setAtivado(false);
        entity.setTipo(validaTipoImovel(requestDTO.getTipo()));
        entity.setTitulo(criarTitulo(requestDTO, requestDTO.getEndereco()));
        entity.setUsuario(getUsuario(requestDTO));
        return mapper.entityToResponseDTO(repository.save(entity));
    }

    private UsuarioEntity getUsuario(ImovelRequestDTO requestDTO) {
        Long idUsuario = requestDTO.getIdUsuario();
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new NotFoundException(String.format("Usuário %d não encontrado", idUsuario)));
    }

    private String validaTipoImovel(String tipoImovel) {
        return TipoImovelEnum.findByTipoImovel(tipoImovel)
                .orElseThrow(() -> new ErrorBusinessException("Tipo imóvel inválido, favor informar se é casa ou apartamento"))
                .name();
    }

    private String criarTitulo(ImovelRequestDTO imovel, EnderecoDTO endereco) {
        String status = StatusEnum.findByStatus(imovel.getStatus())
                .orElseThrow(() -> new ErrorBusinessException("Status do imóvel inválido, favor informar se está a venda ou para alugar"))
                .getDescricao();
        return String.format("%s %s: %s - %s, %s", status, imovel.getTipo(), endereco.getBairro(), endereco.getCidade(), endereco.getUf());
    }
}
