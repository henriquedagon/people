import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import classes from "./Candidate.module.css"
import CandidateService from "../service/candidate-service";
import DataRow from "../components/UI/DataRow";
import DataContainer from "../components/UI/Container/DataContainer";
import PanelContainer from "../components/UI/Container/PanelContainer";

import { stars } from "../functions/stars";

const Candidate = () => {
    const params = useParams()
    const [candidateData, setCandidateData] = useState({})
    const [isLoading, setIsLoading] = useState(false)


    useEffect(() => {
        fetchCandidateById(params.candidateId)
    }, [params.candidateId])


    async function fetchCandidateById (id) {
        setIsLoading(true)
        const data = await CandidateService.getCandidateById(id)
        setCandidateData(data)
        setIsLoading(false)
    }


    const basicDataTable = 
        <DataContainer>
            <DataRow
                field='name'
                value={candidateData?.name}
            />                
            <DataRow
                field='position'
                value={candidateData?.position}
            />                
            <DataRow
                field='state'
                value={candidateData?.state?.name}
            />                
            <DataRow
                field='area'
                value={candidateData?.area?.name}
            />                
        </DataContainer>

    // Score and action panel
    const scoreDataTable = 
        <DataContainer>
            <DataRow
                field='RH Score'
                value={stars(3)}
            />
            <DataRow
                field='Technical Score'
                value={stars(4)}
            />
            <DataRow
                field='Director Score'
                value={stars(5)}
            />
        </DataContainer>

    const actionTable = 
        <DataContainer>
            <DataRow
                field='Advance'
                value='=>'
            />
            <DataRow
                field='Approve'
                value='✓'
            />
            <DataRow
                field='Decline'
                value='X'
            />
        </DataContainer>

    return (
        <React.Fragment>
            <div className={classes.header}>Candidate #{candidateData?.id}</div>
            <PanelContainer>
                {isLoading && <p>Loading...</p>}
                {!isLoading && basicDataTable}
                {!isLoading && scoreDataTable}
                {!isLoading && actionTable}
            </PanelContainer>
        </React.Fragment>
    )
}

export default Candidate