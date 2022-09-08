import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { getEnvironmentData } from 'worker_threads';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';

export default function List() {
  return (
    <>
      <Container style={{ textAlign: 'center', background: 'pink' }}>
        <Row>
          <Col>
            <Form.Select aria-label="Default select example">
              <option>Selecione o tipo de aquisição</option>
              <option value="1">Alugar</option>
              <option value="2">Comprar</option>
            </Form.Select>
          </Col>
          <Col>
            <Form.Select aria-label="Default select example">
              <option>Selecione o tipo de imóvel</option>
              <option value="1">Casa</option>
              <option value="2">Apartamento</option>
            </Form.Select>
          </Col>
          <Col>
            <InputGroup className="mb-3">
              <Form.Control
                placeholder="Digite uma rua, baiiro ou cidade"
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