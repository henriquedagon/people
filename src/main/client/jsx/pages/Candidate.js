import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import classes from "./Candidate.module.css"
import CandidateService from "../service/candidate-service";
import DataRow from "../components/UI/DataRow";
import DataContainer from "../components/UI/DataContainer";

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


    return (
        <React.Fragment>
            <div className={classes.header}>Candidate #{candidateData?.id}</div>
            {isLoading && <p>Loading...</p>}
            {!isLoading && basicDataTable}
        </React.Fragment>
    )
}

export default Candidate