import axios from "axios";

const api = axios.create({
    baseURL: "http://localhost:8080/api",
    responseType: "json"
});

export default api