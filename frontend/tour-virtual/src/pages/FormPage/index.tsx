import React from 'react';
import axios from 'axios';

import { useNavigate } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from "yup";

import './styles.css'

const validationPost = yup.object().shape({
    id_usuario:  yup.number().required("O título é obrigatório"),
    status:  yup.string().required("O título é obrigatório"),
    tipo:  yup.string().required("O título é obrigatório"),
    area_total:  yup.number().required("O título é obrigatório"),
    quantidade_quarto:  yup.number().required("O título é obrigatório"),
    quantidade_banheiro:  yup.number().required("O título é obrigatório"),
    quantidade_vaga_garagem:  yup.number().required("O título é obrigatório"),
    descricao:  yup.string().required("O título é obrigatório"),
    cep:  yup.string().required("O título é obrigatório"),
    rua:  yup.string().required("O título é obrigatório"),
    bairro:  yup.string().required("O título é obrigatório"),
    cidade:  yup.string().required("O título é obrigatório"),
    uf:  yup.string().required("O título é obrigatório"),
    complemento:  yup.string().required("O título é obrigatório")

})

function Post() {

    let navigate = useNavigate()

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(validationPost)
    })

    const addPost = (data: any) => axios.post("http://localhost:8080/v1/imoveis", data)
    .then(() => {
        console.log("Deu tudo certo")
        navigate('/')
    })
    .catch(() => {
        console.log("DEU ERRADO")
    })

    return(
        <div>
            <main>

                <div className="card-post" >

                    <h1>Criar postagem</h1>
                    <div className="line-post" ></div>

                    <div className="card-body-post" >

                        <form onSubmit={handleSubmit(addPost)} >

                            <div className="fields" >
                                <label>Id_usuario</label>
                                <input type="text" data-name="id_usuario" {...register("id_usuario")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>status</label>
                                <input type="text" data-name="status" {...register("status")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>tipo</label>
                                <input type="text" data-name="tipo" {...register("tipo")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>area_total</label>
                                <input type="text" data-name="area_total" {...register("area_total")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>valor</label>
                                <input type="text" data-name="valor" {...register("valor")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>quantidade_quarto</label>
                                <input type="text" data-name="quantidade_quarto" {...register("quantidade_quarto")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>quantidade_banheiro</label>
                                <input type="text" data-name="quantidade_banheiro" {...register("quantidade_banheiro")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>quantidade_vaga_garagem</label>
                                <input type="text" data-name="quantidade_vaga_garagem" {...register("quantidade_vaga_garagem")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>Descrição</label>
                                <textarea data-type="text" data-name="discricao" {...register("descricao")} ></textarea>
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>cep</label>
                                <input type="text" data-name="cep" {...register("cep")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>rua</label>
                                <input type="text" data-name="rua" {...register("rua")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>bairro</label>
                                <input type="text" data-name="bairro" {...register("bairro")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>cidade</label>
                                <input type="text" data-name="cidade" {...register("cidade")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>uf</label>
                                <input type="text" data-name="uf" {...register("uf")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="fields" >
                                <label>complemento</label>
                                <input type="text" data-name="complemento" {...register("complemento")} />
                                <p className="error-message"></p>
                            </div>

                            <div className="btn-post" >
                                <button type="submit" >Enviar</button>
                            </div>

                        </form>

                    </div>

                </div>

            </main>

        </div>
    )
}

export default Post