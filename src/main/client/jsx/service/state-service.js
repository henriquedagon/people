// const axios = require('axios').default;
import api from "./api"

const StateService = {

    getStateById: async (id) => {
        return await api.post(`/state/${id}`)
            .then(response => {return response})
    },

    getAllStates : async () => {
        return await api.get(`/state/`)
            .then(response => {return response.data})
    },

}

export default StateService