// const axios = require('axios').default;
import api from "./api"

const CandidateService = {

    addCandidate: async (candidateData) => {
        // return axios.post('http://localhost:8080/api/candidate', candidateData)
        return api.post('/candidate', candidateData)
    },

    getCandidates : async (selectedFilters) => {
        const {phase, area} = selectedFilters
        return api.get(`http://localhost:8080/api/candidate/search?phaseValue=${phase}&areaValue=${area}`)
    },

    getCandidateById : async (id) => {
        const url = `http://localhost:8080/api/candidate/${id}`
        const response = await fetch(url)
        const data = await response.json()
        return data
    }

}

export default CandidateService