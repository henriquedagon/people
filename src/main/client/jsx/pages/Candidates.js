import React, { useState } from "react";
import CandidatesTable from "../components/Layout/Candidates/CandidatesTable";
import classes from "./Candidates.module.css"
import CandidatesForm from "../components/Layout/Candidates/CandidatesForm";
import Button from "../components/UI/Button";
import AddCandidateModal from "../components/Layout/Candidates/AddCandidateModal";
import EditCandidateModal from "../components/Layout/Candidates/EditCandidateModal";

import CandidateService from "../service/candidate-service"

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
        const data = await CandidateService.getCandidates(selectedFilters)
        setCandidates(data)
        setIsLoading(false)
    }

    async function fetchCandidateById (id) {
        const data = await CandidateService.getCandidateById(id)
        setCandidateToEdit(data)
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
            <div className={classes['add-button']}>
                <Button label="Add" onClick={toggleAddCandidateModalHandler}/>
            </div>
            <CandidatesForm className={classes.wrapper} onChangeFilters={fetchCandidatesHandler}/>
            {!isLoading && <CandidatesTable className={classes.wrapper}
                candidates={candidates}
                descriptions={candidatesDescription} 
                onEditCandidate={editCandidateHandler}
                />}
            {isLoading && <p>Loading...</p>}
        </section>
    )
}

export default Candidates