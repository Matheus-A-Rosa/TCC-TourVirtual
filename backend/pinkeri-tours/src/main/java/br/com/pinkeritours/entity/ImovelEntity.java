package br.com.pinkeritours.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "tb_imovel")
public class ImovelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String tipo;
    @Column(name = "area_total")
    private String areaTotal;
    private Double valor;
    @Column(name = "qtde_quarto")
    private String quantidadeQuartos;
    @Column(name = "qtde_banheiro")
    private String quantidadeBanheiros;
    @Column(name = "qtde_vaga_garagem")
    private String quantidadeVagasGaragem;
    private String descricao;
    private String status;
    private Boolean ativado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
    @OneToOne(cascade = {PERSIST, REMOVE, MERGE})
    @JoinColumn(name = "id_endereco")
    private EnderecoEntity endereco;


}
