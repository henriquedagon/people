import React, { useState } from "react";
import CandidatesTable from "./CandidatesTable";
import classes from "./Candidates.module.css"
import CandidatesForm from "./CandidatesForm";

const candidatesDescription = {
    id: 'Id',
    name: 'Name',
    area: 'Area',
    position: 'Position',
    phase: 'Phase'
}

const DUMMY_CANDIDATES = [
    {
        id: 0,
        name: 'Tadeu Kwiatkowski Ribeiro',
        area: 'data',
        position: 'Data Analyst Senior',
        phase: 'application'
    },
    {
        id: 1,
        name: 'Michel Morais Ferreira',
        area: 'tech',
        position: 'Developer Senior',
        phase: 'declined'
    },
    {
        id: 2,
        name: 'José Fernandes Almeida Junior',
        area: 'risk',
        position: 'Risk Analyst Mid-level',
        phase: 'approved'
    },
    {
        id: 3,
        name: 'Debora Dias de Alexandria Gonçalves',
        area: 'legal',
        position: 'Lawyer',
        phase: 'application'
    }
]

const Candidates = props => {
    const [candidates, setCandidates] = useState([])
    const [isLoading, setIsLoading] = useState(false)

    async function fetchCandidatesHandler (selectedFilters) {
        setIsLoading(true)
        const {phase, area} = selectedFilters
        const url = `http://localhost:8080/api/candidate/all/search?phase=${phase}&area=${area}`
        const response = await fetch(url)
        const data = await response.json()
        setCandidates(data)
        setIsLoading(false)
    }

    return (
        <section className={classes.candidates}>
            <CandidatesForm onChangeFilters={fetchCandidatesHandler}/>
            {!isLoading && <CandidatesTable 
                candidates={candidates}
                descriptions={candidatesDescription} 
            />}
            {isLoading && <p>Loading...</p>}
        </section>
    )
}

export default Candidates