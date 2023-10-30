import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import classes from "./Candidate.module.css"

const Candidate = () => {
    const params = useParams()
    const [candidateData, setCandidateData] = useState({})
    const [isLoading, setIsLoading] = useState(false)


    useEffect(() => {
        fetchCandidateById(params.candidateId)
    }, [params.candidateId])

    async function fetchCandidateById (id) {
        setIsLoading(true)
        const url = `http://localhost:8080/api/candidate/${id}`
        const response = await fetch(url)
        const data = await response.json()
        setCandidateData(data)
        setIsLoading(false)
    }

    const table = 
        <table className={classes['candidate-table']}>
            <thead>
                <tr><th colSpan="2">Candidate #{candidateData.id}</th></tr>
            </thead>
            <tbody>
                <tr><td>name</td><td>{candidateData?.name}</td></tr>
                <tr><td>position</td><td>{candidateData?.position}</td></tr>
                <tr><td>phase</td><td>{candidateData?.phase?.name}</td></tr>
                <tr><td>area</td><td>{candidateData?.area?.name}</td></tr>
            </tbody>
        </table>


    return (
        <React.Fragment>
            {isLoading && <p>Loading...</p>}
            {!isLoading && table}
        </React.Fragment>
    )
}

export default Candidate