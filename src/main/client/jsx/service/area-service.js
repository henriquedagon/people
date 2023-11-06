// const axios = require('axios').default;
import api from "./api"

const AreaService = {

    getAreaById: async (id) => {
        return await api.get(`/area/${id}`)
            .then(response => {
        return response})
    },

    getAllAreas : async () => {
        return await api.get(`/area/`)
            .then(response => {
        return response.data})
    },

}

export default AreaService