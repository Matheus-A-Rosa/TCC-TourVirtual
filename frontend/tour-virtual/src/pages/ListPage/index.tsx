import axios from 'axios';
import React, { useEffect, useState } from 'react';
import api from '../../services/api.js';
import Card from 'react-bootstrap/Card';
import Image from 'react-bootstrap/Image'
import './styles.css';

export default function ListPage() {


    const [infos, setInfos] = useState<any[]>([])


    useEffect(() => {
        api.get("/", {
            // params: {
            //     tipo: 'apartamento',
            //     status: 'venda'
            // }
        })
            .then(response => {
                console.log(response.data);
                setInfos(response.data);
            })

            .catch(() => {
                console.log("Erro na requisição de busca")
            });

    }, [])

    return (

        <>
            {infos.map((info, key) => {
                return (
                    <>
                        {/* <button onClick={test}>Mock</button> */}
                        <div className='alinhamento'>
                        <Image className='image-style' src={info.url_imagem} />
                        <Card className='card-style'>
                            <Card.Body>
                                <Card.Title>{info.endereco.rua + " /"} {info.endereco.complemento + " /"}
                                 {info.endereco.bairro + " /"} {info.endereco.cidade + " /"}
                                 {info.endereco.uf + " "}</Card.Title>
                                 <Card.Text className='title'>{info.titulo}</Card.Text>
                                 <Card.Text className='last-info'>{"R$ " + info.valor}</Card.Text>
                            </Card.Body>
                        </Card>
                        </div>
                    </>
                )
            })}
        </>
    );
}