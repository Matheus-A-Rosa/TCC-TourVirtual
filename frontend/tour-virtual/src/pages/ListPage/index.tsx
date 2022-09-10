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
            params: {
                tipo: 'casa',
                status: 'venda'
            }
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
                        <div className='alinhamento'>
                        <Image className='image-style' src="https://scontent.ffln1-1.fna.fbcdn.net/v/t1.6435-9/173278965_3489520411149917_7203727049437039434_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_eui2=AeHnBoF26YGmMWnGTSzsqHBIyAIrfbpdcvjIAit9ul1y-NbxxV0zjqOePJXYe4k09SQlnA9OsTEnV3_U2nf7DfYc&_nc_ohc=OzYLjFSab2wAX_DVe-4&_nc_ht=scontent.ffln1-1.fna&oh=00_AT_BTnilAAsVNMHPIXle5pbcp6Is6kvspBkOphT0iEy_zA&oe=6340AFC5" />
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