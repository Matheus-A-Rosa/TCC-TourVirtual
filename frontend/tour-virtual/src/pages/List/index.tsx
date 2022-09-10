import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import './styles.css'


export default function List() {
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
        </Row>
      </Container>
    </>

  );
}