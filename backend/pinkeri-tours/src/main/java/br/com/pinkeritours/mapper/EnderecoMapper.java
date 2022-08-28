package br.com.pinkeritours.mapper;

import br.com.pinkeritours.dto.EnderecoDTO;
import br.com.pinkeritours.entity.EnderecoEntity;
import java.text.Normalizer;
import java.util.regex.Pattern;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

  public EnderecoEntity dtoToEntity(EnderecoDTO enderecoDTO) {
    return EnderecoEntity.builder()
        .cep(enderecoDTO.getCep())
        .rua(removerAcentoString(enderecoDTO.getRua()).toUpperCase())
        .bairro(removerAcentoString(enderecoDTO.getBairro()).toUpperCase())
        .cidade(removerAcentoString(enderecoDTO.getCidade()).toUpperCase())
        .uf(removerAcentoString(enderecoDTO.getUf()).toUpperCase())
        .complemento(removerAcentoString(enderecoDTO.getComplemento()).toUpperCase())
        .build();
  }

  public EnderecoDTO entityToDTO(EnderecoEntity enderecoEntity) {
    return EnderecoDTO.builder()
        .cep(enderecoEntity.getCep())
        .rua(removerAcentoString(enderecoEntity.getRua()).toUpperCase())
        .bairro(removerAcentoString(enderecoEntity.getBairro()).toUpperCase())
        .cidade(removerAcentoString(enderecoEntity.getCidade()).toUpperCase())
        .uf(removerAcentoString(enderecoEntity.getUf()).toUpperCase())
        .complemento(removerAcentoString(enderecoEntity.getComplemento()).toUpperCase())
        .build();
  }

  @Named("removerAcentoString")
  public static String removerAcentoString(String str) {
    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return pattern.matcher(nfdNormalizedString).replaceAll("");
  }

}
