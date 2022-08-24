import React, { useState } from "react";
import CandidatesTable from "./CandidatesTable";
import classes from "./Candidates.module.css"
import CandidatesForm from "./CandidatesForm";
import Button from "../../UI/Button";
import AddCandidateModal from "./AddCandidateModal";
import EditCandidateModal from "./EditCandidateModal";

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
    const [candidateToEdit, setCandidateToEdit] = useState({})
    const [showAddCandidateModal, setShowAddCandidateModal] = useState(false)
    const [showEditCandidateModal, setShowEditCandidateModal] = useState(false)

    async function fetchCandidatesHandler (selectedFilters) {
        setIsLoading(true)
        const {phase, area} = selectedFilters
        const url = `http://localhost:8080/api/candidate/all/search?phaseValue=${phase}&areaValue=${area}`
        const response = await fetch(url)
        const data = await response.json()
        setCandidates(data)
        setIsLoading(false)
    }

    async function fetchCandidateById (id) {
        const url = `http://localhost:8080/api/candidate/${id}`
        const response = await fetch(url)
        const data = await response.json()
        setCandidateToEdit(data)
        console.log(data)
    }

    const toggleAddCandidateModalHandler = () => {
        setShowAddCandidateModal(prevState => !prevState)
    }

    const toggleEditCandidateModalHandler = () => {
        setShowEditCandidateModal(prevState => !prevState)
    }

    const editCandidateHandler = (id) => {
        toggleEditCandidateModalHandler()
        fetchCandidateById(id)
    }

    return (
        <section className={classes.candidates}>
            {showAddCandidateModal && <AddCandidateModal onClose={toggleAddCandidateModalHandler}/>}
            {showEditCandidateModal && <EditCandidateModal 
                                            onClose={toggleEditCandidateModalHandler}
                                            candidate={candidateToEdit}
                                        />
                }
            <div className={classes.edition}>
                <Button label="Add" onClick={toggleAddCandidateModalHandler}/>
            </div>
            <CandidatesForm onChangeFilters={fetchCandidatesHandler}/>
            {!isLoading && <CandidatesTable 
                candidates={candidates}
                descriptions={candidatesDescription} 
                onEditCandidate={editCandidateHandler}
                />}
            {isLoading && <p>Loading...</p>}
        </section>
    )
}

export default Candidates