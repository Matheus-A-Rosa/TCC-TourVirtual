import React from 'react';
import Navbar from '../Navbar';
import Content from '../Content';
import Button from "../../Components/Button"
import EndPage from '../EndPage';
import List from '../List';
import ListPage from '../ListPage';
import Post from '../FormPage';

export default function Home() {
    return(
        <>
        <Navbar />
        <Post />
        {/* <Content />
        <EndPage /> */}
        </>
    );
}