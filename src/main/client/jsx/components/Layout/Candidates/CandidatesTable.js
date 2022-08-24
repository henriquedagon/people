import React from "react";
import CandidateItem from "./CandidateItem";
import classes from "./CandidatesTable.module.css"

const CandidatesTable = props => {
    return (
        <table className={classes.table}>
            <thead>
                <tr>
                    <th>{props.descriptions.id}</th>
                    <th>{props.descriptions.name}</th>
                    <th>{props.descriptions.phase}</th>
                    <th>{props.descriptions.position}</th>
                    <th>{props.descriptions.area}</th>
                </tr>
                </thead>
                <tbody>
                    {props.candidates.map((candidate) => 
                    <CandidateItem
                        key={candidate.id}
                        {...candidate}
                        onEditCandidate={props.onEditCandidate}
                        />
                    )}
                </tbody>
        </table>
    )
}

export default CandidatesTable