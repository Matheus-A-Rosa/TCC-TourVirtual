import axios from 'axios';

const api = axios.create({
    baseURL: 'http://18.209.60.81:8080/v1/imoveis',
    // baseURL: 'http://localhost:8080/v1/imoveis',
})


export default api;