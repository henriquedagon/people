import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import classes from "./Candidate.module.css"
import CandidateService from "../service/candidate-service";
import DataRow from "../components/UI/DataRow";
import DataContainer from "../components/UI/Container/DataContainer";
import PanelContainer from "../components/UI/Container/PanelContainer";

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
                field='phase'
                value={candidateData?.phase?.name}
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
                field='RH Phase'
                value='★★★'
            />
            <DataRow
                field='Technical Phase'
                value='★★★★'
            />
            <DataRow
                field='Director Phase'
                value='★★★★★'
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