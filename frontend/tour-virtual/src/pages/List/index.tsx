import React from 'react';
import Container from 'react-bootstrap/Container';
import { useNavigate } from 'react-router-dom';
import './styles.css'


export default function List() {
  const navigate = useNavigate()
  const goToForm = () => {
    navigate("/cadastro")
  }
  return (
    <>
      <Container className='container'>
            <button onClick={goToForm}>Cadastrar Imóvel</button>
      </Container>
    </>

  );
}