import React, { Component } from 'react';
import api from '../../services/api.js';
import Navbar from '../Navbar';
type EnderecoProps = {
    cep: string,
    rua: string,
    bairro: string,
    cidade: string,
    uf: string,
    complemento: string,
}
type StateProps = {
    id_usuario: number,
    status: string,
    tipo: string,
    area_total: number,
    valor: number,
    quantidade_quarto: number,
    quantidade_banheiro: number,
    quantidade_vaga_garagem: number,
    descricao: string,
    url_imagem: string,
    endereco: EnderecoProps
}

export default class Cadastro extends React.Component<{}, StateProps> {
    constructor(props: any) {
        super(props);
        this.state = {
            id_usuario: 1,
            status: "venda",
            tipo: "casa",
            area_total: 200.0,
            valor: 10.0,
            quantidade_quarto: 4,
            quantidade_banheiro: 2,
            quantidade_vaga_garagem: 1,
            descricao: "ap localizado no centro de floripa o coração da cidade",
            url_imagem: "https://queroficarrico.com/blog/wp-content/uploads/2017/06/como_investir_em_imoveis.jpg",
            endereco: {
                cep: "88015600",
                rua: "Rua Boaventura Antonio Pereira",
                bairro: "Vargem",
                cidade: "Florianópolis",
                uf: "SC",
                complemento: "número 900"
            }
        }
            ;

        this.handleChangeStatus = this.handleChangeStatus.bind(this);
        this.handleChangeTipo = this.handleChangeTipo.bind(this);
        this.handleChangeAreaTotal = this.handleChangeAreaTotal.bind(this);
        this.handleChangeValor = this.handleChangeValor.bind(this);
        this.handleChangeQuantidadeQuarto = this.handleChangeQuantidadeQuarto.bind(this);
        this.handleChangeQuantidadeBanheiro = this.handleChangeQuantidadeBanheiro.bind(this);
        this.handleChangeQuantidadeVagaGaragem = this.handleChangeQuantidadeVagaGaragem.bind(this);
        this.handleChangeDescricao = this.handleChangeDescricao.bind(this);
        this.handleChangeUrlImagem = this.handleChangeUrlImagem.bind(this);
        this.handleChangeEnderecoCep = this.handleChangeEnderecoCep.bind(this);
        this.handleChangeEnderecoRua = this.handleChangeEnderecoRua.bind(this);
        this.handleChangeEnderecoBairro = this.handleChangeEnderecoBairro.bind(this);
        this.handleChangeEnderecoCidade = this.handleChangeEnderecoCidade.bind(this);
        this.handleChangeEnderecoUf = this.handleChangeEnderecoUf.bind(this);
        this.handleChangeEnderecoComplemento = this.handleChangeEnderecoComplemento.bind(this);

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChangeStatus(event: any) {
        this.setState({ ...this.state, status: event.target.value });
    }

    handleChangeTipo(event: any) {
        this.setState({ ...this.state, tipo: event.target.value });
    }

    handleChangeAreaTotal(event: any) {
        this.setState({ ...this.state, area_total: event.target.value });
    }

    handleChangeValor(event: any) {
        this.setState({ ...this.state, valor: event.target.value });
    }

    handleChangeQuantidadeQuarto(event: any) {
        this.setState({ ...this.state, quantidade_quarto: event.target.value });
    }

    handleChangeQuantidadeBanheiro(event: any) {
        this.setState({ ...this.state, quantidade_banheiro: event.target.value });
    }

    handleChangeQuantidadeVagaGaragem(event: any) {
        this.setState({ ...this.state, quantidade_vaga_garagem: event.target.value });
    }

    handleChangeDescricao(event: any) {
        this.setState({ ...this.state, descricao: event.target.value });
    }

    handleChangeUrlImagem(event: any) {
        this.setState({ ...this.state, url_imagem: event.target.value });
    }

    handleChangeEnderecoCep(event: any) {
        this.setState({ ...this.state, endereco: { ...this.state.endereco, cep: event.target.value } });
    }

    handleChangeEnderecoRua(event: any) {
        this.setState({ ...this.state, endereco: { ...this.state.endereco, rua: event.target.value } });
    }

    handleChangeEnderecoBairro(event: any) {
        this.setState({ ...this.state, endereco: { ...this.state.endereco, bairro: event.target.value } });
    }

    handleChangeEnderecoCidade(event: any) {
        this.setState({ ...this.state, endereco: { ...this.state.endereco, cidade: event.target.value } });
    }

    handleChangeEnderecoUf(event: any) {
        this.setState({ ...this.state, endereco: { ...this.state.endereco, uf: event.target.value } });
    }

    handleChangeEnderecoComplemento(event: any) {
        this.setState({ ...this.state, endereco: { ...this.state.endereco, complemento: event.target.value } });
    }

    handleSubmit(event: any) {
        event.preventDefault()
        api.post("/", this.state)
            .then(result => {
                console.log(result)
            }).catch(error => {
                console.log(error)
            })

    }

    render() {
        return (
            <>
                <Navbar />
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label>
                            Status do Imóvel:
                            <input type="text" value={this.state.status} onChange={this.handleChangeStatus} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Tipo do Imóvel:
                            <input type="text" value={this.state.tipo} onChange={this.handleChangeTipo} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Valor do Imóvel:
                            <input type="text" value={this.state.valor} onChange={this.handleChangeValor} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Área total do Imóvel:
                            <input type="text" value={this.state.area_total} onChange={this.handleChangeAreaTotal} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Quantidade de quartos do Imóvel:
                            <input type="text" value={this.state.quantidade_quarto} onChange={this.handleChangeQuantidadeQuarto} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Quantidade de banheiros do Imóvel:
                            <input type="text" value={this.state.quantidade_banheiro} onChange={this.handleChangeQuantidadeBanheiro} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Quantidade de vagas na garagem do Imóvel:
                            <input type="text" value={this.state.quantidade_vaga_garagem} onChange={this.handleChangeQuantidadeVagaGaragem} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Descrição do Imóvel:
                            <input type="text" value={this.state.descricao} onChange={this.handleChangeDescricao} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Url da imagem do Imóvel:
                            <input type="text" value={this.state.url_imagem} onChange={this.handleChangeUrlImagem} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Cep do Imóvel:
                            <input type="text" value={this.state.endereco.cep} onChange={this.handleChangeEnderecoCep} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Rua do Imóvel:
                            <input type="text" value={this.state.endereco.rua} onChange={this.handleChangeEnderecoRua} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Bairro do Imóvel:
                            <input type="text" value={this.state.endereco.bairro} onChange={this.handleChangeEnderecoBairro} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Cidade do Imóvel:
                            <input type="text" value={this.state.endereco.cidade} onChange={this.handleChangeEnderecoCidade} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Uf do Imóvel:
                            <input type="text" value={this.state.endereco.uf} onChange={this.handleChangeEnderecoUf} />
                        </label>
                    </div>
                    <div>
                        <label>
                            Complemento do Imóvel:
                            <input type="text" value={this.state.endereco.complemento} onChange={this.handleChangeEnderecoComplemento} />
                        </label>
                    </div>
                    <input type="submit" value="Enviar" />
                </form>
            </>

        );
    }
}