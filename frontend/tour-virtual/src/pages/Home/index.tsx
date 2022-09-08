import React from 'react';
import Navbar from '../Navbar';
import Content from '../Content';
import Button from "../../Components/Button"
import EndPage from '../EndPage';
import List from '../List';

export default function Home() {
    return(
        <>
        <Navbar />
        {/* <Content />
        <EndPage /> */}
        <List />
        </>
    );
}