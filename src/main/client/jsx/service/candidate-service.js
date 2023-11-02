// const axios = require('axios').default;
import api from "./api"

const CandidateService = {

    addCandidate: async (name, position, area) => {
        return await api.post(`/candidate?name=${name}&position=${position}&area=${area}`)
            .then(response => {return response})
    },

    getCandidates : async (selectedFilters) => {
        const {phase, area} = selectedFilters
        return await api.get(`/candidate/search?phaseValue=${phase}&areaValue=${area}`)
            .then(response => {return response.data})
    },

    getCandidateById : async (id) => {
        return await api.get(`/candidate/${id}`)
            .then(response => {return response.data})
    }

}

export default CandidateService