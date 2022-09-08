import React from 'react';
import "../EndPage/styles.css";
import ButtonInfo from '../../Components/ButtonInfo';

export default function EndPage() {
    return (
        <div className='container'>
            <div className='container-text'>
                <h1 className='color-one'>Venha ser nosso</h1>
                <h1 className='color-two'>Parceiro</h1>
                <p>Alinhados as tendencias do Mercado Pinkeri Tours visa inovar<br />
                    no ramo de venda e aluguel de imóveis, faça parte desse  <br />
                    sonho e venha nos fazer uma visitinha, quem sabe <br />
                    fazemos um tour especial para você.</p>
            </div>
            <div className='align-button'>
            <ButtonInfo />
            </div>
        </div>

    );
}