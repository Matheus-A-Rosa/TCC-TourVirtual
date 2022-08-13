package br.com.pinkeritours.entity;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
