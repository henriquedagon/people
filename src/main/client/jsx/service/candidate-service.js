
const CandidateService = {

    addCandidate: async (candidateData) => {
        const response = await fetch('http://localhost:8080/api/candidate', {
            method: 'POST', 
            body: JSON.stringify(candidateData), 
            headers: {'Content-Type': 'application/json'
        }})
        const data = await response.json()
        return data
    },

    getCandidates : async (selectedFilters) => {
        const {phase, area} = selectedFilters
        const url = `http://localhost:8080/api/candidate/all/search?phaseValue=${phase}&areaValue=${area}`
        const response = await fetch(url)
        const data = await response.json()
        return data
    },

    getCandidateById : async (id) => {
        const url = `http://localhost:8080/api/candidate/${id}`
        const response = await fetch(url)
        const data = await response.json()
        return data
    }

}

export default CandidateService