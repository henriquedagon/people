import React, { useState } from "react";
import CandidatesTable from "./CandidatesTable";
import classes from "./Candidates.module.css"
import CandidatesForm from "./CandidatesForm";
import Button from "../../UI/Button";
import AddCandidateModal from "./AddCandidateModal";

const candidatesDescription = {
    id: 'Id',
    name: 'Name',
    area: 'Area',
    position: 'Position',
    phase: 'Phase'
}

const Candidates = props => {
    const [candidates, setCandidates] = useState([])
    const [isLoading, setIsLoading] = useState(false)
    const [showAddCandidateModal, setShowAddCandidateModal] = useState(false)

    async function fetchCandidatesHandler (selectedFilters) {
        setIsLoading(true)
        const {phase, area} = selectedFilters
        const url = `http://localhost:8080/api/candidate/all/search?phase=${phase}&area=${area}`
        const response = await fetch(url)
        const data = await response.json()
        setCandidates(data)
        setIsLoading(false)
    }

    const toggleAddCandidateModalHandler = () => {
        setShowAddCandidateModal(prevState => !prevState)
    }

    return (
        <section className={classes.candidates}>
            {showAddCandidateModal && <AddCandidateModal onClose={toggleAddCandidateModalHandler}/>}
            <div className={classes.edition}>
                <Button label="Add" onClick={toggleAddCandidateModalHandler}/>
            </div>
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