import React from "react";
import { useParams } from "react-router-dom";

const Candidate = () => {
    const params = useParams()

    return (
        <React.Fragment>
            <p>Candidate id: {params.candidateId}</p>
        </React.Fragment>
    )
}

export default Candidate