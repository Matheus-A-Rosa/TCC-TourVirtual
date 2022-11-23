import React from 'react';
import { render } from "react-dom";
import {
  Routes,
  Route,
} from "react-router-dom";
import Cadastro from './pages/Cadastro';
import Home from './pages/Home';
import Imovel from './pages/Imoveis';

export default function MainRoutes() {
  return(
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="imovel" element={<Imovel />} />
      <Route path="cadastro" element={<Cadastro />} />
    </Routes>
  );
}