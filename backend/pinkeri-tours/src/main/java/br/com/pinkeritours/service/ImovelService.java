package br.com.pinkeritours.service;

import br.com.pinkeritours.dto.EnderecoDTO;
import br.com.pinkeritours.dto.ImovelRequestDTO;
import br.com.pinkeritours.dto.ImovelResponseDTO;
import br.com.pinkeritours.entity.ImovelEntity;
import br.com.pinkeritours.entity.UsuarioEntity;
import br.com.pinkeritours.enumeration.StatusEnum;
import br.com.pinkeritours.mapper.ImovelMapper;
import br.com.pinkeritours.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ImovelService {

    private final ImovelMapper mapper;
    private final ImovelRepository repository;

    public ImovelResponseDTO salvar(ImovelRequestDTO requestDTO) {
        ImovelEntity entity = mapper.requestDtoToEntity(requestDTO);
        entity.setAtivado(false);
        entity.setTitulo(criarTitulo(requestDTO, requestDTO.getEnderecoDTO()));
        entity.setUsuario(UsuarioEntity.builder().id(requestDTO.getIdUsuario()).build());
        return mapper.entityToResponseDTO(repository.save(entity));
    }

    private String criarTitulo(ImovelRequestDTO imovel, EnderecoDTO endereco) {
        String status = StatusEnum.findByStatus(imovel.getStatus()).get().getDescricao();
        return String.format("%s %s: %s - %s, %s", status, imovel.getTipo(), endereco.getBairro(), endereco.getCidade(), endereco.getUf());
    }
}
