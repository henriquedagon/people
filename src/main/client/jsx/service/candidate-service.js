// const axios = require('axios').default;
import api from "./api"

const CandidateService = {

    addCandidate: async (candidateData) => {
        // return axios.post('http://localhost:8080/api/candidate', candidateData)
        return api.post('/candidate', candidateData)
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