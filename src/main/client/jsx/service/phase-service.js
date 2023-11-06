// const axios = require('axios').default;
import api from "./api"

const PhaseService = {

    getPhaseById: async (id) => {
        return await api.post(`/phase/${id}`)
            .then(response => {return response})
    },

    getAllPhases : async () => {
        return await api.get(`/phase/`)
            .then(response => {return response.data})
    },

}

export default PhaseService