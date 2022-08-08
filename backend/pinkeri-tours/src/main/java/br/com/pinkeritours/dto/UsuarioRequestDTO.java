package br.com.pinkeritours.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class UsuarioRequestDTO {

    @NotBlank(message = "campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "campo email é obrigatório")
    @Email(message = "email inválido")
    private String email;

    @NotBlank(message = "campo telefone é obrigatório")
    @Size(min = 11, max = 11, message = "telefone inválido - revise a quantidade de números")
    private String telefone;

    @NotBlank(message = "campo senha é obrigatório")
    @Min(value = 8, message = "senha precisa ter no minimo 8 caracteres") // pesquisar validacao de senha - regex
    private String senha;

}
