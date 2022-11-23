import axios from 'axios';
import React, { useEffect, useState } from 'react';
import api from '../../services/api.js';
import Card from 'react-bootstrap/Card';
import Image from 'react-bootstrap/Image';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Button from 'react-bootstrap/Button';

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

<Container className='container'>
        <Row>
          <Col>
            <Form.Select className='form' aria-label="Default select example">
              <option>Selecione o tipo de aquisição</option>
              <option value="1">Alugar</option>
              <option value="2">Comprar</option>
            </Form.Select>
          </Col>
          <Col>
            <Form.Select className='form' aria-label="Default select example">
              <option>Selecione o tipo de imóvel</option>
              <option value="1">Casa</option>
              <option value="2">Apartamento</option>
            </Form.Select>
          </Col>
          <Col>
            <InputGroup  className="mb-3  start">
              <Form.Control className='barra-pesquisa'
                placeholder="Digite uma rua, bairro ou cidade"
                aria-label="Tipo de local"
                aria-describedby="basic-addon1"
              />
            </InputGroup>
          </Col>
          <Col>
          <Button as="input" type="submit" value="Submit" />{' '}
          </Col>
        </Row>
      </Container>



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